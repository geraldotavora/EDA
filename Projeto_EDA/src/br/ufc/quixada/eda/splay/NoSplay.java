package br.ufc.quixada.eda.splay;

public class NoSplay<T> {
	private int chave;
	private T valor;
	private NoSplay<T> esq = null;
	private NoSplay<T> dir = null;
	
	public NoSplay(int chave, T valor){
		this.chave = chave;
		this.valor = valor;
		this.esq = null;
		this.dir = null;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public NoSplay<T> getEsq() {
		return esq;
	}

	public void setEsq(NoSplay<T> esq) {
		this.esq = esq;
	}

	public NoSplay<T> getDir() {
		return dir;
	}

	public void setDir(NoSplay<T> dir) {
		this.dir = dir;
	}
	
	
}
