@quote
Business Need: Automate the Default Flow of QUOTE

  @quote1
  Scenario: (Smoke Test) Fill out the Required Fields of Quote and arrive on the Confirmation Page
    Given I visit Quote Page in the "Stage" Environment
    When I enter "" for the Username field
    And I enter "" for first name and "" for the last name in the Name field
    And I enter "" for the Email field
    When I enter "" for the Password field
    And I enter "" for the Confirm Password field
    Then I "check" the Privacy Policy Policy checkbox
    When I click on the "" button at the bottom of the page
    Then I verify we see the Submitted Application Page


  @quote2
  Scenario: (E2E)Fill out the Required Fields of Quote and Verify all the Data in the Confirmation Page
    Given I visit Quote Page in the "Stage" Environment
    When I enter "" for the Username field
    And I enter "" for first name and "" for the last name in the Name field
    And I enter "" for the Email field
    When I enter "" for the Password field
    And I enter "" for the Confirm Password field
    Then I "check" the Privacy Policy Policy checkbox
    When I click on the "" button at the bottom of the page
    Then I verify username is "", first name is "", last name is "", email is "", and password is ""


  @quote3
  Scenario Outline: E2E
    Given I visit Quote Page in the "Stage" Environment
    When I enter "<username>" for the Username field
    And I enter "<firstName>" for first name and "<lastName>" for the last name in the Name field
    And I enter "<email>" for the Email field
    When I enter "<password>" for the Password field
    And I enter "<password>" for the Confirm Password field
    Then I "check" the Privacy Policy Policy checkbox
    When I click on the "Submit" button at the bottom of the page
    Then I verify username is "<us", first name is "", last name is "", email is "", and password is ""

    Examples:
      |username| firstName|lastName|email|password|
      |annbbq1 |Anna      |khurkina|annaqa@gmail.com|password123|
      |bblade  |Boris     |Danski  |borisb@gmail.com|1234qwerty |
      |jj12xd  |Jyothi    |Pradhan |jj12xd@gmail.com|io12xd*    |
      |sanSan45|Sanjay    |Patel   |sanjalp@gmail.com|admin123  |


  @quote4
  Scenario: (E2E) Fill out Every Field of Quote and Verify all the Data in the Confirmation Page
    Given I visit Quote Page in the "Stage" Environment