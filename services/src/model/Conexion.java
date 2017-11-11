package model;
import java.sql.*;
public class Conexion {
	private Connection con = null;
	 public Conexion() {
	  try {
	   Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	   con = DriverManager.getConnection("jdbc:oracle://localhost:1521/XE", "alfa","bs12350");
	  } catch (InstantiationException | IllegalAccessException
	    | ClassNotFoundException | SQLException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	 }
	 
	 public Connection getConexion(){
	  return con;
	 }
	 
	 public void cerrarConexion(){
	  try {
	   con.close();
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 }
}
