package com.example.demo;

import com.example.domain.Task;
import com.example.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository repository;

    @Test
    public void verifyAdd() {
        Task task = new Task("Spring", "Spring description");
        repository.save(task);
        Assert.assertTrue(repository.existsById(task.getId()));
    }

    @Test
    public void verifyUpdate() {
        List<Task> tasksToUpdate = repository.findByTitle("Spring2");
        tasksToUpdate.forEach(p -> p.setTitle("Hadoop"));
        repository.saveAll(tasksToUpdate);
    }

    @Test
    public void verifyDelete() {
        Optional<Task> task = repository.findById(1L);
        task.ifPresent(it -> repository.delete(it));
        Assert.assertFalse(repository.existsById(task.get().getId()));
    }

}
