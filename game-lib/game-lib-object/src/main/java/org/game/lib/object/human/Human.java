package org.game.lib.object.human;

import org.game.lib.object.Humanoide;
import org.game.lib.object.job.Job;

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
