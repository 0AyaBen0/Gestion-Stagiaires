package com.jee.business;

import java.sql.Connection;
import java.util.List;

import com.jee.beans.Inscription;
import com.jee.beans.Stage;
import com.jee.beans.Stagiaire;
import com.jee.dao.OracleDataSource;
import com.jee.dao.StageDao;
import com.jee.dao.StageDaoImpl;

public class StageManager implements StageBusiness {
	private StageDao dao;
	
	public StageManager() {
	}
	
	public StageManager(StageDao dao) {
		this.dao = dao;
	}
	
	public StageDao getDao() {
		return dao;
	}

	public void setDao(StageDao dao) {
		this.dao = dao;
	}
	
	public void ajouterStage(Stage stg) {
		dao.addStage(stg);
		
	}

	
	public void ajouterStagiaire(Stagiaire stgr) {
		dao.addStagiaire(stgr);
		
	}

	public int ajouterInscription(Inscription ins) {
		return dao.addInscription(ins);
		
	}


	public List<Stage> listerParDate() {
		
		return dao.getAllDate();
	}

	
	public List<Stage> listerParType() {
		
		return dao.getAllType();
	}


	public List<Stagiaire> listerStagiaires() {
	
		return dao.getAllStagiaire();
	}

	
	public List<Stagiaire> listerInscrits(Stage stg) {
		
		return dao.getAllInscrits(stg);
	}
	
	public List<Stage> listerStages(){
		return dao.getAllStages();
	}
	
	public Stage selectionnerStage(String code) {
		return dao.getStagebyCode(code);
	}
	
	public Stagiaire selectionnerStagiaire(String num) {
		return dao.getStagiairebyNum(num);
	}
	
}