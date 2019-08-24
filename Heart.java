import java.awt.*;
import java.applet.*;
/*
<applet code="Heart" width=400 height=400 >
<param name=fontname value=I>
<param name=fontname2 value=AM>
<param name=fontname1 value=SORRY>
<param name=fontsize value=20>
<param name=fontsize1 value=20>
</applet>
*/
public class Heart extends Applet implements Runnable{
	String fontName,fontName1,fontName2;
	Thread t;
	int xpoint1=170;
	int ypoint1=170;
	int xpoint[]={113,220,325};
	int ypoint[]={150,300,150};
	int fontSize,fontSize1;
	boolean we=false;
	boolean he=false;
	public void start()
	{
		String param;
		fontName=getParameter("fontName");
		fontName1=getParameter("fontName1");
		fontName2=getParameter("fontName2");
		param=getParameter("fontSize");
		param=getParameter("fontSize1");
		fontSize=Integer.parseInt(param);
		fontSize1=Integer.parseInt(param);
		if (t==null){
		t=new Thread(this);
		t.start();

	
}
}
	public void paint(Graphics g)
	{
		Font f=new Font(fontName,Font.BOLD,fontSize);
		g.setFont(f);
		Font f1=new Font(fontName1,Font.BOLD,fontSize1);
		g.setColor(Color.red);
		g.fillOval(100,20,xpoint1,ypoint1);
		g.fillOval(169,20,xpoint1,ypoint1);
		
		g.fillPolygon(xpoint,ypoint,3);
//		g.drawLine(0,100,60,60);
		g.setColor(Color.green);
		g.drawString(fontName,170,90);
		g.drawString(fontName2,190,90);
		g.setColor(Color.blue);
		g.drawString(fontName1,182,115);
	}
		public void run(){
		while(true)
		{
			try
			{
				t.sleep(10);
			}
			catch(Exception e){}
					if(we==true){

							xpoint1=xpoint1+1;//170
							ypoint1=ypoint1+1;//170
							//xpoint[0]=xpoint[0]+1;//113
							xpoint[1]=xpoint[1]+1;//220
							xpoint[2]=xpoint[2]+1;//325
							ypoint[0]=ypoint[0]+1;//150
							ypoint[1]=ypoint[1]+1;//300
							ypoint[2]=ypoint[2]+1;//150
						if(xpoint1==170 || ypoint1==170||  xpoint[1]==220 || xpoint[2]==235 || ypoint[0]==150 || ypoint[1]==300 || ypoint[2]==150){
							we=false;
							}
			
						}
							if(we==false){
							xpoint1=xpoint1-1;//170
							ypoint1=ypoint1-1;//170
//							xpoint[0]=xpoint[0]-1;//113
							xpoint[1]=xpoint[1]-1;//220
							xpoint[2]=xpoint[2]-1;//325
							ypoint[0]=ypoint[0]-1;//150
							ypoint[1]=ypoint[1]-1;//300
							ypoint[2]=ypoint[2]-1;//150
						if(xpoint1==120 || ypoint1==120 ||xpoint[1]==195 || xpoint[2]==283 || ypoint[0]==105 || ypoint[1]==225 || ypoint[2]==105){
							we=true;
						}
		}
			repaint();

			
		}
	}
	public void stop(){
		if(t!=null){
			t.stop();
			t=null;
		}
	}
}