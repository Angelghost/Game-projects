package org.borsoi.game.lib.object.object.human;

import org.borsoi.game.lib.object.object.Humanoide;
import org.borsoi.game.lib.object.object.job.Job;

public class Human extends Humanoide {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4679848328372433567L;

	
	private Job job;


	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}
	
	
	
}
