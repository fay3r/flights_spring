const api_url =
    "http://localhost:8080/flights/";

let today = new Date().toISOString().substr(0, 10);
document.querySelector("#today").value = today;
document.querySelector("#today2").value = today;


function findAirportDetails() {
    let airportCode = document.querySelector("#airportCode").value
    let date = document.querySelector("#today2").value
    let table = document.querySelector("#tableForDetails")

    let url = api_url + "airport_details?airportCode=" + airportCode + "&date=" + date

    fetch(url, {
        method: 'GET'
    })
        .then(response => {
            return response.json()
        })
        .then(json => {
            let HTML
            if (json.numberOfArrives != 0 || json.numberOfDeparts != 0 || json.numberOfArrivedPieces != 0 || json.numberOfDepartedPieces != 0) {
                HTML = "<p class=\"text-center\" style=\"font-size:15px\"><strong>Airport code: " + airportCode + "</strong></p>"
                HTML += "<p class=\"text-center\" style=\"font-size:15px\"><strong>Date: " + date + "</strong></p>"
                HTML += "<table class=\"table table-sm\"><tr>";
                HTML += "<th>Number of departures</th> <th>Number of arrivals</th> <th>Number Of Arrived Pieces</th> <th>Number Of Dep Pieces</th>";
                HTML += "<tr class=\"table-info\"><td>" + json.numberOfDeparts + "</td>" +
                    "<td>" + json.numberOfArrives + "</td>" +
                    "<td>" + json.numberOfArrivedPieces + "</td>" +
                    "<td>" + json.numberOfDepartedPieces + "</td></tr>";
                HTML += "</table>";
            } else {
                HTML = "<p class=\"text-center\" style=\"font-size:30px\" ><strong>No information about this airport, check details!</strong></p>"
            }
            table.innerHTML = HTML

        })
        .catch((error) => console.error(error))
}

function findFlightDetails() {
    let flightNumber = document.querySelector("#flightNumber").value
    let date = document.querySelector("#today").value
    let table = document.querySelector("#tableForDetails")

    let url = api_url + "flight_details?flightNumber=" + flightNumber + "&date=" + date
    console.log(url)
    fetch(url, {
        method: 'GET'
    })
        .then(response => {
            return response.json()
        })
        .then(json => {
            let HTML;
            if (json.baggageWeight != null) {
                HTML = "<p class=\"text-center\" style=\"font-size:15px\"><strong>Flight number: " + flightNumber + " </strong></p>"
                HTML += "<p class=\"text-center\" style=\"font-size:15px\"><strong>Date: " + date + "</strong></p>"
                HTML += "<table class=\"table table-sm\"><tr>";
                HTML += "<th>Cargo Weight</th> <th>Baggage Weight</th> <th>Total Weight</th> <th>Weight Unit</th>";
                HTML += "<tr class=\"table-info\"><td>" + json.cargoWeight + "</td>" +
                    "<td>" + json.baggageWeight + "</td>" +
                    "<td>" + json.totalWeight + "</td>" +
                    "<td>" + json.weightUnit + "</td></tr>";
                HTML += "</table>";
            } else {
                HTML = "<p class=\"text-center\" style=\"font-size:30px\"><strong>No information about this flight, check details!</strong></p>"
            }
            table.innerHTML = HTML

        })
        .catch((error) => console.error(error))
}
