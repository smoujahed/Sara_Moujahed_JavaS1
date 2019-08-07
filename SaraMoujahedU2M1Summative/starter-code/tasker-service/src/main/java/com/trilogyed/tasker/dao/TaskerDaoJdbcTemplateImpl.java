package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskerDaoJdbcTemplateImpl implements TaskerDao {

    public static final String INSERT_TASK =
            "insert into task (task_description, create_date, due_date, category) values (?, ?, ?, ?)";
    public static final String SELECT_TASK_BY_ID =
            "select * from task where task_id = ?";
    public static final String SELECT_ALL_TASKS =
            "select * from task";
    public static final String SELECT_TASKS_BY_CATEGORY =
            "select * from task where category = ?";
    public static final String UPDATE_TASK =
            "update task set task_description = ?, create_date = ?, due_date = ?, category = ? where task_id = ?";
    public static final String DELETE_TASK =
            "delete from task where task_id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TaskerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Task createTask(Task task) {
        jdbcTemplate.update(
                INSERT_TASK,
                task.getDescription(),
                task.getCreateDate(),
                task.getDueDate(),
                task.getCategory());
        task.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return task;
    }

    @Override
    public Task getTask(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TASK_BY_ID, this::mapRowToTask, id);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<Task> getAllTasks() {
        try {
            return jdbcTemplate.query(SELECT_ALL_TASKS, this::mapRowToTask);
        } catch (EmptyResultDataAccessException e){
            List<Task> empty = new ArrayList<>();
            return empty;
        }

    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        try {
            return jdbcTemplate.query(SELECT_TASKS_BY_CATEGORY, this::mapRowToTask, category);
        }catch (EmptyResultDataAccessException e) {
            List<Task> empty = new ArrayList<>();
            return empty;
        }
    }

    @Override
    public void updateTask(Task task) {
        jdbcTemplate.update(
                UPDATE_TASK,
                task.getDescription(),
                task.getCreateDate(),
                task.getDueDate(),
                task.getCategory(),
                task.getId()
                );
    }

    @Override
    public void deleteTask(int id) {
        jdbcTemplate.update(DELETE_TASK, id);
    }

    private Task mapRowToTask(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getInt("task_id"));
        task.setDescription(resultSet.getString("task_description"));
        task.setCreateDate(resultSet.getDate("create_date").toLocalDate());
        task.setDueDate(resultSet.getDate("due_date").toLocalDate());
        task.setCategory(resultSet.getString("category"));
        return task;
    }
}
