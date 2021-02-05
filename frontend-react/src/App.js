import React from 'react';
import './App.css';
import Navbar from './Components/Navbar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Home from './pages/Home';
import AllRecords from './pages/AllRecords';
import PostRecords from './pages/PostRecords';
import UpdateRecord from './pages/UpdateRecord';
import SearchView from './pages/SearchView';

function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Switch>
          <Route path='/' exact component={Home} />
          <Route path='/all_records' component={AllRecords} />        
          <Route path='/create' component={PostRecords} />
          <Route path='/update_record/:id' component={UpdateRecord} />
          <Route path='/search_view/:id' component={SearchView} />
        </Switch>
      </Router>
    </>
  );
}

export default App;