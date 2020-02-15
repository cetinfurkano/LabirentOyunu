package Oyun2;

public class Guclen extends Ozellik {

	public Guclen(int[][] grid, Karakter karakter) {
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
		if (gecerliOzellik(x, y)) {
			aktif = false;
			return aktif;
		}

		if (matris[y][x] == Labirent.KUTU) {
			switch (yon) {
			case Labirent.SAGA:

				if (matris[y][x + 1] == Labirent.KUTU && matris[y][x + 2] != Labirent.KUTU
						&& matris[y][x + 2] != Labirent.DUVAR) {
					aktif = true;
					matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
					matris[y][x] = Labirent.ADAM;
					karakter.setAdamX(x);
					karakter.setAdamY(y);
					matris[y][x + 1] = Labirent.KUTU;
					matris[y][x + 2] = Labirent.KUTU;

				}

				break;

			case Labirent.SOLA:

				if (matris[y][x - 1] == Labirent.KUTU && matris[y][x - 2] != Labirent.KUTU
						&& matris[y][x - 2] != Labirent.DUVAR) {
					aktif = true;
					matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
					matris[y][x] = Labirent.ADAM;
					karakter.setAdamX(x);
					karakter.setAdamY(y);
					matris[y][x - 1] = Labirent.KUTU;
					matris[y][x - 2] = Labirent.KUTU;

				}

				break;

			case Labirent.ASAGI:

				if (matris[y + 1][x] == Labirent.KUTU && matris[y + 2][x] != Labirent.KUTU
						&& matris[y + 2][x] != Labirent.DUVAR) {
					aktif = true;
					matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
					matris[y][x] = Labirent.ADAM;
					karakter.setAdamX(x);
					karakter.setAdamY(y);
					matris[y + 1][x] = Labirent.KUTU;
					matris[y + 2][x] = Labirent.KUTU;

				}

				break;

			case Labirent.YUKARI:

				if (matris[y - 1][x] == Labirent.KUTU && matris[y - 2][x] != Labirent.KUTU
						&& matris[y - 2][x] != Labirent.DUVAR) {
					aktif = true;
					matris[karakter.getAdamY()][karakter.getAdamX()] = Labirent.ZEMIN;
					matris[y][x] = Labirent.ADAM;
					karakter.setAdamX(x);
					karakter.setAdamY(y);
					matris[y - 1][x] = Labirent.KUTU;
					matris[y - 2][x] = Labirent.KUTU;

				}

				break;
			}
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
