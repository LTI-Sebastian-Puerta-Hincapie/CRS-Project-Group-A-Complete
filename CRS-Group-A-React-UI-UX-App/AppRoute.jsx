import React from "react";

import {Link } from 'react-router';


class AppRouter extends React.Component{

 render(){

    let routes = {
        margin: 10
    }
    
      return (

          <div>
              <h1> LTI REACT EMPLOYEES APP </h1>
             <Link to="home" style={routes}>Home</Link> 
             <Link to="contact" style={routes}>Contact Us</Link>
             <Link to="about" style={routes}>About us</Link>

      {this.props.children}


          </div>

      );
 }

}

export default AppRouter;