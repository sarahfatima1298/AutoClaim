var items = {
	"payments": "paid",
	"claimstatus":"success",	
	"id":"2017456-1"
}

function login(){
	var username= document.getElementById('user').value;
	var password = document.getElementById('pw').value;
	if(username === "john" && password ==="12345"){
		window.location="homePage.html";

	}else{
		document.getElementById('user').value='';
		document.getElementById('pw').value='';
		document.getElementById('error').innerHTML='login failed , try agin';
		
	}
}
function loadData(){
	console.log('inside load data');
//	     $( '#claimstatus' ).val(items.claimstatus);				
//		 $("#payments").val(items.payments);
//		 $("#claimno").val(items.id);
	$.ajax({
		 type : "GET", 
		  url : "list", 
		 contentType: "application/json",
		 success : function(result) {
				   $("#claimno").val(result.id);
			       $( '#claimstatus' ).val(result.claimstatus);				
				   $("#payments").val(result.payments);
				   $("#incidentdate").val(result.incidentdate);
				   $("#reporteddate").val(result.reporteddate);
				   $("#incidenttype").val(result.incidenttype);
				   $("#year").val(result.year);
				   $("#make").val(result.make);
				   $("#model").val(result.model);
				   $("#vin").val(result.vin);
				   $("#driver").val(result.driver);
				   $("#contactnumber").val(result.contactnumber);
				   $("#email").val(result.email);
				   $("#policynumber").val(result.policynumber);
				   $("#policytype").val(result.policytype);
				 
		 }, 
		 error : function(result) { 
		    console.log("error === "+result );
		 }	
 
	 });
		 
}
