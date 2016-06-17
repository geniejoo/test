package com.study.springrest.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.springrest.domain.RestVO;

@Repository			//¿˙¿Âº“
public class RestDAOImpl implements RestDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String namespace ="com.study.springrest.mappers.restMapper";
	
	@Override
	public void insert(RestVO vo){
		sqlSession.insert(namespace + ".insert", vo);
	}
	
	@Override
	public void increaseReply(int board_no){
		sqlSession.update(namespace + ".increaseReply", board_no);
	}

	@Override
	public RestVO get(int board_no) {
		return sqlSession.selectOne(namespace+".get", board_no);
	}

	@Override
	public List<RestVO> getList() {
		return sqlSession.selectList(namespace+".getList");
	}
	
	@Override
	public void update(RestVO vo){
		sqlSession.update(namespace + ".update", vo);
	}
	
	@Override
	public void delete(int board_no){
		sqlSession.delete(namespace + ".delete", board_no);
	}
	
}
	
