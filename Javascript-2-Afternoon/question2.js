function validateForm() {
  var fname = document.forms["myForm"]["fname"].value;
  var mname = document.forms["myForm"]["mname"].value;
  var lname= document.forms["myForm"]["lname"].value;
  var mail = document.forms["myForm"]["mailid"].value;
  var gender = document.forms["myForm"]["gender"].value;
  var branch = document.forms["myForm"]["branch"].value;
  var data = {};
  if (fname == "") {
    alert("First Name must be filled out");
    return false;
  }
  if (lname == "") {
    alert("Last Name must be filled out");
    return false;
  }
  if (!(/^[a-z0-9]+@[a-z]+.com$/.test(mail))) {
    alert("Invalid Mail ID");
    return false;
  }
  if (gender == "") {
    alert("Gender must be filled out");
    return false;
  }
  if (branch == "") {
    alert("Branch must be filled out");
    return false;
  }
  else
  {
  	data = {
            FirstName: fname,
            MiddleName: mname,
            LastName: lname,
            Email : mail,
            Gender :gender,
            Branch :branch   
        }
  }
  console.log(data);     //logs data in the console
  return true;
}