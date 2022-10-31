import java.io.*;


import com.lowagie.text.*;
import com.lowagie.text.pdf.*;



public class Lowagie1 {
	public static void main(String[] args) throws Exception {

		String fileName = "simple_table.pdf";
		String dir = ".";

		File directory = new File(dir);
		if (!directory.exists())
			directory.mkdirs(); // 파일경로 없으면 생성

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(dir + "/" + fileName));

		// HYGoThic-Medium, HYSMyeongJo-Medium, HYSMyeongJoStd-Medium
	
		
		document.open();
		// 4) 한글 입력을 위해 폰트를 선택해줍니다. iTextAsian.jar에서는 다음 3개의 폰트를 사용할 수 있습니다.
		String fontFace = "HYGoThic-Medium";
		
		// 5) 글자 방향을 결정하는 CMap은 두가지가 있습니다. 
		// UniKS-UCS2-H : 가로, UniKS-UCS2-V : 세로
		String fontNameH = "UniKS-UCS2-H";
		
		BaseFont bf = BaseFont.createFont(fontFace, fontNameH, BaseFont.NOT_EMBEDDED);
		
		Font font = new Font(bf, 20);
		
		PdfPTable  table = new PdfPTable(4);

		for (int i = 0; i < 16; i++) {
			table.addCell(new Paragraph("셀 번호:"+i,font));
		}
		document.add(table);	
		document.close();
	}
}