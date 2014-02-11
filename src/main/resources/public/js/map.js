var pandas = pandas || {};

pandas.initialize = function() {
    geocoder = new google.maps.Geocoder();

    var mapCenter = new google.maps.LatLng(-12.0716330, -77.0566020);

    var mapOptions = {
        zoom: 2,
        center: mapCenter
    }

    pandas.map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

    pandas.getCoordinates();
}

function createMarker(coordinate, description) {
    var marker = new google.maps.Marker ({
        position: coordinate,
        map: pandas.map,
        title: description
    });
}

pandas.getCoordinates = function() {
    var jsonFetcher = pandas.createJsonFetcher("/coordinates");
    jsonFetcher.fetch(drawCoordinatesOnMap);
}

function drawCoordinatesOnMap(coordinates) {
    for (var i = 0; i < coordinates.length; i++) {
        var coordinate = coordinates[i];
        var coordinateToShowOnMap = new google.maps.LatLng(coordinate.latitude, coordinate.longitude);
        createMarker(coordinateToShowOnMap, "coordinate");
    }
}

google.maps.event.addDomListener(window, 'load', pandas.initialize);