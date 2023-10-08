Feature: chains feature api

  Background: background
#
#    * url 'http://34.199.129.2:8080/api'
    * url 'http://localhost:8080/api/'
#    * url baseUrl

  Scenario: addresses
    Given path '/addresses'
    When method get
    Then status 200

