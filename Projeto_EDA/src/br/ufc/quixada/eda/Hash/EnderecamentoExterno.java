package br.ufc.quixada.eda.Hash;

import java.util.LinkedList;
import java.util.List;

public class EnderecamentoExterno<T> extends Hash<T> {
	private List<T> tabela[] = null;
	private NoHash<T> hashaux = new NoHash<T>();
	
	public EnderecamentoExterno(Integer tam) {
		super(tam);
		tabela = new LinkedList[this.m + 1];
	}
	
	@Override
	public void inserir(Integer chave, T valor) throws ExcecaoEnd {
		// TODO Auto-generated method stub
		NoHash<T> hash = new NoHash<>();
		if(chave != null && valor != null) {
			if(this.tabela[fHash(chave)] == null) {
				this.tabela[fHash(chave)] = new LinkedList<>();
				hash.setChave(chave);
				hash.setValor(valor);
				this.tabela[fHash(chave)].add((T) hash);
			}else {
				hash.setChave(chave);
				hash.setValor(valor);
				this.tabela[fHash(chave)].add((T) hash);
			}
				
		}
	}

	@Override
	public T buscar(Integer chave) {
		// TODO Auto-generated method stub
		if(chave != null && this.tabela[fHash(chave)] != null) {
			int tam = this.tabela[fHash(chave)].size();
			for(int i = (tam - 1); i >= 0; i--) {
				this.hashaux = ((NoHash<T>) this.tabela[fHash(chave)].get(i));
				if(this.hashaux.getChave() == chave) {
					return (T) this.hashaux.getValor();
				}
			}
		}
		return null;
	}

	@Override
	public T remover(Integer chave) {
		// TODO Auto-generated method stub
		if(chave != null && this.tabela[fHash(chave)] != null) {
			T valor = null;
			int aux = this.tabela[fHash(chave)].size();
			if(aux == 1) {
				hashaux = ((NoHash<T>) this.tabela[fHash(chave)].get(0));
				valor = (T) hashaux.getValor();
				this.tabela[fHash(chave)] = null;
				return valor;
			}
			for(int i = (aux - 1); i >= 0; i--) {
				hashaux = ((NoHash<T>) this.tabela[fHash(chave)].get(i));
				if(hashaux.getChave() == chave) {
					valor = (T) hashaux.getValor();
					this.tabela[fHash(chave)].remove(i);
					return valor;
				}
			}
		}
		return null;
	} //<T extends Grafo> so herda o tipo da classe informada

	public void imprimir() {
		for(int i = 0; i < tabela.length; i++) {
			System.out.println(tabela[i]);
		}
	}
}