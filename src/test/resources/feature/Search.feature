@search
Feature:  百度搜索
  打开百度进行搜索
  @BaiDu
    Scenario: search selenium
      Given Go to baidu home
      When I find baidu logo
      And Type the search text "马龙"
      And Click the submit
      Then Wait the baidu query result "马龙_百度搜索"

  @JD
    Scenario: search in JD
      Given Go to JD home
      When I find JD search box
      And Type the search content "thinking in java"
      And Click the search button
      And Click the first good
      And Add into cart
      And Go to shopping cart
      And Go to order
      Then Wait the JD query result