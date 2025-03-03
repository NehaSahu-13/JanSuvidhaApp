package com.appbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appbackend.Entities.Notice;

public interface NoticeRepository extends JpaRepository<Notice,Long>{

}
