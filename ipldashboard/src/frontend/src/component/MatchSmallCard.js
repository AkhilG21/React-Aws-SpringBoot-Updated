import { React } from 'react';
import { Link } from 'react-router-dom';
import "./MatchSmallCard.scss";

export const MatchSmallCard = ({ teamName, match }) => {
  if (!match) return null;

  const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
  const otherTeamRoute = `/teams/${otherTeam}`;
  const isMatchWon = teamName === match.match_winner;
  return (
    <div className={isMatchWon ? 'won-card' :'lost-card' }>

      <span className="vs">vs</span>
      <h1><Link to = {otherTeamRoute} > {otherTeam}</Link> </h1>
      <p className="match-result">{match.match_winner} won by {match.result_margin} {match.result}</p>
    </div>
  );
}