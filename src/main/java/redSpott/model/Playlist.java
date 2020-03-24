package redSpott.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Playlist {
	private String playlistName;
	private int id;
	private User user;
	private List<Song> songs;
}
