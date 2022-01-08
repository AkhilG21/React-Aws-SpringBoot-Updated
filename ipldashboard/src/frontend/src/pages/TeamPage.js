import { React, useEffect , useState} from 'react';
import { useParams } from 'react-router-dom';
import { MatchDetailsCard } from '../component/MatchDetailsDard';
import { MatchSmallCard } from '../component/MatchSmallCard';
import { PieChart } from 'react-minimal-pie-chart';
import { Link } from 'react-router-dom';

import './TeamPage.scss';
export const TeamPage = () => {

  const[team , setTeam] = useState({matches: []});
  const {teamName} = useParams(); 

  useEffect(
    () =>{
      const fetchTeam = async() => {
        console.log("Team Name before sending request "+teamName);
        const response = await fetch(`http://localhost:8080/team/${teamName}`);
        const data = await response.json();
        setTeam(data);
      };
      fetchTeam();

    } ,[teamName] //Call this if teamName changes....([] is if you want to load only 1 time)


  );

  if (!team || !team.teamName){
    return <h1> Team Not Found </h1>
  }
  
  return (
    <div className="TeamPage">

      <div className = "team-name-section">
        <div className="team-name"><h1>{team.teamName}</h1></div>
      </div>

      <div className = "win-loss-section">
        Wins / Losses
        <PieChart
          data={[
            { title: 'Wins', value: team.totalWins, color: '#E38627' },
            { title: 'Losses', value: team.totalMatches - team.totalWins , color: '#C13C37' },
          ]}
        />
      </div>
      
      <div className="match-detail-section">
        <h3>Latest Matches</h3>
        <MatchDetailsCard teamName ={team.teamName} match = {team.matches[0]}/>
      </div>
       {team?.matches?.slice(1).map(match => <MatchSmallCard teamName ={team.teamName}  match = {match} />)} 
      
      <div className="more-link">
      <Link to = {`/teams/${teamName}/matches/${process.env.REACT_APP_DATA_END_YEAR}`}>More</Link>
      </div>
    </div>
  );
}

