@CancelBooking
Feature: Verifying the Booked Itinerary Page of Adactin Hotel

  Scenario Outline: Verifying Booked Itinerary Page of Adactin Hotel by cancelling book order ID
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"
    And User should select all the fields "<Location>","<Hotels>", "<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"
    And User should select a hotel
    Then User should verify after select hotel name success message "Book A Hotel"
    And User should Book a Hotel "<firstName>","<lastName>" ,"<billingAddress>","<creditcardno>","<creditcardtype>","<expmonth>","<expyear>" and "<cvvno>"
      | creditcardno     | creditcardtype   | expmonth | expyear | cvvno |
      | 1234567899874123 | Master Card      | December |    2022 |   123 |
      | 1234567899874547 | VISA             | November |    2022 |   124 |
      | 1234567899874478 | American Express | Novembr  |    2022 |   125 |
      | 1234567899874741 | Other            | October  |    2022 |   126 |
    Then User should verify after booking success message "Booking Confirmation" and save the generated order ID
    And User should verify success message after cancel generated order id "The booking has been cancelled."

    Examples: 
      | username   | password | Location | Hotels      | RoomType | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildPerRoom | firstName | lastName | billingAddress |
      | Mano220798 | MANO123  | Brisbane | Hotel Creek | Deluxe   | 4 - Four  | 07/10/2022  | 08/10/2022   | 2 - Two       | 2 - Two      | guna      | diva     | salem          |

  Scenario Outline: Verifying Booked Itinerary Page of Adactin Hotel by cancelling the existing order ID
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"
    And User should cancel existing order ID "<orderID>"
    And User should verify success message after cancel existing order id "The booking has been cancelled."

    Examples: 
      | username   | password | orderID    |
      | Mano220798 | MANO123  | 14MJW614F5 |
