package com.platform.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Servi {
	
	private List<String> servis;

	public Servi() {
		String[] arrServis = { "Espejos", "Focos", "Iluminacion", "Pinturas", "Polarisados", "Seguridad Vehicular", "Siliconas", 
				"Ambientadores", "Respuestos", "Adhesivos", "Asistencia Vhicular", "Accesorios Electricos", "Accesorios externos" };

		this.servis = new ArrayList<>(Arrays.asList(arrServis));
	}
	
	public List<String> getServis() {
		return servis;
	}

}