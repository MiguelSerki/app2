package PruebaWorkbook.app;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestJsoup {
private String link;
private Document document;

public TestJsoup(String link) {
	this.link = link;
}

public void connect () {
	try {
		document = Jsoup.connect (this.link).timeout(9000).get();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		Elements test = document.select("meta[name=description]");
		System.out.println(test.attr("content"));
}

public static void main(String[] args) {
	TestJsoup test = new TestJsoup ("http://www.mtgmintcard.com/mtg/singles/xln/eng-reg/growing-rites-of-itlimoc-itlimoc-cradle-of-the-sun");
	test.connect();
}
}