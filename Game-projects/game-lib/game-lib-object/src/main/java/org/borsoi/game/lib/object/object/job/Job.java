package org.borsoi.game.lib.object.object.job;

import java.util.List;

import org.borsoi.game.lib.object.enumeric.JobLevel;
import org.borsoi.game.lib.object.enumeric.JobType;

public class Job {

	private String jobName;
	
	private JobType jobType;
	
	private JobLevel jobLevel;
	
	private List<Modification> modificationList;

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

	/**
	 * @return the jobLevel
	 */
	public JobLevel getJobLevel() {
		return jobLevel;
	}

	/**
	 * @param jobLevel the jobLevel to set
	 */
	public void setJobLevel(JobLevel jobLevel) {
		this.jobLevel = jobLevel;
	}

	/**
	 * @return the modificationList
	 */
	public List<Modification> getModificationList() {
		return modificationList;
	}

	/**
	 * @param modificationList the modificationList to set
	 */
	public void setModificationList(List<Modification> modificationList) {
		this.modificationList = modificationList;
	}
}
