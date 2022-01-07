import { React } from 'react';
import { Link } from 'react-router-dom';
import "./MatchDetailsCard.scss";

export const MatchDetailsCard = ({teamName ,match}) => {

  if(!match) return null;

  const otherTeam = match.team1 === teamName ?  match.team2 : match.team1 ;
  const otherTeamRoute = `/teams/${otherTeam}`;
  const isMatchWon = teamName === match.match_winner;
  return (

    <div className={isMatchWon ? 'won-card' :'lost-card' }>
      <div>
        <span className="vs">vs</span>
        <h1><Link to = {otherTeamRoute} > {otherTeam}</Link> </h1>
        <h2 className = "match-date">{match.date}</h2>
        <h3 className = "match-venue">at {match.venue}</h3>
        <h3 className = "match-result">{match.match_winner} won by {match.result_margin} {match.result}</h3>
      </div>

      <div className = "additional-detail">
        <h3> First Innings</h3>
        <p>{match.team1}</p>
        <h3> Second Innings</h3>
        <p>{match.team2}</p>
        <h3> Man Of Match</h3>
        <p>{match.player_of_match}</p>
        <h3> Umpires</h3>
        <p>{match.umpire1} , {match.umpire2}</p>
      </div>

    </div>
  );
}