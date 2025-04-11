<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GESTAGE</title>
<link rel="stylesheet" href="css/formInscrip.css">
</head>
<body>
<div class="container">
<h2>>>Veuillez selectionner un autre stagiaire pour ce stage!</h2>

	<form action="back.do" method="get">	
	
   		<div class="form-group">
   			<label for="Stage">Stage :</label>
   			<input type="text" id="id1" name="code" value="<%= (String)request.getAttribute("code") %>" readonly>
   		</div>
   		<div class="form-group">
   			<label for="Du">DU</label>
   			<input type="text" id="id2" name="du" value="<%=(String)request.getAttribute("debut")%>" readonly>
   		</div>
   		<div class="form-group">
   			<label for="Au">AU</label>
   			<input type="text" id="id3" name="au" value="<%=(String)request.getAttribute("fin")%>" readonly>	
   		</div>
   		<button type="submit" value="Retour à l'inscription">Retour à l'inscription</button>
   		   		<button><a href="Gestion_stagiaire.jsp">Retour au stages</a></button>
   		</form>
</div>
</body>
</html>