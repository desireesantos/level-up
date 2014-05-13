var pandas = pandas || {};

pandas.initialize = function() {
    var mapCenter = new L.LatLng(-12.0716330, -77.0566020);

    var mapOptions = {
        zoom: 3,
        center: mapCenter
    };

    pandas.map = new L.Map('map', mapOptions);
    var googleLayer = new L.Google('ROADMAP');
    pandas.map.addLayer(googleLayer);
    pandas.getCoordinates();

};

pandas.createMarker = function(coordinate, description){
    var marker = new L.Marker ({
        position: coordinate,
        title: description
    });
    marker.addTo(pandas.map);
};

pandas.getCoordinates = function() {
    var jsonFetcher = pandas.createJsonFetcher("/coordinates");
    jsonFetcher.fetch(drawCoordinatesOnMap);
};

function drawCoordinatesOnMap(coordinates) {

    for (var i = 0; i < coordinates.length; i++) {
        var coordinate = coordinates[i];
        var coordinateToShowOnMap = new L.LatLng(coordinate.latitude, coordinate.longitude);
        pandas.createMarker(coordinateToShowOnMap, "coordinate");
    }
}

$( function() {
    var geocoder = new google.maps.Geocoder();
    pandas.initialize(geocoder);
});