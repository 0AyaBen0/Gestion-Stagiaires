package com.jee.business;

import java.util.List;

import com.jee.beans.Inscription;
import com.jee.beans.Stage;
import com.jee.beans.Stagiaire;

public interface StageBusiness {
	
	public void ajouterStage(Stage stg);
	public void ajouterStagiaire(Stagiaire stgr);
	public int ajouterInscription(Inscription ins);
	public List<Stage> listerParDate();
	public List<Stage> listerParType();
	public List<Stagiaire> listerStagiaires();
	public List<Stagiaire> listerInscrits(Stage stg);
	public Stage selectionnerStage(String code);
	public Stagiaire selectionnerStagiaire(String num);
}
