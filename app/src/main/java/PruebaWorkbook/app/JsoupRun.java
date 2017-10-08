package PruebaWorkbook.app;
import java.io.IOException;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class JsoupRun {

	private static double price;
	private static String category;
	private static String name;
	private static String expansion;
	private static String link;
	private static int amount;
	
	public void getLink (String string) {
		if (string.isEmpty()){
			
		}
		
		this.link = string;
	}
	
	public int getData () {
		Document d;
		try {
			d = Jsoup.connect (this.getLink()).timeout(9000).get();
			if (!(d.hasText())) {
				return 1;
			}
			else {
		
		Elements ele=d.getElementsByTag("form");
		String priceTemp = null;
		for (Element element : ele) {
			String preci = (element.getElementsByAttributeValue("itemprop", "price").text());
			if (!(preci.isEmpty())) {
				priceTemp = preci;
				}
			String categoria = element.getElementsByAttributeValue("itemprop", "category").text();
			if (!(categoria.isEmpty())) {
				category = categoria;
			}
		}
		StringToInt converter = new StringToInt ();
		price = converter.converter(priceTemp);
		Elements n = d.select("meta[property=og:title]");
		name = n.attr("content");
		
		Elements e = d.getElementsByAttributeValue("name", "ed");
		for (Element element : e) {
			String ex = element.getElementsByAttribute("selected").text();
			if (!(ex.isEmpty())) {
				expansion = ex;
			}
		}
		}} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}
	
	public double getPrice () {
		return this.price;
	}
	public String getCategory () {
		return this.category;
	}
	public String getName () {
		return this.name;
	}
	public String getExpansion() {
		return this.expansion;
	}
	public String getLink() {
		return this.link;
	}
	public void setAmount (int i) {
		this.amount = i;
	}
	
	public int getAmount () {
		return this.amount;
	}
	public String getAll () {
		return this.name +" " +this.expansion +" "+ this.category +" "+ this.price;
	}
}
