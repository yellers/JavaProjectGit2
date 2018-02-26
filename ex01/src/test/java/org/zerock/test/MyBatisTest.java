package org.zerock.test;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//아래 두개 애노테이션은 테스트시 스프링 로드 하는 명령문
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*root-context.xml"})


public class MyBatisTest {

	
	//객체를 주입한다.실제 실행 환경에서는 프레임워크, 컨테이너가 객체를 조립하는 역할을 합니다. 
	//스프링이 정상 작동할 경우 sqlFactory를 주입시켜달라.
	//주입문에서 에러가 발생한다면 root-context.xml 의 SqlSessionFactoryBeand에서 문제가 발생한 것이다.
	@Inject 
	private SqlSessionFactory sqlFactory;
	
	//테스트용 코드를의미하는 애노테이션
	@Test
	public void testFactory(){
		
		System.out.println(sqlFactory);
		
	}
	//테스트용 코드를 의미하는 애노테이션
	@Test
	public void testSession()throws Exception{ 
		//try-with 구문을 이용한 실제 데이터베이스와의 연결을 담당하는 객체인 SqlSession을 생성하는 함수		
		try(SqlSession session = sqlFactory.openSession()){
			
			System.out.println(session);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}


