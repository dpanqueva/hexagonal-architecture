package com.dieva.hexagonal.architecture.infrastructure.mapper.task;

import com.dieva.hexagonal.architecture.application.usecase.task.edit.EditTaskCommand;
import com.dieva.hexagonal.architecture.infrastructure.mapper.GenericMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.task.TaskEditRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskRqEditToCommandMapper extends GenericMapper<TaskEditRequest, EditTaskCommand> {
    @Override
    EditTaskCommand toEntity(TaskEditRequest dto);
}
