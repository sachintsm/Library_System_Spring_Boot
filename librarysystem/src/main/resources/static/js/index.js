var settings = {
    "url": "http://localhost:8080/api/getall",
    "method": "GET"
};

$.ajax(settings).done(function (response) {
    console.log(response);
});