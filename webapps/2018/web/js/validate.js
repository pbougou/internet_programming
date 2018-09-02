function validate() {
    var input = document.getElementById("number").value;
    if(isNaN(input)) {
        document.getElementById("output").innerHTML = "This is not a valid number";
    }
    else {
        document.getElementById("output").innerHTML = "<input type=\"submit\" value=\"Submit\">\n</input>";
    }
}