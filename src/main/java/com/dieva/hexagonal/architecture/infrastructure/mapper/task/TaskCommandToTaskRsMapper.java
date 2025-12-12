package com.dieva.hexagonal.architecture.infrastructure.mapper.task;


import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.model.TaskId;
import com.dieva.hexagonal.architecture.infrastructure.mapper.GenericMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.task.TaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TaskCommandToTaskRsMapper extends GenericMapper<Task, TaskResponse> {

    @Named("mapToId")
    default Long mapToId(TaskId taskId) {
        return taskId != null ? taskId.getValue() : null;
    }
    @Override
    @Mapping(target = "id", source = "taskId", qualifiedByName = "mapToId")
    TaskResponse toEntity(Task dto);
}
