<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<style type="text/css">
        { margin: 0; padding: 0; font-family:Tahoma; font-size:9pt;}
        #divCenter { 
                background-color: #f9e8b3; 
                width: 400px; 
                height: 380px; 
                left: 50%; 
                margin: -130px 0 0 -210px; 
                padding:10px;
                position: absolute; 
                top: 55%;
		border: 1px solid #888;
		border-top-left-radius:20px;
		border-top-right-radius:20px;
		border-bottom-right-radius:20px;
		border-bottom-left-radius:20px; 
		}
</style>


<style type="text/css">
        { margin: 0; padding: 0; font-family:Tahoma; font-size:9pt;}
        #divLogo { 
                left: 25%; 
                padding:10px;
                position: absolute; 
                }
</style>


<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #FFFFFF;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #FBF5EF;
    outline: none;
}

button {
    background-color: #ed9121;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 80%;
    opacity: 0.9;
}
button:hover {
    opacity:1;
}

.cancelbtn {
    padding: 14px 20px;
    background-color: #ffbf00;
}

.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

.container {
    padding: 16px;
}

.modal {
    display: none; 
    position: fixed; 
    z-index: 1; 
    left: 0;
    top: 0;
    width: 100%; 
    height: 100%; 
    overflow: auto;
    background-color: #F5DA81;
    padding-top: 50px;
}

.modal-content {
    background-color: #f9e8b3;
    margin: 0% auto 5% auto; 
    border: 1px solid #888;
    width: 50%; 
		border-top-left-radius:20px;
		border-top-right-radius:20px;
		border-bottom-right-radius:20px;
		border-bottom-left-radius:20px; 
}

hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}
 
.close {
    position: absolute;
    right: 35px;
    top: 15px;
    font-size: 40px;
    font-weight: bold;
    color: #f1f1f1;
}
.close:hover,
.close:focus {
    color: #f44336;
    cursor: pointer;
}

.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>

</head>

<body style="background-color:#F5DA81;">
<div id="divLogo"><img src="https://66.media.tumblr.com/d360df730ecdd3dfb788e5655eb24f3f/tumblr_piyg8gN28F1rr1603o1_1280.png" /></div>



<div id="divCenter">
<center>

<form method="post" action="<%= request.getContextPath() + "/cliente" %>">
<p><font color="#330000"><b>Username:</b> <input type="text" name="NOME_CLIENTE" size="18" placeholder="Insira seu nome de usuário" /></font>
<font color="#330000"><b>Senha:</b> <input type="password" name="SENHA" size="15" placeholder="Insira sua senha" /></font>
<button type="submit" name= "Operacao" value="Login" class="registerbtn">Entrar</button>
</form>

<p><font color="#330000"><b>Ainda não tem uma conta?</b></font>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Cadastre-se</button>

<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" method="post" action="<%= request.getContextPath() + "/cliente" %>">
    <div class="container">
      <h1>Inscreva-se</h1>
      <p>Preencha esse formulário para criar sua conta.</p>
      <hr>
      <label for="username"><b>Username</b></label>
      <input type="text" placeholder="Crie um nome de usuário" name="NOME_CLIENTE" required>

      <label for="senha"><b>Senha</b></label>
      <input type="password" placeholder="Crie uma senha" name="SENHA" required>

      <label for="telefone"><b>Telefone</b></label>
      <input type="text" placeholder="(99)99999-9999" name="TELEFONE" required>

      <label for="endereco"><b>Endereço</b></label>
      <input type="text" placeholder="Rua, numero e bairro" name="ENDERECO" required>
     
      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancelar</button>
        <button type="submit" name="Operacao" value="Inserir" class="signupbtn">Increver-se </button>
      </div>
    </div>
  </form>
</div>

<script>
var modal = document.getElementById('id01');
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>
</html>