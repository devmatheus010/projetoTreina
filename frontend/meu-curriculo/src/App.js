import React from 'react';
import './App.css';
import MyNavBar from './components/MyNavbar';
import Form from './components/Curriculo';
import Footer from './components/Footer';

function App() {
  return (
    <div className="App">
      <MyNavBar />
      <Form />
      <Footer />
    </div>
  );
}

export default App;
