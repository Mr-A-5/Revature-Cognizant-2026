document.querySelector("#getUmaButton").addEventListener("click", async () => {
	let container = document.querySelector("#container");
	let div = document.querySelector("#result");
	let imageContainer = document.querySelector("#imgContainer");
	let umaDataContainer = document.querySelector("#umaDataContainer");

	if (!div) {
		div = document.createElement("div");
		div.id = "result";
		container.appendChild(div);
	}

	// Get all Umas
	let response = await fetch("https://umapyoi.net/api/v1/character");
	let parsedResponse = await response.json();

	// Get a random Uma Id
	let uma = parsedResponse[Math.floor(Math.random() * parsedResponse.length)];
	let id = uma.game_id;
	// Fetch that Uma image
	const url = "https://umapyoi.net/api/v1/character/images/" + id;
	let imageResponse = await fetch(url);
	let imageJson = await imageResponse.json();
	// Fetch Uma Data
	const umaDataUrl = "https://umapyoi.net/api/v1/character/" + id;
	let umaDataResponse = await fetch(umaDataUrl);
	let umaDataJson = await umaDataResponse.json();
	// Append uma data to Portofolio
	const umaDataSpanL1 = document.createElement("h2");
	const umaDataSpanL2 = document.createElement("span");
	const umaName = umaDataJson.name_en;
	const umaProfile = umaDataJson.profile;
	umaDataSpanL1.innerHTML = umaName;
	umaDataSpanL2.innerHTML = "About her: " + umaProfile;
	if (umaDataContainer) {
		umaDataContainer.innerHTML = "";
		umaDataContainer.appendChild(umaDataSpanL1);
		umaDataContainer.appendChild(umaDataSpanL2);
	}
	// Append Uma Image to Portfolio
	console.log(imageJson[0].images[0].image);
	const imgContainer = document.createElement("img");
	imgContainer.src = imageJson[0].images[0].image;
	if (imageContainer) {
		imageContainer.innerHTML = "";
		imageContainer.appendChild(imgContainer);
	}
});
