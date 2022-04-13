<!DOCTYPE html>

<html>
<head>
	  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<form action="processLogin" method = "POST">
	<div class = "container">
		<div class="row">
			<div class="col-sm-10"> <label>User Name</label> </div>
			<div class="col-sm-10"> <input type = "text" name = "user-name"/> </div>
		</div></br>
		<div class="row">
			<div class="col-sm-10"> <label>Password</label> </div>
			<div class="col-sm-10"> <input type = "text" name = "password"/> </div>
		</div></br>
		<div class="row">
			<div class="col-sm-10"><input type="submit" class="btn btn-primary" />  </div>
		</div>
	</div>
</form>


</html>