package model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import controller.UserBean;

public class User {
	 public static boolean agregarUsuario(UserBean usuario){
		  boolean agregado=false;
		  try {
		   Conexion c=new Conexion();
		   Connection con=c.getConexion();
		   if(con!=null){
		    Statement st;
		    st = con.createStatement();
		    st.executeUpdate("INSERT INTO Usuarios(`usu_tipoid`,`usu_numid`,`usu_nombre`, `usu_correo`,`usu_telefono`,`usu_celular`) VALUES ('"+usuario.getUsu_tipoid()+"','"+usuario.getUsu_numid()+"',"+usuario.getUsu_nombre()+",'"+usuario.getUsu_correo()+"','"+usuario.getUsu_telefono()+"','"+usuario.getUsu_celular()+"')");
		    agregado=true;
		    st.close();
		   }
		   c.cerrarConexion();
		  } catch (SQLException e) {
		   agregado=false;
		   e.printStackTrace();
		  }
		  return agregado;
		 }
		}