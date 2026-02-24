
@TravelActivity
Feature: Travel Activity Module Features

  @Smoke @Regression @TC_01
  Scenario: Create A Travel Request
    Given User Open OWS Application
    When User Create Travel Request
    Then Travel Request Should be created Successfully
    And Travel Request is created in Database
    When Supervisor A Open the Travel Request
    And Supervisor A Approve it
    Then Approevd Success Message should be displayed

  @Smoke @Regression @TC_02
  Scenario: SupervisorB Approve Same Travel Request
    Given User Open OWS Application
    When User Create Travel Request
    Then Travel Request is created in Database
    When Supervisor A Open the Travel Request
    And Supervisor A Approve it
    Then Approevd Success Message should be displayed
    When SupervisorB Open OWS Application
    And SupervisorB Open the Same Travel Request
    Then  Approve button should be disabled
    
  @Smoke @Regression @TC_03
  Scenario: fails sometime
    Given User Open OWS Application
    When User Create Travel Request
    Then  sometimes fail
    
