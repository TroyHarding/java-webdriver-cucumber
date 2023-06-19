@xpath
Feature: xpaths solved


  @predefined2
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

  @predefined3
  Scenario: Wikipedia
    Given I open url "https://www.wikipedia.org/"
    Then I should see page title as "Wikipedia"
    Then element with xpath "//input[@id='searchInput']" should be present
    When I type "The Great Emu War" into element with xpath "//input[@id='searchInput']"
    Then I click on element using JavaScript with xpath "//i[contains(text(),'Search')]"
    Then element with xpath "//main[@id='content']" should contain text "The Great Emu War"

  @xpath3
  Scenario: Merriam-Webster Dictionary
    Given I open url "https://www.merriam-webster.com/"
    Then I should see page title as "Merriam-Webster: America's Most Trusted Dictionary"
    Then element with xpath "//input[@id='search-term']" should be present
    When I type "cantankerous" into element with xpath "//input[@id='search-term']"
    Then I click on element using JavaScript with xpath "//button[@title='Search']"
    Then element with xpath "//div[@id='dictionary-entry-1']" should be present
    Then element with xpath "//div[@id='dictionary-entry-1']" should contain text "cantankerous"

  @xpath4
  Scenario: Cambridge Dictionary
    Given I open url "https://dictionary.cambridge.org/"
    Then I should see page title as "Cambridge Dictionary | English Dictionary, Translations & Thesaurus"
    Then element with xpath "//input[@id='searchword']" should be present
    When I type "cantankerous" into element with xpath "//input[@id='searchword']"
    Then I click on element using JavaScript with xpath "//button[@title='Search']"
    Then element with xpath "//div[@data-id='cald4']" should contain text "cantankerous"