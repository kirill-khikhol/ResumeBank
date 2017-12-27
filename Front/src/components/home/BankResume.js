import React from 'react';
import Header from '../common/header';
import  './BankResume.css';
import {NavLink} from 'react-router-dom';

class Bankresume extends  React.Component{
  render(){
    return (
      <div >
        <h1>Bank Resume - Home Page</h1>
          <div className="LoginAbout">
              <NavLink to="/LogIn" activeClassName={"active"}>Log In</NavLink>
              {" | "}
              <NavLink to="/SignUp" activeClassName={"active"}>Sign Up</NavLink>


          </div>

        <Header/>
      </div>
    );
  }
}

export default Bankresume;
