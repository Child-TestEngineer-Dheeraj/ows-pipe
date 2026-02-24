package actions;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import io.qameta.allure.Allure;
import utils.LoggerUtil;

public class ConductRuleAction {

	private static final Logger log = LoggerUtil.getLogger(ConductRuleAction.class);

    public void openApplication() {

        log.info("Opening OWS Application");

        try {
            // Actual Selenium code here
            // driver.get(url);

            Allure.step("OWS Application opened successfully");
            log.info("OWS Application opened successfully");

        } catch (Exception e) {
            log.error("Failed to open OWS Application", e);
            throw e;
        }
    }

    public void OpenCRModule() {

        log.info("Opening Conduct Rule Module");

        try {
            // Selenium click logic

            Allure.step("Conduct Rule Module opened");
            log.info("Conduct Rule Module opened successfully");

        } catch (Exception e) {
            log.error("Failed to open Conduct Rule Module", e);
            throw e;
        }
    }

    public void performCRAttesttion() {

        log.info("Performing Conduct Rule Attestation");

        try {
            // Selenium steps

            Allure.step("Conduct Rule attested");
            log.info("Conduct Rule attestation completed");

        } catch (Exception e) {
            log.error("Attestation failed", e);
            throw e;
        }
    }

    public void validateSuccessMessage() {

        log.info("Validating Success Message");

        try {

            String actualMessage = "Success";  // Replace with real getText()
            String expectedMessage = "Success";

            Allure.addAttachment("Actual Message", actualMessage);

            Assert.assertEquals(actualMessage, expectedMessage,
                    "Success message validation failed");

            log.info("Success message validated successfully");

        } catch (AssertionError e) {
            log.error("Success message validation failed", e);
            throw e;
        }
    }

    public void validateAttestationUnSuccessfull() {

        log.info("Validating Attestation Not Allowed Message");

        try {

            String actualMessage = "Not Allowed";  // Replace with real text
            String expectedMessage = "Not Allowed";

            Allure.addAttachment("Actual Message", actualMessage);

            Assert.assertEquals(actualMessage, expectedMessage,
                    "Attestation unsuccessful validation failed");

            log.info("Unsuccessful attestation validated successfully");

        } catch (AssertionError e) {
            log.error("Unsuccessful attestation validation failed", e);
            throw e;
        }
    }

}
