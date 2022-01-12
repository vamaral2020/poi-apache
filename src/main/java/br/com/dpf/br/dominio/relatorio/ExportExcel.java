package br.com.dpf.br.dominio.relatorio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import br.com.dpf.br.dominio.Pessoa;

public class ExportExcel {

	public ByteArrayInputStream exportDataExcel() throws IOException {
		
		String[] col = {"id","nome","sobrenome","end","fone"};
		
		Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		Sheet sheet = workbook.createSheet("Pessoas");
		Row rows = sheet.createRow(0);
		
		for(int i=0; i<col.length;i++) {
			Cell cells = rows.createCell(i);
			cells.setCellValue(col[i]);
			
		}
		
		List<Pessoa> pessoas = new ArrayList<>();
		int initRow = 1;
		
		for (Pessoa pessoa : pessoas) {
			rows = sheet.createRow(initRow);
			rows.createCell(0).setCellValue(pessoa.getId());
			rows.createCell(1).setCellValue(pessoa.getNome());
			rows.createCell(2).setCellValue(pessoa.getSobreNome());
			rows.createCell(3).setCellValue(pessoa.getEnd());
			rows.createCell(4).setCellValue(pessoa.getFone());
			initRow++;
		}
		
		workbook.write(stream);
		workbook.close();
		return new ByteArrayInputStream(stream.toByteArray());
	}
}
