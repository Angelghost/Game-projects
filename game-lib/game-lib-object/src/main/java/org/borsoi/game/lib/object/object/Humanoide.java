package org.borsoi.game.lib.object.object;

import java.io.Serializable;
import java.util.Map;

import org.borsoi.game.lib.object.enumeric.Carateritics;

public class Humanoide implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7426634369606252579L;

	
	private int maxLife;
	
	private Map<Carateritics,Long> carateritics;
	

	public int getMaxLife() {
		return maxLife;
	}

	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	public Map<Carateritics,Long> getCarateritics() {
		return carateritics;
	}

	public void setCarateritics(Map<Carateritics,Long> carateritics) {
		this.carateritics = carateritics;
	}

}