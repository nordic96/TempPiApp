$(document).ready(function() {
	$(".td_loading").hide();
	
    $(document).ajaxStart(function () {
        $(".td_loading").show();
    }).ajaxStop(function () {
        $(".td_loading").hide();
    });
    
	document.getElementById("search_year").onchange = function() {
		$('#search_month').empty();
		populateMonth();
	}
	
	document.getElementById("search_month").onchange = function() {
		$('#search_date').empty();
		populateDate();
	}
});

function populateMonth() {
	var e = document.getElementById("search_year");
	var yearSelected = e.options[e.selectedIndex].value;
	
	if (!validate(yearSelected)) {
		console.log("year not selected properly..");
		//do nothing
	} else {
		console.log("selected year: " + yearSelected);
	    $.ajax({
	        url: "/TempPi/search/" + yearSelected,
	        type: "GET",
	        success: function(data) 
	        {
	        	var search_month = $('#search_month'), 
	        	option = "<option value='NONE' label='Select'/>";
	        	
	        	for(var i=0; i < data.length; i++) {
	        		console.log(data[i]);
	        		
	        		option = option + "<option value='" + data[i] + "'>" + data[i] + "</option>";
	        	}
	        	search_month.append(option);
	        	
	            console.log("sucess!");
	        },
	        error: function(e){
	            console.log("ERROR: ", e);
	        }
	    });		
	}
}

function populateDate() {
	var e = document.getElementById("search_year");
	var yearSelected = e.options[e.selectedIndex].value;
	
	var e2 = document.getElementById("search_month");
	var monthSelected = e2.options[e2.selectedIndex].value;
	
	if (!validate(yearSelected) || !validate(monthSelected)) {
		console.log("either year or month not selected properly..");
		//do nothing
	} else {
		console.log("selected year: " + yearSelected);
		console.log("selected month: " + monthSelected);
		
	    $.ajax({
	        url: "/TempPi/search/" + yearSelected + "/" + monthSelected,
	        type: "GET",
	        success: function(data) 
	        {
	        	var search_month = $('#search_date'), 
	        	option = "<option value='NONE' label='Select'/>";
	        	for(var i=0; i < data.length; i++) {
	        		console.log(data[i]);
	        		option = option + "<option value='" + data[i] + "'>" + data[i] + "</option>";
	        	}
	        	search_month.append(option);
	        	
	            console.log("sucess!");
	        },
	        error: function(e){
	            console.log("ERROR: ", e);
	        }
	    });		
	}

}

function validate(selectedValue) {
	if(selectedValue == 'NONE') {
		return false;
	} else {
		return true;
	}
}