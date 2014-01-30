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

function createMarker(point, htmlPointDescription) {

    var marker = new google.maps.Marker ({
        position: point,
        map: map,
        title: htmlPointDescription
    });
}

function getCoordinates() {
    $.getJSON("/focus_points", function (data) {

        var points = data;
        console.log(points);

        for (var i=0; i<points.length; i++)
        {
            var point = points[i];
            var pointToShowOnMap = new google.maps.LatLng(point.latitude, point.longitude);
            createMarker(pointToShowOnMap, "Our first point! :)")
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