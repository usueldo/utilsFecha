package utilsFecha;

public class Flexible extends ATipoFecha {

	@Override
	public void formatear(String fecha) {
		FechaBuilder fechaBuilder = new FechaBuilder();
		ATipoFecha tipoFecha = fechaBuilder.getTipoFecha(fecha);
		tipoFecha.formatear(fecha);
		//"Asigno tipo de fecha"
		this.setFechaFormateada(tipoFecha.getFechaFormateada());
	}

}
