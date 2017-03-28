package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

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
            this.vetor[i] = entrada.get(i);
        }
	this.n = entrada.size();
        quickSort(0, this.n - 1);
    }

    public int getMaximaPrioridade(){
        if(this.n > 0) return this.vetor[this.n - 1];
        return 0;
    }

    public int remove(){
        if(this.n > 0) return this.vetor[--this.n];
	return 0;
    }	

    public void inserir(int prioridade){
        if((this.n + 1) < this.nMaximo){
            int i = this.n;
            while(this.vetor[i + 1] > prioridade && i >= 0){
		this.vetor[i + 1] = this.vetor[i];
		i--;
	    }
	    this.vetor[i + 1] = prioridade;
	    this.n++;
	}
    }

    public void alterarPrioridade(int prioridade, int novaPrioridade){
        if(this.n > 1){
		int i = 0;
		//while(true){
		for(;i<n;i++) {	
		if(this.vetor[i+1] == prioridade) {
			break;
		}
			i++;
		}
		while(i < this.n - 1){
			this.vetor[i] = this.vetor[i + 1];
			i++;
		}
		this.n--;
		inserir(novaPrioridade);
	}
    }

    private void quickSort(int ini, int fim){
        if (ini < fim) {
            int posicaoPivo = particiona(ini, fim);
            quickSort(ini, posicaoPivo - 1);
            quickSort(posicaoPivo + 1, fim);
        }       

    }

    private int particiona(int inicio, int fim){		
        int pivo = this.vetor[inicio];
        int i = inicio + 1, f = fim;

        while (i <= f) {
            if (this.vetor[i] <= pivo)
                i++;
            else if (pivo < this.vetor[f])
                f--;
            else {
                int aux = this.vetor[i];
                this.vetor[i] = this.vetor[f];
                this.vetor[f] = aux;
                i++;
                f--;
            }
        }
        this.vetor[inicio] = this.vetor[f];
        this.vetor[f] = pivo;
        return f;
    }
}
