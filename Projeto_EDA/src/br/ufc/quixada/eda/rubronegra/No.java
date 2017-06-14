package br.ufc.quixada.eda.rubronegra;

public class No<T> {
	private int chave;
	private No dir = null;
	private No esq = null;
	private boolean cor;
	private static final boolean preta = true;
	private static final boolean vermelha = false;
	private T info;
	
	public No(int chave, T info) {
		this.chave = chave;
		this.info = info;
		
	}
	
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public No getDir() {
		return dir;
	}
	public void setDir(No dir) {
		this.dir = dir;
	}
	public No getEsq() {
		return esq;
	}
	public void setEsq(No esq) {
		this.esq = esq;
	}
	public boolean isCor() {
		return cor;
	}
	public void setCor(boolean cor) {
		this.cor = cor;
	}
	public static boolean isPreta() {
		return preta;
	}
	public static boolean isVermelha() {
		return vermelha;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	
}
