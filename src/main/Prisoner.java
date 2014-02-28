package main;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Prisoner {
	private int yearsServed = 0;
	public final int id;
	
	/**
	 * @param id 1 if player1 or 2 if player2
	 */
	public Prisoner(int id) {
		this.id = id;
	}
	
	/**
	 * @return decision; true betrayal
	 */
	public abstract boolean play();
	
	public final void sentence(int years) {
		this.yearsServed += years;
	}
	
	public final int getYearsServed() {
		return this.yearsServed;
	}
	
	public final ArrayList<Boolean> getMoveLog() {
		return Main.getMoveLog(this.id);
	}
	
	public final ArrayList<Boolean> getEnemyMoveLog() {
		if (this.id == 1) {
			return Main.getMoveLog(2);
		} else if (this.id == 2) {
			return Main.getMoveLog(1);
		} else {
			return null;
		}
	}
	
	public final int timesBetrayed() {
		return Collections.frequency(Main.getMoveLog(this.id), true);
	}
	public final int timesSilent() {
		return Collections.frequency(Main.getMoveLog(this.id), false);
	}
	/**
	 * Clears prisoner information(except for id) for a fresh start
	 */
	public void reset() {
		this.yearsServed = 0;
	}
}