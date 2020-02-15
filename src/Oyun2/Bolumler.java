package Oyun2;

import java.io.*;
import java.util.Vector;

public class Bolumler 
{
	private int [][] harita = new int [21][21];
	private Vector<String> haritalar = new Vector<String>();
	private int k = 0;

	
	public int[][] haritaGetir(String fileName) {
		try {
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			String oku;
			while ((oku = in.readLine()) != null) 
			{
				
				String dizi [] = oku.split(" ");
				for (String sayilar : dizi) 
				{
					haritalar.add(sayilar);
				}
				
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int satir= 0; satir<21;satir++) 
		{
			for(int sutun = 0; sutun<21;sutun++) 
			{
				if(k<haritalar.size()) 
				{
				harita[satir][sutun]=Integer.parseInt(haritalar.get(k));
				k++;	
				
				}
			}
		}
		return harita;
      
	}
    
	public void haritaKaydet(int [][] harita,String fileName) 
	{
		try {
			File file = new File(fileName);
			FileWriter wr = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(wr);
			
			for(int satir = 0; satir<harita.length;satir++) 
			{
				for(int sutun = 0; sutun<harita[0].length;sutun++) 
				{
					bw.write(Integer.toString(harita[satir][sutun]) +" ");
				}
				bw.newLine();
				
			}
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}
