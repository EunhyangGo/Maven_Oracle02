package com.biz.oracle.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.biz.oracle.dao.ScoreDao;
import com.biz.oracle.dao.ScoreSumDao;
import com.biz.oracle.dao.StdDao;

public class OracleSqlFactory {
	

	SqlSessionFactory sessionFactory;
	
	public SqlSessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
public OracleSqlFactory() {
		
		Properties props = new Properties();
		
		props.put("DRIVER", DBContract.ORACLE_PROFILE.Driver);
		props.put("URL", DBContract.ORACLE_PROFILE.url);
		props.put("USER", DBContract.ORACLE_PROFILE.user);
		props.put("PASSWORD", DBContract.ORACLE_PROFILE.password);
		
		
		// DatasourceFactory 만드는
		DataSourceFactory dataSourceFactory = new StdDataSourceFactory();
		
		dataSourceFactory.setProperties(props);
		
		// DataSourceFactory로부터 DataSource를 요청
		DataSource dataSource = dataSourceFactory.getDataSource();
		
		// TransanctionFactory : 데이터를 대신 받아줄 중간 창고(공장)
		// 또하나의 공장을 만드는 함수
		// insert,update,delete,select(리스트갯수를 몇개인지 관계없이)를 할때에 
		// 중간에 데이터를 대신 받아주는 친구를 만들어주는것.
		TransactionFactory transactionFactory  = new JdbcTransactionFactory();
		
		// 내가 데이터베이스에 접속할 수 있는 환경을 만들어 주는것.
		// datasource와 transaction에서 골라 나만의 제조 조립 공장.
		Environment environment = new Environment("GradeEnv", transactionFactory, dataSource);
		
		Configuration config = new Configuration(environment);
		config.addMapper(StdDao.class);
		// 스코어 다오를 연결해주는것.
		config.addMapper(ScoreSumDao.class); // 스코어 다오를 사용할 준비를 해주는것.
		config.addMapper(ScoreDao.class);
		
		this.sessionFactory = new SqlSessionFactoryBuilder().build(config);
		
		
		
	}
}
