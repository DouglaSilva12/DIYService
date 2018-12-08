<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
  'header header header header header header' 
  'left middle middle middle middle right' 
  'footer footer footer footer footer footer';

} 
.left,
.middle,
.right {
  padding: 0px;
  height: 400px;
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
    'header header header header header header' 
    'left left left left left left' 
    'middle middle middle middle middle middle' 
    'right right right right right right' 
    'footer footer footer footer footer footer';
}
</style>
</head>
<body style="background-color:#F5DA81;">
<div class="grid-container">
  <div class="header">
    <img src="https://66.media.tumblr.com/d360df730ecdd3dfb788e5655eb24f3f/tumblr_piyg8gN28F1rr1603o1_1280.png" height="120" width="400" />
  </div>
  <div class="left" style="background-color:#F5DA81;">
</div>
  <div class="middle" style="background-color:#ffffff;">
<br><br>
<center><h1 style="color:MediumSeaGreen;">Seu pedido foi concluído</h1>
<h2 style="color:MediumSeaGreen;">N° do pedido: #NUMERO</h2>
<h3 style="color:Tomato;">Tempo médio de espera: 30 minutos</h3></center>
</div>  
<br><br><br><br><br><br><br>
  <div class="right" style="background-color:#F5DA81;">
</div>
  <div class="footer">
    <p>Footer</p>
  </div>
</div>
</body>
</html>