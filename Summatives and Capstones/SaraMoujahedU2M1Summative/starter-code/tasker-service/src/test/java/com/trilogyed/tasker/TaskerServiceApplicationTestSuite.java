package com.trilogyed.tasker;

import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
		TaskerDaoJdbcTemplateImpl.class

})
public class TaskerServiceApplicationTestSuite {

}
