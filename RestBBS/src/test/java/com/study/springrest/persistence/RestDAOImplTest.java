package com.study.springrest.persistence;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.RestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class RestDAOImplTest {
	
	@Inject
	private RestDAO dao;
	
	@Test
	public void test(){System.out.println("DAO=" + dao);}

	@Test
	public void insertTest() throws Exception { 
		RestVO vo = new RestVO();
		vo.setTitle("Ÿ��Ʋ4");
		vo.setContent("����4");
		vo.setUser_name("����4");	
		dao.insert(vo);	
	}
	
	@Test
	public void updateTest() throws Exception { 
		RestVO vo = new RestVO();
		vo.setTitle("����Ÿ��Ʋ");
		vo.setContent("��������");
		vo.setUser_name("��������");	
		dao.update(vo);
	}
	
	@Test
	public void getTest() throws Exception { 
		RestVO vo = new RestVO();
		System.out.println("��ȣ: " + vo.getBoard_no());
	}
	
	@Test
	public void getListTest() throws Exception { 
		List<RestVO> list = dao.getList();
		Iterator<RestVO> it = list.iterator();
		while(it.hasNext()){
			RestVO vo = it.next();
			System.out.println("��ȣ: "+vo.getBoard_no());
		}
	}
	
	@Test
	public void deleteTest() throws Exception { 		
		dao.delete(3);	
	}

}
