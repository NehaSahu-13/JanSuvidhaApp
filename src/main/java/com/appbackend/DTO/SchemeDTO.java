package com.appbackend.DTO;


public class SchemeDTO {
	
	private long id;

    private int scheme_Sponsor;
	
	private String scheme_Title;
	
	private String scheme_Description;
	
	private String scheme_Eligiblity;
	
	private String to_Contact;
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getScheme_Sponsor() {
		return scheme_Sponsor;
	}

	public void setScheme_Sponsor(int scheme_Sponsor) {
		this.scheme_Sponsor = scheme_Sponsor;
	}

	public String getScheme_Title() {
		return scheme_Title;
	}

	public void setScheme_Title(String scheme_Title) {
		this.scheme_Title = scheme_Title;
	}

	public String getScheme_Description() {
		return scheme_Description;
	}

	public void setScheme_Description(String scheme_Description) {
		this.scheme_Description = scheme_Description;
	}

	public String getScheme_Eligiblity() {
		return scheme_Eligiblity;
	}

	public void setScheme_Eligiblity(String scheme_Eligiblity) {
		this.scheme_Eligiblity = scheme_Eligiblity;
	}

	public String getTo_Contact() {
		return to_Contact;
	}

	public void setTo_Contact(String to_Contact) {
		this.to_Contact = to_Contact;
	}

	
	
	
    

	@Override
	public String toString() {
		return "SchemeDTO [id=" + id + ", scheme_Sponsor=" + scheme_Sponsor + ", scheme_Title=" + scheme_Title
				+ ", scheme_Description=" + scheme_Description + ", scheme_Eligiblity=" + scheme_Eligiblity
				+ ", to_Contact=" + to_Contact + "]";
	}

	/**
	 * @param id
	 * @param scheme_Sponsor
	 * @param scheme_Title
	 * @param scheme_Description
	 * @param scheme_Eligiblity
	 * @param to_Contact
	 */
	public SchemeDTO(long id, int scheme_Sponsor, String scheme_Title, String scheme_Description,
			String scheme_Eligiblity, String to_Contact) {
		super();
		this.id = id;
		this.scheme_Sponsor = scheme_Sponsor;
		this.scheme_Title = scheme_Title;
		this.scheme_Description = scheme_Description;
		this.scheme_Eligiblity = scheme_Eligiblity;
		this.to_Contact = to_Contact;
	}

	public SchemeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
