package org.game.lib.business.controller;

import java.util.ArrayList;
import java.util.List;

import org.game.lib.object.human.Human;

public class MainController  {

	private List<Human> humanList = new ArrayList<Human>();

	private boolean isFinish = false;
	
	private int food = 0;
	
	public List<Human> getHumanList() {
		return humanList;
	}

	public void setHumanList(List<Human> humanList) {
		this.humanList = humanList;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

}
