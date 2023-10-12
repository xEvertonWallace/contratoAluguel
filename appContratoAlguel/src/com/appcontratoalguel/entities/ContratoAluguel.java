package com.appcontratoalguel.entities;

public class ContratoAluguel {
	
	private int numeroContrato;
	private double valorAluguel;
	private int qtdMeses;
	private int qtdPrestPagas;
	private int  qtdPrestAtraso;
	private double percentJuros;
	private int qtdMesesAtrasadosSuficienteParaDespejo;
	private boolean ativo;
	private Fiador fiador;
	
	public ContratoAluguel(int numeroContrato, double valorAluguel, int qtdMeses, int qtdPrestPagas, int qtdPrestAtraso,
			double percentJuros, int qtdMesesAtrasados, Fiador fiador) {

		this.numeroContrato = numeroContrato;
		this.valorAluguel = valorAluguel;
		this.qtdMeses = qtdMeses;
		this.qtdPrestPagas = qtdPrestPagas;
		this.qtdPrestAtraso = qtdPrestAtraso;
		this.percentJuros = percentJuros;
		this.qtdMesesAtrasadosSuficienteParaDespejo = qtdMesesAtrasados;
		this.fiador = fiador;
		
		if (fiador != null && !fiador.verificaRenda(valorAluguel)) {
	         throw new IllegalArgumentException("Renda do fiador insuficiente");
	    
	     }
	}

    public double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public int getNumeroContrato() {
		return numeroContrato;
	}

	public int getQtdMeses() {
		return qtdMeses;
	}

	public int getQtdPrestPagas() {
		return qtdPrestPagas;
	}

	public int getQtdPrestAtraso() {
		return qtdPrestAtraso;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public Fiador getFiador() {
		return fiador;
	}

	public double calcularPrestacaoSemJuros() {
        return valorAluguel;
    }

    public double calcularPrestacaoComJuros() {
        return valorAluguel * (1 + percentJuros);
    }

    public void pagarPrestacaoSemJuros() {
        if (qtdPrestPagas < qtdMeses) {
        	qtdPrestPagas++;
        }
        if (qtdPrestPagas - qtdPrestAtraso >= qtdMesesAtrasadosSuficienteParaDespejo) {
            ativo = false; 
        }
    }

    public boolean deveOrdemDespejo() {
        return qtdPrestAtraso >= qtdMesesAtrasadosSuficienteParaDespejo && qtdPrestPagas < qtdMeses - 6;
    }

    public void modificarRendaFiador(double novaRenda) {
        fiador.setRendaMensal(novaRenda);
    }

    public void modificarFiador(Fiador novoFiador) {
        fiador = novoFiador;
        if (novoFiador != null && !novoFiador.verificaRenda(valorAluguel)) {
            System.out.println("Renda do novo fiador é insuficiente. Você deve escolher outro fiador.");
        } else {
            fiador = novoFiador;
            System.out.println("Fiador atualizado com sucesso.");
        }
    }

    public void encerrarContrato() {
        ativo = false;
    }
	
	
		
}
