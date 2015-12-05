package org.game.lib.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.game.lib.object.human.Human;

public class MainController  {

	private List<Human> humanList = new ArrayList<Human>();

	public List<Human> getHumanList() {
		return humanList;
	}

	public void setHumanList(List<Human> humanList) {
		this.humanList = humanList;
	}

}
