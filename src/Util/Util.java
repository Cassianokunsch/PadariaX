package Util;

import java.text.DecimalFormat;

public class Util {
	
	public static String FormatPreco(double preco, String format){
		DecimalFormat df = new DecimalFormat(format);
		String dx = df.format(preco);
		return dx;	
	}
}
