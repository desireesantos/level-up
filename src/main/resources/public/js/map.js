var pandas = pandas || {};

pandas.initialize = function(map, geocoder) {
    var mapCenter = new google.maps.LatLng(-12.0716330, -77.0566020);

    var mapOptions = {
        zoom: 3,
        center: mapCenter
    }

    pandas.map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    pandas.centerMap(pandas.map, "Brazil");
    pandas.getCoordinates();
};

pandas.centerMap = function(map, country){
    geocoder = new google.maps.Geocoder();

    geocoder.geocode( {'address' : country}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location);
        }
    });
};


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
};

function drawCoordinatesOnMap(coordinates) {

    for (var i = 0; i < coordinates.length; i++) {
        var coordinate = coordinates[i];
        var coordinateToShowOnMap = new google.maps.LatLng(coordinate.latitude, coordinate.longitude);
        createMarker(coordinateToShowOnMap, "coordinate");
    }
}

google.maps.event.addDomListener(window, 'load', pandas.initialize);