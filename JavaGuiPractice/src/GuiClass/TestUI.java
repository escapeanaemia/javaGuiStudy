package GuiClass;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TestUI extends JFrame {
//	JTextField BoxInfo;
	JTextArea BoxArea;
	public TestUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 완전하게 끄기
		this.setSize(1000,1000);
		this.setVisible(true);
		
		this.setLayout(new GridLayout(5,2));
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.add(new JLabel(" 상자1:"));
//		BoxInfo = new JTextField(100);
		BoxArea = new JTextArea(50,50);
		
		panel1.add(BoxArea);

		this.add(panel1);
		JButton button = new JButton("전송");
		JButton button2 = new JButton("파일저장");
		add(button);
		add(button2);
		this.setVisible(true);
		button.addActionListener(new Listener1(this));
	
		
		
		button2.addActionListener(new Listener2(this));
	}
	
	class Listener1 implements ActionListener{
		JFrame frame;
		public Listener1(JFrame f){
			frame = f;
		}
		@Override
		public void actionPerformed(ActionEvent arg0){
			String  getInfo = BoxArea.getText();
			System.out.println(getInfo);
			
			JOptionPane.showMessageDialog(frame, getInfo);
		}
	}
	
	class Listener2 implements ActionListener{
		JFrame frame;
		public Listener2(JFrame f){
			frame = f;
		}
		@Override
		public void actionPerformed(ActionEvent arg0){
			String getInfo = BoxArea.getText();
			// 엔터(\n) 자르기
			String splitedInfo[] = getInfo.split("\n");
			int IndexOfSplitedInfo = splitedInfo.length;
			for(int i =0; i< IndexOfSplitedInfo; i++){
				System.out.println("splitedInfo["+i+"] : "+splitedInfo[i]);
				
			}
			for(int i = 0 ; i< IndexOfSplitedInfo;i++ ){
				String	TemporarySplitedInfo = splitedInfo[i];
				if(TemporarySplitedInfo.substring(0,1) == "\t"){
					//띄어쓰기 하나 판별
					if(TemporarySplitedInfo.substring(1,2)=="\t"){
						//띄어쓰기 두개 판별 
					}else{
						
					}
				}else{
					
				}
			}
		}
	}
	
	public static void main(String[] args){
		new TestUI();
	}
	 
}


	
