package br.ufc.quixada.eda.Hash;

public class HashLinear<T> extends Hash<T> {
	private NoHash<T> tabela[];
	
	public HashLinear(Integer tamanho) {
		super(tamanho);
		tabela = new NoHash[this.m];
		// TODO Auto-generated constructor stub
	}
	
	private Integer fHash(int chave) {
		return (chave % this.m);
	}
	
	private Integer fHLinear(int chave, int k) {
		return ((fHash(chave) + k) % this.m);
	}

	@Override
	public void inserir(Integer chave, T valor) throws ExcecaoEnd {
		for(int k = 0; k < this.m; k++){
			if(tabela[fHLinear(chave, k)] == null) {
				tabela[fHLinear(chave, k)] = new NoHash<>(chave, valor);
				return;
			}
		}
	}

	@Override
	public T buscar(Integer chave) {
		for(int k = 0; k < this.m; k++) {
			if(tabela[fHLinear(chave, k)].getChave() == chave) {
				return tabela[fHLinear(chave, k)].getValor();
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remover(Integer chave) {
		for(int k = 0; k < this.m; k++) {
			if(tabela[fHLinear(chave, k)].getChave() == chave) {
				T aux = tabela[fHLinear(chave, k)].getValor();
				tabela[fHLinear(chave, k)].setChave(null);
				tabela[fHLinear(chave, k)].setValor(null);
				return aux;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	public void imprimir() {
		for(int i = 0; i < this.m; i++) {
			if(tabela[i] != null) {
				System.out.println(tabela[i].getChave());
			}else {
				System.out.println("[]");
			}
		}
	}
}
