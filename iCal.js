var eventId = 1;
var person;
var script = document.createElement('script');
script.src = 'https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);

function loadFromAnother() {
	person = prompt("Type URL Address to parse");
}


//	var xhttp = new XMLHttpRequest();
//	  xhttp.onreadystatechange = function() {
//	    if (xhttp.readyState == 4 && xhttp.status == 200) {
//	     document.getElementById("demo").innerHTML = xhttp.responseText;
//	    }
//	  };
//	  xhttp.open("GET", "test.jsp?fname=Henry&lname=Ford", false);
//	  xhttp.send();


function editEvent(inputId) {
	var dateElement = document.getElementById("date"+inputId);
	var dateEndElement = document.getElementById("dateEnd"+inputId);
	var titleElement = document.getElementById("title"+inputId);
	
	if(dateElement.disabled) {
		dateElement.disabled = false;
		dateEndElement.disabled = false;
		titleElement.disabled = false;
		}
	else {
		dateElement.disabled = true;
		dateEndElement.disabled = true;
		titleElement.disabled = true;
	}
}

function deleteEvent(inputId) {
	var dateElement = document.getElementById("date"+inputId);
	var dateEndElement = document.getElementById("dateEnd"+inputId);
	var titleElement = document.getElementById("title"+inputId);
	var editEventButtonElement = document.getElementById("editEvent"+inputId);
	var deleteEventButtonElement = document.getElementById("deleteEvent"+inputId);
	
	dateElement.parentNode.removeChild(dateElement);
	dateEndElement.parentNode.removeChild(dateEndElement);
	titleElement.parentNode.removeChild(titleElement);
	editEventButtonElement.parentNode.removeChild(editEventButtonElement);
	deleteEventButtonElement.parentNode.removeChild(deleteEventButtonElement);
}


function show() {
	var divElement = document.getElementById("makingEvent");
	divElement.style.display = "inline";
	var newButtonElement = document.getElementById("newButton");
	newButtonElement.disabled = true;
	var newButton2Element = document.getElementById("newButton2");
	newButton2Element.style.display = "inline";
	var generateICalButtonElement = document.getElementById("generateICalButton");
	generateICalButtonElement.style.display = "inline";
	}

function addEvent() {

	var dateField = document.getElementById("date"+eventId);
	var dateEndField = document.getElementById("dateEnd"+eventId);
	var titleField = document.getElementById("title"+eventId);
	
	eventId++;
	
	dateField.disabled = true;
	dateEndField.disabled = true;
	titleField.disabled = true;
	
	var newDateField = document.createElement('div');
	newDateField.innerHTML = 
			" <input type='text' name='date' " +"id='date"+eventId+"'\>" +
			" <input type='text' name='dateEnd' id='dateEnd"+eventId+"'\>" +
			" <input type='text' name='title' id='title"+eventId+"'\>" +
			" <input type='button' onclick='editEvent("+eventId+")' value='edit' id='editEvent"+eventId+"'\>" +
			" <input type='button' onclick='deleteEvent("+eventId+")' value='delete' id='deleteEvent"+eventId+"'\>";
	document.getElementById("makingEvent").appendChild(newDateField)
}

function counter() {

	var date = new Date();
	
	var day = date.getDate();
	var month = date.getMonth()+1;
	var year = date.getFullYear();
	
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var seconds = date.getSeconds();
	
	if(hours < 10) hours = '0' + hours;
	if(minutes < 10) minutes = '0' + minutes;
	if(seconds < 10) seconds = '0' + seconds;
	
	document.getElementById("clock").innerHTML = hours+":"+minutes+":"+seconds;
	setTimeout("counter()", 1000);
}

window.onload = counter;