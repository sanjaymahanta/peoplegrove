Feature: Verify user workflows under Career and Messaging modules

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

  Scenario: Verify career path navigation, selection, and recently viewed careers display
    Given the user is on the homepage
    When user clicks on signIn
    Then user should be redirected to login page
    When the user logs in with valid credentials
    And clicks on loginButton
    Then the user should be redirected to the dashboard page

  
    When the user mouse hovers over Career in the top navbar
    And the user click "Career Paths" option
    Then the Career Paths page should be displayed

    When the user scrolls down to the "Carrer path" section
    And the user selects any career path
    Then the selected career path detail page should open

    When the user clicks the browser back button
    Then the user should be navigated back to the Career Paths page

    When the user selects two more different career paths of their choice
    And the user clicks on "Home" from the top navbar
    Then the homepage should be displayed

    And in the "Recently Viewed Careers" section
    Then the most recently viewed career path should appear first

