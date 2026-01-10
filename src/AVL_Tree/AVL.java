package AVL_Tree;


public class AVL {
	
	int deger;
	int boy; //Avl nin BST'den farkı
	AVL sag;
	AVL sol;
	
	AVL(int deger){
		this.deger=deger;
		boy=1;

		sag=null;
		sol=null;
	}
	
	void araGezinti() {
		
		if(sol!=null)
			sol.araGezinti();
		System.out.println(deger +" -- " +this.boy);
		if(sag!=null)
			sag.araGezinti();
	
	}
	void onGezinti() {
		
		System.out.println(deger);
		if(sol!=null)
			sol.araGezinti();
		
		if(sag!=null)
			sag.araGezinti();
	
	}
	void sonraGezinti() {
		
		
		if(sol!=null)
			sol.araGezinti();
		
		if(sag!=null)
			sag.araGezinti();
		System.out.println(deger);
	
	}
	AVL ekle(AVL root, int yeni) {
		//BST Ekleme yöntemiyle yeni eleman ekleme aynen yapılır
		if(yeni>deger) {
			if(sag!=null) {
				sag.ekle(root, yeni);
			}else {
				sag=new AVL(yeni);
			}
		}else {
			if(sol!=null) {
				sol.ekle(root, yeni);
			}else {
				sol=new AVL(yeni);
			}
		}
		//DÖNÜŞLER BAŞLIYOR
		//1- boyları güncelle
		
		this.boy= maks(this.boy(sag), this.boy(sol)) + 1;
		
		//denge hesaplamasını yap
		int denge = denge(boy(sag), boy(sol));
		
		// Eğer dengesizlik varsa rotasyon tipini belirle
		if((denge==2)&&(sag.sag!=null)) {
			System.out.println("sag sağ dengesizlik var");
			// Tek Sol Rotasyon yap
			return solaDondur(this);
			
		}else if((denge==2)&&(sag.sol!=null)) {
			System.out.println("sag SOL dengesizlik var");
			// Çift Sağ - Sol Rotasyon yap
			return sagSolDondur(this);
			
		}else if((denge==-2)&&(sol.sol!=null)) {
			System.out.println("sol sol dengesizlik var");
			// Tek SAĞ Rotasyon yap
			return sagaDondur(this);
			
		}else if((denge==-2)&&(sol.sag!=null)) {
			System.out.println("sol SAG dengesizlik var");
			// Çift Sol - Sag Rotasyon yap
			return solSagDondur(this);
			
		}
		
		
			
		return root;
	}
	
	int denge(int sagboy, int solboy){
		return sagboy-solboy;
	}
	
	int maks(int sagboy, int solboy){
		if(sagboy>solboy)
			return sagboy;
		else
			return solboy;
	}
	int boy(AVL dugum){
		if(dugum==null)
			return 0;
		return dugum.boy;
	}
	
	AVL solaDondur(AVL dugum) {
		AVL T=dugum.sag;
		T.sol=dugum;
		dugum.sag=null;
		
		//yerleri değişen düğümlerin Boylarını güncelle
		dugum.boy=maks(dugum.boy(dugum.sag), dugum.boy(dugum.sol)) + 1;
		T.boy=maks(T.boy(T.sag), T.boy(T.sol)) + 1;
		return T;
	}
	
	AVL sagaDondur(AVL dugum) {
		AVL T=dugum.sol;
		T.sag=dugum;
		dugum.sol=null;
		
		//yerleri değişen T ve dugum AVL düğümlerin Boylarını güncelle
		dugum.boy=maks(dugum.boy(dugum.sag), dugum.boy(dugum.sol)) + 1;
		T.boy=maks(T.boy(T.sag), T.boy(T.sol)) + 1;
		return T;
	}
	
	AVL sagSolDondur(AVL dugum) {
		AVL T=dugum.sag;
		dugum.sag=sagaDondur(T);
		AVL Y =solaDondur(dugum);
		
		//yerleri değişen düğümlerin Boylarını güncelle
		dugum.boy=maks(dugum.boy(dugum.sag), dugum.boy(dugum.sol)) + 1;
		T.boy=maks(T.boy(T.sag), T.boy(T.sol)) + 1;
		Y.boy=maks(Y.boy(Y.sag), Y.boy(Y.sol)) + 1;
		return Y;
	}
	
	AVL solSagDondur(AVL dugum) {
		AVL T=dugum.sol;
		dugum.sol=solaDondur(T);
		AVL Y =sagaDondur(dugum);
		
		//yerleri değişen düğümlerin Boylarını güncelle
		dugum.boy=maks(dugum.boy(dugum.sag), dugum.boy(dugum.sol)) + 1;
		T.boy=maks(T.boy(T.sag), T.boy(T.sol)) + 1;
		Y.boy=maks(Y.boy(Y.sag), Y.boy(Y.sol)) + 1;
		return Y;
	}
}
