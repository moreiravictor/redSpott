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

/**
 * Servlet implementation class createPlaylistServlet
 */
public class createPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public createPlaylistServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/index.html";
		try {
			User user = (User) request.getSession().getAttribute("userSTR");
			if (user != null) {
				String title = request.getParameter("txtPlaylistName");
				Playlist playlist = new Playlist();
				playlist.setPlaylistName(title);
				playlist.setUser(user);
				DataSource datasource = new DataSource();
				PlaylistDAO playlistDAO = new PlaylistDAO(datasource);
				playlistDAO.create(playlist);
				datasource.getConnection().close();
				if (user.getPlaylists() == null) user.setPlaylists(new ArrayList<Playlist>());
				user.getPlaylists().add(playlist);
				request.getSession().setAttribute("userSTR", user);
				page = "/myaccount.jsp";
			}
		}
		catch(Exception e) {
			request.setAttribute("errorSTR", "Somethins went wrong when creating the playlist");
			page = "/error.jsp";
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
