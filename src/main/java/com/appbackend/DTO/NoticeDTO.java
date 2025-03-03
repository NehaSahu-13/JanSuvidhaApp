package com.appbackend.DTO;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class NoticeDTO {
	
	private long id;
	
	private String notice_Title;
	
	private String notice_Description;
	
	private Date notice_Date;
	
	private Date notice_Active_Date;
	
	private Date notice_Expiry_Date;
	
	private int notice_Visibility;
	

	public String getNotice_Title() {
		return notice_Title;
	}

	public void setNotice_Title(String notice_Title) {
		this.notice_Title = notice_Title;
	}

	public String getNotice_Description() {
		return notice_Description;
	}

	public void setNotice_Description(String notice_Description) {
		this.notice_Description = notice_Description;
	}

	public Date getNotice_Date() {
		return notice_Date;
	}

	public void setNotice_Date(Date notice_Date) {
		this.notice_Date = notice_Date;
	}

	public Date getNotice_Active_Date() {
		return notice_Active_Date;
	}

	public void setNotice_Active_Date(Date notice_Active_Date) {
		this.notice_Active_Date = notice_Active_Date;
	}

	public Date getNotice_Expiry_Date() {
		return notice_Expiry_Date;
	}

	public void setNotice_Expiry_Date(Date notice_Expiry_Date) {
		this.notice_Expiry_Date = notice_Expiry_Date;
	}

	public int getNotice_Visibility() {
		return notice_Visibility;
	}
	
	
	
    
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNotice_Visibility(int notice_Visibility) {
		this.notice_Visibility = notice_Visibility;
	}

	/**
	 * @param id
	 * @param notice_Title
	 * @param notice_Description
	 * @param notice_Date
	 * @param notice_Active_Date
	 * @param notice_Expiry_Date
	 * @param notice_Visibility
	 */
	public NoticeDTO(long id, String notice_Title, String notice_Description, Date notice_Date, Date notice_Active_Date,
			Date notice_Expiry_Date, int notice_Visibility) {
		super();
		this.id = id;
		this.notice_Title = notice_Title;
		this.notice_Description = notice_Description;
		this.notice_Date = notice_Date;
		this.notice_Active_Date = notice_Active_Date;
		this.notice_Expiry_Date = notice_Expiry_Date;
		this.notice_Visibility = notice_Visibility;
	}

	@Override
	public String toString() {
		return "NoticeDTO [id=" + id + ", notice_Title=" + notice_Title + ", notice_Description=" + notice_Description
				+ ", notice_Date=" + notice_Date + ", notice_Active_Date=" + notice_Active_Date
				+ ", notice_Expiry_Date=" + notice_Expiry_Date + ", notice_Visibility=" + notice_Visibility + "]";
	}

	public NoticeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
}
