import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import Login from './components/login/index'
function App() {
  return (
    <Router>
    <div>
      <Routes>
        <Route path="/" element={ <Login></Login> } />
      </Routes>
    </div>
  </Router>
  );
}

export default App;
