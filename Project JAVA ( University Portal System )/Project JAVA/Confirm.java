import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Confirm extends JFrame implements ActionListener
{
	private JLabel welcome,l1,l2,l3,imgLabel;
	private JButton back,exit;
	private JPanel panel;
	private HomeAiub h;
	private Registration regis;
	private Confirm con;
	private ImageIcon imge;
	private JLabel l[]= new JLabel[50];
	String idTF;
	int x=160, y=110;
	
	public Confirm(Registration regis,String s1[],String idTF,int j)
	{
		super("AIUB STUDENT PORTAL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,550);
		this.setLocationRelativeTo(null);
		this.idTF=idTF;
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		welcome = new JLabel(" WELCOME TO AMERICAN INTERNATIONAL UNIVERSITY BANGLADESH");
		welcome.setBounds(140,20,800,60);
		welcome.setBackground(Color.BLUE);
		welcome.setForeground(Color.white);
		welcome.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		welcome.setOpaque(true);
		panel.add(welcome);
	
		l1 = new JLabel("Registered: ");
		l1.setBounds(160,80,300,20);
		l1.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		panel.add(l1);
		
		for(int i=0; i<j; i++)
		{
			l[i] = new JLabel(s1[i]);
			l[i].setBounds(x,y,335,20);
			l[i].setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
			panel.add(l[i]);
			y+=20;
			if(y==370)
			{
				y=110;
				x=500;	
			}
		} 		
		
		exit = new JButton("Log out");
		exit.setBounds(100,400,220,40);
		exit.setBackground(Color.BLUE);
		exit.setForeground(Color.white);
		exit.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		exit.addActionListener(this);
		panel.add(exit);
		
		back = new JButton("Back");
		back.setBounds(350,400,220,40);
		back.setBackground(Color.BLUE);
		back.setForeground(Color.white);
		back.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		back.addActionListener(this);
		panel.add(back);

		imge = new ImageIcon("img1.png");
		imgLabel = new JLabel(imge);
		imgLabel.setBounds(0,20,150,70);
		panel.add(imgLabel);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		if(elementText.equals(exit.getText()))
		{	
			HomeAiub h = new HomeAiub();
			h.setVisible(true);
			this.setVisible(false);			
		}
		else if(elementText.equals(back.getText()))
		{
			Registration regis = new Registration(idTF);
			regis.setVisible(true);
			this.setVisible(false);
		}	
	}		
}