package br.ufc.quixada.eda.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import br.ufc.quixada.eda.Grafo.Aresta;
import br.ufc.quixada.eda.Grafo.Grafo;

public class EDAUtil {
	private static Aresta [] aresta;
	/**
	 * Ler o arquivo que cont�m as prioridades iniciais da lista de prioridades.
	 * @param path
	 * @return
	 * @throws IOException
	 */
    public static List<Integer> getDadosIniciais(String path) throws IOException {
        List<Integer> entrada = new ArrayList<Integer>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");
		while (scanner.hasNext())
			entrada.add(scanner.nextInt());
		
		scanner.close();
        return entrada;
    }
    
    
    
    public static Grafo getGrafo(String path) throws IOException{
    	Grafo g = null;;
    	//aresta = null;
    	Scanner scan = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");
    	
    	if(scan.hasNext()) {
    		g = new Grafo(scan.nextInt(), scan.nextInt());
//    		g.setQ_vert(scan.nextInt());
//    		g.setQ_arest(scan.nextInt());
    	}
    	
    	int i = 0;
    	while(scan.hasNext()) {
    		g.getAresta()[i] = new Aresta(scan.nextInt(), scan.nextInt(), scan.nextInt());
    		i++;
    	}
    	scan.close();
    	//g.setAresta(aresta);
    	return g;
    }
    
    //Ordenacao
    
    public static void ordenarListaAresta(List<Aresta> aresta) {
    	Collections.sort(aresta, new Comparator<Aresta>() {

			@Override
			public int compare(Aresta o1, Aresta o2) {
				if(o1.getPeso() < o2.getPeso()) return -1;
				else if(o1.getPeso() > o2.getPeso()) return 1;
				else return 0;
				}
				// TODO Auto-generated method stub    		
		});
    }
    
    public static void quickSort(Aresta[] aresta, int i, int j) {
    	if(i < j) {
    		int pivo = particiona(aresta, i, j);
    		quickSort(aresta, i, pivo - 1);
    		quickSort(aresta, pivo + 1, j);
    	}
    }
    
    private static int particiona(Aresta[] aresta, int i, int j) {
    	int pivo = j;
    	int q = i - 1;
    	
    	for(int k = i; k < j; k++) {
    		if(aresta[k].getPeso() < aresta[pivo].getPeso()) {
    			q++;
    			Aresta aux = aresta[k];
    			aresta[k] = aresta[q];
    			aresta[q] = aux;
    		}
    	}
    	
    	Aresta aux = aresta[q + 1];
    	aresta[q + 1] = aresta[j];
    	aresta[j] = aux;
    	
    	return q + 1;
    }
    
    /**
     * Ler as opera��es que ser�o realizadas na lista de prioridades ap�s a sua cria��o.
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Operacao> getOperacoes(String path) throws IOException {
        List<Operacao> operacoes = new ArrayList<Operacao>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");	
		while (scanner.hasNext())
			operacoes.add(new Operacao(scanner.next(), scanner.nextInt(), scanner.nextInt()));
			
		scanner.close();
        return operacoes;
    }    
    
 }
