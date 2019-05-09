import java.lang.*;

public class Course
{
	private int id;
	private String name;
	
	public Course(){}
	
	public Course(String n,int i)
	{
		this.name=n;
		this.id=i;
	}

	public String getCourseName()
	{
		return name;
	}
	
	public int getCourseId()
	{
		return id;
	}
	
	public void setCourseName(String name)
	{
		this.name=name;
	}
	
	public void setCourseId(int id)
	{
		this.id=id;
	}
}