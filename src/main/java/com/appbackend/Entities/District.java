package com.appbackend.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class District {

	@Id
	private int district_ID;
	
	private int state_ID;
	
	private String District_Name_Eng;
	
	private String District_Name_Hindi;
	
	private String abbreviation;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="district",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<Block>blocks;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="district",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<Panchayat>panchayat;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="district",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<CitizenRegistration>citizens;

	public int getDistrict_ID() {
		return district_ID;
	}

	public void setDistrict_ID(int district_ID) {
		this.district_ID = district_ID;
	}

	public int getState_ID() {
		return state_ID;
	}

	public void setState_ID(int state_ID) {
		this.state_ID = state_ID;
	}

	public String getDistrict_Name_Eng() {
		return District_Name_Eng;
	}

	public void setDistrict_Name_Eng(String district_Name_Eng) {
		District_Name_Eng = district_Name_Eng;
	}

	public String getDistrict_Name_Hindi() {
		return District_Name_Hindi;
	}

	public void setDistrict_Name_Hindi(String district_Name_Hindi) {
		District_Name_Hindi = district_Name_Hindi;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public List<Panchayat> getPanchayat() {
		return panchayat;
	}

	public void setPanchayat(List<Panchayat> panchayat) {
		this.panchayat = panchayat;
	}

	public List<CitizenRegistration> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<CitizenRegistration> citizens) {
		this.citizens = citizens;
	}

	@Override
	public String toString() {
		return "District [district_ID=" + district_ID + ", state_ID=" + state_ID + ", District_Name_Eng="
				+ District_Name_Eng + ", District_Name_Hindi=" + District_Name_Hindi + ", abbreviation=" + abbreviation
				+ ", blocks=" + blocks + ", panchayat=" + panchayat + ", citizens=" + citizens + "]";
	}

	/**
	 * @param district_ID
	 * @param state_ID
	 * @param district_Name_Eng
	 * @param district_Name_Hindi
	 * @param abbreviation
	 * @param blocks
	 * @param panchayat
	 * @param citizens
	 */
	public District(int district_ID, int state_ID, String district_Name_Eng, String district_Name_Hindi,
			String abbreviation, List<Block> blocks, List<Panchayat> panchayat, List<CitizenRegistration> citizens) {
		super();
		this.district_ID = district_ID;
		this.state_ID = state_ID;
		District_Name_Eng = district_Name_Eng;
		District_Name_Hindi = district_Name_Hindi;
		this.abbreviation = abbreviation;
		this.blocks = blocks;
		this.panchayat = panchayat;
		this.citizens = citizens;
	}

	/**
	 * 
	 */
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	

	
	
}
