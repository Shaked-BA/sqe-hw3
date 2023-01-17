Feature: A set of scenarios for testing the commenting module
#
#  Scenario: Testing how a case where a user adds a product to the cart
#    Given an example scenario
#    When all step definitions are implemented
#    Then the scenario passes

  Scenario: Testing a case where a user adds a comment to a product
    Given User is in the shops home page
    When User navigates to an items page
    And User presses the Add Review button
    And User submits the review
    Then User successfully reviewed

  Scenario: Admin turns guest commenting off
    Given Admin logs in
    When Admin navigates to the commenting module
    And Admin turns guest commenting off
    Then Admin successfully turned commenting off