package com.biz.oracle.service;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.biz.oracle.dao.ScoreDao;
import com.biz.oracle.dao.ScoreSumDao;
import com.biz.oracle.db.OracleSqlFactory;
import com.biz.oracle.vo.ScoreSumVO;
import com.biz.oracle.vo.ScoreVO;

public class  ScoreService {
	SqlSessionFactory sessionFactory;
	Scanner scan;
	
	
	public ScoreService() {
		Properties props = new Properties();
		scan = new Scanner(System.in);
		
		OracleSqlFactory sqlFactory = new OracleSqlFactory();
		// sessionfactory에 orclesqlfactory의 getsessionfactory를 저장한것.
		this.sessionFactory = sqlFactory.getSessionFactory();
		
		
	}
	
	public int insert(ScoreSumVO vo) {
		SqlSession session = this.sessionFactory.openSession();
		ScoreSumDao dao = session.getMapper(ScoreSumDao.class);
		
		int ret = dao.insert(vo);
		
		
		//int ret = dao.insert(vo);
		session.commit();
		session.close();
		System.out.println(ret);
		return ret;
		
		
	}
	
	// 공장에서 나온 자동차를 이용하는것...흐음..
	public ScoreSumVO viewScoreSum(String st_num) {
		SqlSession session = this.sessionFactory.openSession();
		ScoreSumDao dao = session.getMapper(ScoreSumDao.class);
		
		ScoreSumVO vo = dao.FindStByNum(st_num);
		//System.out.println(vo);
		return vo;
		
	}
	

	// main에서 학번을 입력하면 보여주는 메서드
	// 학번을 매개변수로 받아 점수 리스트를 화면에 보이는 코드
	// 그 점수 리스트를 return하도록 작성
	public List<ScoreVO> viewScore(String st_num){
		// DB로부터 값을 가져오기
		SqlSession session = this.sessionFactory.openSession();
		
		// Dao 받기
		ScoreDao dao = session.getMapper(ScoreDao.class);
		
		List<ScoreVO> scList = dao.findByStNum(st_num);
		
		for(ScoreVO vo : scList) {
			System.out.println(vo);
		}
		return scList;
		
	}
}
