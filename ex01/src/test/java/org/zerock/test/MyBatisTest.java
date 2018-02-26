package org.zerock.test;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//�Ʒ� �ΰ� �ֳ����̼��� �׽�Ʈ�� ������ �ε� �ϴ� ��ɹ�
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*root-context.xml"})


public class MyBatisTest {

	
	//��ü�� �����Ѵ�.���� ���� ȯ�濡���� �����ӿ�ũ, �����̳ʰ� ��ü�� �����ϴ� ������ �մϴ�. 
	//�������� ���� �۵��� ��� sqlFactory�� ���Խ��Ѵ޶�.
	//���Թ����� ������ �߻��Ѵٸ� root-context.xml �� SqlSessionFactoryBeand���� ������ �߻��� ���̴�.
	@Inject 
	private SqlSessionFactory sqlFactory;
	
	//�׽�Ʈ�� �ڵ带�ǹ��ϴ� �ֳ����̼�
	@Test
	public void testFactory(){
		
		System.out.println(sqlFactory);
		
	}
	//�׽�Ʈ�� �ڵ带 �ǹ��ϴ� �ֳ����̼�
	@Test
	public void testSession()throws Exception{ 
		//try-with ������ �̿��� ���� �����ͺ��̽����� ������ ����ϴ� ��ü�� SqlSession�� �����ϴ� �Լ�		
		try(SqlSession session = sqlFactory.openSession()){
			
			System.out.println(session);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}


