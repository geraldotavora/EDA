package br.ufc.quixada.eda.Algoritmos;


import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.Grafo.Aresta;
import br.ufc.quixada.eda.Grafo.Grafo;
import br.ufc.quixada.eda.conjuntosdisjuntos.ConjDisjunto;
import br.ufc.quixada.eda.util.EDAUtil;

public class ArvoreGeradoraMinima {

	public List<Aresta> Kruskal(Grafo g){
		List<Aresta> solucao = new ArrayList<>();
		ConjDisjunto conj = new ConjDisjunto(g.getQtd_vertices());
		
		for(int i = 0; i < g.getQtd_vertices(); i++){
			conj.make_set(i);
		}
		
		EDAUtil.quickSort(g.getArestas(), 0, g.getQtd_arestas());
		
		for(int i = 0; i < g.getQtd_vertices(); i++){
			Aresta a = g.getArestas()[i];
			if(conj.find_set(a.getV()) != conj.find_set(a.getU())){
				solucao.add(a);
				conj.union(a.getV(), a.getU());
			}
		}
		return solucao;		
	}
}

