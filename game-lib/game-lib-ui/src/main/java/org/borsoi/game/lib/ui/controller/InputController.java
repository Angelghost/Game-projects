package org.borsoi.game.lib.ui.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.borsoi.game.lib.business.controller.MainController;
import org.borsoi.game.lib.object.object.human.Human;

public class InputController implements Runnable {

	private MainController mainController;

	public InputController(MainController pMainController) {
		mainController = pMainController;
	}

	public void run() {

		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));
		String input = null;
		try {
			while (!"exit".equals(input)) {
				input = bufferRead.readLine();

				if (!"exit".equals(input)) {
					mainController.getHumanList().add(new Human());
					System.out.println("You have "
							+ mainController.getHumanList().size() + " humans");
				} else {
					bufferRead.close();

				}
			}

		} catch (IOException e) {
		}
		mainController.setFinish(true);

		Thread.currentThread().interrupt();

	}
}
