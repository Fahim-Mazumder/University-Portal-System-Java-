import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class MarkT extends JFrame implements ActionListener
{
	private JLabel welcome,imgLabel;
	private JPanel panel;
	private ImageIcon imge;
	private HomeAiub h;
	private CourseT courT;
	private LogInT logT;
	private JButton exit , back;
	static Object[][] dbinfo;
	static DefaultTableModel dtm;
	String idTF;
	
	public MarkT(String idTF)
	{
		super("AIUB FACULTY PORTAL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.idTF=idTF;
		this.setSize(800,550);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
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
			LogInT logT = new LogInT(idTF);
			logT.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void addToPanel()
	{
		Object[] col = {"Marks", "Grades", "Grade Points"};
		dtm = new DefaultTableModel(dbinfo, col);
				
		ArrayList<Marks> list = marksList();
		Object[] row = new Object[3];
				
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getMark();
			row[1]=list.get(i).getGrade();
			row[2]=list.get(i).getPoint();
					
			dtm.addRow(row);
		}
		
		JTable table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(100,120,400,220);
		add(scrollPane);
	}
	
	public ArrayList<Marks> marksList()
	{
		ArrayList<Marks> marksList = new ArrayList<Marks>();
		
		try
		{
			String query= "select * from marklist";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran","root","");
			Statement st = con.createStatement();
			ResultSet rs   = st.executeQuery(query);
			Marks marks;
				
			while(rs.next())
			{
				marks = new Marks(rs.getString(1), rs.getString(2),rs.getFloat(3));
				marksList.add(marks);
			}
			
			con.close();
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return marksList;
	}	
}