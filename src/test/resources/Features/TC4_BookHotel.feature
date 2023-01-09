@BookHotel
Feature: Verifying the Book Hotel Page of Adactin Hotel

  Scenario Outline: Verifying Book a Hotel Page of Adactin Hotel by entering all fields
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"
    And User should select all the fields "<Location>","<Hotels>", "<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"
    And User should select a hotel
    Then User should verify after select hotel name success message "Book A Hotel"
    And User should Book a Hotel "<FirstName>","<LastName>" ,"<Address>","<creditcardno>","<creditcardtype>","<expmonth>","<expyear>" and "<cvvno>"
      | creditcardno     | creditcardtype   | expmonth | expyear | cvvno |
      | 1234567899874123 | Master Card      | December |    2022 |   123 |
      | 1234567899874547 | VISA             | November |    2022 |   124 |
      | 1234567899874478 | American Express | Novembr  |    2022 |   125 |
      | 1234567899874741 | Other            | October  |    2022 |   126 |
    Then User should verify after booking success message "Booking Confirmation" and save the generated order ID

    Examples: 
      | username    | password       | Location | Hotels      | RoomType | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildPerRoom | FirstName | LastName | Address |
      | Mano220798 | MANO123 | Brisbane | Hotel Creek | Deluxe   | 4 - Four  | 07/10/2022  | 08/10/2022   | 2 - Two       | 2 - Two      | MANOJ    | KUMAR     | karur   |

  Scenario Outline: Verifying Book a Hotel Page of Adactin Hotel without entering any fields
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"
    And User should select all the fields "<Location>","<Hotels>", "<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"
    And User should select a hotel
    Then User should verify after select hotel name success message "Book A Hotel"
    And User should click book now without entering any fields
    Then User should verify without enter any fields while booking error message "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month", "Please Enter your Credit Card CVV Number"

    Examples: 
      | username    | password       | Location | Hotels      | RoomType     | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildPerRoom | Hotels      |
      | Mano220798 | MANO123 | Brisbane | Hotel Creek | Super Deluxe | 4 - Four  | 02/10/2022  | 04/10/2022   | 1 - One       | 2 - Two      | Hotel Creek |
