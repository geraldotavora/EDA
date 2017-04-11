package br.ufc.quixada.eda.Algoritmos;
import br.ufc.quixada.eda.Grafo.Aresta;
import br.ufc.quixada.eda.Grafo.Grafo;
import br.ufc.quixada.eda.conjuntosdisjuntos.ConjDisjuntoVetor;
import br.ufc.quixada.eda.util.EDAUtil;

import java.util.ArrayList;
import java.util.List;

public class ArvoreGeradoraMinima{
	private int vetor[];
	
	public List<Aresta> kruskal(Grafo g){
		List<Aresta> solucao = new ArrayList<Aresta>();
		ConjDisjuntoVetor conj = new ConjDisjuntoVetor(g.getQ_vert());
		for(int i = 0; i < g.getQ_vert(); i++) {
			conj.make_Set(i);
		}
		
		EDAUtil.quickSort(g.getAresta(), 0, g.getQ_arest());
		
		for(int i = 0; i < g.getQ_vert(); i++) {
			Aresta a = g.getAresta()[i];
			if(conj.find_Set(a.getV()) != conj.find_Set(a.getU())) {
				solucao.add(a);
				conj.union(a.getV(), a.getU());
			}
		}
		return solucao;	
	}
}
