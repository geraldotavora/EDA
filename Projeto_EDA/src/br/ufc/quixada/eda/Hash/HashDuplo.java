package br.ufc.quixada.eda.Hash;

public class HashDuplo<T> extends Hash<T>{
	private NoHash<T> tabela[];
	
	public HashDuplo(int tam){
		super(tam);
		tabela = new NoHash[this.m];
	}
	
	private Integer fhash(int chave) {
		return (chave % this.m);
	}
	
	private Integer fhash2(int chave) {
		return ((2 * chave) - 1) % this.m; 
	}
	
	private Integer fhduplo(int chave, int k) {
		return ((fhash(chave)) + k * (fhash2(chave))) % this.m;
	}

	@Override
	public void inserir(Integer chave, T valor) throws ExcecaoEnd {
		if(tabela[fhash(chave)] == null) {
			tabela[fhash(chave)] = new NoHash<>(chave, valor);
		}else {
			for(int k = 1; k < this.m; k++) {
				if(tabela[fhduplo(chave, k)] == null) {
					tabela[fhduplo(chave, k)] = new NoHash<>(chave, valor);
					return;
				}
			}
		}
	}

	@Override
	public T buscar(Integer chave) {
		if(tabela[fhash(chave)].getChave() == chave) {
			return tabela[fhash(chave)].getValor();
		}else {
			for(int k = 1; k < this.m; k++) {
				if(tabela[fhduplo(chave, k)] == null)return null;
				if(tabela[fhduplo(chave, k)].getChave() == chave) {
					return tabela[fhduplo(chave, k)].getValor();
				}
			}
		}
		return null;
	}

	@Override
	public T remover(Integer chave) {
		if(tabela[fhash(chave)].getChave() == chave) {
			T aux = tabela[fhash(chave)].getValor();
			tabela[fhash(chave)].setChave(null);
			tabela[fhash(chave)].setValor(null);
			return aux;
		}else {
			for(int k = 0; k < this.m; k++) {
				if(tabela[fhduplo(chave, k)].getChave() == chave) {
					T aux = tabela[fhduplo(chave, k)].getValor();
					tabela[fhduplo(chave, k)].setChave(null);
					tabela[fhduplo(chave, k)].setValor(null);
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
