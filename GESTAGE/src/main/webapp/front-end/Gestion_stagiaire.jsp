<%@page import="com.jee.business.StageManager"%>
<%@page import="com.jee.dao.StageDaoImpl"%>
<%@page import="com.jee.dao.StageDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.jee.dao.OracleDataSource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.jee.beans.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GESTAGE</title>
<link rel="stylesheet" href="css/gestion_stagiaire.css">
</head>
<body>
<%  OracleDataSource ods = new OracleDataSource();
 	Connection cnx = ods.getConnection();
 	StageDao dao = new StageDaoImpl(cnx);
 	StageManager sg=new StageManager(dao); %>
   <div>
       <h1>Inscription à un stage</h1>
   </div>
   <div>
   
    <% List<Stage> stages = sg.listerStages(); %> 
    
    <script>
    document.getElementById("type").addEventListener("click",function(){
    	stages = sg.getAllType();
        alert("TRI PAR TYPE !");
    });
</script> 
 <script>
    document.getElementById("date").addEventListener("click",function() {
    	stages = sg.GetAllDate() ;
        alert("TRI PAR DATE !");
    });
</script>
<form action="getStage.do" method="get">
   <table border="1">
     <tr>
     <td>NOSTA</td>
     <td>TYPSTA</td>
     <td>NBINSCRITS</td>
     <td>DATEDEB</td>
     <td>DATEFIN</td>
     </tr>
     
       <% for(Stage stage : stages) { %>
       
     <tr>
     <td><button type="submit" name="code" value="<%=stage.getCODE_STAGE()%>"><%=stage.getCODE_STAGE()%></button></td>
     <td><%= stage.getTYPE_STAGE() %></td>
     <td><%= stage.getNBINSCRIT_STAGE() %></td>
     <td><%= stage.getDEBUT_STAGE() %></td>
     <td><%= stage.getFIN_STAGE() %></td>
     </tr>
     <%} %>
   </table></form>
   
   <form action="order.do" method="get">

   
   <button id="date" type="submit" value="date" name="sort">Liste par date</button>
   <button id="type" type="submit" value="type" name="sort">Liste par Type</button>  
   <button><a class="link" href="Gestion_stagiaire.jsp">Fin</a></button>
   </form>
   
       
   </div>

</body>
</html>