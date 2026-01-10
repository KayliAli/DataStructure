package AVL_Tree;

import AVL_Tree.AVL_agaci;

public class AnaSinif {

	public static void main(String[] args) {
		AVL_agaci avl=new AVL_agaci();
		
		avl.ekle(19);
	
		avl.ekle(15);
		avl.ekle(17);
		
		
		avl.kok.araGezinti();
		System.out.println(avl.kok.deger);
		
	}

}
