package yang.paixu;

import java.util.*;

public class Paixu_demo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a={2,5,8,4,267,8,23,1,4,3,-6,-8,46,234,78,2,1,45};
		//Xuanze.sort(a);
		//Maopao.sort(a);
		//Charu.sort(a);
		//Kuaisu.sort(a,0,a.length-1);
		//Shell.sort(a);
		//Dui.sort(a);
		Merge.sort(a, 0, a.length-1);
	//	System.out.println(Arrays.toString(a)); //这样打出来有两边有中括号，直接写a打印出来是地址
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"  ");
		}
		System.out.println();
		Bfind.find(0, a.length-1, 23, a);
		MaxMin A=new MaxMin();
		//A.getm(a); //这样不行，因为我的内部类以及方法都是static的所以不能用MaxMin的对象去调用，而应该直接用类名字
		MaxMin.Result B=new MaxMin.Result();
		B=MaxMin.getM(a);
		System.out.println(B.max+"  "+B.min);
		System.out.println(MaxMin.getM(a).getMax());//或者这种方式访问也行，不用创建对象B

	}

}
//内部类寻找数组最值
class MaxMin{
	public static class Result{
		int max;
		int min;
		public Result(){
			
		};
		public Result(int max, int min){
			this.max=max;
			this.min =min;
		}
		public int getMax(){
			return this.max;
		}
		public int getMin(){
			return min;
		}
	}
	public static Result getM(int [] s){
		int maxs=s[0];
		int mins=s[0];
		for(int i=1;i<s.length;i++)
		{
			if(s[i]<mins)
				mins=s[i];
			if(s[i]>maxs)
				maxs=s[i];
		}
		return new Result(maxs,mins);
	}
}

//二分查找
class Bfind{  //可以用递归实现，也可以用循环实现。
	public static void find(int left,int right, int x,int[] s){
		if(left>right)
			return;
		int m = (left + right) >> 1;
		int mid = s[m];
			if(mid==x)
			{
				System.out.println("找到位置，下标为："+m);
			}
			else if(mid>x)
			{
				find(left,m-1,x,s);
			}
			else
			{
				find(m+1,right,x,s);
			}
	}//下面用循环实现,返回下标值
	public static int find(int x,int[] s){
		int len=s.length;
		if(s==null || s==0) return -1;
		int low=0,high=len-1;
		while(low<=high){//这个＝一定要加，只有数值＝x才在这里返回，否则即使low＝high也，但是数不等于x
			int mid=low+((high-low)>>1);  //也要返回－1，没找到。
			if(s[mid]==x) return mid;
			if(s[mid]>x)
				high=mid-1;
			else 
				low=mid+1;
		}
		return -1;
	}
}

//基数排序 base 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
//然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
//有点像hashmap的结构，数据加链表。详见http://www.cnblogs.com/liuling/p/2013-7-24-01.html

//归并排序 merge  当左右序列有序时，归并可以O(1)空间解决，见leetcode sort list
class Merge{
	public static void sort(int [] s,int left,int right){
		if(left<right){
			int middle = (left+right)>>1;
			sort(s,left,middle); //左边递归
			sort(s,middle+1,right);//右边递归
			mer(s,left,middle,right);//合并
		}
	}
	public static void mer(int[] s,int left,int middle,int right){
		int[] tmpArr =new int[s.length];//额外空间O(n),可以在外层函数中创建这个数组，当作参数传入。他的长度其实就是right-left+1
		int tmp3=left;//这是上面的指针                  //但是不能在这里这样建，因为，虽然长度是怎么长，但是left这些值可能是很大的，所以要处理才可以
		int rm=middle+1; //右边的开始位置	
		int temp=left;  //指针，用于最后面将上面得到的排序好的tmpArr数组复制到真正原来的数字s中
		while(left<=middle && rm<=right){
			if(s[left]<=s[rm]){//从左右两个数组中选取较小的数放入中间数组
				tmpArr[tmp3++]=s[left++];
			}else{
				tmpArr[tmp3++]=s[rm++];
			}
		}
		//将 左或者右 剩余的部分放入中间数组，即两边不一样长，谁剩下，谁接着放
		while(left<=middle){
			tmpArr[tmp3++]=s[left++];
		}
		while(rm<=right){
			tmpArr[tmp3++]=s[rm++];
		}
	//	int temp=left; //这个指针不能放在这，因为这是left已经不是原始的数组开始位置了，所以要放前面定义
		while(temp<=right){
			s[temp]=tmpArr[temp];
			temp++;
		}
	}
}

//堆排序  heap
class Dui{
	public static void sort(int[] s){
		int length=s.length;
		for(int i=0;i<length-1;i++){//n-1次循环建堆
			maxHeap(s,length-1-i); //建堆
			int temp=s[0];  //交换堆顶和最后一个元素  
			s[0]=s[length-1-i];
			s[length-1-i]=temp;
		}
	}
	public static void maxHeap(int[] s,int end){
		//从lastIndex处节点（最后一个节点）的父节点开始 ，因为这里数组是从0开始，所以节点i对应子节点2*i+1和2*i+2. 
		for(int i=(end-1)>>1;i>=0;i--){ //end-1再除以2得到父节点
			int k=i; //k保存正在判断的节点 
			while((k<<1)+1<=end){//如果当前k节点的子节点存在 ,因为左节点存在就说明有有，移位就是2×k+1左节点
				int big=(k<<1)+1; //左子,先把子节点中较大的默认为左节点
				if(big<end){//左子小于end，说明右子(big+1)存在
					if(s[big]<s[big+1]) //这句和后面的比较交换是，同时改成大于号，就是最小堆，可以从大到小排
						big++; //big总是记录较大子节点的索引 
				}
				//如果k节点的值小于其较大的子节点的值
				if(s[k]<s[big]){//这句和上面的比较子节点选小的那句，同时改成大于号，就是最小堆，可以从大到小排
					int temp=s[k];
					s[k]=s[big];
					s[big]=temp; //下面这句就是while一次后k变化，变成下沉的那个节点，继续保证下沉的节点也满足大于子节点
					k=big;//将big赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
				}else{
					break;//跳出while
				}
			}
		}
	}
}

//shell排序 希尔排序
class Shell{
	public static void sort(int[] s){
		int length=s.length;
		int step=length>>1;
		while(step>0){
			for(int i=step;i<length;i++){//下面的插入排序，可以用两种思路，见插入排序
				for(int j=i-step;j>=0 && s[j]>s[j+step];j=j-step){
					int temp=s[j];
					s[j]=s[j+step];
					s[j+step]=temp;
				}
			}
			step=step>>1;
		}
	}
}

//快速排序
class Kuaisu{
	public static void sort(int[] s,int left,int right){
		if(left<right){
		int l=left;
		//把比较值的挖出来形成一个坑
		int temp=s[l]; //这句话很重要，并非是都让等于s[0]而是等于那个当比较的值，并且不能定死了，要用Left这种索引值
		int r=right;
		// 或者用中间的当比较值
		//int temp=s[(left+right)/2];
		while(l<r)
		{
			while(r>l && s[r]>=temp) 
				r--;
			if(r>l)
			{
				s[l]=s[r]; //从右边，把比temp值小的填到这个坑里，这是右边那个找到的值小的位置就是一个新坑
				l++;
			}
			while(l<r && s[l]<=temp)
				l++;
			if(l<r)
			{
				s[r]=s[l];//从左边，把比temp大的挖出填到刚才那个新坑里面
				r--;
			}
		}//这个while结束后，比temp小的都在左边，比temp大的都在右边
		s[r]=temp; //此时l=r，怎么写无所谓，这个是中间值，下面两个递归再排两边
		sort(s,left,r-1);//递归
		sort(s,r+1,right);
	}
}
}
//插入排序  每一个值往已经排好序的数字中插入，由后向前插
class Charu{
	public static void sort(int[] s){
		int temp=0;
		for(int i=1;i<s.length;i++)
		{
			for(int j=i-1;j>=0 && s[j]>s[j+1];j--)
			{
			//下面思路，类似于冒泡，如果大于s[i]就交换，一直交换到不大为止
				temp = s[j];
				s[j] = s[j + 1];
				s[j + 1] = temp;
			//还可以用另一种思路，先将比temp即当前s[i]放在temp中，然后将比temp大的向后一位
			//直到不比temp大的数出现，然后将temp插入这个位置。
//				int tmp = s[i];
//                for(j = i-1; j >= 0 && s[j] > tmp; j--) {
//                    s[j+1] = s[j];
//                }
//                s[j+1] = tmp;
			}
		}
	}
}
//选择排序  每次选剩下中的最小的放前面
class Xuanze{
	public static void sort(int[] s){
		for(int i=0;i<s.length-1;i++)
		{
			for(int j=i+1;j<s.length;j++)
			{
				if(s[i]>s[j])
				{   //只有int类型才可以使用这种方式交换，double类型不可以
					s[i]=s[i]^s[j];
					s[j]=s[i]^s[j];
					s[i]=s[i]^s[j];
				}
			}
		}
		System.out.println("选择排序方法：");
	}
}
//冒泡排序
class Maopao{
	static int temp=0;
	public static void sort(int[] s){
		for(int i=0;i<s.length-1;i++)
		{
			for(int j=0;j<s.length-1-i;j++)
			{
				if(s[j]>s[j+1])
				{
					temp=s[j];
					s[j]=s[j+1];
					s[j+1]=temp;
				}
			}
		}
		System.out.println("冒泡排序方法：");
	}
}

