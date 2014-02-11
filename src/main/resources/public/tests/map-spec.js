describe("JsonFetcher", function() {
    it("fetch points from server ", function(){
        spyOn($, "getJSON");
        var callback = function (pointsJson) {
           console.log(pointsJson);
        };
        var url = "/coordinates";
        var jsonFetcher = pandas.createJsonFetcher(url);
        jsonFetcher.fetch(callback);

        expect($.getJSON).toHaveBeenCalledWith(url, callback);
    });
});

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




