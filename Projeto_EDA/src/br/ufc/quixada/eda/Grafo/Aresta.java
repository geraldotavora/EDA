package br.ufc.quixada.eda.Grafo;

public class Aresta {
	private int u;
	private int v;
	private int peso;
	
	public Aresta(int u, int v, int peso) {
		this.u = u;
		this.v = v;
		this.peso = peso;
		// TODO Auto-generated constructor stub
	}
	public Aresta() {
		// TODO Auto-generated constructor stub
	}
	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
