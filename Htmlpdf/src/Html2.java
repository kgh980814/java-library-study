import java.util.List;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.font.FontProvider;

public class Html2 {
public static void main(String[] args) {
	
	StringBuilder body = new StringBuilder();
	 
	String header = "<!DOCTYPE html>" + "<html lang='ko-KR'>" + "<head>" + "<titlet>test</title>"
	                + "	<meta charset='UTF-8'/>" + "	<meta name='description' content='Free Web tutorials'/>"
	                + "	<meta name='keywords' content='HTML,CSS,XML,JavaScript'/>"
	                + "	<meta name='viewport' content='width=device-width, initial-scale=1.0'/>"
	                + "	<meta http-equiv='X-UA-Compatible' content='IE=Edge'/>"
	                + "<script src='https://use.fontawesome.com/releases/v5.2.0/js/all.js'></script>" + "</head>";
	                
	String middle = "<body style='margin:auto; padding: 0;'>"
	                + "	<div class='logo' style='width: 780px;height: 40px;padding: 10px; margin: auto;'>"
	                + "		<a href='#' style='color: #000000;text-decoration: none;'><img src='img/logo.png' alt='로고'/></a>"
	                + "	</div>";

	String footer = "	<div class='footer' style='width: 780px;height: 60px;padding: 20px;text-align: center;font-size: 0.75em; margin: auto;'>"
	                + "	본 메일은 발신전용 입니다. 자세한 사항은 홈페이지를 확인해 주시기 바랍니다.	" + "	</div>" + "</body>" + "</html>";
	                
	body.append(header);
	body.append(middle);
	body.append(footer);

	String BODY = body.toString();

	// html to pdf
	try {
		makepdf(BODY, "sample.pdf");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static void makepdf(String BODY, String dest)throws Exception {
	 String FONT = "malgun.ttf";
	    //ConverterProperties : htmlconverter의 property를 지정하는 메소드인듯
	    ConverterProperties properties = new ConverterProperties();
	    FontProvider fontProvider = new DefaultFontProvider(false, false, false);
	    FontProgram fontProgram = FontProgramFactory.createFont(FONT);
	    fontProvider.addFont(fontProgram);
	    properties.setFontProvider(fontProvider);

		//pdf 페이지 크기를 조정
		List<IElement> elements = HtmlConverter.convertToElements(BODY, properties);
	    PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
	    Document document = new Document(pdf);
	    	//setMargins 매개변수순서 : 상, 우, 하, 좌
	        document.setMargins(50, 0, 50, 0);
	        for (IElement element : elements) {
	            document.add((IBlockElement) element);
	        }
	        document.close();
	
}
}
