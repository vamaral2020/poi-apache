package br.com.dpf.br.dominio;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cheque {
	
	private Date data;
	private Integer numeroCheque;
	private String nome;
	private BigDecimal valor;
	private String status;
	private Integer qtdeParcelas;
	private String formulaTotal;
	

}
