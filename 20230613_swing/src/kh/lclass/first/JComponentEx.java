package kh.lclass.first;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JComponentEx extends JFrame { //J프레임을 상속받은 클래스 JComponentEx
	public JComponentEx(){ // 생성자 선언
		super("JComponent의 공통 메소드 예제");  // 처음 맨위에뜨는 문구를 super생성자를 통해 정해준다.
		Container c= getContentPane(); // 컨테이너 생성
		c.setLayout(new FlowLayout()); // 컨테이너의 레이아웃 설정 
		JButton b1=new JButton("Magenta/Yellow Button"); // 문구를가진 버튼생성
		JButton b2=new JButton("Disabled Button"); // 문구를가진 버튼생성
		JButton b3=new JButton("getX(),getY()");// 문구를가진 버튼생성
		
		b1.setBackground(Color.YELLOW); //배경색설정
		b1.setForeground(Color.MAGENTA); //글자색설정
		b1.setFont(new Font("Arial",Font.ITALIC,20)); //Arial, 20픽셀 폰트설정
		
		b2.setEnabled(false); // b2의 버튼 비활성화
		
		b3.addActionListener(new ActionListener() { // b3버튼의 동작추가 
			public void actionPerformed(ActionEvent e) { // ActionListener는 인터페이스이므로 함수구현을통한 일회성 생성.
				JButton b=(JButton)e.getSource(); // e라는 이벤트가 발생했을때 버튼소스를 얻어서 b에 저장.
				JComponentEx frame=(JComponentEx)b.getTopLevelAncestor(); //b의 최고조상을 찾은후, JComponentEx형 frame을 만든후 
				frame.setTitle(b.getX()+","+b.getY()); // 객체의 타이틀을 b의 x,y좌표로 변경한다.
			}
		});
		c.add(b1); c.add(b2); c.add(b3); // 순서대로 컨테이너에 버튼부착
		setSize(260,200); //컨테이너 사이즈 정하기
		setVisible(true); //컨테이너 보이도록설정하기
	}
	public static void main(String[] args) {
		new JComponentEx(); // 실행 (생성자이용) 
	}
}
