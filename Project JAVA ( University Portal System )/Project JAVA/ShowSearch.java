import java.lang.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ShowSearch extends JFrame implements ActionListener
{
	JTable myTable;
	private JLabel welcome,imgLabel;
	private ImageIcon imge;
	JScrollPane scrollPane;
	JButton ok;
	JPanel panel;
	OfferedS s;
	
	public ShowSearch(OfferedS s)
	{
		super("AIUB STUDENT PORTAL");
		this.setSize(800,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.s=s;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		imge = new ImageIcon("img1.png");
		imgLabel = new JLabel(imge);
		imgLabel.setBounds(0,20,150,70);
		panel.add(imgLabel);
		
		welcome = new JLabel(" WELCOME TO AMERICAN INTERNATIONAL UNIVERSITY BANGLADESH");
		welcome.setBounds(140,20,800,60);
		welcome.setBackground(Color.BLUE);
		welcome.setForeground(Color.white);
		welcome.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		welcome.setOpaque(true);
		panel.add(welcome);
		
		String []col = {"Name","ID"};
		
		String query = "SELECT `Name`,`ID` FROM `course` WHERE `Name`='"+this.s.stf.getText()+"';";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(col);
		myTable = new JTable();
		myTable.setModel(model); 
		myTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane = new JScrollPane(myTable);
		String name = "";
		int id;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran","root","");
			st = con.createStatement();
			rs = st.executeQuery(query);
			int i=0;
			while(rs.next())
			{
				name = rs.getString("Name");
				id = rs.getInt("ID");
								
				model.addRow(new Object[]{name,id});
				i++;
			}
			if(i==0)
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+e.getMessage());
			JOptionPane.showMessageDialog(this,"No Records.");
		}
		finally
		{
			try
			{
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			}
			catch(Exception ex){}
		}
		
		scrollPane.setBounds(100,100,400,100);
		panel.add(scrollPane);
		
		ok = new JButton("OK");
		ok.setBounds(300,400,100,40);
		ok.setBackground(Color.BLUE);
		ok.setForeground(Color.WHITE);
		ok.setFont(new Font("Calibri",Font.ITALIC,25));
		ok.addActionListener(this);
		panel.add(ok);
		
		this.add(panel);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		if(elementText.equals(ok.getText()))
		{
			s.setVisible(true);
			this.setVisible(false);
		}
	}
}