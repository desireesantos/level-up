describe("Map Loader", function () {
    beforeEach(function () {
        var fakeMap = { addLayer: function () {
        }};
        spyOn(L, "Map").and.returnValue(fakeMap);
        spyOn(L, "Google");
    });

    it("defines the map", function () {
        spyOn(pandas, "getCoordinates");

        expect(pandas.map).toBeUndefined();

        pandas.initialize();

        expect(pandas.map).toBeDefined();
        expect(pandas.getCoordinates).toHaveBeenCalled();
    })
});






