package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import br.ufc.quixada.eda.Algoritmos.Dijkstra;
import br.ufc.quixada.eda.Grafo.Grafo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;

public class TesteDijkstra {
	public static void main(String[] args) {
		try{
			for(int tamanho : CriarInstancia.tamanhoInstancias){
				for(int i = 0; i < 4; i++){
					String path = EDAConstants.caminhoPastaAGM + "tb8ch" + tamanho + "_" + i + ".txt";
					Grafo entrada = EDAUtil.lerGrafo(path);
					
					long tempoInicial = System.currentTimeMillis();	
					
					Dijkstra caminho = new Dijkstra();
					caminho.executar(entrada, 0);
					//caminho.imprimeCaminho(1, tamanho);
					
					long tempo = System.currentTimeMillis() - tempoInicial;			  
					System.out.println("Tempo gasto por -> tb8ch" + tamanho + "_" + i + ": " + tempo);
					
				}
			}	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
