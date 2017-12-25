//This Component handles the App template used on every page.

import React, {Component} from 'react';
import PropTypes from 'prop-types';
import Header from './common/header';
import {BrowserRouter} from 'react-router-dom';

class pp extends Component{
  render(){

    return (
      <div className="container-fluid">
        <Header />
        {this.props.children}
      </div>
    );
  }
}

pp.propTypes = {
  children: PropTypes.object.isRequired
};
const App = (<BrowserRouter>
  <pp/>
</BrowserRouter>);


export default App;
