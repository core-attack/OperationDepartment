function changePayment(el){
	if (el.id == "order"){
		$('#payments a:first').tab('show');
		$("#payment-order").show();
		$("#payment-requirement").hide();
		$("#sendRequirement").hide();
		$("#printRequirement").hide();
		$("#sendOrder").show();
		$("#printOrder").show();
		$("#document-type").attr("data", "payment-order");
		$("#document-type").val("payment-order");
	}
	else {
		$('#payments a:last').tab('show');
		$("#payment-order").hide();
		$("#sendOrder").hide();
		$("#printOrder").hide();
		$("#sendRequirement").show();
		$("#printRequirement").show();
		$("#payment-requirement").show();
		$("#document-type").attr("data", "payment-requirement");
		$("#document-type").val("payment-requirement");
	}
}

function hidePayment(){
	$("#document-type").val("payment-order");
	$("#payment-requirement").hide();
	$("#sendRequirement").hide();
	$("#printRequirement").hide();
	setData();
	
}

//заполняет данными по умолчанию
function setData(){
	$("input#enter-to-bank").val("01.01.2013");
	$("input#change-off").val("01.10.2013");
	$("input#number").val("366");
	$("input#date").val("13.06.2013");
	$("input#payment-type").val("перевод");
	$("input#sum-hand").val("две тысячи пятьсот рублей");
	$("input#sum").val("2500");
	$("input#payer-inn").val("186256985458");
	$("input#payer-kpp").val("458965894");
	$("textarea#payer").val("ООО \"Рога и копыта\"");
	$("input#payer-bank-account").val("2564897568948567895");
	$("input#addressees-bank-bank-account").val("75846374836592548694");
	$("input#addressee-bank-account").val("14768456854764859594");
	$("input#payer-bank-bank-account").val("456985698569856487598");
	$("input#payer-bik").val("045001000");
	$("input#addressee-bik").val("045012356");
	$("textarea#payers-bank").val("ЗАО \"Сбербанк\"");
	$("textarea#addressee-bank").val("ЗАО \"Русский стандарт\"");
	$("input#addressee-inn").val("186954856985");
	$("input#addressee-kpp").val("458695874");
	$("textarea#addressee").val("ООО ИМЗ \"Купол\"");
	$("input#type-pay").val("наличные");
	$("textarea#pay-for").val("задолженность");
	$("input#code").val("9485");
	$("input#period-pay").val("12.11.2013");
	$("input#pay-order").val("1");
}

var numbers1_9 = new Array("ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять");
var numbers1_2 = new Array("одна", "две");
var numbers10_19 = new Array("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать");
var numbers10_90 = new Array("десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто");
var numbers100_900 = new Array("сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот");

//сгенерировать двузначное число
function generateDoubleNumber(number){
	if (number > 0 && number < 100){
		if (number < 10)
			return numbers1_9[number];
		else if (number < 20)
			return numbers10_19[number - 10];
		else {
			//десяток
			var ten = Math.floor(number / 10);
			return numbers10_90[ten - 1] + " " + numbers1_9[number - ten * 10];
		}
	}
	return "";
}
//генерирует трехзначное число 
function generateThreeNumber(number){
	var hundreet = Math.floor(number / 100);
	if (hundreet > 0){
		return numbers100_900[hundreet - 1] + " " + generateDoubleNumber(number - 100 * hundreet);
	}
	return generateDoubleNumber(number - number * hundreet);
}

//генерирует шестизначное число 
function generateSixNumber(number){
	//alert("шестизначное число = " + number);
	var thousands = Math.floor(number / 1000);
	var hundreds =  Math.floor(number % 1000);
	var result = "";
	//alert("число тысяч = " + thousands);
	//alert("число сотен = " + hundreds);
	if (thousands > 0) {
		if (thousands < 5){
			var temp = "" + thousands;
			if (temp[temp.length - 1] == "1")
				result = numbers1_2[0] + " " + getBigNumber(3) + "а";
			else if (temp[temp.length - 1] == "2" || temp[temp.length - 1] == "3" || temp[temp.length - 1] == "4")
				if (temp[temp.length - 1] == "2")
					result = numbers1_2[1] + " " + getBigNumber(3) + "и";
				else
					result = numbers1_9[thousands] + " " + getBigNumber(3) + "и";
			else
				result = numbers1_9[thousands] + " " + getBigNumber(3);
			if (hundreds > 0) {
				result += " " + generateThreeNumber(hundreds);
			}
		}
		else{
			var temp = "" + thousands;
			if (temp[temp.length - 1] == "1")
				result = generateThreeNumber(thousands) + " " + numbers1_2[thousands] + " " + getBigNumber(3) + "а";
			else if (temp[temp.length - 1] == "2" || temp[temp.length - 1] == "3" || temp[temp.length - 1] == "4")
				if (temp[temp.length - 1] == "2")
					result = generateThreeNumber(thousands) + " " + getBigNumber(3) + "и";
				else
					result = generateThreeNumber(thousands) + " " + getBigNumber(3) + "и";
			else
				result = generateThreeNumber(thousands) + " " + getBigNumber(3);
			if (hundreds > 0) {
				result += " " + generateThreeNumber(hundreds);
			}
		}
    }
	else
		result = generateThreeNumber(hundreds);
	return result;
}

//генерирует девятизначное число
function generateNineNumber(number){
	var millions = Math.floor(number / 1000000);
	var thousands = Math.floor(number % 1000000);
	var result = "";
	//alert("число миллионов = " + millions);
	//alert("число тысяч = " + thousands);
	if (millions > 0){
		if (millions == 1)
			result = numbers1_9[millions] + " " + getBigNumber(6);
		else if (millions == 2 || millions == 3 || millions == 4)
			result = numbers1_9[millions] + " " + getBigNumber(6) + "а";
		else{
			var temp = "" + millions;
			if (temp[temp.length - 1] == "1") 
				result = generateThreeNumber(millions) + " " + getBigNumber(6) + "";
			else if (millions % 2 == 0 || millions % 3 == 0 || millions % 4 == 0 )
				result = generateThreeNumber(millions) + " " + getBigNumber(6) + "а";
			else
				result = generateThreeNumber(millions) + " " + getBigNumber(6) + "ов";
		}
		if (thousands > 0)
			result += " " + generateSixNumber(thousands);
	}
	else{
		result = generateSixNumber(thousands);
	}
	return result;
	
}

//генерирует двенадцатизначное число
function generateTwelfNumber(number) {
    var milliards = Math.floor(number / 1000000000);
    var millions = Math.floor(number % 1000000000);
    //alert("миллиардов = " + milliards);
    //alert("миллионов = " + millions);
    var result = "";
    if (milliards > 0) {
        if (milliards == 1)
            result = numbers1_9[milliards] + " " + getBigNumber(9);
        else if (milliards == 2 || milliards == 3 || milliards == 4)
            result = numbers1_9[milliards] + " " + getBigNumber(9) + "а";
        else{
        	var temp = "" + milliards;
			if (temp[temp.length - 1] == "1") 
				result =  generateThreeNumber(milliards) + " " + getBigNumber(9) + "";
			else if (milliards % 2 == 0 || milliards % 3 == 0 || milliards % 4 == 0 )
				result =  generateThreeNumber(milliards) + " " + getBigNumber(9) + "а";
			else
				result = generateThreeNumber(milliards) + " " + getBigNumber(9) + "ов";
        }
        if (millions > 0)
            result += " " + generateNineNumber(millions);
    }
    else {
        result = generateNineNumber(millions);
    }
    return result;
}

//генерирует пятнадцатизначное число
function generateFivetenNumber(number) {
    var trillions = Math.floor(number / 1000000000000);
	var milliards = Math.floor(number % 1000000000000);
	//alert("триллионов = " + trillions);
	//alert("миллиардов = " + milliards);
    var result = "";
    if (trillions > 0) {
        if (trillions == 1){
            alert(trillions);
        	result = numbers1_9[trillions] + " " + getBigNumber(12);
        }
        else if (trillions == 2 || trillions == 3 || trillions == 4)
            result = numbers1_9[trillions] + " " + getBigNumber(12) + "а";
        else{
        	var temp = "" + trillions;
			if (temp[temp.length - 1] == "1") 
				result =  generateThreeNumber(trillions) + " " + getBigNumber(12)  + "";
			else if (trillions % 2 == 0 || trillions % 3 == 0 || trillions % 4 == 0 )
				result =  generateThreeNumber(trillions) + " " + getBigNumber(12)  + "а";
			else
				result = generateThreeNumber(trillions) + " " + getBigNumber(12)  + "ов";
        }
        if (milliards > 0)
            result += " " + generateTwelfNumber(milliards);
    }
    else {
        result = generateTwelfNumber(milliards);
    }
    return result;
}
//
function getBigNumber(number){
	switch(number){
	    case 3:{return "тысяч";}
		break;
		case 6:{return "миллион";}
		break;
		case 9:{return "миллиард";}
		break;
		case 12:{return "триллион";} /*реализовано пока до сюда*/
		break;
		case 15:{return "квадриллион";}
		break;
		case 18:{return "квинтиллион";}
		break;
		case 21:{return "секстиллион";}
		break;
		case 24:{return "септиллион";}
		break;
		case 27:{return "октиллион";}
		break;
		case 30:{return "нониллион";}
		break;
		case 33:{return "дециллион";}
		break;
	}
}

//генерирует сумму прописью
function numberInWords(){
	var text = $("#sum").val().trim();
	if (text.split('.').length > 2 || text.split(',').length > 2){
		alert("Невозможно определить число суммы");
		return;
	}
	if (text.indexOf('.') != -1 && text.indexOf(',') != -1){
		alert("Не определен разделитель суммы");
		return;
	}
	//целая часть числа
	var int = "0";
	//дробная часть числа
	var drob = "0";
	if (text.indexOf('.') != -1) {
        int = text.split('.')[0];
	    drob = text.split('.')[1];
	}
	else if (text.indexOf(',') != -1) {
	    int = text.split(',')[0];
	    drob = text.split(',')[1];
	}
	else 
	    int = text;

	//результирующее предложение
	var result = "";
	if (int == "0" && drob != "0")
	    result = "ноль рублей " + generateFivetenNumber(drob) + " копеек";
	else if (int != "0" && drob == "0")
	    result = generateFivetenNumber(int) + " рублей ноль копеек";
	else if (int == "0" && drob == "0")
	    result = "ноль рублей ноль копеек";
	else
	    result = generateFivetenNumber(int) + " рублей " + generateFivetenNumber(drob) + " копеек";
	$("#sum-hand").val(result);
}

//отправляет введенные данные на сервер
function send()
{}

//распечатывает документ
function print(){
	$("#button-print").hide();
	$("#button-back").hide();
	$("#print").css("margin", "0 auto");
	//window.print();
	
}

//открывает предпросмотр документа
function print_preview(){
	$(".page-header").hide();
	$("#logout").hide();
	$("#wrapper").hide();
	$("h4#title").hide();
	var type = $("#document-type").val();
	if (type == "payment-order")
	{
		
		$(document.body).append("<div id=\"print\"></div>");//"<form id=\"print-form\" action=\"print\" method=\"post\"></form>"
		var el = $("#payment-order").clone();
		//удаляем классы всех таблиц, чтобы bootstrap не портил таблицы
		var tables = $(el).find("table");
		for (var i = 0; i < tables.length; i++){
			tables[i].className = "";
		}
		$(el).find("br").remove();
		
		//заменяем все инпуты и текстареи на спаны
		var arr = $(el).find("input, textarea");
		for (var i = 0; i < arr.length; i++){
			var p = document.createElement("span");
			$(p).attr("id", $(arr[i]).attr("id"));
			$(p).attr("className", $(arr[i]).attr("className"));
			$(p).attr("name", $(arr[i]).attr("name"));
			$(p).append($(arr[i]).val());
			if ($(p).attr("id") == "enter-to-bank" ||  $(p).attr("id") == "change-off" || $(p).attr("id") == "date" || $(p).attr("id") == "payment-type"){
				//var br = document.createElement("br");
				var span = "";
				switch($(p).attr("id")){
					case "enter-to-bank": {span = $("#tooltip-enter-to-bank"); $("#td-enter-to-bank").empty();} break;
					case "change-off": {span = $("#tooltip-change-off"); $("#td-enter-to-bank").empty(); } break;
					case "date": {span = $("#tooltip-date"); $("#td-enter-to-bank").empty(); } break;
					case "payment-type": {span = $("#tooltip-payment-type"); $("#td-enter-to-bank").empty();} break;
				}
				//$(arr[i]).parent().append(p);
				//$(arr[i]).parent().append(br);
				$(arr[i]).parent().prepend(p);
			}
			else
				$(arr[i]).parent().append(p);
			$(arr[i]).remove();
		}
		$("#print").append(el);
		$("#" + type).remove();
		$("#sendOrder").remove();
		$("#printOrder").remove();
		$(document.body).append("<form id=\"print-form\" action=\"toMain\" method=\"post\"><input id=\"button-back\" type=\"submit\" class=\"btn \" value=\"Назад\" \"><input id=\"button-print\" type=\"button\" class=\"btn btn-primary\" value=\"Печать\" \" onclick=\"print();\"></form></div>");
	}
	else if (type == "payment-requirement"){
		$(document.body).append("<div id=\"print\"></div>");//"<form id=\"print-form\" action=\"print\" method=\"post\"></form>"
		var el = $("#payment-requirement").clone();
		$("#print").append(el);
		//
		var arr = $(el).find("input");
		for (var i = 0; i < arr.length; i++){
			var p = document.createElement("p");
			$(p).attr("id", $(arr[i]).attr("id"));
			$(p).attr("className", $(arr[i]).attr("className"));
			$(p).attr("name", $(arr[i]).attr("name"));
			$(p).append($(arr[i]).val());
			$(arr[i]).parent().append(p);
			$(arr[i]).remove();
		}
		$("#" + type).remove();
		$("#sendRequirement").remove();
		$("#printRequirement").remove();
		$(document.body).append("<form id=\"print-form\" action=\"toMain\" method=\"post\"><input id=\"button-back\" type=\"submit\" class=\"btn \" value=\"Назад\" \"><input id=\"button-print\" type=\"button\" class=\"btn btn-primary\" value=\"Печать\" \" onclick=\"print();\"></form></div>");
	}
	else {
		alert("Извините, не определен тип распечатываемого документа.");
	}
}
/*



$(document)
		.ready(
				function() {
					document.getElementById("flights_sort").value = getCookie("flights_sort");
					document.getElementById("order_by").value = getCookie("order_by");
					document.getElementById("client_class_place").value = getCookie("class_place");
				});
// событие нажатия на кнопку "купить"
function buy_click(elem) {
	var arr = new Array();
	arr = elem.id.split(' ');
	var flight_id = -1;
	var client_id = -1;
	var price = -1;
	var lprice = -1;
	for ( var i = 0; i < arr.length; i++) {
		if (arr[i].indexOf("flight_id") != -1) {
			flight_id = arr[i].split("=")[1];
			setCookie("flight_id", flight_id);
		} else if (arr[i].indexOf("client_id") != -1) {
			client_id = arr[i].split("=")[1];
			setCookie("client_id", client_id);
		}
		else if (arr[i].indexOf("ticket_price") != -1) {
			price = arr[i].split("=")[1];
			//alert(price);
			setCookie("ticket_price", price);
		}
		else if (arr[i].indexOf("luggage_price") != -1) {
			lprice = arr[i].split("=")[1];
			//alert(lprice);
			setCookie("luggage_price", lprice);
		}
	}
	//alert("price=" + price + " lprice=" + lprice);
	
	
	
	
}
// событие нажатия на кнопку "забронировать"
function book_click(elem) {
	buy_click(elem);
}
// событие нажатия на кнопку "отменить покупку"
function cancel_buy(elem) {
	var arr = new Array();
	arr = elem.id.split(' ');
	var ticket_id = -1;
	var client_id = -1;
	for ( var i = 0; i < arr.length; i++) {
		if (arr[i].indexOf("ticket_id") != -1) {
			ticket_id = arr[i].split("=")[1];
		} else if (arr[i].indexOf("client_id") != -1) {
			client_id = arr[i].split("=")[1];
		}
	}
	// alert("ticket_id=" + ticket_id + " client_id=" + client_id);
	setCookie("ticket_id", ticket_id);
	setCookie("client_id", client_id);
}
// событие нажатия на кнопку "отменить бронь"
function cancel_book(elem) {
	var arr = new Array();
	arr = elem.id.split(' ');
	var book_id = -1;
	var client_id = -1;
	for ( var i = 0; i < arr.length; i++) {
		if (arr[i].indexOf("book_id") != -1) {
			book_id = arr[i].split("=")[1];
		} else if (arr[i].indexOf("client_id") != -1) {
			client_id = arr[i].split("=")[1];
		}
	}
	// alert("book_id=" + book_id + " client_id=" + client_id);
	setCookie("book_id", book_id);
	setCookie("client_id", client_id);
}

function request(flight_id) {
	if (xmlHttp) {
		//
		try {
			// name = document.all("myLogin").value;
			xmlHttp.open("GET",
					"jdbc:mysql://localhost:3307/avia?useUnicode=true&", true);
			xmlHttp.onreadystatechange = ResponseHandler;
			xmlHttp.send(null);
		}
		//
		catch (e) {
			alert("Connection server error");
		}
	}
}

// Записывает куки
function setCookie(name, value, expires, path, domain, secure) {
	document.cookie = name + "=" + escape(value)
			+ ((expires) ? "; expires=" + expires : "")
			+ ((path) ? "; path=" + path : "")
			+ ((domain) ? "; domain=" + domain : "")
			+ ((secure) ? "; secure" : "");
}
// Возвращает куки
function getCookie(name) {
	var cookie = " " + document.cookie;
	var search = " " + name + "=";
	var setStr = null;
	var offset = 0;
	var end = 0;
	if (cookie.length > 0) {
		offset = cookie.indexOf(search);
		if (offset != -1) {
			offset += search.length;
			end = cookie.indexOf(";", offset);
			if (end == -1) {
				end = cookie.length;
			}
			setStr = unescape(cookie.substring(offset, end));
		}
	}
	return (setStr);
}

// реакция на нажатие кнопки смены класса места в самолете
function setClassPlace() {
	setCookie("class_place",
			document.getElementById("client_class_place").value);
}

function FlightsSort() {
	// var flights_sort = document.getElementById("flights_sort").value;
	// var order_by = document.getElementById("order_by").value;
	// alert("flights_sort=" + flights_sort + " order_by=" + order_by);
	setCookie("flights_sort", document.getElementById("flights_sort").value);
	setCookie("order_by", document.getElementById("order_by").value);

}

function changeCategory(elem){
	var arr = new Array();
	arr = elem.id.split(' ');
	var client_id = -1;
	var category_id = -1;
	for ( var i = 0; i < arr.length; i++) {
		if (arr[i].indexOf("client_id") != -1) {
			client_id = arr[i].split("=")[1];
		} else if (arr[i].indexOf("category_id") != -1) {
			category_id = arr[i].split("=")[1];
		}
	}
	//alert("client_id=" + client_id + " category_id=" + category_id);
	setCookie("client_id", client_id);
	setCookie("category_id", category_id);
	
}

function check(){
	if (document.getElementById("pass1").value ==  document.getElementById("pass2").value)
		document.getElementById("password").value = "good";
	else
		document.getElementById("passport").value += 1;
	document.getElementById("email").value = document.getElementById("pass1").value + " " +  document.getElementById("pass2").value ;
}
function confirmPassword() {
	try {
		var pass1 = document.getElementById("pass1");
		var pass2 = document.getElementById("pass2");
		if (pass2 != null){
			if (pass1.value != pass2.value) {
				document.getElementById('submit').disabled = true;
				//pass2.setAttribute("id", "pass2 " + "inputError");
				//document.getElementById("help").setAttribute("text","don't match with \"Password\"");
			} else {
				document.getElementById('submit').disabled = false;
				//pass2.setAttribute("id", "pass2 " + "inputSuccess");
				//document.getElementById("help").setAttribute("text", "Good");
			}
		} else {
			pass2 = document.getElementById("pass2 inputError");
			if (pass1.value == pass2.value) {
				document.getElementById('submit').disabled = false;
				//pass2.setAttribute("id", "pass2 " + "inputSuccess");
				//document.getElementById("help").setAttribute("text", "Good");
			}
		}
		

	} catch (Exception) {
		alert(Exception.name + "\n" + Exception.message);
	}

}*/
