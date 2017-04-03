package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

public class HeapTernario {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapTernario(int nMaximo){
		this.nMaximo = nMaximo;
		this.vetor = new int[nMaximo];
	}
	
	public void subir(int i) {
		int j = i/3;
		if(j >= 1) {
			if(vetor[j] < vetor[i]) {
				int aux = vetor [i];
				vetor[i] = vetor [j];
				vetor[j] = aux;
				subir(j);
			}
		}
	}
	
	public void descer(int i) {
		int j = (i + 1) * 3;
		if(j <= n) {
			if(j + 1 < n) {
				if(vetor[j] < vetor[j + 1]) {
					j++;
				}
			}
			if(vetor[j] > vetor[i]) {
				int aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				descer(j);
			}
		}
	}
	
	public void contruir(List<Integer> entrada) {
		for(int i = 1; i <= entrada.size(); i++) {
			this.vetor[i] = entrada.get(i - 1);
		}
		n = entrada.size();
		
		for(int i = n / 3; i >= 1; i--) {
			descer(i);
		}
	}
	
	public int getMaximaPrioridade() {
		return vetor[1];
	}
	
	public int remove(){
		if(n >= 1) {
			int aux = vetor[1];
			vetor[1] = vetor[n];
			n--;
			descer(1);
			return aux;
		}
		return -1;
	}
	
	public void inserir(int prioridade) {
		if(n + 1 > nMaximo) {
			vetor[n + 1] = prioridade;
			n++;
			subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade) {
		for(int i = 1; i <= n; i++) {
			if(vetor[i] == prioridade) {
				vetor[i] = novaPrioridade;
				if(novaPrioridade > prioridade) {
					subir(i);
				}else {
					descer(i);
				}
				return;
			}
		}
	}
	
	
}



















