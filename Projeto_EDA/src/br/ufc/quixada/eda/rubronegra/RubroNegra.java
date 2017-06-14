package br.ufc.quixada.eda.rubronegra;

import javax.xml.bind.ParseConversionEvent;

import br.ufc.quixada.eda.avl.NoAvl;

public class RubroNegra{
	private No raiz;
		
	public boolean isPreto(No no) {
		if(no == null) return true;
		else if(no.isCor() == No.isPreta()) return true;
		else return false;
	}
	
	private void recolorir(No no) {
		no.setCor(No.isVermelha());
		no.getEsq().setCor(No.isPreta());
		no.getDir().setCor(No.isPreta());
	}
	
	public void add(int chave) {
		raiz = add(raiz, chave);
		raiz.setCor(No.isPreta());

	}
	
	private No add(No raiz, int chave) {
		if(raiz == null) {
			No node = new No(chave);
			return node;
		}
		
		if(chave < raiz.getChave()) {
			raiz.setEsq(add(raiz.getEsq(), chave));
		}else if(chave > raiz.getChave()) {
			raiz.setDir(add(raiz.getDir(), chave));
		
		}
		
		if(isPreto(raiz) && !isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getEsq())) {
			recolorir(raiz);
		
		}else if(isPreto(raiz) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getDir()) && !isPreto(raiz.getDir().getDir())) {
			recolorir(raiz);
		}
		
		if(isPreto(raiz) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getEsq())) {
			raiz = rotdir(raiz);
			raiz.setCor(No.isPreta());
			raiz.getDir().setCor(No.isVermelha());
			
		}else if(isPreto(raiz) && !isPreto(raiz.getDir()) && !isPreto(raiz.getDir().getDir())) {
			raiz = rotesq(raiz);
			raiz.setCor(No.isPreta());
			raiz.getEsq().setCor(No.isVermelha());
		}
		
		if(!isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getDir())) {
			raiz.setEsq(rotesq(raiz.getEsq()));
		
		}else if (!isPreto(raiz.getDir()) && !isPreto(raiz.getDir().getEsq())) {
			raiz.setDir(rotdir(raiz.getDir()));
		
		}
		
		return raiz;
	}
	
	private No rotdir(No k2) {
		No k1 = k2.getEsq();
		k2.setEsq(k1.getDir());
		k1.setDir(k2);
		return k1;
	}
	
	private No rotesq(No k1) {
		No k2 = k1.getDir();
		k1.setDir(k2.getEsq());
		k2.setEsq(k1);
		return k2;
	}
	
	private void imp(No n, String s) {
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
		System.out.println(n.getChave() +"(" + n.isCor()+ ")");
		if(n != null && (n.getEsq() != null || n.getDir() != null)) {
			imp(n.getEsq(), s + "l");
		}
	}
	
	public void show() {
		imp(this.raiz, "");
	}
}
