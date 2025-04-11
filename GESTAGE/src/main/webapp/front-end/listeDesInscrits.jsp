<%@page import="com.jee.beans.Stage"%>
<%@page import="com.jee.beans.Stagiaire"%>
<%@page import="java.util.List"%>
<%@page import="com.jee.business.StageManager"%>
<%@page import="com.jee.dao.StageDaoImpl"%>
<%@page import="com.jee.dao.StageDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.jee.dao.OracleDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>GESTAGE</title>
    <link rel="stylesheet" href="css/listeDesInscrits.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    
</head>
<body>
    <% OracleDataSource ods = new OracleDataSource();
	 Connection cnx = ods.getConnection();
	 StageDao dao = new StageDaoImpl(cnx);
	 StageManager sg=new StageManager(dao); %>
	
	<% Stage stage = (Stage)request.getAttribute("stage"); %>
    <% List<Stagiaire> sl = sg.listerInscrits(stage); %>
        <div class="box">
            <a href="Gestion_stagiaire.jsp">  <i class="fa-solid fa-arrow-left-long"></i>  </a>
  
        </div>
        
        <div class="container">
            <form action="nouvelle_inscrip.do" method="get">
                <h2>Inscription à un stage</h2>
                <div class="content" >
                    <div class="input-box">
                        <label for="id1">Code Stage</label>
                        <input type="text"  id="id1" name="code" value="<%= (String)request.getAttribute("code") %>" readonly >
                    </div>

                    <div class="input-box">
                        <Label for="id2" >Du</label >
                        <input type="text" id="id2" name="du" value="<%=(String)request.getAttribute("debut")%>" readonly>
                    </div>

                    <div class="input-box">
                        <label for="id3">Au</label>
                        <input type="text" id="id3" name="au" value="<%=(String)request.getAttribute("fin")%>" readonly>
                    </div>
                </div>

                <div class="button-container">
                    <button type="submit">Nouvelle inscription</button>
                </div>
        
            </form>
        </div>

        <div class="container2">
        
                <h2>Liste des inscrits</h2>
                <div class="liste"> 
                <table border="1">
     <tr>
     <td>Numero</td>
     <td>Nom</td>
     <td>Prénom</td>
     <td>Sexe</td>
     <td>Date Naissance</td>
     <td>Diplome</td>
     </tr>
     
       <% for(Stagiaire stgr : sl) { %>
       
     <tr>
     <td><%=stgr.getNum_stagiaire()%></td>
     <td><%= stgr.getNom_stagiaire() %></td>
     <td><%= stgr.getPrenom_stagiaire() %></td>
     <td><%= stgr.getSexe_stagiaire() %></td>
     <td><%= stgr.getDnaiss_stagiaire() %></td>
     <td><%= stgr.getDiplo_stagiaire() %></td>

     </tr>
     <%} %>
   </table> </div>
    </div> 
        
        
</body>
</html>