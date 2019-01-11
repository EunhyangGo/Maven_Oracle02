package com.biz.oracle.sql;

public class StdSQL {

	public static final String STD_ALL =
			" SELECT * FROM tbl_student ";
	
	public static final String STD_FIND_NUM = // dao의 findnum이름과 같아야한다.
			" SELECT * FROM tbl_student WHERE st_num = #{st_num} ";
	
	public static final String STD_FINE_NAME =
			" SELECT * FROM tbl_student WHERE "
			+ " WHERE st_name = #{st_name} ";
	
	public static final String STD_INSERT =
			" INSERT INTO tbl_student(st_num, st_name, st_grade, st_tel) "
			+ " VALUES ( #{st_num}, #{st_name}, #{st_grade}, #{st_tel}) ";
	
	public static final String STD_UPDATE =
			" UPDATE tbl_student "
			+ " SET st_name = #{st_name}, "
			+ " st_grade = #{st_grade} "
			+ " st_tel = #{st_tel} "
			+ " WHERE st_num = #{st_num} "; 
	// primary key 값으로 지정한 num을 지정해야지 지정부분 업데이트가 진행된다.
	// where num(primary key값)을 지정하지 않으면 전체가 다 업데이트 되어 버린다.
	// delete도 마찬가지. where로 primary key값을 설정한 칼럼을 지정해줘야함.
	
	public static final String STD_DELETE =
			" DELETE tbl_student "
			+ " WHERE st_num = #{st_num} ";
			

}
