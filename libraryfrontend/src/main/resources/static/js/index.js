// http://localhost:8080/api/getall

var http = new XMLHttpRequest();
var uri = "http://localhost:8081/api";
function getBooksData() {
    http("GET", uri+"/getall", true);
    http.onreadystatechange = getBooks();
    http.send();
}
function getBooks() {
    if (http.status ===200 && http.readyState === 4) {
        document.getElementById('bookList').innerHTML = http.responseText;
    }else{
        // noinspection JSAnnotator
        document.getElementById('bookList') = "<strong>Waiting for response...!</strong>";
    }
}