
const detailObj={
    names:"",
    email:"",
    phoneNo:"",
    dept:"",
    gender:""
}

function handleNames(namesValue){
    if(/^[a-zA-Z() ]+$/.test(namesValue)){
        detailObj.names=namesValue
        console.log(detailObj.names);
    }else{
        alert("Enter the letters in name field...")
    }
}

function handleEmail(emailValue){
    if(String(emailValue).toLowerCase().match(/\S+@\S+\.\S+/)){
        detailObj.email=emailValue
        console.log(detailObj.email);
    }else{
        alert("Enter the valid email format...")
    }
}

function handlePhoneNo(phoneNoValue){
    if(/^\d+$/.test(phoneNoValue) && (phoneNoValue>9999)){
        detailObj.phoneNo=phoneNoValue
    }else{
        alert("Enter the phone no. with minimum of 5 digit...")
    }
}

function handleDept(deptValue){
    if(deptValue !== ''){
        detailObj.dept=deptValue
    }else{
        alert("Select department...")
    }
}

function handleGenders(genderValue){
    detailObj.gender=genderValue.value
}

//let radios = $('[type="radio"]');

//radios.change(function() {
//  radios.not(this).prop('checked', false);
//});

function validateAndSubmit(){
    if(detailObj.names != "" && detailObj.email != "" && detailObj.phoneNo != "" && detailObj.gender != ""){
        
        
        let params="uname="+detailObj.names+"&email="+detailObj.email+"&phoneNo="+detailObj.phoneNo+"&dept="+detailObj.dept+"&gender="+detailObj.gender;
        let http = new XMLHttpRequest();
        http.open("POST","http://localhost:8084/StudentDB/student",true);
        
        http.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        
        http.onreadystatechange=function(){
			if(http.status===201){
				console.log(JSON.parse(http.responseText));
			}	
		}
		http.send(params);
		
        
        return true;
    }else{
        alert("Enter the mandatory fields");
        return false
    }
}

console.log(detailObj);
