package br.ufc.quixada.eda.Algoritmos;

import br.ufc.quixada.eda.Grafo.Aresta;
import br.ufc.quixada.eda.Grafo.Grafo;
import br.ufc.quixada.eda.Grafo.ListaAdjacencia;
import br.ufc.quixada.eda.listaprioridades.HeapMaximo;
import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class Dijkstra {
	private int origem;
	private int ant[] = null;
	
	public void executar(Grafo g) {
		//inicializacao Integer.MAX_VALUE
		
		HeapMinimo Q = new HeapMinimo(g.getQ_vert());
		Q.contruir(null);
		
		while(!Q.vazio()) {
			int u = Q.remove();
			ListaAdjacencia adj = g.getAdj()[u];
			adj.inicializarIterator();
			while(adj.hasNext()) {
				Aresta a = adj.next();
				int v = (a.getU() == u ? a.getV() : a.getU());
				
				//relaxamento (u, v)
			}
		}
	}
}
