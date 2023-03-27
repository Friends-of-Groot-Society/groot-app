Feature:  FinClass

  Background:
    * url 'http://localhost:8080/'

  Scenario: get all users and then get the first user by id
    Given path 'api/coins'
    When method get
    Then status 200

  Scenario: get all users and then get the first user by id
    Given path 'api/chains'
    When method get
    Then status 200
#     Then match $ ==
# """

# """
  Scenario: get all users and then get the first user by id
    Given path 'api/addresses'
    When method get
    Then status 200
  #   Then match response contains deep
  #  """

  #         "data": [
  #             {
  #                 "ico_id": "1064",
  #                 "token_symbol": "E2C",
  #                 "ico_token_name": "Electronic Energy",
  #                 "ico_category": "Finance",
  #                 "total_supply": "1.00B",
  #                 "total_supply_raw": "1000000000",
  #                 "ico_percent": "50",
  #                 "token_sale_link": "https://electronicenergycoin.com/?utm_source=investing.com",
  #                 "ico_flag": "https://i-invdn-com.investing.com/ico_flags/electronic-energy_80x80.png",
  #                 "related_days_raw": 305,
  #                 "related_days": "305 days",
  #                 "ico_enddate": 1675900800,
  #                 "ico_enddate_": "2023-02-09",
  #                 "ico_startdate": 1513728000,
  #                 "ico_startdate_": "2017-12-20",
  #                 "ico_complete_pct": "0",
  #                 "ico_funds_raised_raw": "",
  #                 "ico_funds_raised": "0",
  #                 "ico_complete_pct_color": "#fa4545"
  #             }
  #         ]
  #  """

  #   * def id = response.id
  #   * print 'created id is: ', id

  #   Given path id
  #   When method get
  #   Then status 200
  #   And match response contains user
