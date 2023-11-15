@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//*[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"


  @predefined2
  Scenario: Steps for excite.com
    Given I open url "https://www.excite.com/"
    Then I should see page title as ""
    Then element with xpath "//*[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@name='q']"
    When I click on element with xpath "//button[@title='Search the Web!']"
    Then I switch to new window
    Then I wait for element with xpath "//div[@class='layout__mainline']" to be present
    Then element with xpath "//div[@class='layout__mainline']" should contain text "Cucumber"
    And I switch to first window

  @predefined3
  Scenario: Steps for duckduckgo.com
    Given I open url "https://duckduckgo.com/"
    Then I should see page title as "DuckDuckGo — Privacy, simplified."
    Then element with xpath "//*[@name='q']" should be present
    When I type "Linux" into element with xpath "//*[@name='q']"
    When I click on element with xpath "//button[@aria-label='Search']"
    Then I wait for element with xpath "//section[@data-testid='mainline']" to be present
    Then element with xpath "//section[@data-testid='mainline']" should contain text "linux"
    
  @predefined4
  Scenario: Steps for swisscows.com 
    Given I open url "https://swisscows.com/en"
    Then I should see page title as "Your private and anonymous search engine Swisscows"
    Then element with xpath "//input[@name='query']" should be present
    When I type "Sacramento" into element with xpath "//input[@name='query']"
    When I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "sacramento"

  @predefined5
  Scenario: Steps for www.searchencrypt.com 
    Given I open url "https://www.searchencrypt.com/home"
    Then I should see page title as "Search Encrypt | Home"
    Then element with xpath "//*[@name='q']" should be present
    When I type "SDLC" into element with xpath "//*[@name='q']"
    When I click on element with xpath "//*[@class='search-bar__submit']"
    Then I wait for element with xpath "//*[@class='serp__results container']" to be present
    And I wait for 1 sec
    Then element with xpath "//div[@class='serp__top-ads']" should contain text "SDLC"
    Then I

  @predefined6
  Scenario: Steps for www.startpage.com 
    Given I open url "https://www.startpage.com/"
    Then I should see page title as "Startpage - Private Search Engine. No Tracking. No Search History."
    Then element with xpath "//input[@id='q']" should be present
    When I type "SDLC" into element with xpath "//input[@id='q']"
    When I click on element with xpath "//button[@id='search-btn']"
    Then I wait for element with xpath "//div[@class='layout-web__mainline']" to be present
    Then element with xpath "//div[@class='layout-web__mainline']" should contain text "SDLC"

  @predefined7
    Scenario: Steps for www.ecosia.org
    Given I open url "https://www.ecosia.org/"
    Then I should see page title as "Ecosia - the search engine that plants trees"
    Then element with xpath "//input[@name='q']" should be present
    When I type "ficus" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//button[@aria-label='Submit']"
    Then I wait for element with xpath "//section[@data-test-id='mainline']" to be present
    Then element with xpath "//section[@data-test-id='mainline']" should contain text "ficus"

  @predefined8
  Scenario: Steps for www.wiki.com
    Given I open url "https://www.wiki.com/" 
    Then I should see page title as "Wiki.com"
    Then element with xpath "//input[@name='q']" should be present
    When I type "halloween" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//input[@name='btnG']"
    And I wait for 2 sec
    When I click on element with xpath "//button[@id='proceed-button']"
    And I wait for 2 sec
    Then I wait for element with xpath "//div[contains(@id, 'results')]" to be present
    Then I switch to iframe with xpath "//iframe[@srcdoc]"
    And I wait for 1 sec
    Then element with xpath "//div[@class='gsc-wrapper']" should contain text "halloween"
    Then I switch to default content

  @predefined9
  Scenario: Steps for www.givewater.com
    Given I open url "https://www.givewater.com/"
    Then I should see page title as "Search the Web to Give Clean Water to Those in Need » giveWater Search Engine"
    Then element with xpath "//input[@id='site-search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='site-search']"
    When I click on element using JavaScript with xpath "//button[@class='btn-search']"
    And I wait for 1 sec
    Then I wait for element with xpath "//div[@class='layout__mainline']" to be present
    Then element with xpath "//div[@class='layout__mainline']" should contain text "cucumber"






