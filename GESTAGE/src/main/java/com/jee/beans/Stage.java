package com.jee.beans;

public class Stage {
	String CODE_STAGE;
	String TYPE_STAGE;
	String DEBUT_STAGE;
	String FIN_STAGE;
	int NBPLACE_STAGE;
	int NBINSCRIT_STAGE;
	
	
	public Stage() {
		
	}
	
	public Stage(String cODE_STAGE, String tYPE_STAGE, String dEBUT_STAGE, String fIN_STAGE, int nBPLACE_STAGE,
			int nBINSCRIT_STAGE) {
		super();
		CODE_STAGE = cODE_STAGE;
		TYPE_STAGE = tYPE_STAGE;
		DEBUT_STAGE = dEBUT_STAGE;
		FIN_STAGE = fIN_STAGE;
		NBPLACE_STAGE = nBPLACE_STAGE;
		NBINSCRIT_STAGE = nBINSCRIT_STAGE;
	}

	public String getCODE_STAGE() {
		return CODE_STAGE;
	}

	public void setCODE_STAGE(String cODE_STAGE) {
		CODE_STAGE = cODE_STAGE;
	}

	public String getTYPE_STAGE() {
		return TYPE_STAGE;
	}

	public void setTYPE_STAGE(String tYPE_STAGE) {
		TYPE_STAGE = tYPE_STAGE;
	}

	public String getDEBUT_STAGE() {
		return DEBUT_STAGE;
	}

	public void setDEBUT_STAGE(String dEBUT_STAGE) {
		DEBUT_STAGE = dEBUT_STAGE;
	}

	public String getFIN_STAGE() {
		return FIN_STAGE;
	}

	public void setFIN_STAGE(String fIN_STAGE) {
		FIN_STAGE = fIN_STAGE;
	}

	public int getNBPLACE_STAGE() {
		return NBPLACE_STAGE;
	}

	public void setNBPLACE_STAGE(int nBPLACE_STAGE) {
		NBPLACE_STAGE = nBPLACE_STAGE;
	}

	public int getNBINSCRIT_STAGE() {
		return NBINSCRIT_STAGE;
	}

	public void setNBINSCRIT_STAGE(int nBINSCRIT_STAGE) {
		NBINSCRIT_STAGE = nBINSCRIT_STAGE;
	}

	@Override
	public String toString() {
		return "Stage [CODE_STAGE=" + CODE_STAGE + ", TYPE_STAGE=" + TYPE_STAGE + ", DEBUT_STAGE=" + DEBUT_STAGE
				+ ", FIN_STAGE=" + FIN_STAGE + ", NBPLACE_STAGE=" + NBPLACE_STAGE + ", NBINSCRIT_STAGE="
				+ NBINSCRIT_STAGE + "]";
	}



	
	
	
	


}
