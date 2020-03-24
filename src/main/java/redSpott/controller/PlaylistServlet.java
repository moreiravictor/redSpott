package redSpott.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redSpott.dao.DataSource;
import redSpott.dao.PlaylistDAO;
import redSpott.model.Playlist;
import redSpott.model.User;

public class PlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PlaylistServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/index.html";
		try {
			User user = (User) request.getSession().getAttribute("userSTR");
			if (user != null) {
				DataSource datasource = new DataSource();
				PlaylistDAO playDAO = new PlaylistDAO(datasource);
				ArrayList<Playlist> arrayPlay = (ArrayList<Playlist>) playDAO.read(user);
				user.setPlaylists(arrayPlay);
				request.getSession().setAttribute("userSTR", user);
				page = "/myplaylists.jsp";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(page);
		dispatch.forward(request, response);
	}

}
