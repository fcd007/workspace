package br.univel.patterns.behavioral.state;

public class TesteStateNota {

	public static void main(String[] args) {
		NotaFiscal n = new NotaFiscal();
		n.abrir();

		n.adicionarItem("Leite");
		n.adicionarItem("Arroz");
		n.adicionarItem("Feijao");

		n.fechar();
		n.fechar();
		
		
		
	}

}
