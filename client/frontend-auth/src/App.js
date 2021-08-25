import './App.css';
import { BrowserRouter as Router, Route } from "react-router-dom";
import WelcomeScreen from "./routes/WelcomeScreen";

function App() {
  return (
	<Router>
		<div className="App">
		</div>
		<Route path="/" exact component={WelcomeScreen} />
	</Router>
  );
}

export default App;
