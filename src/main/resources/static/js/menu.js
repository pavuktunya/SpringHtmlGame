// Создаем переменные

var menu1 = document.getElementById("menu1");
var menu2 = document.getElementById("menu2");
var menu3 = document.getElementById("menu3");
var button1 = document.getElementById("button1");
var button2 = document.getElementById("button2");
var button3 = document.getElementById("button3");
var button4 = document.getElementById("button4");
var m = [0];
var k = [0];
var f = [0];
var level = 0;
var score =0;

// Настроим переходы

button1.onclick = function(){

	// Присвоение копий массивов

	map = userSlice(mapArray[level]);
	things = userSlice(thingsArray[level]);
	keys = userSlice(keysArray[level]);
	start = userSlice(startArray[level]);
	finish = userSlice(finishArray[level]);

	// Создание мира и расстановка предметов

	menu1.style.display = "none";
	CreateNewWorld(map);
	pawn.x = start[0][0];
	pawn.y = start[0][1];
	pawn.z = start[0][2];
	pawn.rx = start[0][3];
	pawn.rx = start[0][4];
	CreateSquares(things,"thing");
	CreateSquares(keys,"key");
	CreateSquares(finish,"finish");

	// Запуск игры

	TimerGame = setInterval(repeatFunction,10);
	canlock = true;
}

button2.onclick = function(){
	menu1.style.display = "none";
	menu2.style.display = "block";
}

button3.onclick = function(){
	menu1.style.display = "block";
	menu2.style.display = "none";
}

button4.onclick = function(){
	menu1.style.display = "block";
	menu3.style.display = "none";
}

// Функция проверки взаимодействия

function interact(objects,string,num){
	for (i = 0; i < objects.length; i++){
		let r = (objects[i][0] - pawn.x)**2 + (objects[i][1] - pawn.y)**2 + (objects[i][2] - pawn.z)**2;
		if(r < (objects[i][7]**2)){
			document.getElementById(string + i).style.display = "none";
			objects[i][0] = 1000000;
			objects[i][1] = 1000000;
			objects[i][2] = 1000000;
			document.getElementById(string + i).style.transform =
			"translate3d(1000000px,1000000px,1000000px)";
			num[0]++;
		};
	};
}

// Функция проверки взаимодействия с финишом

function finishInteract(){
	let r = (finish[0][0] - pawn.x)**2 + (finish[0][1] - pawn.y)**2 + (finish[0][2] - pawn.z)**2;
	if(r < (finish[0][7]**2)){
		if (k[0] == 0){
			console.log("найдите ключ");
		}
		else{
			clearWorld();
			clearInterval(TimerGame);
			document.exitPointerLock();
			score = score + m[0];
			k[0] = 0;
			m[0] = 0;
			menu1.style.display = "block";
			level++;
			if(level >= 2){
				level = 0;
				score = 0;
			};
		};
	};
};

// Функция, повторяющаяся в игре

function repeatFunction(){
	update();
	interact(things,"thing",m);
	interact(keys,"key",k);
	finishInteract();
}

// Пользовательский slice

function userSlice(array){
	let NewArray = new Array();
	for (let i = 0; i < array.length; i++){
		NewArray[i] = new Array();
		for (let j = 0; j < array[i].length; j++){
			NewArray[i][j] = array[i][j];
		}
	}
	return NewArray;
}