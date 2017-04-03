package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import javax.swing.SingleSelectionModel;

import br.ufc.quixada.eda.listaprioridades.HeapTernario;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteListaPrioridadeHeapTern {
	public static void main(String args[]){		
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {				
				String path = EDAConstants.caminhoPasta + "tarefa" + tamanho + ".txt";
				List<Integer> entrada = EDAUtil.getDadosIniciais(path);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE SELEÇÕES
				String arquivoOperacao = "operacoesS_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				List<Operacao> operacoes = EDAUtil.getOperacoes(path);
				
				long tempoInicial = System.currentTimeMillis();				
				HeapTernario listaPrioridade = new HeapTernario(3 * entrada.size());
				listaPrioridade.contruir(entrada);
			
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("S")){
						listaPrioridade.getMaximaPrioridade();
					}else if(operacao.getId().equals("R")){
						listaPrioridade.remove();
					}else if(operacao.getId().equals("I")){
						listaPrioridade.inserir(operacao.getValor());
					}else if(operacao.getId().equals("A")) {
						listaPrioridade.alterarPrioridade(operacao.getValor(),operacao.getNovoValor());
					}
					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}
				
				long tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE ALTERA��ES
				arquivoOperacao = "operacoesA_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new HeapTernario(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("S")){
						listaPrioridade.getMaximaPrioridade();
					}else if(operacao.getId().equals("R")){
						listaPrioridade.remove();
					}else if(operacao.getId().equals("I")){
						listaPrioridade.inserir(operacao.getValor());
					}else if(operacao.getId().equals("A")) {
						listaPrioridade.alterarPrioridade(operacao.getValor(),operacao.getNovoValor());
					}
					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}
				
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);				
				
				//REMOCAO
				
				arquivoOperacao = "operacoesR_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();
				listaPrioridade = new HeapTernario(2*entrada.size());
				listaPrioridade.contruir(entrada);
				
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("S")){
						listaPrioridade.getMaximaPrioridade();
					}else if(operacao.getId().equals("R")){
						listaPrioridade.remove();
					}else if(operacao.getId().equals("I")){
						listaPrioridade.inserir(operacao.getValor());
					}else if(operacao.getId().equals("A")) {
						listaPrioridade.alterarPrioridade(operacao.getValor(),operacao.getNovoValor());
					}
					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}
				
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
				
				//SELECAO
				
				arquivoOperacao = "operacoesI_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();
				listaPrioridade = new HeapTernario(2*entrada.size());
				listaPrioridade.contruir(entrada);
				
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("S")){
						listaPrioridade.getMaximaPrioridade();
					}else if(operacao.getId().equals("R")){
						listaPrioridade.remove();
					}else if(operacao.getId().equals("I")){
						listaPrioridade.inserir(operacao.getValor());
					}else if(operacao.getId().equals("A")) {
						listaPrioridade.alterarPrioridade(operacao.getValor(),operacao.getNovoValor());
					}
					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}
				
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
			}
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
