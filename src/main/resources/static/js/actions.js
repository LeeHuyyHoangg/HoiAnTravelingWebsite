function showAlert(message) {
    alert(message);
}

function getRandom(name){
    return httpGet("http://localhost:8080/data/randomData/" + name);
}

function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}

function openInNewTab(url) {
 window.open(url, '_blank').focus();
}

function smt()
{
    var el = document.getElementById('content');
    var name = document.getElementById('name').value;
    if(name === ''){
        content.innerHTML = '<h1>Name cant be null</h1>';
    } else {
        content.innerHTML = '<h1>Hello ' + name + '</h1>';
    }
}