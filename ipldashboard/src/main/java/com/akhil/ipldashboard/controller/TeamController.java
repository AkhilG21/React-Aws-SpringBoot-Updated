package com.akhil.ipldashboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.ipldashboard.model.Team;
import com.akhil.ipldashboard.repository.MatchRepository;
import com.akhil.ipldashboard.repository.TeamRepository;

@RestController
@CrossOrigin //Allows pages from other Domains to make call to this domain.
public class TeamController {
	
	private static final Logger log = LoggerFactory.getLogger(TeamController.class);

	private TeamRepository teamRepository;
	
	private MatchRepository matchRepository;
	
	

	public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
		super();
		this.teamRepository = teamRepository;
		this.matchRepository = matchRepository;
	}

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		//log.info("Team Name : "+teamName);
		Team team =  this.teamRepository.findByTeamName(teamName);
		//log.info("Team Data : "+team);
		
		team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));
		log.info("Team Data for Latest 4 Matches: "+team);
		return team;
	}
	
	
}
