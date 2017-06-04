package br.ufc.quixada.eda.avl;

public class NoAvl {
	private int altura;
	private int chave;
	private NoAvl esq = null;
	private NoAvl dir = null;
	
	public NoAvl(int chave) {
		this.chave = chave;
		this.esq = null;
		this.dir = null;
		this.altura = 0;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public NoAvl getEsq() {
		return esq;
	}

	public void setEsq(NoAvl esq) {
		this.esq = esq;
	}

	public NoAvl getDir() {
		return dir;
	}

	public void setDir(NoAvl dir) {
		this.dir = dir;
	}
	
	
}
