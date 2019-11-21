<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:useBean id="userSTR" type="redSpott.model.User" scope="session" />
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Red Spott</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <style></style>

  </head>
  <body>

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12" align="center">
		<strong>Red Spot!</strong>
		</div>
	</div>
	<h4 align="center">
		Welcome ${userSTR.getName()}
	</h4>
	</div>
	<div class="userMenu">
		<div class="userMenuit"><a href="myplaylists">My Playlists</a></div>
		<div class="userMenuit"><a href="newplaylist">New Playlists</a></div>
		<div class="userMenuit"><a href="newsongs">Upload new songs</a></div>
		<div class="userMenuit"><a href="logout">Logout</a></div>
	</div>
	<div class ="subtitle">Your playlists are here!</div>
	<div class ="list">
	<c:forEach var = "playlist" items="${userSTR.playlists}">
		<div class = "playItem">${playlist.playlistName}</div>
		<c:forEach var = "song" items="${playlist.songs}">
			<div class = "playItem">${song.songName}</div>
		</c:forEach>
	</c:forEach>	
	</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>