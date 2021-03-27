package util;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;

public class DatasFormatadas {

	private String mes, ano, diaSemana, diaMes;
	private Date data;
	
	public DatasFormatadas (Date data) {
		this.data = data;
	}

	public String getMes() {		
		SimpleDateFormat formatarMes = new SimpleDateFormat("M");
		String mes = formatarMes.format(data);
		
		if( mes.intern() == "1" ) {
			mes = "Janeiro";
		}else if(mes.intern() == "2") {
			mes = "Fevereiro";
		}else if(mes.intern() == "3") {
			mes = "Março";
		}else if(mes.intern() == "4") {
			mes = "Abril";
		}else if(mes.intern() == "5") {
			mes = "Maio";
		}else if(mes.intern() == "6") {
			mes = "Junho";
		}else if(mes.intern() == "7") {
			mes = "Julho";
		}else if(mes.intern() == "8") {
			mes = "Agosto";
		}else if(mes.intern() == "9") {
			mes = "Setembro";
		}else if(mes.intern() == "10") {
			mes = "Outubro";
		}else if(mes.intern() == "11") {
			mes = "Novembro";
		}else if(mes.intern() == "12") {
			mes = "Dezembro";
		}
		
		return mes;
	}
	
	public Month getMesCode() {		
		SimpleDateFormat formatarMes = new SimpleDateFormat("M");
		String mes = formatarMes.format(data);
		
		switch (mes.intern()) {
		case "1":
			return Month.JANUARY;
		case "2":
			return Month.FEBRUARY;		
		case "3":
			return Month.MARCH;
		case "4":
			return Month.APRIL;
		case "5":
			return Month.MAY;
		case "6":
			return Month.JUNE;
		case "7":
			return Month.JULY;
		case "8":
			return Month.AUGUST;
		case "9":
			return Month.SEPTEMBER;
		case "10":
			return Month.OCTOBER;
		case "11":
			return Month.NOVEMBER;
		case "12":
			return Month.DECEMBER;
		default:
			return Month.JANUARY;
		}
	}
	
	public int getMesNumber() {		
		SimpleDateFormat formatarMes = new SimpleDateFormat("M");
		String mes = formatarMes.format(data);
		
		return Integer.parseInt(mes.intern());
	}


	public String getAno() {
		SimpleDateFormat formatarAno = new SimpleDateFormat("y");
		String ano = formatarAno.format(data);
		
		return ano;
	}


	public String getDiaSemana() {
		SimpleDateFormat formatarDiaSemana = new SimpleDateFormat("E");
		String diaSemana = formatarDiaSemana.format(data);
		
		if( diaSemana.intern() == "seg." ) {
			diaSemana = "Segunda";
		}else if(diaSemana.intern() == "ter.") {
			diaSemana = "Terça";
		}else if(diaSemana.intern() == "qua.") {
			diaSemana = "Quarta";
		}else if(diaSemana.intern() == "qui.") {
			diaSemana = "Quinta";
		}else if(diaSemana.intern() == "sex.") {
			diaSemana = "Sexta";
		}else if(diaSemana.intern() == "sáb.") {
			diaSemana = "Sábado";
		}else if(diaSemana.intern() == "dom.") {
			diaSemana = "Domingo";
		}
		
		return diaSemana;
	}



	public String getDiaMes() {
		SimpleDateFormat formatarDiaMes = new SimpleDateFormat("d/M");
		String diaMes = formatarDiaMes.format(data);
		
		return diaMes;
	}

	public int getDiaMesNumber() {
		SimpleDateFormat formatarDiaMes = new SimpleDateFormat("dd");
		String diaMes = formatarDiaMes.format(data);
		
		return Integer.parseInt(diaMes);
	}
	
}
