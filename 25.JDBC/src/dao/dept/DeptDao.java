package dao.dept;



import java.util.List;
import java.util.Map;

/**
 * 
 * dept ���̺�� ���õ� ����Ͻ� �Ծ� �޼ҵ� ����
 *
 * @author  
 */
public interface DeptDao {
	// �μ� ���
	public void insert(Dept deparment) throws Exception;
	// �μ���ȣ�� �μ����� ��ȯ
	public Dept selectByNo(int deptno) throws Exception;
	// �μ� ��ü��� ��ȯ
	public List selectByAll() throws Exception;
	
}






