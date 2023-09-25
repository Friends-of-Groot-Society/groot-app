Feature:
  Background:

    * url 'http://34.199.129.2:8080/api'

  Scenario: chains
    Given path '/chains'
    When method get
    Then status 200

