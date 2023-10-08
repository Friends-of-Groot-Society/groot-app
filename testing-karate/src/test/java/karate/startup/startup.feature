Feature: health and actuator endoints

  Background: background

#    * url 'http://34.199.129.2:8080/'
    * url "http://localhost:8080"
#    * url baseUrl

  Scenario: health
    Given path 'actuator/health'
    When method get
    Then status 200

