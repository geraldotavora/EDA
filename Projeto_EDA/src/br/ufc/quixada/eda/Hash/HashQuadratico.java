package br.ufc.quixada.eda.Hash;

public class HashQuadratico<T> extends Hash<T> {
	private NoHash<T> tabela[];
	
	public HashQuadratico(Integer tamanho) {
		super(tamanho);
		tabela = new NoHash[this.m];
		// TODO Auto-generated constructor stub
	}
	
	private Integer fHash(int chave) {
		return (chave % this.m);
	}
	
	private Integer faux(int chave, int k) {
		return (fHash(chave) + k) % this.m;
	}
	
	private Integer fhquad(int chave, int k) {
		return (faux(chave, (k - 1)) + k) % this.m;
	}

	@Override
	public void inserir(Integer chave, T valor) throws ExcecaoEnd {
		if(tabela[fHash(chave)] == null) {
			tabela[fHash(chave)] = new NoHash<>(chave, valor);
		}else {
		for(int k = 1; k < this.m; k++){
			if(tabela[fhquad(chave, k)] == null) {
				tabela[fhquad(chave, k)] = new NoHash<>(chave, valor);
				return;
			}
			
		}
		}
		// TODO Auto-generated method stub
	}

	@Override
	public T buscar(Integer chave) {
		// TODO Auto-generated method stub
		if(tabela[fHash(chave)].getChave() == chave) {
			return tabela[fHash(chave)].getValor();
		}else {
		for(int k = 1; k < this.m; k++){
			if(tabela[fhquad(chave, k)].getChave() == chave) {
				return tabela[fhquad(chave, k)].getValor();			
			}
		}
		}
		return null;
	}

	@Override
	public T remover(Integer chave) {
		// TODO Auto-generated method stub
		if(tabela[fHash(chave)].getChave() == chave) {
			T aux = tabela[fHash(chave)].getValor();
			tabela[fHash(chave)].setChave(null);
			tabela[fHash(chave)].setValor(null);
			return aux;
		}else {
		for(int k = 1; k < this.m; k++){
			if(tabela[fhquad(chave, k)].getChave() == chave) {
				T aux = tabela[fhquad(chave, k)].getValor();
				tabela[fhquad(chave, k)].setChave(null);
				tabela[fhquad(chave, k)].setValor(null);
				return aux;
			}
			
		}
		}
		return null;
	}
	
	public void imprimir() {
		for(int i = 0; i < this.m; i++) {
			if(tabela[i] != null) {
				System.out.println(tabela[i].getChave() + " -> " + tabela[i].getValor());
			}
		}
	}
	
}
