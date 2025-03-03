package com.appbackend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class NNN {

	
    private int state_ID;
	
	private int district_ID;
	
	private int block_ID;
	
	@Id
	private int NNN_ID;
	
	private String NNN_Name_Eng;
	
	private String NNN_Name_Hindi;
	
	private String NNN_Type;

	public int getState_ID() {
		return state_ID;
	}

	public void setState_ID(int state_ID) {
		this.state_ID = state_ID;
	}

	public int getDistrict_ID() {
		return district_ID;
	}

	public void setDistrict_ID(int district_ID) {
		this.district_ID = district_ID;
	}

	public int getBlock_ID() {
		return block_ID;
	}

	public void setBlock_ID(int block_ID) {
		this.block_ID = block_ID;
	}

	public int getNNN_ID() {
		return NNN_ID;
	}

	public void setNNN_ID(int nNN_ID) {
		NNN_ID = nNN_ID;
	}

	public String getNNN_Name_Eng() {
		return NNN_Name_Eng;
	}

	public void setNNN_Name_Eng(String nNN_Name_Eng) {
		NNN_Name_Eng = nNN_Name_Eng;
	}

	public String getNNN_Name_Hindi() {
		return NNN_Name_Hindi;
	}

	public void setNNN_Name_Hindi(String nNN_Name_Hindi) {
		NNN_Name_Hindi = nNN_Name_Hindi;
	}

	public String getNNN_Type() {
		return NNN_Type;
	}

	public void setNNN_Type(String nNN_Type) {
		NNN_Type = nNN_Type;
	}

	@Override
	public String toString() {
		return "NNN [state_ID=" + state_ID + ", district_ID=" + district_ID + ", block_ID=" + block_ID + ", NNN_ID="
				+ NNN_ID + ", NNN_Name_Eng=" + NNN_Name_Eng + ", NNN_Name_Hindi=" + NNN_Name_Hindi + ", NNN_Type="
				+ NNN_Type + "]";
	}

	/**
	 * @param state_ID
	 * @param district_ID
	 * @param block_ID
	 * @param nNN_ID
	 * @param nNN_Name_Eng
	 * @param nNN_Name_Hindi
	 * @param nNN_Type
	 */
	public NNN(int state_ID, int district_ID, int block_ID, int nNN_ID, String nNN_Name_Eng, String nNN_Name_Hindi,
			String nNN_Type) {
		super();
		this.state_ID = state_ID;
		this.district_ID = district_ID;
		this.block_ID = block_ID;
		NNN_ID = nNN_ID;
		NNN_Name_Eng = nNN_Name_Eng;
		NNN_Name_Hindi = nNN_Name_Hindi;
		NNN_Type = nNN_Type;
	}

	/**
	 * 
	 */
	public NNN() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
}
