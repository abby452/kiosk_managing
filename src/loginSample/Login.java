package loginSample;

/**
 * DB�� ����ϴ� ��Ű��
 * version 1.0
 * @since 1.0
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @Entity
 * @Getter
 * @idField	�ؽ�Ʈ�ʵ带 ������ִ� ����
 * @GenerateValue
 * @passwordField		�н����� �ؽ�Ʈ�ʵ带 ������ִ� ����
 * @GenerateValue
 * @author dlckd
 * @version 1.0
 * �α���ó���� �ϴ� Ŭ������ ���� �̺�Ʈó���� ����ϴ� Ŭ����
 */
public class Login extends JFrame{
	
	
	private JTextField idField;
	private JPasswordField passwordField;
	
	/**
	 * @version 1.0
	 * @since 1.0
	 * �α��� �̺�Ʈó���� ����ϴ� Ŭ����
	 */
	public Login() {
		/**
		 * ����Ʈ�� �߰�
		 */
		getContentPane().setLayout(null);
		
		/**
		 * @IDLabel ���̵� �Է��ϴ� ���� �˷��ִ� ���̺�
		 * ���̺��� ��ġ������ �������ҿ� ����
		 */
		JLabel IDLabel = new JLabel("���̵� �Է�");
		IDLabel.setBounds(39, 27, 76, 25);
		getContentPane().add(IDLabel);
		
		/**
		 * @idfield �ؽ�Ʈ�ʵ� ����
		 * �ؽ�Ʈ�ʵ� ��ġ ���� �� �������ҿ� ����
		 */
		idField = new JTextField();
		idField.setBounds(39, 64, 200, 34);
		getContentPane().add(idField);
		idField.setColumns(10);
		
		/**
		 * @PWLabel ��й�ȣ�� �Է��� ���� �˷��ִ� ���̺�
		 * ���̺��� ��ġ������ �������� ����
		 */
		JLabel PWLabel = new JLabel("�н����� �Է�");
		PWLabel.setBounds(39, 125, 76, 18);
		getContentPane().add(PWLabel);
		
		/**
		 * @passwordField ��й�ȣ�� �Է��� �ؽ�Ʈ�ʵ� ����
		 * �ؽ�Ʈ�ʵ��� ��ġ ������ �������ҿ� ����
		 */
		passwordField = new JPasswordField();
		passwordField.setBounds(39, 155, 200, 34);
		getContentPane().add(passwordField);
		
		/**
		 * @btnDfsdf �α���ó���� �����ϰ� ���ִ� ��ư ����
		 * ��ư�� ��ġ ���� �� ����
		 */
		JButton btnDfsdf = new JButton("�α���");
		btnDfsdf.setBounds(297, 121, 105, 27);	
		getContentPane().add(btnDfsdf);
		
		
		/**
				 * @throws AuthorizationException id�� pw�� ��ġ���� �ʽ��ϴ�.
				 * @throws contentNotExistException contentId�� �ش��ϴ� �������� �������� �ʽ��ϴ�.
				 * @param id ���α׷��� ���̵�
				 * @param pw ���α׷��� ��й�ȣ��
				 */
		btnDfsdf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String id = idField.getText();
				String pw = passwordField.getText();
				idpass pass = new idpass();
				
				if(id.equals(pass.id(id))&&pw.equals(pass.getpw(id, pw))) {
					String welcome = String.format("ȯ���մϴ�. %s ��", id);
					JOptionPane.showMessageDialog(null, welcome);
				}
				else {
					idField.setText("");
					passwordField.setText("");
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� �н����尡 ����Ȯ�մϴ�");
					}
				
				}
			});
		}

	
	
	
	
	
	/**
	 * ���� Ŭ������ ���α׷��� ���۽�ŵ�ϴ�.
	 * @param args
	 */
	public static void main(String[] args) {
		// gin Auto-generated method stub
		Login dr = new Login();
		dr.setSize(450,350);
		dr.setVisible(true);
		}
}