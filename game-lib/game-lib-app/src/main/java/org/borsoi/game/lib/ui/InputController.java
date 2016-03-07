package org.borsoi.game.lib.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;

import org.borsoi.game.lib.business.controller.MainController;
import org.borsoi.game.lib.business.utils.AddJobUtility;
import org.borsoi.game.lib.object.enumeric.JobType;
import org.borsoi.game.lib.object.object.human.Human;

public class InputController
    implements Serializable, Runnable
{

    private static final long serialVersionUID = -2336775829944188745L;


    private MainController mainController;

    public InputController()
    {

    }

    public InputController(MainController pMainController)
    {
        mainController = pMainController;
    }

    public void run()
    {

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try
        {
            while (!"E".equals(input))
            {
                input = bufferRead.readLine();

                if (!"E".equals(input))
                {

                    if ("F".equals(input))
                    {
                        mainController.setHumanList(callToAddJob(JobType.FARMER));
                    }

                    // OutputController.showMainScreen(mainController);
                }
                else
                {
                    bufferRead.close();
                }
            }

        }
        catch (IOException e)
        {
        }
        mainController.setFinish(true);

        Thread.currentThread().interrupt();

    }

    /**
     * @param pFarmer
     * @param pNovice
     * @return
     */
    private List<Human> callToAddJob(JobType pJobType)
    {

        if (mainController.getHumanList() != null)
        {

            return AddJobUtility.addJob(mainController.getHumanList(), pJobType);
        }

        return null;

    }

    public void addHuman()
    {
        if (mainController == null)
        {
            mainController = mainContextController.getMainController();
        }
        mainController.addNewHuman();
        mainContextController.updatePage();
    }

    public void addFarmer()
    {
        if (mainController == null)
        {
            mainController = mainContextController.getMainController();
        }
        mainController.setHumanList(callToAddJob(JobType.FARMER));
        mainController.updateModifcation();
        mainContextController.updatePage();
    }

    public void addWoodCutter()
    {
        if (mainController == null)
        {
            mainController = mainContextController.getMainController();
        }
        mainController.setHumanList(callToAddJob(JobType.WOODCUTTER));
        mainController.updateModifcation();
        mainContextController.updatePage();
    }

    /**
     * Return mainContextController
     * @return mainContextController
     */
    public MainContextController getMainContextController()
    {
        return mainContextController;
    }

    /**
     * Set mainContextController
     * @param pMainContextController mainContextController
     */
    public void setMainContextController(MainContextController pMainContextController)
    {
        mainContextController = pMainContextController;
    }
}
