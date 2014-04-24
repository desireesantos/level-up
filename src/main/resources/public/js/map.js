var pandas = pandas || {};

pandas.initialize = function(geocoder) {
    var mapCenter = new L.LatLng(-12.0716330, -77.0566020);

    var mapOptions = {
        zoom: 3,
        center: mapCenter
    };

    var centerMap = function(map, country, geocoder){
        geocoder.geocode( {'address' : country}, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                map.setCenter(results[0].geometry.location);
            }
        });
    };

    pandas.map = new L.map('map', mapOptions);
    var googleLayer = new L.Google('ROADMAP');
    pandas.map.addLayer(googleLayer);
   // centerMap(pandas.map, "Brazil", geocoder);
    pandas.getCoordinates();
};

function createMarker(coordinate, description) {
    var marker = new L.Marker ({
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
        var coordinateToShowOnMap = new L.LatLng(coordinate.latitude, coordinate.longitude);
        createMarker(coordinateToShowOnMap, "coordinate");
    }
}

$( function() {
    var geocoder = new google.maps.Geocoder();
    pandas.initialize(geocoder);
});