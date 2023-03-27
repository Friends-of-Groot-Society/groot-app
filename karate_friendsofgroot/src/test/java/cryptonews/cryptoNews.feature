

Feature: News API karate test script

    Background: Web-Scraping Results for

        * url 'http://localhost:8080/'
#        * def response = call read('classpath:com/maestas/karate/newsapi/NewsApi.feature@getNewsApi')
#        * print response
Scenario: get all posts and then get the first post by id
    Given path 'api/users/thomasm1.maestas@gmail.com'
    When method get
    Then status 200
    And match response contains { userId: '#notnull' }
    And match response contains { firstName: '#notnull' }
    And match response contains { lastName: '#notnull' }
    And match response contains { email: '#notnull' }
    And match response contains { password: '#notnull' }
    And match response contains { role: '#notnull' }
    And match response contains { created: '#notnull' }
    And match response contains { updated: '#notnull' }
    And match response contains { active: '#notnull' }
    And match response contains { token: '#notnull' }
    And match response contains { id: '#notnull' }
    And match response contains { posts: '#notnull' }


 * def id = response.id
 * print 'created id is: ', id

#  Scenario: get all posts and then get the first post by id
#    Given path 'api/posts'
#    When method get
#    Then status 200
#    And match response contains { id: '#notnull' }
#
# Given path id
# When method get
# Then status 200
# And match response contains { id: '#notnull' }
#
#
#     * request =
#        """
#    {
#        "id": 1,
#        "name": "John",
#        "address": "1234 Main St",
#        "city": "Anytown",
#        "state": "CA",
#        "zip": "12345"
#    }
#
#        """
#    * print request
#        """
#
#
