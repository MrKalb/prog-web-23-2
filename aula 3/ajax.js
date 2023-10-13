// Definição do XMLHttpRequest
//let httpRequest = new XMLHttpRequest();

function makeRequest() {
    // Forma antiga de realizar o AJAX, forma pura em JS mesmo
    //httpRequest.onreadystatechange = getResponse; 
    //httpRequest.open("GET", "http://localhost:8080/v1/products")
    //httpRequest.send();
    fetchSomething(); 
} 


// Forma nova de realizar o JS
/*
* O fetch funciona como uma promise, uma promise é uma "promessa", ou seja, ele vai tentar buscar
* dado e ai vai te retornar, os metodos .then() e catch(), fazem isso, muitas vezes no console a
* requisição vai parecer parada mas ele executa em segundo plano e espera a resposta.
* O then() é o sucesso da requisição, enquanto o .catch() o tratamento do erro.
*
* Nesse caso, como não especificamos um Verbo HTTP (GET, POST, PUT ou DELETE), ele assume GET sempre
* */
function fetchSomething() {
    fetch("http://localhost:49559/v1/products").then(function(element) {
        // ao contrario da forma antiga, o elemento retornado na função já possui um metodo json
        // com o body já convertido em JSON.
        console.log(element.json()); 
        document.getElementById("paragrafo").textContent = element.json()[0].status;
    }).catch(function(err) {
        console.log(err)
    });
}


/*
* Forma antiga de tratar os erros e sucesso usando o XMLHttpRequest, aqui temos testar se a requisição
* foi enviada e se retornou alguma coisa, para cada codigo HTTP é preciso verificar se é erro ou sucesso
* */
function getResponse() {
    // verifica se a requisição está pronta e foi enviada
    if (httpRequest.readyState === 4) {
        // verifica se o status é OK = 200
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