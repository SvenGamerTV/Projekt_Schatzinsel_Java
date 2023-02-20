package de.svenzilius.hwr.projekt_schatzinsel;


public class Pirate {
	
	private int _posX;
	private int _posY;
	private int _id;
	
	public Pirate(int pId, int pPosX, int pPosY) {
		_id = pId;
		_posX = pPosX;
		_posY = pPosY;
	}
	
	public int getId() {
		return _id;
	}
	
	public int getPositionX(){
		return _posX;
	}
	
	public int getPositionY(){
		return _posY;
	}

	public void movePirate(int pPosXnew, int pPosYnew) {
		_posX = pPosXnew;
		_posY = pPosYnew;
	}
}
