package br.ufc.quixada.eda.listaprioridades;


/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */
public class HeapMinimo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int id[] = null;
	private int n = 0;
	
	public HeapMinimo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo + 1];
		id = new int[nMaximo + 1];
	}
	
	public boolean vazio() {
		return (n == 0);
	}
	
	private void subir(int i){
		int j = i / 2;
		if(j >= 1){
			if(vetor[j] > vetor[i]){
				int aux = this.vetor[i];
				this.vetor[i] = this.vetor[j];
				this.vetor[j] = aux;
				
				aux = this.id[i];
				this.id[i] = this.id[j];
				this.id[j] = aux;
				
				subir(j);
			}
		}
	}
	
	private void descer(int i){
		int f = i * 2;
		if(f <= this.n){
			if(f + 1 <= this.n){
				if(this.vetor[f] > this.vetor[f + 1]){
					f++;
				}
			}
			if(this.vetor[f] < this.vetor[i]){
				int aux = this.vetor[i];
				this.vetor[i] = this.vetor[f];
				this.vetor[f] = aux;
								
				aux = this.id[i];
				this.id[i] = this.id[f];
				this.id[f] = aux;
				
				descer(f);
			}
		}
	}
	
	public void contruir(int prioridade[]){
		for(int i = 1; i < prioridade.length; i++){
			vetor[i] = prioridade[i - 1];
			id[i] = i;
		}
		n = prioridade.length;
		for(int i = this.n/2; i >= 1; i--){
			descer(i);
		}
	}
	
	public int getMinimaPrioridade(){
		if(this.n > 0) {
			return this.id[1];
		}
		return -1;
	}
	
	public int remove(){
		if(this.n > 0){
			int aux = this.id[1];
			this.vetor[1] = this.vetor[n];
			this.id[1] = this.id[n];
			this.n--;
			descer(1);
			return aux;
		}
		return -1;
	}	
	
	public void inserir(int prioridade){
		if(this.n != this.nMaximo){
			vetor[this.n + 1] = prioridade;
			this.n++;
			subir(n);
		}
	}
	
	public void alterarPrioridade(int vertice, int novaPrioridade){		
		int i;
		for(i = 1; i <= this.n && this.id[i] != vertice; i++){
			if(i > this.n){
				return;
			}
			int aux = vetor[i];
			vetor[i] = novaPrioridade;
			if(aux < novaPrioridade){
					descer(i);
				}else{
					subir(i);
				}
		}
	}	
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for(int i = 1; i <= this.n - 1;i++) {
			s.append(this.vetor[i]);
			s.append(", ");
		}
		
		if(this.n > 0) {
			s.append(this.vetor[n]);
		}
		
		s.append("]");
		
		return s.toString();
	}
}
