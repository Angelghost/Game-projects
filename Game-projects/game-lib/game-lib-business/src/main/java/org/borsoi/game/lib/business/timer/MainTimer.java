package org.borsoi.game.lib.business.timer;

import java.util.Timer;

import org.borsoi.game.lib.business.controller.MainController;

public class MainTimer extends Timer implements Runnable {


	private MainController mainController = new MainController();

	public MainTimer() {
	}

	public MainTimer( MainController pMainController) {
		mainController = pMainController;

	}

	public void run() {
		while (!mainController.isFinish()) {
			try {
				Thread.sleep(5 * 1000);
				MainTask.run(mainController);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		System.out.println("Timer finish");
		Thread.currentThread().interrupt();
	}
}