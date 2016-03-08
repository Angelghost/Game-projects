var oldFirstComponent;

var oldSecondComponent;

var oldFirstTile;

var oldSecondTile;

var isCallByUpdate;

function selectTile(component, tile) {

	if (!isCallByUpdate) {
		if (oldFirstComponent != null && oldSecondComponent != null) {
			oldFirstComponent.style.border = "none";
			oldSecondComponent.style.border = "none";
		}

		if (oldFirstComponent == null
				|| (oldFirstComponent != null && oldSecondComponent != null)) {
			oldFirstComponent = component;
			oldFirstTile = tile;
			oldSecondComponent = null;
			oldSecondTile = null;
		} else if (oldFirstComponent != null && oldSecondComponent == null) {
			oldSecondComponent = component;
			oldSecondTile = tile;
		}

	}

	component.style.border = "rgb(255, 0, 0) solid 1px";
	if (oldSecondComponent != null) {
		oldSecondComponent.style.border = "rgb(255, 0, 0) solid 1px";
	}

	// dsiplay menu
	$("#tileMenu").empty();
	$("#tileMenu").append(
			"<p>Tile selected  (" + oldFirstTile.x + "," + oldFirstTile.y
					+ ")</p>");
	if (("humanoideList" in oldFirstTile)) {
		$("#tileMenu").append(
				"<p>Human : " + oldFirstTile.humanoideList.length + "</p>");
	}
	if (oldSecondTile != null) {
		$("#tileMenu").append(
				"<p>Second Tile selected  (" + oldSecondTile.x + ","
						+ oldSecondTile.y + ")</p>");

		if (("humanoideList" in oldSecondTile)) {
			$("#tileMenu")
					.append(
							"<p>Human : " + oldSecondTile.humanoideList.length
									+ "</p>");
		}
	}
	isCallByUpdate = false;
};

function updateSelectedTile() {
	if (oldFirstTile != null) {
		var elem = document.getElementById("tile-" + oldFirstTile.x + "-"
				+ oldFirstTile.y);
		if (typeof elem.onclick == "function") {
			isCallByUpdate = true;
			elem.onclick.apply(elem);
		}
	}
}
