Feature: Checking the Date conflict function to Assign the Exam

  Background: User should be Admin to access the Date function

  Scenario: Test the Date conflict Function
    Given User is already in the date conflict website
    When user Entered the UserId and date
    And  user clicked on the check and proceed button
   Then User will get the msg from the backend