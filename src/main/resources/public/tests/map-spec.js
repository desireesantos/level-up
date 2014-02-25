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

    it("center the map on Brazil", function(){
        pandas.centerMap(pandas.map, "Brazil");

        var latitudeBR = 11.897013135795008;
        var longitudeBR = -51.92527999999999;

        expect(pandas.map.getCenter().lng()).toBe(longitudeBR);
        expect(pandas.map.getCenter().lat()).toBe(latitudeBR);
    });

});






