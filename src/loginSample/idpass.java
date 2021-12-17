package loginSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * DB처리 엔티티입니다.
 * 
 * @Entity
 * @Getter
 * @author dlckd
 * @version 1.0
 */
public class idpass {
	/**
	 * 고유url값입니다
	 * @Url 
	 * @GerneratedValue
	 * 고유한 user값입니다.
	 * @user
	 * @GeneratedValue
	 * 고유한 password값입니다.
	 * @password
	 * @GeneratedValue
	 * 아이디 비번 url값을 받아오는 conn입니다.
	 * @conn
	 * @GeneratedValue
	 * conn값을 이용해 새롭게 생성되는 statement입니다
	 * @stmt
	 * @GeneratedValue
	 */
	private String Url 				= "jdbc:oracle:thin:@localhost:1521:xe"; // URL 정보 저장 변수
	private String user 			= "tiger"; // user 정보 저장 변수 -> hr
	private String password 		= "1234"; // password 정보 저장 변수 -> hr
	private Connection conn 		= null;
	private Statement stmt			= null;
	
	/**
	 * DB와 연결하는 엔티티입니다
	 * @Entity
	 * @Getter
	 * @author dlckd
	 * @return
	 */
	public Statement preDbTreatment() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(Url,user,password);
			stmt = conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
		return stmt;
	}
	
	/**
	 * 아이디 값을 받아오는 엔티티입니다.
	 * @Entity
	 * @Getter
	 * @param a
	 * @return
	 */
	public String id(String a){
		String t="";
		Statement stmt = preDbTreatment();
		try {
			ResultSet rs =  stmt.executeQuery("select * from member where NAME = '" + a + "'");
			while(rs.next()) {
				t = rs.getString("NAME");
			}
		}catch( SQLException e) {
			System.out.println( "해당 ID가 없습니다." + e);
		}
		
		return t;
	}
	
	/**
	 * 아이디에 맞는 비번을 받아오는 엔티티입니다,
	 * @Entity
	 * @Getter
	 * @param id
	 * @param pw
	 * @return
	 */
	public String getpw(String id,String pw) {
		String a = "";//아이디
		String b = "";//비번
		boolean pw_checking = false;
		Statement stmt;
		stmt = preDbTreatment();
		try {
			ResultSet rs = stmt.executeQuery("select * from member where NAME = '" + id + "'");
			while(rs.next()) {
				
				pw = rs.getString("PASSWORD");
				if(pw.equals(pw)) {
					pw_checking = true;
				}else {
					pw_checking = false;
				}
			}
		}catch( SQLException e) {
			System.out.println( "해당 PW가 없습니다." + e);
		}
		if(pw_checking) {
			return pw;
		}
		else {
			return "0";
			}
		}
	
	}

