package com.appbackend.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.appbackend.DTO.NoticeDTO;
import com.appbackend.Entities.Notice;

public interface NoticeService {

	public Notice addNotice(long officer_ID,NoticeDTO noticeDto,MultipartFile file);
	
	public Notice getNoticeByID(long id);
	
	public List<Notice> getAllNotices();
	
	public List<Notice> getAllNoticesUploadedByOfficer(long Officer_ID);
	
	public boolean deleteNotice(long id);
	
	public Notice updateNotice(NoticeDTO noticeDto,MultipartFile file);

	public List<Notice> getAllNoticeForCitizen();
	
	public List<Notice> getAllNoticeForOfficer();
	
	
}
