package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    TaskerDao dao;
    private final AdserverClient client;

    @Autowired
    public TaskerServiceLayer(TaskerDao dao, AdserverClient client) {
        this.dao = dao;
        this.client = client;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        // TODO - get ad from Adserver and put in tvm
        tvm.setAdvertisement(getAdvert());




        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> tasks = dao.getAllTasks();
        List<TaskViewModel> taskViewModels = new ArrayList<>();
        for (Task t : tasks){
            TaskViewModel taskViewModel = new TaskViewModel();
            taskViewModel.setId(t.getId());
            taskViewModel.setDescription(t.getDescription());
            taskViewModel.setCreateDate(t.getCreateDate());
            taskViewModel.setDueDate(t.getDueDate());
            taskViewModel.setCategory(t.getCategory());
            //To go - get ad
            taskViewModel.setAdvertisement(getAdvert());
            taskViewModels.add(taskViewModel);
        }
        return taskViewModels;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> tasks = dao.getAllTasks();
        List<TaskViewModel> taskViewModels = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getCategory() == category){
                TaskViewModel taskViewModel = new TaskViewModel();
                taskViewModel.setId(t.getId());
                taskViewModel.setDescription(t.getDescription());
                taskViewModel.setCreateDate(t.getCreateDate());
                taskViewModel.setDueDate(t.getDueDate());
                taskViewModel.setCategory(t.getCategory());
                //To go - get ad
                taskViewModel.setAdvertisement(getAdvert());
                taskViewModels.add(taskViewModel);
            }
        }
            return taskViewModels;

    }

    @Transactional
    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel
        taskViewModel.setAdvertisement(getAdvert());
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        dao.updateTask(task);
    }

    private TaskViewModel buildTaskViewModel(Task task){
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setId(task.getId());
        taskViewModel.setDescription(task.getDescription());
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setCategory(task.getCategory());

        //To go - get ad
        taskViewModel.setAdvertisement(getAdvert());

        return taskViewModel;
    }

    private String getAdvert(){
        return client.getAd();
    }
}
