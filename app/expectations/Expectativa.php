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
	<TITLE>Expectativa</TITLE>
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
<h1 align ="center"><span class="icon-pencil"></span><span style="color:black">Expectativas</span></h1>
</center>

<div align = center table>
	<table width="60%">
	<tr>
	<th width="3%">No</th>
	<th width="45%">Pregunta</th>
	</tr>
</div>

<?php

$sql = "SELECT exp_id,exp_detalle from expectativa";
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
<td align=center>".$cliente['exp_id']."</td>
<td align=left>".$cliente['exp_detalle']."</td>
</tr>";
 }

?>

	</table>
<br>
</BODY>
<form align="center" action="Recomendacion.php" target = "_newblank" method="get">
	<button class="ui primary button">
		Terminar
	</button>
</form>
</HTML>
<?php
$resultado->free();
$bd1->close();
?>