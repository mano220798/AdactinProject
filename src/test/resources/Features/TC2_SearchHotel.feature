@SearchHotel
Feature: Verifying the Search Hotel Page of Adactin Hotel

  Scenario Outline: Verifying Search Hotel Page of Adactin Hotel with valid credentails
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"
    And User should select all the fields "<Location>","<Hotels>", "<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"

    Examples: 
      | username   | password | Location | Hotels      | RoomType     | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildPerRoom |
      | Mano220798 | MANO123  | Brisbane | Hotel Creek | Super Deluxe | 4 - Four  | 02/12/2022  | 04/12/2022   | 2 - Two       | 2 - Two      |

  Scenario Outline: Verifying Search Hotel Page of Adactin Hotel by Entering only the mandatory fields
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"
    And User should enter only the mandatory fields  "<Location>", "<NoOfRooms>", "<CheckInDate>","<CheckOutDate>" and "<AdultsPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"

    Examples: 
      | username   | password | Location | Hotels      | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom |
      | Mano220798 | MANO123  | Brisbane | Hotel Creek | 4 - Four  | 02/12/2022  | 04/12/2022   | 2 - Two       |

  Scenario Outline: Verifying Search Hotel Page of Adactin Hotel by Invalid date
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"
    And User should select all the fields "<Location>","<Hotels>", "<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildPerRoom>"
    Then User should verify Check In date and Check Out date error message after search hotel "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username   | password | Location | Hotels      | RoomType     | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildPerRoom |
      | Mano220798 | MANO123  | Brisbane | Hotel Creek | Super Deluxe | 4 - Four  | 08/12/2022  | 06/04/2022   | 2 - Two       | 2 - Two      |

  Scenario Outline: Verifying Search Hotel Page of Adactin Hotel without selecting any of the fields
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"
    And User should search hotel without entering the fields
    Then User should verify error message after search "Please select a Location"

    Examples: 
      | username   | password |
      | Mano220798 | MANO123  |
