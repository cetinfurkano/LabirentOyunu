package Oyun2;

public abstract class Ozellik {
	protected Karakter karakter;

	protected int[][] matris;

	public Ozellik(int[][] grid, Karakter karakter) {
		this.karakter = karakter;
		yukle(grid);
	}

	protected abstract void yukle(int[][] grid);

	protected abstract boolean ozellikAktif(int yon, int x, int y);

	protected int[][] getMatris() {
		return matris;
	}

	protected void setMatris(int[][] grid) {
	     matris = grid;
	}

	protected abstract boolean gecerliOzellik(int x, int y);

}
