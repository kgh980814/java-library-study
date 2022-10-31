import com.aspose.pdf.*;


public class Pdf1 {
public static void main(String[] args) {
	// 문서 객체 초기화
	Document document = new Document();
	 
	//페이지 추가
	Page page = document.getPages().add();
	 
	// 새 페이지에 텍스트 추가
	page.getParagraphs().add(new TextFragment("Hello World!"));
	 
	// 업데이트된 PDF 저장
	document.save("HelloWorld_out.pdf");
}
}
