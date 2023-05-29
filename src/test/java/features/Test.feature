@test
Feature: Test

  Scenario:Google search
    When I see "HomePage" page
    Then I go to url:"http://www.google.com"
    Then I send key to "googleSearchbar" element text:"fevzi can yılmaz"
    Then I click enter element:googleSearchbar

