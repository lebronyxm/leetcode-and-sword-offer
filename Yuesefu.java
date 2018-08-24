package test.yang;
//剑指offer 45题有分析过程
//约瑟夫问题，丢手帕问题   用循环链表模拟报数、淘汰的过程，复杂度是O(NM)。
/*
public class Yuesefu{
	public static void main(String [] args){
			int m=5; //5 people
			int n=0;  //start # 0代表从第一个人开始数
			int k=2;  //number
			int len=m;
			int[] man= new int[m];
			for(int i=0;i<man.length;i++)
			{
				man[i]=i+1;
				//System.out.print(man[i]);
			}
			int j=1;  //从1开始数
			while(len>0)
			{
				if(man[n%m]>0)
				{
					if(j%k==0)
					{  //这边可以判断length=1后break出来，节省最后遍历
						System.out.println(man[n%m]);
						j=1;
						len--;
						man[n%m]=-1;
						n++;
					}
					else
					{
						n++;j++;
					}
				}
				else
				{
					n++;
				}
			}
			System.out.println(man[n%m]);
	}
}
*/
//多组输入，人下标从0开始，增加最后一人判断
/*
import java.util.*;
public class Yuesefu{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        ArrayList<Integer> listn=new ArrayList<Integer>();
        ArrayList<Integer> listk=new ArrayList<Integer>();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            listn.add(n);
            listk.add(k);
        }
        for(int i=0;i<t;i++){
            int result=ysf(listn.get(i),listk.get(i));
            System.out.println(result);
        }
    }
    public static int ysf(int n,int k){
        int[] man=new int[n];
        for(int i=0;i<n;i++){
            man[i]=i;
        }
        int length=n;
        int i=0,j=1,flag=0;
		while (length > 0) {
			if (man[i % n] >= 0) {
				if (length == 1) {
					flag=man[i%n];
					break;
				} else {
					if (j == k) {
						man[i % n] = -1;
						i++;
						j = 1;
						length--;
					} else {
						i++;
						j++;
					}
				}
			} else {
				i++;
			}
		}
        return flag;
    }
}
*/
// 递推的优化方法，时间O(N)，空间O(1)  处理N和K特别大的情况
//令f[n]表示当有n个候选人时，最后当选者的编号。对于N不是很大的数据来说
//f[1] = 0
//f[n] = (f[n - 1] + K) mod n
//如果N很大，可以先减少规模到K，然后用上面这中递推方式。减少规模如下
//1) s < N mod K : s' = s - N mod K + N
//2) s ≥ N mod K : s' = s - N mod K + (s - N mod K) / (K - 1)
//因此最终优化的代码如下：
//Josephus(N, K):
//	If (N == 1) Then
//		Return 0
//	End If
//	If (N < K) Then
//		ret = 0
//		For i = 2 .. N
//			ret = (ret + K) mod i
//		End For
//		Return ret
//	End If 
//	ret = Josephus(N - N / K, K);
//	If (ret < N mod K) Then 
//		ret = ret - N mod K + N
//	Else
//		ret = ret - N mod K + (ret - N mod K) / (K - 1)
//	End If
//	Return ret

import java.util.*;
public class Yuesefu{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        ArrayList<Integer> listn=new ArrayList<Integer>();
        ArrayList<Integer> listk=new ArrayList<Integer>();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            listn.add(n);
            listk.add(k);
        }
        for(int i=0;i<t;i++){
            int result=ysf(listn.get(i),listk.get(i));
            System.out.println(result);
        }
    }
    public static int ysf(int n,int k){
    	if(n==1)
    		return 0;
    	if(n<k){
    		int fn=0;
    		for(int i=2;i<=n;i++){
    			fn=(fn+k)%i;
    		}
    		return fn;
    	}
    	int fn=ysf(n-n/k,k);
    	if(fn<(n%k)){
    		fn=fn-(n%k) +n;
    	}else{
    		fn= fn- (n%k)+(fn-(n%k))/(k-1);
    	}
    	return fn;
    }
}




