package com.atlantic.test.inout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.atlantic.test.util.Constantes;
import com.atlantic.test.util.ExcelUtil;
import com.atlantic.test.util.ExcelUtilPropio;
import com.atlantic.test.util.InOut;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import atlantic.main.util.Variables;

public class LeerDD_Reembolso implements InOut {

	private ExcelUtilPropio excelUtilPropio = ExcelUtilPropio.getInstancia();
	private ExcelUtil excelUtil = new ExcelUtil();
	// singleton
	private static LeerDD_Reembolso obj = null;

	private LeerDD_Reembolso() {
	}

	public static LeerDD_Reembolso getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new LeerDD_Reembolso();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	// singleton


	@Override
	public List<List<String>> leerDD(String hoja) throws Exception {
		return null;
	}

	@Override
	public List<List<String>> leerUltimaFilaDD(String hoja) throws EncryptedDocumentException, IOException {
		return null;
	}

	@Override
	public void escribirDD(String string, String id) throws Exception {
	}

	@Override
	public void escribirNuevoDD(List<String> listaString, int dataDriven) throws Exception {
	}

	@Override
	public void escribirNuevoDD(String string, int dataDriven) throws Exception {
	}

	@Override
	public void escribirDD(List<String> listaString, String id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escribirDD(List<String> listaString, int filaAEscribir) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void writeReembolsoinExcel(List<String> listaString) throws EncryptedDocumentException, FileNotFoundException, IOException {

		
	}

	@Override
	public void escribirDD(String string, int filaAEscribir) {
		// TODO Auto-generated method stub
		
	}

}
