package br.ufc.quixada.eda.Hash;

public class NoHash<T> {
	private Integer chave;
	private T valor;
	private Integer prox;
	private boolean removido;
	
	public NoHash() {
		this.removido = false;
	}
	
	public NoHash(Integer chave, T valor){
		this.chave = chave;
		this.valor = valor;
		this.removido = false;
	}
	
	
	public Integer getChave() {
		return chave;
	}
	public void setChave(Integer chave) {
		this.chave = chave;
	}
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public Integer getProx() {
		return prox;
	}
	public void setProx(Integer proximo) {
		this.prox = proximo;
	}
	public boolean isRemovido() {
		return removido;
	}
	public void setRemovido(boolean removido) {
		this.removido = removido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chave == null) ? 0 : chave.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoHash other = (NoHash) obj;
		if (chave == null) {
			if (other.chave != null)
				return false;
		} else if (!chave.equals(other.chave))
			return false;
		return true;
	}
	
	
	
	
}