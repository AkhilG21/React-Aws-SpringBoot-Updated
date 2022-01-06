import { React, useEffect , useState} from 'react';
import { useParams } from 'react-router-dom';
import { MatchDetailsCard } from '../component/MatchDetailsDard';

export const MatchPage = () => {

const [matches ,setMatches] = useState([]);
const {teamName ,year} =  useParams(); 
useEffect(
  () => {

    const fetchMatches = async() => {
      const response = await fetch(`http://localhost:8080/team/${teamName}/matches?year=${year}`);
      const data = await response.json();
      console.log("Response from Matches data"+data);
      setMatches(data);

    };

    fetchMatches();

  } ,[] //Call this if teamName changes....([] is if you want to load only 1 time)
  );

  console.log("Inside MatchPage Log");

  return (
    <div className="MatchPage">
      <h1>Match Page</h1>

      {
        matches.map(match => <MatchDetailsCard teamName={teamName} match={match} />)
      }

    </div>
  );
}

