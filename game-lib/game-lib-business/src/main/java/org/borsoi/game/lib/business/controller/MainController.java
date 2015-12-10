package org.borsoi.game.lib.business.controller;

import java.util.ArrayList;
import java.util.List;

import org.borsoi.game.lib.object.object.UserContext;
import org.borsoi.game.lib.object.object.human.Human;
import org.borsoi.game.lib.object.object.job.Modification;

public class MainController
{

    private List<Human> humanList = new ArrayList<Human>();

    private boolean isFinish = false;

    private UserContext userContext;

    public MainController()
    {
        userContext = new UserContext();

        // TODO move to init of userContext with read xml file
        userContext.setFood(200);
        userContext.setModificationList(new ArrayList<Modification>());
        userContext.setTotalFoodModification(0);

    }

    public boolean updateUserContext()
    {

        return true;
    }

    public List<Human> getHumanList()
    {
        return humanList;
    }

    public void setHumanList(List<Human> humanList)
    {
        this.humanList = humanList;
    }

    public boolean isFinish()
    {
        return isFinish;
    }

    public void setFinish(boolean isFinish)
    {
        this.isFinish = isFinish;
    }

    /**
     * Return userContext
     * @return userContext
     */
    public UserContext getUserContext()
    {
        return userContext;
    }

    /**
     * Set userContext
     * @param pUserContext userContext
     */
    public void setUserContext(UserContext pUserContext)
    {
        userContext = pUserContext;
    }

}
