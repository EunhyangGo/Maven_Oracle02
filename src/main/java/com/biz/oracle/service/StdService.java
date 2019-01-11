package com.biz.oracle.service;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.biz.oracle.dao.StdDao;
import com.biz.oracle.db.OracleSqlFactory;
import com.biz.oracle.db.StdDataSourceFactory;
import com.biz.oracle.vo.StdVO;

// mybatis에서 datafactory까지 연결하는 준비과정
public class StdService {

	SqlSessionFactory sessionFactory;
	Scanner scan;
	
	public StdService() {
		
		Properties props = new Properties();
		scan = new Scanner(System.in);
		
		OracleSqlFactory sqlFactory = new OracleSqlFactory();
		// sessionfactory에 orclesqlfactory의 getsessionfactory를 저장한것.
		this.sessionFactory = sqlFactory.getSessionFactory();
		
	}
	
	public void insert() {
		StdVO vo = stdInfoInput();
		if(vo ==null)return;
		
		SqlSession session = this.sessionFactory.openSession();
		StdDao dao = session.getMapper(StdDao.class);
		//getMapper해서 stddao.class를 가져온것.
		
		int ret = dao.insert(vo);
		
		session.commit();
		session.close();
		
		if(ret >0) {
			System.out.println("추가 성공 !!!");
		}else {
			System.out.println("입력 실패 !!!");
		}
	
	
	}
	
	private StdVO stdInfoInput() {
		// 외부 vo에 넘겨주도록 stdVO를 설정
		System.out.println("===========================");
		System.out.println(" 학생정보 입력(0:종료) >>");
		System.out.println("---------------------------");
		
		System.out.println(" 학번 >>");
		String st_num = scan.nextLine();
		if(st_num.equals("0")) return null;
		
		System.out.println(" 이름 >>");
		String st_name = scan.nextLine();
		
		System.out.println(" 학년 >>");
		String st_grade = scan.nextLine();
		
		System.out.println(" 전화번호 >>");
		String st_tel = scan.nextLine();
		
		
		StdVO vo = new StdVO();
		vo.setSt_num(st_num);
		vo.setSt_name(st_name);
		vo.setSt_grade(st_grade);
		vo.setSt_tel(st_tel);
		
	
		return vo; // vo를 외부에 return
				
	}
	
	public void update() {
		StdVO vo = stdInfoInput();
		if(vo ==null)return;
		
		SqlSession session = this.sessionFactory.openSession();
		StdDao dao = session.getMapper(StdDao.class);
		//getMapper해서 stddao.class를 가져온것.
		
		int ret = dao.update(vo);
		
		session.commit();
		session.close();
		
		if(ret >0) {
			System.out.println("추가 성공 !!!");
		}else {
			System.out.println("입력 실패 !!!");
		}
	
	
	}
	

	public void stdView() {
		// TODO Auto-generated method stub
		
		SqlSession session = this.sessionFactory.openSession();
		StdDao dao = session.getMapper(StdDao.class);
		
		List<StdVO> stdList = dao.selectAll();
		
		for(StdVO vo : stdList) {
			System.out.println(vo);
		}
		
	}

	public StdVO stdView(String st_num) {
		// TODO Auto-generated method stub
		
		SqlSession session = this.sessionFactory.openSession();
		StdDao dao = session.getMapper(StdDao.class);
		
		StdVO vo = dao.findByNum(st_num);
		
		return vo;
	}
	
	
}
