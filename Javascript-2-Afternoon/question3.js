StudentDB = [];
function addDetails() {
    student = {};  
    let firstName = document.getElementById("fname").value;
    let lastName = document.getElementById("lname").value;
    let age = document.getElementById("age").value;
    let roll = document.getElementById("roll").value.toUpperCase();;
    let dob = document.getElementById("dob").value;
    let gender = document.forms["myForm"]["gender"].value;
    console.log(roll);

    if (firstName != "" && lastName != "" && gender != "" && age != "" && roll!="" && dob!="") {
        (function makeObject() {
            student = {
                fname: firstName,
                lname: lastName,
                gender :gender,
                rollno : roll,
                dob : dob,
                age :age,
                occupation: ""
            }
        })();
            
        StudentDB[roll] = student;
 
        alert("Success");
        console.log("New Student data added"); 
    }else{
        alert("Form is not Valid");
        console.log("Invalid Details");
    }

    console.log(StudentDB);
}

function getDetails() {
    let inputRoll = document.getElementById("getRoll").value;
    let outputData = "";
    console.log(inputRoll);
    if(inputRoll=="") 
        alert("Please Enter Roll Number");
    else if(inputRoll in StudentDB) {
        outputData += `First Name: ${StudentDB[inputRoll].fname} <br>
        Last Name: ${StudentDB[inputRoll].lname} <br>
        Gender : ${StudentDB[inputRoll].gender} <br>
        Age : ${StudentDB[inputRoll].age} <br>
        DOB :  ${StudentDB[inputRoll].dob} <br> 
        Occupation : ${StudentDB[inputRoll].occupation}`;
        
        console.log(StudentDB[inputRoll]);  

        document.getElementById("studentData").innerHTML = outputData;
        }
    else {
        document.getElementById("studentData").innerHTML = "Student Rollno not Found";
   }

}

function addOccupation() {
    let oc = document.getElementById("inputOc").value;
    let forRoll = document.getElementById("occupationRoll").value;
    StudentDB[forRoll].occupation = oc;
    alert("Occupation Added");
}