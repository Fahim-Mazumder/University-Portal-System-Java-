import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogIn extends JFrame implements MouseListener , ActionListener
{
	private JLabel welcome;
	private JLabel imgLabel;
	private JPanel panel;
	private ImageIcon imge;
	private HomeAiub h;
	private Registration regis;
	String idTF;
	private OfferedS offer;
	private StudentInfo sinformation;
	private JButton reg,course,offered,sinfo,exit;
	
	public LogIn(String idTF)
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
		
		course = new JButton("Results");
		course.setBounds(220,150,260,40);
		course.setBackground(Color.RED);
		course.setForeground(Color.white);
		course.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		course.addActionListener(this);
		panel.add(course);
	
		reg = new JButton("Registration");
		reg.setBounds(220,200,260,40);
		reg.setBackground(Color.RED);
		reg.setForeground(Color.white);
		reg.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		reg.addActionListener(this);
		panel.add(reg);

		offered = new JButton("Offered Courses");
		offered.setBounds(220,250,260,40);
		offered.setBackground(Color.RED);
		offered.setForeground(Color.white);
		offered.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		offered.addActionListener(this);
		panel.add(offered);

		sinfo = new JButton("Student Information");
		sinfo.setBounds(220,300,260,40);
		sinfo.setBackground(Color.RED);
		sinfo.setForeground(Color.white);
		sinfo.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		sinfo.addActionListener(this);
		panel.add(sinfo);

		exit = new JButton("Log out");
		exit.setBounds(220,420,260,40);
		exit.setBackground(Color.BLUE);
		exit.setForeground(Color.white);
		exit.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		exit.addActionListener(this);
		panel.add(exit);
	
		imge = new ImageIcon("img1.png");
		imgLabel = new JLabel(imge);
		imgLabel.setBounds(0,20,150,70);
		panel.add(imgLabel);
		
		this.add(panel);
	}
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
			if(elementText.equals(exit.getText()))
		{
			HomeAiub h = new HomeAiub();
			this.setVisible(false);
			h.setVisible(true);
		}
		else if(elementText.equals(reg.getText()))
		{
			Registration regis = new Registration(idTF);
			this.setVisible(false);
			regis.setVisible(true);
		}
		else if(elementText.equals(course.getText()))
		{
			CourseS cour = new CourseS(idTF);
			this.setVisible(false);
			cour.setVisible(true);
	    }
		else if(elementText.equals(offered.getText()))
		{
			OfferedS offer = new OfferedS(idTF);
			this.setVisible(false);
			offer.setVisible(true);
	    }
		else if(elementText.equals(sinfo.getText()))
		{
			StudentInfo sinformation = new StudentInfo(idTF);
			this.setVisible(false);
			sinformation.setVisible(true);
	    }
	}
}