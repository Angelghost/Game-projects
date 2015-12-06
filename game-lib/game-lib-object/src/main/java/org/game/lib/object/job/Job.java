package org.game.lib.object.job;

import org.game.lib.enumeric.JobType;

public class Job {
	
	
	private String jobName;
	
	private JobType jobType;

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}
