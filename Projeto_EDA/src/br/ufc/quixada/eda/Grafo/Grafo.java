package br.ufc.quixada.eda.Grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private int q_vert = 0;
	private int q_arest = 0;
	private Aresta aresta [] = null;
	//private List<Aresta> l_aresta = new ArrayList<Aresta>();
	
	public Grafo(int q_vert, int q_arest) {
		this.q_vert = q_vert;
		this.q_arest = q_arest;
		this.setAresta(new Aresta[q_arest]);;
		// TODO Auto-generated constructor stub
	}
	public Grafo() {
		// TODO Auto-generated constructor stub
	}
	public int getQ_vert() {
		return q_vert;
	}
	public void setQ_vert(int q_vert) {
		this.q_vert = q_vert;
	}
	public int getQ_arest() {
		return q_arest;
	}
	public void setQ_arest(int q_arest) {
		this.q_arest = q_arest;
	}
	public Aresta[] getAresta() {
		return aresta;
	}
	public void setAresta(Aresta[] aresta) {
		this.aresta = aresta;
	}
	
	
	
}
