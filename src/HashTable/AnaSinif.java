package HashTable;

public class AnaSinif {

	public static void main(String[] args) {
		KarmaBagliListe kbl=new KarmaBagliListe(7);
		Eleman kisi_1=new Eleman("Ali", 14);
		Eleman kisi_2=new Eleman("Ahmet", 15);
		Eleman kisi_3=new Eleman("Bekir", 21);
		kbl.ekleKarmaBagliListe(kisi_1);
		kbl.ekleKarmaBagliListe(kisi_2);
		kbl.ekleKarmaBagliListe(kisi_3);
		
		//System.out.println(kbl.ll[0].get(1).isim);
        kbl.print(1);

	}

}
