package br.ufc.quixada.eda.conjuntosdisjuntos;

public class ConjDisjunto {
	private Node p [] = null;
	private int ref [] = null;
	private int nMax = 0;
	
	public ConjDisjunto(int nMax) {
		this.nMax = nMax;
		this.p = new Node[nMax];
		this.ref = new int[nMax];
	}
	
	public int findSet(int x) {
		if(this.p[x].getValor() == x) {
			return x;
		}
		this.p[x].setValor(findSet(this.p[x].getValor()));
		return this.p[x].getValor();
	}
	
	public void makeSet(int x) {
		this.p[x].setValor(x);
		this.ref[x] = 0;
	}
	
	public void link(int x, int y) {
		if(this.ref[x] < this.ref[y]) {
			this.p[x].setValor(y);
		}else {
			if(this.ref[x] == this.ref[y]) {
				this.ref[x]++;
			}
			this.p[y].setValor(x);
		}
	}
	
	public void union(int x, int y) {
		link(findSet(x), findSet(y));
	}
}
