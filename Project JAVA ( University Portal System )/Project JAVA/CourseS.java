import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CourseS extends JFrame implements ActionListener
{
	private JLabel welcome;
	private JLabel imgLabel,l1,l2,l3,l4,l5;
	private JPanel panel;
	private ImageIcon imge;
	private HomeAiub h;
	private Registration regis;
	private OfferedS offer;
	private StudentInfo sinformation;
	private JButton exit , back;
	String crsname,marks,idTF;
	
	public CourseS(String idTF)
	{
		super("AIUB STUDENT PORTAL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.idTF=idTF;
		this.setSize(800,550);
		this.setLocationRelativeTo(null);
		
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
		
		l1 = new JLabel("ID : "+idTF);
		l1.setBounds(160,100,450,50);
		l1.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		panel.add(l1);
		
		l2 = new JLabel("Course Name : ");
		l2.setBounds(160,150,450,50);
		l2.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		panel.add(l2);
		
		l3 = new JLabel("Exam Marks : ");
		l3.setBounds(160,200,450,50);
		l3.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		panel.add(l3);
	
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
		
		String query = "SELECT `CourseName`, `Marks` FROM `student` where `ID`='"+idTF+"';";    
		Connection con=null;
        Statement st = null;
		ResultSet rs = null;		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			rs = st.executeQuery(query);
			System.out.println("results received");
								
			while(rs.next())
			{
				crsname = rs.getString("CourseName");
				marks = rs.getString("Marks");
			}
				
			l4 = new JLabel(crsname);
			l4.setBounds(320,150,450,50);
			l4.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
			panel.add(l4);
		
			l5 = new JLabel(marks);
			l5.setBounds(310,200,450,50);
			l5.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
			panel.add(l5);

		}		
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
	
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		if(elementText.equals(exit.getText()))
		{
			HomeAiub h = new HomeAiub();
			this.setVisible(false);
			h.setVisible(true);
		}
		else if(elementText.equals(back.getText()))
		{
			LogIn l = new LogIn(idTF);
			l.setVisible(true);
			this.setVisible(false);
		}
	}
}