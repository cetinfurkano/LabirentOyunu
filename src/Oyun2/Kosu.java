package Oyun2;

public class Kosu extends Ozellik {

	public Kosu(int[][] grid, Karakter karakter) {
		super(grid, karakter);

	}

	@Override
	protected void yukle(int[][] grid) {

		matris = new int[grid.length][grid[0].length];

		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[0].length; x++) {

				matris[y][x] = grid[y][x];
			}
		}

	}

	@Override
	protected boolean ozellikAktif(int yon, int x, int y) {
		boolean aktif = false;
		switch (yon) {
		case Labirent.YUKARI:
			if (gecerliOzellik(x, (y - 1)) || gecerliOzellik(x, y)) {
				aktif = false;
				break;
			}

			if (matris[y - 1][x] == Labirent.ZEMIN && matris[y][x] == Labirent.ZEMIN

					&& matris[y][x] != Labirent.CIKIS) {
				aktif = true;
				matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
				matris[y - 1][x] = Labirent.ADAM;
				karakter.setAdamX(x);
				karakter.setAdamY(y - 1);
			}

			break;

		case Labirent.SAGA:
			if (gecerliOzellik(x + 1, y) || gecerliOzellik(x, y)) {
				aktif = false;
				break;
			}
			if (matris[y][x + 1] == Labirent.ZEMIN && matris[y][x] == Labirent.ZEMIN

					&& matris[y][x] != Labirent.CIKIS) {
				aktif = true;
				matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
				matris[y][x + 1] = Labirent.ADAM;
				karakter.setAdamX(x + 1);
				karakter.setAdamY(y);
			}

			break;

		case Labirent.SOLA:
			if (gecerliOzellik(x - 1, y) || gecerliOzellik(x, y)) {
				aktif = false;
				break;
			}
			if (matris[y][x - 1] == Labirent.ZEMIN && matris[y][x] == Labirent.ZEMIN
					&& matris[y][x] != Labirent.CIKIS) {
				aktif = true;
				matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
				matris[y][x - 1] = Labirent.ADAM;
				karakter.setAdamX(x - 1);
				karakter.setAdamY(y);
			}

			break;
		case Labirent.ASAGI:
			if (gecerliOzellik(x, (y + 1)) || gecerliOzellik(x, y)) {
				aktif = false;
				break;
			}
			if (matris[y + 1][x] == Labirent.ZEMIN && matris[y][x] == Labirent.ZEMIN
					
					&& matris[y][x] != Labirent.CIKIS) {
				aktif = true;
				matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
				matris[y + 1][x] = Labirent.ADAM;
				karakter.setAdamX(x);
				karakter.setAdamY(y + 1);
			}

			break;

		}
		return aktif;

	}

	@Override
	protected boolean gecerliOzellik(int x, int y) {
		boolean gecerlilik = false;
		for (int ozellik : Labirent.ozellikler) {
			if (matris[y][x] == ozellik) {
				gecerlilik = true;
				return gecerlilik;
			}
		}
		return gecerlilik;
	}

}
