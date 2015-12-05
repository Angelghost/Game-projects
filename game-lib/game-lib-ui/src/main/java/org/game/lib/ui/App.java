package org.game.lib.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.game.lib.object.human.Human;
import org.game.lib.ui.controller.MainController;
import org.game.lib.ui.timer.MainTimer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String input = null;
        MainController mainController = new MainController();
        MainTimer mainTimer = new  MainTimer(5, mainController);
        while(!"exit".equals(input))
        {
        	BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        	try {
				input = bufferRead.readLine();
			} catch (IOException e) {
			}
       	      
        	if(!"exit".equals(input))
        	{
        		mainController.getHumanList().add(new Human());
        		
        	}
       	    System.out.println("You have " +mainController.getHumanList().size() + " humans");
        }
    }
}
