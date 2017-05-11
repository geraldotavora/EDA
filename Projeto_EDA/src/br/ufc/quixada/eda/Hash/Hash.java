package br.ufc.quixada.eda.Hash;

public abstract class Hash<T> {
	protected Integer m = 0;
	
	public Hash(Integer tamanho) {
		this.m = tamanho;
	}
	
	protected Integer fHash(Integer chave) {
		return (chave % m);
	}
	
	public abstract void inserir(Integer chave, T valor) throws ExcecaoEnd;
		
	public abstract T buscar(Integer chave);
	
	public abstract T remover(Integer chave);
	
	
}
