package com.biz.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.oracle.sql.ScoreSumSQL;
import com.biz.oracle.vo.ScoreSumVO;
import com.biz.oracle.vo.ScoreVO;

public interface ScoreSumDao {

	@Select(ScoreSumSQL.SS_ALL)
	public List<ScoreSumVO> selectAll();
	
	@Select(ScoreSumSQL.SS_FIND_NUM)
	public ScoreSumVO FindStByNum(String st_num);

	public int insert(ScoreVO vo);

	
	
}
