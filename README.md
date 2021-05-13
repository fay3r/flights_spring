# flights_spring
recruit task

calculates basic info about airports, flights using data in database.

<h2>Backend:</h2><br>
Spring, Hibernate, Maven, Facade <br>

| Method  |       URL                    |  Request Params                          | Response body | Comment|
| ------------- | ------------- | ------------- | ------------- | ------------- | 
| GET | /flights/airport_details?airportCode= &date=  | airportCode (3 letter code), date (yyyy-mm-dd) | { "numberOfDeparts":"", "numberOfArrives":"", "numberOfArrivedPieces":"", "numberOfDepartedPieces":""} | using passed parameters, returns details about airport at this day |
| GET | /flights/flight_details?flightNumber= &date=  | flightNumber (4 digit number), date (yyyy-mm-dd) |{ "cargoWeight":"", "baggageWeight":"", "totalWeight":"", "weightUnit":"" } | using passed parameters, return details about flight with that number at this day |
<br>
<br>
<h2>FrontEnd</h2><br>
<img src="https://github.com/fay3r/flights_spring/blob/master/img/1.png?raw=true"><br>
<img src="https://github.com/fay3r/flights_spring/blob/master/img/2.png?raw=true">
