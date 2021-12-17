package swingTableSample.tableDemo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class JdbcVectorTableEvnetSample extends JFrame {

	/**
	 * GeneratedValue
	 * ���� : ����ȭ�� �ʿ��� ���� ����
	 * @param serialVersionUID 	������
	 * ���� : ���̺� ǥ�õ� �����͸� �����ϴ� ���� ���� ����
	 * @ data	������
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@SuppressWarnings("rawtypes")
	private Vector data 			= null;

	
	/**
	 * @title		Ÿ��Ʋ ������
	 * @GeneratedValue
	 * ���� : ���̺� ǥ�õ� Ÿ��Ʋ�� �����ϴ� ���� ���� ����
	 */
	@SuppressWarnings("rawtypes")
	private Vector title 			= null;
	private JTable table 			= null;


	/**
	 * @ table		���̺� ������
	 * @GeneratedValue
	 * ���� : ���̺� ǥ�õ� Ÿ��Ʋ�� �����͸� �����ϴ� �� ��ü ���� ����
	 */
	private DefaultTableModel model = null;


	/**
	 * @ btnAdd 	��ư��ü ������
	 * @GeneratedValue
	 * ���� : �߰� ��ư ��ü ���� ����
	 */
	private JButton btnAdd 			= null;


	/**
	 * @ btnDel	������ư��ü ������
	 * @GeneratedValue
	 * ���� : ���� ��ư ��ü ���� ����
	 */
	private JButton btnDel 			= null;

	
	/**
	 * @ btnUpdate		������ư ��ü ������
	 * @GeneratedValue
	 * ���� : ���� ��ư ��ü ���� ����
	 */
	private JButton btnUpdate		= null;

	
	/**
	 * @ btnClear	�ʱ�ȭ ��ư ��ü ������
	 * @GeneratedValue
	 * ���� : �ʱ�ȭ ��ư ��ü ���� ����
	 */
	private JButton btnClear		= null;


	/**
	 * @ tfCode		��ǰ�ڵ带 ǥ���ϴ� �ؽ�Ʈ �ʵ� ������
	 * @GeneratedValue
	 * ���� : ��ǰ�ڵ带 ǥ���ϴ� TextField  ���� ����
	 */
	private JTextField tfCode		= null;


	/**
	 * @tfName	�̸��� ǥ���ϴ� �ؽ�Ʈ�ʵ� ������
	 * @GeneratedValue
	 * ���� : �̸��� ǥ���ϴ� TextField ���� ����
	 */
	private JTextField tfName		= null;

	
	/**
	 * @tfcount ������ ǥ���ϴ� �ؽ�Ʈ�ʵ� ������
	 * @GeneratedValue
	 * ���� : ������ ǥ���ϴ� TextField ���� ����
	 */
	private JTextField tfcount	= null;

	
//	���̺� ���� ����
	private JLabel	lblCode			= null;
	private JLabel	lblName			= null;
	private JLabel	lblcount		= null;

	
	/**
	 * @Url url�������庯��
	 * @GeneratedValue
	 * ���� : �����ͺ��̽� ������ �ʿ��� URL �����ϴ� ������ ���� ����
	 */
	private String Url 				= "jdbc:oracle:thin:@localhost:1521:xe"; // URL ���� ���� ����
	private String user 			= "pang"; // user ���� ���� ���� -> hr
	private String password 		= "1234"; // password ���� ���� ���� -> hr

	
	/**
	 * @conn	�����ͺ��̽� ���� ��ü ���� ����
	 * @GeneratedValue
	 * ���� : �����ͺ��̽� ���� Connection ��ü ���� ����
	 */
	private Connection conn 		= null;

	
	/**
	 * @stmt	������� ���� ����
	 * @GeneratedValue
	 * ���� : �����ͺ��̽� ���� �� ���� ����� ���ϴ� Statement ��ü ���� ����
	 */
	private Statement stmt			= null;

	
	/**
	 * @pstmtAdd	�߰������� ����� �������� ����
	 * @GeneratedValue
	 * ���� : �߰�(insert) ���� �����ϴ� PreparedStatement ��ü ���� ����
	 */
	private PreparedStatement pstmtAdd    = null;

	
	/**
	 * @pstmtDel	���� ������ ����� �������� ����
	 * @GeneratedValue
	 * ���� : ����(delete) ���� �����ϴ� PreparedStatement ��ü ���� ����

	 */
	private PreparedStatement pstmtDel    = null;
	
	/**
	 * @pstmtUpdate	���������� ����� ���� ���� ����
	 * @GeneratedValue
	 * ���� : ����(update) ���� �����ϴ� PreparedStatement ��ü ���� ����
	 */
	private PreparedStatement pstmtUpdate = null;
	
	/**
	 *
	 * ���� : Frame �ʱ�ȭ, �г� ����, ���̺� ����, �� ����, ȭ�鿡 �ʿ��� ������Ʈ ���� �� 
	 *        �ʱ�ȭ 
	 * 
	 */
	public JdbcVectorTableEvnetSample() {
		super("JdbcTable ���� Sample");


//		�����ͺ��̽� ���� Connection, Statement, 
//		������ PreparedStatement ����, �ʱ�ȭ �޼ҵ� , �߿� Ȯ�� �ʿ�
		preDbTreatment();


//		���̺� ǥ�õ� ������ ���� ����
		data = new Vector<>();


//		���̺� ǥ�õ� Ÿ��Ʋ ���� ����, �ʱ�ȭ 
		title = new Vector<>();
		title.add("��ǰ�ڵ�");
		title.add("��ǰ��");
		title.add("����");

		
//		���̺� ǥ�õ� �� ��ü ����
		model = new DefaultTableModel();

		
//		selectAll() : �����ͺ��̽�  Member ���̺� �ִ� ��� �����͸� ������ ���� �޼ҵ�
//		���� result�� ����
		Vector result = selectAll();


//		�𵨿� ����� ������(result)�� ���� ����
		model.setDataVector(result, title);

		
//		���� ���� ���̺� ����
		table = new JTable(model);

		
//		���̺� ��ũ���� ���� 
		JScrollPane sp = new JScrollPane(table);	

//		���̺� ���콺 Ŭ��(mouseClicked)�� ó���� �̺�Ʈ ���

		table.addMouseListener(new MouseAdapter() {
//			���콺 Ŭ���� ó���� ����ϴ� �޼ҵ� ������

			@Override
			public void mouseClicked(MouseEvent e) {
//				getSelectedRow() : ���̺��� ���õ� ���� ���� ������ ���� �޼ҵ�(0���� ���۵�) 
				int index = table.getSelectedRow();

				
//				���� ���̺� ǥ�õǰ� �ִ� data(��)���� index(���� ���õ� �ٰ�)�� 
//				1���� ���ڵ�(��) ��ü�� ���ͷ� �����ؼ� in ���� ������ ����
				Vector in = (Vector) data.get(index);

				
//				in ���Ϳ� ����ִ� ���� ������ String ������ ���� 
				String num = (String)in.get(0);
				String name = (String)in.get(1);
				String count = (String)in.get(2);

				

//				ȭ�鿡 ǥ�õ� ������ TextField(��ǰ�ڵ�, �̸�, ����)�� 
//				�� setting
				tfCode.setText(num);
				tfName.setText(name);
				tfcount.setText(count);

				
//				��ǰ�ڵ�� setEditable(false)�� ���� ���� ó��
				tfCode.setEditable(false);
//				tfName.setEditable(false);
//				tfcount.setEditable(false);
			}
		});

		

//		ȭ�鿡 ǥ�õ� �г� ����
		JPanel panel = new JPanel();
		

//		���� �Է¹ްų� ǥ���� �ؽ�Ʈ�ʵ�(��ǰ�ڵ�, ��ǰ��, ����) ����
		tfCode = new JTextField(8);
		tfName = new JTextField(10);
		tfcount = new JTextField(20);


//		���̺� ����
		lblCode = new JLabel("��ǰ�ڵ�");
		lblName = new JLabel("��ǰ��");
		lblcount = new JLabel("����");

		

//		��ư(�߰�, ����, ����, �ʱ�ȭ) ����
		btnAdd = new JButton("�߰�");
		btnDel = new JButton("����");
		btnUpdate = new JButton("����");
		btnClear = new JButton("�ʱ�ȭ");

		
//		�߰���ư�� �̺�Ʈ(Ŭ����) ó�� -> �ؽ�Ʈ�ʵ忡 �Էµ� ������ �����ͺ��̽��� 
//		����(Insert)�ϴ� ����
		btnAdd.addActionListener(new ActionListener() {


//			actionPerformed(ActionEvent e) : �߰� ��ư Ŭ���� ȣ��� �޼ҵ�
//			�߰���ư�� Ŭ���ϸ� ó���� ���� �ۼ�
			@Override

			public void actionPerformed(ActionEvent e) {
//				���� �ؽ�Ʈ �ʵ忡 �ִ� ���� ������ ������ ���� 
				String num = tfCode.getText(); // ��ǰ�ڵ�
				String name = tfName.getText(); // �̸�
				String count = tfcount.getText(); // ����


				
//				������ ������ ����� ���� �����ͺ��̽��� Insert�ϴ� �޼ҵ�
				insert(num, name, count);

				
//				�ű� ����� �����͸� �����ͺ��̽����� �ٽ� �о�ͼ� result ���Ϳ� ���� 
				Vector result = selectAll();

				
//				����� ������(����)�� �� ���� -> ���̺� ǥ�� ���ŵ� 
				model.setDataVector(result, title);
			}
		});

		

//		���� ��ư�� �̺�Ʈ(Ŭ����) ó�� -> �ؽ�Ʈ �ʵ忡 �Էµ� ��ǰ�ڵ尪���� �����ͺ��̽��� 
//		�ش� ��ǰ�ڵ��� ���ڵ带 ����(Delete) �ϴ� ����

		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

//				�ؽ�Ʈ�ʵ忡 �ִ� ��ǰ�ڵ尪 ������ ����
				String num = tfCode.getText();

//				��ǰ�ڵ尪���� �����ͺ��̽����� �ش� ��ũ�带 �����ϴ� �޼ҵ�
				delete(num);

//				����ó�� �����͸� �����ͺ��̽����� �ٽ� �о�ͼ� result ���Ϳ� ���� 
				Vector result = selectAll();
			
//				����� ������(����)�� �� ���� -> ���̺� ǥ�� ���ŵ�
				model.setDataVector(result, title);
			}
		});


//		������ư�� �̺�Ʈ(Ŭ����) ó�� -> �ؽ�Ʈ �ʵ忡 �Էµ� ��ǰ�ڵ尪���� �����ͺ��̽���
//		�ش� ��ǰ�ڵ��� ��ũ�带 ����(Update) �ϴ� ���� 
		btnUpdate.addActionListener(new ActionListener() {	

			@Override
			public void actionPerformed(ActionEvent e) {
//				�ؽ�Ʈ�ʵ忡 �ִ� ������ ������ ����
				String num = tfCode.getText();
				String name = tfName.getText();
				String count = tfcount.getText();
				


//				��ǰ�ڵ带 �������� ������ �̸��� ������ �����ϴ� �޼ҵ� 
				update(name, count, num);


//				����ó�� �����͸� �����ͺ��̽����� �ٽ� �о�ͼ� result ���Ϳ� ���� 
				Vector result = selectAll();


//				����� ������(����)�� �� ���� -> ���̺� ǥ�� ���ŵ�
				model.setDataVector(result, title);

			}
		});

		

//		�ʱ�ȭ ��ư �̺�Ʈ(Ŭ����) ó�� -> �ؽ�Ʈ�ʵ� �ʱ�ȭ, ��ǰ�ڵ��ؽ�Ʈ�ʵ忡 Ŀ�� ��ġ
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				�ʱ�ȭ
				tfCode.setText("");
				tfName.setText("");
				tfcount.setText("");

//				���������ϰ� ����
				tfCode.setEditable(true);
				tfName.setEditable(true);
				tfcount.setEditable(true);
//				��ǰ�ڵ��ؽ�Ʈ�ʵ忡 Ŀ�� ��ġ
				tfCode.requestFocus();
			}
		});
		

//		�гο� ������ ���̺�� �ؽ�Ʈ�ʵ� �߰�
		panel.add(lblCode);
		panel.add(tfCode);
		panel.add(lblName);
		panel.add(tfName);
		panel.add(lblcount);
		panel.add(tfcount);

		
//		�гο� ��ư �߰�
		panel.add(btnAdd);
		panel.add(btnDel);
		panel.add(btnUpdate);
		panel.add(btnClear);


//		Frame�� ContentPane �����̳� ��������
		Container c = getContentPane();


//		�����̳ʿ� ���̺�, �г�(�ؽ�Ʈ�ʵ�, ��Ʈ�� ���Ե� �г�) �߰�
		c.add(new JLabel("JDBC Table Demo", JLabel.CENTER),"North");
		c.add(sp,BorderLayout.CENTER);
		c.add(panel, BorderLayout.SOUTH);

		
//		������ ����� ó���� �̺�Ʈ ó�� 
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent w) {
				try{
					stmt.close(); // Statement ��ü �ݱ�
					conn.close(); // Connection ��ü �ݱ�
					
					setVisible(false); // ȭ�� �ݱ�
					dispose(); // �ڿ� �ݳ�
					System.exit(0); // ���� ó��
				} catch(Exception e){
				}
			}
		});	
	}

	

	/**
	 * @Method Name : selectAll
	 * @return : data  
	 * ���� : �����ͺ��̽����� �˻��� �����͸� data Vector�� ��� ����
	 */
	private Vector selectAll() {
		data.clear();
		try{
			ResultSet rs = stmt.executeQuery("select * from member order by num");
			while(rs.next()){
				Vector in = new Vector<String>(); // 1���� ���ڵ� �����ϴ� ���� ����

				String num = rs.getString(1); // �����ͺ��̽����� ��ǰ�ڵ尪 ������ �ͼ� num ������ ����
//				String num = rs.getString("num");

				String name = rs.getString(2); // �����ͺ��̽����� �̸��� ������ �ͼ� name ������ ����
//				String name = rs.getString("name");

				String count = rs.getString(3); // �����ͺ��̽����� ������ ������ �ͼ� count ������ ����
//				String count = rs.getString("count");

//				���Ϳ� ������ �� �߰�
				in.add(num);
				in.add(name);
				in.add(count);


//				��ü �����͸� �����ϴ� ���Ϳ� in(1���� ������ ����) ���� �߰�
				data.add(in);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return data; // ��ü ������ �����ϴ� data ���� ����
	}


	/**
	 * @Method Name : insert
	 * @param num :��ǰ�ڵ� �ؽ�Ʈ�ʵ忡 �Է¹��� �� 
	 * @param name : �̸� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * @param count : ���� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * ���� : ������ �ؽ�Ʈ�ʵ忡 �Էµ� ���� �Ķ���ͷ� �޾Ƽ� �����ͺ��̽��� 
	 *        insert ó���ϴ� �޼ҵ�
	 */

	private void insert(String num, String name, String count){
		try{
//			PreparedStatement ����-> conn�� preDbTreatment() �޼ҵ带 ���� �����Ǿ� ����
			pstmtAdd = conn.prepareStatement("insert into member values(?,?,?)");


//			insert into member values(? -> 1 ,? -> 2, ? -> 3)" ������ ? �� �� ����
			pstmtAdd.setString(1, num);
			pstmtAdd.setString(2, name);
			pstmtAdd.setString(3, count);

			
//			���Թ��� ������ ���� -> �Է� (insert)
			pstmtAdd.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	

	/**
	 * @Method Name : delete
	 * @param num : ��ǰ�ڵ� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * ���� : ��ǰ�ڵ尪�� �Ķ���͸� �޾� �ش� ��ǰ�ڵ��� �����͸� ��񿡼� ����(delete) �ϴ� �޼ҵ� 
	 */

	private void delete(String num){

		try{

//			PreparedStatement ����-> conn�� preDbTreatment() �޼ҵ带 ���� �����Ǿ� ����
			pstmtDel = conn.prepareStatement("delete from member where num = ?");

//			num ���� ���ؼ� ������
 			pstmtDel.setString(1, num);

// 			���Թ��� ������ ����-> ���� (delete)
			pstmtDel.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	

	/**
	 * @Method Name : update
	 * @param name : �̸� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * @param count : ���� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * @param num : ��ǰ�ڵ� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * ���� : ������ �ؽ�Ʈ�ʵ忡 �Էµ� ���� �Ķ���ͷ� �޾Ƽ� �����ͺ��̽��� 
	 *        �ش� ��ǰ�ڵ尪���� �̸��� ������ �����ϴ� �޼ҵ� 
	 */
	private void update(String name, String count, String num){
		try{
//			PreparedStatement ����-> conn�� preDbTreatment() �޼ҵ带 ���� �����Ǿ� ����
			pstmtUpdate = conn.prepareStatement("update member set name = ?, count = ? where num = ?");
//			�� ����
			pstmtUpdate.setString(1, name);
			pstmtUpdate.setString(2, count);
//			? ���� �߿� Ȯ�� �ʿ���
			pstmtUpdate.setString(3, num);
//			���� ����
			pstmtUpdate.executeUpdate();	

		}catch(Exception e){
			e.printStackTrace();
		}
	}


	/**
	 * @Method Name : preDbTreatment
	 * ���� : �����ͺ��̽� ���� �� Connection, Statement ����
	 */
	private void preDbTreatment() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(Url,user,password);
			stmt = conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		JdbcVectorTableEvnetSample frame = new JdbcVectorTableEvnetSample();
//		���� ������Ʈ�� ũ��� ���� ���¿� ���� �������� ũ�⸦ ����
		frame.pack();	
		frame.setVisible(true);
	}
}