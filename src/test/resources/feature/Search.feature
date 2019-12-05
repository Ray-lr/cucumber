@search
Feature:  web test
  some tests

  @BaiDu
  Scenario Outline: search something
    Given Go to BaiDu home
    When I find BaiDu logo
    And Type the search text "<searchText>"
    And Click the submit
    Then Wait the BaiDu query result "<result>"
    Examples:
      | searchText | result   |
      | 马龙         | 马龙_百度搜索  |
      | Ray        | Ray_百度搜索 |
    
  @JD
    Scenario Outline: search in JD
      Given Go to JD home
      When I find JD search box
      And Type the search content "<content>"
      And Click the search button
      And Click the first good
      And Add into cart
      And Go to shopping cart
      And Go to order
      Then Wait the JD query result
    Examples:
      |content |
      |java core|
    |effective java|