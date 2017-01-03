import java.io.*;
public class Files 
{
	public static void urlindexfile(String url)
	{
		String path = new String("./urlindex.txt");
		File file = new File(path);
		if(!(file.exists() && !file.isDirectory()))
		{
			try
			{
				String block = new String("1                       \n1 " + url);
				boolean bool = file.createNewFile();
				if(bool == true)
				{
					PrintWriter out = new PrintWriter(path);
					out.print(block);
					out.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			};
		}
		else
		{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(path));
				String line = br.readLine();
				
				
				int k = 0;
				while(line.charAt(k) != ' ')
					k++;
				int y = Integer.parseInt(line.substring(0,k));
				y++;
				while((line = br.readLine()) != null)
				{
					k=0;
					while(line.charAt(k) != ' ')
						k++;
					String checkurl = new String(line.substring(k+1));
					if(checkurl.compareTo(url) == 0)
					{
						br.close();
						throw new Exception("URL Exists");
					}
				}
				br.close();
				
				String block = new String("\n" + y + " " +url);
				
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
				out.print(block);
				out.close();
				
				RandomAccessFile f = new RandomAccessFile(new File(path), "rw");
				String s = "" + y;
				f.seek(0);
				f.write(s.getBytes());
				f.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			};
		}
	}
	public static void main(String[] args)
	{
		int i=97;
		char c = (char) i;
		System.out.println(c);
	}
	
}