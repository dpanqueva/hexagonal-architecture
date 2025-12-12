package com.dieva.hexagonal.architecture.infrastructure.mapper.task;

import com.dieva.hexagonal.architecture.application.usecase.task.create.CreateTaskCommand;
import com.dieva.hexagonal.architecture.infrastructure.mapper.GenericMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.task.TaskRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskRqToCommandMapper extends GenericMapper<TaskRequest, CreateTaskCommand> {
    @Override
    CreateTaskCommand toEntity(TaskRequest dto);
}
