package redSpott.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redSpott.dao.DataSource;
import redSpott.dao.UserDAO;
import redSpott.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/error.jsp";
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		User userRequest = new User();
		userRequest.setEmail(email);
		userRequest.setPassword(password);
		try {
			DataSource datasource = new DataSource();
			UserDAO userdao = new UserDAO(datasource);
			List<User> users = userdao.read(userRequest);
			
			if (!users.isEmpty()) {
				page = "/myaccount.jsp";
				request.getSession().setAttribute("userSTR", users.get(0));
			}
			else request.setAttribute("errorSTR", "Email/password not found");
			datasource.getConnection().close();
		}
		catch(Exception e) {
			request.setAttribute("errorSTR", "Erro ao recuperar conta");
		}
		RequestDispatcher ds = getServletContext().getRequestDispatcher(page);
		ds.forward(request, response);
	}

}
