package hooks;

import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import utils.LoggerUtil;
import utils.SearchContext;

public class baseHooks {
	
	private static final Logger log = LoggerUtil.getLogger(baseHooks.class);
	private long startTime;
	@SuppressWarnings("deprecation")
	@Before
	public void setup(Scenario scenario)
	{
		 startTime = System.currentTimeMillis(); 
		log.info("============================================");
        log.info("🚀 Test Execution Started");
        log.info("Scenario Name  : {}", scenario.getName());
        log.info("Scenario ID    : {}", scenario.getId());
        log.info("Thread ID      : {}", Thread.currentThread().getId());
        log.info("============================================");
        
        // Allure metadata

        Allure.step("Starting Scenario: " + scenario.getName());
			
	}
	
	
	@After
	public void tearDown(Scenario scenario)
	{
		 long duration = System.currentTimeMillis() - startTime;
		 log.info("============================================");
	        log.info("🧹 Test Execution Completed");

	        // Attach execution time
	        Allure.addAttachment("Execution Time (ms)", String.valueOf(duration));
	        if (scenario.isFailed()) {
	            log.error("❌ Scenario FAILED : {}", scenario.getName());
	            Allure.step("Scenario Failed: " + scenario.getName(),
	                    Status.FAILED);
	        } else {
	            log.info("✅ Scenario PASSED : {}", scenario.getName());
	            Allure.step("Scenario Passed: " + scenario.getName(),
	                    Status.PASSED);
	            
	        }

	        log.info("Clearing SearchContext (ThreadLocal data)");
	        SearchContext.remove();

	        log.info("Thread ID {} cleaned successfully", Thread.currentThread().getId());
	        log.info("============================================");
			
	}

}
