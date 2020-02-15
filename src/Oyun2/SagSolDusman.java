package Oyun2;

public class SagSolDusman extends Dusmanlar {

	private boolean duvarM� = false;

	
	public SagSolDusman(int[][] grid,int x,int y) {
		super(grid,x,y);
	}
	

	@Override
	protected void hareket() {

		if ((matris[dusmanY][dusmanX + 1] == Labirent.ZEMIN || matris[dusmanY][dusmanX + 1] == Labirent.ADAM)
				&& duvarM� == false) {

			matris[dusmanY][dusmanX] = Labirent.ZEMIN;
			matris[dusmanY][dusmanX + 1] = Labirent.YATAYDUSMAN;

			dusmanX = dusmanX + 1;

		} else {
			duvarM� = true;

		}

		if ((matris[dusmanY][dusmanX - 1] == Labirent.ZEMIN || matris[dusmanY][dusmanX - 1] == Labirent.ADAM)
				&& duvarM� == true) {

			matris[dusmanY][dusmanX] = Labirent.ZEMIN;
			matris[dusmanY][dusmanX - 1] = Labirent.YATAYDUSMAN;
			dusmanX = dusmanX - 1;

		} else {
			duvarM� = false;
		}

	}

}
