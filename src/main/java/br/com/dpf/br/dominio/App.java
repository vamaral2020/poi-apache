package br.com.dpf.br.dominio;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		GerenciadorCheques gerenciadorCheques = new GerenciadorCheques();
		
		List<Cheque> cheques =gerenciadorCheques.criar();
		
		gerenciadorCheques.imprimir(cheques);

	}
}
