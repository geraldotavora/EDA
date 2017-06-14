package br.ufc.quixada.eda.testes;

import br.ufc.quixada.eda.rubronegra.RubroNegra;

public class TesteRubroNegra {
	public static void main(String[] args) {
		RubroNegra<String> a = new RubroNegra(30, null);
		a.add(30, "jesus");
		a.add(10, "geraldo" );
		a.add(40, "cecilia");
		a.add(5, "maria");
		a.add(15, "jose");
		a.add(50, "joao");
		a.add(25, "mavia");
		a.add(20, "pedro");
		a.show();
		
	}
}
