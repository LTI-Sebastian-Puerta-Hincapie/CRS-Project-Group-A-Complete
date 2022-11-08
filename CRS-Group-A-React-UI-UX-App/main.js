import React from "react";
import ReactDOM from "react-dom";
import { Router, Route, browserHistory, IndexRoute } from "react-router";
import Home from './components/Home.jsx';
import About from './components/About.jsx';
import Contact from './components/Contact.jsx'
import AppRouter from "./AppRoute.jsx";
import NormalEmployee from "./components/NormalEmployee.jsx";
import PremiumEmployee from "./components/PremiumEmployee.jsx";

ReactDOM.render((
    <Router history = {browserHistory}>
    <Route path = "/" component = {AppRouter}>
           <IndexRoute component = {Home} />
           <Route path = "home" component = {Home} />      
           <Route path = "about" component = {About} />
           <Route path = "contact" component = {Contact} />
           <Route path = "normalemployee" component = {NormalEmployee} />
           <Route path = "premiumemployee" component = {PremiumEmployee} />
    </Route>
   </Router>
   ), document.getElementById('router'));
