public class Mergesort
{
	public static void sort(IndexWeightNode iwn,int lo,int hi)
	{
		if(lo<hi)
		{
			int m = (lo+hi)/2;
			sort(iwn,lo,m);
			sort(iwn,m+1,hi);
			merge(iwn,lo,hi);
		}
	}
	public static void merge(IndexWeightNode iwn,int lo,int hi)
	{
		int i,j,k;
		double b[] = new double[hi-lo+1];
		int d[] = new int[hi-lo+1];
		int m = (hi+lo)/2;
		for(i=0;i<hi-lo+1;i++)
		{
			b[i] = iwn.weight[lo+i];
			d[i] = iwn.index[lo+i]; 
		}
		i=lo;
		j=m+1;
		k=lo;
		while(i<=m && j<=hi)
		{
			if(b[i-lo]<=b[j-lo])
			{
				iwn.weight[k] = b[j-lo];
				iwn.index[k] = d[j-lo];
				k++;
				j++;
			}
			else
			{
				iwn.weight[k] = b[i-lo];
				iwn.index[k] = d[i-lo];
				k++;
				i++;
			}
		}
		while(i<=m)
		{
			iwn.weight[k] = b[i-lo];
			iwn.index[k] = d[i-lo];
			k++;
			i++;
		}
		while(j<=hi)
		{
			iwn.weight[k] = b[j-lo];
			iwn.index[k] = d[j-lo];
			k++;
			j++;
		}
	}
	/*public static void main(String arg[])
	{
		int array[],x,size;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of the array : ");
		size = s.nextInt();
		array = new int[size];
		System.out.println("Enter the elements of the array : ");
		for(x=0;x<size;x++)
			array[x] = s.nextInt();
		sort(array,0,size-1);
		System.out.print("Output : ");
		for(x=0;x<size;x++)
			System.out.print(array[x] + " ");
		s.close();
	}*/
}