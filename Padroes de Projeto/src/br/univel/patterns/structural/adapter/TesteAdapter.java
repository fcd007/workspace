package br.univel.patterns.structural.adapter;

public class TesteAdapter {

	private Impressora impressora;

	public TesteAdapter() {}
	
	private void setImpressora(Impressora impressora) {
		this.impressora = impressora;
	}

	private void imprime() {
		impressora.imprime("Olá");
		impressora.imprime("\n");
		impressora.imprime("padrão adapter");
	}

	public static void main(String[] args) {
		
		JanelaOutput jo = new JanelaOutput();
		jo.setSize(800, 600);
		jo.setLocationRelativeTo(null);
		jo.setVisible(true);
		
		Impressora impressora = new NovaImpressora(jo.getTextArea());
		TesteAdapter teste = new TesteAdapter();
		teste.setImpressora(impressora);
		teste.imprime();
	}
}
