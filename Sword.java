package yang.sowrd;

import java.util.*;
/*
//2����ģʽ
public class Sword {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	//	SingletonClass sc=new SingletonClass(); //�������У���Ϊ���캯����private�������ⲿ��
		SingletonClass sc=SingletonClass.getIn();
	}

}
// ������̬�ڲ��� �ŵ㣺����ʱ�����ʼ����̬����INSTANCE����Ϊû������ʹ�ã��ﵽLazy loading

class SingletonClass{
	private SingletonClass(){
		
	}
	public static final SingletonClass getIn(){
		System.out.println("OK!");
		return Need.ins;
	}
	private static class Need{ //��̬�ڲ���ķ���
		Need(){                  //������䣬��ʽ����getInʱ���Ż�ʵ����
			
		}
	private	static final SingletonClass ins= new SingletonClass();
	}
}
//������,ȱ�㣺û�дﵽlazy loading��Ч��
class HungrySingleton{
    private static HungrySingleton singleton=new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return singleton;
    }
}
// һ�����������õ�д��
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
//3��ά�������
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
//4�滻�ַ�
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
//#include<cmath>  // math.h��C���÷�����Ȼ��C++��Ҳ��
//���ַ����е�yes����no��  ˼·��ֱ����ǰ�����ƣ���󽫶�����������
void Re(char b[], int length)
{
	 �����ж��ٸ�yes,�������Բ�����һ����������Ϊ�˶�һ�������Ժ��������
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
//==========������ο��Բ���ͳ�ƣ��ַ���̵Ĳ���Ҫ����ɾ�Ҫ��
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
//5�����ӡ����
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
	//�ݹ鷽ʽ��ӡ��³���Բ�������stack�ã��ڵ�̫�࣬�ݹ���̫�಻��
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
//6�ؽ�������  ��֪��������������������������,�ؽ����������
/*
import java.util.*;
public class Sword{ //�����������
	public static void main(String[] args) {
		
		int[] pre={1,2,4,7,3,5,8,6};
		int[] in={4,7,2,1,5,3,8,6};
		TN root=consTree(pre,in);
		//������֮ǰд�Ĵ�ӡ�������Ⱥ����鿴���
	}
	public static TN consTree(int[] pre,int[] in){
		if(pre.length==0 || in.length==0 || pre.length!=in.length)
		{
			System.out.println("�������������������");
			return null;
		}
		TN root= new TN(pre[0]);//���ڵ�
		boolean have=false;
		for(int i=0;i<in.length;i++)
		{
			if(in[i]==root.val)
			{
				have=true;  //�ж��ǲ������У����������pre[0]�����Ǹ��ڵ㣬��in���Ҳ��������Ժ����ж����null,����ֱ�����root
				int[] pre2left=Arrays.copyOfRange(pre,1,1+i);
				int[] in2left=Arrays.copyOfRange(in,0,i);
				root.left=consTree(pre2left,in2left);
				int[] pre2right= Arrays.copyOfRange(pre,1+i,pre.length);
				int[] in2right = Arrays.copyOfRange(in,i+1,in.length);
				root.right=consTree(pre2right,in2right);
			}
		}
		if(!have){
			System.out.print("û�и��ڵ㣬�������");
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
//���淽��֮��ӡ���������û�й�����
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


//7����stack��ջʵ�ֶ���queue
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
		if(s2.isEmpty()){ //����ж���s1����S2���ǲ�����ĵ����ˣ�����s1�����Ѿ�û�ˣ��Ͳ���pop
			System.out.println("Queue��û��Ԫ�ز���pop");
			return -1; 
		}
		return s2.pop();
	}
}
*/
//8��ת�������С����  ���ֲ���
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
				throw new Exception("��������Ϊ��");
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		int left=0;
		int right=array.length-1;
		int mid=left;
		while(array[left]>=array[right])
		{
			if(left+1==right){ //ֻ������������������С��
				mid=right;
				break;
			}
			mid = (left+right)/2;
			if(array[left]==array[mid] && array[mid]==array[right]) //ֻ��˳�����
			{
				int temp=array[left];
				for(int i=left+1;i<=right;i++){
					if(temp>array[i])
						temp=array[i];
				}
				return temp;
			}
			//������˳�����
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
//9쳲���������  ������̨��  �����зž���
/*
public class Sword{
	public static void main(String[] args) {
		int a=fb(4);
		System.out.println(a);
	}  //�ݹ鷽�����ã��ظ�����ܶ�������������һάDP����̬�滮��
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
//���ܱ�̬��̨�� 2^(n-1) ,һ�ο�����1��2��3������n�֣��ÿ�ѧ���ɷ�����֤��f(n)=f(n-1)+f(n-2)+```+f(1);
/*          // f(n-1)=f(n-2)+```+f(1)   so f(n)=2*f(n-1)
public class Sword{
	public static void main(String[] args) {
		int a=f(4);
		System.out.println(a);
	}
	static int f(int n){
		return (int)Math.pow(2, n-1);
		//return 1<<(n-1);  //����Ϊ�����ֱ�ӣ���������ĺ���Ҳ�ܺã����ڲ��Ż��ģ��ٶȲ�����λ����
	}
}
*/
//10λ���� ��������1�ĸ���
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
//11 ��ֵ�������η�
//��ֵ�������η���Ҫע����ǣ�ָ���Ǹ���������������0
//����1/2���ݵ����, 32�η����16�ξ��У��ݹ飬�������ٳ��Դ��Լ�
/*
public class Sword{
	public double power(double base,int n){
		//0�ĸ����η������壬0��0�η�Ҳû�����壬����ʱ��Ϊ1����ʱΪ0
		//double�ĺ�float����ֵ�Ƚϲ�����==����Ϊ�������������<0.00000001�ж�
		if(Math.abs(base)<0.00000001 && n<0)  return 0.0;
		if(n==0) return 1;
		boolean fushu=false;
		if(n<0){
			fushu=true;
			n=-n;
		}
		if(n==1) return base;
		double ex=power(base,n>>1); //����λ��������2��int��ĳ˳�2����������λ
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
//12 ��ӡ1������nλ��       //����ʹ������Ӧ��Ҳ��
//��ӡ0-nλ�����е��������֣�����Ҫ�������ֳ��꣬����200λ��long��int�������ˣ�����ʹ���ַ������д�ӡ

//13 O(1)ʱ��ɾ����������ڵ�
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
	// ǰһ�����������������ͷ����һ����Ҫɾ���ĵ�
	public static void delete(ListNode head,ListNode node){ 
		if(head==null || node==null)
			return;
		if(head.next==null){ //ֻ��һ���ڵ�
			head=null;
			return;
		}
		if(node.next ==null){ //β�ڵ㣬ֻ�ܱ���
			ListNode temp=head;
			while(temp.next!=node){
				temp=temp.next;
			}
			temp.next =null;
		}
		else //�ø�����һ����ɾ����һ���ķ���
		{   
			node.val=node.next.val;
			node.next=node.next.next;
//������node=node.next; ��ֻ�����ã���nodeָ��node.next,ֻ����һ�ε���nodeʱ���������ԭ����node.next��ֵ
			//�����������������node�Ĺ��̣�����Java�ĺ������ô��ݽ�����ԭָ��ĸ��ƣ�������ø��Ƶ����ָ��ָ����ڴ�ı䣬��ô������
			//���ú����ı��ԭ����ʵֵ��Ч�������ǣ����������У�ֻ�ǶԸ��Ƶ����ò�������û�ж���ָ����ڴ�Ķ�����û���õġ�
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
//14 ��������˳������λ��ż��ǰ�档����һ��Ҫ�󣬲��ܸı䣬������������ż����ż��֮������˳��
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
	//ԭ���еĲ���֤˳��
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
	//ͬʱ��֤���˳��,ʹ�ò��������˼��
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
//15 �����еĵ�����K���ڵ�
/*
public class Sword{
	public static void main(String[] args) {
		//�����ⶼ�Ƕ�������ָ�룬ͨ���ߵ��ٶȲ�ͬ�����ﵽĿ�ģ����緵���м��㣬����һ����һ����һ����������
		//��56�⣬�ж������Ƿ��ǻ��νṹ��Ҳ��һ���ٶȿ죬һ�������������Ǹ�׷�����ģ���Ȧ������ô�л���
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
//16 ��ת����  ������ת
/*   //  �ݹ� 
public Node inverseDG(Node head){
	if(head==null || head.next==null)
		return head;
	Node newHead=inverseDG(head.next);
	head.next.next=head;
	head.next=null;
	return newHead;
}
//3��ָ��
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
//�ϲ��������������  �ݹ��ѭ��������
public class Sword{
	public static void main(String[] args) {
		
	}
	static public ListNode mergeDG(ListNode list1,ListNode list2){
		if(list1==null)
			return list2; //����ͬʱ��Ҳû�£����ص�null��Ϊ���һ����next��last.next
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
	//ѭ�������ķ���
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
//18 �����ӽṹ ������B�Ƿ��Ƕ�����A���ӽṹ  
/*  //����ǲ���Ҫ��ȫ�ز���ͬ��ֻ��������ṹ���У���ҪҪ��ȫһ������ô��subtree������Ҫ�ϸ�ֻ������ͬʱΪnull���ŷ���true
public class Sword{
	public static void main(String[] args) {
		//�����ݹ飬һ����������ڵ��ҵ�ֵ��B�ĸ��ڵ���ͬ�Ľڵ�
		//һ���������ҵ���ֵͬ�ڵ������ȥ�ж��ǲ���������
		//����aHasB�������жϣ��ú������ֵ���subtree�����ж��ǲ�������
	}
	static public boolean aHasB(Tree A,Tree B){
		if(B==null || A==null)   //��Ŀ�����ʱ����false
			return false;
		//ʣ�µ�ֻ����A �͡�B������null
		boolean have=false;
		if(A.val==B.val)
			have= subtree(A,B);  //�������return����Ϊ��һ�����ǣ���Ҫ�Ƚ������֧
		if(!have)  //�������û�У���Щ���������֧��������˾Ͳ����ˣ�ֱ�ӷ���true
			have= ( aHasB(A.left,B) || aHasB(A.right,B) );
		return have;
	}
	static public boolean subtree(Tree A, Tree B){
		if(B==null)  //ע��A��B��˳���ܽ�����Ҫ���ж�B����������ͬʱΪ��ʱ����true
			return true;  //���������ͬʱΪ�գ�˵��һ�������һ���ڵ���һ��������ȷ��״̬
		if(A==null)     //A=1,0  B=0  true   //A=0  B=1  false  //ʣ�µ�ֻ����A �͡�B������null
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
//19 ���ľ���  �Գ�һ��������  �õݹ� ���� ��ջ
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
//reverse digits of an integer ��ת����
//������ѵ�����int������-2147483648��Χ�ģ������������x�������Խ���ˣ�����0-x����xû��ȥ������
//���Ի�Ҫ�ж�һ���Ƿ�<0 ���������ַ�ʱ��ȥ����һ�����š����о�����double����ת������֣�Ȼ���жϣ��������MAX����MIN����ֱ���쳣����0��
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
//20 ˳ʱ���ӡ���� ��Ȧ��������һȦһȦ��ӡ
//20 ��ת�����ӡ  //ע�����⣬�����static��List��ʽ����OJ�Ͽ���ͨ��������Ϊ����һ�β��ԵĴ𰸱�������List�С����������Կ�����
//�ں����ж���һ��List��Ȼ���봫������
/*
public class Sword{
	static ArrayList<Integer> list=new ArrayList<Integer>();//�����������list�У����Բ��ã�ֱ�Ӵ�ӡ���С�
	public static void main(String[] args) {
		int[][] s=new int[2][2];
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				//s[i][j]=(int)(Math.random()*20);
				s[i][j]=i;
			}
		}
		spiral(s);
		System.out.println("----��������ķ�ʽ----");
		for(int i:list){
			System.out.print(i+" ");
		}
	}
	static void spiral(int[][]s){
		int length=s.length;
		if(length==0)
			return;
		int tr=0;
		int tc=0; //������ʼ������
		int dr=length-1;
		int dc=s[0].length-1;//���½ǽ���������
		while(tr<=dr && tc<=dc){
			printEdge(s,tr++,tc++,dr--,dc--);
		}
	}
	static void printEdge(int[][] s,int tr,int tc,int dr,int dc){
		if(tr==dr){//����ֻ��һ��   ����ֻ��һ��Ԫ�ص����
			for(int i=tc;i<=dc;i++){
				System.out.print(s[tr][i]+" ");
				list.add(s[tr][i]);  //ÿ������list�Ĺ��̶����Բ�Ҫ
			}
		}else if(tc==dc){//ֻ��һ��  ���elseһ��Ҫ�У���Ȼֻ��һ��Ԫ��ʱ���ӡ����
			for(int i=tr;i<=dr;i++){
				System.out.print(s[i][tc]+" ");
				list.add(s[i][tc]);
			}
		}else{//һ�����
			int tempr=tr; //��ӡʱָ�룬Ҫ���ʹ�þ����С�������꣬���Բ�����ԭ������仯
			int tempc=tc;
			while(tempc<dc){//����=���������Ͻǵ��������е�ʱ���ӡ���������ﵱ���д�ӡ
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
//21 ����min������ջ  ���ַ�ʽ��һ���Ƿѿռ�ά��һ��һ����С��ջ��ÿ����Сֵ�� 
//һ����һ��ջֻ�治�ظ�����Сֵ    �������P3�������صķ�����ֻ��һ��Stack�����Զ�������ݽṹ��һ��
//��ֵ��һ����min��Ȼ�������ṹ�塣����ÿ�δ�ʱ�ж��Ƿ���Ҫ��min
/*
public class Sword{//һ��stack
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
class MyStack{//����stack
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
		if(data.isEmpty()){//����ֱ��return -1��
			throw new RuntimeException("��Ϊ�գ����ܵ���"); 
		}
		min.pop();
		return data.pop();
	}
	public int getmin(){
		if(min.isEmpty()){
			throw new RuntimeException("û��ֵ����Ϊ��");
		}
		return min.peek();
	}
}
*/
//22 ջ��ѹ�� ��������
/*
public class Sword{
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		int[] B = {1,2,3,4,5};
		System.out.println(IsPopOrder(A,B));
//		int i=0;
//		while(i<5){ //if(i<5) ��whileһ��
//			while(i<10){ //ע��whileǶ�ף���������ģ������Ƿ���������ѭ��
//				System.out.println(i++); //���ӡ��9
//			}
//			System.out.println("zhixing");//ֻ��ӡһ��
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
		return s.isEmpty(); //�����������̾��ǳ�ջ���̣�������Ƕ�Ӧ���У���ôһ��û���꣬���Բ��ǿա�
	}
}
*/
//23 �������� �������Ҵ�ӡ������ ˳���ӡ������ ���/�����������������/ͼ��˼���ö��С�
//�����ӡ������  ZigZag�����ӡ  �������P131  Breadth First Search  BFS
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
//24 �����������ĺ����������
/*
public class Sword{
	public static void main(String[] args) {
		int[] a={5,7,6,9,11,10,8};
		int[] b=new int[]{};
		System.out.println(order(a));
	}
	static public boolean order(int[] s){
		int length=s.length;
		if(length==0) //����Ҫ��s==null�жϣ���������
			return false;
		int root=s[length-1];
		int i=0;
		for(;i<length-1;i++){
			if(s[i]>root)
				break; //ɨ�赽������
		}
		int j=i;
		for(;j<length-1;j++){
			if(s[j]<root) //�������������С�ڽڵ�Ŀ϶�����
				return false;
		}
		boolean left=true;;
		if(i>0){//�����������ж����  //Ҳ������Ƴɴ��������±귶Χ���������ø���
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
//25 �������к�Ϊĳһֵ��·��  ���ݷ�
/*
public class Sword{  //ʹ��stack �ݹ�˼·��Ϊ�˴�ӡ�����ڵ㣬��Ҫ������������list����
	ArrayList<ArrayList<Integer>> listlist=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list=new ArrayList<Integer>();
public ArrayList<ArrayList<Integer>> path(Node root,int sum){
	if(root==null)
			return listlist;
	list.add(root.val);
	sum=sum-root.val; //listlist����ֱ��add(list),������������ã��������ñ��ˣ�ǰ�����еĶ���ָ�����һ������
	if(sum==0 && root.left==null && root.right==null ){
		listlist.add(new ArrayList<Integer>(list));//ֻҪ��ӡ�Ļ�����������ѭ����ӡ����
	}//���浽Ҷ�����õ���sum���¼����������������ҽڵ㣬�����ڵ�root�������󣬾͵ûص���һ���ڵ�
	if(root.left!=null){
			path(root.left,sum);
		}
		if(root.right!=null){
			path(root.right,sum);
		}//�����ʾ�����root�Ѿ��������ˣ������򷵻ظ��ڵ㡣
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
//26 ��������ĸ���  1:����ÿ���ڵ���뵽ԭ���ĵ�ǰ�ڵ���� 2.���ƵĽڵ����ָ�����ǰһ��ԭ�ڵ�����ָ�����һ����  3����ż�ֿ�������
public class Sword{
	public RandomListNode fuzhi(RandomListNode pHead){
		if(pHead==null)
			return null;
		RandomListNode index= pHead;
		while(index!=null){
			RandomListNode fz=new RandomListNode(index.val);//����Nԭ�ڵ�N'
			fz.next=index.next; //N'ָ��N.next
			index.next=fz; //Nָ��N'
			index=fz.next;//index������һ��ԭ�ڵ㣬����ѭ������
		}
		index=pHead;//index�ص���ͷ����ʼ��������ڵ�
		while(index!=null){
			if(index.random!=null){//���ָ�������ָ���
				index.next.random=index.random.next;}
			else
				index.next.random=null;
			index=index.next.next;
		}
		index=pHead; //��ʼ���
		RandomListNode indexfz=pHead.next;
		RandomListNode headfz=pHead.next; //����ͷ���λ��
		while(indexfz.next!=null){//�������һ��û������Ϊ��̫���жϣ�����ֱ����ѭ���������ָ��null����
			index.next=index.next.next;
			indexfz.next=indexfz.next.next;
			index=index.next;
			indexfz=indexfz.next;
		}
		index.next=null; //�������һ��
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
//27 ������������˫������  �����P74  ÿ�εݹ鵥Ԫ�������һ��last��rightָ���һ��head����������ȡ��ͷβ�ڵ�
public class Sword{
	public Node link(Node root){
		if(root==null || (root.left==null && root.right==null)){
			return root;
		}
		Node last=linkdg(root);
		Node head=last.right;// ���һ�β��õݹ��ʱ��������rightָ��null,�����ٵݹ����ã����Ե����ó���
		last.right=null;     //�����һ���⣬�м�Ĳ����õݹ�
		return head;
	}
	public Node linkdg(Node head){
		if(head==null)
			return head;
//		if(head.left==null && head.right==null){//ֻ��һ��Node
//			head.right=head;      //������������������ˣ����Բ��õ���д��
//			return head;
//		}
		Node lastL=null;
		Node headL=head;//������Ϊ�գ���ô��ߵ�ͷ��Ӧ����Ŀǰ�Ľڵ�head
		if(head.left!=null){
			lastL=linkdg(head.left);
			headL=lastL.right;//����ߣ��͸��£�û�о��������ʼ��ʱ��head
			lastL.right=head;
			head.left=lastL;
		}
		Node lastR=head;//����ұ�Ϊ�գ��ұߵ����һ�����ǵ�ǰ�ڵ�head
		Node headR=null;
		if(head.right!=null){
			lastR=linkdg(head.right);//���ұߣ�����£�û�о��������ʼ����head
			headR=lastR.right;
			head.right=headR;
			headR.left=head;
		}                //����ǰ������û�л�����û�У���Ҫ�����е�β�ڵ��rightָ��ͷ���
		lastR.right=headL;  //�����ң������ұ�lastָ�����head��û�о��ǳ�ʼֵheadָ��head
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
//28 �ַ�����ȫ����   �̶���һ����ÿ���ַ������Ե���һ�������Խ������棬��N�ʺ�һ����˼·����һ��ÿ��λ�ö����ԣ�
//Ȼ��ֱ𿴶�Ӧ�������ж��ٿ��ܣ��������ȫ���У�Ȼ��ݹ������ַ�
public class Sword{
	ArrayList<String> list=new ArrayList<String>();   //������List������Collections.sortҲ��
	TreeSet<String> ts=new TreeSet<String>();//��վҪ�������������������treeSet�棬Ȼ���ڴ���List
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
			ts.add(String.valueOf(c));//���ܴ��ַ����飬���û�䣬���ƶ�����·��Ҫnewһ��
		}else{
			for(int i=begin;i<len;i++){//��һ���ַ����������Ϊ��һ����һ�����ܣ�����Ҫ��begin��ʼ
				if(i!=begin && c[i]==c[begin])
					continue;//�͵�һ����ͬ���ַ����Ͳ��ý�����
				swap(c,begin,i);
				permutation(c,begin+1);
				swap(c,begin,i);
			}
		}
	}
	public void swap(char[] c,int i,int j){
		if(i!=j){//��������ʡ�˽���һ���ַ��͵�һ���ַ�������
			char temp=c[i];
			c[i]=c[j];
			c[j]=temp;
		}
	}
}
*/
/*
//29 �����г��ִ�������һ�������   ����N/K���������� �����P345
//���ַ�������ʱ��O(n)�ģ�һ���������ڿ�������ģ��ҵ��м��±�϶����Ǹ������������һ�룬������ߵݹ飬��֮�ұ�
//�ڶ��ַ����ñ�����ÿ������ͬ�ʹ���+1����ͬ��-1������>1���Ǹ������ǣ�Ȼ���ٱ���ȷ��һ�ߡ�˼·����һ��ɾ��K��������K-1����ѡ��
import java.util.Map.Entry;//Ҫ��Entry<key,value> : hashmap.entrySet();���÷�����Ҫ�������
public class Sword{ //�ڶ��ֺ�һ�㣬���Լǵڶ���
	public int half(int[] s){
		int len=s.length;
		if(s==null || len==0){
			return 0;  //û�оͷ���0
		}
		int num=0;
		int now=0;
		for(int i=0;i<len;i++){
			if(num==0){//����ȷ����ѡ����
				now=s[i];
				num=1;
			}else{
				if(s[i]==now){
					num++;//��ͬ��+1
				}else{
					num--;//��ͬ-1
				}
			}
		}
		if(num<1){//˵���϶�û�г���һ���
			return 0;
		}else{//������������ʱ��û�г���һ���Ҳ������1�������ٱ�������ȷ�ϣ�ע��O(2N)=O(N)
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
	}                                       //Ҫ��K������2,��ҪС��N
	public void khalf(int[] s,int k){//����N/K���������֣����ܲ�ֹһ��.��ӡ���У�������list����
		int len=s.length;
		if(s==null || len==0 || k<2){
			return;
		}
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(int i=0;i<len;i++){
			if(!hm.containsKey(s[i])){//����K-1����ѡ������Ϊ��ѡ
				if(hm.size()<k-1){
					hm.put(s[i], 1);
				}else{  //����ÿ����ѡ-1�Σ�ע��ֻ��1�εĺ�ѡ��Ҫ���޳�
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
			}else{//����ͬ�����Ӧ+1
				hm.put(s[i], hm.get(s[i])+1);
			}
		}
		if(hm.isEmpty()){
			return;//û�п��ܵ���
		}else{//���ж��Ƿ���Щ����ĳ�����N/K
			HashMap<Integer,Integer> hmC=tongji(hm,s);//ͳ����ʵ���ִ���
			for(Entry<Integer, Integer> et : hmC.entrySet()){//�о�������iterator����
				int key=et.getKey();
				if(hmC.get(key)> len/k ){//û�оͲ���ӡ�����Ҫ����һ����־�������ڴ�ӡǰ��һ��flag�����Ƿ��ӡ��
					System.out.print(key+" ");
				}
			}
		}
	}
	public HashMap<Integer,Integer> tongji(HashMap<Integer,Integer> ori,int[] s){
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(int i=0;i<s.length;i++){
			if(ori.containsKey(s[i])){
				if(hm.containsKey(s[i])){//����ͬ��+1
					hm.put(s[i], hm.get(s[i])+1);
				}else{//��һ��ͳ�ƣ�����Ϊ1
					hm.put(s[i], 1);
				}
			}
		}
		return hm;
	}
}
*/
/*
//30  ��������С��K����  �����P337
//һ�ַ������ڿ�������O(n)��һ�ֻ�������O(nlogK)��������TreeSet����TreeMapʵ�֣�����������������
public class Sword{  //����TreeSet/Map�������ظ����ݣ��������ظ���ʱ�����Լ�ʵ�����Ѻ͵�����
	public static void main(String[] args) {
		int[] a=new int[]{1,9,3,4,5,6,7,8};
		System.out.println(kmin(a,3));
	}
	static public ArrayList<Integer> kmin(int[] s,int k){//TreeSetʵ�֣����ı����飬�ʺϴ����ݣ��������ظ�
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
				int biggest=ts.last();//pollLast()��ͬʱɾ�����
				if(s[i]<biggest){
					ts.pollLast(); //����remove(ts.last())
					ts.add(s[i]);
				}
			}
		}
		list.addAll(ts);
		return list;
	}
	//���ڿ�������ʵ��   ��ı����飬O��N��
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
	    while(front <= rear){ //һ��Ҫ�е��ںţ������м�ֵ����rearҲ��front,û�Ⱥžͻᶪ������м�ֵ
	        mid  = quick(m, front, rear);
	       int temp = rear - mid + 1;                // mid���ң�����mid����temp����
	   //    int temp = mid-front+1;  //��С��N��������Ҫ����ҲҪ���Ÿ�
	        if (temp == N)                    // �չ�
	            break;
	        else if (temp > N) {               // ���ұ���N����
	            front = mid + 1; //mid + 1
	        }
	        else                        // �������N-temp����
	        {
	            rear = mid - 1;//mid - 1
	            N -= temp;
	        }
	    }
	    return mid;
	}
public static int quick(int[] a, int low, int high){//��������
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
	//�����Լ�д������ʵ��   �������ظ� O(NlogK)
}
*/
//31 �������������������� P368  ��̬�滮˼�룬�������Լ�offer����һ��˼�룬������ʵ����
//��f(j)����j��β�������������ͣ�״̬����Ϊf(j) = max(s[j], f[j-1]+s[j])
/*
public class Sword{
	public int maxSum(int[] s){
		int len=s.length;
		if(s==null || len==0){
			return 0;
		}
		int sum=0;
		int max=s[0];//��ʼ��ΪInteger.MIN_VALUE����
		for(int i=0;i<len;i++){
			sum+=s[i];//����f(j-1)+s[i]
			max=Math.max(max, sum);//Ҫ�ȸ���max,����ȫ�Ǹ�����ʱ�򣬹���ż����һ��sum,max��ͣ�ڵ�һ��ֵ
			sum=sum<0? 0:sum;//����״̬����
		}
		return max;
	}
}
*/
/*
//32 ��1��n������1���ֵĴ���   K���ֵĴ�����http://www.cnblogs.com/nailperry/p/4752987.html
//�����ж��֣���ֱoffer������ƵĶ��Ƚϸ��ӣ�leetcode�м򵥵ģ���������Ҳ��������дleetcode����
//��Ҫ˼·���趨�����㣨��1��10��100�ȵȣ���Ϊλ�õ�i����Ӧn�ĸ�λ��ʮλ����λ�ȵȣ����ֱ��ÿ����λ���ж��ٰ���1�ĵ���з���
//�����趨������λ�ã���n���зָ��Ϊ�����֣���λn/i����λn%i
//��i��ʾ��λ���Ұ�λ��Ӧ����>=2,��n=31456,i=100����a=314,b=56����ʱ��λΪ1�Ĵ�����a/10+1=32�������λ0~31��
//ÿһ�ζ�����100�������ĵ㣬������(a/10+1)*100����İ�λΪ1
//��i��ʾ��λ���Ұ�λ��Ӧ����Ϊ1����n=31156,i=100����a=311,b=56����ʱ��λ��Ӧ�ľ���1��
//����a/10(�����λ0-30)���ǰ���100�������㣬�������λΪ31����a=311��������ֻ��Ӧ�ֲ���00~56����b+1�Σ�
//���е���������У�a/10*100��+(b+1)����Щ���λ��ӦΪ1
//��i��ʾ��λ���Ұ�λ��Ӧ����Ϊ0,��n=31056,i=100����a=310,b=56����ʱ��λΪ1�Ĵ�����a/10=31�������λ0~30��
//�ۺ������������������λ��Ӧ0��>=2ʱ����(a+8)/10�ΰ�������100���㣬���е���λΪ1(a%10==1)����Ҫ���Ӿֲ���b+1
//֮���Բ�8������Ϊ����λΪ0����a/10==(a+8)/10������λ>=2����8�������λλ��Ч����ͬ��(a/10+1)
public class Sword{
	public int num1(int n){
		int num=0;
		for(int i=1;i<=n;i*=10){
			int gao=n/i;
			int di=n%i;
			if(gao%10==1){
				num+=(gao+8)/10*i + di+1;//���ﲻ��8Ҳ��
			}else{
				num+=(gao+8)/10*i;//���߲��0��>=2���֣��ֱ����Ҳ�У�û��Ҫ����̫����
			}
		}
		return num;
	}
	public int mynum1(int n){//�ֿ���3����������׼�Ҳ�Ե���ʵ
		int num=0;
		for(int i=1;i<=n;i*=10){
			int gao=n/i;
			int di=n%i;
			if(gao%10==1){
				num+=gao/10*i + di+1;//���ﲻ��8Ҳ��
			}else if(gao%10==0){
				num+=gao/10*i;
			}else{//>=2�����
				num+=((gao/10)+1)*i;
			}
		}
		return num;
	}
}
*/
/*
//33 ���������ų���С����   ˼·��дһ�ֱȽϷ�����ʹ�����ְ���˳�����򣬼��ɵõ���С����
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
//34 ����   //��ָoffer�������Ա���Ķ��з�ʽhttp://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b
public class Sword{
	public int ugly(int k){//���˼·��offer��ֻ࣬�Ǹ���abcʱ������һ���������ڶ��е�˼��
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
			if(tmin==t2)//�������һ�Ρ�2�����Ŀǰ����list��������ô��һ�ο϶�����������������2 �ſ��ܼ���
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
//35 ��һ��֮����һ�ε��ַ�  //1.��HashMapͳ�ƴ���  2.��һ����С26���飬���ÿ����Ӧ����   ��ʵ����ʵ�ּ򵥵�HashMap��Ч�ʸ�һ��
public class Sword{
	public int single(String s){//�����±�
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
	public int single2(String str){//��һ�������Ŵ���,ģ��hashmap
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
//36 �����е������  //���ƹ鲢�����˼·  ���η�  ��ͳ��С�����ж��ٸ����ٽ���������Ȼ��ͳ���������໥֮���ж��ٸ�
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
			}else{//������a[begin]��������ĵ�ǰԪ��a[right]�����������begin�����ÿ���������ұ�s[right]��
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
//37 ��������ĵ�һ�������ڵ�    //�ȱ����ֱ�õ��������ȣ�Ȼ���ٳ����Ǹ��������߶���ĳ��ȣ�Ȼ������һ�������ֱ��������ȷ��ش˿�ֵ
public class Sword{     //�й����ڵ㣬һ�����Ķ��ǣ��������һ���϶�����ͬ��
	public ListNode first(ListNode root1,ListNode root2){
		if(root1==null || root2==null)
			return null;
		int len1=1;//��ֵ����ν��ֻҪ�Ƚ϶��߲����
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
		if(n1!=n2){//���һ���ڵ㲻һ���Ļ����϶�û�й����ڵ�
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
//38 ���������������г��ֵĴ���   ˼·�����ֲ��ң��ֱ��ҵ���һ��K�����һ��K��λ��O(logN)  ��������ҵ�һ����Ȼ�����߱�����O(N)
public class Sword{   //�����C++��STL����low bound �� upper bound ֱ���ҵ���һ�����һ��λ��
	public int getnum(int[] s,int k){
		int len=s.length;
		if(s==null || len==0){
			return 0;
		}
		int begin=bsbegin(s,k,0,len-1);
		int end=bsend(s,k,0,len-1);
		if(begin!=-1 && end!=-1)//Ҫôͬʱ�ҵ���Ҫô��û�ҵ�
			return end-begin+1;
		else
			return 0;
	}
	public int bsbegin(int[] s,int k,int left,int right){
		if(left>right)
			return -1;//û�ҵ�
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
			return -1;//û�ҵ�
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
//39-1 �����������  ˼·���ݹ���߶�̬�滮��root����ȣ�������ڵ����+1�����ҽڵ����+1 ���ߵ�Max
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
//39-2 �ж��Ƿ���ƽ�������   �����P144  ��������ķ�ʽ �ȷ����������Ƿ�ΪAVL�Լ�����ȣ��ٷ�����������Ȼ��Ƚ�����жϵ�ǰ
class Avl{  //ÿ���ڵ�������һ�Σ�ʱ��O(N)  
	public boolean isAvl(Node root){
		if(root==null)
			return true;
		if(height(root)==-1)   //���ｫ����AVL��������ȶ�����-1����ô��⵽-1��return
			return false;
		return true;
	}
	public int height(Node root){
		if(root==null)
			return 0;
		int lefth=height(root.left);
		if(lefth==-1)//����������Avl����ôֱ�ӷ��ص�ǰrootҲ����Avl
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
//40 ������ֻ����һ�ε�����   һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
//������ͬ���������Ϊ0��1��ʹ��������㣬�õ�������ֻ����һ�ε��������Ľ����2.���ݽ����һ��1λ���������������»��ֳ�������
//��ô��ͬ�����������϶��ڲ�ͬ�����У�Ȼ��ֱ�ÿ�������õ��Ǹ���
public class Sword{ //Ҫ��ʱ��O(N)���ռ�O(1)
	public void find(int[] s,int[] num1,int[] num2){
		int len=s.length;
		if(s==null || len<2){
			return;
		}
		int all=s[0];
		for(int i=1;i<len;i++){
			all=all^s[i];
		}
		String sall=Integer.toBinaryString(all); //�Ӻ���ǰ����index
		int index=sall.length();//��Ϊ���ص�String����32λ�ģ�ֻ�ӵ�һ��1λ��ʼ�����г��ȿ��Ե���index
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
	public boolean isone(int a,int index){//a>>index;return(a&1);��������
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
//41-1 ��ΪS���������� ,���������С��ж�����ʱ������˻���С�ġ����˻���С���ǲ�ֵ���ģ���Ϊ�����ʱab��ͬa*b���
public class Sword{         //����˵���������м�ƽ��ҵ��ĵ�һ����ǲ�ֵ����
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
		int right=len-1;//������ѭ��ǰ��һ���ж�sum�Ƿ��ǰ��������С���߱�����������ʹ�����ֱ�ӷ��ؿա�
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
//41-2 ��ΪS��������������  ����˼·��1��offer�ϵģ����������ƣ�begin��ʼ��Ϊ1��end��ʼ��Ϊ2
//�����begin��end�ĺʹ���s�����Ǿʹ�������ȥ����С��ֵ(������begin)����֮����end,һֱ��begin��(1+s)/2.
//�ڶ���2��(a1+an)*n/2=s  n=an-a1+1  ����(an+a1)*(an-a1+1)=2*s=k*L(k>L) �������an=(k+L-1)/2  a1=(k-L+1)/2
class S{
static	public ArrayList<ArrayList<Integer>> find2(int sum){
		ArrayList<ArrayList<Integer>> listlist=new ArrayList<>();
		if(sum<3)
			return listlist;
		int slast=(int)Math.sqrt(sum<<1);
		for(int small=slast;small>=2;small--){//С�������𽥱�С��2��small��������
			int yes=(sum<<1)%small;
			if( yes==0){//�ֽܷ�ʱ�Ž�һ����֤                                                                                                 //ż��������&1==0�ж�
				int big=(sum<<1)/small;//������λ������٣���˼������õ�an �� a1������������an��(k+L-1)����2�õ�����ô�����о͵���ż��
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
//42 ����ת�ַ���&��ת����˳��  ���������ƣ�������ʹ�ö�η�תһ���ַ���������ʵ�֡���ȻҲ������Stack�洢�������Ҳ�С�����ռ�Ҫ��O(1)ֻ��ǰ��
public class Sword{//Java��String��û�����壬���Ըĳ�char[]��������˼�����.��ʹC++Ҳ����char[]�ȽϷ���
	public String word(String s,int k){//StringBuffer ��reverse()���������ﻹ���Լ�ʵ��
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
		char temp;//�������ͣ����Է���������һ�����������ͣ���û��Ƿ�������ÿ��new�Ƚϰ�ȫ����ֹ�������һ��
		while(begin<end){
			temp=c[begin];
			c[begin]=c[end-1];
			c[end-1]=temp;
			begin++;
			end--;
		}
	}  
//��ת�������ӵ�3�ַ���                 	//Ҫ��O(1)�ռ䣬���Բ�����Щ�ֳɵĺ�����ֻ���÷�1����Ҫ��3�ݹ�ȽϺã���2�ȽϺ��볣��
	public String sentence1(String s){//String��split����������ָ���ַ��ָ���ַ������飬String[] a = str.split(" ");
		int len=s.length();
		if(s==null || len==0)
			return "";
		char[] c=s.toCharArray();
		reverse(c,0,len);//�����巭ת
		int begin,end=0;
		int i=0;
		while(i<len){
			while(i<len && c[i]==' '){
				i++;//�ҵ���Ϊ�� ���ĵ��ʿ�ͷ
			}
			begin=i;
			end=i;
			while(i<len && c[i]!=' '){
				end++;
				i++;
			}
			reverse(c,begin,end);//�ֲ����ʷ�ת
		}
		return String.valueOf(c);
	}
	public String sentence2(String str){//O(N)�ռ�ʱ�����Է����
		 StringBuffer sb = new StringBuffer("");
	        if(str.length() <= 0 || str.trim().equals("")){
	            return str;//Ҫtrim()�������������ո���ɵ��ַ���
	        }
	        String[] strSet = str.split(" ");
	        int length = strSet.length;
	        for(int i = length-1; i > 0 ;i--){
	            sb.append(strSet[i]+" ");
	        }
	        sb.append(strSet[0]);
	        return sb.toString();
	}
	public String sentence3(String str) {//�ݹ鷽ʽ
		int index=str.lastIndexOf(" ");
		if(index==-1){//û�пո�ֻ��һ�����ʣ�ֱ�ӷ���
			return str;
		}else{ //�пո񣬷������һ������+ǰ��ݹ�Ľ����
			return str.substring(index+1)+" "+sentence3(str.substring(0,index));
		}
}
}
*/
/*
//43 n�����ӵĵ�����   ˼·���ݹ����ѭ������쳲�����˼·���ƣ���ѭ�����ټ�����������ʵ����DP��
//F(n,s) = F(n-1,s-6)*1+F(n-1,s-5)*1+F(n-1,s-4)*1+F(n-1,s-3)*1+F(n-1,s-2)*1+F(n-1,s-1)*1;
//��1�����ӣ�f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1�����еĺͳ��ִ����ܺ�Ϊ6^n��
//����һ�����ӣ�ÿ�����������ǵȸ��ʵģ���������ÿ��������ǡ�1                  //��Ȼ�����Ż�Ϊ5n����û��Ҫ���������븴��
//��������һ��2άDP�����ǵ�n������ֻ��n-1���йأ���DP������ÿһ��ֻ����һ���йأ�(������������һ�ж���)����ֻҪһ������6n��һά�������
//http://blog.csdn.net/tbwood/article/details/22747215  ��ʱ������һά���飬�Լ������2��һά������һά���е������
public class Sword{
	public static void main(String[] args) {
		int n=5;//���Ӹ���
		int k=6;//�����ж��ٵ���������Ķ����������
		probability(n,k);
		solve(n);
	}
	static public void probability(int n,int k){//�Լ��ķ�����ֻҪһ�����飬���ö���һ������
		if(n<=0 || k<=0)
			return;
		int[] num=new int[k*n+1];//+1��Ϊ����ֱ�����±��ʾ��S�������0��ʼ��
		for(int i=1;i<=k;i++){
			num[i]=1;
		}
		for(int i=2;i<=n;i++){//һ��ѭ�����У�����������
			for(int j=i*k;j>=i;j--){//����ѭ�����Ӻ���ǰ����Ϊ���µ�ǰλ�ú�ǰ���йأ������ǰ���󣬻�ı�ǰ���ֵ
				//num[j]=num[j-1]+num[j-2]+num[j-3]+num[j-4]+num[j-5]+num[j-6];
				int temp=0;
				for(int m=1;m<=k;m++){//��һ��ѭ����ʾ������͹��̣�����DP��ͨ��
					if(j-m>=i-1){//����һ�����С��K�����������ע������6�����ӣ���ôǰһ�����ӵ�5,����������>=i-1
						temp+=num[j-m]; //���ﲻ��ֱ����num[j]���ۼӣ���Ϊ���֮ǰ��f(n-1,s)Ҳ����
					}
				}
				num[j]=temp;
			}
		}
		for(int i=n;i<=k*n;i++){//��ӡ����
			double pro=num[i]/Math.pow(k, n);
			System.out.println(i+"����"+num[i]+"�Σ������= "+pro);
		}
	}
	public static void solve(int n)//���ڴ�ǰ������µķ�����������Ҫ����һ���������һ�ν��
	{	
		if(n==0) return;
		int[] result = new int[6*n+1];//Ϊ�˷��㣬�ͽ��±���Ϊ��
		
		for(int i=1;i<=6;i++)
		{
			result[i] = 1;
		}
		for(int i=2;i<=n;i++)
		{	
			int[] result_temp = new int[6*n+1];//Ϊ�˷��㣬�ͽ��±���Ϊ��
			//��i��6*i
			for(int j=i;j<=6*i;j++)
			{	
				for(int k=j-1;k>=j-6;k--)
				{
					if(k>=1) result_temp[j]+=result[k];
				}
			}
			result = result_temp;//�����������齻�棬����ʹ�õ�N��ʱ��ǰN-1=0�����Բ��õ�����һ�ַ�����ע���
		}
		for(int i=n;i<=6*n;i++)
		{
			System.out.println(i+":"+result[i]+" ");
		}
	}
}
*/
/*
//44 �˿��Ƶ�˳��  ������0����������  ��ȡ5����
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
//45 ԲȦ�����ʣ�µ����� ���־� Լɪ��  ��test1�ҵ�Yuesefu����
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
//46 ����ѭ���жϵ���1+2+����+n��  ˼·�ö�·˼��
public class Sword{
	public int sumN(int n){
		if(n<=0)
			return 0;
		int sum=0;
		boolean y = (n>=1) && (sum=n+sumN(n-1))>0;//ע�����>0�����жϣ����Ҳ�У�ֻҪ���õݹ������Ҳ�Ӱ��������
		return sum;
	}
}
*/
//48 ���ܱ��̳е��࣬����Java��������ֱ����final��������С�����
/*
//47 ���üӼ��˳����ӷ�  ˼· a��b����������ͣ�a��b��֮������һλ����λ��Ȼ��ǰ����a��������b����ͬ�������㣬֪�����߼���λ=0
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
//49 ���ַ���ת����������  ��Ҫ�����������������λ���Ƿ�0-9��abc�ȣ��Լ�intֵ���������
public class Sword{
	public boolean isValid=true;//��һ��ȫ�ֱ���˵������ֵ0���������Ϊ0���������ڷǷ����뵼�µġ�
	public int strToint(String s){
		int len=s.length();
		if(s==null || len==0 || (len==1 && (s.charAt(0)=='+' || s.charAt(0)=='-'))){
     isValid=false;  //�գ�ֻ��һ������λ����ֱ�ӷ���
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
		long sum=0;//����long���ֽ�����ж��Ƿ�����������ȽϷ���
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
//50 ���������ڵ����͹������� 3��������ף�1.��AVL��ʱ���ж���rootֵ��С���жϣ�ֱ��һ��һС���ǹ����ġ�
//2.�������ͨ��������������ָ�򸸽ڵ��ָ�룬��ô����ת���������������һ�������ڵ�����⣬�������2���ڵ㿪ʼ�����ң�����Ŀ37
//3.û��ָ�򸸽ڵ�ָ�����ͨ�����������Ƕ���������root��ʼ�ҵ������ڵ㣬��¼��2��·����Ȼ���ҵ����һ����ͬ�ڵ����
public class Sword{
	//1��AVL�� ����û���ظ�ֵ      ��ȻҲ�����õݹ飬����ѭ����һ��
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
		return have;//�������Է���null���ڵ㲻�����root����ʱ
	}
	//2������AVL��������ָ�򸸽ڵ��ָ��.��������һ���֣�Ȼ������һ���ߣ�һֱ����һ����ͬ�ڵ�
	public Node pointer(Node root,Node t1,Node t2){
		if(root==null || t1==null || t2==null){
			return null;
		}
		int len1=1;
		int len2=1; //���߳�ʼΪ0
		Node tt1=t1;
		Node tt2=t2;
		while(tt1.father!=null){//��ʼΪ0����ô�������tt1!=null����������Ϊ������ñȽ϶����Ƿ���ͬһ��root
			len1++;
			tt1=tt1.father;
		}
		while(tt2!=null){
			len2++;
			tt2=tt2.father;
		}
		if(tt1!=tt2){
			return null;//������ڵ�������ͬ��˵�����������ڵ�϶�����һ�����ϵģ���Щ�����Լ��ӵĹ���
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
		return null;//�������û�з��أ�˵���϶�û�й����ڵ㣬����ֱ�ӷ���null
	}
//3: û��ָ���ϼ�ָ�룬ֻ����ͨ����.��Ѱ�ҳ�����㵽����Ŀ�Ľڵ��·�������ٴӸ���㿪ʼ��������������һ�������ڵ������͹����ڵ�
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
		return list;//����return nullӦ��Ҳ��һ����
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
//51 �������ظ�������  ����Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ��ҳ�����һ���ظ������֡�O(n)ʱ��O(1)�ռ�
//˼· ��������Ӧ���±��Ӧ��ֵ��������㡣s[n]=n,����һ����ɨ��s[N]=M �����s[M],�������M�������ظ������Ⱦͽ�������������
public class Sword{//��վ�ύ��ʽ�������dup[0],û�з���false
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
//52 �����˻�����   ����ʹ�ó���  ����һ������A,��������B,B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
//˼· �����ڶ�̬�滮������������ÿ�����³ˣ����м���һ��һ��������
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

//53 ������ʽ     ������ʽƥ�䡣�ݹ�
/*leetcode ��hard�⣬�кܶ�̴��룬�����������DP������
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
//��̴���C++��
bool isMatch(const char *s, const char *p) {
        if (!*p)
            return !*s;
        if (p[1] == '*')
            return isMatch(s, p+2) || (*p == '.' && *s || *s == *p) && isMatch(s+1, p);
        if (*p == '.')
            return *s && isMatch(s+1, p+1);
        return *s == *p && isMatch(s+1, p+1);
    }
˼·��ֻ�е�ģʽ�����ַ���ͬʱ����\0���ſ�����Ϊ������ƥ�䡣
��ƥ���У�����ÿ��λ��ƥ����Է�Ϊ�������
1������Ӧλƥ��||ģʽ��Ϊ.&&�ַ�������\0��&&ģʽ����һλ��*
2������Ӧλƥ��||ģʽ��Ϊ.&&�ַ�������\0��&&ģʽ����һλ����*
3����Ӧλ��ƥ��&&��ģʽλ��Ϊ.||�ַ�����\0��
��Ӧ1����ӡ���Ϊ*ȡ0��*ȡ1��*>=2���������
*ȡ0��Ӧ������ǰƥ��λ������Ѱ��patter����һ��ƥ��λ��str���䣬pattern+2
*ȡ1��Ӧ��ǰƥ��λ��һ�γɹ�ƥ�䣬str+1��pattern+2
*ȡ>=2��Ӧһ�γɹ�ƥ�䣬����ƥ���ַ�������һλ�Ƿ�ƥ�䣬str+1��pattern����
����ȡ�򡣼�ֻҪ��һ�������ƥ��ɹ���Ϊ�ַ�������ƥ��ɹ��ġ�
��Ӧ2���൱��һ�γɹ�ƥ�䣬str+1��pattern+1
��Ӧ3��ƥ��ʧ�ܣ�ֱ�ӷ���false
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
		 if(start2>=lenp) return false;//ֻ��pattern�����˲��ܽ����������̣��ַ�����Ҫ������pattern��������ƥ��
		 if(start2<lenp-1){
			 if(p[start2+1]=='*'){//��Ӧ1
				 if((start1<lens)&&(s[start1]==p[start2]||p[start2]=='.')){
					 return isMatch(s,start1,p,start2+2)||isMatch(s,start1+1,p,start2+2)||isMatch(s,start1+1,p,start2);
				 }else return isMatch(s,start1,p,start2+2);//���ȵĻ���ֻ����*��0��
			 }
		 }
		 if(start1==lens) return false;
		 if(s[start1]==p[start2]||p[start2]=='.')//��Ӧ2
			 return isMatch(s,start1+1,p,start2+1);
		 return false; //��Ӧ3       
	 }
}
*/
/*
//54 ��ʾ��ֵ���ַ���  ˼·����һ��ָ��i���������ݿ��ܳ��ֵ��Ⱥ�������ж�
public class Sword {
boolean isNumeric(char[] s) {
	 int len=s.length ;
 if(len==0) return false;
 if((len==1)&&(s[0]<'0'||s[0]>'9')) return false;
 if(s[0]=='+'||s[0]=='-'){
     if(len==2&&(s[1]=='.')) return false;
 }else if((s[0]<'0'||s[0]>'9')&&s[0]!='.') return false;//��λ�Ȳ��Ƿ���Ҳ�������ֻ�����С���㣬��Ȼ��false
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
//55 �ַ����е�һ�����ظ����ַ�  hashMapʵ�֣�����д��ֻ��Ϊ����վˢ���ʽ��OJ�ķ�ʽ��������֮ǰд��HashmapZifu����
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
}//============�ڶ��֣�����ASCII�뵱�±꼴Key������ĸ���ַ����е�λ�õ�Value���ظ��ͱ�-1��������ģ��HashMap
public class Sword {
     final static int num = 256;
     int arr[] = new int[num];
     int index = 1;
     //Insert one char from stringstream
     public void Insert(char ch)
     {
         if(arr[ch] == 0)  //��һ�γ��֣������ֵ�˳��
             arr[ch] = index;
         else  //���״γ��֣����ַ���Ϊ��Ч
             arr[ch] = -1;
         index++;
     }
   //return the first appearence once char in current stringstream
     public char FirstAppearingOnce()
     {
         int min = Integer.MAX_VALUE;
         char result = '#';
         for(int i = 0; i < num; i++){//�ҳ������д���0��������С��һ�������ǵ�һ������һ�ε�
             if(arr[i] > 0 && arr[i]<min){  //arr[i]>0��ʾ�ҵ����ִ���ֻΪ1���ַ�
                 min = arr[i];//�������С��С���͸�����С��
                 result = (char)i;
             }
         }
         return result;
     }
 }

*/
/*
//56 �����л�����ڽڵ�  ˼·���ҳ����нڵ����n��Ȼ��һ������n�Σ�Ȼ��һ���ߣ��������Ǹ��������ڡ��ؼ����ҳ�n
//��������15���ж��Ƿ��Ż�������һ��p2һ��p1������ʱ�϶��ڻ��У�Ȼ��Ӵ˵�������ٴε������ʱ����������ٸ��ڵ�n
//2.������һ�㣬��p1==p2ʱ��p2�������ڵ���Ϊ2x,p1�������ڵ���Ϊx,�軷����n���ڵ�,p2��p1����һȦ��2x=n+x; n=x;
//���Կ���p1ʵ������һ�����Ĳ���������p2ָ������ͷ����p1λ�ò��䣬p1,p2ÿ����һ��ֱ��p1==p2; ��ʱp1ָ�򻷵���ڡ�
//3.���ɵ���Ҫ�Ͽ���������ָ��ͬʱ����ƶ���ÿ�ƶ�һ�Σ�ǰ���ָ���nextָ��NULL��
//Ҳ����˵�����ʹ��Ľڵ㶼�Ͽ�����󵽴���Ǹ��ڵ�һ��������ڡ�����
public class Sword{
	public Node first(Node root){
		if(root==null || root.next==null){
			return null;
		}
		Node fast=root;
		Node slow=root;//�ж������Ƿ��л��ṹ
		while(fast!=null || slow!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow){
				break;
			}
		}
		fast=root;//��һ����һ��Σ�գ���������ǵ�һ�������������while�ͽ���ȥ��
		while(fast!=slow){
			fast=fast.next;
			slow=slow.next;
		//	if(fast==slow){
		//		break;//����while���ܽ����������Բ���������return fast�����return null����Ϊ���ܲ���
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
//57 ɾ���������ظ��Ľڵ�  ����������� 1->2->3->3->4->4->5 �����Ϊ 1->2->5 ���������ļ������71��������HashSet���ж��Ƿ���ֹ�
//step1���ж�   //Leet 83������
public class Sword{
	public Node deleteDuplication(Node pHead)
{//���ϵķ����������о������Լ������������Ǹ���һ��
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
	//�����Լ�д���е㸴�ӣ��ͼ����Լ��İ�
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
				Node first=after.next;//�����һ�����ظ��Ľڵ�
				while(first!=null && first.val==after.val){
					first=first.next;
				}
				if(now==root){//˵����һ�ξͽ�������������now����ûִ�й���Ҳ���ǵ�һ�������ظ�
					if(first==null){
						return null;
					}
					root=first;//����root���൱�����¿�ʼ
					pre=first;
					now=first;
					after=now.next;
				}else{//�м���ظ�������ȥ��
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
//58 ����������һ���ڵ�   ����һ�������������е�һ����㣬�ҳ��������˳�����һ����㡣���еĽ�����ָ�򸸽���ָ�롣
public class Sword{
	public Node getNext(Node tn){
		if(tn==null)
			return null;
		if(tn.right!=null){//�����������������������������ڵ�
			Node nextN=tn.right;
			while(nextN.left!=null){
				nextN=nextN.left;
			}
			return nextN;
		}
		while(tn.father!=null){//û�����������ҵ�һ����ǰ�ڵ��Ǹ��ڵ����ӵĽڵ�
			if(tn.father.left==tn){
				return tn.father;
			}else{
				tn=tn.father;
			}
		}
		return null; //�˵��˸��ڵ���û�ҵ����򷵻�null
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
//59 �ԳƵĶ�����  ˼·1�� ǰ��������ͶԳƵ�ǰ����������Һ��󣩣�ע��Ҫ�ڿյ�λ�ú�Ҷ�ڵ����Null��Ȼ��Ƚ�2������һ������
//˼·2�� ��Ҷ�ڵ�ĩ�Ϳյ�λ�ü���null�Ļ���Ӧ�ÿ�������������õ����У���������Ƿ�Գƾ���
//˼·3�� ��õķ������õݹ顣���ȸ��ڵ��Լ���������������������������������������������ͬ����������������������������������ͬ����
public class Sword{
	public boolean sym(Node root){
		if(root==null){
			return true;
		}
		return isSym(root.left,root.right);
	}
	public boolean isSym(Node left,Node right){
		if(left==null){
			return right==null;//��գ����ұ��Ƿ��
		}
		if(right==null){//�󲻿գ��ҿգ���false
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
//60 �Ѷ�������ӡ�ɶ��� �����P133   ˼·��ǰ��BFS ��� ������ȱ����������Ļ����ϼ�һ���ж�һ�н�������
public class Sword{//ÿ����һ��List���棬ֻ��ӡ�Ļ�ֱ�Ӵ�ӡ���У����ñ���
	public ArrayList<ArrayList<Integer> > print(TreeNode root) {
	    	ArrayList<ArrayList<Integer>> listlist=new ArrayList<>();
	        if(root==null){
	            return listlist;
	        }
	        Queue<TreeNode> que=new LinkedList<TreeNode>();
	        TreeNode last=root;
	        TreeNode nlast=null;//����Ҫ��������last��ʹ��last��ʾ��ǰ������һ����nlast��ʾ��һ�����ұ�һ��
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
	            }//���õİ취�ж�һ�и���������ÿ�д�ӡque.size�Σ����ǿ϶��ġ���Leetcode107��102
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
//61 ��֮����˳���ӡ������ ZigZag  ����Java�е�LinkedList�ĵײ�ʵ����˫��������ص㡣
//1)����������,ʵ�����Ĳ�α���   2)��˫�����,������ʱ��ǰ��������ż����ʱ�Ӻ���ǰ����
//��������ͷ���������������ӽڵ�������ҷ����β��ż�������β���������������ӽڵ����Һ������ͷ��.
//�����ô���ArrayList�У�ż����ʱ����reverseʵ�֣���������ʱ��Ч��̫�͡�
public class Sword{
	public ArrayList<ArrayList<Integer>> print(TreeNode root){
		ArrayList<ArrayList<Integer>> listlist=new ArrayList<>();
		if(root==null){
			return listlist;
		}
		Deque<TreeNode> que=new LinkedList<>();//Ҳ����ֱ��ǰ����LinkedList
		ArrayList<Integer> list=new ArrayList<>();
		TreeNode last=root;
		TreeNode nlast=null;
		boolean lt2rt=true;
		que.offer(root);
		while(!que.isEmpty()){
			TreeNode temp=null;
			if(lt2rt){
				temp=que.removeFirst();//que.pollFirst()Ҳ��
				if(temp.left!=null){
					que.addLast(temp.left);
					nlast= nlast==null? temp.left : nlast; //ÿ�д�ӡ��һ��ʱ������Ӧ���ӽڵ�����һ�еĴ�ӡ��
				}                                         //���һ��������ÿ��ֻ�ڵ�һ����ӡ��ʱ�����nlast
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
				nlast=null;//ÿ���ÿգ������ڸ���ʱ�������жϵ�ǰ�Ƿ���Ҫ����
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
//62 ���л�������  �����л�������
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
		if(!ss[index].equals("#")){//ע�ⲻ����!=��Ҫ��equals
			root=new TreeNode(Integer.valueOf(ss[index]));//����Integer.parseInt
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
//63 �����������ĵ�K�����   ˼·��(�ݹ����ѭ������)��������ǵ����ģ������ҵ���С�����K������
public class Sword{
	private int cnt=0;//ע�������������¼����������ʹ��·����Ϊĳֵ��˼·��������Ҫ������ڵ��ж��ٸ�������ٵݹ��ұ�
	public Node getK(Node root,int k){//�ݹ�˼·���е㼼�ɣ����üǣ��ͼ�����ǵݹ�ġ���ʵ��һ����
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
	public Node getK2(Node root,int k){//����˼·���ǵݹ�ķ�ʽ���ȵõ����򣬵���K��ֹͣ����
		if(root==null || k<=0){
			return null;
		}
		int cnt=0;
		Stack<Node> stack=new Stack<>();
		Node temp=root;
		while(temp!=null || !stack.isEmpty()){
			if(temp!=null){
				stack.push(temp);//��ͣ���������
				temp=temp.left;
			}else{
				temp=stack.pop();//��ڵ���꣬����һ�������ҽڵ�
				if(++cnt==k){
					return temp;
				}
				temp=temp.right; //����û���ҽڵ�Ҳ��Ҫ��ͣ����ڵ㡣
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
//64 ����������λ��  ˼·��������AVLƽ�����������ʵ�֣����ǱȽ���д�������������������������һ�����ѣ�һ����С��
//��λ����������M1��M2����ʾ������ʱ���������м�����M1������������ģ�M2���ұ�������С�ġ�
//�Ѳ����Լ�ʵ�֣����������ȶ���ʵ��
public class Sword{
	private int cnt=0;
	Comparator<Integer> max=new Comparator<Integer>(){
		@Override
		public int compare(Integer a,Integer b){
			return -a.compareTo(b);//��������С�ȽϷ�һ��
		}
	};
	private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
	private PriorityQueue<Integer> maxHeap=new PriorityQueue<>(11,max);//11��ϵͳĬ��������С���Լ�������ʼ�������
//�����ѣ��ұߵ���С���е���Ҫ������ߵ������е��������԰�����ż�жϲ���ʱ����Ҫ����Ƿ�������һ����
	public void insert(Integer num){
		if((cnt&1)==0){//ż����������С��
//			if(num<maxHeap.peek()){//����ֱ�ӽ���С���ѣ����Ǿ������ɸѡ��ȡ����������Ԫ�ؽ���С���ѡ�
//				maxHeap.offer(num);//�����������ԣ���һ��ʱpeekû��ֵ�����Ի���ͳһ�������Ȳ����ȡ
//				int big=maxHeap.poll();
//				minHeap.offer(big);
//			}else{
//				minHeap.offer(num);
//			}
			maxHeap.offer(num);
			int big=maxHeap.poll();
			minHeap.offer(big);
		}else{//�����������ѡ����Բ������������жϣ�ֱ�Ӳ�����һ���ѣ�Ȼ��ȡ�Ѷ����У������õ�������һ����
			minHeap.offer(num);
			int small=minHeap.poll();
			maxHeap.offer(small);
		}
		cnt++;
	}
	public Double mid(){
//		double min=minHeap.peek();//����������ȡֵ�������������Ϊ����û������ֻ��ʵʱ�ġ����Ի�������������ȫ
//		double max=maxHeap.peek();
		if((cnt&1)==0){//ż������
			return ((double)(minHeap.peek()+maxHeap.peek()))/2;
		}else{
			return (double) minHeap.peek();//��Ϊǰ��cntΪż��ʱ������С���У���ʼֵcnt=0;�����ǵ�һ��������3��5��7���������ұߵ���С���У�������������min
		}
	}
}
*/
/*
//65 �������ڵ����ֵ  �����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}
//˼·�� ˫�˶���
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
			int begin=i-k+1;//���ڵĿ�ʼ�±�
			if(dq.isEmpty()){
				dq.offerLast(i);//ע���������±�,��ʱ��������νǰ��ֻ��һ��
			}else if(dq.peekFirst()<begin){//�������ڵ�Ԫ��ɾ��
				dq.pollFirst();//removeFirstҲһ��
			}
			while(!dq.isEmpty() && s[dq.peekLast()]<=s[i]){//����Ⱥźܹؼ�����һ��dq��ʱǰ���Ѿ�����һ�Σ����û��
				dq.pollLast();//ȥ���ȵ�ǰҪ�����С��ֵ              //û�еȺţ���ô�����ֲ�����һ�ε�һ��Ԫ�ء������õȺſ���
			}                                              //���Խ��������⣬��һ��Ԫ��֮����һ��
			dq.addLast(i);//ע���Ǵ����±�
			if(begin>=0){//begin����0��ʾ���ڴ�0��ʼ��֮ǰ���붼û��һ���������Բ������Max
				list.add(s[dq.peekFirst()]);
				System.out.println(dq.peekFirst());
			}
		}
		return list;
	}
}
*/
/*
//66 �����е�·��   ʹ�û��ݷ������Ƶݹ飩//��ν�Ļ����޷Ǿ��Ƕ�ʹ�ù����ַ����б�Ǻ�ʹ�����ȥ���
//��һ��״̬���鱣��֮ǰ���ʹ����ַ���Ȼ���ٷֱ��ϣ��£����ҵݹ�
public class Sword{
	public static void main(String[] args) {
		char[] c="ABCESFCSADEE".toCharArray();
		char[] s="ABCCED".toCharArray();
		boolean hh=path(c,3,4,s);
		System.out.println(hh);
	}
static	public boolean path(char[] matrix,int row,int col,char[] s){
		boolean[] flag=new boolean[matrix.length];//��¼�Ƿ��Ѿ��߹��˵�
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
			return false;//ע������������ж��У�ǰ��ı߽粻�ܷ��ں����жϣ������д��󣬻���i=-1�����
		}       //��Ϊ��������жϱ߽磬����ĳ��xy=-4;�������flag[xy]�ǷǷ��ģ�����Ҫ���жϱ߽�
		if(index== s.length-1)//���һ������ˣ������
			return true;
		flag[xy]=true;
		if( haspath(matrix,row,col,s,i-1,j,flag,index+1)//��
				|| haspath(matrix,row,col,s,i+1,j,flag,index+1)//��
				|| haspath(matrix,row,col,s,i,j-1,flag,index+1)//��
				|| haspath(matrix,row,col,s,i,j+1,flag,index+1)){//��
			return true;
			}
		flag[xy]=false;
		return false;
	}
}
*/
//67 �����˵��˶���Χ  ˼·ͬ��һ�⣬���ݷ�
public class Sword{
	public int movingCount(int max,int row,int col){
		if(row<=0 || col<=0 || max<0)
			return 0;
		boolean[][] flag=new boolean[row][col];//״̬����
		return move(max,row,col,0,0,flag);
	}
	public int move(int max,int row,int col,int x,int y,boolean[][]flag){
		if(x<0||x>=row || y<0||y>=col || flag[x][y]==true || (num(x)+num(y)>max)){
			return 0; //�жϱ߽��Լ���С�Ƿ񳬹�max
		}
		flag[x][y]=true;//����Ϊ�߹��õ�  //������1+����4������ע�����������Ҫ���ݣ���Ϊ����Ծ�+1����������·������
		return 1+move(max,row,col,x-1,y,flag)+move(max,row,col,x+1,y,flag)
				+move(max,row,col,x,y-1,flag)+move(max,row,col,x,y+1,flag);
	}
	public int num(int x){//����һ��������λ�ú�
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







