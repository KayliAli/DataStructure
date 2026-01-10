package MinHeapTree;

public class MinHeap {
	
	int dizi[];
	int diziSonu;
	
	MinHeap(int N){
		dizi=new int[N];
		diziSonu=0;
	}
	//<>
	int ebeveyn(int cocuk){
		return (cocuk-1)/2;
	}
	int sagCocuk(int ebeveyn) {
		return 2*ebeveyn+2;
	}
	int solCocuk(int ebeveyn) {
		return 2*ebeveyn+1;
	}
	void yerDegistir(int cocukIndex, int ebeveynIndex) {
		int yedek= dizi[cocukIndex];
		dizi[cocukIndex]=dizi[ebeveynIndex];
		dizi[ebeveynIndex]=yedek;
	}
	boolean ekle(int yeni){
		//heap doluysa çık
		if(diziSonu>=dizi.length)
			return false;
		
		dizi[diziSonu]=yeni;
		int i=diziSonu;
		diziSonu++;
		
		while(i > 0 ) {
			
			if(dizi[i] < dizi[ebeveyn(i)]) {// yer değiştir
				yerDegistir(i, ebeveyn(i));
			
			}
			i = ebeveyn(i);
		}
		
		return true;
		
	}
	
	void heapYazdir(){
		for(int i: dizi) {
			System.out.println(i);
		}
		System.out.println("------------------");
	}
	
	int heapCek() {
	
		if(diziSonu == 0)
			return -1;
		
		if(diziSonu==1) {// dizide sadece bir eleman varsa 
			
			return dizi[--diziSonu];
		}
		//koku çekiyor son eklenen elemanı koku yukluyor
		int ydk=dizi[0];
		dizi[0]=dizi[diziSonu];
		diziSonu--;
		
		//Heapfy (heapleştirme) işlemini başlat
		heapify(0);
		return ydk;
		
	}
	//istenen bir düğümü aşağı doğru hipleştirme 
	void heapify(int kok) {
		int sag=sagCocuk(kok);
		int sol=solCocuk(kok);
		
		int enKucuk = kok;
		//sağ ve sol çosuklar içinde ebeveynden küçük değerlisini bul ve 
		//en küşük indeks olarak onu işaretle 
		if(dizi[sag] < dizi[enKucuk]) {
			enKucuk=sag;
		}if(dizi[sol]< dizi[enKucuk]) {
			enKucuk=sol;
		}
		//en küşük değeri kok dışında bir değer olduysa 
		//ozaman swap işlemi yapılmalıdır
		
		if(enKucuk != kok) {
			yerDegistir(kok, enKucuk);
			heapify(enKucuk);
		}
	}

}
