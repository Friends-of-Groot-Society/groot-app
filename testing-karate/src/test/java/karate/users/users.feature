Feature:  users karate test script

  Background:
#    * url 'http://34.199.129.2:8080/api/'
    * url 'http://localhost:8080/api/'
#  * url baseUrl
  @Order(1)
  Scenario: get all users and then get the first user by id
    Given path 'users'
    When method get
    Then status 200

    * def first = response[0]

    Given path 'users/' + first.userId
    When method get
    Then status 200

  @Order(2)
  Scenario: create a user and then get it by id
    * def rando = Math.floor(Math.random() * 100)
    * print "_______________________ID____" + rando
    * def user =
      """
 {
        "userId": '#(rando)',
        "username": "sarah.treviso",
        "password": "password",
        "lastName": "Treviso",
        "firstName": "Sarah",
        "groups": "1",
        "userType": 1,
        "phone": "5055087707",
        "email": "sarah.treviso@cryptomaven.xyz",
        "cusUrl": "http://www.dailytech.net",
        "photoPath": "photoPath",
        "userGroup": "userGroup",
        "isActive": 0,
        "contactType": 1
    }
      """

    Given path '/users'
    And request user
    When method post
    Then status 201

    * json resp = response
    * def id = resp.id
    * print 'created id is: ', id
# TODO
#    Given path 'users/' + id
#    When method get
#    Then status 200
#     And match response contains user
  