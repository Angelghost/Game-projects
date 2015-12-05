package org.game.lib.ui.timer;

import java.util.Timer;

import org.game.lib.ui.controller.MainController;

public class MainTimer extends Timer implements Runnable {

	private Timer timer;
	private int seconds;

	private MainController mainController = new MainController();

	public MainTimer(int pSeconds) {
		timer = new Timer();
		timer.schedule(new MainTask(), seconds * 100);
		seconds = pSeconds;
	}

	public MainTimer(int pSeconds, MainController pMainController) {
		timer = new Timer();
		mainController = pMainController;
		seconds = pSeconds;

	}

	public void run() {
		timer.schedule(new MainTask(mainController), seconds * 100);
	}
}
