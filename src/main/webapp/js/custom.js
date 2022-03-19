alert("I'm active");
var x;
$(document).ready(function(){
$("#subbtn").click(function(){
	 x = $('#exp').val();
	 sessionStorage.setItem("x", x);
});
});