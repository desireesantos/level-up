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
    });

    it("should add markers to the map", function () {
        spyOn(pandas, "getCoordinates");

        pandas.initialize();

//        var marker = jasmine.createSpyObj("fakeMarker", "addTo");
//        L.Marker = function () {
//            return marker;
//        };

        spyOn(L, "Marker").andReturn(jasmine.createSpyObj("fakeMarker", ["addTo"]));
        pandas.createMarker([-14.2400732, -53.1805018], 'description');

        expect(L.Marker).toHaveBeenCalled();
    });
});






