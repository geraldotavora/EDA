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
		
		g.quickSort(0, g.getAresta().length - 1);
		
		for(int i = 0; i < g.getQ_vert(); i++) {
			Aresta a[] = g.getAresta();
			if(conj.find_Set_Topper(a[i].getV()) != conj.find_Set_Topper(a[i].getU())) {
				solucao.add(a[i]);
				conj.union(a[i].getV(), a[i].getU());
			}
		}
		return solucao;	
	}
	
	public double getCustoArvore(List<Aresta> solucao) {
		double custo = 0;
		for(Aresta aresta : solucao) {
			custo += aresta.getPeso();
		}
		return custo;
	}
}
