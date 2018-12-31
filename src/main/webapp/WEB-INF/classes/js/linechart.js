google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawBackgroundColor);
window.onresize = function(){
    drawBackgroundColor();
};

function formatTimeOfDay(time) {
	var arr = time.split(":").map(Number);
	return arr;
}

function drawBackgroundColor() {
      var data = new google.visualization.DataTable();
      //var searchResult = "${searchResultJson}";
      searchResult = JSON.parse(searchResult);
      data.addColumn('timeofday', 'Time');
      data.addColumn('number', 'Temp');

      for (var i = 0; i < searchResult.length; i++) {
    	  data.addRow([formatTimeOfDay(searchResult[i].rec_time), 
    		  searchResult[i].temp]);
      }

      var options = {	  
	    hAxis: {
	      title: 'Time'
	    },
	    vAxis: {
	      title: 'Temperature'
	    },
	    width: '100%',
	    height: '250'
      };

      var chart = new google.visualization.LineChart(document.getElementById('tempLineChart'));
      chart.draw(data, options);
    }