@quote
Business Need: Automate the Default Flow of QUOTE

  @quote1
  Scenario: (Smoke Test) Fill out the Required Fields of Quote and arrive on the Confirmation Page
    Given I visit Quote Page in the "Stage" Environment
    When I enter "noobsaibot" for the Username field
    And I enter "Noob" for first name and "Saibot" for the last name in the Name field
    And I enter "test@test.com" for the Email field
    When I enter "abcd1234" for the Password field
    And I enter "abcd1234" for the Confirm Password field
    Then I "check" the Privacy Policy Policy checkbox
    When I click on the "Submit" button at the bottom of the page
    Then I verify we see the Submitted Application Page
    Then I verify username is "noobsaibot", first name is "Noob", last name is "Saibot", email is "test@test.com", and password is "abcd1234"


  @quote2
  Scenario Outline: (Smoke Test) Fill out the Required Fields of Quote and arrive on the Confirmation Page
    Given I visit Quote Page in the "Stage" Environment
    When I enter <username> for the Username field
    And I enter <fname> for first name and <lname> for the last name in the Name field
    And I enter <email> for the Email field
    When I enter <pass> for the Password field
    And I enter <pass> for the Confirm Password field
    Then I "check" the Privacy Policy Policy checkbox
    When I click on the "Submit" button at the bottom of the page
    Then I verify we see the Submitted Application Page
    Then I verify username is <username>, first name is <fname>, last name is <lname>, email is <email>, and password is <pass>
    Examples:
      | username     | fname  | lname      | email           | pass       |
      | "Sub Zero"   | "Tony" | "Demyshev" | "test@test.com" | "abcd1234" |
      | "Raiden" | "Viktor" | "Kim" | "test@test.com" | "1234abcd" |
      | "Kitana" | "Katya" | "Fedoseeva" | "test@test.com" | "qwerty6" |
      | "Jax" | "Baran" | "Karabacak" | "test@test.com" | "PASSWORD" |
      | "!@$#%^$(*))___++)_+_)_+$$@#$" | ")(&(*^*(%^(&@))!_)@!@#@#@#@" | "@(#^@(#&*)@&*#@#" | "test@test.com" | "PASSWORD" |
      | "Jade" | "Smitha" | "Puthotte" | "test@test" | "PASSWORD" |
      | "Shiva" | "Saiqua" | "Sidra" | "test@test.com" | "1" |


  # Create one for full QUOTE all the Pages
