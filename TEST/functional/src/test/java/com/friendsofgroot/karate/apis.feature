Feature:  API testing

  Background:
    * url 'http://localhost:8080/'

  Scenario: get all users and then get the first user by id
    Given path 'api/users'
    When method get
    Then status 200
    Then match response ==
    """
        [
          {
        "userId": #number,
        "username": "#string",
        "password":"#string",
        "lastName": "#string",
        "firstName": "#string",
        "groups":  #number,
        "userType":  #number,
        "email": "#string",
        "phone": "#string",
        "cusUrl": "#string",
        "photoPath":"#string",
        "userGroup": "#string",
        "isActive":  #number,
        "contactType":  #number,
        "idToken":   #present,
        "addresses": []
    }
        ]
    """

  Scenario: get all users and then get the first user by id
    Given path 'api/coins'
    When method get
    Then status 200
    Then match $ ==
    """
        [op
    {
        "coinId":  #number,
        "coinToken": "#string",
        "coinSymbol": "#string",
        "priceTotal":  #number,
        "purchased":  #number
    }
                 ]
     """

  Scenario: get all users and then get the first user by id
    Given path 'api/weblinks'
    When method get
    Then status 200
    Then match response contains deep
    """
  [
      {
        "id":  #number,
        "title":  #present,
        "profileUrl":  #present,
        "sharedBy":  #present,
        "url": "#string",
        "host": "#string",
        "htmlPage": "#string",
        "downloadStatus":"#string",
        "web3Link":  #boolean,
        "itemData": "#string"
            }
       ]
    """
  Scenario: get all users and then get the first user by id
    Given path 'api/addresses'
    When method get
    Then status 200
    Then match response contains deep
    """
        [
     {
        "id":  #number,
        "description": "#string",
        "email": "#string",
        "address":"#string",
        "chain": "#string",
        "iconUrl": "#string",
        "blockExplorerUrl": "#string",
        "user":  #present,
        "chainId":  #number
    }
                ]
    """

  Scenario: get all users and then get the first user by id
    Given path 'api/nfts'
    When method get
    Then status 200
    Then match response contains deep
    """
         [
       {
        "id": #number,
        "name": "#string",
        "amount":  #number,
        "metadata":  #present,
        "nft_address_id":  #number
    }
                ]
    """

  Scenario: get all users and then get the first user by id
    Given path 'api/chains'
    When method get
    Then status 200
    Then match response contains deep
    """
         [
         {
        "chainId":  #number,
        "name": "#string",
        "symbol": "#string",
        "description": "#string",
        "longDescription": "#string",
        "iconUrl":          "#string",
        "category":    "#string",
        "chainListIcon":  #present,
        "rpcUrl": "#string",
        "id":  #number,
        "blockExplorerUrl": #present
    }
           ]
    """
