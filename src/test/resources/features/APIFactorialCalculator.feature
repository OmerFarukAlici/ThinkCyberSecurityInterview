Feature: API calls


  @wip
  Scenario: Post request
    When sending a POST request using ContentType.URLENC and sending 5 in the body
    Then Status code 200 should be given
    And response body answer should be 120
