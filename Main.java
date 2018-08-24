import java.util.*;

public class Main{
	public static void main(String[] args) {
		
	}
}
/*
//一组数中，选出最大的N个数  思路是用快速排序法，选出比某个数大的全在右边边，直到正好有N个数
import java.util.*;
public class Main {
	public static void main(String[] args) {
        int len = 10;
		int[] a = new int[len];
		for(int i=0;i<len;i++){
			a[i] = (int)(java.lang.Math.random()*100);
			System.out.print(a[i]+" ");
		}
		int[] b=new int[]{1,2,3,4,9,9,9,9,9,9 };
		System.out.println();
		int N = BigN(a, 0, len-1, 5);
		System.out.println(N);
		for(int j = N;j<len;j++){
			System.out.print(a[j]+" ");
		}    
	}
	public static int BigN(int[] m, int front, int rear, int N){
	    int length=m.length;
		if (length==0 ||  N>length || N<=0 || front>rear)
			return -1;
		if(N==length)
			return 0;
		int mid = 0;		
	    while(front <= rear){ //一定要有等于号，比如中间值即是rear也是front,没等号就会丢掉这个中间值
	        mid  = quick(m, front, rear);
	       int temp = rear - mid + 1;                // mid以右（包括mid）有temp个数
	   //    int temp = mid-front+1;  //最小的N个数，还要下面也要跟着改
	        if (temp == N)                    // 收工
	            break;
	        else if (temp > N) {               // 在右边找N个数
	            front = mid + 1; //mid + 1
	        }
	        else                        // 在左边找N-temp个数
	        {
	            rear = mid - 1;//mid - 1
	            N -= temp;
	        }
	    }
	    return mid;
	}
    public static int quick(int[] a, int low, int high){//快速排序
		int temp = a[low];
		while(low<high){
			while(low<high && a[high]>=temp){
				high--;
			}
			if(low<high){
				a[low] = a[high];
				low++;
			}
			while(low<high && a[low]<=temp){
				low++;
			}
			if(low<high){
			a[high] = a[low];
			high--;
			}
		}
		a[low] = temp;
		return low;
	}
}
*/

//微软404第二题网络IP，下面还一个位置需要改。
/*
import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		ArrayList<In> list=new ArrayList<In>();
		ArrayList<Long> li=new ArrayList<Long>();
		for(int i=0;i<N;i++){
			String ad=sc.next();
			String ip=sc.next();
			int index= ip.indexOf('/');
			if (index<2){
				In in=new In(ad,ip);
				list.add(in);
			}else{
				int mask=Integer.parseInt(ip.substring(index+1,ip.length()));
				String ip2=ip.substring(0,index);
				In in2=new In(ad,ip2,mask);
				list.add(in2);
				
			}
		}
		for(int i=0;i<M;i++){
			String s=sc.next();
			long ou=In.iptolong(s);
			li.add(ou);
		}
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				//int a=(int)li.get(i);
				String s1=Long.toBinaryString(li.get(i));
				System.out.println(s1); //第一位的1没有写成00000001，而是直接1，所以mask=30会越界
				String s2=Long.toBinaryString(list.get(i).ip);
				if(li.get(i)==list.get(j).ip ){
						System.out.println("YES");
						break;
				}
				if(list.get(j).mask!=0){
					if(s1.substring(0,list.get(j).mask).equals(s2.substring(0,list.get(j).mask))){
						System.out.println("YES");
					    break;
				}
				System.out.println("NO");
				break;
				
			}
		}
	}
}
}
class In{
	boolean yes=false;
	long ip;
	int mask;
	In(String s1,String s2,int mask){
		if(s1.equals("allow"))
			yes=true;
		ip=iptolong(s2);
		this.mask=mask;
	}
	In(String s1,String s2){
		if(s1.equals("allow"))
			yes=true;
		ip=iptolong(s2);
		this.mask=0;
	}
	public static long iptolong(String strip) 
	{ 
	int j=0; 
	int i=0; 
	long[]ip=new long[4]; 
	int position1=strip.indexOf("."); 
	int position2=strip.indexOf(".",position1+1); 
	int position3=strip.indexOf(".",position2+1); 
	ip[0]=Long.parseLong(strip.substring(0,position1)); 
	ip[1]=Long.parseLong(strip.substring(position1+1,position2)); 
	ip[2]=Long.parseLong(strip.substring(position2+1,position3)); 
	ip[3]=Long.parseLong(strip.substring(position3+1)); 
	return(ip[0]<<24)+(ip[1]<<16)+(ip[2]<<8)+ip[3];//ip1*256*256*256+ip2*256*256+ip3*256+ip4 
	}
}

//class In2{
//	boolean yes=false;
//	StringBuilder s;
//	int mask;
//	In2(String s1,int a,int b,int c,int d,int mask){
//		if(s1.equals("allow"))
//			yes=true;
//		String aa=Integer.toBinaryString(a);
//		s.append(aa.substring(24,32));
//		String bb=Integer.toBinaryString(b);
//		s.append(bb.substring(24,32));
//		String cc=Integer.toBinaryString(c);
//		s.append(cc.substring(24,32));
//		String dd=Integer.toBinaryString(d);
//		s.append(dd.substring(24,32));
//		this.mask=mask;
//	}
//}
*/

/*

//微软第一题，手机屏幕，最大字体设置
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		ArrayList<In> list=new ArrayList<In>();
		for(int i=0;i<test;i++){
			int n=sc.nextInt();
			int p=sc.nextInt();
			int w=sc.nextInt();
			int h=sc.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++){
				a[j]=sc.nextInt();
			}
			In in=new In(n,p,w,h,a);
			list.add(in);
		}
		for(int i=0;i<test;i++){
			size(list.get(i).N,list.get(i).P,list.get(i).W,list.get(i).H,list.get(i).a);
		}
	}
	public static void size(int N,int P,int W,int H,int[] a){
		double suma=0;
		for(int i=0;i<N;i++){
			suma+=a[i];
		}
		
		int smax=(int)Math.sqrt((W*H*P/suma));
		for(int s=smax;s>=1;s--){
			int[] col=new int[N];
			int linesum=0;
			for(int i=0;i<N;i++){
				col[i]=line(a[i],s,W);
				linesum+=col[i];
			}
			int pnum=line(linesum,s,H);
			if(pnum<=P){
				System.out.println(s);
				return;
			}
		}
	}
	public static int line(int a,int s,int W){
		if(a==0)
			return 0;
		if(a*s<=W){
			return 1;
		}else{
			int a2=a-W/s;
			return 1+line(a2,s,W);
		}
	}

}
class In{
	int N;
	int P;
	int W;
	int H;
	int [] a=new int[N];
	In(int n,int p,int w,int h,int[] a){
		N=n;
		P=p;
		W=w;
		H=h;
		this.a=a;
	}
}
*/

//京东信封卡片问题
/*
import java.util.*;
public class Test1{
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		while(in.hasNext()){
			int N=in.nextInt();
			int w=in.nextInt();
			int h=in.nextInt();
			int[] wf=new int[N];
			int[] hf=new int[N];
			for(int i=0;i<N;i++){
				wf[i]=in.nextInt();
				hf[i]=in.nextInt();
			}
			yangxm(N,w,h,wf,hf);
		}
	}
	public static void yangxm(int N,int w,int h,int[] wf,int[] hf){
		if(N==0)
			return;
		boolean yes=false;
		ArrayList<Emp> hp=new ArrayList<Emp>();
		for(int i=0;i<N;i++){
			if(wf[i]>w && hf[i]>h){
				int s=wf[i]*hf[i];
				Emp e=new Emp(i+1,s); //信封是从1开始的，所以是下标+1
				hp.add(e);
				yes=true;
			}
		}
		if(!yes){
			System.out.println(0);
			return;}
		Collections.sort(hp);
		for(Emp a:hp){
			System.out.println(a);
		}
	}
}
class Emp implements Comparable<Emp>{
	 int id;
	 int age;
	public Emp(int id,int age){
		this.id=age;
		this.age=id;
	}
	public String toString(){
		return String.valueOf(age);
	}
	@Override
	public int compareTo(Emp e){
		if(id>e.id)
			{return 1;}
		else if(id<e.id)
			{return -1;}
		else
			return 0;
	}
}
*/
/*
//京东小球落地题目
import java.util.*;
public class Test1{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[] h=new int[4];
		for(int i=0;i<4;i++){
			h[i]=in.nextInt();
		}
		int sumHeight=0;
		for(int i=0;i<4;i++){
			sumHeight+=yangxm(h[i]);
		}
		System.out.println(sumHeight);
	}
	static public int yangxm(int height){
		if(height<=0)
			return 0;
		int sum=height;
		int h=height>>1;
		
		while(h!=0){
			sum+=h<<1;
			h=h>>1;
		}
		return sum;
	}
}
*/
/*
//京东走台阶题目
import java.util.*;

public class Test1{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] taijie=new int[n];
		for(int i=0;i<n;i++){
			taijie[i]=in.nextInt();
		}
		for(int i=0;i<n;i++){
			int a=yangxm(taijie[i]);
			System.out.println(a);
		}
	} 
	static public int yangxm(int m){
		int n=m-1;
		if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		int pre1=1;
		int pre2=2;
		int f=0;
		for(int i=3;i<=n;i++){
			f=pre1+pre2;
			pre1=pre2;
			pre2=f;
		}
		return f;
	}
}
*/

//360 猜数字的题目
/*
public class Test1{
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		while(sin.hasNext()){
			int n=sin.nextInt();
			int b=sin.nextInt();
			int a=0;
//			if(b>1 || b>n || n>1000000000)
//				return;
			if(n%2==0)
			{
				if(b<=n/2)
				{
					a=b+1;
				}
				else
				{
					a=b-1;
				}
			}
			else if(n%2==1)
			{
				if(b>n/2)
				{
					a=b-1;
				}
				else
				{
					a=b+1;
				}
			}
			System.out.println(a);
		}
	}
}
*/
