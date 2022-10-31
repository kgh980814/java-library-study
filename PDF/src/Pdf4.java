import com.aspose.pdf.*;

public class Pdf4 {
public static void main(String[] args) {
	String dataDir = "./";
	// 전체 예제 및 데이터 파일을 보려면 https://github.com/aspose-pdf/Aspose.Pdf-for-Java로 이동하십시오.
	// 원본 PDF 문서 로드
	Document doc = new Document(dataDir  + "input.pdf");
	// 테이블의 새 인스턴스를 초기화합니다.
	Table table = new Table();
	// 테이블 테두리 색상을 LightGray로 설정
	table.setBorder(new BorderInfo(BorderSide.All, .5f, Color.getLightGray()));
	// 표 셀의 테두리 설정
	table.setDefaultCellBorder(new BorderInfo(BorderSide.All, .5f, Color.getLightGray()));
	// 10개의 행을 추가하는 루프 생성
	for (int row_count = 1; row_count < 10; row_count++) {
		// 테이블에 행 추가
		Row row = table.getRows().add();
		// 표 셀 추가
		row.getCells().add("Column (" + row_count + ", 1)");
		row.getCells().add("Column (" + row_count + ", 2)");
		row.getCells().add("Column (" + row_count + ", 3)");
	}
	// 입력 문서의 첫 페이지에 테이블 개체 추가
	doc.getPages().get_Item(1).getParagraphs().add(table);
	// 테이블 개체가 포함된 업데이트된 문서 저장
	doc.save(dataDir + "document_with_table.pdf");
}
}
