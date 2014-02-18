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