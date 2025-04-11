<%@page import="com.jee.dao.StageDaoImpl"%>
<%@page import="com.jee.business.StageManager"%>
<%@page import="com.jee.dao.StageDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.jee.dao.OracleDataSource"%>
<%@page import="java.util.List"%>
<%@page import="com.jee.beans.Stagiaire"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GESTAGE</title>
<link rel="stylesheet" href="css/formInscrip.css">
</head>

<body>
<div class="container">
   <h2>Inscription à un stage</h2>
   <% OracleDataSource ods = new OracleDataSource();
   	 Connection cnx = ods.getConnection();
   	 StageDao dao = new StageDaoImpl(cnx);
   	 StageManager sg = new StageManager(dao); %>
   <% List<Stagiaire> stagiaires = (List<Stagiaire>)request.getAttribute("st"); %>
   <form action="select_stgr.do" method="get">	
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
   		<div class="form-group">
   			<label for="select">Selection stagiaire</label>
   			<select id="selects" name="option_stgr">
   			<option value="selectionner un stagiaire" disabled>selectionner un stagiaire</option>
   			<% for (Stagiaire stagiaire : stagiaires) { %>
   			    <option value="<%=stagiaire.getNum_stagiaire()%>"><%=stagiaire.getNom_stagiaire() + " " + stagiaire.getPrenom_stagiaire()%></option>
   			<% } %> 
   			</select>
   		</div>
   		<div class="form-group">
   			<label for="statut">Statut</label>
   			<select id="statuts" name="statut_inscrip">
   			    <option value="CIF">CIF</option>
   			    <option value="SIFE">SIFE</option>
   			    <option value="Force">Ch.Force</option>
   			    <option value="Pblic">Code Public</option>
   			</select>
   		</div>
   		<button type="submit" name="button" value="valider">Validation</button>
   		<button><a href="Gestion_stagiaire.jsp">Retour stage</a></button>
   </form>
   <button type="submit" value="nouveau"><a href="creation.html">Nouveau stagiaire</a></button>
</div>
</body>
</html>