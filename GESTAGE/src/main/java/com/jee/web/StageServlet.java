package com.jee.web;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.Inscription;
import com.jee.beans.Stage;
import com.jee.beans.Stagiaire;
import com.jee.business.StageManager;
import com.jee.dao.OracleDataSource;
import com.jee.dao.StageDao;
import com.jee.dao.StageDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StageServlet extends HttpServlet {
	private OracleDataSource ods = new OracleDataSource();
	private Connection cnx = ods.getConnection();
	
	private StageDao dao = new StageDaoImpl(cnx);
	private StageManager sg=new StageManager(dao);

	
	public void init() throws ServletException {
		sg = new StageManager(dao);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String uri = req.getRequestURI();
		
		if(uri.contains("nouvelle_inscrip")){
			String code = req.getParameter("code");
			Stage stg = sg.selectionnerStage(code);
			String debut_date = stg.getDEBUT_STAGE();
			String fin_date = stg.getFIN_STAGE();
			List<Stagiaire> st = sg.listerStagiaires();
			req.setAttribute("st",st);
			req.setAttribute("code", code);
			req.setAttribute("stage", stg);
			req.setAttribute("debut", debut_date);
			req.setAttribute("fin", fin_date);
			req.getRequestDispatcher("formInscrip.jsp").forward(req, res);
		}
		else if(uri.contains("select_stgr")) {
			String code = req.getParameter("code");
			System.out.println(code);
			Stage stg = sg.selectionnerStage(code);
			String debut_date = stg.getDEBUT_STAGE();
			String fin_date = stg.getFIN_STAGE();
			List<Stagiaire> st = sg.listerStagiaires();
			req.setAttribute("st",st);
			req.setAttribute("code", code);
			req.setAttribute("stage", stg);
			req.setAttribute("debut", debut_date);
			req.setAttribute("fin", fin_date);
		    String selectedValue = req.getParameter("option_stgr");
		    Stagiaire stgr = sg.selectionnerStagiaire(selectedValue);
		    String statut = req.getParameter("statut_inscrip");
			String button = req.getParameter("button");
			if(button.equals("valider")) {
			    LocalDate today = LocalDate.now();
			    DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String date_inscrip=df.format(today);
				System.out.println(date_inscrip);
		   		Inscription ins = new Inscription(stg, stgr, date_inscrip, statut);
		    	if(sg.ajouterInscription(ins)==0) {
		    		sg.ajouterInscription(ins);
			    	req.getRequestDispatcher("listeDesInscrits.jsp").forward(req, res);
		    	}else if(sg.ajouterInscription(ins)==-1) {
			    	req.getRequestDispatcher("error_page.jsp").forward(req, res);
		    	}
		   	}
			else if(button.equals("nouveau")) {
			   	req.getRequestDispatcher("creation.jsp").forward(req, res);
			}
		}
		else if(uri.contains("ajouter_stagiaire")) {
			
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String date = req.getParameter("date");
			String diplo = req.getParameter("diplo");
			String sexe = req.getParameter("gender");
			
			Stagiaire stgr = new Stagiaire(nom, prenom, sexe, date, diplo);
			sg.ajouterStagiaire(stgr);
			req.getRequestDispatcher("creation.html").forward(req, res);
			
		}
		else if(uri.contains("back")) {
			String code = req.getParameter("code");
			System.out.println(code);
			Stage stg = sg.selectionnerStage(code);
			String debut_date = stg.getDEBUT_STAGE();
			String fin_date = stg.getFIN_STAGE();
			List<Stagiaire> st = sg.listerStagiaires();
			req.setAttribute("st",st);
			req.setAttribute("code", code);
			req.setAttribute("stage", stg);
			req.setAttribute("debut", debut_date);
			req.setAttribute("fin", fin_date);
			req.getRequestDispatcher("formInscrip.jsp").forward(req, res);
		}
		else if(uri.contains("order")) {
			String button = req.getParameter("sort");
			List<Stage> stg = null;
			if(button.equals("date")) {
				stg = sg.listerParDate();
				req.setAttribute("stages", stg);
				req.getRequestDispatcher("sortedList.jsp").forward(req, res);
			}else if(button.equals("type")){
				stg = sg.listerParType();
				req.setAttribute("stages", stg);
				req.getRequestDispatcher("sortedList.jsp").forward(req, res);
			}
			else if(button.equals("fin")) {
				req.getRequestDispatcher("Gestion_stagiaire.jsp").forward(req, res);
			}
		}
		else if(uri.contains("getStage")) {
			String code = req.getParameter("code");
			Stage stg = sg.selectionnerStage(code);
			String debut_date = stg.getDEBUT_STAGE();
			String fin_date = stg.getFIN_STAGE();
			req.setAttribute("code", code);
			req.setAttribute("stage", stg);
			req.setAttribute("debut", debut_date);
			req.setAttribute("fin", fin_date);
			req.getRequestDispatcher("listeDesInscrits.jsp").forward(req, res);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	

}
