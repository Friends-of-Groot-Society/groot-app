Feature: *

  Background:
      * def js = call read('classpath:utils/JSMethods.js')
    * url  apiUrl

    @getRandomId
  Scenario: get random id
      ## calling this from another featur file and passing in path
   # * eval if(typeof(toolAPI) == 'undefined') toolAPI = configToolAPI

      * path ''
      * headers headerInfo
      * method GET
      * status 200
      * def ids = $resposne.data.content[*].id
      * def randomId = ids[r]
      * print "::::::::::::::"
      * print randomId
