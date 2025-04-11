package com.appbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appbackend.Entities.Notice;

public interface NoticeRepository extends JpaRepository<Notice,Long>{

    @Query("SELECT u FROM Notice u WHERE (u.notice_Visibility = :vis1 OR u.notice_Visibility = :vis2) "
		     + "AND u.notice_Active_Date <= CURRENT_DATE "
		     + "AND u.notice_Expiry_Date >= CURRENT_DATE")
		List<Notice> findByNotice_Visibility(@Param("vis1") int vis1, @Param("vis2") int vis2);

    
}
