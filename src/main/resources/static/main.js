function movieFilter() 
{
  var input, filter, table, tr, td, i, txtValue;

  input = document.getElementById("input");

  filter = input.value.toUpperCase();

  table = document.getElementById("movie");

  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) 
  {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) 
	{
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) 
	  {
        tr[i].style.display = "";
      } 
	  else 
	  {
        tr[i].style.display = "none";
      }
    }       
  }
}

$(document).ready(function() {
  jQuery.fn.carousel.Constructor.TRANSITION_DURATION = 5000 
});



