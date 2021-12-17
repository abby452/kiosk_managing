package loginSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * DBó�� ��ƼƼ�Դϴ�.
 * 
 * @Entity
 * @Getter
 * @author dlckd
 * @version 1.0
 */
public class idpass {
	/**
	 * ����url���Դϴ�
	 * @Url 
	 * @GerneratedValue
	 * ������ user���Դϴ�.
	 * @user
	 * @GeneratedValue
	 * ������ password���Դϴ�.
	 * @password
	 * @GeneratedValue
	 * ���̵� ��� url���� �޾ƿ��� conn�Դϴ�.
	 * @conn
	 * @GeneratedValue
	 * conn���� �̿��� ���Ӱ� �����Ǵ� statement�Դϴ�
	 * @stmt
	 * @GeneratedValue
	 */
	private String Url 				= "jdbc:oracle:thin:@localhost:1521:xe"; // URL ���� ���� ����
	private String user 			= "tiger"; // user ���� ���� ���� -> hr
	private String password 		= "1234"; // password ���� ���� ���� -> hr
	private Connection conn 		= null;
	private Statement stmt			= null;
	
	/**
	 * DB�� �����ϴ� ��ƼƼ�Դϴ�
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
	 * ���̵� ���� �޾ƿ��� ��ƼƼ�Դϴ�.
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
			System.out.println( "�ش� ID�� �����ϴ�." + e);
		}
		
		return t;
	}
	
	/**
	 * ���̵� �´� ����� �޾ƿ��� ��ƼƼ�Դϴ�,
	 * @Entity
	 * @Getter
	 * @param id
	 * @param pw
	 * @return
	 */
	public String getpw(String id,String pw) {
		String a = "";//���̵�
		String b = "";//���
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
			System.out.println( "�ش� PW�� �����ϴ�." + e);
		}
		if(pw_checking) {
			return pw;
		}
		else {
			return "0";
			}
		}
	
	}

