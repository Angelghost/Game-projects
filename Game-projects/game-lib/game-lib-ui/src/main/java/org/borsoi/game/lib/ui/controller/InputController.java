
package org.borsoi.game.lib.ui.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.borsoi.game.lib.business.controller.MainController;
import org.borsoi.game.lib.business.utils.AddJobUtility;
import org.borsoi.game.lib.object.enumeric.JobType;
import org.borsoi.game.lib.object.object.human.Human;

public class InputController
    implements Runnable
{

    private MainController mainController;

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

                    OutputController.showMainScreen(mainController);
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
}
