public class StackSb 
{
	private StringBuilder[] s;
	private int top;
	public StackSb()
	{
		top=-1;
		s = new StringBuilder[100];
	}
	public void push(StringBuilder sb)
	{
		if(top<50)
			s[++top] = new StringBuilder(sb);
	}
	public StringBuilder pop()
	{
		if(top>=0)
		{
			StringBuilder sb = s[top];
			top--;
			return sb;
		}
		return null;
	}
}