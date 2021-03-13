package Util;

import java.text.SimpleDateFormat;
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
		}else if(diaSemana.intern() == "sab.") {
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


	
}
