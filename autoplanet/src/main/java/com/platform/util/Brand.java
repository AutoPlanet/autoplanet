package com.platform.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Brand {
	
	private List<String> brands;

	public Brand() {
		String[] arrBrands = { "Wimbo", "Safari Matrix", "Taron", "JiangDong", "Masalta", "H-Powers",
				"Safari Rack", "G3", "Safari Gold", "Lacela" , "K-1903", "Lion", "Mikrouna", "Narva", "Poli", "Hwasdan",
				"Pentair", "SPY", "RTECH", "Simoniz" };

		this.brands = new ArrayList<>(Arrays.asList(arrBrands));
	}
	
	public List<String> getBrands() {
		return brands;
	}

}
