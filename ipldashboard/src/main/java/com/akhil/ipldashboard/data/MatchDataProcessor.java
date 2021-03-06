package com.akhil.ipldashboard.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.akhil.ipldashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

		  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

		  @Override
		  public Match process(final MatchInput matchInput) throws Exception {
		  
			  Match match = new Match();
			  match.setId(Long.parseLong(matchInput.getId()));
			  match.setCity(matchInput.getCity());
			  match.setDate(LocalDate.parse(matchInput.getDate()));
			  match.setPlayer_of_match(matchInput.getPlayer_of_match());
			  match.setVenue(matchInput.getVenue());

			  //Set Team-1 and Team-2 depending on innings order 
			  String firstInningsTeam, secondInningsTeam;
			  
			  if("bat".equals(matchInput.getToss_decision())) {
				  firstInningsTeam  = matchInput.getToss_winner();
				  secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ?
						  matchInput.getTeam2() : matchInput.getTeam1();
			  }else {
				  secondInningsTeam = matchInput.getToss_winner();
				  firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ?
						  matchInput.getTeam2() : matchInput.getTeam1();
			  }
			  
			  match.setTeam1(firstInningsTeam);
		      match.setTeam2(secondInningsTeam);
			  match.setToss_winner(matchInput.getToss_winner());
			  match.setToss_decision(matchInput.getToss_decision());
			  match.setMatch_winner(matchInput.getWinner());
			  match.setResult(matchInput.getResult());
			  match.setResult_margin(matchInput.getResult_margin());
			  match.setUmpire1(matchInput.getUmpire1());
			  match.setUmpire2(matchInput.getUmpire2());
			  
			  log.info("Match :: "+match);
		    return match;
		  }

	
}
