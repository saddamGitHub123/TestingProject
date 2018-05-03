<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://www.gstatic.com/firebasejs/4.13.0/firebase.js"></script>
<!-- <script src="https://www.gstatic.com/firebasejs/4.13.0/firebase-messaging.js"></script> -->

<%-- <link rel="manifest" href="<c:url value="/views/manifest.json" />" > --%>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyCfSGIddRKKvxDa0kpKM8zbSB9nikFAZpI",
    authDomain: "testapi-202905.firebaseapp.com",
    databaseURL: "https://testapi-202905.firebaseio.com",
    projectId: "testapi-202905",
    storageBucket: "testapi-202905.appspot.com",
    messagingSenderId: "522135343939"
  };
  firebase.initializeApp(config);
  
 /*  <link rel="manifest" href="/manifest.json"> */
  
//Retrieve Firebase Messaging object.
  const messaging = firebase.messaging();
  messaging.requestPermission().then(function() {
	  console.log('Notification permission granted.');
	  return messaging.getToken();
	})
	.then(function(token){
		console.log(token);
	})
	.catch(function(err) {
	  console.log('Unable to get permission to notify.', err);
	});
  
  
 
  
</script>
</head>
<body>
<p>this push notification used </p>
</body>
</html>