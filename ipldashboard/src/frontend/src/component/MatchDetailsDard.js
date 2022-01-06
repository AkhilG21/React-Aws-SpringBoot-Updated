import { React } from 'react';
import { Link } from 'react-router-dom';

export const MatchDetailsCard = ({teamName ,match}) => {

  if(!match) return null;

  const otherTeam = match.team1 === teamName ?  match.team2 : match.team1 ;
  const otherTeamRoute = `/teams/${otherTeam}`;
  return (

    <div className="MatchDetailsCard">
      <h2>Latest Matches</h2>
      <h4>Match Details</h4>
      <h1>vs <Link to = {otherTeamRoute} > {otherTeam}</Link> </h1>
      <h2>{match.date}</h2>
      <h3>at {match.venue}</h3>
      <h3>{match.match_winner} won by {match.result_margin} {match.result}</h3>
    </div>
  );
}