package com.appbackend.Service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.appbackend.DTO.NoticeDTO;
import com.appbackend.Entities.Department;
import com.appbackend.Entities.Notice;
import com.appbackend.Entities.OfficerRegistration;
import com.appbackend.Repository.DepartmentRepository;
import com.appbackend.Repository.NoticeRepository;
import com.appbackend.Repository.OfficerRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	
	@Autowired
	private OfficerRepository officerRepository;
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private FileServiceImpl fileservice;

	@Override
	public Notice addNotice(long officer_ID,NoticeDTO noticeDto,MultipartFile file) {
		
		Notice notice=new Notice();

		notice.setNotice_Active_Date(noticeDto.getNotice_Active_Date());
		notice.setNotice_Date(new Date());
		notice.setNotice_Description(noticeDto.getNotice_Description());
		notice.setNotice_Expiry_Date(noticeDto.getNotice_Expiry_Date());
		notice.setNotice_Title(noticeDto.getNotice_Title());
		notice.setNotice_Visibility(noticeDto.getNotice_Visibility());
		OfficerRegistration officer=officerRepository.findById(officer_ID).get();
		notice.setOffice(officer.getOffice());
		notice.setOfficer(officer);
		notice.setDepartment(officer.getDepartment());
		officer.getNotices().add(notice);
		officer.getOffice().getNotices().add(notice);
		Department department=officer.getDepartment();
		department.getNotices().add(notice);
		
		
		try {
			if(file!=null) {
			String fileName=fileservice.uploadFile(file);
			notice.setUploaded_FileName(fileName);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		departmentRepository.save(department);
		return notice;	
	}

	@Override
	public Notice getNoticeByID(long id) {
		Notice notice=noticeRepository.findById(id).get();
		return notice;
	}

	@Override
	public List<Notice> getAllNotices() {
		List<Notice> notices=noticeRepository.findAll();
		return notices;
	}

	@Override
	public boolean deleteNotice(long id) {
		Notice notice=noticeRepository.findById(id).get();
		noticeRepository.delete(notice);
		return true;
	}

	@Override
	public Notice updateNotice(NoticeDTO noticeDto,MultipartFile file) {
		
		Notice notice=noticeRepository.findById(noticeDto.getId()).get();
		
		notice.setNotice_Active_Date(noticeDto.getNotice_Active_Date());
		notice.setNotice_Date(new Date());
		notice.setNotice_Description(noticeDto.getNotice_Description());
		notice.setNotice_Expiry_Date(noticeDto.getNotice_Expiry_Date());
		notice.setNotice_Title(noticeDto.getNotice_Title());
		notice.setNotice_Visibility(noticeDto.getNotice_Visibility());
		
		
		try {
			   if(file!=null) {
				String oldFile=notice.getUploaded_FileName();
				File deleteFile=new ClassPathResource("static/file").getFile();
				File file1=new File(deleteFile,oldFile);
				file1.delete();				
				
				fileservice.uploadFile(file);
				
				notice.setUploaded_FileName(file.getOriginalFilename());
			   }
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		noticeRepository.save(notice);
		return notice;
	}

	@Override
	public List<Notice> getAllNoticesUploadedByOfficer(long officer_ID) {
		
		OfficerRegistration officer=officerRepository.findById(officer_ID).get();
		
		List<Notice>notices = officer.getNotices();
		
		return notices;
		
	}

}
