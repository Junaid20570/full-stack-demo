package com.testfullstack.Fullstack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {

	String name;
	@Id
	String email;
	String team;
	String status;
	String role;
	String nationality;
	int noOfMatchesPlayed;
	int noOfWickets;
	int noOfRuns;
	int noOfCatches;
	@Lob
	String image;
}
