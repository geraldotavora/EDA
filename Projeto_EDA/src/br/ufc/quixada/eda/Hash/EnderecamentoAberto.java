package br.ufc.quixada.eda.Hash;

import java.util.Arrays;

public class EnderecamentoAberto<T> extends Hash<T> {
	private boolean removido;
	private NoHash<T> tabela[];
	
	public EnderecamentoAberto(Integer tamanho) {
		super(tamanho);
		this.tabela = new NoHash[this.m + 1];
		for(int i = 0; i < this.m + 1; i++) {
		this.tabela[i] = null;
		}
		// TODO Auto-generated constructor stub
	}
	
	public Integer fHash(Integer chave) {
		return (chave % this.m);
	}
	
	public Integer fHashAberto(Integer chave) {
		int inicio = this.fHash(chave);
		int ind = inicio;
		int i = 0;
		while(this.tabela[ind] != null && !chave.equals(this.tabela[ind].getChave()) && i < this.m) {
			ind = (inicio + (++i) % this.m);
		}
		if(this.tabela[ind] != null && chave.equals(this.tabela[ind].getChave())) {
			return ind;
		}
		return this.m;
	}
	
	@Override
	public void inserir(Integer chave, T valor) throws ExcecaoEnd {
		if(this.buscar(chave) == null) {
			int inicio = this.fHash(chave);
			int indice = inicio;
			int i = 0;
			while(this.tabela[indice] != null && !this.tabela[indice].isRemovido() && i < this.m) {
				indice = (inicio + (++i)) % this.m;
			}
			if(i < this.m ) {
				this.tabela[indice] = new NoHash<T>(chave, valor);
			}else {
				System.out.println("tabela cheia");
			}
			
		}else {
			throw new ExcecaoEnd("reg já presente");
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public T buscar(Integer chave) {
		int indice = this.fHashAberto(chave);
		if (indice < this.m) {
			return this.tabela[indice].getValor();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remover(Integer chave) {
		int i = this.fHashAberto(chave);
		if(i < this.m) {
			this.tabela[i].setRemovido(true);
			this.tabela[i].setChave(null);
		}else {
			System.out.println("valor nao presente");
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	public void imprimir() {
		try {
		for(int i = 0; i < this.m + 1; i++) {
			if(tabela[i] != null) {
				System.out.println("[" + i + "]" + "\tChave: " + tabela[i].getChave() + "\t\t -> " + this.tabela[i].getValor() + "\t\tRemovido: "+ this.tabela[i].isRemovido());
		}
		}
		System.out.println("\n");
		}catch (RuntimeException e) {
			System.err.println(e.getMessage());
			// TODO: handle exception
		}
	}

	@Override
	public String toString() {
		return "EnderecamentoAberto [removido=" + removido + ", tabela=" + Arrays.toString(tabela) + "]";
	}
	
	
	
}
