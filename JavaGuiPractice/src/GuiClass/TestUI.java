package GuiClass;
import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import java.util.Map;
public class TestUI extends JFrame {
//	JTextField BoxInfo;
	JTextArea BoxArea;
	JTextField X_Field, Y_Field, W_Field, H_Field, ColorField;
	
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
		X_Field = new JTextField();
		Y_Field = new JTextField();
		W_Field = new JTextField();
		H_Field = new JTextField();
		ColorField = new JTextField();
		panel1.add(BoxArea);
		
		this.add(panel1);
		JButton button = new JButton("전송");
		JButton button2 = new JButton("Json파일저장");
		JButton button3 = new JButton("txt파일저장");
		add(X_Field);
		add(Y_Field);
		add(W_Field);
		add(H_Field);
		add(ColorField);
		add(button);
		add(button2);
		add(button3);
		this.setVisible(true);
		button.addActionListener(new Listener1(this));
		button2.addActionListener(new Listener2(this));
		button3.addActionListener(new Listener3(this));
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
			
//			//최종JSON객체 선언, (JSONOBject 선언)
//			JSONObject jsonObject = new JSONObject();
//			//JSON정보를 저장할 Array 생성
//			JSONArray splitedTextArrayJS = new JSONArray();
//			//잘라진 문자열 정보가 들어갈 JSONObject 선언
//			JSONObject splitedTextInfoJS = new JSONObject();
//			
			
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			JSONArray jsonArray2 = new JSONArray();
			JSONArray firstDataArrayJS = new JSONArray();
			JSONArray secondDataArrayJS = new JSONArray();
			JSONObject thirdDataObjectJS = new JSONObject();
			
			String oneSpacedString = "";
			int j = 0;
			for(int i = 0 ; i< IndexOfSplitedInfo;i++ ){
				String	TemporarySplitedInfo = splitedInfo[i];
				
				if(TemporarySplitedInfo.charAt(0) == ' '){
					//띄어쓰기 하나 판별
					
					if(TemporarySplitedInfo.charAt(1)==' '){
						
						//띄어쓰기 두개 판별 
						System.out.println("띄어쓰기 두개가 감지됨");
						jsonObject.put(oneSpacedString + " "+ j, TemporarySplitedInfo);
//						jsonArray.add(j, TemporarySplitedInfo);
						
						j++;
				
					}else{
						//띄어쓰기 하나만 했을 경우의 잘린 문자를 저장한다. 그리고 여기에다 노드를 붙여주면 된다.
//						jsonObject.put(oneSpacedString, jsonArray);
						oneSpacedString = splitedInfo[i];
						System.out.println("띄어쓰기 하나가 감지됨");
//						jsonArray.clear();
						j=0;
					}
//					jsonArray2.add(jsonObject);
					
				}
			}
			JSONObject finalJsonObject = new JSONObject();
			finalJsonObject.put(splitedInfo[0], jsonObject);
			
			System.out.println(finalJsonObject);
			
			//파일 만들기 
			//파일 이름
			String fileName = splitedInfo[0]+".json";
			
			try{
				File file = new File(fileName);
				FileWriter fw = new FileWriter(file, true);
				
				fw.write(finalJsonObject.toString());
				fw.flush();
				
				fw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	class Listener3 implements ActionListener{
		JFrame frame;
		public Listener3(JFrame f){
			frame = f;
		}
		@Override
		public void actionPerformed(ActionEvent arg0){
			
			String xPosition = X_Field.getText();
			String yPosition = Y_Field.getText();
			String wPosition = W_Field.getText();
			String hPosition = H_Field.getText();
			String colorField = ColorField.getText();
			
			String getInfo2 = BoxArea.getText();
			// 엔터(\n) 자르기
			String splitedInfo[] = getInfo2.split("\n");
			int IndexOfSplitedInfo = splitedInfo.length;
			for(int i =0; i< IndexOfSplitedInfo; i++){
				System.out.println("splitedInfo["+i+"] : "+splitedInfo[i]);
				
			}
			for(int i = 0 ; i< IndexOfSplitedInfo;i++ ){
				String	TemporarySplitedInfo = splitedInfo[i];
				
				if(TemporarySplitedInfo.charAt(0) == ' '){
					//띄어쓰기 하나 판별
					
					if(TemporarySplitedInfo.charAt(1)==' '){
						
						//띄어쓰기 두개 판별 
						System.out.println("띄어쓰기 두개가 감지됨");

				
					}else{
						
						System.out.println("띄어쓰기 하나가 감지됨");
						
					}
					
				}else{
					
					
					splitedInfo[i] = splitedInfo[i]+"(" + xPosition + ","+wPosition+","+hPosition+","+colorField+")";
					System.out.println("첫째 노드");
					System.out.println(splitedInfo[i]);
				}
			}
		}
	}
	public static void main(String[] args){
		new TestUI();
	}
	 
}