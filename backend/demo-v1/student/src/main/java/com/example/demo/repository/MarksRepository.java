package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MarksEntity;
import com.example.demo.entity.UserEntity;

@Repository
public interface MarksRepository extends JpaRepository<MarksEntity, Long> {
    //List<MarksEntity> findByUserName(UserEntity user);
	List<MarksEntity> findByUser_Id(Long id);
    
}