Feature: chains feature api

  Background: background
#
#    * url 'http://34.199.129.2:8080/api'
    * url 'http://localhost:8080/api/'
#    * url baseUrl

  Scenario: chains
    Given path '/chains'
    When method get
    Then status 200

