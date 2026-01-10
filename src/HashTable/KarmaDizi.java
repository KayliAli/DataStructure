package HashTable;

public class KarmaDizi {
	
	int dizi[];
	
	KarmaDizi(int N){
		dizi=new int[N];
		
	}
	
	void karmaEkle(int yeni) {
		dizi[karmaFonksiyon(yeni)]=yeni;
	}
	
	int karmaFonksiyon(int sayi) {
		return sayi % dizi.length;
	}
	//<>
	int karmaAra(int aranan) {
		int index=karmaFonksiyon(aranan);
		return index;
	}
	void diziYazdir() {
		for(int i=0;i<dizi.length;i++) {
			System.out.println( i+ " . " +dizi[i]);
		}
		System.out.println( "--*-----*----*");
	}

}
