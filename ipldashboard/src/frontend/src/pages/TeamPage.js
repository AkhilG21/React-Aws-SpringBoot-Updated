import { React, useEffect , useState} from 'react';
import { useParams } from 'react-router-dom';
import { MatchDetailsCard } from '../component/MatchDetailsDard';
import { MatchSmallCard } from '../component/MatchSmallCard';

export const TeamPage = () => {

  const[team , setTeam] = useState({matches: []});
  const {teamName} = useParams(); 

  useEffect(
    () =>{
      const fetchMatches = async() => {
        console.log("Team Name before sendign request "+teamName);
        const response = await fetch(`http://localhost:8080/team/${teamName}`);
        const data = await response.json();
        setTeam(data);
      };
      fetchMatches();

    } ,[teamName] //Call this if teamName changes....([] is if you want to load only 1 time)


  );

  if (!team || !team.teamName){
    return <h1> Team Not Found </h1>
  }
  
  return (
    <div className="TeamPage">
      <h1>{team.teamName}</h1>
      
      <MatchDetailsCard teamName ={team.teamName} match = {team.matches[0]}/>
      {team?.matches?.slice(1).map(match => <MatchSmallCard teamName ={team.teamName}  match = {match} />)} 
    </div>
  );
}

