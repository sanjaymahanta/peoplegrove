Feature: Verify sending a message and inbox conversation flow

  Scenario: Verify sent message appears in inbox conversation and navigation back to Jobs page
    Given the user is on the homepage
    When user clicks on signIn
    Then user should be redirected to login page
    When the user logs in with valid credentials
    And clicks on loginButton
    Then the user should be redirected to the dashboard page

    When the user clicks on Career in the top navbar
    And the user selects Jobs option
    Then the Jobs page should be displayed

    When the user clicks on the first job
    And clicks on the first recommended user profile
    And clicks on the username "AAKASH SHUKLA"
    And clicks on the message button
    And writes a message "Hi, this is a test automation message!"
    And clicks on "Send Now" button
    And clicks on "Send without meeting" in the confirmation modal
    And clicks on "Go to inbox" button
    Then the sent message should appear in the inbox conversation

    When the user navigates back using browser back navigation
    Then the user should be redirected back to the Jobs page
    And verify that the first job title and its related user names are displayed
    And verify that the second job title and its related user names are displayed
