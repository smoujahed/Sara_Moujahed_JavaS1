package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {
    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp(){
        List<Task> tasks = new ArrayList<>();
        for (Task t : tasks){
            taskerDao.deleteTask(t.getId());
        }
    }

    @Test
    public void addGetDeleteTask(){
        Task task = new Task();
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019, 8, 1));
        task.setDueDate(LocalDate.of(2019, 8, 5));
        task.setCategory("Category");

        task = taskerDao.createTask(task);

        Task task1 = taskerDao.getTask(task.getId());
        assertEquals(task,task1);

        taskerDao.deleteTask(task.getId());
        task1 = taskerDao.getTask(task.getId());
        assertNull(task1);
    }

    @Test
    public void updateTask(){
        Task task = new Task();
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019, 8, 1));
        task.setDueDate(LocalDate.of(2019, 8, 5));
        task.setCategory("Category");

        task = taskerDao.createTask(task);

        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019, 8, 1));
        task.setDueDate(LocalDate.of(2019, 8, 5));
        task.setCategory("Category");
        taskerDao.updateTask(task);

        Task task1 = taskerDao.getTask(task.getId());

        assertEquals(task1, task);
    }

    @Test
    public void getAllTasks(){
        Task task = new Task();
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019, 8, 1));
        task.setDueDate(LocalDate.of(2019, 8, 5));
        task.setCategory("Category");

        task = taskerDao.createTask(task);

        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019, 8, 1));
        task.setDueDate(LocalDate.of(2019, 8, 5));
        task.setCategory("Category");
        taskerDao.createTask(task);

        List<Task> taskList = taskerDao.getAllTasks();
        assertEquals(2, taskList.size());
    }
}
