package org.game.lib.ui.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.game.lib.business.controller.MainController;
import org.game.lib.object.human.Human;

public class InputController implements Runnable {

	private MainController mainController;

	public InputController(MainController pMainController) {
		mainController = pMainController;
	}

	public void run() {

		String input = null;
		while (!"exit".equals(input)) {
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			try {
				input = bufferRead.readLine();
			} catch (IOException e) {
			}

			if (!"exit".equals(input)) {
				mainController.getHumanList().add(new Human());

			}
			System.out.println("You have "
					+ mainController.getHumanList().size() + " humans");
		}
		
		mainController.setFinish(true);
		
		Thread.currentThread().interrupt();

	}
}
