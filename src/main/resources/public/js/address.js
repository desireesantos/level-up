function initialize() {
    geocoder = new google.maps.Geocoder();

    var mapCenter = new google.maps.LatLng(-12.0716330, -77.0566020);

    var mapOptions = {
        zoom: 2,
        center: mapCenter
    }

    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

    getCoordinates();

}

function createMarker(coordinate, description) {

    var marker = new google.maps.Marker ({
        position: coordinate,
        map: map,
        title: description
    });
}

function getCoordinates() {
    $.getJSON("/coordinates", function (coordinates) {

        for (var i=0; i<coordinates.length; i++)
        {
            var coordinate = coordinates[i];
            var coordinateToShowOnMap = new google.maps.LatLng(coordinate.latitude, coordinate.longitude);
            createMarker(coordinateToShowOnMap, "coordinate")
        }
    });
}


function goToAddress() {
    var address = document.getElementById("address").value;
    geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location
            });
        } else {
            alert("Geocode was not successful for the following reason: " + status);
        }
    });
}

google.maps.event.addDomListener(window, 'load', initialize);