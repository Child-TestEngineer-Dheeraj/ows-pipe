
@ConductRule @Feature2
Feature: Conduct Rule Module

  @TC_04 @Smoke @Regression
  Scenario: Conduct Rule Attested
    Given User Open OWS Application
    And User Open Conduct Rule Module
    When User Attest Conduct Rule for Country
    Then Conduct Rule Attested Success Message should display

  @TC_05 @Smoke @Regression
  Scenario: Conduct Rule Attestion Not Done
    Given User Open OWS Application
    And User Open Conduct Rule Module
    When User Attest Conduct Rule for Same Country
    Then System should not allow
