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

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #FFFFFF;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
    background-color: #FBF5EF;
    outline: none;
}

/* Set a style for all buttons */
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

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #ffbf00;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: #F5DA81;
    padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #f9e8b3;
    margin: 0% auto 5% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 50%; /* Could be more or less, depending on screen size */
		border-top-left-radius:20px;
		border-top-right-radius:20px;
		border-bottom-right-radius:20px;
		border-bottom-left-radius:20px; 
}

/* Style the horizontal ruler */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}
 
/* The Close Button (x) */
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

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
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

<form>
<p><font color="#330000"><b>Username:</b> <input type="text" name="user" size="18" placeholder="Insira seu nome de usuário" /></font>
<font color="#330000"><b>Senha:</b> <input type="password" name="senha" size="15" placeholder="Insira sua senha" /></font>
<button type="submit" class="registerbtn">Entrar</button>
</form>

<p><font color="#330000"><b>Ainda não tem uma conta?</b></font>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Cadastre-se</button>

<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" method="post" action="<%=request.getContextPath() + "/cliente" %>">
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
      <input type="text" placeholder="Rua, numero e bairro" name="ENDEREÇO" required>
     
      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancelar</button>
        <button type="submit" name="operacao" value="Inserir" class="signupbtn">Increver-se </button>
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
