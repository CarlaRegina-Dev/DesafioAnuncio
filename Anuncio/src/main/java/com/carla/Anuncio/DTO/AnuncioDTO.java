package com.carla.Anuncio.DTO;

import com.carla.Anuncio.Model.AnuncioModel;

public class AnuncioDTO {
	private NovoDTO anuncio;
	private Double valorTotalInvestido;
	private int quantidadeMaximaVisualizacao;
	private int quantidadeMaximaCliques;
	private int quantidadeMaximaCompartilhamento;


	public NovoDTO getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(NovoDTO anuncio) {
		this.anuncio = anuncio;
	}

	public Double getValorTotalInvestido() {
		return valorTotalInvestido;
	}

	public void setValorTotalInvestido(Double valorTotalInvestido) {
		this.valorTotalInvestido = valorTotalInvestido;
	}

	public int getQuantidadeMaximaVisualizacao() {
		return quantidadeMaximaVisualizacao;
	}

	public void setQuantidadeMaximaVisualizacao(int quantidadeMaximaVisualizacao) {
		this.quantidadeMaximaVisualizacao = quantidadeMaximaVisualizacao;
	}

	public int getQuantidadeMaximaCliques() {
		return quantidadeMaximaCliques;
	}

	public void setQuantidadeMaximaCliques(int quantidadeMaximaCliques) {
		this.quantidadeMaximaCliques = quantidadeMaximaCliques;
	}

	public int getQuantidadeMaximaCompartilhamento() {
		return quantidadeMaximaCompartilhamento;
	}

	public void setQuantidadeMaximaCompartilhamento(int quantidadeMaximaCompartilhamento) {
		this.quantidadeMaximaCompartilhamento = quantidadeMaximaCompartilhamento;
	}
}
