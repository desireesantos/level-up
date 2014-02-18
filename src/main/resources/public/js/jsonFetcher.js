var pandas = pandas || {};
pandas.createJsonFetcher = function (url){
    return {
        fetch : function (callBack){
            $.getJSON(url, callBack);
        }
    };
}