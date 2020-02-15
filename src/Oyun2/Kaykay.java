package Oyun2;

public class Kaykay extends Ozellik {

	public Kaykay(int[][] grid, Karakter karakter) {
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
			if (gecerliOzellik(x, y)) {
				aktif = false;
				break;
			}

			else if (matris[y][x] == Labirent.KUTU || matris[y][x] == Labirent.DUVAR) {
				aktif = false;
				break;
			}

			else {
				while (matris[y - 1][x] == Labirent.ZEMIN && matris[y][x] != Labirent.CIKIS
						&& (gecerliOzellik(x, y - 1) == false && gecerliOzellik(x, y) == false)) {

					y -= 1;
				}
				matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
				matris[y][x] = Labirent.ADAM;
				karakter.setAdamX(x);
				karakter.setAdamY(y);
				aktif = true;
				break;
			}

		case Labirent.ASAGI:
			if (gecerliOzellik(x, y)) {
				aktif = false;
				break;
			}

			else if (matris[y][x] == Labirent.KUTU || matris[y][x] == Labirent.DUVAR) {
				aktif = false;
				break;
			} else {
				while (matris[y + 1][x] == Labirent.ZEMIN && matris[y][x] != Labirent.CIKIS
						&& (gecerliOzellik(x, y + 1) == false && gecerliOzellik(x, y) == false)) {
					y += 1;
				}
				matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
				matris[y][x] = Labirent.ADAM;
				karakter.setAdamX(x);
				karakter.setAdamY(y);
				aktif = true;
				break;
			}
		case Labirent.SAGA:
			if (gecerliOzellik(x, y)) {
				aktif = false;
				break;
			} else if (matris[y][x] == Labirent.KUTU || matris[y][x] == Labirent.DUVAR) {
				aktif = false;
				break;
			} else {
				while (matris[y][x + 1] == Labirent.ZEMIN && matris[y][x] != Labirent.CIKIS
						&& (gecerliOzellik(x + 1, y) == false && gecerliOzellik(x, y) == false)) {
					x += 1;
				}
				matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
				matris[y][x] = Labirent.ADAM;
				karakter.setAdamX(x);
				karakter.setAdamY(y);
				aktif = true;
				break;
			}
		case Labirent.SOLA:
			if (gecerliOzellik(x, y)) {
				aktif = false;
				break;
			} else if (matris[y][x] == Labirent.KUTU || matris[y][x] == Labirent.DUVAR) {
				aktif = false;
				break;
			} else {
				while (matris[y][x - 1] == Labirent.ZEMIN && matris[y][x] != Labirent.CIKIS
						&& (gecerliOzellik(x - 1, y) == false && gecerliOzellik(x, y) == false)) {
					x -= 1;
				}
				matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
				matris[y][x] = Labirent.ADAM;
				karakter.setAdamX(x);
				karakter.setAdamY(y);
				aktif = true;
				break;
			}
		default:
			aktif = false;
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
