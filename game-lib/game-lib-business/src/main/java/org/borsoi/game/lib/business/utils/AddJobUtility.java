package org.borsoi.game.lib.business.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.borsoi.game.lib.common.resources.JobReader;
import org.borsoi.game.lib.object.enumeric.JobLevel;
import org.borsoi.game.lib.object.enumeric.JobType;
import org.borsoi.game.lib.object.object.human.Human;
import org.borsoi.game.lib.object.object.job.Job;

public class AddJobUtility
{

    public static List<Human> addJob(List<Human> pHumanList, JobType pJobType)
    {

        Map<Integer, Human> temporaryMap = new HashMap<Integer, Human>();

        if (pHumanList != null && !pHumanList.isEmpty())
        {
            for (Human human : pHumanList)
            {
                if (human.getJob() == null || human.getJob().getJobType() == null
                    || JobType.NONE.equals(human.getJob().getJobType()))
                {
                    temporaryMap.put(pHumanList.indexOf(human), human);
                    break;
                }

            }

            // TODO : temporay solution need to choose the better for this

            if (!temporaryMap.isEmpty())
            {
                for (Integer key : temporaryMap.keySet())
                {
                    Human human = temporaryMap.get(key);
                    human.setJob(createJob(pJobType, JobLevel.NOVICE));
                    pHumanList.set(key, human);
                }
            }
        }

        return pHumanList;
    }

    /**
     * @param pJobType
     * @return
     */
    private static Job createJob(JobType pJobType, JobLevel pJobLevel)
    {
        List<Job> jobList = JobReader.getCurrentInstance().getJobByType(pJobType);

        if (jobList != null)
        {
            for (Job jobTemplate : jobList)
            {
                if (pJobLevel.equals(jobTemplate.getJobLevel()))
                {
                    return jobTemplate;
                }
            }
        }
        return null;
    }
}
