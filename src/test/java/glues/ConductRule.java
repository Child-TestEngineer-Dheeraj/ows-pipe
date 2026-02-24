package glues;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import actions.ConductRuleAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import utils.LoggerUtil;

public class ConductRule {
	private static final Logger log = LoggerUtil.getLogger(TravelRequest.class);

	ConductRuleAction craction = new ConductRuleAction();

	@Given("User Open OWS Application")
	public void user_open_ows_application() {

		//log.info("Step Started: Open OWS Application");

		Allure.step("Opening OWS Application", () -> {
			craction.openApplication();
		});

		//log.info("Step Completed: OWS Application Opened");
	}

	@Given("User Open Conduct Rule Module")
	public void user_open_conduct_rule_module() {

		//log.info("Step Started: Open Conduct Rule Module");

		Allure.step("Opening Conduct Rule Module", () -> {
			craction.OpenCRModule();
		});

		//log.info("Step Completed: Conduct Rule Module Opened");
	}

	@When("User Attest Conduct Rule for Country")
	public void user_attest_conduct_rule_for_country() {

		//log.info("Step Started: Attest Conduct Rule for Country");

		Allure.step("Attesting Conduct Rule for Country", () -> {
			craction.performCRAttesttion();
		});

		//log.info("Step Completed: Conduct Rule Attestation Done");
	}

	@Then("Conduct Rule Attested Success Message should display")
	public void conduct_rule_attested_success_message_should_display() {

		//log.info("Step Started: Validate Success Message");

		Allure.step("Validating Success Message", () -> {
			craction.validateSuccessMessage();
		});

		//log.info("Step Completed: Success Message Validated");
	}

	@When("User Attest Conduct Rule for Same Country")
	public void user_attest_conduct_rule_for_same_country() {

		//log.info("Step Started: Attest Conduct Rule for Same Country");

		Allure.step("Attesting Conduct Rule for Same Country", () -> {
			craction.performCRAttesttion();
		});

		//log.info("Step Completed: Re-Attestation Attempt Done");
	}

	@Then("System should not allow")
	public void system_should_not_allow() {

		//log.info("Step Started: Validate Attestation Not Allowed");

		Allure.step("Validating Attestation Not Allowed Scenario", () -> {
			craction.validateAttestationUnSuccessfull();
		});

		//log.info("Step Completed: Validation of Unsuccessful Attestation Done");
	}
}
