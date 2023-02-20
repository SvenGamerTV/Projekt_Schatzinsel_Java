package de.svenzilius.hwr.projekt_schatzinsel;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	//Game Paramters, set manually before start
	private final static int cSIZE_X = 25;
	private final static int cSIZE_Y = 25;
	private final static int cPIRATE_COUNT = 3;
	private final static boolean cTEAMS_ENABLED = false;
	private final static boolean cENABLE_HOSTILITY = false;
	
	private static Treasure _treasure;
	
	
	private static List<Pirate> _pirates = new ArrayList<>();
	
	private static List<Pirate> team1;
	private static List<Pirate> team2;
	
	
	
	public static void main(String[] args) {
		int roundcount = 0;
		intializeGame();
		while (!makeTurn()) {
			roundcount++;
		}
		System.out.println("Das Spiel hat " + roundcount + "Runden gedauert.");
	}
	
	private static void intializeGame() {
		Island playField = new Island (cSIZE_X, cSIZE_Y);
		_treasure = new Treasure((int)(Math.random() * cSIZE_X) + 1,  (int)(Math.random() * cSIZE_Y) + 1);
		playField.setTreasurePos(_treasure.getPositionX(), _treasure.getPositionY());
		for(int i = 0; i < cPIRATE_COUNT; i++) {
			int randomX;
			int randomY;
			do {
				randomX = (int)(Math.random() * cSIZE_X) + 1;
				randomY = (int)(Math.random() * cSIZE_Y) + 1;
			} while(_treasure.getPositionX() != randomX && _treasure.getPositionY() != randomY);
			_pirates.add(new Pirate(i, randomX, randomY));
		}
		if(cTEAMS_ENABLED) {
			int pirateCount = _pirates.size();
			for(int j = 0; j < pirateCount; j++) {
				if(j < pirateCount / 2) {
					team1.add(_pirates.get(j));
				} else {
					team2.add(_pirates.get(j));
				}
			}
		}
	}
	
	private static boolean makeTurn() {
		boolean treasureFound = false;
		for (Pirate pirate : _pirates) {
			int randomX;
			int randomY;
			do {
				randomX = (int)(Math.random() * cSIZE_X) + 1;
				randomY = (int)(Math.random() * cSIZE_Y) + 1;
			} while(pirate.getPositionX() != randomX && pirate.getPositionY() != randomY);
			if(cENABLE_HOSTILITY) {
				for (Pirate pirate2 : _pirates) {
					if(pirate2.getPositionX() == randomX && pirate2.getPositionY() == randomY) {
						if(cTEAMS_ENABLED) {
							if(team1.contains(pirate) && !team1.contains(pirate2)){
								_pirates.remove(pirate2);
							}
						}
					}
				}
			}
			pirate.movePirate(randomX, randomY);
			treasureFound = _treasure.isTreasureFound(pirate.getPositionX(), pirate.getPositionY());
		}
		
		return treasureFound;
	}
}
