package com.biz.oracle.vo;

import lombok.Data;

/*
 * Lombok 플러그인을 이클립스에 설치해서 
 * VO클래스의 getter setter 생성자, toString등의 작성을
 * 대신 하도록 만들었다.
 * pom.xml의 dependencies에 가서 maven repository에서 
 */
@Data
public class ScoreVO {
	
	
	  private long id ;
      private String st_num ;
      private String sc_sb_code; 
      private int sc_score ;
      
      
      
      
	
	
}
