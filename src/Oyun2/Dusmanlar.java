package Oyun2;

public abstract class Dusmanlar 
{

	protected int dusmanX,dusmanY;
	
	
	protected int [][] matris;
	
	
	public Dusmanlar(int [][] grid,int x, int y) 
	{
		dusmanX = x;
		dusmanY = y;
	    matris = grid;
	    	
	}

	protected abstract void hareket();
	
	protected int[][]getHarita(){
		return matris;
	}
	
}
