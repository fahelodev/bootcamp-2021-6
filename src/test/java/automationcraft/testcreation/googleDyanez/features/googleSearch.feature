Feature: Google Search
  'When I go to the Google search page, and search for an item,
  I expect to see some reference to that item in the result summary.'

  Scenario Outline: Standard Search nameAnimal
    Given that I have gone to the Google page
    When I add "<nameAnimal>" to the search box
    And click the Search Button
    Then the "<nameAnimal>" should be mentioned in the results

    Examples:
      |nameAnimal |
      |cats       |
      |dogs       |
      #|elephants  |
      #|pigs       |
      #|birs       |