import java.lang.*;

public class Marks
{
	private String mark;
	private String grade;
	private float  point;
	
	public Marks(String m,String g,float p)
	{
		this.grade=g;
		this.mark=m;
		this.point=p;
	}

	public String getMark()
	{
		return mark;
	}
	
	public String getGrade()
	{
		return grade;
	}
	
	public float getPoint()
	{
		return point;
	}
}