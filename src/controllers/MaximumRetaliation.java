package controllers;

public class MaximumRetaliation extends main.Prisoner {
	public MaximumRetaliation(int id) {
		super(id);
	}
	
	@Override
	public boolean play() {
		if (this.getEnemyMoveLog().contains(true)) {
			return true;
		} else {
			return false;
		}
	}
}