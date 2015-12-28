package org.borsoi.game.lib.ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.borsoi.game.lib.business.controller.MainController;
import org.borsoi.game.lib.business.timer.MainTimer;
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

    @PostConstruct
    public void init()
    {

        mainController = new MainController();

        MainTimer mainTimer = new MainTimer(mainController);

        Thread t = new Thread(mainTimer);

        t.start();

        outputController.showMainScreen(mainController);
    }

    public void updatePage()
    {
        outputController.showMainScreen(mainController);
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
