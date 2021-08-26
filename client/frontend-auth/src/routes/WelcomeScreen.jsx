//import SockJS from "sockjs-client";
import { useEffect, useState } from 'react';

const WelcomeScreen = (props) => {

	/*let sock = new SockJS("http://localhost:8080/gs-guide-websocket");
	sock.onopen = function() {
		console.log('opened');
	};*/

	const [registeredUsers, setRegisteredUsers] = useState(null);

	const url = window.location.host;
	const testingURL = "http://localhost:8080";
	
	async function getData() {
		try {
			const response = await fetch(testingURL + "/api/v1/student/getStudents");
			if (response.status !== 200) {
				//props.history.push("/login");
				console.log("response not 200 ok");
			}
			const data = await response.json();
			console.log(data);
		} catch (e) {
			console.log('failed');
		}
	}

	async function fetchRegisteredUsers() {
		try {
			const response = await fetch(testingURL + "/api/v1/user/getUsers");
			const data = await response.json();
			setRegisteredUsers(data);
		} catch (e) {
			console.log('failed to fetch registered users');
		}
	}

	function logout() {
		try {
			fetch(url + "/logout");
		} catch (e) {
			console.log('logout unsuccessful');
		}
	}

	return (
		<div>
			Hello World From WelcomeScreen
			<button onClick={getData}>click me</button>
			<br></br>
			<button onClick={logout}>Logout</button>
			<br></br>
			<h1>{registeredUsers === null ? "Load Users Below" : <h1>{registeredUsers.map(user => user + ', ')}</h1>}</h1>
			<button onClick={fetchRegisteredUsers}>Load Users</button>
		</div>
	)
}

export default WelcomeScreen;