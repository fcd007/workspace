package br.univel.patterns.structural.facade;

public class LigarPCFacade {

	
	private Computador pc;

	public LigarPCFacade(Computador pc) {
		this.pc = pc;
	}
	
	public void ligarPc() {
		pc.ligaEnergia();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pc.ligaPerifericos();
		pc.carregaBios();
		pc.carregaSistema();
	}
	
	public static void main(String[] args) {
		new LigarPCFacade(
				new Computador()
				).ligarPc();
	}
	
}
