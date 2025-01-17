package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MarksEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.MarksFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.MarksRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    
    public List<MarksEntity> getAllMarks() {
        return marksRepository.findAll();
    }

    public Optional<MarksEntity> getMarksById(Long id) {
        return marksRepository.findById(id);
    }

    public MarksEntity saveMarks(MarksEntity marks) {
    	int total = marks.getSem1()+marks.getSem2()+marks.getSem3();
	    Optional<MarksEntity> existingUserById = marksRepository.findById(marks.getId());//userRepository.findById(user.getId());

    	if(existingUserById.isEmpty()) {
    	UserEntity user = userRepository.findById(marks.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + marks.getId()));
    	
        System.out.println("User: "+user);
        marks.setUserName(user.getUserName());
        marks.setTotal(total);
        marks.setUser(user);
        return marksRepository.save(marks);
    	}
    	throw new MarksFoundException("Record already exist");
        
    }
    
    public MarksEntity updateMarks(MarksEntity marks) {
    	int total = marks.getSem1()+marks.getSem2()+marks.getSem3();
	    //Optional<MarksEntity> existingUserById = marksRepository.findById(marks.getId());//userRepository.findById(user.getId());

    	//if(existingUserById.isEmpty()) {
    	UserEntity user = userRepository.findById(marks.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + marks.getId()));
    	
        System.out.println("User: "+user);
        marks.setUserName(user.getUserName());
        marks.setTotal(total);
        marks.setUser(user);
        return marksRepository.save(marks);
    	//}
    	//throw new MarksFoundException("Record already exist");
        
    }

    public void deleteMarks(Long id) {
        marksRepository.deleteById(id);
    }
    
    private int getTotalMarks(MarksEntity marks) {
    	return marks.getSem1()+marks.getSem2()+marks.getSem3();
    }
    
	public List<MarksEntity> fetchMarksByUserId(Long id){
		return marksRepository.findByUser_Id(id);
	}
}