package com.appbackend.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Block {
	
	private int state_ID;
	
	@ManyToOne
	private District district;
	
	@Id
	private int block_ID;
	
	private String block_Name_Eng;
	
	private String block_Name_Hindi;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="block",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<Panchayat>panchayat;

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

	public int getBlock_ID() {
		return block_ID;
	}

	public void setBlock_ID(int block_ID) {
		this.block_ID = block_ID;
	}

	public String getBlock_Name_Eng() {
		return block_Name_Eng;
	}

	public void setBlock_Name_Eng(String block_Name_Eng) {
		this.block_Name_Eng = block_Name_Eng;
	}

	public String getBlock_Name_Hindi() {
		return block_Name_Hindi;
	}

	public void setBlock_Name_Hindi(String block_Name_Hindi) {
		this.block_Name_Hindi = block_Name_Hindi;
	}

	public List<Panchayat> getPanchayat() {
		return panchayat;
	}

	public void setPanchayat(List<Panchayat> panchayat) {
		this.panchayat = panchayat;
	}

	@Override
	public String toString() {
		return "Block [state_ID=" + state_ID + ", district=" + district + ", block_ID=" + block_ID + ", block_Name_Eng="
				+ block_Name_Eng + ", block_Name_Hindi=" + block_Name_Hindi + ", panchayat=" + panchayat + "]";
	}

	/**
	 * @param state_ID
	 * @param district
	 * @param block_ID
	 * @param block_Name_Eng
	 * @param block_Name_Hindi
	 * @param panchayat
	 */
	public Block(int state_ID, District district, int block_ID, String block_Name_Eng, String block_Name_Hindi,
			List<Panchayat> panchayat) {
		super();
		this.state_ID = state_ID;
		this.district = district;
		this.block_ID = block_ID;
		this.block_Name_Eng = block_Name_Eng;
		this.block_Name_Hindi = block_Name_Hindi;
		this.panchayat = panchayat;
	}

	/**
	 * 
	 */
	public Block() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

}
