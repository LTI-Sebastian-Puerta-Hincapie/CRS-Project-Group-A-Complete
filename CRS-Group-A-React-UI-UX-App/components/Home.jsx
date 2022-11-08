import React from "react";
import NormalEmployee from "./NormalEmployee.jsx";
import PremiumEmployee from "./PremiumEmployee.jsx";

class Home extends React.Component{

 render(){
    
      return (

          <div>
              <NormalEmployee />
              <PremiumEmployee />
          </div>
          
      );
 }

}

export default Home;

