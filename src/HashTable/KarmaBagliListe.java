package HashTable;

import java.util.LinkedList;

public class KarmaBagliListe {
	LinkedList<Eleman>[] ll;
	
	KarmaBagliListe(int N){
		ll=new LinkedList[N];
		for(int i=0;i<ll.length;i++) {
			ll[i]=new LinkedList();
		}
	}
	
	void ekleKarmaBagliListe(Eleman yeni){
		int index=karmaFonksiyon(yeni);
		
		ll[index].addLast(yeni);
		
	}
	
	int karmaFonksiyon(Eleman yeni) {
		return yeni.dt % ll.length;
	}

    void print(int index){
        if(index>ll.length-1){
            System.out.println("index out of bound");
            return;
        }
        for (int i=0;i<ll[index].size();i++){
            System.out.print(ll[index].get(i).isim+"-");
        }
    }
	

}
