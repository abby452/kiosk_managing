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
	 * @ tfItemCode		��ǰ�ڵ带 ǥ���ϴ� �ؽ�Ʈ �ʵ� ������
	 * @GeneratedValue
	 * ���� : ��ǰ�ڵ带 ǥ���ϴ� TextField  ���� ����
	 */
	private JTextField tfItemCode		= null;


	/**
	 * @tfItemName	�̸��� ǥ���ϴ� �ؽ�Ʈ�ʵ� ������
	 * @GeneratedValue
	 * ���� : �̸��� ǥ���ϴ� TextField ���� ����
	 */
	private JTextField tfItemName		= null;

	
	/**
	 * @tfSelectedItemNum ������ ǥ���ϴ� �ؽ�Ʈ�ʵ� ������
	 * @GeneratedValue
	 * ���� : ������ ǥ���ϴ� TextField ���� ����
	 */
	private JTextField tfSelectedItemNum	= null;

	
//	���̺� ���� ����
	private JLabel	lblItemCode			= null;
	private JLabel	lblItemName			= null;
	private JLabel	lblSelectedItemNum		= null;

	
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
				String ItemCode = (String)in.get(0);
				String ItemName = (String)in.get(1);
				String SelectedItemNum = (String)in.get(2);

				

//				ȭ�鿡 ǥ�õ� ������ TextField(��ǰ�ڵ�, �̸�, ����)�� 
//				�� setting
				tfItemCode.setText(ItemCode);
				tfItemName.setText(ItemName);
				tfSelectedItemNum.setText(SelectedItemNum);

				
//				��ǰ�ڵ�� setEditable(false)�� ���� ���� ó��
				tfItemCode.setEditable(false);
//				tfItemName.setEditable(false);
//				tfSelectedItemNum.setEditable(false);
			}
		});

		

//		ȭ�鿡 ǥ�õ� �г� ����
		JPanel panel = new JPanel();
		

//		���� �Է¹ްų� ǥ���� �ؽ�Ʈ�ʵ�(��ǰ�ڵ�, ��ǰ��, ����) ����
		tfItemCode = new JTextField(8);
		tfItemName = new JTextField(10);
		tfSelectedItemNum = new JTextField(20);


//		���̺� ����
		lblItemCode = new JLabel("��ǰ�ڵ�");
		lblItemName = new JLabel("��ǰ��");
		lblSelectedItemNum = new JLabel("����");

		

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
				String ItemCode = tfItemCode.getText(); // ��ǰ�ڵ�
				String ItemName = tfItemName.getText(); // �̸�
				String SelectedItemNum = tfSelectedItemNum.getText(); // ����


				
//				������ ������ ����� ���� �����ͺ��̽��� Insert�ϴ� �޼ҵ�
				insert(ItemCode, ItemName, SelectedItemNum);

				
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
				String ItemCode = tfItemCode.getText();

//				��ǰ�ڵ尪���� �����ͺ��̽����� �ش� ��ũ�带 �����ϴ� �޼ҵ�
				delete(ItemCode);

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
				String ItemCode = tfItemCode.getText();
				String ItemName = tfItemName.getText();
				String SelectedItemNum = tfSelectedItemNum.getText();
				

//				��ǰ�ڵ带 �������� ������ �̸��� ������ �����ϴ� �޼ҵ� 
				update(ItemName, SelectedItemNum, ItemCode);


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
				tfItemCode.setText("");
				tfItemName.setText("");
				tfSelectedItemNum.setText("");

//				���������ϰ� ����
				tfItemCode.setEditable(true);
				tfItemName.setEditable(true);
				tfSelectedItemNum.setEditable(true);
//				��ǰ�ڵ��ؽ�Ʈ�ʵ忡 Ŀ�� ��ġ
				tfItemCode.requestFocus();
			}
		});
		

//		�гο� ������ ���̺�� �ؽ�Ʈ�ʵ� �߰�
		panel.add(lblItemCode);
		panel.add(tfItemCode);
		panel.add(lblItemName);
		panel.add(tfItemName);
		panel.add(lblSelectedItemNum);
		panel.add(tfSelectedItemNum);

		
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
	 * @Method ItemName : selectAll
	 * @return : data  
	 * ���� : �����ͺ��̽����� �˻��� �����͸� data Vector�� ��� ����
	 */
	private Vector selectAll() {
		data.clear();
		try{
			ResultSet rs = stmt.executeQuery("select * from member order by ItemCode");
			while(rs.next()){
				Vector in = new Vector<String>(); // 1���� ���ڵ� �����ϴ� ���� ����

				String ItemCode = rs.getString(1); // �����ͺ��̽����� ��ǰ�ڵ尪 ������ �ͼ� ItemCode ������ ����
//				String ItemCode = rs.getString("ItemCode");

				String ItemName = rs.getString(2); // �����ͺ��̽����� �̸��� ������ �ͼ� ItemName ������ ����
//				String ItemName = rs.getString("ItemName");

				String SelectedItemNum = rs.getString(3); // �����ͺ��̽����� ������ ������ �ͼ� SelectedItemNum ������ ����
//				String SelectedItemNum = rs.getString("SelectedItemNum");

//				���Ϳ� ������ �� �߰�
				in.add(ItemCode);
				in.add(ItemName);
				in.add(SelectedItemNum);


//				��ü �����͸� �����ϴ� ���Ϳ� in(1���� ������ ����) ���� �߰�
				data.add(in);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return data; // ��ü ������ �����ϴ� data ���� ����
	}


	/**
	 * @Method ItemName : insert
	 * @param ItemCode :��ǰ�ڵ� �ؽ�Ʈ�ʵ忡 �Է¹��� �� 
	 * @param ItemName : �̸� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * @param SelectedItemNum : ���� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * ���� : ������ �ؽ�Ʈ�ʵ忡 �Էµ� ���� �Ķ���ͷ� �޾Ƽ� �����ͺ��̽��� 
	 *        insert ó���ϴ� �޼ҵ�
	 */

	private void insert(String ItemCode, String ItemName, String SelectedItemNum){
		try{
//			PreparedStatement ����-> conn�� preDbTreatment() �޼ҵ带 ���� �����Ǿ� ����
			pstmtAdd = conn.prepareStatement("insert into member values(?,?,?)");


//			insert into member values(? -> 1 ,? -> 2, ? -> 3)" ������ ? �� �� ����
			pstmtAdd.setString(1, ItemCode);
			pstmtAdd.setString(2, ItemName);
			pstmtAdd.setString(3, SelectedItemNum);

			
//			���Թ��� ������ ���� -> �Է� (insert)
			pstmtAdd.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	

	/**
	 * @Method ItemName : delete
	 * @param ItemCode : ��ǰ�ڵ� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * ���� : ��ǰ�ڵ尪�� �Ķ���͸� �޾� �ش� ��ǰ�ڵ��� �����͸� ��񿡼� ����(delete) �ϴ� �޼ҵ� 
	 */

	private void delete(String ItemCode){

		try{

//			PreparedStatement ����-> conn�� preDbTreatment() �޼ҵ带 ���� �����Ǿ� ����
			pstmtDel = conn.prepareStatement("delete from member where ItemCode = ?");

//			ItemCode ���� ���ؼ� ������
 			pstmtDel.setString(1, ItemCode);

// 			���Թ��� ������ ����-> ���� (delete)
			pstmtDel.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	

	/**
	 * @Method ItemName : update
	 * @param ItemName : �̸� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * @param SelectedItemNum : ���� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * @param ItemCode : ��ǰ�ڵ� �ؽ�Ʈ�ʵ忡 �Է¹��� ��
	 * ���� : ������ �ؽ�Ʈ�ʵ忡 �Էµ� ���� �Ķ���ͷ� �޾Ƽ� �����ͺ��̽��� 
	 *        �ش� ��ǰ�ڵ尪���� �̸��� ������ �����ϴ� �޼ҵ� 
	 */
	private void update(String ItemName, String SelectedItemNum, String ItemCode){
		try{
//			PreparedStatement ����-> conn�� preDbTreatment() �޼ҵ带 ���� �����Ǿ� ����
			pstmtUpdate = conn.prepareStatement("update member set ItemName = ?, SelectedItemNum = ? where ItemCode = ?");
//			�� ����
			pstmtUpdate.setString(1, ItemName);
			pstmtUpdate.setString(2, SelectedItemNum);
//			? ���� �߿� Ȯ�� �ʿ���
			pstmtUpdate.setString(3, ItemCode);
//			���� ����
			pstmtUpdate.executeUpdate();	

		}catch(Exception e){
			e.printStackTrace();
		}
	}


	/**
	 * @Method ItemName : preDbTreatment
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