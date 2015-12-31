package org.borsoi.game.lib.ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.borsoi.game.lib.business.controller.MainController;
import org.borsoi.game.lib.business.timer.MainTimer;
import org.borsoi.game.lib.object.object.map.GameMap;
import org.borsoi.game.lib.object.object.map.Tile;
import org.borsoi.game.lib.ui.contants.ControllerNameConstants;

@ManagedBean(name = ControllerNameConstants.MAIN_CONTEXT_CONTROLLER)
@SessionScoped
public class MainContextController
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{outputController}")
    private OutputController outputController;

    private MainController mainController;

    private Tile tileSelected;

    @PostConstruct
    public void init()
    {

        mainController = new MainController();

        MainTimer mainTimer = new MainTimer(mainController);

        Thread t = new Thread(mainTimer);

        t.start();

        outputController.showMainScreen(mainController, tileSelected);
    }

    public void generateMap()
    {
        mainController.generateMap();
    }

    public void updatePage()
    {
        outputController.showMainScreen(mainController, tileSelected);
    }

    public GameMap getGameMap()
    {
        return mainController.getUserContext().getGameMap();
    }

    public String selectTile(int x, int y)
    {

        tileSelected = mainController.getUserContext().getGameMap().getTitle(x, y);
        outputController.showMainScreen(mainController, tileSelected);
        return null;
    }

    /**
     * Return outputController
     * @return outputController
     */
    public OutputController getOutputController()
    {
        return outputController;
    }

    /**
     * Set outputController
     * @param pOutputController outputController
     */
    public void setOutputController(OutputController pOutputController)
    {
        outputController = pOutputController;
    }

    /**
     * @return
     */
    public MainController getMainController()
    {
        return mainController;
    }
}
