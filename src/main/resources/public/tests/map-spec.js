describe("Map Loader", function() {
    it("defines the map", function(){
        spyOn(google.maps,"Map");
        spyOn(pandas, "getCoordinates");

        expect(pandas.map).toBeUndefined();

        pandas.initialize();

        expect(pandas.map).toBeDefined();
        expect(google.maps.Map).toHaveBeenCalled();
        expect(pandas.getCoordinates).toHaveBeenCalled();
    });

    // make sure call center map when initialize
    // make sure center the map of brazil coordinates


    it("center the map when initialize", function(){
        spyOn(pandas, "centerMap");
        spyOn(google.maps, "Map");

        pandas.initialize();

        expect(pandas.centerMap).toHaveBeenCalled();
        expect(pandas.centerMap).toHaveBeenCalledWith(pandas.map, "Brazil");
    });

    it("center the map on Brazil using Geocoder", function(){
        var myFakeMap = { setCenter: function(){}};
        var brLocation = "fake Brazil location";
        var geocoder = {
            geocode: function (target, callback) {
                var result = [
                    {geometry: {location: brLocation}}
                ];
                var status = google.maps.GeocoderStatus.OK;
                callback(result, status);
            }
        };

        spyOn(google.maps,"Map").and.returnValue(myFakeMap);
        spyOn(myFakeMap,"setCenter");
        pandas.initialize(geocoder);
        expect(pandas.map.setCenter).toHaveBeenCalledWith(brLocation);
    });
});






