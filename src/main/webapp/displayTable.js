
let displayObj;
let xttp = new XMLHttpRequest();
xttp.onreadystatechange = function(){
	if(this.readyState==4 && this.status==200){
		displayObj=JSON.parse(this.response);
		console.log(JSON.parse(this.response));
		ls = Object.keys(displayObj);
		/*
		for(i=0; i<ls.length;i++){
			console.log(displayObj[i]);
		}*/
		for(let i in displayObj){
			//console.log(i);
			//document.write('<tr><td>'+displayObj[i].id+'</td><td>'+displayObj[i].uname+'</td><td>'+displayObj[i].email+'</td><td>'+displayObj[i].phoneNo+'</td><td>'+displayObj[i].dept+'</td><td>'+displayObj[i].gender+'</td></tr>')
		 	//document.write(`<tr><td>${i}</td></tr>`);
		 	let tRow=document.createElement('tr');
		 	let tIdData=document.createElement('td');
		 	tIdData.innerText=displayObj[i].id;
		 	let tUnameData=document.createElement('td');
		 	tUnameData.innerText=displayObj[i].uname;
		 	let tEmailData=document.createElement('td');
		 	tEmailData.innerText=displayObj[i].email;
		 	let tPhoneNoData=document.createElement('td');
		 	tPhoneNoData.innerText=displayObj[i].phoneNo;
		 	let tDeptData=document.createElement('td');
		 	tDeptData.innerText=displayObj[i].dept;
		 	let tGenderData=document.createElement('td');
		 	tGenderData.innerText=displayObj[i].gender;
		 	tRow.append(tIdData,tUnameData,tEmailData,tPhoneNoData,tDeptData,tGenderData);
		 	document.querySelector('table').appendChild(tRow);
		 	
		}
	}
}
xttp.open("GET","http://localhost:8084/StudentDB/DisplayStudent",true);
xttp.send();



