package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import model.User;
import controller.UserBean;

/**
 * Servlet implementation class ServletRegistry
 */
@WebServlet("/ServletRegistry")
public class ServletRegistry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistry() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String usu_tipoid = request.getParameter("usu_tipoid");
		String usu_numid = request.getParameter("usu_numid");
		String usu_nombre = request.getParameter("usu_nombre");
		String usu_correo = request.getParameter("usu_correo");
		String usu_telefono = request.getParameter("usu_telefono");
		String usu_celular = request.getParameter("usu_celular");
		if (!usu_tipoid.equalsIgnoreCase("") && !usu_numid.equalsIgnoreCase("") && !usu_nombre.equalsIgnoreCase("")
				&& !usu_correo.equalsIgnoreCase("") && !usu_telefono.equalsIgnoreCase("")
				&& !usu_celular.equalsIgnoreCase("")) {
			UserBean buser = new UserBean(usu_tipoid, usu_numid, usu_nombre, usu_correo, usu_telefono, usu_celular);
			boolean ag = User.agregarUsuario(buser);
			if (ag) {
				request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("Tu solicitud no ha podido ser completada , intentalo mas tarde");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usu_tipoid = request.getParameter("usu_tipoid");
		String usu_numid = request.getParameter("usu_numid");
		String usu_nombre = request.getParameter("usu_nombre");
		String usu_correo = request.getParameter("usu_correo");
		String usu_telefono = request.getParameter("usu_telefono");
		String usu_celular = request.getParameter("usu_celular");
		if (!usu_tipoid.equalsIgnoreCase("") && !usu_numid.equalsIgnoreCase("") && !usu_nombre.equalsIgnoreCase("")
				&& !usu_correo.equalsIgnoreCase("") && !usu_telefono.equalsIgnoreCase("")
				&& !usu_celular.equalsIgnoreCase("")) {
			UserBean buser = new UserBean(usu_tipoid, usu_numid, usu_nombre, usu_correo, usu_telefono, usu_celular);
			boolean ag = User.agregarUsuario(buser);
			if (ag) {
				request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("Tu solicitud no ha podido ser completada , intentalo mas tarde");
			}
		}
	}

}
