package redSpott.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private List<Playlist> playlists;
	
}
