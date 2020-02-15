package Oyun2;

import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Labirent {

	private Karakter karakter;
	private Ozellik ozellik;

	
	private int hedefX, hedefY;

	private Vector<Dusmanlar> dusman = new Vector<Dusmanlar>();

	protected static final int ZEMIN = 1;
	protected static final int DUVAR = 2;
	protected static final int ADAM = 3;
	protected static final int YILDIZ = 5;
	protected static final int KUTU = 6;
	protected static final int KOS = 7;
	protected static final int GUCLEN = 8;
	protected static final int KAYKAY = 9;
	protected static final int CIKIS = 4;
	protected static final int YATAYDUSMAN = 10;
	protected static final int DÝKEYDUSMAN = 11;

	protected static int ozellikler[] = { KOS, GUCLEN, KAYKAY };

	private int YON;

	protected static final int YUKARI = 1;
	protected static final int ASAGI = 2;
	protected static final int SAGA = 3;
	protected static final int SOLA = 4;

	private int adimSay = 0;
	private int belirSay = 0;

	private int cikistaMi = 0;

	private int aktifSure = 0;

	private int kacYildiz = 0;

	private int yildizSayisi = 0;

	private int matris[][];

	public Labirent() {

		matris = null;
		karakter = null;
		ozellik = null;
	
	}

	public Labirent(int[][] grid) {

		karakter = new Karakter(grid);
		
		ozellik = null;
		yukle(grid);

	}

	public void yukle(int[][] grid) {

		matris = new int[grid.length][grid[0].length];

		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[0].length; x++) {
				int hucre = grid[y][x];
				if (hucre == ADAM) {
					karakter.setAdamX(x);
					karakter.setAdamY(y);
				}
				if (hucre == CIKIS) {
					hedefX = x;
					hedefY = y;
				}
				if (hucre == YILDIZ) {
					kacYildiz++;
				}
				if (hucre == YATAYDUSMAN) {
					dusman.add(new SagSolDusman(grid, x, y));
				}
				if (hucre == DÝKEYDUSMAN) {
					dusman.add(new DikeyDusman(grid, x, y));
				}
				matris[y][x] = grid[y][x];
			}
		}

	}

	public int getAdamX() {
		return karakter.getAdamX();
	}

	public int getYildizSayisi() {
		return yildizSayisi;

	}

	public int getAdamY() {
		return karakter.getAdamY();
	}

	public void adaminYeriniGuncelle(int x, int y) {

		adimSay++;
		belirSay++;
        
		if (belirSay == 15) {
			Belir();
			belirSay = 0;
			adimSay = 0;
		}

		if (dusmanVarmý(matris)) {
			for (int i = 0; i < dusman.size(); i++) {
				dusman.get(i).hareket();
				matris = dusman.get(i).getHarita();
			}
		}

		if (adimSay == 10) {
			zeminYap(matris);
			adimSay = 0;
		}

		if (aktifSure >= 10 && aktifSure <= 30) {
			aktifSure++;
			ozellik.setMatris(matris);
			if (ozellik.ozellikAktif(YON, x, y)) {
				matris = ozellik.getMatris();
				if (karakter.getAdamX() == hedefX && karakter.getAdamY() == hedefY)
					cikistaMi = 1;

			} else {

				matris = ozellik.getMatris();
				normalHareket(x, y);
				if (karakter.getAdamX() == hedefX && karakter.getAdamY() == hedefY)
					cikistaMi = 1;
			}

		}
		if (aktifSure > 30)
			aktifSure = 0;
		else if (aktifSure == 0) {
			normalHareket(x, y);

		}
		if (dusmanIleKarsýlastýkMý(matris, x, y)) 
		{
			JOptionPane.showMessageDialog(null, "Yandýn tekrar baþla! " ,"UYARI MESAJI", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
			

	}

	public int[][] getHarita() {
		return matris;
	}

	public void setHarita(int[][] harita) {

		dusman.clear();
		yukle(harita);

	}

	public void yonBelirle(int yon) {
		YON = yon;
	}

	public int getCikistaMi() {
		return cikistaMi;
	}

	public void setCikistaMi(int cikistaMi) {
		this.cikistaMi = cikistaMi;
	}

	private void normalHareket(int x, int y) {

		if (matris[y][x] == ZEMIN) {

			matris[karakter.getAdamY()][karakter.getAdamX()] = ZEMIN;

			matris[y][x] = ADAM;
			karakter.setAdamX(x);
			karakter.setAdamY(y);
		}

		else if (matris[y][x] == KUTU) {
			switch (YON) {

			case SAGA:
				if (matris[y][x+1] == ZEMIN) {

					matris[karakter.getAdamY()][karakter.getAdamX()] = ZEMIN;
					matris[y][x] = ADAM;
					karakter.setAdamX(x);
					karakter.setAdamY(y);
					matris[y][x + 1] = KUTU;

				}

				break;

			case SOLA:
				if (matris[y][x-1] == ZEMIN) {

					matris[karakter.getAdamY()][karakter.getAdamX()] = ZEMIN;
					matris[y][x] = ADAM;
					karakter.setAdamX(x);
					karakter.setAdamY(y);
					matris[y][x - 1] = KUTU;

				}

				break;

			case ASAGI:
				if (matris[y + 1][x] == ZEMIN) {

					matris[karakter.getAdamY()][karakter.getAdamX()] = ZEMIN;
					matris[y][x] = ADAM;
					karakter.setAdamX(x);
					karakter.setAdamY(y);
					matris[y + 1][x] = KUTU;
				}

				break;

			case YUKARI:
				if (matris[y - 1][x] == ZEMIN) {

					matris[karakter.getAdamY()][karakter.getAdamX()] = ZEMIN;
					matris[y][x] = ADAM;
					karakter.setAdamX(x);

					karakter.setAdamY(y);
					matris[y - 1][x] = KUTU;

				}

				break;
			}

		}
		if (matris[y][x] == YILDIZ) {

			matris[karakter.getAdamY()][karakter.getAdamX()] = ZEMIN;
			matris[y][x] = ADAM;
			karakter.setAdamX(x);

			karakter.setAdamY(y);

			yildizSayisi++;
		}

		if (matris[y][x] == CIKIS) {

			if (yildizSayisi == kacYildiz) {
				matris[karakter.getAdamY()][karakter.getAdamX()] = ZEMIN;
				matris[y][x] = ADAM;
				karakter.setAdamX(x);
				karakter.setAdamY(y);

				cikistaMi = 1;
				aktifSure = 0;
			}
			else
				JOptionPane.showMessageDialog(null, "Yýldýzlarýn hepsini topla! " ,"UYARI MESAJI", JOptionPane.INFORMATION_MESSAGE);
					
		}
		if (matris[y][x] == KOS) {

			matris[karakter.getAdamY()][karakter.getAdamX()] = ZEMIN;

			matris[y][x] = ADAM;
			karakter.setAdamX(x);
			karakter.setAdamY(y);
			aktifSure = 10;
			ozellik = new Kosu(matris, karakter);

		}
		if (matris[y][x] == GUCLEN) {

			matris[karakter.getAdamY()][karakter.getAdamX()] = ZEMIN;

			matris[y][x] = ADAM;
			karakter.setAdamX(x);
			karakter.setAdamY(y);
			aktifSure = 10;
			ozellik = new Guclen(matris, karakter);
		}
		if (matris[y][x] == KAYKAY) {

			matris[karakter.getAdamY()][karakter.getAdamX()] = ZEMIN;

			matris[y][x] = ADAM;
			karakter.setAdamX(x);
			karakter.setAdamY(y);
			aktifSure = 10;
			ozellik = new Kaykay(matris, karakter);
		}

	}

	private void Belir() {
		Random rnd = new Random();
		int y = rnd.nextInt(21);
		int x = rnd.nextInt(21);
		int ciz = rnd.nextInt(ozellikler.length);
		if (yerBul(matris, x, y) == -1 && ozellikAra(matris, ozellikler[ciz]) == -1 && birTane(matris) == false) {
			switch (ozellikler[ciz]) {
			case KOS:
				matris[y][x] = KOS;

				break;
			case GUCLEN:
				matris[y][x] = GUCLEN;

				break;
			case KAYKAY:
				matris[y][x] = KAYKAY;

				break;
			}
		}
	}

	private int ozellikAra(int[][] matris, int param) {
		int varsayilan = -1;

		for (int i = 0; i < matris.length; i++) {
			for (int y = 0; y < matris[0].length; y++) {
				if (param == matris[i][y]) {
					varsayilan = matris[i][y];
					return varsayilan;
				}
			}
		}

		return varsayilan;
	}

	private int yerBul(int[][] matris, int x, int y) {
		int varsayilan = -1;

		if (matris[y][x] != ZEMIN) {
			varsayilan = matris[y][x];
			return varsayilan;
		}

		return varsayilan;
	}

	private boolean birTane(int[][] matris) {
		boolean birTane = false;

		for (int y = 0; y < matris.length; y++) {
			for (int x = 0; x < matris[0].length; x++) {
				int hucre = matris[y][x];

				for (int ozellik : ozellikler) {
					if (hucre == ozellik) {
						birTane = true;
						return birTane;
					}
				}

			}
		}
		return birTane;
	}

	private boolean dusmanVarmý(int[][] matris) {
		boolean varMý = false;
		for (int satir = 0; satir < matris.length; satir++) {
			for (int sutun = 0; sutun < matris[0].length; sutun++) {
				if (matris[satir][sutun] == YATAYDUSMAN || matris[satir][sutun] == DÝKEYDUSMAN) {
					varMý = true;
					return varMý;
				}
			}
		}

		return varMý;
	}

	private boolean dusmanIleKarsýlastýkMý(int[][] matris, int x, int y) {
		boolean karsýlastýMý = false;

		switch (YON) {
		case YUKARI:
			for (int i = 0; i < dusman.size(); i++) {
				if (matris[y + 1][x] == matris[dusman.get(i).dusmanY][dusman.get(i).dusmanX]) {
					karsýlastýMý = true;
					return karsýlastýMý;
				}

			}
			break;

		case ASAGI:
			for (int i = 0; i < dusman.size(); i++) {
				if (matris[y - 1][x] == matris[dusman.get(i).dusmanY][dusman.get(i).dusmanX]) {
					karsýlastýMý = true;
					return karsýlastýMý;
				}

			}
			break;
		case SAGA:
			for (int i = 0; i < dusman.size(); i++) {
				if (matris[y][x - 1] == matris[dusman.get(i).dusmanY][dusman.get(i).dusmanX]) {
					karsýlastýMý = true;
					return karsýlastýMý;
				}

			}
			break;
		case SOLA:
			for (int i = 0; i < dusman.size(); i++) {
				if (matris[y][x + 1] == matris[dusman.get(i).dusmanY][dusman.get(i).dusmanX]) {
					karsýlastýMý = true;
					return karsýlastýMý;
				}

			}
			break;
		}

		return karsýlastýMý;

	}

	private void zeminYap(int[][] matris) {

		for (int y = 0; y < matris.length; y++) {
			for (int x = 0; x < matris[0].length; x++) {
				int hucre = matris[y][x];

				for (int ozellik : ozellikler) {
					if (hucre == ozellik) {
						matris[y][x] = ZEMIN;

					}
				}
			}
		}

	}

}
