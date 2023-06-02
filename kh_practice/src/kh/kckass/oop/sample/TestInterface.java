package kh.kckass.oop.sample;
import java.util.List;

public interface TestInterface {
	public final int MAXCNT=10;
	void method1(); //능력단위별 평가
	String method2(); //평가안내
	public int method3(int a,int b); //평가리뷰 
	public int method();
	int insertBoard(Car vo);
	int deleteBoard(Car vo);
	int updateBoard(Car vo);
	int selectOne(int boardNo);
	Car[] selectList();
	Car[] selectList(String searchWord);
	List<Car> selectListList(String searchWord);
	Car[] searchSelectBoard(String word);
}
