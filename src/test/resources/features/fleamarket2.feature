@flea
Feature: Automate Flea Market

  @flea1
  Scenario Outline: Landing Page
    Given I visit FLEA Market in the "Stage" Environment
    Then I verify title is "E-Market – Automation Practice Website" for the page
    When I verify and Click on <name> Category on the Top Bar
    Then I verify Cart Icon is present
    Then I verify Image Slider is present
    Then I verify Contact button functionality
    Examples:
      | name    |
      | "Mac"         |
      | "iPhone"      |
      | "Watch"       |
      | "Accessories" |


  @flea2
  Scenario: Product Page
    Given I visit FLEA Market in the "Stage" Environment
    Then I verify title is "E-Market – Automation Practice Website" for the page
    When I wait and click on a product "Apple Watch Series 6" on the Landing Page
    When I verify Description contains text "Apple Watch Series 6"
    When I add "2" items to Cart and verify Cart

  @flea3
  Scenario: Add to Cart Flow
    Given I visit FLEA Market in the "Stage" Environment
    Then I verify title is "E-Market – Automation Practice Website" for the page
    When I tap on element "Apple Watch Series 6" from Landing Page
    Then I tap on View Cart button
    When I update the cart to "2" and verify
    Then I remove the "Apple Watch Series 6" product and verify it was removed

  @flea4
  Scenario: Checkout/Confirmation Flow
    Given I visit FLEA Market in the "Stage" Environment
    Then I verify title is "E-Market – Automation Practice Website" for the page
    When I tap on element "Apple Watch Series 6" from Landing Page
    Then I tap on View Cart button
    Then I should see the page title as "Cart – E-Market"
    When I proceed to checkout
    When I fill out checkout details and place order
    Then I verify Confirmation Page




