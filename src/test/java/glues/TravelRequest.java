package glues;

import java.util.Random;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import actions.ConductRuleAction;
import actions.TravelRequestAction;
import actions.commonActions;

import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import utils.LoggerUtil;

public class TravelRequest{
	private static final Logger log=LoggerUtil.getLogger(TravelRequest.class);
	
	
	TravelRequestAction traction =new TravelRequestAction();
	ConductRuleAction craction=new ConductRuleAction();
	commonActions action=new commonActions();
	
	@When("User Create Travel Request")
    public void user_create_travel_request() {

      //  log.info("Step Started: Create Travel Request");

        Allure.step("User creates Travel Request", () -> {
            traction.createTravelRequest();
        });

       // log.info("Step Completed: Travel Request Created");
    }

    @Then("Travel Request Should be created Successfully")
    public void travel_request_should_be_created_successfully() {

      //log.info("Step Started: Validate Travel Request Creation");

        Allure.step("Validate Travel Request Success Message", () -> {
            traction.validateTravelRequestCreation();
        });

       // log.info("Step Completed: Travel Request Creation Validated");
    }

    @Then("Travel Request is created in Database")
    public void travel_request_is_created_in_database() {

       // log.info("Step Started: Validate Travel Request in Database");

        Allure.step("Validate Travel Request Entry in Database", () -> {
            traction.validateCreationInDB();
        });

      //  log.info("Step Completed: Database Validation Done");
    }

    @When("Supervisor A Open the Travel Request")
    public void supervisor_a_open_the_travel_request() {

       // log.info("Step Started: Supervisor A opens Travel Request");

        Allure.step("Supervisor A opens Travel Request", () -> {
            traction.opentravelRequest();
        });

        //log.info("Step Completed: Travel Request Opened by Supervisor A");
    }

    @When("Supervisor A Approve it")
    public void supervisor_a_approve_it() {

       // log.info("Step Started: Supervisor A Approves Travel Request");

        Allure.step("Supervisor A approves Travel Request", () -> {
            traction.approvetravelRequest();
        });

      //  log.info("Step Completed: Travel Request Approved");
    }

    @Then("Approevd Success Message should be displayed")
    public void approevd_success_message_should_be_displayed() {

      //  log.info("Step Started: Validate Approval Success Message");

        Allure.step("Validate Approval Success Message", () -> {
            craction.validateSuccessMessage();
        });

      //  log.info("Step Completed: Approval Message Validated");
    }

    @Given("SupervisorB Open OWS Application")
    public void supervisor_b_open_ows_application() {

     //   log.info("Step Started: Supervisor B opens OWS Application");

        Allure.step("Supervisor B opens OWS Application", () -> {
            craction.openApplication();
        });

   //     log.info("Step Completed: Supervisor B Application Opened");
    }

    @When("SupervisorB Open the Same Travel Request")
    public void supervisor_b_open_the_same_travel_request() {

   //     log.info("Step Started: Supervisor B opens same Travel Request");

        Allure.step("Supervisor B opens same Travel Request", () -> {
            traction.opentravelRequest();
        });

    //    log.info("Step Completed: Supervisor B Opened Travel Request");
    }

    @Then("Approve button should be disabled")
    public void approve_button_should_be_disabled() {

   //     log.info("Step Started: Validate Approve Button Disabled");

        Allure.step("Validate Approve Button is Disabled", () -> {
            action.validateDisabledButton();
        });

     //   log.info("Step Completed: Disabled Button Validation Done");
    }

    @Given("SupervisorC Open OWS Application")
    public void supervisor_c_open_ows_application() {
    	//log.info("Step Started: Supervisor B opens OWS Application");

        Allure.step("Supervisor B opens OWS Application", () -> {
            craction.openApplication();
        });

       // log.info("Step Completed: Supervisor B Application Opened");

     
    }

    @When("SupervisorC Open the Same Travel Request")
    public void supervisor_c_open_the_same_travel_request() {
    	// log.info("Step Started: Supervisor B opens same Travel Request");

         Allure.step("Supervisor B opens same Travel Request", () -> {
             traction.opentravelRequest();
         });

       //  log.info("Step Completed: Supervisor B Opened Travel Request");
    }

    @Then("sometimes fail")
    public void sometimes_fail() {
    	if(new Random().nextBoolean()) {
            Assert.fail("Random failure");
        }
    }


}
