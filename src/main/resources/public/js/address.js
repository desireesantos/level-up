function initialize() {
    geocoder = new google.maps.Geocoder();
    var latitudeAndLongitude = new google.maps.LatLng(-12.0716330, -77.0566020);
    var mapOptions = {
        zoom: 8,
        center: latitudeAndLongitude
    }

    var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

    function createMarker(point, htmlPointDescription) {
        var marker = new google.maps.Marker ({
           position: point,
           map: map,
           title: htmlPointDescription
        });
    }

    var points = [{latitude:-12.0716330, longitude:-77.0566020}, {latitude:-13.0716376, longitude:-78.0716330}];


    for (var i=0; i<points.length; i++)
    {
        var point = points[i];
        var pointToShowOnMap = new google.maps.LatLng(point.latitude, point.longitude);
        createMarker(pointToShowOnMap, "Our first point! :)")
    }

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