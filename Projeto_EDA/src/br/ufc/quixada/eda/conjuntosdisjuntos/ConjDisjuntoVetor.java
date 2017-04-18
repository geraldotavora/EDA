package br.ufc.quixada.eda.conjuntosdisjuntos;

public class ConjDisjuntoVetor {
	private int pai[] = null;
	private int ordem[] = null;
	private int n;
	
	public ConjDisjuntoVetor(int n) {
		this.n = n;
		this.pai = new int[n + 1];
		this.ordem = new int[n + 1];
	}
	
	public void make_Set(int x) {
		this.pai[x] = x;
		this.ordem[x] = 0;
	}
	
	public void make_Set_Topper() {
		for(int i = 1; i <= n; i++) {
			make_Set(i);
		}
	}
	
	public int find_Set(int x) {
		if(x == this.pai[x]) {
			return x;
		}
		this.pai[x] = find_Set(this.pai[x]);
		return this.pai[x];
	}
	
	public int find_Set_Topper(int x) {
		if(x == this.pai[x]) {
			return x;
		}else {
			int paix = find_Set_Topper(pai[x]);
			pai[x] = paix;
			return paix;
		}
	}
	
	public void link_Set(int x, int y) {
		pai[x] = y;
	}
	
	public void link_Set_Topper(int x, int y) {
		if(this.ordem[x] < this.ordem[y]) {
			this.pai[x] = y;
		}else {
			if(this.ordem[x] == this.ordem[y]) {
				this.ordem[x]++;
			}
			this.pai[y] = x;
		}
	}
	
	public void union(int x, int y) {
		link_Set_Topper(find_Set_Topper(x), find_Set_Topper(y));
	}

	public int[] getPai() {
		return pai;
	}

	public void setPai(int[] pai) {
		this.pai = pai;
	}

	public int[] getOrdem() {
		return ordem;
	}

	public void setOrdem(int[] ordem) {
		this.ordem = ordem;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	

}
