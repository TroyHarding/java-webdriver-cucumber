@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//textarea[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//textarea[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined4
  Scenario: Wikipedia
    Given I open url "https://www.wikipedia.org/"
    Then I should see page title as "Wikipedia"
    Then element with xpath "Search Bar" should be present
    When I type "The Great Emu War" into element with xpath "Search Bar"
    Then I click on element using JavaScript with xpath "Search Icon"
    Then element with xpath "Content Text" should contain text "The Great Emu War"

  @predefined3
  Scenario: Quote Page Required Pages
    Given I open url "http://quote-stage.portnov.com/"
    Then I should see page title as "Get a Quote"
    Then element with xpath "Username" should be present
    When I type "Tester T Testington" into element with xpath "Name"
    When I type "test4life" into element with xpath "Username"
    When I type "P@$$w04d" into element with xpath "Enter Password"
    When I type "P@$$w04d" into element with xpath "Confirm Password"
    Then I click on element using JavaScript with xpath "Send"
    Then element with xpath "Submitted Application" should contain text "Submitted Application"

  @predefined4
  Scenario: Merriam-Webster Dictionary
    Given I open url "https://www.merriam-webster.com/"
    Then I should see page title as "Merriam-Webster: America's Most Trusted Dictionary"
    Then element with xpath "Search Bar" should be present
    When I type "cantankerous" into element with xpath "Search Bar"
    Then I click on element using JavaScript with xpath "Search Button"
    Then element with xpath "Content Text" should be present
    Then element with xpath "Content Text" should contain text "cantankerous"

  @predefined5
  Scenario: Cambridge Dictionary
    Given I open url "https://dictionary.cambridge.org/"
    Then I should see page title as "Cambridge Dictionary | English Dictionary, Translations & Thesaurus"
    Then element with xpath "Search Bar" should be present
    When I type "cantankerous" into element with xpath "Search Bar"
    Then I click on element using JavaScript with xpath "Search Button"
    Then element with xpath "Content Text" should be present
    Then element with xpath "Content Text" should contain text "cantankerous"
