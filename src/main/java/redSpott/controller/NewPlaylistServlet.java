package redSpott.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redSpott.model.User;

/**
 * Servlet implementation class NewPlaylistServlet
 */
public class NewPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/index.html";
		User user = (User) request.getSession().getAttribute("userSTR");
		if (user != null) {
			page = "/newplaylist.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
