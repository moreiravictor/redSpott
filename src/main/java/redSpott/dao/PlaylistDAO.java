package redSpott.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import redSpott.model.Playlist;
import redSpott.model.User;

public class PlaylistDAO {
	private DataSource datasource;
	public PlaylistDAO(DataSource datasource) {
		this.datasource = datasource;
	}
	public void create(Playlist playlist) {
		try {
			String SQL = "INSERT INTO tblPlaylist(titulo, iduser) VALUES (?, ?)";
			PreparedStatement stm = datasource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, playlist.getPlaylistName());
			stm.setInt(2, playlist.getUser().getId());
			int res = stm.executeUpdate();
			if (res == 0) {
				throw new RuntimeException("Not possible to create the playlist");
			}
			ResultSet rs = stm.getGeneratedKeys();
			if (rs.next()) playlist.setId(rs.getInt(1));
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Playlist> read(User user) {
		try {
			String SQL = "SELECT * FROM tblPlaylist WHERE iduser = ?";
			PreparedStatement stm = datasource.getConnection().prepareStatement(SQL);
			stm.setInt(1, user.getId());
			ResultSet rs = stm.executeQuery();
			ArrayList<Playlist> playlists = new ArrayList<Playlist>();
			while (rs.next()) {
				Playlist p = new Playlist();
				p.setPlaylistName(rs.getString("titulo"));
				p.setId(rs.getInt("idplaylist"));
				playlists.add(p);
			}
			stm.close();
			rs.close();
			return playlists;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
