var pandas = pandas || {};

pandas.initialize = function() {
    var mapCenter = new L.LatLng(-12.0716330, -77.0566020);

    var mapOptions = {
        zoom: 4,
        center: mapCenter
    };

    pandas.map = new L.Map('map', mapOptions);
    var googleLayer = new L.Google('ROADMAP');

    pandas.getCoordinates();
    pandas.map.addLayer(googleLayer);

};

pandas.paintHeatmap = function(coordinates, description){
    var heatmapLayer = L.heatLayer(coordinates, {radius: 30});
    heatmapLayer.addTo(pandas.map);
};

pandas.getCoordinates = function() {
    var jsonFetcher = pandas.createJsonFetcher("/coordinates");
    jsonFetcher.fetch(drawCoordinatesOnMap);
};

function drawCoordinatesOnMap(coordinates) {

    var coordinate;
    var coordinatesToShowOnMap = [];
    for (var i = 0; i < coordinates.length; i++) {
        coordinate = coordinates[i];
        coordinatesToShowOnMap.push(new L.LatLng(coordinate.latitude, coordinate.longitude));

    }
    pandas.paintHeatmap(coordinatesToShowOnMap, "coordinate");
}

$( function() {
    var geocoder = new google.maps.Geocoder();
    pandas.initialize(geocoder);
});