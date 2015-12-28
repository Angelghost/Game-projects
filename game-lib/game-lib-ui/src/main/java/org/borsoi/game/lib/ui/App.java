package org.borsoi.game.lib.ui;

import org.borsoi.game.lib.business.controller.MainController;
import org.borsoi.game.lib.business.timer.MainTimer;
import org.borsoi.game.lib.ui.controller.InputController;

/**
 * Hello world!
 */
public class App
{
    public static void main(String[] args)
        throws InterruptedException
    {
        System.out.println("Hello World!");

        MainController mainController = new MainController();
        MainTimer mainTimer = new MainTimer(mainController);

        // OutputController.showMainScreen(mainController);
        Thread t = new Thread(mainTimer);
        InputController inputController = new InputController(mainController);
        // Thread t2 = new Thread(inputController);

        t.start();
        // t2.start();
        //
        // while (t.isAlive() && t2.isAlive()) {
        // try {
        // Thread.sleep(20 * 100);
        // // OutputController.showMainScreen(mainController);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // }
        // t2.interrupt();
        // t2.join();
        t.interrupt();
        t.join();

        Thread.currentThread().interrupt();
        return;
    }

}
