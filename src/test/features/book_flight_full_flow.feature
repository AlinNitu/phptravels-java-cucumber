Feature: Book flight for the full next week and assert it was correctly saved in Admin bookings panel

  Background: User Login
    Given   User navigates to home page
    And     User clicks on the my account drop-down button
    And     User clicks on the login button on home page
    And     User enters valid username
    And     User enters valid password
    When    User clicks on the login button
    Then    User is successfully logged in

  @flight
  Scenario: Search for return flights for the full next week for one adult and verify it was saved correctly in Admin panel
    Given   User clicks on the home button on top menu
    And     User clicks on the flights button
    And     User selects return flight option
    And     User selects a flight departing from "SXF" and arriving at "JFK"
    And     Set departure date as next Monday
    And     Set departure date as next Sunday
    And     The booking is for 1 adults and 0 children and 0 infants
    When    Click the Search flights button to navigate to flights selection

    Given   User selects flight with minimum amount of stops
    And     User fills required personal information
    And     User fills credit card information
    When    User accepts terms and successfully submits checkout form

    Given   User navigates to Admin login page
    And     User enters valid Admin username
    And     User enters valid Admin password
    When    User clicks on the Admin login button
    Then    User is successfully logged in Admin home page

    Given   User navigates to flights bookings
    Then    Booking id in admin page is the same as booking number in invoice page
    And     In Admin panel departure flight is "SXF" and arriving flight is "JFK"
    And     In Admin panel the departure date is next Monday
    And     In admin panel the arriving date is next Sunday
    And     In admin panel the booking is for 1 adults and 0 children and 0 infants
