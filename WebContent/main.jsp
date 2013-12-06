<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Операционный отдел</title>
<link rel="stylesheet" media="all" type="text/css"	href="css/bootstrap.css" />
<link rel="stylesheet" media="all" type="text/css"	href="css/app.css" />
<script src="js/jquery-1.10.1.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/app.js"></script>
</head>
<a name="type" id="document-type" data="payment-order"></a>
<body onload="hidePayment();">
	<div class="page-header">
	 	<h1>Операционный отдел<small></small></h1>
	</div>
	<input id="login" name="login" type="text" placeholder="Login" value="${login}"/><br/>
	<form action="logout" method="POST" id="logout">
		<span class="label label-info"><div name='login' id="nikname">Вы вошли как ${login}</div></span>
		<input type="submit" class="btn btn-link" value="Выйти" id="logout">
	</form>
	<div id="wrapper">
		<ul class="nav nav-tabs nav-justified" id="payments">
			<li class="active" id="order"><a onclick="changePayment(this);" id="order">Платежное поручение</a></li>
			<li id="requirement"><a onclick="changePayment(this);" id="requirement">Платежное требование</a></li>
		</ul>
		<form action="sendPaymentOrder" method="POST" id="send">
			<div id="payment-order">
				<h4 id="title">Платежное поручение</h4>
				<table class="table" id="table-payment-order-header1">
					<tr>
					
						<td id="td-enter-to-bank"><input type="textfield" name="enter-to-bank" id="enter-to-bank" placeholder="Поступ. в банк плат."><br><span id="tooltip-enter-to-bank">Поступ. в банк плат.</span></td>
                        <td id="td-change-off"><input type="textfield" name="change-off" id="change-off" placeholder="Списано со сч. плат."><br><span id="tooltip-change-off">Списано со сч. плат.</span></td>
                        <td id="td-document-number" ><span id="document-number">0401060</span></td>
						<!-- 
						<td id="enter-to-bank"><input type="textfield" name="enter-to-bank" id="enter-to-bank" placeholder="Поступ. в банк плат."></td>
						<td colspan="6"><input type="textfield" name="change-off" id="change-off" placeholder="Списано со сч. плат."></td>
						<td id="document-number"><p id="document-number">0401060</p></td> -->
					</tr>
				</table>
				<table class="table" id="table-payment-order-header2">
					<tr>
						<td colspan="2" id="td-document-type">Платежное поручение №</td>
						<td id="td-number"><input type="textfield" name="number" id="number"></td>
						<td id="td-date" colspan="2"><input type="textfield" name="date" id="date" placeholder="Дата"><br><span id="tooltip-date">Дата</span></td>
						<td id="td-payment-type" colspan="1"><input type="textfield" name="payment-type" id="payment-type" placeholder="Вид платежа	"><br><span id="tooltip-payment-type">Вид платежа</span></td>
						<td id="td-square"><input type="textfield" name="square" id="square"></td>
					<!--  
						<td colspan="2" id="document-type">Платежное поручение №</td>
						<td id="number"><input type="textfield" name="number" id="number"></td>
						<td id="date" colspan="2"><input type="textfield" name="date" id="date" placeholder="Дата"></td>
						<td id="payment-type" colspan="2"><input type="textfield" name="payment-type" id="payment-type" placeholder="Вид платежа	"></td>
						<td id="square"><input type="textfield" name="square" id="square"></td>-->
					</tr>
				</table>
				<table class="table table-bordered" id="payment-order">
					<tr>
						<td id="td-sum-hand-label">Сумма прописью</td>
						<td id="td-sum-hand" colspan="7"><input type="textfield" name="sum-hand" id="sum-hand"></td>
					</tr>
					<tr>
						<td colspan="2" id="td-payer-inn-1"><span id="payer-inn-label">ИНН </span><input type="textfield" name="payer-inn" id="payer-inn"></td>
                        <td colspan="2" id="td-payer-kpp-1"><span id="payer-kpp-label">КПП </span><input type="textfield" name="payer-kpp" id="payer-kpp"></td>
						<td id="td-sum-label"><span id="sum-label">Сумма</span></td>
                        <td id="td-sum" colspan="3"><input type="textfield" name="sum" id="sum" onchange="numberInWords();"></td>
					<!--  
						<td id="td-payer-inn-label">ИНН</td>
						<td id="td-payer-inn"><input type="textfield" name="payer-inn" id="payer-inn"></td>
						<td id="td-payer-kpp-label">КПП</td>
						<td id="td-payer-kpp"><input type="textfield" name="payer-kpp" id="payer-kpp"></td>
						<td id="td-sum-label">Сумма</td>
						<td id="td-sum" colspan="3"><input type="textfield" name="sum" id="sum" onchange="numberInWords();"></td>-->
					</tr>
					<tr>
						<td id="td-payer" colspan="4"><span id="payer-label">Плательщик</span><textarea type="textfield" name="payer" id="payer"></textarea></td>
						<td id="td-payer-bank-account-label"><span id="payer-bank-account-label">Сч. №</span></td>
                        <td id="td-payer-bank-account" colspan="3"><input type="textfield" name="payer-bank-account" id="payer-bank-account"></td>
					<!--  
						<td id="payer-label">Плательщик</td>
						<td id="payer" colspan="3"><textarea type="textfield" name="payer" id="payer"></textarea></td>
						<td id="payer-bank-account-label">Сч. №</td>
						<td id="payer-bank-account" colspan="3"><input type="textfield" name="payer-bank-account" id="payer-bank-account"></td>-->
					</tr>
					<tr>
						<td id="td-payers-bank" colspan="4" rowspan="2"><span id="payers-bank-label">Банк плательщика</span><textarea type="textfield" name="payers-bank" id="payers-bank"></textarea></td>
						<td id="td-payer-bik-label"><span id="payer-bik-label">БИК</span></td>
                        <td id="td-payer-bik" colspan="3"><input type="textfield" name="payer-bik" id="payer-bik"></td>
					<!-- 
						<td id="payers-bank-label" rowspan="2">Банк плательщика</td>
						<td id="payers-bank" colspan="3" rowspan="2"><textarea type="textfield" name="payers-bank" id="payers-bank"></textarea></td>
						<td id="payer-bik-label">БИК</td>
						<td id="payer-bik" colspan="3"><input type="textfield" name="payer-bik" id="payer-bik"></td> -->
					</tr>
					<tr>
						<td id="td-payer-bank-bank-account-label">Сч. №</td>
						<td id="td-payer-bank-bank-account" colspan="3"><input type="textfield" name="payer-bank-bank-account" id="payer-bank-bank-account"></td>
					</tr>
					<tr>
						<td id="td-addressee-bank" colspan="4" rowspan="2"><span id="addressee-bank-label" >Банк получателя</span><textarea type="textfield" name="addressees-bank" id="addressee-bank"></textarea></td>
						<td id="td-addressee-bik-label"><span id="addressee-bik-label">БИК</span></td>
                        <td id="td-addressee-bik" colspan="4"><input type="textfield" name="addressees-bik" id="addressee-bik"></td>
					<!-- 
						<td id="addressee-bank-label" rowspan="2">Банк получателя</td>
						<td id="addressee-bank" colspan="3" rowspan="2"><textarea type="textfield" name="addressees-bank" id="addressee-bank"></textarea></td>
						<td id="addressee-bik-label">БИК</td>
						<td id="addressee-bik" colspan="3"><input type="textfield" name="addressees-bik" id="addressee-bik"></td> -->
					</tr>
					<tr>
						<td id="td-addressees-bank-bank-account-label">Сч. № </td>
						<td id="td-addressees-bank-bank-account" colspan="3"><input type="textfield" name="addressees-bank-bank-account" id="addressees-bank-bank-account"></td>
					</tr>
					<tr>
					<td id="td-addressee-inn" colspan="2"><span id="addressee-inn-label">ИНН  </span><input type="textfield" name="addressee-inn" id="addressee-inn"></td>
						<td id="td-addressee-kpp" colspan="2"><span id="addressee-kpp-label">КПП  </span><input type="textfield" name="addressee-kpp" id="addressee-kpp"></td>
						<td id="td-addressee-bank-account-label"><span id="addressee-bank-account-label">Сч. № </span></td>
						<td id="td-addressee-bank-account" colspan="3"><input type="textfield" name="addressee-bank-account" id="addressee-bank-account"></td>
					<!-- 
						<td id="addressee-inn-label">ИНН</td>
						<td id="addressee-inn"><input type="textfield" name="addressee-inn" id="addressee-inn"></td>
						<td id="addressee-kpp-label">КПП</td>
						<td id="addressee-kpp"><input type="textfield" name="addressee-kpp" id="addressee-kpp"></td>
						<td id="addressee-bank-account-label">Сч. № </td>
						<td id="addressee-bank-account" colspan="3"><input type="textfield" name="addressee-bank-account" id="addressee-bank-account"></td> -->
					</tr>
					<tr>
					<td id="td-addressee" colspan="4" rowspan="3"><span id="addressee-label" >Получатель</span><textarea type="textfield" name="addressee" id="addressee"></textarea></td>
					<!-- 
						<td id="addressee-label" rowspan="3">Получатель</td>
						<td id="addressee" colspan="3" rowspan="3"><textarea type="textfield" name="addressee" id="addressee"></textarea></td> -->
					</tr>
					<tr>
						<td id="td-type-pay-label">Вид оп.</td>
						<td id="td-type-pay"><input type="textfield" name="type-pay" id="type-pay"></td>
						<td id="td-period-pay-label">Срок пл.</td>
						<td id="td-period-pay"><input type="textfield" name="period-pay" id="period-pay"></td>
					</tr>
					<tr>
						<td></td>
                        <td></td>
						<td id="td-pay-order-label"><span id="pay-order-label">Очер. пл.</span></td>
						<td id="td-pay-order"><input type="textfield" name="pay-order" id="pay-order"></td>
						<!-- <td>Очер. пл.</td>
						<td><input type="textfield" name="pay-order" id="pay-order"></td> -->
					</tr>
					<tr>
						<td colspan="8" id="td-pay-for">
                            <span id="pay-for-label">Назначение платежа</span>
							<textarea type="textfield" name="pay-for" id="pay-for"></textarea>
						</td>
						<!-- <td>Назначение платежа</td>
						<td colspan="7">
							<textarea type="textfield" name="pay-for" id="pay-for"></textarea>
						</td> -->
					</tr>
				</table>
			</div>
			<!-- send the document to db -->
			<input id="sendOrder" type="submit" class="btn btn-primary" value="Отправить" onclick="send();">
			<!-- print the document -->
			<input id="printOrder" type="button" class="btn " value="Предпросмотр печати" onclick="print_preview();">
		</form>
		<form action="sendPaymentRequirement" method="POST" id="send">
			<div id="payment-requirement">
				<h4 id="title">Платежное требование</h4>
				<table class="table" id="payment-requirement-header">
					<tr>
						<td colspan="2"><input type="textfield" name="enter-to-bank" id="enter-to-bank" placeholder="Поступ. в банк плат."></td>
						<td colspan="2"><input type="textfield" name="accept-end" id="accept-end" placeholder="Оконч. срока акцепта"></td>
						<td colspan="3"><input type="textfield" name="change-off" id="change-off" placeholder="Списано со сч. плат."></td>
						<td><p id="document-number">0401061</p></td>
					</tr>
					<tr>
						<td colspan="2">Платежное требование №</td>
						<td><input type="textfield" name="number" id="number"></td>
						<td colspan="2"><input type="textfield" name="date" id="date" placeholder="Дата"></td>
						<td colspan="3"><input type="textfield" name="payment-type" id="payment-type" placeholder="Вид платежа	"></td>
					</tr>
				</table>
				<table class="table table-bordered" id="payment-requirement">
					<tr>
						<td>Условие оплаты</td>
						<td colspan="3"><input type="textfield" name="payment-terms" id="payment-terms"></td>
						<td>Срок для акцепта</td>
						<td><input type="textfield" name="accept-period" id="accept-period"></td>
					</tr>
					<tr>
						<td>Сумма прописью</td>
						<td colspan="5"><input type="textfield" name="sum-hand" id="sum-hand"></td>
					</tr>
					<tr>
						<td>ИНН</td>
						<td><input type="textfield" name="payer-inn" id="payer-inn"></td>
						<td>Сумма</td>
						<td colspan="3"><input type="textfield" name="sum" id="sum" onchange="numberInWords();"></td>
					</tr>
					<tr>
						<td >Плательщик</td>
						<td ><textarea type="textfield" name="payer" id="payer"></textarea></td>
						<td>Сч. №</td>
						<td colspan="3"><input type="textfield" name="payer-bank-account" id="payer-bank-account"></td>
					</tr>
					<tr>
						<td rowspan="2">Банк плательщика</td>
						<td rowspan="2"><textarea type="textfield" name="payers-bank" id="payers-bank"></textarea></td>
						<td>БИК</td>
						<td colspan="3"><input type="textfield" name="payer-kpp" id="payer-bik"></td>
					</tr>
					<tr>
						<td>Сч. №</td>
						<td colspan="3"><input type="textfield" name="payer-bank-bank-account" id="payer-bank-bank-account"></td>
					</tr>
					<tr>
						<td rowspan="2">Банк получателя</td>
						<td rowspan="2"><textarea type="textfield" name="addressees-bank" id="addressee-bank"></textarea></td>
						<td>БИК / BIK</td>
						<td colspan="3"><input type="textfield" name="addressees-kpp" id="addressee-bik"></td>
					</tr>
					<tr>
						<td>Сч. №</td>
						<td colspan="3"><input type="textfield" name="addressees-bank-bank-account" id="addressees-bank-bank-account"></td>
					</tr>
					<tr>
						<td>ИНН </td>
						<td><input type="textfield" name="addressee-inn" id="addressee-inn"></td>
						<td>Сч. № </td>
						<td colspan="3"><input type="textfield" name="addressee-bank-account" id="addressee-bank-account"></td>
					</tr>
					<tr>
						<td rowspan="3">Получатель </td>
						<td rowspan="3"><textarea type="textfield" name="addressee" id="addressee"></textarea></td>
					</tr>
					<tr>
						<td>Вид оп.</td>
						<td><input type="textfield" name="type-pay" id="type-pay"></td>
						<td>Срок пл.</td>
						<td><input type="textfield" name="period-pay" id="period-pay"></td>
					</tr>
					<tr>
						<td>Очер. пл.</td>
						<td><input type="textfield" name="pay-order" id="pay-order"></td>
					</tr>
					<tr>
						<td>Назначение платежа</td>
						<td colspan="7">
							<textarea type="textfield" name="pay-for" id="pay-for"></textarea>
						</td>
					</tr>
				</table>
			</div>
			<!-- send the document to db -->
			<input id="sendRequirement" type="submit" class="btn btn-primary" value="Отправить" onclick="send();">
			<!-- print the document -->
			<input id="printRequirement" type="button" class="btn " value="Предпросмотр печати" onclick="print_preview();">
		</form>	
	</div>

</body>
</html>