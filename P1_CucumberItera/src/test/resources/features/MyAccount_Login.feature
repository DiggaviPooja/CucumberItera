Feature: MyAccount-Login Feature
  Description: This feature will test a Login feature

  #Simple login without parameters
  @simpleTest
  Scenario: TC01_Log-in with valid username and password
    Given Open the browser
    When User Enter the URL "http://practice.automationtesting.in/"
    And Click on My Account Menu
    And Enter registered username and password
    And Click on login button
    Then User must successfully login to the web page

    #Simple login with DataTable parameters
  @DataTableTest
  Scenario: TC02_DATATABLE example
    Given Open the browser
    When User Enter the URL
    And Click on My Account Menu
    #for single user -> List
    And user enters registered username and password
        | pavanoltraining | Test@selenium123 |
    #for multiple users -> Map
    #And user enters registered username and password with headers
    #  | UserName | Password |
    #  | pavanoltraining | Test@selenium123 |
    #  | pavanol         | Test@selenium123 |
    #here it is not valid case because we have given wrong credentials for 2nd user, to verify login it has to execute before
    #it will fail here
    And Click on login button
    Then User must successfully login to the web page