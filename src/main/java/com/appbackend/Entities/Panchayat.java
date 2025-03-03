package com.appbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Panchayat {

	 private int state_ID;
		
	 @ManyToOne
	 private District district;
	 
	 @ManyToOne
	 private Block block;
	 
	 @Id
	 private int panchayat_ID;
	 
	 private String panchayat_Name_Eng;
	 
	 private String panchayat_Name_Hindi;

	public int getState_ID() {
		return state_ID;
	}

	public void setState_ID(int state_ID) {
		this.state_ID = state_ID;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public int getPanchayat_ID() {
		return panchayat_ID;
	}

	public void setPanchayat_ID(int panchayat_ID) {
		this.panchayat_ID = panchayat_ID;
	}

	public String getPanchayat_Name_Eng() {
		return panchayat_Name_Eng;
	}

	public void setPanchayat_Name_Eng(String panchayat_Name_Eng) {
		this.panchayat_Name_Eng = panchayat_Name_Eng;
	}

	public String getPanchayat_Name_Hindi() {
		return panchayat_Name_Hindi;
	}

	public void setPanchayat_Name_Hindi(String panchayat_Name_Hindi) {
		this.panchayat_Name_Hindi = panchayat_Name_Hindi;
	}

	@Override
	public String toString() {
		return "Panchayat [state_ID=" + state_ID + ", district=" + district + ", block=" + block + ", panchayat_ID="
				+ panchayat_ID + ", panchayat_Name_Eng=" + panchayat_Name_Eng + ", panchayat_Name_Hindi="
				+ panchayat_Name_Hindi + "]";
	}

	/**
	 * @param state_ID
	 * @param district
	 * @param block
	 * @param panchayat_ID
	 * @param panchayat_Name_Eng
	 * @param panchayat_Name_Hindi
	 */
	public Panchayat(int state_ID, District district, Block block, int panchayat_ID, String panchayat_Name_Eng,
			String panchayat_Name_Hindi) {
		super();
		this.state_ID = state_ID;
		this.district = district;
		this.block = block;
		this.panchayat_ID = panchayat_ID;
		this.panchayat_Name_Eng = panchayat_Name_Eng;
		this.panchayat_Name_Hindi = panchayat_Name_Hindi;
	}

	/**
	 * 
	 */
	public Panchayat() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	 
	 
	 
	 
	 
	 
}
