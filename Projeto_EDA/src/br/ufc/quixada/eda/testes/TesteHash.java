package br.ufc.quixada.eda.testes;

import br.ufc.quixada.eda.Hash.EnderecamentoAberto;
import br.ufc.quixada.eda.Hash.EnderecamentoExterno;
import br.ufc.quixada.eda.Hash.EnderecamentoInterno;
import br.ufc.quixada.eda.Hash.ExcecaoEnd;

public class TesteHash {
	public static <T> void main(String[] args) {
//		EnderecamentoExterno end = new EnderecamentoExterno(10);
//		
//		end.inserir(2, "");
//		end.inserir(1, "2");
//		end.inserir(2, "4");
//		end.imprimir();
//		end.remover(1);
//		System.out.println("exclusao");
//		end.imprimir();
		
//		EnderecamentoInterno<String> endi = new EnderecamentoInterno<String>(15);
//		try {
//		
//		endi.inserir(2, "5");
//		endi.inserir(1, "50");
//		endi.inserir(3, "500");
//		endi.inserir(3, "5000");
//		endi.inserir(3, "55000");
//		
//		
//		endi.imprimir();
//		
//		endi.buscar(1);
//		endi.buscar(2);
//		endi.buscar(3);
//		
//		endi.remover(3);
//		
//		endi.imprimir();
//		}catch (ExcecaoEnd e) {
//			System.out.println(e.getMessage());
//			// TODO: handle exception
//		}
		
		EnderecamentoAberto<String> enda = new EnderecamentoAberto<String>(15);
		enda.inserir(0, "geraldo");
		enda.inserir(1, "cecilia");
		enda.inserir(5, "maria");
		enda.inserir(7, "valor");
		System.out.println(enda.buscar(1));
		enda.imprimir();
		
		enda.remover(7);
		enda.imprimir();
		
		enda.inserir(7, "tavora");
		enda.imprimir();
		
		
		
		
	}
}
