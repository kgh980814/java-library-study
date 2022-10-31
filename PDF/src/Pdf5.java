import com.aspose.pdf.*;

public class Pdf5 {
public static void main(String[] args) {
	// 전체 예제 및 데이터 파일을 보려면 https://github.com/aspose-pdf/Aspose.Pdf-for-Java로 이동하십시오.
	// 문서 열기
	Document pdfDocument = new Document("input.pdf");

	// 필드 만들기
	TextBoxField textBoxField1 = new TextBoxField(pdfDocument.getPages().get_Item(1), new Rectangle(100, 200, 300, 300));

	// 필드 이름 설정
	textBoxField1.setPartialName("textbox1");

	// 필드 값 설정
	textBoxField1.setValue("Text Box");

	// 테두리 개체 만들기
	Border border = new Border(textBoxField1);

	// 테두리 너비 설정
	border.setWidth(5);

	// 테두리 대시 스타일 설정
	border.setDash(new Dash(1, 1));

	// 필드 테두리 설정
	textBoxField1.setBorder(border);

	// 문서에 필드 추가
	pdfDocument.getForm().add(textBoxField1, 1);

	// 수정된 PDF 저장
	pdfDocument.save("output.pdf");
}
}
