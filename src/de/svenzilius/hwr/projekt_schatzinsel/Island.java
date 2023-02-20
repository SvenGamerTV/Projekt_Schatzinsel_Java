package de.svenzilius.hwr.projekt_schatzinsel;

import java.util.HashMap;
import java.util.Map;

public class Island {
	private int _sizeX;
	private int _sizeY;
	
	private int _treasurePosX;
	private int _treasurePosY;
	
	public Island(int sizeX, int sizeY) {
		_sizeX = sizeX;
		_sizeY = sizeY;
	}
	
	public Map<Integer, Integer> getSize() {
		Map<Integer, Integer> sizeMap= new HashMap<Integer, Integer>(_sizeX, _sizeY);
		return sizeMap;
	}
	
	public void setTreasurePos(int pPosX, int pPosY) {
		_treasurePosX = pPosX;
		_treasurePosY = pPosY;
	}
	
	public int getTreasurePosX() {
		return _treasurePosX;
	}
	public int getTreasurePosY() {
		return _treasurePosY;
	}
	
}
