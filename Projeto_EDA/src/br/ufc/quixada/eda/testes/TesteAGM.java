package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import javax.swing.SingleSelectionModel;

import br.ufc.quixada.eda.Algoritmos.ArvoreGeradoraMinima;
import br.ufc.quixada.eda.Grafo.Aresta;
import br.ufc.quixada.eda.Grafo.Grafo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;
import br.ufc.quixada.eda.util.OperacoesAGM;


public class TesteAGM {
	
	public static void main(String args[]){		
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {	
				for (int tam : CriarInstancia.tam) {
				String path = EDAConstants.caminhoPastaAGM + "tb8ch" + tamanho + "_" + tam + ".txt";
				System.out.println(path);
				//List<Grafo> entrada = (List<Grafo>) EDAUtil.getGrafo(path);
				
				String arquivoOperacao = "tb8ch" + tamanho + "_" + tam;
				path = EDAConstants.caminhoPastaAGM + arquivoOperacao + ".txt";
				List<OperacoesAGM> operacoes = (List<OperacoesAGM>) EDAUtil.getGrafo(path);
				
				long tempoInicial = System.currentTimeMillis();	
				Grafo g = new Grafo();
				Aresta [] aresta = null;
				int custo = 0;
				
				for(OperacoesAGM op : operacoes) {
					aresta[tam] = new Aresta(op.getAresta(), op.getVertice(), op.getPeso());
					g.setAresta(aresta);
				}
//								
				long tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
//				
//				//PARA ARQUIVO COM MAIOR QUANTIDADE DE ALTERA��ES
//				arquivoOperacao = "operacoesA_" + tamanho;
//				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
//				operacoes = EDAUtil.getOperacoes(path);
//				
//				tempoInicial = System.currentTimeMillis();				
//				listaPrioridade = new HeapMaximo(2*entrada.size());
//				listaPrioridade.contruir(entrada);							
//			
//				for (Operacao operacao : operacoes) {
//					if(operacao.getId().equals("S")){
//						listaPrioridade.getMaximaPrioridade();
//					}else if(operacao.getId().equals("R")){
//						listaPrioridade.remove();
//					}else if(operacao.getId().equals("I")){
//						listaPrioridade.inserir(operacao.getValor());
//					}else if(operacao.getId().equals("A")) {
//						listaPrioridade.alterarPrioridade(operacao.getValor(),operacao.getNovoValor());
//					}
//					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
//				}
//				
//				tempo = System.currentTimeMillis() - tempoInicial;			  
//				System.out.println(arquivoOperacao + ": " + tempo);				
//				
//				//REMOCAO
//				
//				arquivoOperacao = "operacoesR_" + tamanho;
//				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
//				operacoes = EDAUtil.getOperacoes(path);
//				
//				tempoInicial = System.currentTimeMillis();
//				listaPrioridade = new HeapMaximo(2*entrada.size());
//				listaPrioridade.contruir(entrada);
//				
//				for (Operacao operacao : operacoes) {
//					if(operacao.getId().equals("S")){
//						listaPrioridade.getMaximaPrioridade();
//					}else if(operacao.getId().equals("R")){
//						listaPrioridade.remove();
//					}else if(operacao.getId().equals("I")){
//						listaPrioridade.inserir(operacao.getValor());
//					}else if(operacao.getId().equals("A")) {
//						listaPrioridade.alterarPrioridade(operacao.getValor(),operacao.getNovoValor());
//					}
//					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
//				}
//				
//				tempo = System.currentTimeMillis() - tempoInicial;			  
//				System.out.println(arquivoOperacao + ": " + tempo);
//				
//				//SELECAO
//				
//				arquivoOperacao = "operacoesI_" + tamanho;
//				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
//				operacoes = EDAUtil.getOperacoes(path);
//				
//				tempoInicial = System.currentTimeMillis();
//				listaPrioridade = new HeapMaximo(2*entrada.size());
//				listaPrioridade.contruir(entrada);
//				
//				for (Operacao operacao : operacoes) {
//					if(operacao.getId().equals("S")){
//						listaPrioridade.getMaximaPrioridade();
//					}else if(operacao.getId().equals("R")){
//						listaPrioridade.remove();
//					}else if(operacao.getId().equals("I")){
//						listaPrioridade.inserir(operacao.getValor());
//					}else if(operacao.getId().equals("A")) {
//						listaPrioridade.alterarPrioridade(operacao.getValor(),operacao.getNovoValor());
//					}
//					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
//				}
//				
//				tempo = System.currentTimeMillis() - tempoInicial;			  
//				System.out.println(arquivoOperacao + ": " + tempo);
				//}
				}
			}
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
