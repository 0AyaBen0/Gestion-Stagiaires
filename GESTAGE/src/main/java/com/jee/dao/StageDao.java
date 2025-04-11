package com.jee.dao;

import java.util.List;

import com.jee.beans.Inscription;
import com.jee.beans.Stage;
import com.jee.beans.Stagiaire;

public interface StageDao {
	
	public int addStage(Stage stg);
	public int addStagiaire(Stagiaire stgr);
	public List<Stage> getAllDate();
	public List<Stage> getAllType();
	public int addInscription(Inscription ins);
	public List<Stagiaire> getAllStagiaire();
	public List<Stagiaire> getAllInscrits(Stage stg);
	public Stage getStagebyCode(String code);
	public Stagiaire getStagiairebyNum(String num);
	public List<Stage> getAllStages();
}
