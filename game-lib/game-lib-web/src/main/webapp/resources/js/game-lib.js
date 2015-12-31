var oldComponent;

var oldTile;

function selectTile(component, tile) {

	if (oldComponent != null) {
		oldComponent.style.border = "none";
	}
	component.style.border = "rgb(255, 0, 0) solid 1px";
	oldComponent = component;
	oldTile = tile;
	// dsiplay menu
	$("#tileMenu").empty();
	$("#tileMenu").append(
			"<p>Tile selected  (" + tile.x + "," + tile.y + ")</p>");
	if (("humanoideList" in tile)) {
		$("#tileMenu").append(
				"<p>Human : " + tile.humanoideList.length + "</p>");
	}

};

function updateSelectedTile() {
	if (oldTile != null) {
		var elem = document.getElementById("tile-" + oldTile.x + "-"
				+ oldTile.y);
		if (typeof elem.onclick == "function") {
			elem.onclick.apply(elem);
		}
	}
}
