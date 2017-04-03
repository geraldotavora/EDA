package br.ufc.quixada.eda.conjuntosdisjuntos;

public class Node {
	private int valor = 0;
	private Node prox;
	private int rep;
	
	public Node() {
		
	}
	public Node (int valor, Node prox, int representante) {
		this.valor = valor;
		this.prox = prox;
		this.rep = representante;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Node getProx() {
		return prox;
	}
	public void setProx(Node prox) {
		this.prox = prox;
	}
	public int getRep() {
		return rep;
	}
	public void setRep(int rep) {
		this.rep = rep;
	}
	
	
}
