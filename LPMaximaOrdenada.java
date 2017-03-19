package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

//GERALDO TAVORA MIRANDA FILHO 383865

/**
 * Implementa a lista de prioridade usando vetor ordenado.
 * Reparem que aqui voc� devem utilizar obrigat�riamente o quickSort 
 * para realizar a ordena��o, quando for necess�rio.
 * @author fabio
 *
 */
public class LPMaximaOrdenada {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public LPMaximaOrdenada(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	public void contruir(List<Integer> entrada){
		for(int i = 0; i < entrada.size(); i++){
			vetor[i] = entrada.get(i);
		}
		quickSort(entrada.get(0), entrada.size() - 1);
		n = entrada.size();
	}
	
	public int getMaximaPrioridade(){
		int maxima = 0;
		for(int i = 1; i < n; i++){
			if(vetor[i] > vetor[maxima]){
				maxima = i;
			}
		}
		return vetor[maxima];
	}
	
	public int remove(){
		int maxima = 0;
		for(int i = 1; i < n; i++){
			if(vetor[i] > vetor[maxima]){
				maxima = i;
			}
		}
		int aux = vetor[maxima];
		n--;
		vetor[maxima] = vetor[n];
		return aux;
	}	
	
	public void inserir(int prioridade){
		if(n + 1 < nMaximo){
			vetor[n] = prioridade;
			n++;
			quickSort(vetor[0], vetor[n]);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		for(int i = 0; i < n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
				break;
			}
			quickSort(vetor[0], vetor[n]);
		}
	}
	
	private void quickSort(int ini, int fim){
		int i = ini;
		int f = fim;
		int pivo = ini;
		
		while(f >= i){
			while(vetor[i] < vetor[pivo]){
				i++;
			}
			while(vetor[f] > vetor[pivo]){
				f--;
			}
			if(f >= i){
				int aux = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = aux;
				i++;
				f--;
			}
		}
		if(f - ini >= 1){
			quickSort(ini, f);
		}
		if(fim - i >= 1){
			quickSort(i, fim);
		}
	}
	
	private int particiona(int p, int r){		
		return 0;
	}
	
}


