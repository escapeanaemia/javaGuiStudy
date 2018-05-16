# javaGuiStudy
> javaGuiStudy는 Gui환경에서 사용자가 제공하는 데이터를 바탕으로 마인드맵을 그려주는 앱을 제작하기 위해 시작한 스터디입니다.

참고 링크 <br/>
http://egloos.zum.com/khpower/v/3027012 <br/>
http://all-record.tistory.com/118 <br/>
http://itpangpang.xyz/276 <br/>
http://gusfree.tistory.com/660 <br/>
https://kldp.org/node/100329 <br/>
http://huskdoll.tistory.com/38 <br/>
http://mainia.tistory.com/2273 <br/>
http://fruitdev.tistory.com/54 <br/>
http://shstarkr.tistory.com/185 <br/>
http://mkil.tistory.com/323 <br/>
https://stackoverflow.com/questions/17651395/convert-jsonobject-to-string?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa <br/>
<br/><br/>

## JTextArea를 통해 사용자 입력값 받아오기
```
JTextArea BoxArea;
public TestUI(){

  BoxArea = new JTextArea(50,50);
  
  // JTextArea에 입력된 값을 콘솔로 전송하는 버튼
  JButton button = new JButton("전송");
  add(button);
  this.setVisible(true);
	button.addActionListener(new Listener1(this));
}
class Listener1 implements ActionListener{
	JFrame frame;
	public Listener1(JFrame f){
		frame = f;
	}
	@Override
	public void actionPerformed(ActionEvent arg0){
		String  getInfo = BoxArea.getText();
		System.out.println(getInfo); //콘솔에 입력된 값이 출력됨
		
		JOptionPane.showMessageDialog(frame, getInfo); //신경안써도 되는 코드.
	}
}

```
