@flea
Feature: Automate the FLEA Market

  @flea1
  Scenario: Landing Page
    Given I login
    Then Verify Page Title
    Then Verify Product Categories (Both)
    Then Verify Cart Icon
    Then Verify Image Slider
    Then Verify Filters
    Then Verify Contact Button
    Then I wait for 15 second


  @flea2
  Scenario: Product Page

  @flea3
  Scenario: Add to Cart Flow

  @flea4
  Scenario: Checkout/Confirmation Flow





