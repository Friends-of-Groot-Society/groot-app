Feature: health and actuator endoints

  Background:

    * url 'http://34.199.129.2:8080/'

  Scenario: health
    Given path 'actuator/health'
    When method get
    Then status 200

