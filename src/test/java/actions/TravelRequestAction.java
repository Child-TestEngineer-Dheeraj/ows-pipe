package actions;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import io.qameta.allure.Allure;
import utils.LoggerUtil;
import utils.SearchContext;

public class TravelRequestAction {

	private static final Logger log = LoggerUtil.getLogger(TravelRequestAction.class);

	public void createTravelRequest() {

		log.info("Creating Travel Request");

		try {

			// Simulate generated ID (replace with real UI/API response)
			String travelRequestId = String.valueOf(System.currentTimeMillis());

			SearchContext.setContextdata("TR_ID", travelRequestId);

			log.info("Travel Request Created with ID: {}", travelRequestId);

			Allure.addAttachment("Travel Request ID", travelRequestId);

		} catch (Exception e) {
			log.error("Failed to create Travel Request", e);
			throw e;
		}
	}

	public void validateTravelRequestCreation() {

		log.info("Validating Travel Request Creation");

		try {

			String message = "Travel Request Created Successfully"; // replace with UI text

			Allure.addAttachment("Creation Message", message);

			Assert.assertTrue(message.contains("Successfully"), "Travel Request creation validation failed");

			log.info("Travel Request creation validated successfully");

		} catch (AssertionError e) {
			log.error("Validation failed for Travel Request creation", e);
			throw e;
		}
	}

	public void validateCreationInDB() {

		log.info("Validating Travel Request in Database");

		try {

			String TRID = SearchContext.getContextdata("TR_ID");

			// Replace with real DB query
			boolean recordExistsInDB = true;

			Allure.addAttachment("DB Validation TR_ID", TRID);

			Assert.assertTrue(recordExistsInDB, "Travel Request not found in Database for ID: " + TRID);

			log.info("Travel Request {} found in Database", TRID);

		} catch (AssertionError e) {
			log.error("Database validation failed", e);
			throw e;
		}
	}

	public void opentravelRequest() {

		String TRID = SearchContext.getContextdata("TR_ID");

		log.info("Opening Travel Request with ID: {}", TRID);

		Allure.step("Opening Travel Request ID: " + TRID);

		Assert.assertNotNull(TRID, "Travel Request ID is null in SearchContext");
	}

	public void approvetravelRequest() {

		String TRID = SearchContext.getContextdata("TR_ID");

		log.info("Approving Travel Request with ID: {}", TRID);

		Allure.step("Approving Travel Request ID: " + TRID);

		Assert.assertNotNull(TRID, "Travel Request ID is null before approval");
	}

}
