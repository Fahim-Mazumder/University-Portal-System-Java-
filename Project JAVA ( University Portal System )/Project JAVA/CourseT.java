import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CourseT extends JFrame implements ActionListener
{
	private JLabel welcome, crsname, sid1, sid2, marks, label1, label2;
	private JTextField crsnameTF, sidTF1, sidTF2, marksTF;
	private JLabel imgLabel;
	private JPanel panel;
	private ImageIcon imge;
	private HomeAiub h;
	private CourseT courT;
	private LogInT logT;
	private JButton exit , back, insert1, insert2, update1, update2;
	String idTF;
	
	public CourseT(String idTF)
	{
		super("AIUB FACULTY PORTAL");
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
		
		label1 = new JLabel("COURSES");
		label1.setBounds(200,90,80,60);
		panel.add(label1);
		
		crsname = new JLabel("Course Name");
		crsname.setBounds(70,150,80,40);
		panel.add(crsname);
		
		sid1 = new JLabel("Student ID");
		sid1.setBounds(70,200,100,40);
		panel.add(sid1);
		
		crsnameTF = new JTextField();
		crsnameTF.setBounds(160,155,150,30);
		panel.add(crsnameTF);
		
		sidTF1 = new JTextField();
		sidTF1.setBounds(160,205,150,30);
		panel.add(sidTF1);
		
		update1 = new JButton("Update");
		update1.setBounds(190,250,80,40);
		update1.addActionListener(this);
		panel.add(update1);
		
		label2 = new JLabel("RESULTS");
		label2.setBounds(580,90,80,60);
		panel.add(label2);
		
		marks = new JLabel("Exam Mark");
		marks.setBounds(450,150,80,40);
		panel.add(marks);
		
		sid2 = new JLabel("Student ID");
		sid2.setBounds(450,200,100,40);
		panel.add(sid2);
		
		marksTF = new JTextField();
		marksTF.setBounds(540,155,150,30);
		panel.add(marksTF);
		
		sidTF2 = new JTextField();
		sidTF2.setBounds(540,205,150,30);
		panel.add(sidTF2);
		
		update2 = new JButton("Update");
		update2.setBounds(580,250,80,40);
		update2.addActionListener(this);
		panel.add(update2);
		
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
		if(ae.getSource()==update1)
		{
			crsUpdateDB();
		}
		else if(ae.getSource()==update2)
		{
			marksUpdateDB();
		}
		else if(ae.getSource()==back)
		{
			LogInT lt = new LogInT(idTF);
			this.setVisible(false);
			lt.setVisible(true);
		}
		else if(ae.getSource()==exit)
		{
			HomeAiub h = new HomeAiub();
			this.setVisible(false);
			h.setVisible(true);
		}
	}

	public void crsUpdateDB()
	{
		String query = "UPDATE `student` SET `CourseName`='"+crsnameTF.getText()+"' where `ID`='"+sidTF1.getText()+"'";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			JOptionPane.showMessageDialog(this,"DONE");
			stm.close();
			con.close();
					
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this,"Invalid");
			System.out.println("Exception : " +ex.getMessage());
        }
    }

	public void marksUpdateDB()
	{
		String query = "UPDATE `student` SET `Marks`='"+marksTF.getText()+"' where `ID`='"+sidTF2.getText()+"'";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			JOptionPane.showMessageDialog(this,"DONE");
			stm.close();
			con.close();
					
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this,"Invalid");
			System.out.println("Exception : " +ex.getMessage());
        }
    }
}