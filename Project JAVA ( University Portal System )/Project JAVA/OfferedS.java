import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class OfferedS extends JFrame implements ActionListener
{
	private JLabel welcome,imgLabel;
	public JTextField stf;
	private JPanel panel;
	private ImageIcon imge;
	private HomeAiub h;
	private OfferedS offer;
	private JButton exit , back,search;
	static Object[][] dbinfo;
	static DefaultTableModel dtm;
	String idTF;
	
	public OfferedS(String idTF)
	{
		super("AIUB STUDENT PORTAL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.idTF=idTF;
		this.setSize(800,550);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		stf = new JTextField();
		stf.setBounds(550,100,200,40);
		panel.add(stf);
		
		search = new JButton("Search");
		search.setBounds(650,160,100,40);
		search.addActionListener(this);
		panel.add(search);
		
		addToPanel();

		welcome = new JLabel(" WELCOME TO AMERICAN INTERNATIONAL UNIVERSITY BANGLADESH");
		welcome.setBounds(140,20,800,60);
		welcome.setBackground(Color.BLUE);
		welcome.setForeground(Color.white);
		welcome.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		welcome.setOpaque(true);
		panel.add(welcome);
		
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
			this.setVisible(false);
			h.setVisible(true);
		}
		else if(elementText.equals(back.getText()))
		{
			LogIn l = new LogIn(idTF);
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(search.getText()))
		{
			ShowSearch ss = new ShowSearch(this);
			ss.setVisible(true);
			this.setVisible(false);	
		}
	}
	
	public void addToPanel()
	{
		Object[] col = {"Name", "ID"};
		dtm = new DefaultTableModel(dbinfo, col);
				
		ArrayList<Course> list = courseList();
		Object[] row = new Object[2];
				
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getCourseName();
			row[1]=list.get(i).getCourseId();
					
			dtm.addRow(row);
		}
		
		JTable table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(100,100,400,220);
		add(scrollPane);
	}
	
	public ArrayList<Course> courseList()
	{
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		try
		{
			String query= "select * from course";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran","root","");
			Statement st = con.createStatement();
			ResultSet rs   = st.executeQuery(query);
			Course course;
				
			while(rs.next())
			{
				course = new Course(rs.getString(1), rs.getInt(2));
				courseList.add(course);
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