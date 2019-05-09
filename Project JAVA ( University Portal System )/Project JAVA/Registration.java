import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class Registration extends JFrame implements ActionListener
{
	JLabel welcome,imgLabel;
	JCheckBox r;
	JButton back,confirm,exit;
	private JCheckBox c[]= new JCheckBox[50];
	private JPanel p;
	JPanel panel;
	private LogIn l;
	private HomeAiub h;
	private Confirm con; 
	String idTF;
	int i,len,j=0;
	private ImageIcon imge;
	static Object[][] dbinfo;
	static DefaultTableModel dtm;
	String s1[];
	
	public Registration(String idTF)
	{
		super("AIUB STUDENT PORTAL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,550);
		this.idTF=idTF;
		this.setLocationRelativeTo(null);
		s1 = new String[50];
		
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
		
		back = new JButton("Back");
		back.setBounds(100,400,220,40);
		back.setBackground(Color.BLUE);
		back.setForeground(Color.white);
		back.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		back.addActionListener(this);
		panel.add(back);
		
		confirm = new JButton("Confirm");
		confirm.setBounds(350,400,220,40);
		confirm.setBackground(Color.BLUE);
		confirm.setForeground(Color.white);
		confirm.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		confirm.addActionListener(this);
		panel.add(confirm);
	
		exit = new JButton("Log out");
		exit.setBounds(220,460,260,40);
		exit.setBackground(Color.BLUE);
		exit.setForeground(Color.white);
		exit.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		exit.addActionListener(this);
		panel.add(exit);	
		
		imge = new ImageIcon("img1.png");
		imgLabel = new JLabel(imge);
		imgLabel.setBounds(0,20,150,70);
		panel.add(imgLabel);
		
		courseList(panel);
	
		this.add(panel);
	}	
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		if(elementText.equals(back.getText()))
		{
			LogIn l = new LogIn(idTF);
			l.setVisible(true);
			this.setVisible(false);		 
		}
		else if(elementText.equals(confirm.getText()))
		{
			for(int i=0;i<len;i++)
			{
				if(c[i].isSelected())
				{
					c[i].setSelected(true);
					s1[j] = c[i].getText();
					j++;
				}
			}
			Confirm con = new Confirm(this,s1,idTF,j);
			con.setVisible(true);
			this.setVisible(false); 
		}
		else if(elementText.equals(exit.getText()))
		{
			HomeAiub h = new HomeAiub();
			h.setVisible(true);
			this.setVisible(false); 
		}
	}
	
	public ArrayList<Course> courseList(JPanel p)
	{
		ArrayList<Course> courseList = new ArrayList<Course>();
		String myArray[];
						
		try
		{
			String query= "select * from course";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran","root","");
			Statement st = con.createStatement();
			ResultSet rs   = st.executeQuery(query);
			Course course;
			
			myArray = new String[50];
			int j=0;
			while(rs.next())
			{	
				myArray[j] = rs.getString(1);
				j++;
			}
			
			int x=100, y=100;
			for(int i=0; i< myArray.length; i++)
			{
				c[i] = new JCheckBox(myArray[i]);
				c[i].setBounds(x,y,280,10);
				c[i].addActionListener(this);
				p.add(c[i]);
				y+=20;
				if(y==380)
				{
					y=100;
					x=390;
				}
				len=i;
			} 
						
			con.close();
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return courseList;
	}		
}