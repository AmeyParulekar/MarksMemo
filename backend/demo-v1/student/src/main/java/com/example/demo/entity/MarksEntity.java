package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "marks")
public class MarksEntity {

	@Id
	private Long id;
	
	@Column(name = "user_name", length = 20)
	private String userName;
	
	private int sem1;
	
	private int sem2;
	
	private int sem3;
	
	private int total;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	private UserEntity user;
			
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSem1() {
		return sem1;
	}

	public void setSem1(int sem1) {
		this.sem1 = sem1;
	}

	public int getSem2() {
		return sem2;
	}

	public void setSem2(int sem2) {
		this.sem2 = sem2;
	}

	public int getSem3() {
		return sem3;
	}

	public void setSem3(int sem3) {
		this.sem3 = sem3;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}

