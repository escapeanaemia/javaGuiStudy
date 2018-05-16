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
</br>

## JTextArea를 통해 입력받은 값을 줄바꿈(\n)에 따라 구분하기
```
String getInfo = BoxArea.getText();
	// 엔터(\n) 자르기
	String splitedInfo[] = getInfo.split("\n");
	int IndexOfSplitedInfo = splitedInfo.length;
	for(int i =0; i< IndexOfSplitedInfo; i++){
		System.out.println("splitedInfo["+i+"] : "+splitedInfo[i]);				
	}
```
</br>

## 줄바꿈에 따라 구분된 입력 문자열을 띄어쓰기 단위에 따른 구분 및 JSON구조화
```
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
			
		
			
			JSONObject jsonObject = new JSONObject();
			
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

						
						j++;
				
					}else{
						//띄어쓰기 하나만 했을 경우의 잘린 문자를 저장한다. 그리고 여기에다 노드를 붙여주면 된다.

						oneSpacedString = splitedInfo[i];
						System.out.println("띄어쓰기 하나가 감지됨");

						j=0;
					}
					
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
```
</br>

## JSON파일 생성
```
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
```
