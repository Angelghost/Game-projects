package org.borsoi.game.lib.object.object;

import java.io.Serializable;

public abstract class Humanoide implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7426634369606252579L;

	private int life;
	
	private int maxLife;
	
	private int minDamage;
	
	private int maxDamage;

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getMaxLife() {
		return maxLife;
	}

	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}
	
}
