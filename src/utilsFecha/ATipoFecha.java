package utilsFecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class ATipoFecha {
	protected Date fechaFormateada;
	protected String dia	 = "";
	protected String mes	 = "";
	protected String anio	 = "";
	protected SimpleDateFormat formato = new SimpleDateFormat("dd MM yyyy");
	protected String patron;
	
	public abstract void formatear(String fecha);
	public long calcularDias(Date fecha) {
		long diferenciaEnMilesimas;
		if(this.esAnteriorA(fecha)) {
			//Fecha formateada es menor a la fecha ingresada
			diferenciaEnMilesimas= fecha.getTime() - this.getFechaFormateada().getTime();
		}
		
		//Fecha formateada es mayor a la fecha ingresada
		diferenciaEnMilesimas = this.getFechaFormateada().getTime() - fecha.getTime();
		
		//Se convierte las milesimas en dias
		return TimeUnit.DAYS.convert(diferenciaEnMilesimas, TimeUnit.MILLISECONDS);
	}
	
	public boolean esAnteriorA(Date fecha) {
		//La fecha formateada es anterior a la fecha ingresada
		return this.getFechaFormateada().compareTo(fecha) < 0;
	}
		
	protected void formatearFecha(String fecha) {
		Date fechaObtenida;
		try {
			fechaObtenida = formato.parse(fecha);
			this.setFechaFormateada(fechaObtenida);
		} catch (ParseException exception) {
			System.out.println(exception);
		}
	}

	public Date getFechaFormateada() {
		return fechaFormateada;
	}

	protected void setFechaFormateada(Date fechaFormateada) {
		this.fechaFormateada = fechaFormateada;
	}
	
	public String getPatron() {return patron;}

}
