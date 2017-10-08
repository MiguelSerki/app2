package PruebaWorkbook.app;

public class StringToInt {

	private double convertedString;
	
	
	public StringToInt() {
		
	}
	
	public double converter (String toConvert) {
		
		convertedString = Double.parseDouble(toConvert);
		
		return convertedString;
	}
	
}
