//alert(sessionStorage.getItem("x"));

$(document).ready(function(){
 $.get("/calculate", {expression:sessionStorage.getItem("x")}, function(data, status){
	$("#exp").val(data);
   // alert("Data: " + data + "\nStatus: " + status);
  });
});