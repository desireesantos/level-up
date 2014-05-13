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

    describe('when adding markers to the map', function (){
        var realMarker;
        var fakeConstructedMarker = jasmine.createSpyObj('fakeConstructedMarker',['addTo']);
        var fakeMarker = function () {
                        return fakeConstructedMarker;
                    };

        beforeEach(function () {
                    realMarker = L.Marker;
                    L.Marker = fakeMarker;
        });
        afterEach(function(){
                L.Marker = realMarker;
        });

        it("adds markers to the map", function () {
            pandas.createMarker([-14.2400732, -53.1805018], 'description');
            expect(fakeConstructedMarker.addTo).toHaveBeenCalled();
        });
    });
});






