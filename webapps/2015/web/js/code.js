var xmlhttp;

function validate() {
    var rate = Number(document.getElementById("rate").value);
    console.log(rate);
    if(isNaN(rate)) {
        document.getElementById("output").innerHTML = "This is not a valid number";
    }
    else {

        if(rate < 0 || rate > 10) {
            document.getElementById("output").innerHTML = "Range in 0-10";
        }
        else {
            document.getElementById("output").innerHTML = "<input type=\"submit\" value=\"Submit\">";
        }
    }
}

function loadDoc(url) {
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = onComplete;
    xmlhttp.open("GET", url, true);
    xmlhttp.send(null);
}

function onComplete(event) {
    if (xmlhttp.readyState == 4)
        writeContent(xmlhttp.responseText);
}

function writeContent(data) {
    document.getElementById("content").innerHTML = data;
}

function asyncLoadContent(url) {
    writeContent("Please Wait<br/>Loading...");
    loadDoc(url, writeContent);
}

function submit_form() {

    var form = document.getElementById("contactForm");
    var ok = true;

    if (form.name.value.length < 2) {
        ok = false;
        alert("Too short name.");
    }
    else if (form.email.value.length < 2) {
        ok = false;
        alert("Too short mail.");
    }
    else if (form.email.value.indexOf('@') < 0 || form.email.value.indexOf('.') < 0) {
        ok = false;
        alert("mail address doesn't comply to RFC-12349856145\nPlease read it and re-type accordingly :)");
    }

    return ok;
}