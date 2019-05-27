package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import utilsFecha.FechaInvalidaException;
import utilsFecha.Flexible;

class FlexibleTest {

	
	@Test
	void formatearCualquierFecha_fechaFormateadaSinErrorISO(){
		Flexible fechatest = new Flexible();
		fechatest.formatear("2018-01-12");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2018, Calendar.JANUARY, 12);

        assertTrue("Las fechas no son iguales", fechaEsperada.getTime().equals(fechatest.getFechaFormateada()));
 
	}

	@Test
	void formatearCualquierFecha_fechaFormateadaSinErrorLatin(){
		Flexible fechatest = new Flexible();
		fechatest.formatear("12/01/2019");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.JANUARY, 12);

        assertTrue("Las fechas no son iguales", fechaEsperada.getTime().equals(fechatest.getFechaFormateada()));
 
	}

	@Test
	void formatearCualquierFecha_fechaFormateadaSinErrorNorte(){
		Flexible fechatest = new Flexible();
		fechatest.formatear("01-12-2019");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.JANUARY, 12);

        assertTrue("Las fechas no son iguales", fechaEsperada.getTime().equals(fechatest.getFechaFormateada()));
 
	}
	
	@Test
	void formatearCualquierFecha_fechaDesconocida(){
		Flexible fechatest = new Flexible();
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.JANUARY, 12);

        Assertions.assertThrows(FechaInvalidaException.class,
        						() -> fechatest.formatear("43-54-2019"));
	}

	@Test
    public void calcularDias_HayDosDiasDeDiferencia() {
		Flexible fechaFlexible1 = new Flexible();
		Flexible fechaFlexible2 = new Flexible();
		fechaFlexible1.formatear("2018-04-04");
		fechaFlexible2.formatear("2018-04-02");

        assertEquals("No hay dos dias de diferencia",
        		2,
        		fechaFlexible1.calcularDias(fechaFlexible2.getFechaFormateada()));
    }
	@Test
    public void esAnteriorA_25DeMayoEsAnteriorA9DeJulio() {
		Flexible fechaFlexible1 = new Flexible();
		Flexible fechaFlexible2 = new Flexible();
		fechaFlexible1.formatear("2018-05-25");
		fechaFlexible2.formatear("2019-07-09");

       assertTrue("25 de Mayo no es anterior a 9 de Julio",
    		   	   fechaFlexible1.esAnteriorA(fechaFlexible2.getFechaFormateada()));
    }
}

