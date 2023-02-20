package de.svenzilius.hwr.projekt_schatzinsel;


public class Treasure {
	private int _posX;
	private int _posY;
	
	public Treasure(int pPosX, int pPosY) {
		_posX = pPosX;
		_posY = pPosY;
	}
	
	public int getPositionX(){
		return _posX;

	}
	public int getPositionY(){
		return _posY;
	}
	
	public boolean isTreasureFound (int pPiratePosX, int pPiratePosY) {
		if(pPiratePosX == _posX) {
			if(pPiratePosY == _posY) {
				return true;
			}
		}
		return false;
	}
}
