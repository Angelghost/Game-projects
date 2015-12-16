package org.borsoi.game.lib.object.object.job;

import java.util.List;

import org.borsoi.game.lib.object.enumeric.JobLevel;
import org.borsoi.game.lib.object.enumeric.JobType;

public class Job
{

    private String jobName;

    private JobType jobType;

    private JobLevel jobLevel;

    private List<Modification> modificationList;

    public JobType getJobType()
    {
        return jobType;
    }

    public void setJobType(JobType jobType)
    {
        this.jobType = jobType;
    }

    /**
     * @return the jobName
     */
    public String getJobName()
    {
        return jobName;
    }

    /**
     * @param jobName the jobName to set
     */
    public void setJobName(String jobName)
    {
        this.jobName = jobName;
    }

    /**
     * Return modificationList
     * @return modificationList
     */
    public List<Modification> getModificationList()
    {
        return modificationList;
    }

    /**
     * Set modificationList
     * @param pModificationList modificationList
     */
    public void setModificationList(List<Modification> pModificationList)
    {
        modificationList = pModificationList;
    }

    /**
     * Return jobLevel
     * @return jobLevel
     */
    public JobLevel getJobLevel()
    {
        return jobLevel;
    }

    /**
     * Set jobLevel
     * @param pJobLevel jobLevel
     */
    public void setJobLevel(JobLevel pJobLevel)
    {
        jobLevel = pJobLevel;
    }
}
