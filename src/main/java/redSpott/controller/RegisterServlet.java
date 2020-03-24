package redSpott.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redSpott.dao.DataSource;
import redSpott.dao.UserDAO;
import redSpott.model.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/myaccount.jsp";
		String name = request.getParameter("txtName");
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		DataSource datasource = new DataSource();
		UserDAO userdao = new UserDAO(datasource);
		userdao.create(user);
		try {
			datasource.getConnection().close();
		}
		catch(Exception e) {
			e.printStackTrace();
			page = "/error.jsp";
			request.setAttribute("errorSTR", "Something went wrong");
		}
		if (user.getId()!=0) {
			request.getSession().setAttribute("userSTR", user);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
