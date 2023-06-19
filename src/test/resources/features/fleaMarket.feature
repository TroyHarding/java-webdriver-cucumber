@flea
Feature: Automate the FLEA Market

  @flea1
  Scenario: Landing Page
    Given I visit FLEA Market in the "QA" Environment
    Then I verify title is "e-commerce – Automation Practice Website" for the page
    Then I verify Cart Icon is present
    Then I verify Image Slider is present


  @flea2
  Scenario: Product Page
    Given I visit FLEA Market in the "QA" Environment


  @flea3
  Scenario: Add to Cart Flow
    Given I visit FLEA Market in the "QA" Environment


  @flea4
  Scenario: Checkout/Confirmation Flow
    Given I visit FLEA Market in the "QA" Environment
    When I wait and click on a product "Apple Watch Series 6" on the Landing Page
    Then I wait for "View Cart" to appear
    Then I tap on "View Cart"
    Then I should see the page title as "Cart – E-Market"
    Then I go to "Proceed" button
    And I enter "John" for the first name and "Doe" for the last name in the Name field "123-123-1234" for phone and "email@email.com" for email field
    Then element "Place Order" should be present
    Then I wait 10 sec
    Then I press "Place Order" button
    Then I verify we see the Confirmation Page title is "Checkout – E-Market"
    Then I verify Order Details have "Apple Watch Series 6" item





