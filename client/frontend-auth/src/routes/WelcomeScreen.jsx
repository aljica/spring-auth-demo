//import SockJS from "sockjs-client";

const WelcomeScreen = (props) => {

	/*let sock = new SockJS("http://localhost:8080/gs-guide-websocket");
	sock.onopen = function() {
		console.log('opened');
	};*/

	async function getData() {
		try {
			const response = await fetch("http://localhost:8080/api/v1/student/getStudents");
			if (response.status != 200) {
				//props.history.push("/login");
				console.log("response not 200 ok");
			}
			const data = await response.json();
			console.log(data);
		} catch (e) {
			console.log('failed');
		}
	}

	function logout() {
		try {
			fetch("http://localhost:8080/logout");
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
		</div>
	)
}

export default WelcomeScreen;