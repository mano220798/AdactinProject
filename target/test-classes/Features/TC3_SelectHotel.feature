@SelectHotel
Feature: Verifying the Select Hotel Page of Adactin Hotel

  Scenario Outline: Verifying Select Hotel Page of Adactin Hotel by entering all fields
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"
    And User should select all the fields "<Location>","<Hotels>", "<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"
    And User should select a hotel
    Then User should verify after select hotel name success message "Book A Hotel"

    Examples: 
      | username   | password | Location | Hotels      | RoomType | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildPerRoom |
      | Mano220798 | MANO123  | Brisbane | Hotel Creek | Deluxe   | 4 - Four  | 02/10/2022  | 04/10/2022   | 2 - Two       | 2 - Two      |

  Scenario Outline: Verifying Select Hotel Page of Adactin Hotel without selecting hotel
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"
    And User should select all the fields "<Location>","<Hotels>", "<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"
    And User should click continue without select any hotel name
    Then User shoudld verify without select any hotel name error message "Please Select a Hotel"

    Examples: 
      | username   | password | Location | Hotels      | RoomType     | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildPerRoom |
      | Mano220798 | MANO123  | Brisbane | Hotel Creek | Super Deluxe | 4 - Four  | 02/10/2022  | 04/10/2022   | 1 - One       | 2 - Two      |
