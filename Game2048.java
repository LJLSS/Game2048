package Game2048;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ColorModel;
import java.util.Calendar;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Game2048 extends Thread {
	JPanel panel=new JPanel(null);
	JFrame frame=new JFrame();
	JLabel[]label_num={new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()};
	JLabel[]label_line={new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()};
	JLabel[] button={new JLabel("重新开始"),new JLabel("控制器"),new JLabel("帮助"),new JLabel()};
	JLabel show[]={new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()};
	int score=0;
	int highscore=0;
	public Game2048()
	{
		
		Container contain=frame.getContentPane();
		frame.setTitle("2048－LJL");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 600);
	    panel.setSize(480,600);
		contain.add(panel);
		point();
		backcolor();
		opaque();
		font();
		listener();
		for(int index=0;index<label_num.length;index++)
		{
		panel.add(label_num[index]);
		}
		for(int index=0;index<label_line.length;index++)
		{
		panel.add(label_line[index]);
		}
		for(int index=0;index<show.length;index++)
		{
		panel.add(show[index]);
		}
		for(int index=0;index<button.length;index++)
		{
		panel.add(button[index]);
		}
		random();
		label_num[0].setText(String.valueOf((int)Math.pow(2,1)));
		check_color();
		frame.setVisible(true);
	}
	
	public void listener()//监听器
	{
		frame.addKeyListener(new KeyAdapter()
		   {
				   public void keyPressed(KeyEvent e)

				   { 
					   if(e.getKeyCode()==KeyEvent.VK_UP)
					   {
						   moveup();
							random();
							score();
							check_color();
							if(iswin()==true){
						    JOptionPane.showMessageDialog(null, "你赢了");
							 clear();}
					   }
					   if(e.getKeyCode()==KeyEvent.VK_LEFT)
					   {
						   moveleft();
							random();
							score();
							check_color();
							if(iswin()==true){
							    JOptionPane.showMessageDialog(null, "你赢了");
							 clear();}
					   }
					   if(e.getKeyCode()==KeyEvent.VK_RIGHT)
					   {
						   moveright();
							random();
							score();
							check_color();
							if(iswin()==true){
							    JOptionPane.showMessageDialog(null, "你赢了");
							 clear();}
					   }
					   if(e.getKeyCode()==KeyEvent.VK_DOWN)
					   {
						   movedown();
							random();
							score();
							check_color();
							if(iswin()==true){
							    JOptionPane.showMessageDialog(null, "你赢了");
							    clear();}
					   }
				   }
		   });
		
		button[0].addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				clear();
				// 处理鼠标点击
			}
			public void mouseEntered(MouseEvent e) {
				// 处理鼠标移入
			}
			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}
			public void mousePressed(MouseEvent e) {
				// 处理鼠标按下
				button[0].setBackground(new java.awt.Color(85,194,249));
			}
			public void mouseReleased(MouseEvent e) {
				// 处理鼠标释放
				button[0].setBackground(new java.awt.Color(187, 173,160));
			}
		});
		button[1].addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				clear();
				// 处理鼠标点击
			}
			public void mouseEntered(MouseEvent e) {
				// 处理鼠标移入
			}
			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}
			public void mousePressed(MouseEvent e) {
				// 处理鼠标按下
				button[0].setBackground(new java.awt.Color(85,194,249));
			}
			public void mouseReleased(MouseEvent e) {
				// 处理鼠标释放
				button[0].setBackground(new java.awt.Color(187, 173,160));
			}
		});
	}
	public void clear()//restart
	{
		for(int index=0;index<label_num.length;index++)
		label_num[index].setText(String.valueOf(""));
		show[3].setText(String.valueOf(0));
		random();
		label_num[0].setText(String.valueOf((int)Math.pow(2,1)));
		check_color();
	}
	public void score()
	{
		if(score>highscore)
		{
			highscore=score;
			show[4].setText(String.valueOf(highscore));
		}
	}

	public void test()
	{
		
	}
	public void random()//随机出现数字
	{
		
	
		int dom;
		int ran=(int)(Math.random());
		if(ran==0)
	    dom=2;
		else
		dom=4;
		ran=(int)(Math.random()*15);
		if(label_num[ran].getText().equals(""))
		{
		label_num[ran].setText(String.valueOf(dom));
		}
		else
		{
			for(int index=0;index<label_num.length;index++)
			if(label_num[index].getText().equals(""))
				{
				label_num[index].setText(String.valueOf(dom));
				break;
				}
		}
	check_color();
	}
	public void run()
	{
		   
		/*for(;;)
		{
			int i=(int)(3*Math.random());
			if(i==0)
			{
			moveup();
			//random();
			check_color();
			}
			if(i==1)
			{
			movedown();
			random();
			check_color();
			}
			if(i==2)
			{
			moveleft();
			random();
			check_color();
			}
			if(i==30)
			{
			moveright();
			//random();
			check_color();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}*/
	}
	
	public boolean iswin()
	{
		for(int index=0;index<label_num.length;index++)
		{
			if(label_num[index].getText().equals("2048"))
			{
				return true;
			}
		}
		return false;
	}
	public void check_color()
	{
		for(int index=0;index<label_num.length;index++)
			{
				if(label_num[index].getText().equals("2"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,45));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(238, 228,218));
					label_num[index].setForeground(new java.awt.Color(119,110,101));
				}
			
				if(label_num[index].getText().equals("4"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,45));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center	
					label_num[index].setBackground(new java.awt.Color(237, 224,200));	
					label_num[index].setForeground(new java.awt.Color(119,110,101));
				}
			
				if(label_num[index].getText().equals("8"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,45));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(242, 177,121));
					label_num[index].setForeground(Color.white);
				}
			
				if(label_num[index].getText().equals("16"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,45));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(245, 149,99));
					label_num[index].setForeground(Color.white);
				}	
			
				if(label_num[index].getText().equals("32"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,45));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(246, 124,95));	
					label_num[index].setForeground(Color.white);
				}
			
				if(label_num[index].getText().equals("64"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,45));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(246, 94,59));
					label_num[index].setForeground(Color.white);
				}
			
				if(label_num[index].getText().equals("128"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,45));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(241, 200,128));
					label_num[index].setForeground(Color.white);
				}
			
				if(label_num[index].getText().equals("256"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,45));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(241, 200,108));
					label_num[index].setForeground(Color.white);
				}
				if(label_num[index].getText().equals("512"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,45));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(238, 198,84));
					label_num[index].setForeground(Color.white);
				}
				if(label_num[index].getText().equals("1024"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,30));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(240, 208,64));
					label_num[index].setForeground(Color.white);
				}
				if(label_num[index].getText().equals("2048"))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,30));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(241, 190,40));
					label_num[index].setForeground(Color.white);
				}
				if(label_num[index].getText().equals(""))
				{
					label_num[index].setFont(new Font("2048",Font.CENTER_BASELINE,30));
					label_num[index].setHorizontalAlignment(SwingConstants.CENTER);//font center
					label_num[index].setBackground(new java.awt.Color(204, 192,178));
					label_num[index].setForeground(Color.white);
				}

				else
				{
					continue;
				}
		}
	}
	public void backcolor()
	{
		panel.setBackground(new java.awt.Color(250,248,239));
		
		for(int index=0;index<label_num.length;index++)
		{
		label_num[index].setBackground(new java.awt.Color(204, 192,178));
		}
		
		
		for(int index=0;index<label_line.length;index++)
		{
		label_line[index].setBackground(new java.awt.Color(187, 173,160));
		}
		
		for(int index=1;index<show.length;index++)
		{
		show[index].setBackground(new java.awt.Color(187, 173,160));
		}
		
		for(int index=0;index<button.length;index++)
		{
		button[index].setBackground(new java.awt.Color(187, 173,160));
		button[index].setForeground(Color.WHITE);
		
		}
	}
	
	public void point()
	{
		int x=30;
		for(int index=0;index<4;index++)
		{
		label_num[index].setBounds(x, 100, 90, 90);
		label_num[index+4].setBounds(x, 200, 90, 90);
		label_num[index+8].setBounds(x, 300, 90, 90);
		label_num[index+12].setBounds(x, 400, 90, 90);
		x=x+100;
		}
		
		x=20;
		for(int index=0;index<5;index++)
		{
		label_line[index].setBounds(x, 90, 10, 410);
		x=x+100;
		}
		
		int y=90;
		for(int index=5;index<10;index++)
		{
		label_line[index].setBounds(20, y, 400, 10);
		y=y+100;
		}
		
		show[0].setBounds(15, 18, 150, 70);
		show[1].setBounds(160, 18, 120, 30);
		show[2].setBounds(300, 18, 120, 30);
		show[3].setBounds(160, 45, 120, 30);
		show[4].setBounds(300, 45, 120, 30);
		button[0].setBounds(50, 510, 100, 50);
		button[1].setBounds(175, 510, 100, 50);
		button[2].setBounds(300, 510, 100, 50);
	}
	
	public void opaque()
	{
		for(int index=0;index<label_num.length;index++)
		{
		label_num[index].setOpaque(true);
		}
		for(int index=0;index<label_line.length;index++)
		{
		label_line[index].setOpaque(true);
		}
		for(int index=1;index<show.length;index++)
		{
	     show[index].setOpaque(true);
		}
		for(int index=0;index<button.length;index++)
		{
	     button[index].setOpaque(true);
		}
	}
	
	public void font()
	{
		show[0].setFont(new Font("2048",Font.BOLD,40));
		show[0].setText("2048");
		for(int index=1;index<5;index++)
		{
		show[index].setForeground(Color.white);
		show[index].setFont(new Font("2048",Font.BOLD,15));
		}
		for(int index=1;index<show.length;index++)
		{
		show[index].setHorizontalAlignment(SwingConstants.CENTER);
		}
		for(int index=0;index<label_num.length;index++)
		{
		label_num[index].setHorizontalAlignment(SwingConstants.CENTER);
		}
		for(int index=0;index<button.length;index++)
		{
		 button[index].setFont(new Font("2048",Font.BOLD,15));
	     button[index].setHorizontalAlignment(SwingConstants.CENTER);
		}
		show[1].setText("分数");
		show[2].setText("最高分数");
		show[3].setText(String.valueOf(score));
		show[4].setText(String.valueOf(highscore));
	}
	
	public void moveup()
	{
		for(int loop=0;loop<10;loop++)
		{
		for(int index=4;index<13;)
		{
			for(int i=index;i<index+4;i++)
			{
				if(label_num[i-4].getText().equals(""))
				{
					label_num[i-4].setText(label_num[i].getText());
					label_num[i].setText("");
				}
				if(label_num[i-4].getText().equals(label_num[i].getText())&&label_num[i-4].getText()!="")
				{
					label_num[i-4].setText(String.valueOf(Integer.parseInt(label_num[i].getText())+Integer.parseInt(label_num[i-4].getText())));
					label_num[i].setText("");
					try{
					show[3].setText(String.valueOf(score=score+(Integer.parseInt(label_num[i-4].getText()))));}catch(Exception e){}
				}
				else
					continue;
			}
			index=index+4;
		}
		}
		check_color();
	}
	
	public void movedown()

	{
		for(int loop=0;loop<10;loop++)
		{
		for(int index=8;index>-1;)
		{
			for(int i=index;i<index+4;i++)
			{
				if(label_num[i+4].getText().equals(""))
				{
					label_num[i+4].setText(label_num[i].getText());
					label_num[i].setText("");
				}
				if(label_num[i+4].getText().equals(label_num[i].getText())&&label_num[i+4].getText()!="")
				{
					label_num[i+4].setText(String.valueOf(Integer.parseInt(label_num[i].getText())+Integer.parseInt(label_num[i+4].getText())));
					label_num[i].setText("");
					try{
						show[3].setText(String.valueOf(score=score+(Integer.parseInt(label_num[i+4].getText()))));}catch(Exception e){}
				}
				else
					continue;
			}
			index=index-4;
		}
		}
		check_color();
	}
	
	public void moveleft()
	{
		for(int loop=0;loop<10;loop++)
		{
			
			for(int index=1;index<index+1&&index<16;)
			{
				
				for(int i=index;i<index+3;i++)
				{
					if(label_num[i-1].getText().equals(""))
					{
						label_num[i-1].setText(label_num[i].getText());
						label_num[i].setText("");
					}
					if(label_num[i-1].getText().equals(label_num[i].getText())&&label_num[i-1].getText()!="")
					{
						label_num[i-1].setText(String.valueOf(Integer.parseInt(label_num[i-1].getText())+Integer.parseInt(label_num[i].getText())));
						label_num[i].setText("");
						try{
							show[3].setText(String.valueOf(score=score+(Integer.parseInt(label_num[i-1].getText()))));}catch(Exception e){}
					}
					else
					{
					
						continue;
						}
				}
				index=index+4;
				
			}
		
	}
	check_color();
	}
	
	public void moveright()
	{
	for(int loop=0;loop<10;loop++)
	{
		
		for(int index=2;index<index+1&&index<16;)
		{
			
			for(int i=index;i>index-3;i--)
			{
				if(label_num[i+1].getText().equals(""))
				{
					label_num[i+1].setText(label_num[i].getText());
					label_num[i].setText("");
				}
				if(label_num[i+1].getText().equals(label_num[i].getText())&&label_num[i+1].getText()!="")
				{
					label_num[i+1].setText(String.valueOf(Integer.parseInt(label_num[i].getText())+Integer.parseInt(label_num[i+1].getText())));
					label_num[i].setText("");
					try{
						show[3].setText(String.valueOf(score=score+(Integer.parseInt(label_num[i+1].getText()))));}catch(Exception e){}
				}
				else
				{
				
					continue;
					}
			}
			index=index+4;
			
		}
	}
	check_color();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread thread=new Thread(new Game2048());
		thread.start();
	}

}
