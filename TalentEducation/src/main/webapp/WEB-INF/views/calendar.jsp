<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Full Calendar</title>
</head>

	<link rel="stylesheet" href="resources/css/fullcalendar.css">
	<link rel="stylesheet" href="resources/css/fullcalendar.min.css">
	<link rel="stylesheet" href="resources/css/main.css">

  	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  	<script src="resources/js/bootstrap.min.js"></script>
  	<script src="resources/js/moment.min.js"></script>
   	<script src="resources/js/fullcalendar.min.js"></script>
   	<script src="resources/js/ko.js"></script>
   	<script src="resources/js/select2.min.js"></script>
   	<script src="resources/js/bootstrap-datetimepicker.min.js"></script>
   
   	<script type="text/javascript">
    	$(function(){
    		$("#calendar").fullCalendar({
    			
    			header: {
    		        left: 'prev,next today',
    		        center: 'title',
    		        right: 'month,agendaWeek,agendaDay'
    		    }
    		});
    	});
    
    </script>
<body>
	
	<div id="wrapper">
		<div id="loading"></div>
		<div id="calendar"></div>
	</div>

</body>
</html>










