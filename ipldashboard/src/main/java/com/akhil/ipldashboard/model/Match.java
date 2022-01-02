package com.akhil.ipldashboard.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Match {

	@Id
	private long id ;
	private String city;
	private LocalDate date;	
	private String player_of_match;
	private String venue;
	private String team1;
	private String team2;
	private String toss_winner;
	private String toss_decision;
	private String match_winner;
	private String result;
	private String result_margin;
	private String umpire1;
	private String umpire2;
	
	
	public Match() {
		super();
	}
	
	
	
	public Match(long id, String city, LocalDate date, String player_of_match, String venue, String team1, String team2,
			String toss_winner, String toss_decision, String match_winner, String result, String result_margin,
			String umpire1, String umpire2) {
		super();
		this.id = id;
		this.city = city;
		this.date = date;
		this.player_of_match = player_of_match;
		this.venue = venue;
		this.team1 = team1;
		this.team2 = team2;
		this.toss_winner = toss_winner;
		this.toss_decision = toss_decision;
		this.match_winner = match_winner;
		this.result = result;
		this.result_margin = result_margin;
		this.umpire1 = umpire1;
		this.umpire2 = umpire2;
	}



	/*public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getPlayer_of_match() {
		return player_of_match;
	}
	public void setPlayer_of_match(String player_of_match) {
		this.player_of_match = player_of_match;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getToss_winner() {
		return toss_winner;
	}
	public void setToss_winner(String toss_winner) {
		this.toss_winner = toss_winner;
	}
	public String getToss_decision() {
		return toss_decision;
	}
	public void setToss_decision(String toss_decision) {
		this.toss_decision = toss_decision;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResult_margin() {
		return result_margin;
	}
	public void setResult_margin(String result_margin) {
		this.result_margin = result_margin;
	}
	public String getUmpire1() {
		return umpire1;
	}
	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}
	public String getUmpire2() {
		return umpire2;
	}
	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
	}

	public String getMatch_winner() {
		return match_winner;
	}

	public void setMatch_winner(String match_winner) {
		this.match_winner = match_winner;
	}*/
	
	
	
}
