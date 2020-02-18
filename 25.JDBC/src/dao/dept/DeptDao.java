package dao.dept;



import java.util.List;
import java.util.Map;

/**
 * 
 * dept 테이블과 관련된 비즈니스 규약 메소드 선언
 *
 * @author  
 */
public interface DeptDao {
	// 부서 등록
	public void insert(Dept deparment) throws Exception;
	// 부서번호로 부서정보 반환
	public Dept selectByNo(int deptno) throws Exception;
	// 부서 전체목록 반환
	public List selectByAll() throws Exception;
	
}






