package br.ufc.quixada.eda.Grafo;

public class Grafo {
	private int q_vert;
	private int q_arest;
	private Aresta aresta [];
	private ListaAdjacencia adj[];
	
	public Grafo(int a, int b) {
		this.q_vert = a;
		this.q_arest = b;
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
	
	public void add(Aresta a) {
		aresta[aresta.length] = a;
	}
	
	public void quickSort(int i, int j) {
		if(i < j) {
			int k = particiona(i, j);
			quickSort(i, k - 1);
			quickSort(k + 1, j);
		}
	}
	
	private int particiona(int i, int j) {
		int pivo = j;
		int q = i - 1;
		for(int k = i; k < j; k++) {
			if(aresta[k].getPeso() < aresta[pivo].getPeso()) {
				q++;
				Aresta aux = aresta[k];
				aresta[k] = aresta[q];
				aresta[q] = aux;
			}
		}
		
		Aresta aux = aresta[q + 1];
		aresta[q + 1] = aresta[j];
		aresta[j] = aux;
		return q + 1;
	}
	
	public ListaAdjacencia[] getAdj() {
		return adj;
	}
	
	public void setAdj(ListaAdjacencia[] adj) {
		this.adj = adj;
	}
	
	
}
