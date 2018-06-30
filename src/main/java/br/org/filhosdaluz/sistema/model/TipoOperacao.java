package br.org.filhosdaluz.sistema.model;

public enum TipoOperacao{

    RECEITA("Receita"), DESPESA("Despesa");
	
	
	protected String operacao = null;
	

	private TipoOperacao(String operacao) {
		this.operacao = operacao;
		}

	

}
