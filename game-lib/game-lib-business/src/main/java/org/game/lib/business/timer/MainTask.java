package org.game.lib.business.timer;

import org.game.lib.business.controller.MainController;
import org.game.lib.object.human.Human;

public class MainTask {

	public static void run(MainController pMainController) {
		createHuman(pMainController);
		System.out.println("You have " + pMainController.getHumanList().size()
				+ " humans");
	}

	private static void createHuman(MainController pMainController)
	{
		pMainController.getHumanList().add(new Human());
	}
	
}
