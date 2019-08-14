package com.company.SaraMoujahedU1Capstone;

import com.company.SaraMoujahedU1Capstone.dao.*;
import com.company.SaraMoujahedU1Capstone.model.Game;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
		ConsoleDaoJdbcTemplateImplTest.class,
		GameDaoJdbcTemplateImplTest.class,
		TShirtDaoJdbcTemplateImplTest.class,
		InvoiceDaoJdbcTemplateImplTest.class,

})
public class SaraMoujahedU1CapstoneTestSuite {

}
