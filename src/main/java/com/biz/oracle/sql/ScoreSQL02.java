package com.biz.oracle.sql;

public class ScoreSQL02 {
	
	public static class SCORE{
		public static final String TABLE_NAME = "tbl_score";
		public static final String COLUMN_ID = "id";
		public static final String COLUMN_ST_NUM = "st_num";
		public static final String COLUMN_SC_SB_CODE = "sc_sb_code";
		public static final String COLUMN_SC_SCORE = "sc_score";
	}
	 

	public static final String SC_ALL = 
			" SELECT * FROM "+ SCORE.TABLE_NAME ;// socre ALL
	
	// 학생테이블하고 점수테이블하고 쪼인해서 연관된 데이터를 찾을떄
	public static final String SC_FIND_NUM = 
			" SELECT * FROM tbl_score WHERE st_num = #{st_num} ";
	
	public static final String SC_FIND_ID =
			String.format(" SELECT * FROM %s WHERE %s = #{%s} ",
					SCORE.TABLE_NAME, SCORE.COLUMN_ID,SCORE.COLUMN_ID);
			
	
	public static final String SC_INSERT =
	
	String.format(" INSERT INTO %1s(%$2s,%$3s,%$4s,%$5s) "
			+ " VALUES( SEQ_SCORE.NEXTVAL,#{%$2s},#{%$3s},#{%$4s},#{$5s})",
			SCORE.TABLE_NAME,
			SCORE.COLUMN_ID,
			SCORE.COLUMN_SC_SB_CODE,
			SCORE.COLUMN_ST_NUM,
			SCORE.COLUMN_SC_SCORE
			);
			
	public static final String SC_UPDATE =
			String.format(" UPDATE %$1s"
					+ " SET %$2s = #{%$2s}, %$3s = #{%$3s}, %$4s = #{%$4s}, "
					+ " WHERE %$5s = #{%$5s} ",
					SCORE.TABLE_NAME,
					SCORE.COLUMN_ST_NUM,
					SCORE.COLUMN_SC_SB_CODE,
					SCORE.COLUMN_SC_SCORE,
					SCORE.COLUMN_ID);
			
	
	public static final String SC_DELETE =
			String.format( "DELETE FROM %$1s WHERE %$2s = #{%$2s} ",
					SCORE.TABLE_NAME,SCORE.COLUMN_ID);
}
