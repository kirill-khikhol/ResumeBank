import React, { Component } from 'react';
import {Route,Switch,withRouter} from 'react-router-dom'
import BankResume from './components/home/BankResume'
import PageEmployee from "./components/Employee/PageEmployee";
import PageCompany from "./components/Company/PageCompany";
import LogIn from "./components/Login/LogIn";
import SignUp from "./components/Login/SignUp";
import CreateResume from "./components/Employee/CreateResume";
import SearchEmployee from "./components/Company/SearchEmployee";
import About from './components/about/AboutPage'
import './App.css';
import Resume from './components/Resume/Resume';

class App extends Component {
  render() {
    return (
      <div className="App">
            <Switch>
             <Route path ="/" exact component={BankResume}/>
                <Route path="/PageEmployee" exact component={PageEmployee} />
                <Route path="/CreateResume" exact component={CreateResume} />
                <Route path="/PageCompany" exact component={PageCompany}/>
                <Route path="/SearchEmployee" exact component={SearchEmployee} />
                <Route path="/LogIn" exact component={LogIn} />
                <Route path="/SignUp" exact component={SignUp} />
                <Route path="/About" exact component={About} />
                <Route path="/Resume" exact component={Resume} />
            </Switch>
      </div>
    );
  }
}


export default withRouter(App);
