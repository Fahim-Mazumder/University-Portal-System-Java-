import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HomeAiub extends JFrame implements ActionListener
{
	private JLabel titel,titel1,titel2,imgLabel,note,id,pass;
	private JTextField idTF;
	private JPasswordField passPF;
	private JButton login , exit;
	private JPanel panel;
	private ImageIcon img;
	private JRadioButton Student, Faculty, Admin;
	private ButtonGroup bg;
	private boolean flag;
	
	public HomeAiub()
	{
		super("AIUB PORTAL INDEX");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,550);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		titel = new JLabel("AMERICAN INTERNATIONAL");
		titel.setBounds(150,20,500,30);
		titel.setBackground(Color.WHITE);
		titel.setForeground(Color.black);
		titel.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,40));
		titel.setOpaque(true);
		panel.add(titel);
				
		titel1 = new JLabel("UNIVERSITY-BANGLADESH");
		titel1.setBounds(180,50,500,35);
		titel1.setBackground(Color.WHITE);
		titel1.setForeground(Color.black);
		titel1.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,40));
		titel1.setOpaque(true);
		panel.add(titel1);
	
		titel2 = new JLabel("-where leaders are created");
		titel2.setBounds(200,120,700,35);
		titel2.setBackground(Color.WHITE);
		titel2.setForeground(Color.black);
		titel2.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,25));
		titel2.setOpaque(true);
		panel.add(titel2);	
			
		id = new JLabel("User ID");
		id.setBounds(220,230,100,30);
		panel.add(id);
		
		idTF = new JTextField();
		idTF.setBounds(290,230,200,30);
		panel.add(idTF);
		
		pass = new JLabel("Password");
		pass.setBounds(220,330,100,30);
		panel.add(pass);
		
		passPF = new JPasswordField();
		passPF.setBounds(290,335,200,30);
		passPF.setBackground(Color.WHITE);
		panel.add(passPF);
		
		login = new JButton("Log in");
		login.setBounds(230,400,260,40);
		login.setBackground(Color.BLUE);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		panel.add(login);
	
		img = new ImageIcon("img.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(10,0,100,100);
		panel.add(imgLabel);
		
		Student = new JRadioButton("Student");
		Student.setBounds(550,240,150,25);
		Student.setSelected(true);
		panel.add(Student);
		
		Faculty = new JRadioButton("Faculty");
		Faculty.setBounds(550,270,150,25);
		panel.add(Faculty);
		
		Admin = new JRadioButton("Admin");
		Admin.setBounds(550,300,150,25);
		panel.add(Admin);
		
		bg = new ButtonGroup();
		bg.add(Student);
		bg.add(Faculty);
		bg.add(Admin);
				
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		if(elementText.equals(login.getText()))
		{
			flag=true; 
			logintoDB();
		} 
	}
	
	public void logintoDB()
	{
        String query1 = "SELECT `Name`, `ID`, `Department`, `Password` FROM `student`;";     
        String query2 = "SELECT `Name`, `ID`, `Department`, `Password` FROM `faculty`;";
		String query3 = "SELECT `Name`, `ID`, `Password` FROM `admin`;";
		Connection con=null;
        Statement st = null;
		ResultSet rs = null;
		
		if(Student.isSelected())
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran","root","");
				System.out.println("connection done");
				st = con.createStatement();
				System.out.println("statement created");
				rs = st.executeQuery(query1);
				System.out.println("results received");
								
				while(rs.next())
				{
					String name = rs.getString("Name");
					int id = rs.getInt("ID");
					String dept = rs.getString("Department");
					int pass = rs.getInt("Password");
					String num = String.valueOf(id);
					String num1 = String.valueOf(pass);
					
					if(num.equals(idTF.getText()))
					{
						flag=false;
						if(num1.equals(passPF.getText()))
						{
							LogIn l = new LogIn(idTF.getText());
							this.setVisible(false);
							l.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(this,"Invalid pass"); 
						}
					}
				}
			}
			catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
			}
			finally
			{
				try
				{
					if(rs!=null)
					rs.close();

					if(st!=null)
					st.close();

					if(con!=null)
					con.close();
				}
				catch(Exception e){}
			}
		}
		else if(Faculty.isSelected())
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran","root","");
				System.out.println("connection done");
				st = con.createStatement();
				System.out.println("statement created");
				rs = st.executeQuery(query2);
				System.out.println("results received");
					
				while(rs.next())
				{
					String name = rs.getString("Name");
					int id = rs.getInt("ID");
					String dept = rs.getString("Department");
					int pass = rs.getInt("Password");
					String num = String.valueOf(id);
					String num1 = String.valueOf(pass);
					
					if(num.equals(idTF.getText()))
					{
						flag=false;
						if(num1.equals(passPF.getText()))
						{
							LogInT lt = new LogInT(idTF.getText());
							this.setVisible(false);
							lt.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(this,"Invalid pass"); 
						}
					}
				}
			}
			catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
			}
			finally
			{
				try
				{
					if(rs!=null)
					rs.close();

					if(st!=null)
					st.close();

					if(con!=null)
					con.close();
				}
				catch(Exception e){}
			}
		}
		else if(Admin.isSelected())
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran","root","");
				System.out.println("connection done");
				st = con.createStatement();
				System.out.println("statement created");
				rs = st.executeQuery(query3);
				System.out.println("results received");
					
				while(rs.next())
				{
					String name = rs.getString("Name");
					int id = rs.getInt("ID");
					int pass = rs.getInt("Password");
					String num = String.valueOf(id);
					String num1 = String.valueOf(pass);
					
					if(num.equals(idTF.getText()))
					{
						flag=false;
						if(num1.equals(passPF.getText()))
						{
							Admin ad = new Admin();
							ad.setVisible(true);
							this.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(this,"Invalid pass"); 
						}
					}
				}
			}
			catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
			}
			finally
			{
				try
				{
					if(rs!=null)
					rs.close();

					if(st!=null)
					st.close();

					if(con!=null)
					con.close();
				}
				catch(Exception e){}
			}
		}
		if(flag)
		{
			JOptionPane.showMessageDialog(this,"Invalid name"); 
		}
	}
}