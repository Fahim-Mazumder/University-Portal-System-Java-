import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogInT extends JFrame implements ActionListener
{
	private JLabel welcome;
	private JLabel imgLabel;
	private JPanel panel;
	private ImageIcon imge;
	private LogInT logT;
	private CourseT courT;
	private MarkT mar;
	private OfferedT off;
	private Tinfo infot;
	private HomeAiub h;
	private JButton reg,course,mark,tinfo,exit,offered;
	String idTF;
	
	public LogInT(String idTF)
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
	
		course = new JButton("Courses & Results");
		course.setBounds(220,180,260,40);
		course.setBackground(Color.RED);
		course.setForeground(Color.white);
		course.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		course.addActionListener(this);
		panel.add(course);
	
		mark = new JButton("Marking System");
		mark.setBounds(220,230,260,40);
		mark.setBackground(Color.RED);
		mark.setForeground(Color.white);
		mark.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		mark.addActionListener(this);
		panel.add(mark);

		offered = new JButton("Offered Courses");
		offered.setBounds(220,280,260,40);
		offered.setBackground(Color.RED);
		offered.setForeground(Color.white);
		offered.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		offered.addActionListener(this);
		panel.add(offered);

		tinfo = new JButton("Teacher Information");
		tinfo.setBounds(220,330,260,40);
		tinfo.setBackground(Color.RED);
		tinfo.setForeground(Color.white);
		tinfo.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		tinfo.addActionListener(this);
		panel.add(tinfo);

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
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		if(elementText.equals(exit.getText()))
		{
			HomeAiub h = new HomeAiub();
			h.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(course.getText()))
		{
			CourseT courT = new CourseT(idTF);
			this.setVisible(false);
			courT.setVisible(true);
		} 
		else if(elementText.equals(mark.getText()))
		{
			MarkT mar = new MarkT(idTF);
			this.setVisible(false);
			mar.setVisible(true);		
		}
		else if(elementText.equals(offered.getText()))
		{
			OfferedT off = new OfferedT(idTF);
			this.setVisible(false);
			off.setVisible(true);
		}
		else if(elementText.equals(tinfo.getText()))
		{
			Tinfo infot = new Tinfo(idTF);
			this.setVisible(false);
			infot.setVisible(true);
		}
	}
}