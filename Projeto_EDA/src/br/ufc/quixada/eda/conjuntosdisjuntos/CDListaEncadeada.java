package br.ufc.quixada.eda.conjuntosdisjuntos;

public class CDListaEncadeada {
	private Node head;
	private int n;
	
	public Node Criar(){
		this.head = null;
		this.n = 0;	
		return head;
	}
	
	public Node Novo(int x) {
		Node no = new Node();
		no.setValor(x);
		no.setProx(null);
		no.setRep(x);
		return no;
	}
	
	public void InserirInicio(int valor) {
		Node node = Novo(valor);
		node.setProx(this.head);
		this.head = node;
		this.n++;
	}
	
	public void InserirFim(int valor) {
		if(this.n == 0) {
			InserirInicio(valor);
		}else {
			Node p = head;
			while(p.getProx() != null) {
				p = p.getProx();
			}
			p.setProx(Novo(valor));
			n++;
		}
	}
	
	public Node Buscar(int valor) {
		Node p = this.head;
		if(p == null || p.getValor() == valor) {
			return null;
		}
		while(p.getProx() != null) {
			Node aux = new Node();
			aux.setValor(p.getProx().getValor());
			
			if((aux.getValor() == valor) || (aux.getValor() >= valor)){
				break;
			}
			p = p.getProx();
		}
		return p;
	}
	
	public boolean Remove(int valor) {
		Node p = Buscar(valor);
		if(p == null) {
			if(head != null) {
				Node q = head;
				head = q.getProx();
			}else {
				return false;
			}
		}else {
			Node q = p.getProx();
			p.setProx(q.getProx());
		}
		return true;
	}
	
	public void Destruir() {
		while(head != null) {
			head = head.getProx();
		}
		n = 0;
	}

	public Node getHead() {
		return head;
	}


	public int getN() {
		return n;
	}	
	
}
