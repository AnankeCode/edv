<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido! :D</title>
</head>
<body>

	<div align="center">
		<table>
			<tr>
				<td>
					<form action="ServletRegistro" method="post">
						<table>
							<tr>
								<td>Tipo De Documento</td>
								<td><input type="text" size="20" name="usu_tipoid"></td>
							</tr>
							<tr>
								<td>Numero De Identificacion:</td>
								<td><input type="text" size="20" name="usu_numid"></td>
							</tr>
							<tr>
								<td>Nombre Completo:</td>
								<td><input type="text" size="20" name="usu_nombre"></td>
							</tr>
							<tr>
								<td>Correo Electronico:</td>
								<td><input type="text" size="20" name="usu_correo"></td>
							</tr>
							<tr>
								<td>Telefono:</td>
								<td><input type="text" size="20" name="usu_telefono"></td>
							</tr>
							<tr>
								<td>Celular:</td>
								<td><input type="password" size="20" name="usu_celular"></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="Registrar"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
