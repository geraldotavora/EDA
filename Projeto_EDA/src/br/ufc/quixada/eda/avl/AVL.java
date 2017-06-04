package br.ufc.quixada.eda.avl;

public class AVL {
	private NoAvl raiz;
	
	public AVL() {
		raiz = null;
	}
	
	public void limpar() {
		raiz = null;
	}
	
	public boolean isEmpty() {
		return raiz == null;
	}
	
	public static int altura(NoAvl r) {
		if(r == null) return -1;
		return r.getAltura();
	}
	
	public void inserirChave(int chave) {
		this.raiz = inserir(chave, raiz);
	}
	
	private NoAvl inserir(int chave, NoAvl r) {
		if(r == null) r = new NoAvl(chave);
		else if(r.getChave() > chave) {
			r.setEsq(inserir(chave, r.getEsq()));
		}else if(r.getChave() < chave) {
			r.setDir(inserir(chave, r.getDir()));
		}
		r = balanceamento(r);
		return r;
	}
	
	private int difAltura(NoAvl r) {
		return altura(r.getEsq()) - altura(r.getDir());
	}
	
	private static int max(int sae, int sad) {
		if(sae > sad) return sae;
		else{
			return sad;
		}
	}
	
	public NoAvl balanceamento(NoAvl r) {
		if(difAltura(r) == 2) {
			if(difAltura(r.getEsq()) > 0) {
				r = rotdireita(r);
			}else {
				r = duplarotdireita(r);
			}
		}else if(difAltura(r) == -2) {
			if(difAltura(r.getDir()) < 0) {
				r = rotesquerda(r);
			}else {
				r = duplarotesquerda(r);
			}
		}
		r.setAltura(max(altura(r.getEsq()), altura(r.getDir())) + 1);
		return r;
	}
	
	private static NoAvl rotdireita(NoAvl k2) {
		NoAvl k1 = k2.getEsq();
		k2.setEsq(k1.getDir());
		k1.setDir(k2);
		k2.setAltura(max(altura(k2.getEsq()), altura(k2.getDir())) + 1);
		k1.setAltura(max(altura(k1.getEsq()), k2.getAltura()) + 1);
		return k1;
	}
	
	private static NoAvl rotesquerda(NoAvl k1) {
		NoAvl k2 = k1.getDir();
		k1.setDir(k2.getEsq());
		k2.setEsq(k1);
		k1.setAltura(max(altura(k1.getEsq()), altura(k1.getDir())) + 1);
		k2.setAltura(max(altura(k2.getDir()), k1.getAltura()) + 1);
		return k2;
	}
	
	private static NoAvl duplarotdireita(NoAvl k3) {
		k3.setEsq(rotesquerda(k3.getEsq()));
		return rotdireita(k3);
	}
	
	private static NoAvl duplarotesquerda(NoAvl k1) {
		k1.setDir(rotdireita(k1.getDir()));
		return rotesquerda(k1);
	}
	
	public NoAvl busca(int chave) {
		return busca(raiz, chave);
	}
	
	private NoAvl busca(NoAvl n, int valor) {
		while(n != null) {
			if(valor == n.getChave()) return n;
			else if(valor < n.getChave()) return n.getEsq();
			else if(valor < n.getChave()) return n.getDir();
		}
		return null;
	}
	
	public NoAvl buscarep(int chave) {
		NoAvl p = raiz;
		NoAvl ant = null;
		while(p != null && !(p.getChave() == chave)) {
			ant = p;
			if(p.getChave() < chave) {
				p = p.getDir();
			}else {
				p = p.getEsq();
			}
		}
		if(p != null && p.getChave() == chave) {
			return ant;
		}
		return null;
	}
	
	private void imp(NoAvl n, String s) {
		if(n != null && (n.getEsq() != null || n.getDir() != null))
			imp(n.getDir(), s + "r");
		int tam = s.length();
		for(int i = 0; i < tam - 1; i++) {
			if(s.charAt(i) != s.charAt(i+1)) {
				System.out.print("| "+"  ");
			}else {
				System.out.print("  "+"  ");
			}
		}
		if(s != "") {
			if(s.endsWith("r") == true)
				System.out.print("┌───");
			else
				System.out.print("└───");
		}
		if(n == null) {
			System.out.println("#");
			return;
		}
		System.out.println(n.getChave() +"(" + n.getAltura()+ ")");
		if(n != null && (n.getEsq() != null || n.getDir() != null)) {
			imp(n.getEsq(), s + "l");
		}
	}
	
	public void show() {
		imp(this.raiz, "");
	}
	
}

















