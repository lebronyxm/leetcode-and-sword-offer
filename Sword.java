package yang.sowrd;

import java.util.*;
/*
//2单例模式
public class Sword {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	//	SingletonClass sc=new SingletonClass(); //这样不行，因为构造函数是private，不可外部用
		SingletonClass sc=SingletonClass.getIn();
	}

}
// 三、静态内部类 优点：加载时不会初始化静态变量INSTANCE，因为没有主动使用，达到Lazy loading

class SingletonClass{
	private SingletonClass(){
		
	}
	public static final SingletonClass getIn(){
		System.out.println("OK!");
		return Need.ins;
	}
	private static class Need{ //静态内部类的方法
		Need(){                  //按需分配，显式调用getIn时，才会实例化
			
		}
	private	static final SingletonClass ins= new SingletonClass();
	}
}
//二、恶汉,缺点：没有达到lazy loading的效果
class HungrySingleton{
    private static HungrySingleton singleton=new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return singleton;
    }
}
// 一、懒汉，常用的写法
class LazySingleton{
    private static LazySingleton singleton;
    private LazySingleton(){
    }
    public static LazySingleton getInstance(){
        if(singleton==null){
            singleton=new LazySingleton();
        }
        return singleton;
    }   
}
*/
//3二维数组查找
/*
public class Sword{
	public static void main(String[] args) {
     int[][] testarray={{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15}};
     System.out.println(find(testarray,9));
	}
static	public boolean find(int[][] num, int f){
		if(num.length==0)
			return false;
		int row=num.length;
		int col=num[0].length;
		int i=row-1;
		int j=0;
		while(i>=0 && j<col){
			if(num[i][j]==f)
				return true;
			if(num[i][j]<f)
			{
				j++;
			}else{
				i--;
			}
		}
		return false;
	}
}
*/
//4替换字符
/*
class Tihuan{
	public String ti(char[] s){
		String t=s.toString().replaceAll(" ", "%20");
		return t;
	}
}
*/
/*
#include<iostream>
using namespace std;
//#include<cmath>  // math.h是C的用法，当然在C++中也行
//将字符串中的yes换成no，  思路：直接总前往后复制，最后将多余的内容清空
void Re(char b[], int length)
{
	 计算有多少个yes,不过可以不用这一步，保留是为了多一个功能以后可能有用
	if(b==NULL || length<=0)
		return;
	int ori=0;
	int yes=0;
	int i=0;
	while(b[i]!='\o'){
		++ori; 
		//cout<<i<<endl;
		if(b[i]=='y'&&b[i+1]=='e'&&b[i+2]=='s')
		{	++yes;
		    i=i+3;
		}else{
			i++;}
	}
//==========以上这段可以不用统计，字符变短的不需要，变成就要了
	int newlength=length-yes;
	
	int  indexori=0;
	int  indexnew=0;

	while(indexori<length)
	{
		//cout<<b[indexori]<<endl;
		if(b[indexori]=='y'&&b[indexori+1]=='e'&&b[indexori+2]=='s')
		{
			b[indexnew++]='n';
			indexori++;
			b[indexnew++]='o';
			indexori++;
			b[indexnew]=b[indexori+1];
			indexori++;
		}
		else{
			
			b[indexnew++]=b[indexori++];
		}
	}
	
	for(int i=indexnew--;i<length;i++)
	{
		//cout<<b[i]<<endl;
		b[i]=NULL; //NULL
	}
	
	//cout<<b<<endl;
}
int main()
{
	char a[]="yesabcyes";
	Re(a,a.strlen);
	//for(int i=0;i<9;i++)
	cout<<a;
	return 0;

}
*/
//5反向打印链表
/*
import java.util.*;
public class Sword{
	public static void main(String[] args) {
		
	}
}
class inversePrint{
	static public void stackPrint(ListNo head){
		Stack<Integer> s= new Stack<Integer>();
		if(head==null)
			return;
		while(head!=null){
			s.push(head.val);
			head=head.next;
		}
		while(!s.isEmpty()){
			System.out.print(s.pop()+" ");
		}
	}
	//递归方式打印，鲁棒性不如上面stack好，节点太多，递归层次太多不好
	static public void recursivePrint(ListNo head){
		if(head==null)
			return;
		recursivePrint(head.next);
		System.out.print(head.val+" ");
	}
}
class ListNo{
	int val;
	ListNo next=null;
	ListNo(int i){
		this.val=i;
	}
}
*/
//6重建二叉树  已知先序遍历和中序遍历，求后序遍历,重建出这棵树。
/*
import java.util.*;
public class Sword{ //构建出这棵树
	public static void main(String[] args) {
		
		int[] pre={1,2,4,7,3,5,8,6};
		int[] in={4,7,2,1,5,3,8,6};
		TN root=consTree(pre,in);
		//可以用之前写的打印，遍历等函数查看结果
	}
	public static TN consTree(int[] pre,int[] in){
		if(pre.length==0 || in.length==0 || pre.length!=in.length)
		{
			System.out.println("空树或者输入个数不等");
			return null;
		}
		TN root= new TN(pre[0]);//根节点
		boolean have=false;
		for(int i=0;i<in.length;i++)
		{
			if(in[i]==root.val)
			{
				have=true;  //判断是不是真有，可能上面的pre[0]并不是跟节点，即in中找不到，所以后面判断输出null,不是直接输出root
				int[] pre2left=Arrays.copyOfRange(pre,1,1+i);
				int[] in2left=Arrays.copyOfRange(in,0,i);
				root.left=consTree(pre2left,in2left);
				int[] pre2right= Arrays.copyOfRange(pre,1+i,pre.length);
				int[] in2right = Arrays.copyOfRange(in,i+1,in.length);
				root.right=consTree(pre2right,in2right);
			}
		}
		if(!have){
			System.out.print("没有根节点，输入错误");
					return null;
		}
		return root;
	}
}
class TN{
	TN left;
	TN right;
	int val;
	TN(int i){
		val=i;
		left=null;
		right=null;
	}
}
*/
//下面方法之打印后序遍历，没有构建树
/*
import java.util.*;

public class Sword{
 public static void main(String[] args){
     Scanner sc= new Scanner(System.in);
     String pre=sc.next();
     String in=sc.next();
     hx(pre,in);
 }
 public static void hx(String pre,String in){
     int lenPre=pre.length();
     int lenIn = in.length();
     if(lenPre==0 || lenIn==0 || (lenPre!=lenIn) )
        return;
     boolean have=false;
     for(int i=0;i<lenIn;i++){
         if(in.charAt(i)==pre.charAt(0)){
             have=true;
             String leftPre=pre.substring(1,i+1);
             String leftIn=in.substring(0,i);
             hx(leftPre,leftIn);
             String rightPre=pre.substring(i+1,lenPre);
             String rightIn =in.substring(i+1,lenIn);
             hx(rightPre,rightIn);
         }
     }
     if(!have){
         return;
     }
     System.out.print(pre.charAt(0));
 }
}
*/


//7两个stack堆栈实现队列queue
/*
import java.util.*;
class StaQueue{
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();
	public void push(int node){
		s1.push(node);
	}
	public int pop(){
		if(s2.isEmpty()){
			while(!s1.empty()){
				s2.push(s1.pop());
			}
			return s2.pop();
		}
		if(s2.isEmpty()){ //这句判读从s1弹到S2后，是不是真的弹入了，可能s1本身已经没了，就不能pop
			System.out.println("Queue中没有元素不能pop");
			return -1; 
		}
		return s2.pop();
	}
}
*/
//8旋转数组的最小数字  二分查找
/*
public class Sword {
	public static void main(String args[])
	{
		FindMin testMin=new FindMin();
		int[] array={1,1,1,2,3};
		System.out.println(testMin.find(array));
	}

}
class  FindMin{
	public int find(int[] array){
		if(array.length==0)
			try {
				throw new Exception("输入数组为空");
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		int left=0;
		int right=array.length-1;
		int mid=left;
		while(array[left]>=array[right])
		{
			if(left+1==right){ //只有两个数，则后面的是小的
				mid=right;
				break;
			}
			mid = (left+right)/2;
			if(array[left]==array[mid] && array[mid]==array[right]) //只能顺序查找
			{
				int temp=array[left];
				for(int i=left+1;i<=right;i++){
					if(temp>array[i])
						temp=array[i];
				}
				return temp;
			}
			//上面是顺序查找
			if(array[left]<=array[mid]){
				left=mid;
			}else if(array[mid]<=array[right])
			{
				right=mid;
			}
		}
		return array[mid];
	}
}
*/
//9斐波那契数列  青蛙跳台阶  矩形中放矩形
/*
public class Sword{
	public static void main(String[] args) {
		int a=fb(4);
		System.out.println(a);
	}  //递归方法不好，重复计算很多项，所以用下面的一维DP（动态规划）
	static int fb(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		int pre1=0;
		int pre2=1;
		int f=0;
		for(int i=2;i<=n;i++){
			f=pre1+pre2;
			pre1=pre2;
			pre2=f;
		}
		return f;
	}
}
*/
//青蛙变态跳台阶 2^(n-1) ,一次可以跳1，2，3，，，n种，用科学归纳法可以证明f(n)=f(n-1)+f(n-2)+```+f(1);
/*          // f(n-1)=f(n-2)+```+f(1)   so f(n)=2*f(n-1)
public class Sword{
	public static void main(String[] args) {
		int a=f(4);
		System.out.println(a);
	}
	static int f(int n){
		return (int)Math.pow(2, n-1);
		//return 1<<(n-1);  //用以为代替更直接，不过上面的函数也很好，是内部优化的，速度不比移位慢。
	}
}
*/
//10位运算 二进制中1的个数
/*
public class Sword{
	public int number(int num){
		int n=0;
		while(num!=0){
			num=num&(num-1);
			n++;
		}
		return n;
	}
}
*/
//11 数值的整数次方
//数值的整数次方，要注意的是：指数是负数还是正数还是0
//两个1/2次幂的相乘, 32次方求得16次就行，递归，奇数的再乘以次自己
/*
public class Sword{
	public double power(double base,int n){
		//0的负数次方无意义，0的0次方也没有意义，但有时定为1，有时为0
		//double的和float的数值比较不能用==，因为有误差，所以用相减<0.00000001判断
		if(Math.abs(base)<0.00000001 && n<0)  return 0.0;
		if(n==0) return 1;
		boolean fushu=false;
		if(n<0){
			fushu=true;
			n=-n;
		}
		if(n==1) return base;
		double ex=power(base,n>>1); //用移位代替整除2，int类的乘除2都可以用移位
		double result=ex*ex;
		if((n&1)==1){  //(n%2==1)
			result*=base;
		}
		if(fushu)
			return 1.0/result;
		return result;
	}
}
*/
//12 打印1到最大的n位数       //或者使用数组应该也行
//打印0-n位数字中的所有数字，其中要考虑数字超标，比如200位，long和int都不行了，智能使用字符串进行打印

//13 O(1)时间删除单向链表节点
/*
public class Sword{
	public static void main(String[] args) {
		int N=10;
		ListNode[] lists = new ListNode[N];
		for(int i=0;i<N;i++)
		{
			lists[i]=new ListNode(i);
		}
		for(int i=0;i<N-1;i++)
		{
			lists[i].next = lists[i+1];
		}
		ListNode aa=lists[N/2];
		//System.out.println(aa.val);
		delete(lists[0],aa);
		//System.out.println(aa.val);
		printlist(lists[0]);
		delete(lists[0],lists[N-1]);
		printlist(lists[0]);
	}
	
	public static void printlist(ListNode head)
	{	
		ListNode p = head;
		while(p.next!=null)
		{
			System.out.print(p.val+"->");
			p=p.next;
		}
		System.out.println(p.val);
	}
	// 前一个参数是输入的链表头，后一个是要删除的点
	public static void delete(ListNode head,ListNode node){ 
		if(head==null || node==null)
			return;
		if(head.next==null){ //只有一个节点
			head=null;
			return;
		}
		if(node.next ==null){ //尾节点，只能遍历
			ListNode temp=head;
			while(temp.next!=node){
				temp=temp.next;
			}
			temp.next =null;
		}
		else //用复制下一个，删掉下一个的方法
		{   
			node.val=node.next.val;
			node.next=node.next.next;
//不能用node=node.next; 这只是引用，让node指向node.next,只是下一次调用node时，输出的是原来的node.next的值
			//理论上是完成了跳过node的过程，但是Java的函数调用传递进来的原指针的复制，即如果让复制的这个指针指向的内存改变，那么可以起到
			//调用函数改变的原来真实值的效果。但是，想下面这中，只是对复制的引用操作，而没有对其指向的内存改动，是没有用的。
//			System.out.println(node.val);
//			node=node.next;
//			System.out.println(node.val);
		}
	}
}
class ListNode {
 int val;
 ListNode next;
 ListNode(int x) {
     val = x;
     next = null;
 }
}
*/
//14 调整数组顺序，奇数位于偶数前面。（多一个要求，不能改变，奇数与奇数，偶数与偶数之间的相对顺序）
/*
public class Sword{
	public static void main(String[] args) {
		int[] A={2,3,4,7,8,6,5,32,234,5435,46,567,4,534,1534,6,657,7,687,5,4,4342,43,75,};
		//jiou(A);
		jiou2(A);
		for(int i:A)
		{
			System.out.print(i+" ");
		}
	}
	//原书中的不保证顺序
	static public void jiou(int[] a){
		if(a.length==0)
			return;
		int left=0;
		int right=a.length-1;
		while(left<right){
			while(((a[left]&1)==1) && left<right)
				left++;
			while(((a[right]&1)==0) && left<right)
			    right--;
			int temp= a[left];
			a[left]=a[right];
			a[right]=temp;
			left++;
			right--;
		}
	}
	//同时保证相对顺序,使用插入排序的思想
	static void jiou2(int[] array){
		int len=array.length;
		if(len==0)
			return;
		for(int i=1;i<len;i++)
		{
			if((array[i]&1)==1){
				for (int j = i - 1; j >= 0; j--) {
					if((array[j]&1)==1){
						break;
					}else{
						int temp=array[j+1];
						array[j+1]=array[j];
						array[j]=temp;
					}
				}
			}
		}
	}
	
}
*/
//15 链表中的倒数第K个节点
/*
public class Sword{
	public static void main(String[] args) {
		//这类题都是定义两个指针，通过走的速度不同，来达到目的，比如返回中间结点，就是一个走一步，一个走两步。
		//见56题，判断链表是否是环形结构，也是一个速度快，一个慢，如果快的那个追上慢的（套圈），那么有环形
	}
	static public ListNode kk(ListNode head,int k){
		if(head==null || k<=0)
			return null;
		ListNode left=head;
		ListNode right=head;
		for(int i=0;i<k-1;i++){
			right=right.next;
			if(right==null)
				return null;
		}
		while(right.next!=null){
			left=left.next;
			right=right.next;
		}
		return left;
	}
}
class ListNode {
 int val;
 ListNode next;
 ListNode(int x) {
     val = x;
     next = null;
 }
}
*/
//16 反转链表  单链表反转
/*   //  递归 
public Node inverseDG(Node head){
	if(head==null || head.next==null)
		return head;
	Node newHead=inverseDG(head.next);
	head.next.next=head;
	head.next=null;
	return newHead;
}
//3个指针
public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode pre=null;
        ListNode now=head;
        while(now!=null){
            ListNode after=now.next;
            now.next=pre;
            pre=now;
            now=after;
        }
        return pre;
    }
*/
/*
//合并两个排序的链表  递归和循环都可以
public class Sword{
	public static void main(String[] args) {
		
	}
	static public ListNode mergeDG(ListNode list1,ListNode list2){
		if(list1==null)
			return list2; //两个同时空也没事，返回的null作为最后一个的next即last.next
		if(list2==null)
			return  list1;
		ListNode temp=null;
		if(list1.val<=list2.val){
			temp=mergeDG(list1.next,list2);
			list1.next=temp;
			return list1;
		}else{
			temp=mergeDG(list1,list2.next);
			list2.next=temp;
			return list2;
		}
	}
	//循环迭代的方法
	static public ListNode mergeXH(ListNode l1,ListNode l2){
     if(l1==null || l2==null)
            return l1==null? l2:l1;
     ListNode rt = new ListNode(0);
     ListNode h = rt;
     while( l1 != null && l2 != null){
         if(l1.val < l2.val){
             rt.next = l1;
             l1 = l1.next;
         }else{ 
             rt.next = l2;
             l2 = l2.next;
         }
         rt = rt.next;
     }
     if(l1 != null) rt.next = l1;
     else rt.next = l2;     
     return h.next;
	}
}
class ListNode{
	int val;
	ListNode next;
	ListNode(int i){
		val=i;
		next=null;
	}
}
*/
//18 树的子结构 二叉树B是否是二叉树A的子结构  
/*  //这个是不需要完全拓补相同，只有有这个结构就行，需要要完全一样，那么在subtree函数中要严格只有连个同时为null，才返回true
public class Sword{
	public static void main(String[] args) {
		//两个递归，一个负责遍历节点找到值和B的根节点相同的节点
		//一个负责在找到相同值节点情况下去判断是不是子树。
		//调用aHasB主函数判断，该函数中又调用subtree函数判断是不是子树
	}
	static public boolean aHasB(Tree A,Tree B){
		if(B==null || A==null)   //题目定义空时返回false
			return false;
		//剩下的只能是A 和　B都不是null
		boolean have=false;
		if(A.val==B.val)
			have= subtree(A,B);  //这个不能return，因为第一个不是，还要比较下面分支
		if(!have)  //上面如果没有，那些试试下面分支，如果有了就不试了，直接返回true
			have= ( aHasB(A.left,B) || aHasB(A.right,B) );
		return have;
	}
	static public boolean subtree(Tree A, Tree B){
		if(B==null)  //注意A和B的顺序不能交换，要先判断B，这样两个同时为空时返回true
			return true;  //这里的两个同时为空，说明一起到了最后一个节点下一个，是正确的状态
		if(A==null)     //A=1,0  B=0  true   //A=0  B=1  false  //剩下的只能是A 和　B都不是null
			return false;
		if(A.val!=B.val)
			return false;
		return (subtree(A.left,B.left) && subtree(A.right,B.right));
	}
}
class Tree {
 int val;
 Tree left;
 Tree right;
 Tree(int v)
 {
 	val = v;
 	left = null;
 	right = null;
 }
}
*/
//19 树的镜像  对称一个二叉树  用递归 或者 堆栈
/*
public class Sword{
	public static void main(String[] args) {
		
	}
	static public void mirror(TreeNode root){
		if(root==null)
			return;
		if(root.left==null && root.right==null)
			return;
		TreeNode temp=null;
		temp=root.left;
		root.left=root.right;
		root.right=temp;
		mirror(root.left);
		mirror(root.right);
		
	}
}
class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int v)
 {
 	val = v;
 	left = null;
 	right = null;
 }
}
*/
//reverse digits of an integer 反转整数
//这题的难点在于int类型是-2147483648范围的，所以如果输入x是这个就越界了，导致0-x还是x没有去掉负号
//所以还要判断一次是否<0 这样复制字符时，去掉第一个负号。还有就是用double保持转后的数字，然后判断，如果超过MAX或者MIN，就直接异常返回0；
/*
public class Sword{
	public static void main(String[] args) {
		int a=-21474848;
		int b=reverse(a);
		System.out.println(b);
	}
	static public int reverse(int x){
		boolean fu=false;
		if(x==0)
			return 0;
		if(x<0){
			fu=true;
			x=-x;
		}
		char[] s;
		String s0=Integer.toString(x);
		if(x>0){
			s=s0.toCharArray();
		}else{
			s=s0.substring(1,s0.length()).toCharArray();
		}
		int length=s.length;
		char[] s2=new char[length];
		for(int i=0;i<length;i++){
			s2[i]=s[length-1-i];
		}
		String s3=new String(s2);
		double r= Double.parseDouble(s3);
		if(r>Integer.MAX_VALUE || r<Integer.MIN_VALUE)
			return 0;
		if(fu)
			return -Integer.parseInt(s3);
		return Integer.parseInt(s3);
	}
}
*/
//20 顺时针打印矩阵 分圈从外向内一圈一圈打印
//20 旋转矩阵打印  //注意这题，如果用static的List方式，在OJ上可能通不过，因为他上一次测试的答案保存在了List中。。。，所以可以在
//在函数中定义一个List，然后传入传出就行
/*
public class Sword{
	static ArrayList<Integer> list=new ArrayList<Integer>();//将结果保存在list中，可以不用，直接打印就行。
	public static void main(String[] args) {
		int[][] s=new int[2][2];
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				//s[i][j]=(int)(Math.random()*20);
				s[i][j]=i;
			}
		}
		spiral(s);
		System.out.println("----保存数组的方式----");
		for(int i:list){
			System.out.print(i+" ");
		}
	}
	static void spiral(int[][]s){
		int length=s.length;
		if(length==0)
			return;
		int tr=0;
		int tc=0; //左上起始点坐标
		int dr=length-1;
		int dc=s[0].length-1;//右下角截至点坐标
		while(tr<=dr && tc<=dc){
			printEdge(s,tr++,tc++,dr--,dc--);
		}
	}
	static void printEdge(int[][] s,int tr,int tc,int dr,int dc){
		if(tr==dr){//矩阵只有一行   包含只有一个元素的情况
			for(int i=tc;i<=dc;i++){
				System.out.print(s[tr][i]+" ");
				list.add(s[tr][i]);  //每个加入list的过程都可以不要
			}
		}else if(tc==dc){//只有一列  这个else一定要有，不然只有一个元素时会打印两遍
			for(int i=tr;i<=dr;i++){
				System.out.print(s[i][tc]+" ");
				list.add(s[i][tc]);
			}
		}else{//一般情况
			int tempr=tr; //打印时指针，要多次使用矩阵大小横纵坐标，所以不能再原来上面变化
			int tempc=tc;
			while(tempc<dc){//不用=，把最右上角当作下面列的时候打印，不再这里当作行打印
				System.out.print(s[tempr][tempc]+" ");
				list.add(s[tempr][tempc]);
				tempc++;
			}
			while(tempr<dr){
				System.out.print(s[tempr][dc]+" ");
				list.add(s[tempr][dc]);
				tempr++;
			}
			while(tempc>tc){
				System.out.print(s[dr][tempc]+" ");
				list.add(s[dr][tempc]);
				tempc--;
			}
			while(tempr>tr){
				System.out.print(s[tempr][tc]+" ");
				list.add(s[tempr][tc]);
				tempr--;
			}
		}
		
	}
}
*/
//21 包含min函数的栈  两种方式，一个是费空间维护一个一样大小的栈存每次最小值。 
//一种是一个栈只存不重复的最小值    见左程云P3。更独特的方法是只用一个Stack，存自定义的数据结构，一个
//数值，一个是min，然后存这个结构体。或者每次存时判断是否需要改min
/*
public class Sword{//一个stack
	Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    public void pop() {
        int peek = stack.pop();
        if (peek == min){
            min = stack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }
}
class MyStack{//两个stack
	private Stack<Integer> data= new Stack<Integer>();
	private Stack<Integer> min= new Stack<Integer>();
	public void push(int node){
		data.push(node);
		if(min.isEmpty()){
			min.push(node);
		}else if(node<=min.peek()){
			min.push(node);
		}else{
			int temp=min.peek();
			min.push(temp);
		}
	}
	public int pop(){
		if(data.isEmpty()){//或者直接return -1；
			throw new RuntimeException("堆为空，不能弹出"); 
		}
		min.pop();
		return data.pop();
	}
	public int getmin(){
		if(min.isEmpty()){
			throw new RuntimeException("没有值，堆为空");
		}
		return min.peek();
	}
}
*/
//22 栈的压入 弹出序列
/*
public class Sword{
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		int[] B = {1,2,3,4,5};
		System.out.println(IsPopOrder(A,B));
//		int i=0;
//		while(i<5){ //if(i<5) 和while一样
//			while(i<10){ //注意while嵌套，先做里面的，不管是否满足外面循环
//				System.out.println(i++); //会打印到9
//			}
//			System.out.println("zhixing");//只打印一次
//		}
	}
	public static boolean IsPopOrder(int[] pushA,int[] popA){
		int lengthA=pushA.length;
		int lengthB=popA.length;
		if(lengthA!=lengthB || lengthA==0 ||lengthB==0)
			return false;
		Stack<Integer> s=new Stack<Integer>();
		int j=0;
		for(int i=0;i<lengthA;i++){
			s.push(pushA[i]);
			while(!s.isEmpty() && j<lengthB && s.peek()==popA[j]){
				s.pop();
				j++;
			}
		}
		return s.isEmpty(); //上面整个过程就是出栈过程，如果不是对应序列，那么一定没出完，所以不是空。
	}
}
*/
//23 从上往下 从左往右打印二叉树 顺序打印二叉树 宽度/广度优先搜索二叉树/图，思想用队列。
//按层打印二叉树  ZigZag按层打印  见左程云P131  Breadth First Search  BFS
/*
public class Sword{
	public static void main(String[] args) {
		
	}
	static public void print(Node root){
		if(root==null)
			return;
		Queue<Node> que= new LinkedList<Node>();
		que.offer(root);
		while(!que.isEmpty()){
			Node head= que.poll();
			System.out.println(head.val);
			if(head.left!=null){
				que.offer(head.left);
			}
			if(head.right!=null){
				que.offer(head.right);
			}
		}
	}
}
class Node {
 int val;
 Node left;
 Node right;
 Node(int v)
 {
 	val = v;
 	left = null;
 	right = null;
 }
}
*/
//24 二叉搜索树的后序遍历序列
/*
public class Sword{
	public static void main(String[] args) {
		int[] a={5,7,6,9,11,10,8};
		int[] b=new int[]{};
		System.out.println(order(a));
	}
	static public boolean order(int[] s){
		int length=s.length;
		if(length==0) //不需要用s==null判断，这样不对
			return false;
		int root=s[length-1];
		int i=0;
		for(;i<length-1;i++){
			if(s[i]>root)
				break; //扫描到右子树
		}
		int j=i;
		for(;j<length-1;j++){
			if(s[j]<root) //如果右子树中有小于节点的肯定错误
				return false;
		}
		boolean left=true;;
		if(i>0){//有左子树，判断左边  //也可以设计成传入数组下标范围，这样不用复制
			left=order(Arrays.copyOfRange(s, 0, i));
		}
		boolean right=true;
		if(i<length-2){
			right=order(Arrays.copyOfRange(s, i, length-1));
		}
		return (left && right);
	}
}
*/
//25 二叉树中和为某一值的路径  回溯法
/*
public class Sword{  //使用stack 递归思路，为了打印各个节点，需要遍历，所以用list代替
	ArrayList<ArrayList<Integer>> listlist=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list=new ArrayList<Integer>();
public ArrayList<ArrayList<Integer>> path(Node root,int sum){
	if(root==null)
			return listlist;
	list.add(root.val);
	sum=sum-root.val; //listlist不能直接add(list),这样存的是引用，左右引用变了，前面所有的都是指向最后一个引用
	if(sum==0 && root.left==null && root.right==null ){
		listlist.add(new ArrayList<Integer>(list));//只要打印的话，就在这里循环打印就行
	}//上面到叶子正好等于sum则记录。否则继续下面左右节点，当现在的root遍历过后，就得回到上一个节点
	if(root.left!=null){
			path(root.left,sum);
		}
		if(root.right!=null){
			path(root.right,sum);
		}//上面表示输入的root已经遍历过了，下面则返回父节点。
		list.remove(list.size()-1);
		return listlist;
	}
}
class Node{
	Node left;
	Node right;
	int val;
	Node(int i){
		val=i;
		left=null;right=null;
	}
}
*/
/*
//26 复杂链表的复制  1:复制每个节点插入到原来的当前节点后面 2.复制的节点随机指针就是前一个原节点的随机指针的下一个。  3：奇偶分开两链表
public class Sword{
	public RandomListNode fuzhi(RandomListNode pHead){
		if(pHead==null)
			return null;
		RandomListNode index= pHead;
		while(index!=null){
			RandomListNode fz=new RandomListNode(index.val);//复制N原节点N'
			fz.next=index.next; //N'指向N.next
			index.next=fz; //N指向N'
			index=fz.next;//index跳到下一个原节点，继续循环复制
		}
		index=pHead;//index回到开头，开始复制随机节点
		while(index!=null){
			if(index.random!=null){//随机指针可能是指向空
				index.next.random=index.random.next;}
			else
				index.next.random=null;
			index=index.next.next;
		}
		index=pHead; //开始拆分
		RandomListNode indexfz=pHead.next;
		RandomListNode headfz=pHead.next; //保存头结点位置
		while(indexfz.next!=null){//留着最后一个没处理，因为不太好判断，所以直接在循环外面各自指向null就行
			index.next=index.next.next;
			indexfz.next=indexfz.next.next;
			index=index.next;
			indexfz=indexfz.next;
		}
		index.next=null; //处理最后一个
		indexfz.next=null;
		return headfz;
	}
}
class RandomListNode{
	RandomListNode next;
	RandomListNode random;
	int val;
	RandomListNode(int i){
		val=i;
		next=null;random=null;
	}
}
*/
/*
//27 二叉搜索树和双向链表  左程云P74  每次递归单元，让最后一个last的right指向第一个head，这样方便取出头尾节点
public class Sword{
	public Node link(Node root){
		if(root==null || (root.left==null && root.right==null)){
			return root;
		}
		Node last=linkdg(root);
		Node head=last.right;// 最后一次不用递归的时候，让最后的right指向null,不好再递归中用，所以单独拿出，
		last.right=null;     //出最后一次外，中间的部分用递归
		return head;
	}
	public Node linkdg(Node head){
		if(head==null)
			return head;
//		if(head.left==null && head.right==null){//只有一个Node
//			head.right=head;      //这种情况包含在下面了，所以不用单独写。
//			return head;
//		}
		Node lastL=null;
		Node headL=head;//如果左边为空，那么左边的头就应该是目前的节点head
		if(head.left!=null){
			lastL=linkdg(head.left);
			headL=lastL.right;//有左边，就更新，没有就是上面初始化时的head
			lastL.right=head;
			head.left=lastL;
		}
		Node lastR=head;//如果右边为空，右边的最后一个就是当前节点head
		Node headR=null;
		if(head.right!=null){
			lastR=linkdg(head.right);//有右边，则更新，没有就是上面初始化的head
			headR=lastR.right;
			head.right=headR;
			headR.left=head;
		}                //不管前面是左没有还是右没有，都要让现有的尾节点的right指向头结点
		lastR.right=headL;  //有左右，就是右边last指向左边head，没有就是初始值head指向head
		return lastR;
	}
}
class Node{
	Node left;
	Node right;
	int val;
	Node(int i){
		val=i;
		left=null;
		right=null;
	}
}
*/
/*
//28 字符串的全排列   固定第一个（每个字符都可以当第一个，所以交换后面，和N皇后一样的思路，第一排每个位置都可以，
//然后分别看对应的下面有多少可能），后面的全排列，然后递归后面的字符
public class Sword{
	ArrayList<String> list=new ArrayList<String>();   //或者用List后用其Collections.sort也行
	TreeSet<String> ts=new TreeSet<String>();//网站要求按排序结果输出，所以用treeSet存，然后在传给List
	public ArrayList<String> pailie(String s){
		int len=s.length();
		if(s==null || len==0)
			return null;                                              
		char[] c=s.toCharArray();
		permutation(c,0);
		list.addAll(ts);
		return list;
	}
	public void permutation(char[] c,int begin){
		int len=c.length;
		if(begin==len-1){
			ts.add(String.valueOf(c));//不能存字符数组，引用会变，类似二叉树路径要new一样
		}else{
			for(int i=begin;i<len;i++){//第一个字符本身就是作为第一个的一个可能，所以要从begin开始
				if(i!=begin && c[i]==c[begin])
					continue;//和第一个相同的字符，就不用交换了
				swap(c,begin,i);
				permutation(c,begin+1);
				swap(c,begin,i);
			}
		}
	}
	public void swap(char[] c,int i,int j){
		if(i!=j){//这样可以省了将第一个字符和第一个字符本身交换
			char temp=c[i];
			c[i]=c[j];
			c[j]=temp;
		}
	}
}
*/
/*
//29 数组中出现次数超过一半的数字   超过N/K次数的数字 左程云P345
//两种方法都是时间O(n)的，一种是类似于快速排序的，找到中间下标肯定是那个数，如果大于一半，就在左边递归，反之右边
//第二种方法用遍历，每次有相同就次数+1，不同就-1，最终>1的那个可能是，然后再遍历确认一边。思路就是一次删除K个数，共K-1个候选数
import java.util.Map.Entry;//要用Entry<key,value> : hashmap.entrySet();这用方法就要引这个包
public class Sword{ //第二种好一点，所以记第二种
	public int half(int[] s){
		int len=s.length;
		if(s==null || len==0){
			return 0;  //没有就返回0
		}
		int num=0;
		int now=0;
		for(int i=0;i<len;i++){
			if(num==0){//重新确立候选数字
				now=s[i];
				num=1;
			}else{
				if(s[i]==now){
					num++;//相同就+1
				}else{
					num--;//不同-1
				}
			}
		}
		if(num<1){//说明肯定没有超过一半的
			return 0;
		}else{//当数组是奇数时，没有超过一半的也可能是1，所以再遍历数组确认，注意O(2N)=O(N)
			num=0;
			for(int i=0;i<len;i++){
				if(s[i]==now)
					num++;
			}
			if(num>(len>>2)){
				return now;
			}else{
				return 0;
			}
		}
	}                                       //要求K至少是2,但要小于N
	public void khalf(int[] s,int k){//超过N/K次数的数字，可能不止一个.打印就行，不存在list中了
		int len=s.length;
		if(s==null || len==0 || k<2){
			return;
		}
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(int i=0;i<len;i++){
			if(!hm.containsKey(s[i])){//不足K-1个候选，则列为候选
				if(hm.size()<k-1){
					hm.put(s[i], 1);
				}else{  //否则每个候选-1次，注意只有1次的候选就要被剔除
					Iterator<Integer> it=hm.keySet().iterator();
					for(;it.hasNext();){
						int key=it.next();
						if(hm.get(key)==1){
							it.remove();
						}else{
							hm.put(key, hm.get(key)-1);
						}
					}
				}
			}else{//有相同的则对应+1
				hm.put(s[i], hm.get(s[i])+1);
			}
		}
		if(hm.isEmpty()){
			return;//没有可能的书
		}else{//再判断是否这些书真的超过了N/K
			HashMap<Integer,Integer> hmC=tongji(hm,s);//统计真实出现次数
			for(Entry<Integer, Integer> et : hmC.entrySet()){//感觉不如用iterator方便
				int key=et.getKey();
				if(hmC.get(key)> len/k ){//没有就不打印，如果要返回一个标志，可以在打印前设一个flag，看是否打印过
					System.out.print(key+" ");
				}
			}
		}
	}
	public HashMap<Integer,Integer> tongji(HashMap<Integer,Integer> ori,int[] s){
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(int i=0;i<s.length;i++){
			if(ori.containsKey(s[i])){
				if(hm.containsKey(s[i])){//有相同的+1
					hm.put(s[i], hm.get(s[i])+1);
				}else{//第一次统计，则设为1
					hm.put(s[i], 1);
				}
			}
		}
		return hm;
	}
}
*/
/*
//30  数组中最小的K个数  左程云P337
//一种方法基于快速排序O(n)，一种基于最大堆O(nlogK)，可以用TreeSet或者TreeMap实现，红黑树就有这个性质
public class Sword{  //不过TreeSet/Map不能有重复数据，所以有重复的时候还是自己实现最大堆和调整吧
	public static void main(String[] args) {
		int[] a=new int[]{1,9,3,4,5,6,7,8};
		System.out.println(kmin(a,3));
	}
	static public ArrayList<Integer> kmin(int[] s,int k){//TreeSet实现，不改变数组，适合大数据，不能有重复
		TreeSet<Integer> ts=new TreeSet<Integer>();               //O(NlogK)
		ArrayList<Integer> list=new ArrayList<Integer>();
		int len=s.length;
		if(s==null || len==0 || k<1 || k>len){
			return list;
		}
		for(int i=0;i<len;i++){
			if(ts.size()<k){
				ts.add(s[i]);
			}else{
				int biggest=ts.last();//pollLast()会同时删除最大
				if(s[i]<biggest){
					ts.pollLast(); //或者remove(ts.last())
					ts.add(s[i]);
				}
			}
		}
		list.addAll(ts);
		return list;
	}
	//基于快速排序实现   会改变数组，O（N）
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
	//基于自己写的最大堆实现   可以有重复 O(NlogK)
}
*/
//31 连续子数组的最大和左程云 P368  动态规划思想，或者左以及offer中另一种思想，二者其实类似
//设f(j)是以j结尾的连续数组最大和，状态方程为f(j) = max(s[j], f[j-1]+s[j])
/*
public class Sword{
	public int maxSum(int[] s){
		int len=s.length;
		if(s==null || len==0){
			return 0;
		}
		int sum=0;
		int max=s[0];//初始化为Integer.MIN_VALUE更好
		for(int i=0;i<len;i++){
			sum+=s[i];//就是f(j-1)+s[i]
			max=Math.max(max, sum);//要先更新max,否则全是负数的时候，光顾着检测下一个sum,max还停在第一个值
			sum=sum<0? 0:sum;//就是状态方程
		}
		return max;
	}
}
*/
/*
//32 从1到n整数中1出现的次数   K出现的次数见http://www.cnblogs.com/nailperry/p/4752987.html
//方法有多种，简直offer和左程云的都比较复杂，leetcode有简单的，上面链接也不错，下面写leetcode方法
//主要思路：设定整数点（如1、10、100等等）作为位置点i（对应n的各位、十位、百位等等），分别对每个数位上有多少包含1的点进行分析
//根据设定的整数位置，对n进行分割，分为两部分，高位n/i，低位n%i
//当i表示百位，且百位对应的数>=2,如n=31456,i=100，则a=314,b=56，此时百位为1的次数有a/10+1=32（最高两位0~31）
//每一次都包含100个连续的点，即共有(a/10+1)*100个点的百位为1
//当i表示百位，且百位对应的数为1，如n=31156,i=100，则a=311,b=56，此时百位对应的就是1，
//则共有a/10(最高两位0-30)次是包含100个连续点，当最高两位为31（即a=311），本次只对应局部点00~56，共b+1次，
//所有点加起来共有（a/10*100）+(b+1)，这些点百位对应为1
//当i表示百位，且百位对应的数为0,如n=31056,i=100，则a=310,b=56，此时百位为1的次数有a/10=31（最高两位0~30）
//综合以上三种情况，当百位对应0或>=2时，有(a+8)/10次包含所有100个点，还有当百位为1(a%10==1)，需要增加局部点b+1
//之所以补8，是因为当百位为0，则a/10==(a+8)/10，当百位>=2，补8会产生进位位，效果等同于(a/10+1)
public class Sword{
	public int num1(int n){
		int num=0;
		for(int i=1;i<=n;i*=10){
			int gao=n/i;
			int di=n%i;
			if(gao%10==1){
				num+=(gao+8)/10*i + di+1;//这里不加8也行
			}else{
				num+=(gao+8)/10*i;//或者拆成0和>=2两种，分别计算也行，没必要这样太精妙
			}
		}
		return num;
	}
	public int mynum1(int n){//分开来3种情况，容易记也显得真实
		int num=0;
		for(int i=1;i<=n;i*=10){
			int gao=n/i;
			int di=n%i;
			if(gao%10==1){
				num+=gao/10*i + di+1;//这里不加8也行
			}else if(gao%10==0){
				num+=gao/10*i;
			}else{//>=2的情况
				num+=((gao/10)+1)*i;
			}
		}
		return num;
	}
}
*/
/*
//33 正数数组排成最小的数   思路重写一种比较方法，使得数字按此顺序排序，即可得到最小的数
public class Sword{
	public static void main(String[] args) {
		int[] a={3,5,1,4,2};
		System.out.println(pailie(a));
	}
static	public String pailie(int[] s){
		int len=s.length;
		if(s==null || len==0){
			return "";
		}
		ArrayList<Myint> list=new ArrayList<Myint>();
		for(int i=0;i<len;i++){
			String temp=String.valueOf(s[i]);
			Myint mi=new Myint(temp);
			list.add(mi);
		}
		Collections.sort(list);
		StringBuilder sb=new StringBuilder();
		for(Myint i:list){
			sb.append(i.val);
		}
		return sb.toString();
	}
}
class Myint implements Comparable<Myint>{
	String val;
	Myint(String i){
		val=i;
	}
	@Override
	public int compareTo(Myint a){
		String va=val+a.val;
		String av=a.val+val;
		if(va.compareTo(av)>0){
			return 1;
		}else if(va.equals(av)){
			return 0;
		}else{
			return -1;
		}
	}
}
*/
/*
//34 丑数   //剑指offer或者面试宝典的队列方式http://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b
public class Sword{
	public int ugly(int k){//这个思路和offer差不多，只是跟新abc时方法不一样，类似于队列的思想
		if(k<=0)
			return 0;
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		int a=0;
		int b=0;
		int c=0;
		while(list.size()<k){
			int t2=list.get(a)*2;
			int t3=list.get(b)*3;
			int t5=list.get(c)*5;
			int tmin=Math.min(t2, Math.min(t3, t5));
			list.add(tmin);
			if(tmin==t2)//这个数这一次×2后等于目前加入list的数，那么下一次肯定是这个数后面的数×2 才可能加入
				a++;
			if(tmin==t3)
				b++;
			if(tmin==t5)
				c++;
		}
		return list.get(k-1);
	}
}
*/
/*
//35 第一个之出现一次的字符  //1.用HashMap统计次数  2.用一个大小26数组，存放每个对应几次   其实就是实现简单的HashMap，效率高一点
public class Sword{
	public int single(String s){//返回下标
		int len=s.length();
		if(s==null || len==0){
			return -1;
		}
		HashMap<Character,Integer> hm=new HashMap<>();
		char[] c=s.toCharArray();
		for(int i=0;i<len;i++){
			if(hm.containsKey(c[i])){
				hm.put(c[i], hm.get(c[i])+1);
			}else{
				hm.put(c[i], 1);
			}
		}
		for(int i=0;i<len;i++){
			if(hm.get(c[i])==1)
				return i;
		}
		return -1;
	}
	public int single2(String str){//用一个数组存放次数,模拟hashmap
		char[] c = str.toCharArray();
 int[] a = new int['z'];
 for (char d : c)
     a[(int) d]++;
 for (int i = 0; i < c.length; i++)
     if (a[(int) c[i]] == 1)
         return i;
 return -1;
	}
}
*/
/*
//36 数组中的逆序对  //类似归并排序的思路  分治法  先统计小组内有多少个，再将组内排序，然后统计两个组相互之间有多少个
public class Sword{
	int result=0;
	public int getInv(int[] s){
		int len=s.length;
		if(s==null || len<2){
			return 0;
		}
		msort(s,0,len-1);
		return result;
	}
	public void msort(int[] s,int begin,int end){
		if(begin<end){
			int mid=(begin+end)>>1;
		    msort(s,begin,mid);
		    msort(s,mid+1,end);
		    merge(s,begin,mid,end);
		}
	}
	public void merge(int[] s,int begin,int mid,int end){
		int[] temp=new int[s.length];
		int tmp3=begin;
		int right=mid+1;
		int index=begin;
		while(begin<=mid && right<=end){
			if(s[begin]<=s[right]){
				temp[tmp3++]=s[begin++];
			}else{//如果左边a[begin]比右数组的当前元素a[right]大，那左边数组begin后面的每个数都比右边s[right]大
				temp[tmp3++]=s[right++];
				result+=mid-begin+1;
			}
		}
		while(begin<=mid){
			temp[tmp3++]=s[begin++];
		}
		while(right<=end){
			temp[tmp3++]=s[right++];
		}
		for(int i=index;i<=end;i++){
			s[i]=temp[i];
		}
	}
}
*/
/*
//37 两个链表的第一个公共节点    //先遍历分别得到两个长度，然后再长的那个上面先走多出的长度，然后两个一起遍历，直到二者相等返回此刻值
public class Sword{     //有公共节点，一定最后的都是，所以最后一个肯定是相同的
	public ListNode first(ListNode root1,ListNode root2){
		if(root1==null || root2==null)
			return null;
		int len1=1;//初值无所谓，只要比较二者差就行
		int len2=1;
		ListNode n1=root1;
		ListNode n2=root2;
		while(n1.next!=null){
			len1++;
			n1=n1.next;
		}
		while(n2.next!=null){
			len2++;
			n2=n2.next;
		}
		if(n1!=n2){//最后一个节点不一样的话，肯定没有公共节点
			return null;
		}
		n1=root1;
		n2=root2;
		if(len1>len2){
			for(int i=0;i<(len1-len2);i++){
				n1=n1.next;
			}
		}else{
			for(int i=0;i<len2-len1;i++){
				n2=n2.next;
			}
		}
		while(n1!=n2){
			n1=n1.next;
			n2=n2.next;
		}
		return n1;
	}
}
class ListNode{
	int val;
	ListNode next=null;
	ListNode(int i){
		val=i;
	}
}
*/
/*
//38 数字在排序数组中出现的次数   思路，二分查找，分别找到第一个K和最后一个K的位置O(logN)  如果二分找到一个，然后两边遍历是O(N)
public class Sword{   //如果用C++的STL里有low bound 和 upper bound 直接找到第一个最后一个位置
	public int getnum(int[] s,int k){
		int len=s.length;
		if(s==null || len==0){
			return 0;
		}
		int begin=bsbegin(s,k,0,len-1);
		int end=bsend(s,k,0,len-1);
		if(begin!=-1 && end!=-1)//要么同时找到，要么都没找到
			return end-begin+1;
		else
			return 0;
	}
	public int bsbegin(int[] s,int k,int left,int right){
		if(left>right)
			return -1;//没找到
		int m=(left+right)>>1;
		int mid=s[m];
		if(mid==k){
			if(m==0|| (m>0 && s[m-1]!=k))
				return m;
			else
				return bsbegin(s,k,left,m-1);
		}else if(mid<k){
			return bsbegin(s,k,m+1,right);
		}else{
			return bsbegin(s,k,left,m-1);
		}
	}
	public int bsend(int[] s,int k,int left,int right){
		if(left>right)
			return -1;//没找到
		int m=(left+right)>>1;
		int mid=s[m];
		if(mid==k){
			if(m==right || (m<right && s[m+1]!=k))
				return m;
			else
				return bsend(s,k,m+1,right);
		}else if(mid<k){
			return bsend(s,k,m+1,right);
		}else{
			return bsend(s,k,left,m-1);
		}
	}
}
*/
/*
//39-1 二叉树的深度  思路：递归或者动态规划，root点深度，等于左节点深度+1，和右节点深度+1 二者的Max
public class Sword{
	public int depth(Node root){
		if(root==null)
			return 0;
		int left=depth(root.left);
		int right=depth(root.right);
		return Math.max(left+1, right+1);
	}
}
class Node{
	int val;
	Node left=null;
	Node right=null;
	Node(int i){
		this.val=i;
	}
}
//39-2 判断是否是平衡二叉树   左程云P144  后序遍历的方式 先返回左子树是否为AVL以及其深度，再返回右子树，然后比较深度判断当前
class Avl{  //每个节点最多遍历一次，时间O(N)  
	public boolean isAvl(Node root){
		if(root==null)
			return true;
		if(height(root)==-1)   //这里将不是AVL的子树深度都当作-1，那么检测到-1就return
			return false;
		return true;
	}
	public int height(Node root){
		if(root==null)
			return 0;
		int lefth=height(root.left);
		if(lefth==-1)//左子树不是Avl，那么直接返回当前root也不是Avl
			return -1;
		int righth=height(root.right);
		if(righth==-1)
			return -1;
		if(Math.abs(lefth-righth)<=1){
			return Math.max(lefth, righth)+1;
		}else{
			return -1;
		}
	}
}
*/
/*
//40 数组中只出现一次的数字   一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
//两个相同的数异或结果为0，1：使用异或运算，得到了两个只出现一次的数相异或的结果。2.根据结果第一个1位，将整个数组重新划分成两部分
//那么不同的两个数，肯定在不同的组中，然后分别每个组异或得到那个数
public class Sword{ //要求时间O(N)，空间O(1)
	public void find(int[] s,int[] num1,int[] num2){
		int len=s.length;
		if(s==null || len<2){
			return;
		}
		int all=s[0];
		for(int i=1;i<len;i++){
			all=all^s[i];
		}
		String sall=Integer.toBinaryString(all); //从后往前数的index
		int index=sall.length();//因为返回的String不是32位的，只从第一个1位开始，所有长度可以当作index
		num1[0]=0;
		num2[0]=0;
		for(int i=0;i<len;i++){
			if(isone(s[i],index)){
				num1[0]=num1[0]^s[i];
			}else{
				num2[0]=num2[0]^s[i];
			}
		}
	}
	public boolean isone(int a,int index){//a>>index;return(a&1);这样更简单
		String s=Integer.toBinaryString(a);
		int len=s.length();
		if(len<index){
			return false;
		}else{
			if(s.charAt(len-index)=='1')
				return true;
			else
				return false;
		}
	}
}
*/
/*
//41-1 和为S的两个数字 ,递增数组中。有多个组合时，输出乘积最小的。（乘积最小就是差值最大的，因为和相等时ab相同a*b最大）
public class Sword{         //或者说从两边向中间逼近找到的第一组就是差值最大的
	public static void main(String[] args) {
		int s=9;
		ArrayList<ArrayList<Integer>> ll=new ArrayList<>();
		ll=S.find2(s);
		for(int i=0;i<ll.size();i++){
			for(int j=0;j<ll.get(i).size();j++){
				System.out.print(ll.get(i).get(j));
			}
			System.out.println();
		}
	}
	public ArrayList<Integer> find(int[] s,int sum){
		int len=s.length;
		ArrayList<Integer> list =new ArrayList<>();
		if(s==null || len<2)
			return list;
		int left=0;
		int right=len-1;//可以在循环前加一个判断sum是否比前两个数和小或者比最后两个数和大，是则直接返回空。
		while(left<right){
			if(s[left]+s[right]==sum){
				list.add(s[left]);
				list.add(s[right]);
				return list;
			}else if(s[left]+s[right]<sum){
				left++;
			}else{
				right--;
			}
		}
		return list;
	}
}
//41-2 和为S的连续正数序列  两种思路，1：offer上的，和上面类似，begin初始化为1，end初始化为2
//如果从begin到end的和大于s，我们就从序列中去掉较小的值(即增大begin)，反之增加end,一直到begin到(1+s)/2.
//第二种2：(a1+an)*n/2=s  n=an-a1+1  所以(an+a1)*(an-a1+1)=2*s=k*L(k>L) 可以算出an=(k+L-1)/2  a1=(k-L+1)/2
class S{
static	public ArrayList<ArrayList<Integer>> find2(int sum){
		ArrayList<ArrayList<Integer>> listlist=new ArrayList<>();
		if(sum<3)
			return listlist;
		int slast=(int)Math.sqrt(sum<<1);
		for(int small=slast;small>=2;small--){//小的因子逐渐变小到2，small代表项数
			int yes=(sum<<1)%small;
			if( yes==0){//能分解时才进一步验证                                                                                                 //偶数可以用&1==0判断
				int big=(sum<<1)/small;//下面用位运算加速，意思就是求得的an 和 a1都是整数，如an是(k+L-1)整除2得到，那么括号中就的是偶数
				if( ( (big+small-1) &1)==0 && ( (big-small+1)&1)==0 ){
					int an=(big+small-1)>>1;				
					int a1=(big-small+1)>>1;
		        	ArrayList<Integer> list=new ArrayList<>();
					for(int j=a1;j<=an;j++){
						list.add(j);
					} 
					listlist.add(list);
				}
			}
		}
		return listlist;
	}
}
*/
/*
//42 左旋转字符串&翻转单词顺序  两道题类似，都可以使用多次反转一个字符串函数来实现。当然也可以用Stack存储倒着输出也行。如果空间要求O(1)只能前者
public class Sword{//Java中String做没有意义，所以改成char[]做，明白思想就行.即使C++也是用char[]比较方便
	public String word(String s,int k){//StringBuffer 有reverse()函数，这里还是自己实现
		int len=s.length();
		if(s==null || len==0 || k<0 || k>len){
			return "";
		}
		char[] c=s.toCharArray();
		reverse(c,0,k);
		reverse(c,k,len);
		reverse(c,0,len);
		return String.valueOf(c);
	}
	public void reverse(char[] c,int begin,int end){
		if(begin>=end)
			return;
		char temp;//基本类型，可以放在外面用一个，引用类型，最好还是放在里面每次new比较安全，防止引用最后都一样
		while(begin<end){
			temp=c[begin];
			c[begin]=c[end-1];
			c[end-1]=temp;
			begin++;
			end--;
		}
	}  
//翻转整个句子的3种方法                 	//要求O(1)空间，所以不能这些现成的函数，只能用法1，无要求法3递归比较好，法2比较好想常规
	public String sentence1(String s){//String有split函数，即按指定字符分割成字符串数组，String[] a = str.split(" ");
		int len=s.length();
		if(s==null || len==0)
			return "";
		char[] c=s.toCharArray();
		reverse(c,0,len);//先整体翻转
		int begin,end=0;
		int i=0;
		while(i<len){
			while(i<len && c[i]==' '){
				i++;//找到不为“ ”的单词开头
			}
			begin=i;
			end=i;
			while(i<len && c[i]!=' '){
				end++;
				i++;
			}
			reverse(c,begin,end);//局部单词翻转
		}
		return String.valueOf(c);
	}
	public String sentence2(String str){//O(N)空间时，可以方便的
		 StringBuffer sb = new StringBuffer("");
	        if(str.length() <= 0 || str.trim().equals("")){
	            return str;//要trim()，可能输入多个空格组成的字符串
	        }
	        String[] strSet = str.split(" ");
	        int length = strSet.length;
	        for(int i = length-1; i > 0 ;i--){
	            sb.append(strSet[i]+" ");
	        }
	        sb.append(strSet[0]);
	        return sb.toString();
	}
	public String sentence3(String str) {//递归方式
		int index=str.lastIndexOf(" ");
		if(index==-1){//没有空格，只有一个单词，直接返回
			return str;
		}else{ //有空格，返回最后一个单词+前面递归的结果。
			return str.substring(index+1)+" "+sentence3(str.substring(0,index));
		}
}
}
*/
/*
//43 n个骰子的点数和   思路：递归或者循环，和斐波那契思路类似，用循环减少计算量。那其实就是DP了
//F(n,s) = F(n-1,s-6)*1+F(n-1,s-5)*1+F(n-1,s-4)*1+F(n-1,s-3)*1+F(n-1,s-2)*1+F(n-1,s-1)*1;
//有1个骰子，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1。所有的和出现次数总和为6^n。
//对于一个骰子，每个点数出现是等概率的，所以上面每种情况都是×1                  //当然可以优化为5n但是没必要，那样代码复杂
//本来这是一个2维DP，但是第n个骰子只和n-1个有关，即DP矩阵中每一行只和上一行有关，(并且求的是最后一行而已)所以只要一个长度6n的一维数组就行
//http://blog.csdn.net/tbwood/article/details/22747215  何时可以用一维数组，以及如何用2个一维数组解决一维不行的情况。
public class Sword{
	public static void main(String[] args) {
		int n=5;//骰子个数
		int k=6;//骰子有多少点数，方便改动遇到新情况
		probability(n,k);
		solve(n);
	}
	static public void probability(int n,int k){//自己的方法，只要一个数组，不用额外一个数组
		if(n<=0 || k<=0)
			return;
		int[] num=new int[k*n+1];//+1是为了能直接让下标表示和S，数组从0开始的
		for(int i=1;i<=k;i++){
			num[i]=1;
		}
		for(int i=2;i<=n;i++){//一级循环是行，共几个骰子
			for(int j=i*k;j>=i;j--){//二级循环，从后往前，因为更新当前位置和前面有关，如果从前往后，会改变前面的值
				//num[j]=num[j-1]+num[j-2]+num[j-3]+num[j-4]+num[j-5]+num[j-6];
				int temp=0;
				for(int m=1;m<=k;m++){//用一个循环表示上面求和过程，不是DP的通法
					if(j-m>=i-1){//处理一下左边小于K个数字情况，注意比如第6个骰子，那么前一次最多加到5,所以这里是>=i-1
						temp+=num[j-m]; //这里不能直接在num[j]上累加，因为会把之前的f(n-1,s)也加上
					}
				}
				num[j]=temp;
			}
		}
		for(int i=n;i<=k*n;i++){//打印概率
			double pro=num[i]/Math.pow(k, n);
			System.out.println(i+"共有"+num[i]+"次，其概率= "+pro);
		}
	}
	public static void solve(int n)//由于从前往后更新的方法，所以需要额外一个数组存上一次结果
	{	
		if(n==0) return;
		int[] result = new int[6*n+1];//为了方便，就将下标作为和
		
		for(int i=1;i<=6;i++)
		{
			result[i] = 1;
		}
		for(int i=2;i<=n;i++)
		{	
			int[] result_temp = new int[6*n+1];//为了方便，就将下标作为和
			//从i到6*i
			for(int j=i;j<=6*i;j++)
			{	
				for(int k=j-1;k>=j-6;k--)
				{
					if(k>=1) result_temp[j]+=result[k];
				}
			}
			result = result_temp;//这样两个数组交替，可以使得第N个时，前N-1=0，所以不用担心上一种方法的注意点
		}
		for(int i=n;i<=6*n;i++)
		{
			System.out.println(i+":"+result[i]+" ");
		}
	}
}
*/
/*
//44 扑克牌的顺子  王当作0，即任意配  抽取5张牌
public class Sword{
	boolean continuous(int[] s){
		int len=s.length;
		if(s==null || len<5){
			return false;
		}
		Arrays.sort(s);
		int zeros=0;
		int begin=0;
		for(int i=0;i<len;i++){
			if(s[i]==0){
				zeros++;
				begin++;
			}
		}
		if(zeros>=4){
			return true;
		}
		int cha=0;
		for(int i=begin+1;i<len;i++){
			if(s[i-1]==s[i]){
				return false;
			}else{
				cha+=s[i]-s[i-1]-1;
			}
		}
		return zeros>=cha? true:false;
	}
}
*/
/*
//45 圆圈中最后剩下的数字 丢手绢 约瑟夫  见test1我的Yuesefu函数
public class Sword{
	public int last(int n,int k){
		if(n<=0 || k<=0){
			return -1;
		}
		int f0=0;
		int fi=0;
		for(int i=2;i<=n;i++){
			fi=(f0+k)%i;
			f0=fi;
		}
		return fi;
	}
}
*/
/*
//46 不用循环判断等求1+2+。。+n，  思路用短路思想
public class Sword{
	public int sumN(int n){
		if(n<=0)
			return 0;
		int sum=0;
		boolean y = (n>=1) && (sum=n+sumN(n-1))>0;//注意后面>0当作判断，别的也行，只要能让递归运行且不影响结果就行
		return sum;
	}
}
*/
//48 不能被继承的类，这题Java不好做，直接用final修饰类就行。。。
/*
//47 不用加减乘除做加法  思路 a和b异或当作基础和，a和b与之后左移一位当进位。然后前者是a，后者是b，不同这样计算，知道后者即进位=0
public class Sword{
	public int sum(int a,int b){
		while(b!=0){
			int sum=a^b;
			int carry=(a&b)<<1;
			a=sum;
			b=carry;
		}
		return a;
	}
}
*/
/*
//49 把字符串转换成整数，  主要考察特例处理，如符号位，非法0-9如abc等，以及int值的溢出问题
public class Sword{
	public boolean isValid=true;//用一个全局变量说明返回值0是真的输入为0，还是由于非法输入导致的。
	public int strToint(String s){
		int len=s.length();
		if(s==null || len==0 || (len==1 && (s.charAt(0)=='+' || s.charAt(0)=='-'))){
     isValid=false;  //空，只有一个符号位，都直接返回
			return 0;
		}
		char[] c=s.toCharArray();
		int res=solve(c);
		if(!isValid){
			return 0;
		}else{
			return res;
		}
	}
	public int solve(char[] c){
		int len =c.length;
		boolean minus=false;
		int begin=0;
		if(c[0]=='+'){
			begin++;
		}
		if(c[0]=='-'){
			minus=true;
			begin++;
		}
		long sum=0;//先用long保持结果，判断是否溢出，这样比较方便
		int temp=0;
		for(int i=begin;i<len;i++){
			temp=c[i]-'0';
			if(temp>=0 && temp<=9){
				sum=sum*10+temp;
				if((!minus && sum>Integer.MAX_VALUE) ||(minus && -sum<Integer.MIN_VALUE)){
					isValid=false;
					return 0;
				}
			}else{
				isValid=false;
				return 0;
			}
		}
		return minus==true? -1*(int)sum:(int)sum;
	}
}
*/
/*
//50 树中两个节点的最低公共祖先 3个问题进阶，1.是AVL树时，判断与root值大小来判断，直到一大一小就是公共的。
//2.如果是普通二叉树，但是有指向父节点的指针，那么就是转换成两个链表求第一个公共节点的问题，从输入的2个节点开始向上找，见题目37
//3.没有指向父节点指针的普通树，甚至不是二叉树。从root开始找到两个节点，记录这2条路径，然后找到最后一个不同节点就是
public class Sword{
	//1：AVL树 假设没有重复值      当然也可以用递归，我用循环好一点
	public Node avl(Node root,Node t1,Node t2){
		if(root==null || t1==null || t2==null)
			return null;
		Node pub=root;
		Node have=null;
		while(pub.left!=null || pub.right!=null){
			if((t1.val-pub.val)*(t2.val-pub.val)<0){
				have=pub;
				return have;
			}else if(t1.val<pub.val && t2.val<pub.val){
				pub=pub.left;
			}else{
				pub=pub.right;
			}
		}
		return have;//这样可以返回null当节点不在这个root树中时
	}
	//2：并非AVL，但是有指向父节点的指针.长的先走一部分，然后两个一起走，一直到第一个相同节点
	public Node pointer(Node root,Node t1,Node t2){
		if(root==null || t1==null || t2==null){
			return null;
		}
		int len1=1;
		int len2=1; //或者初始为0
		Node tt1=t1;
		Node tt2=t2;
		while(tt1.father!=null){//初始为0，那么这里就是tt1!=null。我这样是为了下面好比较二者是否都是同一个root
			len1++;
			tt1=tt1.father;
		}
		while(tt2!=null){
			len2++;
			tt2=tt2.father;
		}
		if(tt1!=tt2){
			return null;//如果跟节点两个不同，说明，这两个节点肯定不是一颗树上的，这些都是自己加的功能
		}
		tt1=t1;
		tt2=t2;
		if(len1>len2){
			for(int i=0;i<len1-len2;i++){
				tt1=tt1.father;
			}
		}else if(len1<len2){
			for(int i=0;i<len2-len1;i++){
				tt2=tt2.father;
			}
		}
		while(tt1.father!=null){
			if(tt1.father==tt2.father){
				return tt1.father;
			}
			tt1=tt1.father;
			tt2=tt2.father;
		}
		return null;//如果上面没有返回，说明肯定没有公共节点，所以直接返回null
	}
//3: 没有指向上级指针，只是普通的树.先寻找出根结点到两个目的节点的路径链表，再从根结点开始，两个链表的最后一个公共节点就是最低公共节点
	public Node norm(Node root,Node t1,Node t2){
		if(root==null || t1==null || t2==null){
			return null;
		}
		ArrayList<Node> list1=getPath(root,t1);
		ArrayList<Node> list2=getPath(root,t2);
		Node pub=null;
		for(int i=0;i<Math.min(list1.size(), list2.size());i++){
			if(list1.get(i)!=list2.get(i)){
				pub=list1.get(i-1);
				break;
			}
		}
		return pub;
	}
	public ArrayList<Node> getPath(Node root,Node t){
		ArrayList<Node> list=new ArrayList<Node>();
		if(root==null)
			return list;
		list.add(root);
		if(root==t)
			return list;
		if(root.left!=null)
			return getPath(root.left,t);
		if(root.right!=null)
			return getPath(root.right,t);
		list.remove(list.size()-1);
		return list;//这里return null应该也是一样的
	}
}
class Node{
	int val;
	Node left=null;
	Node right=null;
	Node father=null;
	Node(int i){
		this.val=i;
	}
}
*/
/*
//51 数组中重复的数字  长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，找出任意一个重复的数字。O(n)时间O(1)空间
//思路 如排序则应是下标对应数值，利用这点。s[n]=n,就下一个，扫描s[N]=M ，检查s[M],如果等于M，则有重复，不等就交换这两个数。
public class Sword{//网站提交格式，输出在dup[0],没有返回false
	public boolean duplicate(int[] s,int len,int[] dup){
		if(s==null || len<=0){
			return false;
		}
		for(int i=0;i<len;i++){
			while(s[i]!=i){
				int t=s[i];
				if(s[i]==s[t]){
					dup[0]=t;
					return true;
				}else{
					s[i]=s[t];
					s[t]=t;
				}
			}
		}
		return false;
	}
}
*/
/*
//52 构建乘积数组   不能使用除法  给定一个数组A,构建数组B,B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
//思路 类似于动态规划的做法，不必每次重新乘，将中间结果一步一步存起来
public class Sword{
	public int[] mul(int[] a){
		int len=a.length;
		if(a==null || len<=1){
			return null;
		}
		int[] left=new int[len];
		left[0]=1;
		int[] right=new int[len];
		right[0]=1;
		for(int i=1;i<len;i++){
			left[i]=left[i-1]*a[i-1];
		}
		for(int i=1;i<len;i++){
			right[i]=right[i-1]*a[len-i];
		}
		int[] b=new int[len];
		for(int i=0;i<len;i++){
			b[i]=left[i]*right[len-i-1];
		}
		return b;
	}
}
*/

//53 正则表达式     正则表达式匹配。递归
/*leetcode 的hard题，有很多短代码，就用下面这个DP方法吧
1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*': 
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
        return false;
    }
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i-1]) {
            dp[0][i+1] = true;
        }
    }
    for (int i = 0 ; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '.') {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == s.charAt(i)) {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                    dp[i+1][j+1] = dp[i+1][j-1];
                } else {
                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
    }
    return dp[s.length()][p.length()];
}
//最短代码C++的
bool isMatch(const char *s, const char *p) {
        if (!*p)
            return !*s;
        if (p[1] == '*')
            return isMatch(s, p+2) || (*p == '.' && *s || *s == *p) && isMatch(s+1, p);
        if (*p == '.')
            return *s && isMatch(s+1, p+1);
        return *s == *p && isMatch(s+1, p+1);
    }
思路：只有当模式串和字符串同时等于\0，才可以认为两个串匹配。
在匹配中，对于每个位的匹配可以分为三种情况
1、（相应位匹配||模式串为.&&字符串不是\0）&&模式串下一位是*
2、（相应位匹配||模式串为.&&字符串不是\0）&&模式串下一位不是*
3、相应位不匹配&&（模式位不为.||字符串是\0）
对应1，最复杂。分为*取0，*取1，*>=2三种情况。
*取0对应跳过当前匹配位，继续寻找patter的下一个匹配位，str不变，pattern+2
*取1对应当前匹配位算一次成功匹配，str+1，pattern+2
*取>=2对应一次成功匹配，继续匹配字符串的下一位是否匹配，str+1，pattern不变
三者取或。即只要有一种情况能匹配成功认为字符串就是匹配成功的。
对应2，相当于一次成功匹配，str+1，pattern+1
对应3，匹配失败，直接返回false
*/
/*
public class Sword {
	 boolean match(char[] s, char[] p){
	        return isMatch(s,0,p,0);
	    }	 
	 public boolean isMatch(char[] s,int start1,char[] p,int start2){
		 int lens=s.length;
		 int lenp=p.length;
		 if(start1==lens&&start2==lenp) return true;
		 if(start2>=lenp) return false;//只有pattern结束了才能结束整个过程，字符结束要继续看pattern可能仍能匹配
		 if(start2<lenp-1){
			 if(p[start2+1]=='*'){//对应1
				 if((start1<lens)&&(s[start1]==p[start2]||p[start2]=='.')){
					 return isMatch(s,start1,p,start2+2)||isMatch(s,start1+1,p,start2+2)||isMatch(s,start1+1,p,start2);
				 }else return isMatch(s,start1,p,start2+2);//不等的话，只能是*当0次
			 }
		 }
		 if(start1==lens) return false;
		 if(s[start1]==p[start2]||p[start2]=='.')//对应2
			 return isMatch(s,start1+1,p,start2+1);
		 return false; //对应3       
	 }
}
*/
/*
//54 表示数值的字符串  思路：用一个指针i遍历，根据可能出现的先后情况做判断
public class Sword {
boolean isNumeric(char[] s) {
	 int len=s.length ;
 if(len==0) return false;
 if((len==1)&&(s[0]<'0'||s[0]>'9')) return false;
 if(s[0]=='+'||s[0]=='-'){
     if(len==2&&(s[1]=='.')) return false;
 }else if((s[0]<'0'||s[0]>'9')&&s[0]!='.') return false;//首位既不是符号也不是数字还不是小数点，当然是false
 int i = 1;
 while((i<len)&&(s[i]>='0'&&s[i]<='9')) i++;
 if(i<len&&s[i]=='.'){
     i++;
     //if(i>=s.length) return false;
     while((i<len)&&(s[i]>='0'&&s[i]<='9')) i++;
 }
 if(i<len&&(s[i]=='e'||s[i]=='E')){
     i++;
     if((i<len)&&(s[i]=='+'||s[i]=='-')){
         i++;
         if(i<len) while((i<len)&&(s[i]>='0'&&s[i]<='9')) i++;
         else return false;
     }else if(i<len){
         while((i<len)&&(s[i]>='0'&&s[i]<='9')) i++;
     }else return false;
 }
 if(i<len) return false;            
 return true;        
}
}
*/
/*
//55 字符流中第一个不重复的字符  hashMap实现，下面写法只是为了网站刷题格式，OJ的方式见方法见之前写的HashmapZifu函数
public class Sword{
	StringBuffer sb=new StringBuffer();
	public void insert(char ch){
		sb.append(ch);
	}
	public char first(){
		char[] c=sb.toString().toCharArray();
		HashMap<Character,Integer> hm=new HashMap<>();
		int len=c.length;
		if(len==0)
			return '#';
		for(int i=0;i<len;i++){
			if(hm.containsKey(c[i])){
				hm.put(c[i], hm.get(c[i])+1);
			}else{
				hm.put(c[i],1);
			}
		}
		for(int i=0;i<len;i++){
			if(hm.get(c[i])==1){
				return c[i];
			}
		}
		return '#';
	}
}//============第二种，利用ASCII码当下标即Key，用字母在字符流中的位置当Value，重复就变-1，用数组模拟HashMap
public class Sword {
     final static int num = 256;
     int arr[] = new int[num];
     int index = 1;
     //Insert one char from stringstream
     public void Insert(char ch)
     {
         if(arr[ch] == 0)  //第一次出现，则存出现的顺序
             arr[ch] = index;
         else  //非首次出现，此字符视为无效
             arr[ch] = -1;
         index++;
     }
   //return the first appearence once char in current stringstream
     public char FirstAppearingOnce()
     {
         int min = Integer.MAX_VALUE;
         char result = '#';
         for(int i = 0; i < num; i++){//找出数组中大于0的数中最小的一个数就是第一个出现一次的
             if(arr[i] > 0 && arr[i]<min){  //arr[i]>0表示找到出现次数只为1的字符
                 min = arr[i];//如果比最小的小，就更新最小的
                 result = (char)i;
             }
         }
         return result;
     }
 }

*/
/*
//56 链表中环的入口节点  思路先找出换中节点个数n，然后一个先走n次，然后一起走，相遇的那个点就是入口。关键是找出n
//可以利用15题判断是否优环方法，一快p2一慢p1，相遇时肯定在环中，然后从此点计数，再次到这个点时可以算出多少个节点n
//2.再巧妙一点，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;
//可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。
//3.更巧但是要断开链表。两个指针同时向后移动，每移动一次，前面的指针的next指向NULL。
//也就是说：访问过的节点都断开，最后到达的那个节点一定就是入口。。。
public class Sword{
	public Node first(Node root){
		if(root==null || root.next==null){
			return null;
		}
		Node fast=root;
		Node slow=root;//判断链表是否有环结构
		while(fast!=null || slow!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow){
				break;
			}
		}
		fast=root;//这一步有一个危险，假如入口是第一个，这样下面的while就进不去，
		while(fast!=slow){
			fast=fast.next;
			slow=slow.next;
		//	if(fast==slow){
		//		break;//由于while可能进不来，所以不能用这里return fast，最后return null，因为可能不对
		//	}
		}
		return fast;
	}
}
class Node{
	int val;
	Node next=null;
	Node(int i){
		this.val=i;
	}
}
*/
/*
//57 删除链表中重复的节点  排序的链表中 1->2->3->3->4->4->5 处理后为 1->2->5 如果是无序的见左程云71，可以用HashSet，判断是否出现过
//step1：判断   //Leet 83题类似
public class Sword{
	public Node deleteDuplication(Node pHead)
{//书上的方法，不过感觉还是自己的有条理，就是复杂一点
 if(pHead==null)return null;   
 Node preNode = null;
 Node node = pHead;
 while(node!=null){
 	Node nextNode = node.next;
     boolean needDelete = false;
     if(nextNode!=null&&nextNode.val==node.val){
         needDelete = true;
     }
     if(!needDelete){
         preNode = node;
         node = node.next;
     }
     else{
         int value = node.val;
         Node toBeDel = node;
         while(toBeDel!=null&&toBeDel.val == value){
             nextNode = toBeDel.next;
             toBeDel = nextNode;
             if(preNode==null)
                 pHead = nextNode;
             else
                 preNode.next = nextNode;
             node = nextNode;
         }
     }
 }
 return pHead;
}
	//下面自己写的有点复杂，就记忆自己的吧
	public Node dup(Node root){
		if(root==null || root.next==null){
			return root;
		}
		Node pre=root;
		Node now=root;
		Node after=now.next;//
		while(after!=null){
			if(now.val!=after.val){
				pre=now;
				now=after;
				after=after.next;
			}else{
				Node first=after.next;//下面第一个不重复的节点
				while(first!=null && first.val==after.val){
					first=first.next;
				}
				if(now==root){//说明第一次就进到这里，即上面的now更新没执行过，也就是第一个就有重复
					if(first==null){
						return null;
					}
					root=first;//更新root后相当于重新开始
					pre=first;
					now=first;
					after=now.next;
				}else{//中间的重复用下面去除
					if(first==null){
						pre.next=null;
						return root;
					}
					pre.next=first;
					now=pre.next;
					after=now.next;
				}
			}
		}
		return root;
	}
}
class Node{
	int val;
	Node next=null;
	Node(int i){
		this.val=i;
	}
}
*/
/*
//58 二叉树的下一个节点   给定一个二叉树和其中的一个结点，找出中序遍历顺序的下一个结点。树中的结点包含指向父结点的指针。
public class Sword{
	public Node getNext(Node tn){
		if(tn==null)
			return null;
		if(tn.right!=null){//如果有右子树，则找右子树的最左节点
			Node nextN=tn.right;
			while(nextN.left!=null){
				nextN=nextN.left;
			}
			return nextN;
		}
		while(tn.father!=null){//没右子树，则找第一个当前节点是父节点左孩子的节点
			if(tn.father.left==tn){
				return tn.father;
			}else{
				tn=tn.father;
			}
		}
		return null; //退到了根节点仍没找到，则返回null
	}
}
class Node{
	Node left=null;
	Node right=null;
	Node father=null;
	int val;
	Node(int i){
		this.val=i;
	}
}
*/
/*
//59 对称的二叉树  思路1： 前序遍历，和对称的前序遍历（先右后左），注意要在空的位置和叶节点加上Null，然后比较2个序列一样就行
//思路2： 在叶节点末和空的位置加上null的话，应该可以用中序遍历得到序列，检查序列是否对称就行
//思路3： 最好的方法，用递归。首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同，左子树的右子树和右子树的左子树相同即可
public class Sword{
	public boolean sym(Node root){
		if(root==null){
			return true;
		}
		return isSym(root.left,root.right);
	}
	public boolean isSym(Node left,Node right){
		if(left==null){
			return right==null;//左空，则看右边是否空
		}
		if(right==null){//左不空，右空，则false
			return false;
		}
		if(left.val!=right.val){
			return false;
		}
		return isSym(left.left,right.right) && isSym(left.right,right.left);
	}
}
class Node{
	Node left=null;
	Node right=null;
	Node father=null;
	int val;
	Node(int i){
		this.val=i;
	}
}
*/
/*
//60 把二叉树打印成多行 左程云P133   思路在前面BFS 广度 宽度优先遍历二叉树的基础上加一个判断一行结束就行
public class Sword{//每行用一个List保存，只打印的话直接打印就行，不用保存
	public ArrayList<ArrayList<Integer> > print(TreeNode root) {
	    	ArrayList<ArrayList<Integer>> listlist=new ArrayList<>();
	        if(root==null){
	            return listlist;
	        }
	        Queue<TreeNode> que=new LinkedList<TreeNode>();
	        TreeNode last=root;
	        TreeNode nlast=null;//最主要是这两个last的使用last表示当前行最右一个，nlast表示下一行最右边一个
	        que.offer(root);
	        TreeNode temp=root;
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        while(!que.isEmpty()){
	       		 temp=que.poll();
	             list.add(temp.val);
	            if(temp.left!=null){
	                que.offer(temp.left);
	                nlast=temp.left;
	            }
	            if(temp.right!=null){
	                que.offer(temp.right);
	                nlast=temp.right;
	            }//更好的办法判断一行个数，就是每行打印que.size次，这是肯定的。见Leetcode107和102
	            if(temp==last){
	                listlist.add(new ArrayList<Integer>(list));
	                list.clear();
	                last=nlast;
	            }
	        }
	       return listlist;
	     
	    }
}
class TreeNode{
	int val;
	TreeNode left=null;
	TreeNode right=null;
	TreeNode(int i){
		this.val=i;
	}
}
*/
/*
//61 按之字形顺序打印二叉树 ZigZag  利用Java中的LinkedList的底层实现是双向链表的特点。
//1)可用做队列,实现树的层次遍历   2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
//奇数，从头部遍历，并将其子节点先左后右放入队尾。偶数，则从尾部遍历，并将其子节点先右后左放入头部.
//不采用存在ArrayList中，偶数层时进行reverse实现，数据量大时，效率太低。
public class Sword{
	public ArrayList<ArrayList<Integer>> print(TreeNode root){
		ArrayList<ArrayList<Integer>> listlist=new ArrayList<>();
		if(root==null){
			return listlist;
		}
		Deque<TreeNode> que=new LinkedList<>();//也可以直接前面用LinkedList
		ArrayList<Integer> list=new ArrayList<>();
		TreeNode last=root;
		TreeNode nlast=null;
		boolean lt2rt=true;
		que.offer(root);
		while(!que.isEmpty()){
			TreeNode temp=null;
			if(lt2rt){
				temp=que.removeFirst();//que.pollFirst()也行
				if(temp.left!=null){
					que.addLast(temp.left);
					nlast= nlast==null? temp.left : nlast; //每行打印第一个时，他对应的子节点是下一行的打印的
				}                                         //最后一个，所以每次只在第一个打印的时候更新nlast
				if(temp.right!=null){
					que.addLast(temp.right);
					nlast= nlast==null? temp.right : nlast;
				}
			}else{
				temp=que.pollLast();
				if(temp.right!=null){
					que.addFirst(temp.right);
					nlast= nlast==null? temp.right : nlast;
				}
				if(temp.left!=null){
					que.addFirst(temp.left);
					nlast= nlast==null? temp.left : nlast;
				}
			}
			list.add(temp.val);
			if(temp==last){
				listlist.add(new ArrayList<Integer>(list));
				lt2rt=!lt2rt;
				list.clear();
				last=nlast;
				nlast=null;//每次置空，这样在更新时，容易判断当前是否需要更新
			}
		}
		return listlist;
	}
}
class TreeNode{
	int val;
	TreeNode left=null;
	TreeNode right=null;
	TreeNode(int i){
		this.val=i;
	}
}
*/
/*
//62 序列化二叉树  反序列化二叉树
public class Sword{
	public String ser(TreeNode root){
		StringBuffer sb=new StringBuffer();
		if(root==null){
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val+",");
		sb.append(ser(root.left));
		sb.append(ser(root.right));
		return sb.toString();
	}
	int index=-1;
	public TreeNode deser(String s){		
		int len=s.length();
		if(len<=0 || s==null){
			return null;
		}
		String[] ss=s.split(",");
		return des(ss);
	}
	public TreeNode des(String[] ss){
		TreeNode root=null;
		if(index>=ss.length){
			return null;
		}
		index++;
		if(!ss[index].equals("#")){//注意不能用!=，要用equals
			root=new TreeNode(Integer.valueOf(ss[index]));//或者Integer.parseInt
			root.left=des(ss);
			root.right=des(ss);
		}
		return root;
	}
}
class TreeNode{
	TreeNode left=null;
	TreeNode right=null;
	int val;
	TreeNode(int i){
		this.val=i;
	}
}
*/
/*
//63 二叉搜索树的第K个结点   思路：(递归或者循环都行)中序遍历是递增的，容易找到从小到大第K个数字
public class Sword{
	private int cnt=0;//注意这个变量，记录次数，不能使用路径和为某值的思路，那样需要计算左节点有多少个后减掉再递归右边
	public Node getK(Node root,int k){//递归思路，有点技巧，不好记，就记下面非递归的。其实是一样的
		if(root==null || k<=0){
			return null;
		}
		Node temp=getK(root.left,k);
		if(temp!=null){
			return temp;
		}
		cnt++;
		if(cnt==k){
			return root;
		}
		return getK(root.right ,k);
	}
	public Node getK2(Node root,int k){//正常思路：非递归的方式，先得到中序，到了K就停止遍历
		if(root==null || k<=0){
			return null;
		}
		int cnt=0;
		Stack<Node> stack=new Stack<>();
		Node temp=root;
		while(temp!=null || !stack.isEmpty()){
			if(temp!=null){
				stack.push(temp);//不停把左结点放入
				temp=temp.left;
			}else{
				temp=stack.pop();//左节点放完，弹出一个，放右节点
				if(++cnt==k){
					return temp;
				}
				temp=temp.right; //对于没个右节点也是要不停放左节点。
			}
		}
		return null;
	}
}
class Node{
	Node left=null;
	Node right=null;
	int val;
	Node(int i){
		this.val=i;
	}
}
*/
/*
//64 数据流的中位数  思路：可以用AVL平衡二叉搜索树实现，但是比较难写出来，所以用两个堆来解决，一个最大堆，一个最小堆
//中位数用两个数M1和M2来表示，奇数时两个都是中间数。M1是左边数中最大的，M2是右边数中最小的。
//堆不用自己实现，可以用优先队列实现
public class Sword{
	private int cnt=0;
	Comparator<Integer> max=new Comparator<Integer>(){
		@Override
		public int compare(Integer a,Integer b){
			return -a.compareTo(b);//把正常大小比较反一下
		}
	};
	private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
	private PriorityQueue<Integer> maxHeap=new PriorityQueue<>(11,max);//11是系统默认容量大小，自己设置起始可以随便
//两个堆，右边的最小堆中的数要都比左边的最大堆中的数大，所以按照奇偶判断插入时，还要检查是否满足这一条件
	public void insert(Integer num){
		if((cnt&1)==0){//偶数，放在最小堆
//			if(num<maxHeap.peek()){//不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆。
//				maxHeap.offer(num);//并且这样不对，第一次时peek没有值，所以还是统一用下面先插入后取
//				int big=maxHeap.poll();
//				minHeap.offer(big);
//			}else{
//				minHeap.offer(num);
//			}
			maxHeap.offer(num);
			int big=maxHeap.poll();
			minHeap.offer(big);
		}else{//奇数放在最大堆。可以不像上面那样判断，直接插入另一个堆，然后取堆顶就行，反正得到的数是一样的
			minHeap.offer(num);
			int small=minHeap.poll();
			maxHeap.offer(small);
		}
		cnt++;
	}
	public Double mid(){
//		double min=minHeap.peek();//不能这样先取值，后面输出，因为可能没有数，只是实时的。所以还是下面这样安全
//		double max=maxHeap.peek();
		if((cnt&1)==0){//偶数个数
			return ((double)(minHeap.peek()+maxHeap.peek()))/2;
		}else{
			return (double) minHeap.peek();//因为前面cnt为偶数时放在最小堆中，初始值cnt=0;所以是第一个数，第3，5，7个数放在右边的最小堆中，所以奇数返回min
		}
	}
}
*/
/*
//65 滑动窗口的最大值  如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}
//思路： 双端队列
public class Sword{
	public static void main(String[] args) {
		int [] s=new int[]{16,14,12,10,8,6,4};
		int k=5;
		max(s,k);
	}
static	public ArrayList<Integer> max(int[] s,int k){
		int len=s.length;
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(s==null || len<k || k<=0){
			return list;
		}
		Deque<Integer> dq=new LinkedList<Integer>();
		for(int i=0;i<len;i++){
			int begin=i-k+1;//窗口的开始下标
			if(dq.isEmpty()){
				dq.offerLast(i);//注意插入的是下标,此时插入无所谓前后，只有一个
			}else if(dq.peekFirst()<begin){//超出窗口的元素删除
				dq.pollFirst();//removeFirst也一样
			}
			while(!dq.isEmpty() && s[dq.peekLast()]<=s[i]){//这个等号很关键，第一次dq空时前面已经插入一次，如果没有
				dq.pollLast();//去掉比当前要插入的小的值              //没有等号，那么下面又插入了一次第一个元素。所以用等号可以
			}                                              //可以解决这个问题，第一个元素之插入一次
			dq.addLast(i);//注意是存入下标
			if(begin>=0){//begin大于0表示窗口从0开始，之前存入都没满一个窗口所以不用输出Max
				list.add(s[dq.peekFirst()]);
				System.out.println(dq.peekFirst());
			}
		}
		return list;
	}
}
*/
/*
//66 矩阵中的路径   使用回溯法（类似递归）//所谓的回溯无非就是对使用过的字符进行标记后和处理后的去标记
//用一个状态数组保存之前访问过的字符，然后再分别按上，下，左，右递归
public class Sword{
	public static void main(String[] args) {
		char[] c="ABCESFCSADEE".toCharArray();
		char[] s="ABCCED".toCharArray();
		boolean hh=path(c,3,4,s);
		System.out.println(hh);
	}
static	public boolean path(char[] matrix,int row,int col,char[] s){
		boolean[] flag=new boolean[matrix.length];//记录是否已经走过此点
		if(matrix==null || matrix.length==0 || s==null || s.length==0)
			return false;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(haspath(matrix,row,col,s,i,j,flag,0))
					return true;
			}
		}
		return false;
	}
static	public boolean haspath(char[] matrix,int row,int col,char[] s,int i,int j,boolean[] flag,int index){
		int xy=i*col+j;
		if( i<0 || i>=row || j<0 || j>=col|| (flag[xy]==true) ||(s[index]!=matrix[xy])){
			return false;//注意上面的条件判断中，前面的边界不能放在后面判断，否则有错误，会有i=-1的情况
		}       //因为如果不先判断边界，可能某次xy=-4;而这对于flag[xy]是非法的，所以要先判断边界
		if(index== s.length-1)//最后一个相等了，则结束
			return true;
		flag[xy]=true;
		if( haspath(matrix,row,col,s,i-1,j,flag,index+1)//上
				|| haspath(matrix,row,col,s,i+1,j,flag,index+1)//下
				|| haspath(matrix,row,col,s,i,j-1,flag,index+1)//左
				|| haspath(matrix,row,col,s,i,j+1,flag,index+1)){//右
			return true;
			}
		flag[xy]=false;
		return false;
	}
}
*/
//67 机器人的运动范围  思路同上一题，回溯法
public class Sword{
	public int movingCount(int max,int row,int col){
		if(row<=0 || col<=0 || max<0)
			return 0;
		boolean[][] flag=new boolean[row][col];//状态矩阵
		return move(max,row,col,0,0,flag);
	}
	public int move(int max,int row,int col,int x,int y,boolean[][]flag){
		if(x<0||x>=row || y<0||y>=col || flag[x][y]==true || (num(x)+num(y)>max)){
			return 0; //判断边界以及大小是否超过max
		}
		flag[x][y]=true;//设置为走过该点  //下面是1+其他4个方向，注意这里最后不需要回溯，因为点可以就+1，不用整个路径可以
		return 1+move(max,row,col,x-1,y,flag)+move(max,row,col,x+1,y,flag)
				+move(max,row,col,x,y-1,flag)+move(max,row,col,x,y+1,flag);
	}
	public int num(int x){//计算一个数各个位置和
		if(x<=0)
			return 0;
		int sum=0;
		while(x!=0){
			sum+=x%10;
			x=x/10;
		}
		return sum;
	}
}







