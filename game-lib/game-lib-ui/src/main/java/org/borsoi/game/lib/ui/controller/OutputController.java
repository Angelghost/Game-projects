package org.borsoi.game.lib.ui.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.borsoi.game.lib.business.controller.MainController;
import org.borsoi.game.lib.object.enumeric.JobType;
import org.borsoi.game.lib.object.enumeric.ResourceType;
import org.borsoi.game.lib.object.object.UserContext;
import org.borsoi.game.lib.object.object.human.Human;
import org.borsoi.game.lib.object.object.job.Resource;

@ManagedBean(name = "outputController")
@SessionScoped
public class OutputController
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private List<String> output;

    public void showMainScreen(MainController pMainController)
    {

        List<String> stringToDeplay = new ArrayList<String>();
        // cleanConsole();
        stringToDeplay.addAll(showResources(pMainController.getUserContext()));
        stringToDeplay.add(drawALine());
        stringToDeplay.addAll(showJob(pMainController.getHumanList()));
        stringToDeplay.add(drawALine());
        stringToDeplay.addAll(showMenu());
        stringToDeplay.add(drawALine());

        setOutput(stringToDeplay);

    }

    private List<String> showResources(UserContext userContext)
    {

        List<String> result = new ArrayList<String>();
        if (userContext != null)
        {
            result.add("Resources    : ");
            if (userContext.getResourceList() != null)
            {
                for (Resource resource : userContext.getResourceList())
                {
                    result.add(resource.getResourceType().toString() + "          " + resource.getValue());
                }

            }

            result.add("Modification : ");
            if (userContext.getTotalModificationMap() != null)
            {
                for (ResourceType resourceType : userContext.getTotalModificationMap().keySet())
                {

                    double value = userContext.getTotalModificationMap().get(resourceType);
                    result.add(resourceType.toString() + "          " + (value >= 0 ? "+" : "-") + value);

                }

            }
        }
        return result;

    }

    private List<String> showJob(List<Human> humanList)
    {
        List<String> result = new ArrayList<String>();
        if (humanList != null && !humanList.isEmpty())
        {
            result.add("You have " + humanList.size() + " humans");
            Map<JobType, Integer> temporaryMap = new HashMap<JobType, Integer>();
            for (Human human : humanList)
            {

                if (human.getJob() == null || human.getJob().getJobType() == null)
                {
                    if (temporaryMap.containsKey(JobType.NONE))
                    {
                        temporaryMap.put(JobType.NONE, temporaryMap.get(JobType.NONE) + 1);
                    }
                    else
                    {
                        temporaryMap.put(JobType.NONE, 1);

                    }
                }
                else
                {
                    if (temporaryMap.containsKey(human.getJob().getJobType()))
                    {
                        temporaryMap
                            .put(human.getJob().getJobType(), temporaryMap.get(human.getJob().getJobType()) + 1);
                    }
                    else
                    {
                        temporaryMap.put(human.getJob().getJobType(), 1);
                    }

                }
            }

            if (!temporaryMap.isEmpty())
            {
                for (JobType key : temporaryMap.keySet())
                {
                    result.add("You have " + temporaryMap.get(key) + " " + getLabel(key));
                }
            }
        }
        return result;

    }

    private static String getLabel(JobType key)
    {
        switch (key)
        {
            case NONE:
                return "no job";
            case FARMER:
                return "farmer";
            default:
                break;
        }
        return key.toString();
    }

    private List<String> showMenu()
    {
        List<String> result = new ArrayList<String>();
        result.add("Menu choose :");
        result.add("-- F create a farmer");
        result.add("-- E for exist");
        return result;
    }

    private static void cleanConsole()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }

    private String drawALine()
    {
        return "------------------------------------------------------------------";

    }

    public List<String> getOutput()
    {
        return output;
    }

    public void setOutput(List<String> output)
    {
        this.output = output;
    }

}
