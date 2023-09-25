
Feature: Create Token

    Scenario: Create Token
        Given url apiUrl
        Given path 'auth/login'
        And request {"user": {"email": "#(userEmail)","password": "#(userPassword)"}}
        When method Post
        Then status 200
        * def authToken = response.user.token