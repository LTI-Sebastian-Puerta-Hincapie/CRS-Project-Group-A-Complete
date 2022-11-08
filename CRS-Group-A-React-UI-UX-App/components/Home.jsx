import React from "react";
import NormalEmployee from "./NormalEmployee.jsx";
import PremiumEmployee from "./PremiumEmployee.jsx";
import {Link } from 'react-router';

class Home extends React.Component{

 render(){

    let link = {
        color: "black",
        fontFamily: "Robot"
    }

    let button = {
        margin: 10,
        padding: "1em",
        backgroundColor: "blue"
    }
    let container = {
        padding: "2em",
        backgroundColor: "LightGrey",
        margin: "5em",
        border: "solid",
        textAlign: "center"
    }
    
      return (
          <div style={container}>
             <h1> Welcome ! </h1>
             <button style={button}><Link to="normalemployee" style={link}>NormalEmployee</Link></button>
             <button style={button}><Link to="premiumemployee" style={link}>PremiumEmployee</Link></button>
          </div>
          
      );
 }

}

export default Home;

