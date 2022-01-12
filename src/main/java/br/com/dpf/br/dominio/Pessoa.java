package br.com.dpf.br.dominio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pessoa {

	
	private int id;
	private String nome;
	private String sobreNome;
	private String end;
	private String fone;

}
