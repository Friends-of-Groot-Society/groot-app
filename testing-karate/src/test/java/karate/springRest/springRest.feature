Feature: Spring REST feature api

  Background: background
#
#    * url 'http://34.199.129.2:8080/'
    * url 'http://localhost:8080/'
#    * url baseUrl

  Scenario Outline: Spring REST Framework
    Given path 'rest/' + '<_PATH>'
    When method get
    Then status 200

    Examples:
      | _PATH        | VAR_1   | VAR_2   | VAR_3   | VAR_   |
      | user         | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | address      | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | attribute    | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | chain        | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | metadata     | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | nftaddress   | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | raw_token    | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | role         | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | user_account | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |


