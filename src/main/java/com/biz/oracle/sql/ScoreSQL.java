package com.biz.oracle.sql;

public class ScoreSQL {
	
	

	public static final String SC_ALL = 
			" SELECT * FROM tbl_score ";// socre ALL
	
	// 학생테이블하고 점수테이블하고 쪼인해서 연관된 데이터를 찾을떄
	public static final String SC_FIND_NUM = 
			" SELECT * FROM tbl_score WHERE st_num = #{st_num} ";
	
	public static final String SC_FIND_ID =
			" SELECT * FROM tbl_score WHERE id = #{id}  ";
	
	public static final String SC_INSERT =
			" INSERT INTO tbl_score(id, st_num, sc_sb_code, sc_score) "
			+ " VALUES ( SEQ_SCORE.NEXTVAL #{id}, #{st_num}, #{sc_sb_code}, #{sc_score}) ";
	
	public static final String SC_UPDATE =
			" UPDATE tbl_score "
			+ " SET st_num = #{st_num}, "
			+ " sc_sb_code = #{sc_sb_code}, "
			+ " sc_score = #{sc_score} "
			+ " WHERE id = #{id} ";
	
	public static final String SC_DELETE =
			" DELETE tbl_socre "
			+ " WHERE id = #{id} ";
}
