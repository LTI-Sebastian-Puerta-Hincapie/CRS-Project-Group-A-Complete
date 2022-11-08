import React from "react";
import NormalEmployee from "./NormalEmployee.jsx";
import PremiumEmployee from "./PremiumEmployee.jsx";
import {Link } from 'react-router';

class Home extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            showNormal: false,
            showPremium: false
        }
    }

 componentDidMount() {
    this.state = {
      showNormal: false,
      showPremium: false
    };
  }

  showNormal() {
    this.setState({
      showNormal: !this.state.showNormal
    });
  }

  showPremium() {
    this.setState({
      showPremium: !this.state.showPremium
    });
  }

 render(){

    let link = {
        color: "black",
        fontFamily: "Robot",
        textDecoration: "none"
    }

    let button = {
        margin: 10,
        padding: "1em",
        backgroundColor: "LightGreen",
        borderRadius: "8px",
        border: "none",
        color: "black",
        fontFamily: "Robot"
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
             <button style={button}><Link to="normalemployee" style={link}>Navigate to Normal </Link></button>
             <button style={button}><Link to="premiumemployee" style={link}>Navigate to Premium </Link></button><br/><br/>
             <button style={button} onClick={()=>this.showNormal()}>Show Normal</button>
             <button style={button} onClick={()=>this.showPremium()}>Show Premium</button>
             {this.state.showNormal && <NormalEmployee/>}
             {this.state.showPremium && <PremiumEmployee/>}
          </div>
      );
 }

}

export default Home;

