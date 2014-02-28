package controllers;

import main.Prisoner;

public class Random extends Prisoner {
	public Random(int id) {
		super(id);
	}

	@Override
	public boolean play() {
		java.util.Random seedGen = new java.util.Random();
		java.util.Random gen = new java.util.Random(seedGen.nextLong());
		
		return gen.nextBoolean();
	}
}