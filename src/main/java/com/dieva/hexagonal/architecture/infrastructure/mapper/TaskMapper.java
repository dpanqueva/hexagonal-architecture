package com.dieva.hexagonal.architecture.infrastructure.mapper;

import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.model.TaskId;
import com.dieva.hexagonal.architecture.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface TaskMapper extends GenericMapper<Task, TaskEntity> {

    @Named("mapToId")
    default Long mapToId(TaskId taskId) {
        return taskId != null ? taskId.getValue() : null;
    }

    @Named("mapToTaskId")
    default TaskId mapToTaskId(Long id) {
        return id != null ? TaskId.of(id) : null;
    }

    @Override
    @Mapping(target = "id", source = "taskId", qualifiedByName = "mapToId")
    TaskEntity toEntity(Task dto);

    @Override
    @Mapping(target = "taskId", source = "id", qualifiedByName = "mapToTaskId")
    Task toDto(TaskEntity entity);

    @Override
    List<TaskEntity> toDto(List<Task> dtoList);

    @Override
    List<Task> toEntity(List<TaskEntity> entityList);

    @Override
    default Page<Task> toDto(Page<TaskEntity> entityPage) {
        return GenericMapper.super.toDto(entityPage);
    }

    @Override
    Set<Task> toDto(Set<TaskEntity> entityList);

}

