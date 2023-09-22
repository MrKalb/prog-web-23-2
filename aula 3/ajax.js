let httpRequest = new XMLHttpRequest(); 

function makeRequest() {
    httpRequest.onreadystatechange = getResponse; 
    httpRequest.open("GET", "http://localhost:8080/v1/products")
    httpRequest.send();
} 

function fetchSomething() {
    fetch("http://localhost:8080/v1/products").then(function(element) {
        let elementJson = JSON.parse(element.body); 
    }).catch(function() {

    });
}

function getResponse() {
    if (httpRequest.readyState === 4) {
        if (httpRequest.status === 200) {
            let body = JSON.parse(httpRequest.responseText);
            body.key = 3; 
            body.key4.key1;
            body.key5.forEach(element => {
                element.key1 = 1; 
            });
        }
    }
}