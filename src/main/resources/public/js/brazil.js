
function drawMap() {
    var data = google.visualization.arrayToDataTable([
        ['Country', 'Popularity'],
        ['Brazil', 800]
    ]);

    var options = {};
    options['dataMode'] = 'regions';

    var container = document.getElementById('map_canvas');
    var geomap = new google.visualization.GeoMap(container);
    geomap.draw(data, options);
};

google.load('visualization', '1', {'packages': ['geomap']});
google.setOnLoadCallback(drawMap);