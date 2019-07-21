@DiscoveryTest
@Recommandevideos
@Myvideos
Feature: To add videos from recommanded videos and verify in my videos
  Scenario: Adding videos from recommanded videos list and verificaion in my videos
  Given I launch the browser and enter the url
  Then I scroll the page till recommanded videos
  And I move to first video
  When I store the name of first video
  Then I select the video and adding to favorite list
  And I move to second video
  When I store the name of second video
  Then I select second video and adding to favorite list
  When I click on menu tab in homepage
  Then I click my videos tab from menu
  And I verify videos added correctly in my videos tab