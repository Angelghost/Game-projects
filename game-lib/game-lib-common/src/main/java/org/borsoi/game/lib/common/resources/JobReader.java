package org.borsoi.game.lib.common.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.borsoi.game.lib.object.enumeric.JobType;
import org.borsoi.game.lib.object.object.job.Job;
import org.borsoi.game.lib.object.object.job.Modification;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class JobReader
    extends AbstractReader
{
    private static JobReader instance = new JobReader();

    private static String RESSOURCE_FILE = "org/borsoi/game/lib/common/Jobs.xml";

    private List<Job> jobList;

    private Map<JobType, List<Job>> jobMap;

    @SuppressWarnings("unchecked")
    private JobReader()
    {
        Object objectInfile = getObject();

        if (objectInfile instanceof List)
        {
            jobList = (List<Job>) objectInfile;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public XStream getXStream()
    {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("JobList", List.class);
        xStream.alias("Job", Job.class);
        xStream.alias("modification", Modification.class);
        return xStream;
    }

    public List<Job> getJobByType(JobType pJobtype)
    {
        if (jobList == null || pJobtype == null)
        {
            return null;
        }

        if (jobMap == null)
        {
            jobMap = new HashMap<JobType, List<Job>>();
        }

        if (jobMap.containsKey(pJobtype))
        {
            return jobMap.get(pJobtype);
        }
        else
        {
            List<Job> result = new ArrayList<Job>();

            for (Job job : jobList)
            {
                if (job != null && pJobtype.equals(job.getJobType()))
                {
                    result.add(job);
                }
            }

            jobMap.put(pJobtype, result);
            return result;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLabelResourceFile()
    {
        return RESSOURCE_FILE;
    }

    public static JobReader getCurrentInstance()
    {
        return instance;
    }

    /**
     * Return jobList
     * @return jobList
     */
    public List<Job> getJobList()
    {
        return jobList;
    }

    /**
     * Set jobList
     * @param pJobList jobList
     */
    public void setJobList(List<Job> pJobList)
    {
        jobList = pJobList;
    }

}
