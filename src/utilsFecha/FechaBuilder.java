package utilsFecha;

import java.util.ArrayList;

public class FechaBuilder {
	ArrayList<ATipoFecha> tiposFecha = new ArrayList<ATipoFecha>();
	
	public FechaBuilder() {
		tiposFecha.add(new ISO());
		tiposFecha.add(new Latino());
		tiposFecha.add(new Norte());
	}
	
	public ATipoFecha getTipoFecha(String fecha) {
		
		for(ATipoFecha tipoFecha : tiposFecha) {
			if(fecha.matches(tipoFecha.getPatron())) {
				return tipoFecha;
			}
		}
		//No se encontro ninguna fecha valida
		throw new FechaInvalidaException();
	}
}
