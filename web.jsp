<%@page import="iCalGenerator.ParseUzSite"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Your own iCalGenerator!</title>
	<script type="text/javascript" src="iCal.js"></script>	
	<script type="text/javascript" src="clean.js"></script>
	<script type="text/javascript" src="help.js"></script>
	<link rel= stylesheet href= "style.css" type="text/css" />
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var text="lab";
			$('#loadFromUzButton').click(function(event){
				$('#url').show();
				$('#submit').show();
				$('#submit').click(function(event2) {
					var userAddress = $('#url').val();
					$.get('ActionServlet', {url:userAddress}, function(responseText) {
						var size = responseText.charAt(0);
						responseText = responseText.substring(1, responseText.length);
						var dateStart;
						var dateEnd;
						var name;
						show();
						for(var i = 1; i <= size; i++) {
							dateStart = responseText.substring(0, responseText.indexOf(" - "));
							dateEnd = responseText.substring(responseText.indexOf(" - ")+3,responseText.indexOf("   "));
							name = responseText.substring(responseText.indexOf("   ")+3, responseText.indexOf("\n"));
							responseText = responseText.substring(responseText.indexOf("\n")+1, responseText.length);
							$('#demo').text(responseText);
							$('#date'+i).val(dateStart);
							$('#dateEnd'+i).val(dateEnd);
							$('#title'+i).val(name);
							addEvent();
						}
					});
					
				});
			});
		});
	</script>
</head>
<body>
	<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>	
	<div id="page">
		<div id="clock"></div>
		<input type="button" onclick="show()" value="New" id="newButton" />
	    <input type="button" onclick="loadFromAnother()" value="Load from another site" id="loadFromAnotherButton"/>
	    <input type="button" value="Load from uz site" id="loadFromUzButton"/>
		<input type="button" onclick="loadFromFile()" value="Load from file" id="loadFromFile"/>
		<input type="button" onclick="cleanAll()" value="Clear" id="clearButton"/>
		<input type="button" onclick="helpMe()" value="Help" id="helpButton"/>
		<br/>
		<input type="text" id="url" placeholder="Type URL address" class="hidden"/>
		<input type="button" id="submit" value="Parse!" class="hidden"/>
		<br/>
		<div id="demo"></div>
		<div id="makingEvent" class="hidden" >
				<label>Title</label>
				
				<input type="text" id="title"/> 
				<label>Timezone</label>
				<select name="timezone">
					<option>Poland</option>
					<option>England</option>
					<option>DeutscheDog</option>
					<option>SwedenYes</option>
				</select>
				<%= request.getLocale() %>
				<br/><br/>
				
				<label for="date" class="test">Date</label>
				<br/>
				<input type="text" name="Date" id="date1"/>
				<input type="text" name="DateEnd" id="dateEnd1"/>
				<input type="text" name="title1" id="title1"/>
				<input type="button" onclick="editEvent(1)" value="edit" id="editEvent1">
				<input type="button" onclick="deleteEvent(1)" value="delete" id="deleteEvent1">
				<br/>
		</div>
		<input type="button" id="newButton2" onclick="addEvent()" value="New" class="hidden" />
		<br/><br/><br/>
		<input type="button" onclick="generateICal()" value="Generate iCal"  id="generateICalButton" class="hidden"/>
	</div>
</body>
</html>