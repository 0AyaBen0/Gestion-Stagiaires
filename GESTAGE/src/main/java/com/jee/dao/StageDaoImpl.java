package com.jee.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.Inscription;
import com.jee.beans.Stage;
import com.jee.beans.Stagiaire;

public class StageDaoImpl implements StageDao{
	
	private OracleDataSource ods = new OracleDataSource();
	public Connection cnx;

	
		public StageDaoImpl(Connection cnx) {
		this.cnx=cnx;
	}
	
	public int addStage(Stage stg) {
		try {
			
			String req = "INSERT INTO stage VALUES ('"+stg.getCODE_STAGE()+"', '"+stg.getTYPE_STAGE()
					+"', TO_DATE('"+Date.valueOf(stg.getDEBUT_STAGE())+"' , 'yyyy-MM-dd'), TO_DATE('"
					+Date.valueOf(stg.getFIN_STAGE())+"', 'yyyy-MM-dd'), '"
					+stg.getNBPLACE_STAGE()+"', '"+stg.getNBINSCRIT_STAGE()+ "')";
			
			Statement st = cnx.createStatement();
			int r = st.executeUpdate(req);
			System.out.println("stage added successfully");
			return r;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return -1;
		}

	}
	
	public int addInscription(Inscription ins) {
		try {			
	        CallableStatement cstmt = cnx.prepareCall("{call ANONYMOUS.pInscription('"
	        		+ins.getStage().getCODE_STAGE()+ "', '"+ ins.getStagiaire().getNum_stagiaire()+"', TO_DATE('"
	        		+Date.valueOf(ins.getDate_iscrip())+"', 'yyyy-MM-dd'), '"+ ins.getStatut_inscrip() +"')}");
	        cstmt.execute();

			return 0;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}	
	}
	
	private Stagiaire selectMax() {
		Stagiaire stagiaire = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
		    String req = "SELECT * FROM (SELECT * FROM Stagiaire ORDER BY num_stagiaire DESC) WHERE ROWNUM = 1";
			Statement st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(req);
			if(rs.first()) {
				String num = rs.getString(1);
				String nom = rs.getString(2);
				String prenom = rs.getString(3);
				String sexe = rs.getString(4);
				String date_naiss = dateFormat.format(rs.getDate(5));
				String diplo = rs.getString(6);
				stagiaire = new Stagiaire(num, nom, prenom, sexe, date_naiss, diplo);
			}
			return stagiaire;
		}catch(Exception e) {
			e.printStackTrace();
			return new Stagiaire("0", "", "", "", "");
		}
		
	}
	public int addStagiaire(Stagiaire stgr) {
		try {
			int nums = Integer.parseInt(selectMax().getNum_stagiaire().trim())+1;
			String req = "INSERT INTO stagiaire VALUES ('"+nums+"', '"+stgr.getNom_stagiaire()+"','"
					+stgr.getPrenom_stagiaire()+"' ,'"+stgr.getSexe_stagiaire() +"', "
					+ "TO_DATE('"+Date.valueOf(stgr.getDnaiss_stagiaire())+"', 'yyyy-MM-dd'), '"
					+stgr.getDiplo_stagiaire()+"')";
			
			Statement st = cnx.createStatement();
			int r = st.executeUpdate(req);
			System.out.println("stagiaire added successfully");
			
			return r;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return -1;
		}
	}
	
		
	public List<Stage> getAllDate() {
		
		try {
			String req = "select * from Stage order by DEBUT_STAGE asc";
			Statement s = this.cnx.createStatement();
			ResultSet r = s.executeQuery(req);
			List<Stage> stages = new ArrayList<>();
		while (r.next()) {
            Stage stage = new Stage();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            stage.setCODE_STAGE(r.getString("CODE_STAGE"));
            stage.setTYPE_STAGE(r.getString("TYPE_STAGE"));
            stage.setNBINSCRIT_STAGE(r.getInt("NBINSCRIT_STAGE"));
            stage.setNBPLACE_STAGE(r.getInt("NBPLACE_STAGE"));
            Date debutStageDate = r.getDate("DEBUT_STAGE");
            Date finStageDate = r.getDate("FIN_STAGE");
            String debutStage = dateFormat.format(debutStageDate);
            String finStage = dateFormat.format(finStageDate);
            stage.setDEBUT_STAGE(debutStage);
            stage.setFIN_STAGE(finStage);
            stages.add(stage);
            }
		return stages;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public List<Stage> getAllType() {
		try {
			String req = "select * from Stage order by TYPE_STAGE";
			Statement s = this.cnx.createStatement();
			ResultSet r = s.executeQuery(req);
			List<Stage> stages = new ArrayList<>();
		while (r.next()) {
            Stage stage = new Stage();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            stage.setCODE_STAGE(r.getString("CODE_STAGE"));
            stage.setTYPE_STAGE(r.getString("TYPE_STAGE"));
            stage.setNBINSCRIT_STAGE(r.getInt("NBINSCRIT_STAGE"));
            stage.setNBPLACE_STAGE(r.getInt("NBPLACE_STAGE"));
            Date debutStageDate = r.getDate("DEBUT_STAGE");
            Date finStageDate = r.getDate("FIN_STAGE");
            String debutStage = dateFormat.format(debutStageDate);
            String finStage = dateFormat.format(finStageDate);

            stage.setDEBUT_STAGE(debutStage);
            stage.setFIN_STAGE(finStage);
            stages.add(stage);
            }
		return stages;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public List<Stagiaire> getAllInscrits(Stage stg) {
		try {
		String req="select s.num_stagiaire, s.nom_stagiaire, s.prenom_stagiaire, s.sexe_stagiaire, s.dnaiss_stagiaire, s.diplo_stagiaire "
				+ "from Stagiaire s join Inscription i on s.num_stagiaire=i.num_stagiaire and i.code_stage="+stg.getCODE_STAGE();
		Statement st=cnx.createStatement();
		ResultSet rs=st.executeQuery(req);
		List<Stagiaire> ls=new ArrayList<>();
		while(rs.next()) {
			Stagiaire sta =new Stagiaire();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			sta.setNum_stagiaire(rs.getString("num_stagiaire"));
			sta.setNom_stagiaire(rs.getString("nom_stagiaire"));
			sta.setPrenom_stagiaire(rs.getString("prenom_stagiaire"));
			sta.setDiplo_stagiaire(rs.getString("diplo_stagiaire"));
			Date d=rs.getDate("dnaiss_stagiaire");
			String nais=df.format(d);
			sta.setDnaiss_stagiaire(nais);
			sta.setSexe_stagiaire(rs.getString("sexe_stagiaire"));
			ls.add(sta);	
			}
			return ls;
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Stagiaire> getAllStagiaire() {
		try {
		String req="select * from Stagiaire";
		Statement st = this.cnx.createStatement();
		ResultSet rs=st.executeQuery(req);
		List<Stagiaire> ls=new ArrayList<>();
		while(rs.next()) {
			Stagiaire sta =new Stagiaire();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			sta.setNum_stagiaire(rs.getString("num_stagiaire"));
			sta.setNom_stagiaire(rs.getString("nom_stagiaire"));
			sta.setPrenom_stagiaire(rs.getString("prenom_stagiaire"));
			sta.setDiplo_stagiaire(rs.getString("diplo_stagiaire"));
			Date d=rs.getDate("dnaiss_stagiaire");
			String nais=df.format(d);
			sta.setDnaiss_stagiaire(nais);
			sta.setSexe_stagiaire(rs.getString("sexe_stagiaire"));
			ls.add(sta);
			
		}
			return ls;
		
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}

		
	}
	
	public Stage getStagebyCode(String code) {
		Stage stage = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String req = "select * from stage where CODE_STAGE = " + code;
			Statement st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(req);
			if(rs.first()) {
				String type = rs.getString(2);
				String date_debut = dateFormat.format(rs.getDate(3));
				String date_fin = dateFormat.format(rs.getDate(4));
				int nb_place = rs.getInt(5);
				int nb_inscrits = rs.getInt(6);
				stage = new Stage(code, type, date_debut, date_fin, nb_place, nb_inscrits);
			}
			return stage;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Stagiaire getStagiairebyNum(String num) {
		Stagiaire stagiaire = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String req = "select * from stagiaire where NUM_STAGIAIRE = " + num;
			Statement st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(req);
			if(rs.first()) {
				String nom = rs.getString(2);
				String prenom = rs.getString(3);
				String sexe = rs.getString(4);
				String date_naiss = dateFormat.format(rs.getDate(5));
				String diplo = rs.getString(6);
				stagiaire = new Stagiaire(num, nom, prenom, sexe, date_naiss, diplo);
			}
			return stagiaire;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Stage> getAllStages() {
		try {
			String req = "select * from Stage order by code_stage";
			Statement s = this.cnx.createStatement();
			ResultSet r = s.executeQuery(req);
			List<Stage> stages = new ArrayList<>();
		while (r.next()) {
            Stage stage = new Stage();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            stage.setCODE_STAGE(r.getString("CODE_STAGE"));
            stage.setTYPE_STAGE(r.getString("TYPE_STAGE"));
            stage.setNBINSCRIT_STAGE(r.getInt("NBINSCRIT_STAGE"));
            stage.setNBPLACE_STAGE(r.getInt("NBPLACE_STAGE"));
            Date debutStageDate = r.getDate("DEBUT_STAGE");
            Date finStageDate = r.getDate("FIN_STAGE");
            String debutStage = dateFormat.format(debutStageDate);
            String finStage = dateFormat.format(finStageDate);

            stage.setDEBUT_STAGE(debutStage);
            stage.setFIN_STAGE(finStage);
            stages.add(stage);
            }
		return stages;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}


}
