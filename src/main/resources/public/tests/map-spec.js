describe("Map Loader", function() {
    it("Define the map", function(){
        spyOn(google.maps,"Map");
        spyOn(pandas, "getCoordinates");

        expect(pandas.map).toBeUndefined();

        pandas.initialize();

        expect(pandas.map).toBeDefined();
        expect(google.maps.Map).toHaveBeenCalled();
        expect(pandas.getCoordinates).toHaveBeenCalled();
    });
});




