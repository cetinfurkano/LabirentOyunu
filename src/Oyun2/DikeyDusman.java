package Oyun2;

public class DikeyDusman extends Dusmanlar {
	private boolean duvarMý = false;

	
	public DikeyDusman(int[][] grid,int x,int y) {
		super(grid,x,y);
	}
	
	
	@Override
	protected void hareket() {
		if ((matris[dusmanY - 1][dusmanX] == Labirent.ZEMIN || matris[dusmanY - 1][dusmanX] == Labirent.ADAM)
				&& duvarMý == false) {
			matris[dusmanY][dusmanX] = Labirent.ZEMIN;
			matris[dusmanY - 1][dusmanX] = Labirent.DÝKEYDUSMAN;
			dusmanY = dusmanY - 1;

		} else {
			duvarMý = true;
		}

		if ((matris[dusmanY + 1][dusmanX] == Labirent.ZEMIN || matris[dusmanY + 1][dusmanX] == Labirent.ADAM)
				&& duvarMý == true) {
			matris[dusmanY][dusmanX] = Labirent.ZEMIN;
			matris[dusmanY + 1][dusmanX] = Labirent.DÝKEYDUSMAN;
			dusmanY = dusmanY + 1;

		} else {
			duvarMý = false;
		}

	}

}
