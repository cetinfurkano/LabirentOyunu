package Oyun2;

public class DikeyDusman extends Dusmanlar {
	private boolean duvarM� = false;

	
	public DikeyDusman(int[][] grid,int x,int y) {
		super(grid,x,y);
	}
	
	
	@Override
	protected void hareket() {
		if ((matris[dusmanY - 1][dusmanX] == Labirent.ZEMIN || matris[dusmanY - 1][dusmanX] == Labirent.ADAM)
				&& duvarM� == false) {
			matris[dusmanY][dusmanX] = Labirent.ZEMIN;
			matris[dusmanY - 1][dusmanX] = Labirent.D�KEYDUSMAN;
			dusmanY = dusmanY - 1;

		} else {
			duvarM� = true;
		}

		if ((matris[dusmanY + 1][dusmanX] == Labirent.ZEMIN || matris[dusmanY + 1][dusmanX] == Labirent.ADAM)
				&& duvarM� == true) {
			matris[dusmanY][dusmanX] = Labirent.ZEMIN;
			matris[dusmanY + 1][dusmanX] = Labirent.D�KEYDUSMAN;
			dusmanY = dusmanY + 1;

		} else {
			duvarM� = false;
		}

	}

}
