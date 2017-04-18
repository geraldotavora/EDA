package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import br.ufc.quixada.eda.Algoritmos.ArvoreGeradoraMinima;
import br.ufc.quixada.eda.Grafo.Aresta;
import br.ufc.quixada.eda.Grafo.Grafo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;

public class TesteAGM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {	
				for(int i = 0; i < 4; i++){
					String arquivoOperacao = "tb8ch" + tamanho + "_" + i;
					String path = EDAConstants.caminhoPastaAGM + arquivoOperacao + ".txt";
					Grafo entrada = EDAUtil.lerGrafo(path);
					
					long tempoInicial = System.currentTimeMillis();
					ArvoreGeradoraMinima grafo = new ArvoreGeradoraMinima();
					System.out.println("\n" + "tb8ch" + tamanho + "_" + i + ": ");
					List<Aresta> solucao = grafo.kruskal(entrada);
					
					System.out.println("Custo: " + grafo.getCustoArvore(solucao));
					long tempo = System.currentTimeMillis() - tempoInicial;			  
					System.out.println("Tempo gasto: " + tempo);
				}
		}
		
	}catch (IOException e) {
		e.printStackTrace();
	}

}}
