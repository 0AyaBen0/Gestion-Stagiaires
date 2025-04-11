package com.jee.dao;

import java.sql.Connection;
import java.util.List;

import com.jee.beans.Inscription;
import com.jee.beans.Stage;
import com.jee.beans.Stagiaire;

public class TestDao {
	
	public static void main(String[] args) {
		OracleDataSource ods = new OracleDataSource();
		Connection cnx = ods.getConnection();
		StageDaoImpl db = new StageDaoImpl(cnx);
//		db.addStage(new Stage("4", "aabc", "2021-03-12", "2021-05-01", 50, 20));
		Stage stage = new Stage("4", "aabc", "2021-03-12", "2021-05-01", 50, 20);
		Stagiaire stgr = new Stagiaire("56", "qsdcxc", "qsdf", "M", "2005-03-25", "ing");
		
		
		Inscription ins = new Inscription(stage, stgr, "2021-01-05", "stu");
		System.out.println(db.addStagiaire(stgr));
		
//		System.out.println(db.getAllInscrits(stage));
	}

}
