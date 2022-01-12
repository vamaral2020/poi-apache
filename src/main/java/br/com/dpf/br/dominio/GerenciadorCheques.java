package br.com.dpf.br.dominio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GerenciadorCheques {

	public List<Cheque> criar() throws IOException {
		
		List<Cheque> cheques = new ArrayList<>();
		String path = "src\\main\\java\\br\\com\\dpf\\br\\resource\\SLA - ESTOURADO.xlsx";
		FileInputStream file = null;
		
		
		try {
			//recepera o arquivo
			file = new FileInputStream(path);
			
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			Sheet sheet = workbook.getSheetAt(0);
			
			//setando as linhas
			@SuppressWarnings("unchecked")
			List<Row> rows = (List<Row>) toList(sheet.iterator());
			
			//remove cabeçalhos
			rows.remove(0);
			
			rows.forEach(row->{
				@SuppressWarnings({ "unchecked" })
				List<Cell> cells =(List<Cell>) toList(row.iterator());	
				
				Cheque cheque = Cheque.builder()
						.data((Date) cells.get(0).getDateCellValue())
						.numeroCheque((int) cells.get(1).getNumericCellValue())
						.nome(cells.get(2).getStringCellValue())
						.valor(new BigDecimal(cells.get(3).getNumericCellValue()))
						.status(cells.get(4).getStringCellValue())
						.qtdeParcelas((int) cells.get(5).getNumericCellValue())
						.formulaTotal(cells.get(6).getCellFormula())
						.build();
				cheques.add(cheque);
			});

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return cheques;
	}
	
	public List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);
	}
	
	public void imprimir(List<Cheque> cheques) {
		cheques.forEach(System.out::println);
	}

}

