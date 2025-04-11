package com.jee.beans;

public class Stagiaire {
	private String num_stagiaire;
	private String nom_stagiaire;
	private String prenom_stagiaire;
	private String sexe_stagiaire;
	private String dnaiss_stagiaire;
	private String diplo_stagiaire;
	private static int c=0;
	
	public Stagiaire() {
		super();
	}

	
	public Stagiaire(String nom_stagiaire, String prenom_stagiaire, String sexe_stagiaire, String dnaiss_stagiaire,
			String diplo_stagiaire) {
		super();
		this.num_stagiaire = ""+ c++;
		this.nom_stagiaire = nom_stagiaire;
		this.prenom_stagiaire = prenom_stagiaire;
		this.sexe_stagiaire = sexe_stagiaire;
		this.dnaiss_stagiaire = dnaiss_stagiaire;
		this.diplo_stagiaire = diplo_stagiaire;
	}


	public Stagiaire(String num_stagiaire, String nom_stagiaire, String prenom_stagiaire, String sexe_stagiaire,
			String dnaiss_stagiaire, String diplo_stagiaire) {
		super();
		this.num_stagiaire = num_stagiaire;
		this.nom_stagiaire = nom_stagiaire;
		this.prenom_stagiaire = prenom_stagiaire;
		this.sexe_stagiaire = sexe_stagiaire;
		this.dnaiss_stagiaire = dnaiss_stagiaire;
		this.diplo_stagiaire = diplo_stagiaire;
	}



	public String getNum_stagiaire() {
		return num_stagiaire;
	}

	public void setNum_stagiaire(String num_stagiaire) {
		this.num_stagiaire = num_stagiaire;
	}

	public String getNom_stagiaire() {
		return nom_stagiaire;
	}

	public void setNom_stagiaire(String nom_stagiaire) {
		this.nom_stagiaire = nom_stagiaire;
	}

	public String getPrenom_stagiaire() {
		return prenom_stagiaire;
	}

	public void setPrenom_stagiaire(String prenom_stagiaire) {
		this.prenom_stagiaire = prenom_stagiaire;
	}
	
	public String getSexe_stagiaire() {
		return sexe_stagiaire;
	}

	public void setSexe_stagiaire(String sexe_stagiaire) {
		this.sexe_stagiaire = sexe_stagiaire;
	}

	public String getDnaiss_stagiaire() {
		return dnaiss_stagiaire;
	}

	public void setDnaiss_stagiaire(String dnaiss_stagiaire) {
		this.dnaiss_stagiaire = dnaiss_stagiaire;
	}

	public String getDiplo_stagiaire() {
		return diplo_stagiaire;
	}

	public void setDiplo_stagiaire(String diplo_stagiaire) {
		this.diplo_stagiaire = diplo_stagiaire;
	}

	public String toString() {
		return "Stagiaire [num_stagiaire=" + num_stagiaire + ", nom_stagiaire=" + nom_stagiaire + ", prenom_stagiaire="
				+ prenom_stagiaire + ", sexe_stagiaire=" + sexe_stagiaire + ", dnaiss_stagiaire=" + dnaiss_stagiaire
				+ ", diplo_stagiaire=" + diplo_stagiaire + "]";
	}

	

	
	
}