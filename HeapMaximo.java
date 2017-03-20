package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

//GERALDO TAVORA MIRANDA FILHO 383865

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */
public class HeapMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapMaximo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	private void subir(int i){
		int j = i/2;
		if(j >= 1){
			if(vetor[j] < vetor[i]){
				int aux = vetor[j];
				vetor[j] = vetor [i];
				vetor[i] = aux;
				subir(j);
			}
		}
	}
	
	private void descer(int i){
		int j = 2 * i;
		if(j <= n){
			if(vetor[j + 1] > vetor[j]) j++;
			if(vetor[j] > vetor[i]){
				int aux = vetor[j];
				vetor[j] = vetor[i];
				vetor[i] = aux;
				descer(j);
			}
		}
		
	}
	
	public void contruir(List<Integer> entrada){
		for(int i = entrada.size() / 2; i >= 1; i--){
			vetor[i] = entrada.get(i);
			descer(entrada.get(i));
		}
		n = entrada.size();
	}
	
	public int getMaximaPrioridade(){
		int maxima = 0;
		for(int i = 1; i < n; i++){
			if(vetor[i] > vetor[maxima]) maxima = i; 
		}
		return vetor[maxima];
	}
	
	public int remove(){
		if(n >= 1){
			int aux = vetor[1];
			vetor[1] = vetor[n];
			n--;
			return aux;
		}
		return 0;
	}	
	
	public void inserir(int prioridade){
		if(n + 1 <= nMaximo){
			vetor[n + 1] = prioridade;
			n++;
			subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		for(int i = 0; i< n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
				if(prioridade < novaPrioridade){
					subir(novaPrioridade);
				}
				if(prioridade > novaPrioridade){
					descer(novaPrioridade);
				}
				break;
			}
		}
	}	
}
