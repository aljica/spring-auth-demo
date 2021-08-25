const WelcomeScreen = (props) => {

	async function getData() {
		try {
			const response = await fetch("http://localhost:8080/api/v1/student/getStudents");
			const data = await response.json();
			console.log(data);
		} catch (e) {
			console.log('failed');
		}
	}

	return (
		<div>
			Hello World From WelcomeScreen
			<button onClick={getData}>click me</button>
		</div>
	)
}

export default WelcomeScreen;