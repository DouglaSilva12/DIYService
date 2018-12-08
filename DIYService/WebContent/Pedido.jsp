<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
fieldset { 
    display: block;
    margin-left: 2px;
    margin-right: 2px;
    padding-top: 0.35em;
    padding-bottom: 0.625em;
    padding-left: 0.75em;
    padding-right: 0.75em;
    border: 2px groove (internal value);
    border-color: #efc53a;
    border-top-left-radius:20px;
	border-top-right-radius:20px;
	border-bottom-right-radius:20px;
    border-bottom-left-radius:20px; 
}
</style>


<style>
* {
    box-sizing: border-box;
}
body {
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  grid-area: header;
  background-color: #F5DA81;
  padding: 30px;
  text-align: center;
  font-size: 35px;
}

.grid-container {
  display: grid;
  grid-template-areas: 
  'header header header header header header header' 
  'left left middle middle middle right right' 
  'footer footer footer footer footer footer footer';

} 
.left,
.middle,
.right {
  padding: 10px;
}

.left {
  grid-area: left;
}

.middle {
  grid-area: middle;
}

.right {
  grid-area: right;
}

.footer {
  grid-area: footer;
  background-color: #F5DA81;
  padding: 10px;
  text-align: center;
}

@media (max-width: 600px) {
  .grid-container  {
    grid-template-areas: 
    'header header header header header header header' 
    'left left left left left left left' 
    'middle middle middle middle middle middle middle' 
    'right right right right right right right' 
    'footer footer footer footer footer footer footer';
}
</style>
<style>

input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}
</style>
<style type="text/css">
#tag1 {
    background-color: #ffffff;
    width: 100px; 
    height: 35px;
    padding:10px;
	border-top-left-radius:15px;
	border-top-right-radius:15px;
	border-bottom-right-radius:15px;
	border-bottom-left-radius:15px;
}
</style>
<style type="text/css">
#tag2 {
    background-color: #fff79c;
    width: 150px; 
    height: 40px;
    padding:10px;
    border-top-left-radius:15px;
	border-top-right-radius:15px;
	border-bottom-right-radius:15px;
	border-bottom-left-radius:15px;
}
</style>
<style type="text/css">
#tag3 {
    background-color: #fff79c;
    width: 150px; 
    height: 55px;
    padding:10px;
    border-top-left-radius:15px;
	border-top-right-radius:15px;
	border-bottom-right-radius:15px;
	border-bottom-left-radius:15px;
}
</style>
<style type="text/css">
#tag4 {
    background-color: #fff79c;
    width: 150px; 
    height: 70px;
    padding:10px;
    border-top-left-radius:15px;
	border-top-right-radius:15px;
	border-bottom-right-radius:15px;
	border-bottom-left-radius:15px;
}
</style>
<style>
button {
    background-color: #ed9121;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}
button:hover {
    opacity:1;
}
</style>
<style>

.dropbtn {
    background-color: #ed9121;
    color: white;
    padding: 5px;
    font-size: 14px;
    border: none;
    cursor: pointer;
    opacity: 0.9;
}

.dropbtn:hover, .dropbtn:focus {
    background-color: #ed9121;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 130px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #ddd}

.show {display:block;}
</style>
</head>
<body>
<%
// VAR
String nome = request.getParameter("NOME_CLIENTE");
String id = request.getParameter("ID_CLIENTE");
String telefone = request.getParameter("TELEFONE");
String endereco = request.getParameter("ENDERECO");
%>
<div class="grid-container">
  <div class="header">
<img src="https://66.media.tumblr.com/d360df730ecdd3dfb788e5655eb24f3f/tumblr_piyg8gN28F1rr1603o1_1280.png" height="120" width="400" />
  </div>
  <div class="left" style="background-color:#f8e5a6;">
<center>
<br><br><br>
<p><div id="tag1">Etapas:</div></p>
<p><div id="tag2">Selecione os itens</div></p>
<p><div id="tag3">Defina o nome do produto</div></p>
<p><div id="tag4">Confirme endereço e forma de pagamento</div></p>
</center>
</div>
  <div class="middle" style="background-color:#ffffff;">
<fieldset>
<legend>Pão</legend>
<center><br>
    <input type="radio" name="pao" value="pq" > Pão três queijos </input>
    <input type="radio" name="pao" value="pi" > Pão italiano </input>
    <input type="radio" name="pao" value="pt" > Pão de tomate </input>
    <input type="radio" name="pao" value="pa" > Pão australiano </input>
</center><br>
</fieldset>  
<br>
<fieldset>
<legend>Carne</legend>
<center><br>
<input type="radio" name="carne" value="c60" > 60g </input>
  <input type="radio" name="carne" value="c120" > 120g </input>
</center><br>
</fieldset>
<br>
<fieldset>
<legend>Queijo</legend>
<center><br>
    <input type="checkbox" nome="queijo" value="n1"> Sem queijo </input>
    <input type="checkbox" nome="queijo" value="q1" > Prato </input>
    <input type="checkbox" nome="queijo" value="q2" > Cheddar </input>
    <input type="checkbox" nome="queijo" value="q3" > Mussarela </input>
</center><br>
</fieldset>
<br>
<fieldset>
<legend>Salada</legend>
<center><br>
    <input type="checkbox" nome="1" value="tomate" > Tomate </input>
    <input type="checkbox" nome="2" value="cebola" > Cebola </input>
    <input type="checkbox" nome="3" value="alface" > Alface </input>
</center><br>
</fieldset>
<br>
<fieldset>
<legend> Molhos</legend>
<center><br>
    <input type="checkbox" nome="1" value="barbecue"> Barbecue </input>
    <input type="checkbox" nome="2" value="alho" > Alho </input>
    <input type="checkbox" nome="3" value="verde" > Verde </input>
    <input type="checkbox" nome="4" value="katchup" > Katchup </input>
    <input type="checkbox" nome="5" value="maionese" > Maionese </input>
    <input type="checkbox" nome="6" value="mostarda" > Mostarda </input>
</center><br>
</fieldset>
<br>
<hr />
<br>
<fieldset>
<legend> Defina o nome do produto</legend>
<center><br>
    <input type="text" placeholder="Escolha um nome para seu hambúrguer" name="NOME_PRODUTO" required>
</center><br>
</fieldset>
<br>
<hr />
<br>
<fieldset>
<legend> Pagamento</legend>
<center><br>
    <input type="radio" name="pagamento" value="DINHEIRO" > Dinheiro </input>
    <input type="radio" name="pagamento" value="CARTÃO" > Cartão </input>
</center><br>
</fieldset>
<br>
<hr />
<br>
<fieldset>
<legend> Entrega</legend>
<center><br>
    MOSTRAR ENDEREÇO E OPÇÃO DE ALTERAR >>>>> ${endereco}
</center><br>
</fieldset>
<button type="submit" class="signupbtn">Enviar pedido</button>
</div>
  <div class="right" style="background-color:#f8e5a6;">
  
<!--  INFORMAÇÕES DE LOGIN -->
 <%= session.getAttribute("nomeLogin") %>
  <p><div class="dropdown">
  <button onclick="myFunction()" class="dropbtn">Opções</button>
  <div id="myDropdown" class="dropdown-content">
    <a href="#">Alterar dados</a>
    <a href="#">Link 2</a>
    <a href="#">Sair</a>
  </div>
</div>
</div>
  <div class="footer">
    <p><a href="#"> Sobre nós </a> | <a href="#"> Contato</a></p>
  </div>
</div>
<script>

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
</body>
</html>