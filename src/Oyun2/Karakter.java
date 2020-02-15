package Oyun2;

public class Karakter {

	private int adamX, adamY;
	
	private int[][] harita;

	public Karakter() {
		adamX = adamY = 0;
		harita = null;
	}

	public Karakter(int[][] param) {
		adamX = adamY = 0;
		yukle(param);
	}

	private void yukle(int[][] param) {
		harita = new int[param.length][param[0].length];
		for (int y = 0; y < param.length; y++) {
			for (int x = 0; x < param[0].length; x++) {
				int hucre = param[y][x];
				if (hucre == Labirent.ADAM) {
					adamX = x;
					adamY = y;
				}
				harita[y][x] = param[y][x];
			}
		}

	}

	public int getAdamX() {
		return adamX;
	}

	public void setAdamX(int adamX) {
		this.adamX = adamX;
	}

	public int getAdamY() {
		return adamY;
	}

	public void setAdamY(int adamY) {
		this.adamY = adamY;
	}

}
