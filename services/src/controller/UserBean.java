package controller;

public class UserBean {

	private String usu_tipoid;
	private String usu_numid;
	private String usu_nombre;
	private String usu_correo;
	private String usu_telefono;
	private String usu_celular;

	public String getUsu_tipoid() {
		return usu_tipoid;
	}

	public void setUsu_tipoid(String usu_tipoid) {
		this.usu_tipoid = usu_tipoid;
	}

	public String getUsu_numid() {
		return usu_numid;
	}

	public void setUsu_numid(String usu_numid) {
		this.usu_numid = usu_numid;
	}

	public String getUsu_nombre() {
		return usu_nombre;
	}

	public void setUsu_nombre(String usu_nombre) {
		this.usu_nombre = usu_nombre;
	}

	public String getUsu_correo() {
		return usu_correo;
	}

	public void setUsu_correo(String usu_correo) {
		this.usu_correo = usu_correo;
	}

	public String getUsu_telefono() {
		return usu_telefono;
	}

	public void setUsu_telefono(String usu_telefono) {
		this.usu_telefono = usu_telefono;
	}

	public String getUsu_celular() {
		return usu_celular;
	}

	public void setUsu_celular(String usu_celular) {
		this.usu_celular = usu_celular;
	}

	public UserBean(String usu_tipoid, String usu_numid, String usu_nombre, String usu_correo, String usu_telefono,
			String usu_celular) {
		super();
		this.usu_tipoid = usu_tipoid;
		this.usu_numid = usu_numid;
		this.usu_nombre = usu_nombre;
		this.usu_correo = usu_correo;
		this.usu_telefono = usu_telefono;
		this.usu_celular = usu_celular;
	}
}
