<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<jsp:useBean id="userSTR" type="redSpott.model.User" scope="session"/>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Red Spott</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12" align="center">
		<strong>Red Spot!</strong>
		<h4>Create your playlist ${userSTR.getName()}</h4>	
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<form role="form" action="createplaylist" method="POST">
				<div class="form-group">
					 
					<label for="exampleInputPlaylistName">
						Playlist name
					</label>
					<input type="text" class="form-control" id="exampleInputPlaylistName" name="txtPlaylistName">
				</div>
				<div class="subReg">
				<button type="submit" class="btn btn-primary">
					Create it
				</button>
				</div>
			</form>
		</div>
	</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>