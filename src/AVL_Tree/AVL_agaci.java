package AVL_Tree;

public class AVL_agaci {
	AVL kok;
	
	AVL_agaci(){
		kok=null;
	}
	
	void ekle(int yeni) {
		if(kok==null) {
			kok=new AVL(yeni);
			return;
		}
		kok=kok.ekle(kok, yeni);
		
	}
}
