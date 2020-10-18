Feature: Test the login functionality

  Scenario: Ht user should be able to login with correct username and password
    Given user is on the login page
    When user enters correct username and correct password
    Then user gets confirmation

  Scenario Outline: the user should be able to login
    Given user is on the login page
    When user enters email <username>
    And user enters password <password>
    And user clicks login button
    Then user gets confirmation
    Examples:
      | username     | password   |
      | awcdf@abc.co | Qwerty123! |
      | ion@ion.com  | IonIonIon  |