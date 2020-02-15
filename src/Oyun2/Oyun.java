package Oyun2;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

public class Oyun extends JFrame implements KeyListener {
	private Labirent labirent;

	private Bolumler bolum;

	private String[] bolumler = { "Harita.txt", "Harita2.txt" };
	private int iter = 1;

	private int[][] harita;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Oyun init = new Oyun();
					init.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public Oyun() {
		super("Maze Game");
		addKeyListener(this);
		setSize(730, 730);
		bolum = new Bolumler();
		if (denetle()) {
			harita = bolum.haritaGetir("Kaydedilen.txt");
			labirent = new Labirent(harita);
		}

		else {
			harita = bolum.haritaGetir(bolumler[iter]);
			labirent = new Labirent(harita);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			labirent.yonBelirle(Labirent.YUKARI);
			labirent.adaminYeriniGuncelle(labirent.getAdamX(), labirent.getAdamY() - 1);
			harita = labirent.getHarita();

			bittiMi();
			break;
		case KeyEvent.VK_DOWN:
			labirent.yonBelirle(Labirent.ASAGI);
			labirent.adaminYeriniGuncelle(labirent.getAdamX(), labirent.getAdamY() + 1);
			harita = labirent.getHarita();

			bittiMi();
			break;
		case KeyEvent.VK_RIGHT:
			labirent.yonBelirle(Labirent.SAGA);
			labirent.adaminYeriniGuncelle(labirent.getAdamX() + 1, labirent.getAdamY());
			harita = labirent.getHarita();

			bittiMi();
			break;
		case KeyEvent.VK_LEFT:
			labirent.yonBelirle(Labirent.SOLA);
			labirent.adaminYeriniGuncelle(labirent.getAdamX() - 1, labirent.getAdamY());
			harita = labirent.getHarita();

			bittiMi();
			break;
		case KeyEvent.VK_K:
			JOptionPane.showMessageDialog(this, "Oyunu kaydettiniz. ", "Bigi Mesajý", JOptionPane.INFORMATION_MESSAGE);
			bolum.haritaKaydet(harita, "Kaydedilen.txt");
		}

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.translate(50, 50);

		for (int row = 0; row < harita.length; row++) {
			for (int col = 0; col < harita[0].length; col++) {
				Image image;
				ImageIcon resim;
				resim = new ImageIcon("Resimler//Zemin.png");
				image = resim.getImage();
				g.drawImage(image, col * 30, row * 30, null);

				switch (harita[row][col]) {
				case 1:

					resim = new ImageIcon("Resimler//Zemin.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);

					break;
				case 4:
					resim = new ImageIcon("Resimler//Cikis.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);
					break;
				case 2:
					resim = new ImageIcon("Resimler//Duvar.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);
					break;
				case 3:
					resim = new ImageIcon("Resimler//Karakterr.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);
					break;
				case 5:
					resim = new ImageIcon("Resimler//Yildiz.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);
					break;
				case 6:
					resim = new ImageIcon("Resimler//Kutu.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);
					break;
				case 7:
					resim = new ImageIcon("Resimler//Kosma.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);
					break;
				case 8:
					resim = new ImageIcon("Resimler//Guclen.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);
					break;
				case 9:
					resim = new ImageIcon("Resimler//Kaykay.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);
					break;

				case 10:
					resim = new ImageIcon("Resimler//Dusman.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);
					break;
				case 11:
					resim = new ImageIcon("Resimler//Dusman.png");
					image = resim.getImage();
					g.drawImage(image, col * 30, row * 30, null);
					break;

				default:

					break;

				}

			}

		}

	}

	private void bittiMi() {

		if (labirent.getCikistaMi() == 1) {
			
			iter++;

			if (iter < bolumler.length) {
				JOptionPane.showMessageDialog(this, "Tebrikler bir sonraki bölüme geçtiniz! ", "Tebrik Mesajý",
						JOptionPane.INFORMATION_MESSAGE);
				harita = bolum.haritaGetir(bolumler[iter]);
				labirent.setHarita(harita);
				labirent.setCikistaMi(0);

			} else
				{
				JOptionPane.showMessageDialog(this, "Tebrikler oyunu bitirdiniz! ", "Tebrik Mesajý",
						JOptionPane.INFORMATION_MESSAGE);
				   System.exit(0);
				}

		}
	}

	private boolean denetle() {
		boolean varsayilan = false;
		String s = JOptionPane.showInputDialog(
				"Kaydettiðiniz yerden mi baþlamak istiyorsanýz 1 e basýn.(Ýstemiyorsanýz 1 dýþýnda herhangi bir þeye basýn.)");

		JOptionPane.showMessageDialog(this, "Oyun sýrasýnda kaydetmek isterseniz K tuþuna basýnýz! ", "Tebrik Mesajý",
				JOptionPane.INFORMATION_MESSAGE);
		if (s.equals("1")) {
			varsayilan = true;
			return varsayilan;
		}

		return varsayilan;

	}

}
