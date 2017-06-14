package br.ufc.quixada.eda.splay;

import br.ufc.quixada.eda.avl.NoAvl;

public class Splay<T> extends NoSplay<T> {
	private NoSplay<T> raiz;
	
	public Splay(int chave, T valor) {
		super(chave, valor);
		// TODO Auto-generated constructor stub
	}
	
	private NoSplay<T> Splay(NoSplay<T> raiz, int chave){
		if(this.raiz == null) return null;
		if(this.raiz.getChave() == chave) return raiz;
		if(chave < this.raiz.getChave()) {
			if(this.raiz.getEsq() != null) {
				raiz.setEsq(Splay(raiz.getEsq(), chave));
				this.raiz = rotdir(raiz);
			}
		}else if(chave > this.raiz.getChave()) {
			if(this.raiz.getDir() != null) {
				raiz.setDir(Splay(raiz.getDir(), chave));
				raiz = rotesq(raiz);
			}
		}
		return raiz;
				
	}
	
	public void inserir(int chave, T valor) {
		this.raiz = inserir(chave, valor, raiz);
	}
	
	private NoSplay<T> inserir(int chave, T valor, NoSplay<T> r){
		if(r == null) r = new NoSplay<T>(chave, valor);
		else if(chave < r.getChave()) {
			r.setEsq(inserir(chave, valor, r.getEsq()));
		}else if(chave > r.getChave()) {
			r.setDir(inserir(chave, valor, r.getDir()));			
		}
		//return Splay(r, chave);
		return r;
				
	}
	
	private NoSplay<T> rotdir(NoSplay<T> k2){
		NoSplay<T> k1 = k2.getEsq();
		k2.setEsq(k1.getDir());
		k1.setDir(k2);
		return k1;
	}
	
	private NoSplay<T> rotesq(NoSplay<T> k1){
		NoSplay<T> k2 = k1.getDir();
		k1.setDir(k2.getEsq());
		k2.setEsq(k1);
		return k2;
	}
	
	public NoSplay<T> limpa() {
		return raiz = null;
	}
	
	
	private void imp(NoSplay<T> n, String s) {
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
		System.out.println(n.getChave() + "("+ n.getValor()+ ")");
		if(n != null && (n.getEsq() != null || n.getDir() != null)) {
			imp(n.getEsq(), s + "l");
		}
	}
	
	public void show() {
		imp(this.raiz, "");
	}
}
