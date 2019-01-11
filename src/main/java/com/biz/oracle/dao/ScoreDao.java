package com.biz.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.oracle.sql.ScoreSQL;
import com.biz.oracle.vo.ScoreVO;

public interface ScoreDao {

	@Select(ScoreSQL.SC_ALL)
	public List<ScoreVO> seletAll(); //scoreVo를 리턴하게 해주는것
	
	// 리턴값이 vo인경우는 딱 하나, 테이블의 프라이머리키
	@Select(ScoreSQL.SC_FIND_ID)
	public ScoreVO findById(long id); //scorevo리턴
	
	// 리턴값이 여러개의 정보로 올 확률이 높기때문에 List<>로 리턴값.
	@Select(ScoreSQL.SC_FIND_NUM)
	public List<ScoreVO> findByStNum(String st_num);
	
	@Insert(ScoreSQL.SC_INSERT)
	public int insert(ScoreVO vo); // scorevo를 매개변수로 받고 int return

	@Update(ScoreSQL.SC_UPDATE)
	public int update(ScoreVO vo);
	
	@Delete(ScoreSQL.SC_DELETE)
	public int delete(long id); // int로 return
}
