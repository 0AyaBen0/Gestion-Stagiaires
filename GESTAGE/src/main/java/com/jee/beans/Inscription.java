package com.jee.beans;

public class Inscription {
	
	private Stage stage;
	private Stagiaire stagiaire;
	private String date_iscrip;
	private String statut_inscrip;
	private int code_position;
	
	public Inscription() {
	}

	public Inscription(Stage stage, Stagiaire stagiaire, String date_iscrip, String statut_inscrip, int code_position) {
		this.stage = stage;
		this.stagiaire = stagiaire;
		this.date_iscrip = date_iscrip;
		this.statut_inscrip = statut_inscrip;
		this.code_position = code_position;
	}
	
	public Inscription(Stage stage, Stagiaire stagiaire, String date_iscrip, String statut_inscrip) {
		super();
		this.stage = stage;
		this.stagiaire = stagiaire;
		this.date_iscrip = date_iscrip;
		this.statut_inscrip = statut_inscrip;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public String getDate_iscrip() {
		return date_iscrip;
	}

	public void setDate_iscrip(String date_iscrip) {
		this.date_iscrip = date_iscrip;
	}

	public String getStatut_inscrip() {
		return statut_inscrip;
	}

	public void setStatut_inscrip(String statut_inscrip) {
		this.statut_inscrip = statut_inscrip;
	}

	public int getCode_position() {
		return code_position;
	}

	public void setCode_position(int code_position) {
		this.code_position = code_position;
	}

	public String toString() {
		return "Inscription [stage=" + stage + ", stagiaire=" + stagiaire + ", date_iscrip=" + date_iscrip
				+ ", statut_inscrip=" + statut_inscrip + ", code_position=" + code_position + "]";
	}
}
