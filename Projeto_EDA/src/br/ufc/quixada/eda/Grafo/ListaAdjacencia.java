package br.ufc.quixada.eda.Grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaAdjacencia implements Iterator<Aresta>{
	private List<Aresta> lista = null;
	private int posicao = 0;
	
	public ListaAdjacencia() {
		lista = new ArrayList<Aresta>();
	}
	
	public void add(Aresta a) {
		lista.add(a);
	}
	
	public void inicializarIterator() {
		posicao = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return (posicao < lista.size());
	}

	@Override
	public Aresta next() {
		// TODO Auto-generated method stub
		Aresta aa = lista.get(posicao);
		posicao++;
		return aa;
	}

}
