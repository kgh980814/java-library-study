import java.io.IOException;

import com.aspose.pdf.*;
import com.aspose.pdf.Operator.*;
import com.aspose.pdf.operators.ConcatenateMatrix;
import com.aspose.pdf.operators.Do;
import com.aspose.pdf.operators.GRestore;
import com.aspose.pdf.operators.GSave;

public class Pdf3 {
	public static void main(String[] args) throws IOException {
		// 전체 예제 및 데이터 파일을 보려면 https://github.com/aspose-pdf/Aspose.Pdf-for-Java로 이동하십시오.
		// 문서 열기
		Document pdfDocument1 = new Document("input.pdf");

		// 좌표 설정
		int lowerLeftX = 100;
		int lowerLeftY = 100;
		int upperRightX = 200;
		int upperRightY = 200;

		// 이미지를 추가할 페이지를 가져옵니다.
		Page page = pdfDocument1.getPages().get_Item(1);

		// 스트림에 이미지 로드
		java.io.FileInputStream imageStream = new java.io.FileInputStream(new java.io.File("coffee3.jpg"));

		// 페이지 리소스의 이미지 컬렉션에 이미지 추가
		page.getResources().getImages().add(imageStream);

		// GSave 연산자 사용: 이 연산자는 현재 그래픽 상태를 저장합니다.
		page.getContents().add(new GSave());

		// Rectangle 및 Matrix 객체 만들기
		Rectangle rectangle = new Rectangle(lowerLeftX, lowerLeftY, upperRightX, upperRightY);
		Matrix matrix = new Matrix(new double[] { rectangle.getURX() - rectangle.getLLX(), 0, 0, rectangle.getURY() - rectangle.getLLY(), rectangle.getLLX(), rectangle.getLLY() });

		// ConcatenateMatrix(행렬 연결) 연산자 사용: 이미지를 배치하는 방법을 정의합니다.
		page.getContents().add(new ConcatenateMatrix(matrix));
		XImage ximage = page.getResources().getImages().get_Item(page.getResources().getImages().size());

		// Do 연산자 사용: 이 연산자는 이미지를 그립니다.
		page.getContents().add(new Do(ximage.getName()));

		// GRestore 연산자 사용: 이 연산자는 그래픽 상태를 복원합니다.
		page.getContents().add(new GRestore());

		// 새 PDF 저장
		pdfDocument1.save("Updated_document.pdf");

		// 이미지 스트림 닫기
		imageStream.close();
	}
}
