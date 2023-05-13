Feature:  NFT API testing

  Background:
    * url 'http://34.199.129.2:9000'



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
    Given path 'api/nft'
    When method post
    And request
    """
    {

      "address":"0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
  "chain":"ropstein"
    }
    """


    Then status 200
    Then match response ==
    """
      {
    "native": "0.010273261366019717",
    "tokens": [
        "35.117792413387084938 BUSD",
        "69.54927571 MATIC",
        "12.0 USDC",
        "55.0 HEX"
    ],
    "nfts": [
        {
            "name": "One day,Ujuuna killed in explosion, and his reincarnation is decided at generative.",
            "amount": 1,
            "metadata": {
                "name": "Ten Uju Gene #08380",
                "description": "ある日、イケハヤさんと対談し、未来にワクワクしながら布団に入るうじゅうな……。  \n    \n  （明日からも頑張ろう……）  \n    \n  そう思った矢先、爆死し、転生してしまううじゅうな。  \n    \n  念願の転生は思っていたのとは、なんか違うようで……。  \n    \n  その転生先はあなたの目で見届けてほしい。",
                "image": "https://storage.googleapis.com/uju-explosion/images/8380.png",
                "attributes": [
                    {
                        "value": "Tegaki",
                        "trait_type": "Base"
                    },
                    {
                        "value": "Knight",
                        "trait_type": "1st panel"
                    },
                    {
                        "trait_type": "1st panel option",
                        "value": "None"
                    },
                    {
                        "trait_type": "2nd panel",
                        "value": "Boss"
                    },
                    {
                        "value": "None",
                        "trait_type": "2nd panel option"
                    },
                    {
                        "trait_type": "3rd panel",
                        "value": "Fall"
                    },
                    {
                        "value": "Nobuyuki",
                        "trait_type": "3rd panel option"
                    },
                    {
                        "trait_type": "4th panel",
                        "value": "Reincarnation"
                    },
                    {
                        "trait_type": "4th panel option",
                        "value": "Sailor suit uncle"
                    },
                    {
                        "value": "Massage8",
                        "trait_type": "Massage"
                    }
                ]
            }
        },
        {
            "name": "One day,Ujuuna killed in explosion, and his reincarnation is decided at generative.",
            "amount": 1,
            "metadata": {
                "name": "Ten Uju Gene #08260",
                "description": "ある日、イケハヤさんと対談し、未来にワクワクしながら布団に入るうじゅうな……。  \n    \n  （明日からも頑張ろう……）  \n    \n  そう思った矢先、爆死し、転生してしまううじゅうな。  \n    \n  念願の転生は思っていたのとは、なんか違うようで……。  \n    \n  その転生先はあなたの目で見届けてほしい。",
                "image": "https://storage.googleapis.com/uju-explosion/images/8260.png",
                "attributes": [
                    {
                        "trait_type": "Base",
                        "value": "Tegaki silver"
                    },
                    {
                        "trait_type": "1st panel",
                        "value": "Knight"
                    },
                    {
                        "value": "None",
                        "trait_type": "1st panel option"
                    },
                    {
                        "value": "UFO",
                        "trait_type": "2nd panel"
                    },
                    {
                        "trait_type": "2nd panel option",
                        "value": "Kiyoshi"
                    },
                    {
                        "trait_type": "3rd panel",
                        "value": "Sentaku"
                    },
                    {
                        "value": "None",
                        "trait_type": "3rd panel option"
                    },
                    {
                        "trait_type": "4th panel",
                        "value": "God"
                    },
                    {
                        "trait_type": "4th panel option",
                        "value": "Uju2"
                    },
                    {
                        "trait_type": "Massage",
                        "value": "Massage13"
                    }
                ]
            }
        }
    ]
}
    """
