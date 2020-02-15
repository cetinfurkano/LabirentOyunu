package Oyun2;

public class SagSolDusman extends Dusmanlar {

	private boolean duvarMý = false;

	
	public SagSolDusman(int[][] grid,int x,int y) {
		super(grid,x,y);
	}
	

	@Override
	protected void hareket() {

		if ((matris[dusmanY][dusmanX + 1] == Labirent.ZEMIN || matris[dusmanY][dusmanX + 1] == Labirent.ADAM)
				&& duvarMý == false) {

			matris[dusmanY][dusmanX] = Labirent.ZEMIN;
			matris[dusmanY][dusmanX + 1] = Labirent.YATAYDUSMAN;

			dusmanX = dusmanX + 1;

		} else {
			duvarMý = true;

		}

		if ((matris[dusmanY][dusmanX - 1] == Labirent.ZEMIN || matris[dusmanY][dusmanX - 1] == Labirent.ADAM)
				&& duvarMý == true) {

			matris[dusmanY][dusmanX] = Labirent.ZEMIN;
			matris[dusmanY][dusmanX - 1] = Labirent.YATAYDUSMAN;
			dusmanX = dusmanX - 1;

		} else {
			duvarMý = false;
		}

	}

}
