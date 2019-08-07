package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {

    @InjectMocks
    TaskerServiceLayer serviceLayer;

    @Mock
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception{
        setUpTaskerDaoMock();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveFindTask(){
        TaskViewModel task = new TaskViewModel();
        task.setDescription("Descr");
        task.setCreateDate(LocalDate.of(2019, 07, 28));
        task.setDueDate(LocalDate.of(2019, 07, 31));
        task.setCategory("Cat");

        task = serviceLayer.newTask(task);
        TaskViewModel fromService = serviceLayer.fetchTask(task.getId());
        assertEquals(task, fromService);

        List<TaskViewModel> tasks = serviceLayer.fetchAllTasks();
        assertEquals(tasks.size(), 1);
    }

    @Test
    public void updateDeleteTask(){
        TaskViewModel task = new TaskViewModel();
        task.setDescription("Descr");
        task.setCreateDate(LocalDate.of(2019, 07, 28));
        task.setDueDate(LocalDate.of(2019, 07, 31));
        task.setCategory("Cat");
        serviceLayer.newTask(task);

        Task task1 = new Task();
        task.setDescription("Descr2");
        serviceLayer.updateTask(task);
        task1.setId(task.getId());
        task1.setDescription(task.getDescription());
        task1.setCreateDate(task.getCreateDate());
        task1.setDueDate(task.getDueDate());
        task1.setCategory(task.getCategory());
        verify(taskerDao).updateTask(task1);

        serviceLayer.deleteTask(task.getId());
        verify(taskerDao).deleteTask(task.getId());

    }

    private void setUpTaskerDaoMock(){
        Task task = new Task();
        task.setId(10);
        task.setDescription("Descr");
        task.setCreateDate(LocalDate.of(2019, 07, 28));
        task.setDueDate(LocalDate.of(2019, 07, 31));
        task.setCategory("Cat");

        Task task1 = new Task();
        task1.setDescription("Descr");
        task1.setCreateDate(LocalDate.of(2019, 07, 28));
        task1.setDueDate(LocalDate.of(2019, 07, 31));
        task1.setCategory("Cat");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(10);
        doReturn(tasks).when(taskerDao).getAllTasks();
        doReturn(tasks).when(taskerDao).getTasksByCategory(task1.getCategory());
    }



}
