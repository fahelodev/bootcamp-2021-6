Feature: Google Search
  'When I go to the Google search page, and search for an item,
  I expect to see some reference to that item in the result summary.'

  Scenario: Standard Search One
    Given that I have gone to the Google page
    When I add "cats" to the search box
    And click the Search Button
    Then "cats" should be mentioned in the results

#  Scenario: Standard Search Two
#    Given that I have gone to the Google page
#    When I add "dogs" to the search box
#    And click the Search Button
#    Then "dogs" should be mentioned in the results