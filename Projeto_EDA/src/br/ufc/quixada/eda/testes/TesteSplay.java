package br.ufc.quixada.eda.testes;

import br.ufc.quixada.eda.splay.Splay;

public class TesteSplay {
	public static void main(String[] args) {
		Splay<Integer> splay = new Splay<Integer>(0, null);
		splay.inserir(3, 56);
		splay.inserir(7, 21);
		splay.inserir(6, 18);
		splay.inserir(1, 100);
		splay.show();
		splay.limpa();
		splay.show();
	}
}
