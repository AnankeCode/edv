<?php
require_once 'config/config.php';
echo " Desarrollado por: ".AUTOR;
echo " -- Version .".VERSION;

 $bd1 = new mysqli(IPSERVIDOR.":".PUERTO,USUARIOBD,CLAVEBD,BD);		  

 // ¡Oh, no! Existe un error 'connect_errno', fallando así el intento de conexión
if ($bd1->connect_errno) {
    // La conexión falló. ¿Que vamos a hacer? 
    // Se podría contactar con uno mismo (¿email?), registrar el error, mostrar una bonita página, etc.
    // No se debe revelar información delicada

    // Probemos esto:
    echo "Lo sentimos, este sitio web está experimentando problemas.";

    // Algo que no se debería de hacer en un sitio público, aunque este ejemplo lo mostrará
    // de todas formas, es imprimir información relacionada con errores de MySQL -- se podría registrar
    echo "Error: Fallo al conectarse a MySQL debido a: \n";
    echo "Errno: " . $bd1->connect_errno . "\n";
    echo "Error: " . $bd1->connect_error . "\n";
    
    // Podría ser conveniente mostrar algo interesante, aunque nosotros simplemente saldremos
    exit;
}
?>

<!DOCTYPE html>
<HTML>
<HEAD>
	<meta charset="ÚTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="fonts/style.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.js"></script>
	<link href="<link href="https://fonts.googleapis.com/css?family=Oswald|Raleway|Roboto+Condensed" rel="stylesheet">
	<TITLE>Test Ingreso</TITLE>
	<div style="background-color: #6B0D0D">
		<center><img src="imagenes/encabezado.png"></center>
	</div>
	<style>
		h1 span {
			color: blue;
			margin-right:20px;
		}
		body {
			font-family:Roboto, Helvetica, Arial;
			background: url(imagenes/bn2.png)
		}
	</style>
</HEAD>

<BODY>
<br>
<center>
<h1 align ="center"><span class="icon-home2"></span><span style="color:black">Prueba de Conocimientos</span></h1>
</center>
<br>
<br>
<form align="center" action="expectativa.php" target = "_newblank" method="get">
	<table  width="100%">
<tr>
<td align="center" width="70%">
	<label for="nombre">Nombre: </label>
	<input type="Text" id="nombre" name="nombre">
	<label>Correo </label><input type="email" placeholder="direccion@correo.com" name="correo">
	<select name="tipoid">
		<option value="Cedula">CC</option>
		<option value="Tarjeta">TI</option>
		<option value="Extranjeria">CE</option>
	</select>
	<label>Documento </label><input type="Text" name="documento">
	<label>Celular </label><input type="Tel" placeholder="xxx-xxxxxxx" name="celular">
<button class="ui primary button">
	Enviar
</button>
</td>
</table>
</form>
</div>
<?php

$sqld = "insert into usuarios (usu_tipoid, usu_numid, usu_nombre, usu_telefono, usu_correo values  ";
?>
<br>
<br>
<br>
<div align = center table>
	<table width="60%">
	<tr>
	<th width="3%">No</th>
	<th width="45%">Pregunta</th>
	</tr>
</div>

<?php


$sql = "SELECT pre_id,pre_detalle from preguntas";
IF (isset($_REQUEST["cadena"]) ) {
  $cadena=$_REQUEST["cadena"];
}

if (!$resultado = $bd1->query($sql)) {
    // ¡Oh, no! La consulta falló.
    echo "Lo sentimos, este sitio web está experimentando problemas.";

    // De nuevo, no hacer esto en un sitio público, aunque nosotros mostraremos
    // cómo obtener información del error
    echo "Error: La ejecución de la consulta falló debido a: \n";
    echo "Query: " . $sql . "\n";
    echo "Errno: " . $mysqli->errno . "\n";
    echo "Error: " . $mysqli->error . "\n";
    exit;
}
if ($resultado->num_rows === 0) {
    // ¡Oh, no ha filas! Unas veces es lo previsto, pero otras
    // no. Nosotros decidimos. En este caso, ¿podría haber sido
    // actor_id demasiado grande? 
    echo "Lo sentimos. No se pudo encontrar una coincidencia para la busqueda. Inténtelo de nuevo.";
    exit;
}
//$cliente = $resultado->fetch_assoc();
while ($cliente = $resultado->fetch_assoc()) {

     echo "
<tr>
<td align=center>".$cliente['pre_id']."</td>
<td align=left>".$cliente['pre_detalle']."</td>
</tr>";
 }

?>

	</table>
<br>
</BODY>

<div = "redes">
	<div = "video">
		<video src="video/bs.mp4" controls="controls" width=150 height=150></video>
	</div>
<br>
<button class="ui facebook button">
  <i class="facebook icon"></i>
  Shared on Facebook
</button>
<button class="ui youtube button">
  <i class="youtube icon"></i>
  YouTube
</button>
<button class="ui twitter button">
  <i class="twitter icon"></i>
  Shared on Twitter
</button>
<button class="ui google plus button">
  <i class="google plus icon"></i>
  Google Plus
</button>
<button class="ui linkedin button">
  <i class="linkedin icon"></i>
  Shared on LinkedIn
</button>
<button class="ui instagram button">
  <i class="instagram icon"></i>
  Shared on Instagram
</button>
</div>
</HTML>
<?php
$resultado->free();
$bd1->close();
?>