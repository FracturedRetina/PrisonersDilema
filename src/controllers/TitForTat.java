package controllers;

public class TitForTat extends main.Prisoner {
	public TitForTat(int id) {
		super(id);
	}

	@Override
	public boolean play() {
		boolean enemyLastMove;
		
		try {
			enemyLastMove = getEnemyMoveLog().get(getEnemyMoveLog().size() - 1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		
		return enemyLastMove;
	}
	
}