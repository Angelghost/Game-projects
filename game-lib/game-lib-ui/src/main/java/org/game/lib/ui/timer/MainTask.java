package org.game.lib.ui.timer;

import java.util.TimerTask;

import org.game.lib.object.human.Human;
import org.game.lib.ui.controller.MainController;

public class MainTask extends TimerTask {

	private MainController mainController;

	public MainTask(MainController pMainController) {
		mainController = pMainController;
	}
	
	public MainTask() {
	}

	@Override
	public void run() {
		mainController.getHumanList().add(new Human());
		System.out.println("You have " +mainController.getHumanList().size() + " humans");
	}

}
