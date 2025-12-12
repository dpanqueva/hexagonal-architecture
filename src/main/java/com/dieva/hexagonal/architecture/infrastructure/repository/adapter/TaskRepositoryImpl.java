package com.dieva.hexagonal.architecture.infrastructure.repository.adapter;

import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.model.TaskId;
import com.dieva.hexagonal.architecture.domain.repository.port.TaskRepository;
import com.dieva.hexagonal.architecture.infrastructure.entity.TaskEntity;
import com.dieva.hexagonal.architecture.infrastructure.mapper.task.TaskMapper;
import com.dieva.hexagonal.architecture.infrastructure.repository.TaskEntityRepositoryJpa;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskEntityRepositoryJpa taskEntityRepositoryJpa;
    private final TaskMapper taskMapper;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = taskMapper.toEntity(task);
        return taskMapper.toDto(taskEntityRepositoryJpa.save(taskEntity));
    }

    @Override
    public List<Task> getAll() {
        return taskEntityRepositoryJpa.findAll()
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Override
    public Optional<Task> getById(TaskId id) {
        return taskEntityRepositoryJpa.findById(id.getValue())
                .map(taskMapper::toDto);
    }

    @Override
    public void delete(TaskId id) {
        taskEntityRepositoryJpa.deleteById(id.getValue());
    }
}
