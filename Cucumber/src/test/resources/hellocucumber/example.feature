Feature: A set of scenarios for testing the commenting module
#
#  Scenario: Testing how a case where a user adds a product to the cart
#    Given an example scenario
#    When all step definitions are implemented
#    Then the scenario passes

  Scenario: Testing a case where a user adds a comment to a product
    Given User is in the shops home page
    When User navigates to an items page
    And User presses the Write Your Review button
    And User writes a review
    And User submits the review
    Then User successfully reviewed

  Scenario: Testing a case where the admin turns guest commenting off
    Given Admin logs in
    When Admin navigates to the commenting module
    And Admin turns guest commenting off
    Then Admin successfully turned commenting off

  Scenario: Testing a case where the admin turns guest commenting off while a user adds a comment
    Given User is in the shops home page
    And User navigates to an items page
    And User presses the Write Your Review button
    And User writes a review
    And Admin logs in
    And Admin navigates to the commenting module
    And Admin turns guest commenting off
    And Admin successfully turned commenting off
    When User submits the review
    Then User did not successfully reviewed