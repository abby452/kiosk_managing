package loginSample;

/**
 * DB와 통신하는 패키지
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
 * @idField	텍스트필드를 만들어주는 변수
 * @GenerateValue
 * @passwordField		패스워드 텍스트필드를 만들어주는 변수
 * @GenerateValue
 * @author dlckd
 * @version 1.0
 * 로그인처리를 하는 클래스로 각종 이벤트처리를 담당하는 클래스
 */
public class Login extends JFrame{
	
	
	private JTextField idField;
	private JPasswordField passwordField;
	
	/**
	 * @version 1.0
	 * @since 1.0
	 * 로그인 이벤트처리를 담당하는 클래스
	 */
	public Login() {
		/**
		 * 컨텐트팬 추가
		 */
		getContentPane().setLayout(null);
		
		/**
		 * @IDLabel 아이디 입력하는 곳을 알려주는 레이블
		 * 레이블의 위치설정과 컨텐츠팬에 부착
		 */
		JLabel IDLabel = new JLabel("아이디 입력");
		IDLabel.setBounds(39, 27, 76, 25);
		getContentPane().add(IDLabel);
		
		/**
		 * @idfield 텍스트필드 생성
		 * 텍스트필드 위치 생성 및 컨텐츠팬에 부착
		 */
		idField = new JTextField();
		idField.setBounds(39, 64, 200, 34);
		getContentPane().add(idField);
		idField.setColumns(10);
		
		/**
		 * @PWLabel 비밀번호를 입력할 곳을 알려주는 레이블
		 * 레이블의 위치설정과 컨텐츠팬 부착
		 */
		JLabel PWLabel = new JLabel("패스워드 입력");
		PWLabel.setBounds(39, 125, 76, 18);
		getContentPane().add(PWLabel);
		
		/**
		 * @passwordField 비밀번호를 입력할 텍스트필드 생성
		 * 텍스트필드의 위치 설정과 컨텐츠팬에 부착
		 */
		passwordField = new JPasswordField();
		passwordField.setBounds(39, 155, 200, 34);
		getContentPane().add(passwordField);
		
		/**
		 * @btnDfsdf 로그인처리를 시작하게 해주는 버튼 생성
		 * 버튼의 위치 설정 및 부착
		 */
		JButton btnDfsdf = new JButton("로그인");
		btnDfsdf.setBounds(297, 121, 105, 27);	
		getContentPane().add(btnDfsdf);
		
		
		/**
				 * @throws AuthorizationException id가 pw와 일치하지 않습니다.
				 * @throws contentNotExistException contentId에 해당하는 컨텐츠가 존재하지 않습니다.
				 * @param id 프로그램의 아이디값
				 * @param pw 프로그램의 비밀번호값
				 */
		btnDfsdf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String id = idField.getText();
				String pw = passwordField.getText();
				idpass pass = new idpass();
				
				if(id.equals(pass.id(id))&&pw.equals(pass.getpw(id, pw))) {
					String welcome = String.format("환영합니다. %s 님", id);
					JOptionPane.showMessageDialog(null, welcome);
				}
				else {
					idField.setText("");
					passwordField.setText("");
					JOptionPane.showMessageDialog(null, "아이디 또는 패스워드가 부정확합니다");
					}
				
				}
			});
		}

	
	
	
	
	
	/**
	 * 메인 클래스로 프로그램을 시작시킵니다.
	 * @param args
	 */
	public static void main(String[] args) {
		// gin Auto-generated method stub
		Login dr = new Login();
		dr.setSize(450,350);
		dr.setVisible(true);
		}
}