package br.ufc.quixada.eda.testes;

import br.ufc.quixada.eda.avl.AVL;
import br.ufc.quixada.eda.avl.NoAvl;

public class TesteAVL {
	public static void main(String[] args) {
		AVL a = new AVL();
		AVL b = new AVL();
		AVL c = new AVL();
		
		a.inserirChave(5);
		a.inserirChave(10);
		a.inserirChave(4);
		a.inserirChave(2);
		a.show();
		System.out.println();
		
		b.inserirChave(5);
		b.inserirChave(10);
		b.inserirChave(4);
		b.inserirChave(2);
		b.inserirChave(1);
		b.inserirChave(3);
		b.inserirChave(6);
		b.inserirChave(8);
		b.show();
		System.out.println();
		
		c.inserirChave(5);
		c.inserirChave(10);
		c.inserirChave(4);
		c.inserirChave(2);
		c.inserirChave(1);
		c.inserirChave(3);
		c.inserirChave(6);
		c.inserirChave(8);
		c.inserirChave(9);
		c.inserirChave(11);
		c.inserirChave(7);
		c.inserirChave(12);
		c.show();
	}
}
