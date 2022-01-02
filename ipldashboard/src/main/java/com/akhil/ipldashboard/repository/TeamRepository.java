package com.akhil.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import com.akhil.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team , Long> {
	
	Team findByTeamName(String teamName);

}
