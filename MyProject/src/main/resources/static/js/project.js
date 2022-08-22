(function() { 		
	let today = new Date();   
	document.getElementById('time').innerText = today.toLocaleDateString() + "🌳";
}());

let input = document.getElementById('input');
let must_table = document.getElementById('must_table');
let add_table = document.getElementById('add_table');

let cnt = 1;
function must() {
	if(window.event.keyCode == 13) {
		if(input.value != '') {				
			must_table.innerHTML += "<tbody id='must_tb"+cnt+"'><tr><td><button class='btn btn-outline-secondary'" 
			+ "type='button' onclick='add("+cnt+")'>⚪</button></td><td class='must_todo_td'>"
			+ input.value +"</td><td><button class='btn btn-outline-secondary' type='button'" 
			+ "onclick='remove("+cnt+")'>❌</button></td></tr></tbody>"	 
			
			input.value = ''		
			cnt++; 
		} 
	}
}

function remove(cnt) { 	

	let tb = document.getElementById('must_tb'+cnt)
	tb.remove();
	// let tb = document.getElementById('must_tb'+cnt);
	// tb.deleteRow(tb);
	// tbody가 확실히 제거되지 않는다.
}

function add(cnt) {  //must에서 complete로
	
	let must_tb = document.getElementById('must_tb'+cnt);
	var text = must_tb.getElementsByClassName("must_todo_td")[0].innerText;
	
	add_table.innerHTML += "<tbody id='add_tb"+cnt+"'><tr><td><button class='btn btn-outline-secondary'" 
	+ "type='button'>🔘</button></td><td class='add_todo_td'>"
	+ text +"</td><td><button class='btn btn-outline-secondary' type='button'" 
	+ "onclick='again_must("+cnt+")'>👆</button></td></tr></tbody>"	 

	let tb = document.getElementById('must_tb'+cnt)
	tb.remove();
} 

function again_must(cnt) { //complete에서  다시 must로 
	
	let add_tb = document.getElementById('add_tb'+cnt);
	var text = add_tb.getElementsByClassName("add_todo_td")[0].innerText;
	
	must_table.innerHTML += "<tbody id='must_tb"+cnt+"'><tr><td><button class='btn btn-outline-secondary'" 
	+ "type='button' onclick='add("+cnt+")'>⚪</button></td><td class='must_todo_td'>"
	+ text +"</td><td><button class='btn btn-outline-secondary' type='button'" 
	+ "onclick='remove("+cnt+")'>❌</button></td></tr></tbody>"	 

	//add_tb.deleteRow(add_tb);
	let tb = document.getElementById('add_tb'+cnt)
	tb.remove();

}





/*	let cell1 = "";
let cell2 = "";
let cell3 = "";

let add_tb = document.getElementById('add_tb'+cnt);
	var text = add_tb.getElementsByClassName("add_todo_td")[0].innerText;

	var row = must_table.insertRow();
	row.setAttribute('id', 'must_tb'+cnt);
		
	cell1 = row.insertCell(0);
	cell2 = row.insertCell(1);
	cell3 = row.insertCell(2);
	
	cell1.innerHTML = "<button class='btn btn-outline-secondary' type='button'" 
					+ "onclick='add("+cnt+")'>⚪</button></td>"
	cell2.setAttribute('class', 'must_todo_td');
	cell2.innerHTML = text;
	cell3.innerHTML = "<button class='btn btn-outline-secondary' type='button'" 
					+ "onclick='remove("+cnt+")'>❌</button></td>";

	add_tb.deleteRow(add_tb);
*/


/*	var row = add_table.insertRow();
	let parent = row.parentNode;
	parent.setAttribute('id', 'add_tb'+cnt);

	cell1 = row.insertCell(0);
	cell2 = row.insertCell(1);
	cell3 = row.insertCell(2);
	
	cell1.innerHTML = "<button class='btn btn-outline-secondary' type='button'>🔘</button></td>";
	cell2.setAttribute('class', 'add_todo_td');
	cell2.innerHTML = text;
	cell3.innerHTML = "<button class='btn btn-outline-secondary' type='button'" 
					+ "onclick='again_must("+cnt+")'>👆</button></td>";
		*/