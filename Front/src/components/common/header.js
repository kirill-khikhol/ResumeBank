import React from 'react';
import {NavLink,withRouter}from 'react-router-dom'
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import './header.css'

const Header = () => {
  return(
     <div className="header">
<p>. </p>
    <nav className="nav navbar-collapse navbar-default NavigationBar" >
      <NavLink to="/" activeClassName={"active"}>Bank Resume</NavLink>
      {" | "}
      <NavLink to="/PageEmployee" activeClassName={"active"}>Page Employee</NavLink>
      {" | "}
      <NavLink to="/PageCompany" activeClassName={"active"}>Page Company</NavLink>
      {" | "}
      <NavLink to="/SearchEmployee" activeClassName={"active"}>Search Employee</NavLink>
      {" | "}
     <NavLink to="/About" activeClassName={"active"}>About</NavLink>
    </nav>
      </div>
  );
};
export default withRouter(Header);
