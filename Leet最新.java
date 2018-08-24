package com.yang;

import java.util.*;

import javax.swing.tree.TreeNode;

//7 reverse digits of an integer ��ת���� 7. Reverse Integer
//������ѵ�����int������-2147483648��Χ�ģ������������x�������Խ���ˣ�����0-x����xû��ȥ������
//���Ի�Ҫ�ж�һ���Ƿ�<0 ���������ַ�ʱ��ȥ����һ�����š����о�����double����ת������֣�Ȼ���жϣ�
//�������MAX����MIN����ֱ���쳣����0��
/*
public class Leet {

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
	//����ķ��������ϳ����Ĵ���ʽ�����������������Լ��ķ�����ܶࡣ
	static public int reverse2(int x){
		double s=0;
        int flag=1;
        if(x==0) return 0;
        if(x<0) 
        {
            flag=-1;
            x=x*(-1);
        }
        while(x>0){
            s = s * 10 + x % 10;
            x=x/10;
        }
        s=s*flag;
        return (s > Integer.MAX_VALUE || s < Integer.MIN_VALUE? 0 : (int)s);
	}
}
*/
// 139 ��̬�滮 word-break Given a string s and a dictionary of words dict, determine 
//if s can be segmented into a space-separated sequence of one or more dictionary words.
//˼·����ΪN���ַ����������i���ԣ���ôֻҪ����i��N���Ƿ������ϣ��������
/*
public class Leet{
	public static void main(String[] args) {
		Set<String> dict=new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		String s="leetcode";
		boolean a=wordBreak(s,dict);
		System.out.println(a);
	}
	public static boolean wordBreak(String s,Set<String> dict){
		int length=s.length();
		if(length<1)
			return true;
		boolean[] dp=new boolean[length+1];//Ĭ��ֵΪfalse
		dp[0]=true;
		for(int i=0;i<length;i++){ //�ַ���0��length-1
			if(dp[i]){ //dp����Ӧ����0��length-1���У����һ��dp[length],��������һ�εĽ���и�ֵ���������һ�β�����
				for(int j=i;j<length;j++){//�ַ���index
					if(dict.contains(s.substring(i,j+1))){
						dp[j+1]=true;
					}
				}  // s: 0 1 2 3 4 5  length-1   ��length��
			}     //dp:0 1 2 3 4 5 6  length   ��length+1��   dp[i]��ʾs[i-1]�ܷ�ִ� 
		}
		return dp[length];
	}
}
*/
//148 sort list  �ҵ������е㣬��merge two sorted lists ˼��ϲ����� O(1)�ռ䣬O(NlogN)ʱ��
/*
public class Leet{
	public static void main(String[] args) {
		
	}
	public ListNode sortList(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode slow=head;//һ��һ�����ҵ��м�
		ListNode fast=head;
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode head2=slow.next;
		slow.next=null; //�Ͽ����������֣�������������ж��±��֪��������һ�룬�������Ͽ�
		ListNode left=sortList(head);
		ListNode right=sortList(head2);
		return merge(left,right);
	}
	public ListNode merge(ListNode left,ListNode right){//���Եݹ��sword��Ҳ����ѭ��
	//	if(left==null) �쳣�������ʡ�ԣ���Ϊ����������������ʱ���Ѿ����������֤����Ĳ�����null
		ListNode temp=new ListNode(0);//������һ����ʼ��������
		ListNode hnew=temp;//���������һ��λ�ã���һ��index����󷵻�ͷ����Ȼ����һֱ������Ӻ��Ҳ���ͷ��
		while(left!=null && right!=null){
			if(left.val<=right.val){
				temp.next=left;
				left=left.next;
			}else{
				temp.next=right;
				right=right.next;
			}
			temp=temp.next;
		}
		if(left!=null){
			temp.next=left; //left����ֵ����rightֵ��
		}else if(right!=null){
			temp.next=right;
		}
		return hnew.next;//��һ���Ǹ����ռ�0�����Ժ�һ������ͷ
	}
}
class ListNode{
	ListNode next;
	int val;
	ListNode(int val){
		this.val=val;
		next=null;
	}
}
*/
/*
//91 decode ways  ��̬�滮������¥������  �����ж����п��ܵ�ʱ��Ӧ������̬�滮������һ��
public class Leet{
	public static void main(String[] args) {
		String s="26";  //���������0,��10 20
		System.out.println(numDecodings(s));
	}
	public static int numDecodings(String s){
		int length=s.length();
		if(length==0 || s.charAt(0)=='0')
			return 0;
		if(length==1)
			return 1;
		char[] ss=s.toCharArray();
		int f0=1,f1=1;
		int fn=0;
		for(int i=1;i<length;i++){//ע��-'0'���̣���char�Զ��ĳ�int,��Ȼchar��3�ɲ���int3
			if(ss[i]!='0'){
				if( ss[i-1]!='0' && (ss[i-1]-'0')*10+(ss[i]-'0')<=26){
					fn=f0+f1;
				}else{
					fn=f1;
				}
				f0=f1;
				f1=fn;
			}else{//�����λΪ0����ôҪ�ж�ǰһλ�Ƿ���0<x<=2֮�䡣������ǲ�����
				if( ss[i-1]!='0' && (ss[i-1]-'0')<=2){
					fn=f0;
				}else{
					return 0;
				}
				f0=f1;
				f1=fn;
			}		
		}
		return fn;
	}
}
*/
//  ������Ӵ� ����ȫ��ͬ��  ����� P216  һ���ö�ά��̬�滮����ռ���O(MN)�����Բ�ȡб�߷���ֵҪO(1)
/*
public class Leet{  //�ԣ�i,j����β��������
	public static void main(String[] args) {
		String s1="1AB3C4565CD";
		String s2="13C456EF";
		int a=zuichang(s1,s2);
		System.out.println(a);
		System.out.println(zc(s1,s2));
	}
	static public int[][] changdu(char[] s1,char[] s2){//�����άDP�ľ���
		int len1=s1.length;
		int len2=s2.length;//��ͷ�����ݴ��ǵ����������ʱ�Ѿ������������
		int[][] dp=new int[len1][len2];
		for(int i=0;i<len1;i++){
			if(s1[i]==s2[0]){
				dp[i][0]=1;
			}
		}
		for(int j=1;j<len2;j++){//j=0����������Ѿ������ˣ��������Ͻǹ���Ԫ��
			if(s1[0]==s2[j]){
				dp[0][j]=1;
			}
		}
		for(int i=1;i<len1;i++){
			for(int j=1;j<len2;j++){
				if(s1[i]==s2[j]){
					dp[i][j]=dp[i-1][j-1]+1;
				}else{//���Բ�Ҫ���=0��������Ϊ����Ĭ�Ͼ���0
					dp[i][j]=0;
				}
			}
		}
		return dp;
	}
	static public String zc(String s1,String s2){
		int len1=s1.length();
		int len2=s2.length();
		if(s1==null||s2==null || len1==0||len2==0){
			return "";
		}
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		int[][] dp=changdu(c1,c2);
		int end=0,maxLen=0;
		for(int i=0;i<len1;i++){
			for(int j=0;j<len2;j++){
				if(dp[i][j]>maxLen){
					maxLen=dp[i][j];
					end=i;
				}
			}
		} //return maxLen;  ��Ҫ���ȵĻ�������ֱ�����������dp�ĺ����з��ؾ���
		return s1.substring(end+1-maxLen,end+1);
	}
	// ���Բ�ȡб�߷���ֵҪO(1)
	static public int zuichang(String s1,String s2){
		int len1=s1.length();
		int len2=s2.length();
		if(s1==null || s2==null || len1==0 || len2==0){
			return 0;
		}
		char[] cs1=s1.toCharArray();
		char[] cs2=s2.toCharArray();
		int maxLen=0; //��¼��󳤶�
		int row= 0;//б�߿�ʼ����
		int col= len2-1;//б�߿�ʼ����
		int end=0;//��¼��ִ��Ľ�βλ��
		while(row<len1){
			int i=row;
			int j=col; //�ӣ�i,j����ʼ�����·�����
			int nowLen=0;
			while(i<len1 && j<len2){
				if(cs1[i] !=cs2[j]){
					nowLen=0;
				}else{
					nowLen++;
				}
				if(nowLen>maxLen){
					maxLen=nowLen;
					end=i;//�õ�һ������׼��������=j������õڶ����ַ�������Ҳ��
				}
				i++;
				j++;
			}
			if(col>0){//��Ӧ��һ�еĸ���б�ߣ�����������
				col--;
			}else{ //��������
				row++;
			}
		} //��Ҫ�����ַ����ݣ��򷵻�λ�þ���
		return maxLen; //return s1.substring(end+1-maxLen,end+1);
	}
}
*/ 
/*
//�����������    �������һ���������ڣ������Ҫ��������ֻ���������оͿ��ԡ� ��Ȼ��ʹ�ö�άDP
public class Leet{ //����� P210
	public static void main(String[] args) {
		String s1="1A2C3D4B56";
		String s2="B1D23CA45B6A";
		System.out.println(zc(s1,s2));
	}
	static public int[][] dp(char[] s1,char[] s2){
		int len1=s1.length;
		int len2=s2.length;
		int[][] dp=new int[len1][len2];
		dp[0][0]= s1[0]==s2[0]? 1:0;
		for(int i=1;i<len1;i++){ //��һ�У����Ϊ1�����Ⱥ�ǰһ��һ��
			if(s1[i]==s2[0]){
				dp[i][0]=1;
			}else{
				dp[i][0]=dp[i-1][0];
			}
		}
		for(int j=1;j<len2;j++){//��һ�У����Ϊ1�����Ⱥ�ǰһ��һ��
			if(s2[j]==s1[0]){
				dp[0][j]=1;
			}else{
				dp[0][j]=dp[0][j-1];
			}
		}
		for(int i=1;i<len1;i++){//��i,j�����s1[i]!=s2[j]��ô��i-1,j�����ߣ�i,j-1���еĴ���.
			for(int j=1;j<len2;j++){ //�����ȣ���ô��������(i-1,j-1)+1���ٴ�ѡ�����
				dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				if(s1[i]==s2[j]){
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-1]+1);
				}
			}
		}
		return dp;//���һ��ֵ������ĳ���
	}
	static public String zc(String s1,String s2){
		if(s1==null||s2==null||s1.equals("")||s2.length()==0){
			return ""; //һ���ó���==0���У����ֻ��һ��˼·
		}
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		int[][] dp=dp(c1,c2);
		int m=c1.length-1;
		int n=c2.length-1;//��������������ȣ���Ҫ�Ǹ����浱index
		char[] both=new char[dp[m][n]];
		int index=both.length-1;//��Ϊ��ͬ�ַ����±��¼���Ӻ���ǰ��
		while(index>=0){
			if(m>0 && dp[m][n]==dp[m-1][n]){
				m--;  //m��n���ж��Ⱥ�˳���Ӱ�����ս����������ж��ֿ��ܵĻ���ѡ������оͲ�һ��
			}else if(n>0 && dp[m][n]==dp[m][n-1]){
				n--;
			}else{
				both[index--]=c1[m];//����c2[n]
				m--;
				n--;
			}
		}
		return String.valueOf(both);
	}
}
*/
/*
//344 reverse string  ����C++д��
//class Solution {
//public:
//    string reverseString(string s) {
//        int len=s.length();
//        if(len==0){
//            return s;
//        }
//       
//        for(int i=0;i<(len>>1);i++){
//            char t=s[i];
//            s[i]=s[len-1-i];
//            s[len-1-i]=t;
//        }
//        return s;
//    }
//};
*/
/*
//342  power of 4 four  ˼·��������2�Ĵη���ֻ��һ��1��������1Ҫ��������λ��4�Ĵη���������0101�������0.
public class Leet{
	public boolean isPowerOfFour(int num) {
		if((num&(num-1))==0 && (num&0x55555555)>0) //16���ƣ�һ��5=0101. 32λ������8��5
			return true;
		return false;
	}
}
*/
/*
//226 invert binary tree ��ת������
public class Leet{
	public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }	
}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
*/
/*
//191 number of one bit 1�ĸ���
public class Leet{
    public int onenum(int n) {
        int cnt=0;
        while(n!=0){
            n=n&(n-1);
            cnt++;
        }
        return cnt;
    }
}
*/
/*
//88  Merge Sorted Array ������2�ϲ�������1�У�ע���Ѿ�����˼·�ǴӺ���ǰ�ϲ���������1�ĺ��档�����ٶȿ�
public class Leet{
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m+n-1; //�ܵ�index���Ӻ���ǰ
        int j1=m-1;//�Ӻ���ǰ ����1��index
        int j2=n-1; //����2��
        while(j1>=0 && j2>=0)
        {
            nums1[i--]= (nums1[j1]>=nums2[j2])? nums1[j1--]:nums2[j2--];
        }
        while(j2>=0)//2�ϲ���1�У�����ֻҪ��2�Ƿ���ʣ�£�1���ù�
        {
            nums1[i--]=nums2[j2--];
        }
    }
}
*/
/*
//26 Remove Duplicates from Sorted Array Ҫ�����ö�������
public class Leet{
    public int removeDuplicates(int[] nums) {
       int len=nums.length;
    	if(len==0)
          return 0;
        int m=1;
        for(int i=1;i<len;i++){//����index��m���µĲ�ͬ�������Ԫ�ظ�����һ��������ȷ�ϣ�i��ԭ����
            if(nums[m-1]!=nums[i]){
                nums[m]=nums[i];//Ҫ�󲻽��Ƿ��س��ȣ���Ҫ���ȥ���ظ�����һ������ȥ���ظ�
                m++;
            }
        }
        return m;
    }
}
*/
/*
//299 Bulls and Cows ������ λ����ͬ��ֵ��ͬ��bull  λ�ò�ֵͬ��ͬ��cow
//˼·��������ģ��hashmap��ͳ��һ�����ٸ���ͬ���ַ�������λ��Ҳ��ȵľ���bull����ȥ���bull����cow
public class Leet{//��Ŀ����涨��ֻ�������֣��ҳ������
	public String hint(String num,String guess){
		int len=num.length();
		if(len<=0 || num==null || guess==null){
			return "invalid";
		}
		char[] s=num.toCharArray();
		char[] g=guess.toCharArray();
		int[] mps=new int[10];//0-9��10����
		int[] mpg=new int[10];
		int bull=0;
		int cow=0;
		for(int i=0;i<len;i++){
			if(s[i]==g[i]){
				bull++;
			}
			mps[s[i]-'0']++;
			mpg[g[i]-'0']++;
		}
		for(int i=0;i<10;i++){
			cow+=Math.min(mps[i], mpg[i]);
		}
		cow=cow-bull;
		return bull+"A"+cow+"B"; //��ĿҪ��A����bull
	}
}
*/
/*
// 371 Sum of Two Integers ����+-��ӷ�
public class Leet{
	public static void main(String[] args){
		
	}
	public int getSum(int a,int b){
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
// 258 easy Add Digits һ���Ǹ���������ѭ��O(1)ʱ���������λ����֮��ֱ��һλ��.
//˼·��һ�����ܱ�9��3����������ô��λ��������Ӻ����ܱ�9��3��������9B+99C+999D+9999E����+A+B+C+D+E����
//��һ��������λ�úͣ������������9ȡ��
//����dr(n) = n-(n-1)/9 *9 = 1+(n-1)-(n-1)/9*9 = 1+(n-1)%9 ����һ�д��룬return (num-1)%9+1;
public class Leet{
	public int addDigits(int num){
	    if(num==0)
	    	return 0;
	    else if(num%9==0){
			return 9;
		}else{
			return num%9;
		}
	}
}
*/
/*
// 292.easy Nim Game ��һ��ʯͷÿ��1-3�������ȣ������������ܷ�Ӯ��
//ö���ܷ�������˭��4�ı���˭��.����4�ı���ʱ��������ȥ������ʹ��Ϊ4�ı�����dp[n]=!dp[n-1] || !dp[n-2] || !dp[n-3]
public class Leet{
	public boolean canwin(int n){
		if(n<=0)
			return false;//�ݴ���Բ���
		return !(n%4==0);
	}
}
*/
/*
//104. Maximum Depth of Binary Tree
public class Leet{
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
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
*/
/*
//283. Move Zeroes ֻ׼��ԭ�����ϲ���   ˼·������һ��index��Ϊ����������±꣬��ô��0��һ��������ֵ
//ֱ���������������������ʱ��ʣ�µ�ȫ����0
public class Leet{
	public void moveZero(int[] s){
		int len=s.length;
		if(len<=0 || s==null)
			return;
		int index=0;
		for(int i=0;i<len;i++){
			if(s[i]!=0){
				s[index++]=s[i];
			}
		}
		for(int i=index;i<len;i++){
			s[i]=0;
		}
	}
}
*/
/*
//237. Delete Node in a Linked List
public class Leet {
    public void deleteNode(ListNode node) {
        if(node==null){
            return;
        }
        node.val=node.next.val;
        node.next=node.next.next;
        return;
    }
}
*/
/*
//100. Same Tree
public class Leet {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){//��������3���жϣ�ͬʱnull��true��ֻһ��null��false
            return p==q;
        }
        if(p.val==q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
*/
/*
//242. Valid Anagram ͬ��ĸ��ͬ˳��ĵ��� ����ȫ��ͬ��Ҳ�����
public class Leet {
    public boolean isAnagram(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        if(len1!=len2) return false;
        int[] map=new int[26];//��ĸ��Map����
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        for(int i=0;i<len1;i++){
            map[ss[i]-'a']++;
        }//˼·��ͳ�Ƶ�һ����+1������Ȼ������ڶ���-1����
        for(int i=0;i<len1;i++){
            if(map[tt[i]-'a']==0)//s���Ѿ�û�ˣ�t���ֳ��֣���false
                return false;
            map[tt[i]-'a']--;
        }
        return true;
    }
}
*/
/*
//171. Excel Sheet Column Number A-1 Z-26 AB-28
public class Leet{
	public int s2num(String s){
		int len=s.length();
		if(len==0|| s==null)
			return 0;
		int sum=0;
		for(int i=0;i<len;i++){
			sum+=(s.charAt(i)-'A'+1)*Math.pow(26, len-i-1);
		}
		return sum;
	}
}
*/
/*
//169. Majority Element �ǿ�������ڴ�������һ�루n/2����Ϊ��ҪԪ�أ�
public class Leet{//˼·����ͬ+1����ͬ-1�����ʣ�µĿ϶��ǳ���һ��ġ��൱��һ������2��
	public int mje(int[] s){
		int len=s.length;
		if(len==0|| s==null)
			return 0;
		int mj=s[0];//��һ����Ĭ��
		int time=1;
		for(int i=1;i<len;i++){//iֱ�Ӵӵڶ�����ʼ
			if(time==0){
				mj=s[i];
				time=1;
			}else if(s[i]==mj)
				time++;
			else
				time--;
		}
		return mj;
	}
}
*/
/*
//217. Contains Duplicate �ж������Ƿ����ظ����֣���hashMap����set����
public class Leet{
	public boolean dup(int[] s){
		int len=s.length;
		if(len==0 || s==null)
			return false;
		HashSet<Integer> hs=new HashSet<>();
		for(int i=0;i<len;i++){
			if(!hs.add(s[i]))//add������set�д���������ͷ���false
				return true;
		}
		return false;
	}
}
*/
/*
//350. Intersection of Two Arrays II ����������ͬ���� nums1=[1,2,2,1], nums2=[2, ],return[2,2]
public class Leet{
	public int[] intersect(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int[] res=new int[Math.min(len1,len2)];
        if(len1<=0 || len2<=0)
           return res;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<len1;i++){
            if(hm.containsKey(nums1[i])){
                hm.put(nums1[i],hm.get(nums1[i])+1);
            }else{
                hm.put(nums1[i],1);
            }
        }
        int index=0;
        for(int j=0;j<len2;j++){
            if(hm.containsKey(nums2[j])){
                if(hm.get(nums2[j])>0){
                    res[index++]=nums2[j];
                    hm.put(nums2[j],hm.get(nums2[j])-1);
                }
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
*/
/*
//349. Intersection of Two Arrays  ����һ���ξ���
public class Leet{//˼·��������hashmap��������hashset������remove����
	public int[] intersection(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int[] res=new int[Math.min(len1,len2)];
        if(nums1==null || len1==0 || nums2==null || len2==0){
            return res;
        }
        HashSet<Integer> hs= new HashSet<Integer>();
        for(int i=0;i<len1;i++){
            hs.add(nums1[i]);
        }
        int index=0;
        for(int j=0;j<len2;j++){
            if(hs.remove(nums2[j])){//remove����ture��˵�������Ԫ��
                res[index++]=nums2[j];
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
*/
/*
// 13. Roman to Integer  //����1������5������10��L��50��C��100��D��500��M��1000�� 
// rules:λ�ڴ����ĺ���ʱ����Ϊ������λ�ڴ�����ǰ�����Ϊ������ֻ��I��X��C������45������д��VL��ֻ����XLV��
//eg����=3,��=4,��=6,����=19,����=20,��L��=45,MCM����C=1980
//˼·����HashMap������������Щ��ĸ��Ӧ�����֡�Ȼ��Ӻ���ǰ���ߴ�ǰ���������ĸ����¼һ��sum
//������ǰ������ǰ��Ⱥ���С�����ȥ����֮����ϡ���ǰ�������������ǰ������ȥ2����֮��
public class Leet{
	public int roma2num(String s){
		int len=s.length();
		if(len==0 || s==null)
			return 0;
		HashMap<Character,Integer> hm=new HashMap<>();
		hm.put('I', 1); // hm=new int[26]
		hm.put('V', 5); // hm['V'-'A']=5;
		hm.put('X',10);
		hm.put('L', 50);
		hm.put('C', 100);
		hm.put('D', 500);
		hm.put('M', 1000);
		char[] ss=s.toCharArray();
		int sum=hm.get(ss[len-1]);
		for(int i=len-2;i>=0;i--){
			if(hm.get(ss[i+1])>hm.get(ss[i])){
				sum-=hm.get(ss[i]);
			}else{
				sum+=hm.get(ss[i]);
			}
		}
		return sum;
	}
}
*/
/*
//326. Power of Three ˼·��1������int��3�Ĵη���1162261467���ܱ��������϶��ǡ�
//2������log���� log10(n)/log10(3)�����������.����log����log10����Ϊlog(243)/log(3)�����
public class Leet{
	public boolean ispow(int n){
	//	return n > 0 && (1162261467 % n == 0);
	    return n>0 && (Math.log10(n)/Math.log10(3))%1==0;
	}
}
*/
/*
//235. Lowest Common Ancestor of a Binary Search Tree
//������ȣ�ע��Node����Ҳ���Լ�������
public class Leet{
	TreeNode lowcom(TreeNode root,TreeNode p,TreeNode q){
		if(root==null || p==null || q==null)
			return null;
		if((root.val-p.val)*(root.val-q.val)<=0)//��������
			return root;
		else if(root.val>p.val && root.val>q.val)
			return lowcom(root.left,p,q);
		else
			return lowcom(root.right,p,q);
	}
}
class TreeNode{int val;TreeNode left;TreeNode right;}
*/
/*
//263. Ugly Number  �뽣ָoffer34���ƣ�������жϣ��Ǹ�������
public class Leet{
	public boolean isugly(int n){
		if(n<=0) return false;
		if(n==1) return true;
		while(n%2==0) n=n>>1;
		while(n%3==0) n=n/3;
		while(n%5==0) n=n/5;
		return n==1? true:false;
	}
}
*/
/*
//202. Happy Number ��λƽ�����ֱ������1��19������ѭ��
//˼·����HashSet����table����ƽ���ͣ�������˾�false��û�оͼ�����.
//2:�����ڼ�������л���һ�������ֱ���һ�κ�2�Σ�ֱ��������ȡ���������ȵ�ֵ�ǲ���1
public class Leet{
	public boolean isHappy(int n){
		if(n==0) return false;
		HashSet<Integer> hs=new HashSet<>();
		int sum=0,low=0;
		while(hs.add(n)){//�ܴ棬���ظ�
			sum=0;
			while(n!=0){
				low=n%10;
				sum+=low*low;
				n=n/10;
			}
			n=sum;
		}
		return sum==1? true:false;
	}
	//����˼·Ҳ����
	public int digitSquareSum(int n) {
	        int sum = 0, tmp;
	        while (n!=0) {
	            tmp = n % 10;
	            sum += tmp * tmp;
	            n /= 10;
	        }
	        return sum;
	    }
	 public boolean isHappy2(int n) {
	        int slow, fast;
	        slow = fast = n;
	        do {
	            slow = digitSquareSum(slow);
	            fast = digitSquareSum(fast);
	            fast = digitSquareSum(fast);
	            if(fast == 1) return true;
	        } while(slow != fast);
	         return false;
	}
}
*/
/*
//83. Remove Duplicates from Sorted List   1->1->2->3->3->4, return 1->2->3
//����sword57���Ǹ��Ƿ���2->4���ظ���ȫɾ��������ʱ�����P71,��hashset��ֵ��ѭ������
//���Եݹ飬Ҳ����ѭ��
public class Leet{
	public ListNode delrecursive(ListNode head){
		if(head==null || head.next==null)
			return head;
		head.next=delrecursive(head.next);//head.next=����Ҫ����������½�һ�����þ���
		return head.val==head.next.val? head.next:head;
	}
	public ListNode del(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode list=head;
		while(list.next!=null){
			if(list.val==list.next.val)
				list.next=list.next.next;
			else
				list=list.next;
		}
		return head;
	}
}
class ListNode{
	int val;ListNode next;ListNode(int i){val=i;}
}
*/
/*
//121. Best Time to Buy and Sell Stock  [7, 1, 5, 3, 6, 4] ���5=6-1�� ����׬����0
//������DP����i�����������dp[i],��ôi+1���������dp[i]���ߵ�i+1��۸��ȥǰi����Сֵ��
//��ЧΪ�����������͵����⣬��Ϊ������Ǿ�����һ����������m����m[n]-m[0]ֵ�����ô��ԭ���鹹��
//�ɺ�һ����ǰһ���õ������飬��ôԭ����ͱ������������������������⡣
class Leet{
	public int buy(int[] s){
		int len=s.length;
		if(len<2) return 0;
		int max=0,newsum=0;//max�Ǳ���ĿǰΪֹ�������newsum��ÿһ�����ܵ������鿪ʼ�ۻ���
		for(int i=1;i<len;i++){
			newsum+=s[i]-s[i-1];
			max=Math.max(max, newsum);
			newsum=Math.max(0, newsum);
		}
		return max;
	}
}
*/
/*
//345. Reverse Vowels of a String  "hello", return "holle"
class Leet{
	public String revow(String s){
		int len=s.length();
		if(len<2) return s;
		int left=0;
		int right=len-1;
		char[] ss=s.toCharArray();
		String vowels="aeiouAEIOU";
		while(left<right){
			while(left<right && vowels.indexOf(ss[left])==-1){
				left++;
			}
			while(left<right && vowels.indexOf(ss[right])==-1){
				right--;
			}
			if(left<right){//������жϿ��Բ�Ҫ����Ϊ��ʹ����ȣ�����Ҳ����ν
				char temp=ss[left];
				ss[left]=ss[right];
				ss[right]=temp;
				left++;
				right--;
			}else{//���ﷵ��Ҳ���Բ�Ҫ����Ϊ��һ�ο϶������ϴ�ѭ��
				return String.valueOf(ss);
			}
		}
		return String.valueOf(ss);
	}
}
*/
/*
//24. Swap Nodes in Pairs   1->2->3->4, as 2->1->4->3. ������������
class Leet{
	//�ݹ鷽��
	public ListNode swap(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode temp=head.next;
		head.next=swap(head.next.next);
		temp.next=head;
		return temp;
	}
	//ѭ��
	public ListNode swap2(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode cur=dummy;
		while(cur.next!=null && cur.next.next!=null){
			ListNode fir=cur.next;
			ListNode sec=cur.next.next;
			cur.next=sec;//�⼸���㻭ͼ������
			fir.next=sec.next;
			sec.next=fir;
			cur=cur.next.next;
		}
		return dummy.next;
	}
}
*/
/*
//198. House Robber ����������������ͣ�DP��⡣maxV[i] = max(maxV[i-2]+num[i], maxV[i-1])
class Leet{
	public int hr(int[] s){
		int len=s.length;
		if(len<=0) return 0;
		if(len==1) return s[0];
		int f0=0;
		int f1=s[0];
		int fi=0;
		for(int i=1;i<len;i++){
			fi=Math.max(f0+s[i], f1);
			f0=f1;
			f1=fi;
		}
		return fi;
	}
}
*/
/*
//107 102 Binary Tree Level Order Traversal II ���д�ӡ�������������»�������
class Leet{
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> list=new ArrayList<Integer>();
            int size=que.size();//���������������Ƶ��ж����һ��Node��
            for(int i=0;i<size;i++){
                TreeNode cur=que.poll();
                list.add(cur.val);
                if(cur.left!=null)
                    que.add(cur.left);
                if(cur.right!=null)
                    que.offer(cur.right);
            }
            res.add(0,list);
        }
        return res;
    }
}
*/
/*
//27 Remove Element  nums = [3,2,2,3], ȥ��val = 3 ����2��������ǰ����2��2
class Leet{
	public int removeElement(int[] nums, int val) {
        int len=nums.length;
        if(len<=0) return 0;
        int newindex=0;
        for(int i=0;i<len;i++){
            if(nums[i]!=val){
                nums[newindex++]=nums[i];
            }
        }
        return newindex;
    }
}
*/
/*
//66. Plus One ������ɵ����ּ�1, �Ӻ���ǰ����9��+1ֱ�ӷ��أ�9�ͱ�0��λ��
//���ȫ��9������Ҫ��һλ1������ȫ��0
class Leet{
	public int[] plusOne(int[] digits) {
        int len=digits.length;
        if(len<=0) return digits;
        for(int i=len-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]+=1;
                break;
            }else{
                digits[i]=0;
            }
        }
        if(digits[0]==0){
            int[] nd=new int[len+1];
            nd[0]=1;
            return nd;
        }else{
            return digits;
        }
    }
}
*/
/*
//118. Pascal's Triangle ����5�õ� [1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]
class Leet{
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listlist=new ArrayList<List<Integer>>();
        if(numRows<1)  return listlist;
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<numRows;i++){
            list.add(0,1);
            for(int j=1;j<list.size()-1;j++){//��һ�����һ��һֻ��1������
                list.set(j,list.get(j)+list.get(j+1));//set�Ǵ��棬add�ǲ���
            }
            listlist.add(new ArrayList<Integer>(list));
        }
        return listlist;
    }
}
*/
/*
//119. Pascal's Triangle II����K�������K�У�Ҫ�� O(k)�ռ� k=3 ��[1,3,3,1].
class Leet{
	public List<Integer> getRow(int n) {
        List<Integer> list=new ArrayList<Integer>();
        if(n<0) return list;
        list.add(0,1);
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=1;j--){
                list.set(j,list.get(j-1)+list.get(j));
            }    //֮ǰ�ǵ��⣬����ѭ��ǰ�棬1Ҳ����ǰ�档���ʲ�Ҫ�������顣
            list.add(1);//�������,��������ѭ�����档
        }
        return list;
    }
}
*/
/*
//172. Factorial Trailing Zeroes ��N�׳��ж���0��
//��N�׳����������ֽ⣬��2^k*3^m*5^n. ��2��5�Ĵη��ٵ��Ǹ�����0�ĸ�����5���ٵ��Ǹ�
//���Ը�������n/5�ĸ�����n/5/5, n/5/5/5...ֱ��0
class Leet{
	public int trailingZeroes(int n) {
        int num=0;
        while(n!=0){
            num+=n/5;
            n=n/5;
        }
        return num;
    }
}
*/
/*
//9. Palindrome Number ���ö���ռ䣬�ж������Ƿ��ǻ��ģ�������ת�����ַ���
class Leet{
	public boolean isP(int x){
		if(x<0 || (x!=0 && x%10==0)) return false;
		int right=0;
		while(x>right){//���㵽һ�볤�ȼ��ɡ�
			right=right*10+x%10;
			x/=10;
		}     // ż��λ                  ����λ
		return (x==right || x==right/10);
	}
}
*/
/*
//112. Path Sum ��Ϊĳһֵ·���� ��offer25
class Leet{
	public boolean haspath(TreeNode root,int sum){
		if(root==null) return false;
		if(root.left==null && root.right==null)
			return root.val==sum? true:false;
		return haspath(root.left,sum-root.val) || haspath(root.right,sum-root.val);
	}
}
*/
/*
//36. Valid Sudoku �ж������Ƿ����,����Ҫ�ɽ⣬ֻҪ�Ѿ��е����֣�ÿ��ÿ��ÿ��9����û�ظ�������
//˼·����ÿһ��Ԫ�ر�ǣ���s[2][3]=5;��ô������5ʱ����Set���ύ3��Ԫ�أ�һ����3��5��2��5����һ��
//�Ź����5.����ֻҪ����һ������������С�
class Leet{//�յ����á�.����ʾ
	public boolean isshudu(char[][] s){
		Set<String> set=new HashSet<String>();
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(s[i][j]!='.'){
					if(!set.add(s[i][j]+"row"+i)||
					   !set.add(s[i][j]+"col"+j)||
					   !set.add(s[i][j]+"block"+i/3+"-"+j/3))
						return false;
				}
			}
		}
		return true;
	}
}
*/
/*
//374. Guess Number Higher or Lower  1-n������������ֲ���
class Leet{//����API�����Ǵ�1��С-1
	public int guessNumber(int n){
		int low=1;
		int high=n;
		while(low<high){
			int mid=low+((high-low)>>1);//��λһ��Ҫ������
			switch(guess(mid)){
			case 0:
				return mid;
			case 1:
				low=mid+1;break;
			case -1:
				high=mid-1;break;
			}
		}
		return low;
	}
	public int guess(int n){return 0;};
}
*/
/*
//111. Minimum Depth of Binary Tree
class Leet{//ע���ǵ�Ҷ�ڵ㣨���Ҿ�Ϊnull���������
	public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) return minDepth(root.right)+1;
        if(root.right==null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
*/
/*
//225. Implement Stack using Queues ֻҪһ�����У�push������һ��
class Leet{
    Queue<Integer> que=new LinkedList<Integer>();
    public void push(int x) {
        que.offer(x);
        int len=que.size();
        for(int i=0;i<len-1;i++){
            que.offer(que.poll());
        }
    }
    public void pop() {
        que.poll();
    }
    public int top() {
        return que.peek();
    }
    public boolean empty() {
        return que.isEmpty();
    }
}
*/
/*
//223. Rectangle Area ������������������������ϵ�����
class Leet{
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int are1=(C-A)*(D-B);
        int are2=(G-E)*(H-F);
        if(E>=C || F>=D || G<=A || H<=B)
            return are1+are2;
        int len=Math.min(C,G)-Math.max(A,E);
        int hei=Math.min(D,H)-Math.max(B,F);
        return are1+are2-len*hei;
    }
}
*/
/*
//205. Isomorphic Strings Given "egg","add",return true.Given "foo","bar",return false
//˼·������HashMap����ģ���HM��ÿ�μ����Keyʱ����Ӧ��Value�Ƿ�һ������һ����false��һ����
//�����µ�value��HashMap��put�����᷵��Ҫ�ӵ�Key��Ӧ��ǰһ��Value
class Leet{
	public boolean isIsomorphic(String s, String t) {
        int[] m1=new int[256];
        int[] m2=new int[256];
        int len=s.length();
        for(int i=0;i<len;i++){
            if(m1[s.charAt(i)]!=m2[t.charAt(i)])
                return false;
            m1[s.charAt(i)]=i+1;//+1�������һ����Ϊ0������
            m2[t.charAt(i)]=i+1;//Ĭ��ֵ�����
        }
        return true;
    }
	public boolean isIsomorphic2(String s, String t) {
        HashMap<Character,Integer> m1=new HashMap<>();
        HashMap<Character,Integer> m2=new HashMap<>();
        int len=s.length();
        for(Integer i=0;i<len;i++){//ע����Integer����int�����Զ�װ�������
            if(m1.put(s.charAt(i),i)!=m2.put(t.charAt(i),i))
                return false;//put�������Key��һ�ε�Value�����򷵻�null
        }
        return true;
    }
}
*/
/*
//160. Intersection of Two Linked Lists ��ָ��Ҳ��
class Leet{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;//��ͳ��������Ȳ���������ֵ
        ListNode a=headA;//������һ���ߵ���ͬ
        ListNode b=headB;
        while(a!=b){//����ﵽ�Զ����곤�ȵĲ�ֵ
            a= a==null? headB:a.next; //һ���ߵ�β����
            b= b==null? headA:b.next;//����һ��ͷ��
        }
        return a;
    }
}
*/
/*
//219. Contains Duplicate II ��������ͳ���K�������Ƿ��������s[i]=s[j],j-i<=K
class Leet{
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len=nums.length;
        if(k<=0 || len<=1) return false;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<len;i++){
            if(hm.containsKey(nums[i])){
                if(i-hm.get(nums[i])<=k)
                    return true;
            }
            hm.put(nums[i],i);
        }
        return false;
    }
}
*/
/*
//19. Remove Nth Node From End of List ɾ��������N�Ľ�㣬�ؼ�������һ��ͷ���
class Leet{
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        if(head==null) return head;
	        ListNode dummy=new ListNode(0);
	        dummy.next=head;//��һ��ͷ�����Բ����ٿ���ɾ��ͷ���������
	        ListNode fast=dummy;
	        ListNode slow=dummy;
	        while(n>0){
	            fast=fast.next;
	            n--;
	        }
	        while(fast.next!=null){
	            slow=slow.next;
	            fast=fast.next;
	        }
	        slow.next=slow.next.next;
	        return dummy.next;
	    }
}
*/
/*
//290. Word Pattern pattern = "abba", str = "dog cat cat dog" should return true.
class Leet{
	public boolean wordPattern(String pattern, String str) {
        int len1=pattern.length();
        String[] strs=str.split(" ");
        int len2=strs.length;
        if(len1!=len2) return false;
        HashMap<Character,Integer> hm1=new HashMap<>();
        HashMap<String,Integer> hm2=new HashMap<>();
        for(Integer i=0;i<len1;i++){
            if(hm1.put(pattern.charAt(i),i)!=hm2.put(strs[i],i))
                return false;
        }//����˼·���ж������ַ���Isomorphic Strings����һ��
        return true;
    }
}
*/
/*
//257. Binary Tree Paths  DFS����·�� ["1->2->5", "1->3"]
class Leet{
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<String>();
        if(root==null) return list;
        StringBuffer s=new StringBuffer();
        dfs(root,s,list);
        return list;
    }
    private void dfs(TreeNode root,StringBuffer s,List<String> list){
        int len=s.length();
        s.append(root.val);//һ��Ҫ�ȼӣ����������淵��ʱ����dfs�����м�
        if(root.left==null && root.right==null){
            list.add(s.toString());
        }else{
            s.append("->");//һ��Ҫ��ifǰ�ȼӺã�
            if(root.left!=null)
            dfs(root.left,s,list);//�����ں����������
             if(root.right!=null)//����Ҫʹ������dfs����������s���һ��
            dfs(root.right,s,list);//����ں����мӣ���ô��һ������һ����һ��
        }
        //�����String�����û��ݣ���Ϊÿ�ζ����¿��ģ����õ��Ļᱣ����һ��·��
        s.setLength(len);//����ȥ�������·��
    }
}
*/
/*
//20. Valid Parentheses "()[]{}" are all valid but "(]" and "([)]" are not
class Leet{//˼·������stack����
	public boolean isValid(String s) {
        int len=s.length();
        if(len<2) return false;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<len;i++){
            switch(s.charAt(i)){
                case '(': stack.push('(');break;
                case '[': stack.push('[');break;
                case '{': stack.push('{');break;
                case ')': 
                    if(stack.isEmpty() || stack.pop()!='(')
                        return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop()!='[')
                        return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop()!='{')
                        return false;
                    break;
                default: break;
            }
        }
        return stack.isEmpty();
    }
}
*/
/*
//38. Count and Say 1, 11, 21, 1211, 111221�����ķ�ʽ��Ϊ��һ�������õݹ�,���ص�N����
class Leet{
	public String countAndSay(int n) {
        if(n<=0) return "";
        if(n==1) return "1";
        String s=countAndSay(n-1);
        char[] c=s.toCharArray();
        int len=c.length;
        StringBuffer sb=new StringBuffer();
        int i=0;
        while(i<len){//cnt��ʾ�����ֵĴ���
            int cnt=1;//һ���ڴ�ѭ������ÿ�δ�1��ʼ
            while(i<len-1 && c[i]==c[i+1]){
                i++;
                cnt++;
            }  //����ݹ飬ÿ���ַ����� X�Ĵ�����X����
            sb.append(String.valueOf(cnt)).append(c[i]);
            i++;
        }
        return sb.toString();
    }
}
*/
/*
//58. Length of Last Word ���һ���ʵĳ���"Hello World",��Ϊ5
class Leet{//�����Ǵ�Сд��ĸ�ӿո�
	public int llw(String s){
		//����һ��Ϳ��ԣ�trim������ȥ�ַ�����ͷ��ĩβ�Ŀհ�
		//return s.trim().length()-s.trim().lastIndexOf(" ")-1;
		int len=s.length();
		if(len<1) return 0;
		while(len>0 && s.charAt(len-1)==' '){
			len--;
		}
		int indexlength=0;
		while(len>0 && s.charAt(len-1)!=' '){
			len--;
			indexlength++;
		}
		return indexlength;
	}
}
*/
/*
//203. Remove Linked List Elements  2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//���� 2 --> 3 --> 4 --> 5
class Leet{//ɾ������ʱ������һ��ͷ������߽�
	public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode index=dummy;
        while(index.next!=null){
        	if(index.next.val==val)
        		index.next=index.next.next;
        	else
        		index=index.next;
        }
        return dummy.next;
    }
}
*/
/*
//190. Reverse Bits��32λ�޷���int������������Ʒ�ת���Ӧ��int��
class Leet{//˼·��10����һ����10��/10�����һλ����
	public int revbit(int n){
		if(n==0) return 0;
		int result=0;
		for(int i=0;i<32;i++){
			result=result<<1;//�൱�ڳ���2������Ӧ10���Ƶ�10��
			result=result+(n&1);//����n�����һλ
			n=n>>1;
		}
		return result;
	}
}
*/
/*
//234. Palindrome Linked List �ж������Ƿ��ǻ���,˼·��תһ����ٱȽ�
class Leet{//O(n) time and O(1) space
	public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        }
        if(fast!=null)//������ʱ��fast�����һ���ϣ���slow���м�
        	slow=slow.next;//��slow�ں�һ��Ŀ�ͷ
        slow=reverse(slow);//��תslow��ͷ�ĺ�һ��
        while(slow!=null){
        	if(slow.val!=head.val)
        		return false;
        	else{
        		slow=slow.next;
        		head=head.next;
        	}
        }
        return true;
    }//�����Ǽ򵥵ķ�ת����
	private ListNode reverse(ListNode h){
		if(h==null || h.next==null) return h;
		ListNode pre=null;
		ListNode now=h;
		while(now!=null){
			ListNode after=now.next;
			now.next=pre;
			pre=now;
			now=after;
		}
		return pre;
	}
}
*/
/*
//190. Reverse Bits ��һ����3������Ӧ��32λ2���Ʒ�ת���Ӧ�����������
class Leet{
	public int reverseBits(int n) {
        if(n==0) return 0;
		int result=0;
		for(int i=0;i<32;i++){
			result=result<<1;//�൱�ڳ���2������Ӧ10���Ƶ�10��
			result=result+(n&1);//����n�����һλ
			n=n>>1;
		}
		return result;
    }
}
*/
/*
//14. Longest Common Prefix һ���ַ����Ĺ���ǰ׺
class Leet{
	public String longestCommonPrefix(String[] strs) {
        int len=strs.length;
        if(strs==null || len==0) return "";
        if(len==1) return strs[0];
        Arrays.sort(strs);
        char[] first=strs[0].toCharArray();
        char[] last=strs[len-1].toCharArray();
        int len2=Math.min(first.length,last.length);
        int i=0;
        while(i<len2 && first[i]==last[i]){
            i++;
        }
        return strs[0].substring(0,i);
    }
}
*/
////1. Two Sum ���������ҳ�2�����͵����ض�ֵ��ֻ��һ��
//class Leet{
//	public int[] twoSum(int[] nums, int target) {
//        int len=nums.length;
//        int[] res=new int[2];
//        HashMap<Integer,Integer> hm=new HashMap<>();
//        for(int i=0;i<len;i++){
//            if(hm.containsKey(target-nums[i])){
//                res[0]=hm.get(target-nums[i])-1;
//                res[1]=i;
//                return res;
//            }
//            hm.put(nums[i],i+1);
//        }
//        return res;
//    }
//}
////67. Add Binary  11+1=100  3+1=4
//class Leet{
//	public String binary(String a,String b){
//		int len1=a.length();
//		int len2=b.length();
//		if(len1==0) return b;
//		if(len2==0) return a;
//		StringBuilder sb=new StringBuilder();
//		int aa=0,bb=0,carry=0;
//		int i=len1-1;
//		int j=len2-1;
//		while(i>=0 || j>=0 ||carry==1){//ֱ��a.charAt(i--)-'0'Ҳ��
//			aa= (i>=0)? Integer.valueOf(a.charAt(i--)+""):0;
//			bb= (j>=0)? Integer.parseInt(b.charAt(j--)+""):0;
//			int sum=aa^bb^carry;
//			carry= ((aa+bb+carry)>=2)? 1:0;
//			sb.append(sum);
//		}
//		return sb.reverse().toString();
//	}
//}
//// 28. Implement strStr()  ���ǵ�һ�γ��ֵ�λ�ã�indexOf
//class Leet{
//	public int strstr(String h,String n){
//		if(n.equals("")) return 0;
//		int len1=h.length();
//		int len2=n.length();
//		for(int i=0;i<=len1-len2;i++){
//			for(int j=0;j<len2;j++){
//				if(j==len2-1 && n.charAt(j)==h.charAt(i+j)) return i;
//				if(n.charAt(j)!=h.charAt(i+j)) break;
//			}
//		}
//		return -1;
//	}
//}
////303. Range Sum Query - Immutable ��̬�滮����Ŀ�ܼ���һ������ָ���±귶Χ�ڵĺ�
////Ҫ���Ƕ�ε���������������Կ϶����ȼ�������д�0��i�ĺʹ���n[i]�Ȼ��n[j]-n[i]���ǽ��
//class Leet{
//	int[] s;
//    public Leet(int[] nums) {
//        int len=nums.length;
//        for(int i=1;i<len;i++){
//        	nums[i]=nums[i-1]+nums[i];
//        }
//        this.s=nums;
//    }
//    public int sumRange(int i, int j) {
//        if(i>j || i<0 || j<0) return 0;
//        if(i==0) return s[j];
//        return s[j]-s[i-1];
//    }
//}
////204. Count Primes <n����������������
//class Leet{
//	public int countPrimes(int n) {
//        if(n<=2) return 0;
//        boolean[] notpri=new boolean[n];//Ĭ��false������prime
//        int cnt=n>>1;//n����ż�����ÿ���ȥ��һ��
//        for(int i=3;i*i<n;i+=2){//ֻ������
//            if(!notpri[i]){
//                for(int j=i*i;j<n;j+=2*i){//ֻ��������j������i������ֻ�У�2i����
//                    if(!notpri[j]){
//                        cnt--;
//                        notpri[j]=true;
//                    }
//                }
//            }
//        }
//        return cnt;
//    }
//}
////6. ZigZag Conversion  Z�δ�ӡһ���ַ����������
//class Leet{//https://leetcode.com/problems/zigzag-conversion/
//	public String convert(String s, int numRows) {
//        int len=s.length();
//        if(numRows<1 || len==0) return "";
//        if(numRows==1) return s;
//        StringBuilder[] sb=new StringBuilder[numRows];
//        for(int i=0;i<numRows;i++)
//            sb[i]=new StringBuilder();
//        char[] c=s.toCharArray();
//        int i=0;
//        while(i<len){
//            for(int id=0;id<numRows && i<len;id++){
//                sb[id].append(c[i++]);
//            }//ֱ�µ�1����row��
//            for(int id=numRows-2;id>=1 && i<len;id--){
//                sb[id].append(c[i++]);
//            }//б�ϵ�row-1����2��
//        }
//        for(int id=1;id<numRows;id++){
//            sb[0].append(sb[id]);
//        }
//        return sb[0].toString();
//    }
//}
////10. Regular Expression Matching hard�Ѷȵ�,��ָoffer53
//class Leet{
//	 boolean match(char[] s, char[] p){
//	        return isMatch(s,0,p,0);
//	    }	 
//	 public boolean isMatch(char[] s,int start1,char[] p,int start2){
//		 int lens=s.length;
//		 int lenp=p.length;
//		 if(start1==lens&&start2==lenp) return true;
//		 if(start2>=lenp) return false;//ֻ��pattern�����˲��ܽ����������̣��ַ�����Ҫ������pattern��������ƥ��
//		 if(start2<lenp-1){
//			 if(p[start2+1]=='*'){//��Ӧ1
//				 if((start1<lens)&&(s[start1]==p[start2]||p[start2]=='.')){
//					 return isMatch(s,start1,p,start2+2)||isMatch(s,start1+1,p,start2+2)||isMatch(s,start1+1,p,start2);
//				 }else return isMatch(s,start1,p,start2+2);//���ȵĻ���ֻ����*��0��
//			 }
//		 }
//		 if(start1==lens) return false;
//		 if(s[start1]==p[start2]||p[start2]=='.')//��Ӧ2
//			 return isMatch(s,start1+1,p,start2+1);
//		 return false; //��Ӧ3       
//	 }
//}
////65. Valid Number hard�����Ѷ� ��ָoffer��54��
//class Leet{
//	public boolean isNumber(String s) {
//	    s = s.trim();
//	    boolean pointSeen = false;
//	    boolean eSeen = false;
//	    boolean numberSeen = false;
//	    boolean numberAfterE = true;
//	    for(int i=0; i<s.length(); i++) {
//	        if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
//	            numberSeen = true;
//	            numberAfterE = true;
//	        } else if(s.charAt(i) == '.') {
//	            if(eSeen || pointSeen) {
//	                return false;
//	            }
//	            pointSeen = true;
//	        } else if(s.charAt(i) == 'e') {
//	            if(eSeen || !numberSeen) {
//	                return false;
//	            }
//	            numberAfterE = false;
//	            eSeen = true;
//	        } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
//	            if(i != 0 && s.charAt(i-1) != 'e') {
//	                return false;
//	            }
//	        } else {
//	            return false;
//	        }
//	    }
//	    
//	    return numberSeen && numberAfterE;
//	}
//}
////125. Valid Palindromeֻ��������ĸ���ִ�Сд "A man, a plan, a canal: Panama" is a palindrome.
//class Leet{//˼·�򵥣�����ǰ������жϡ�
//	public boolean isPalindrome(String s) {
//        int len=s.length();
//        if(len==0) return true;
//        char[] c=s.toCharArray();
//        int left=0;
//        int right=len-1;
//        while(left<right){//���ֳɵ��ж���ĸ���ֺ���
//            while(left<right && !Character.isLetterOrDigit(c[left])){
//                left++;
//            }
//            while(left<right && !Character.isLetterOrDigit(c[right])){
//                right--;
//            }
//            if(Character.toLowerCase(c[left])!=Character.toLowerCase(c[right]))
//                return false;
//            else{
//                left++;
//                right--;
//            }
//        }
//        return true;
//    }
//}
////278. First Bad Version ��1��n�������ж���һ���ǻ��ģ����һ�����ģ����Ƕ��֡�
//class Leet{//ע�����mid�ļ�����left+((right-left)>>1)�ȣ�left+right)/2��ȫ�����߿���Խ��
//	public int firstBadVersion(int n) {
//        if(n<=1) return n;
//        int left=1;
//        int right=n;
//        while(left<=right){
//            int mid=left+((right-left)>>1);
//            if(isBadVersion(mid)){
//                if(!isBadVersion(mid-1))
//                    return mid;
//                else
//                    right=mid-1;
//            }else{
//                left=mid+1;
//            }
//        }
//        return left;
//    }
//}
////168. Excel Sheet Column Title��171���෴����������ת10���ƣ���λ�����ƵĴη��������̾��ö̳�����ͬ������
//class Leet{//���ֶ�Ӧ��û��0������Z%26=0��A%26=1���е��ҡ�����n-1������0��25��ӦA��Z
//    public String convertToTitle(int n) {
//    	 StringBuilder sb=new StringBuilder();
//         while(n>0){
//         	int s=(n-1)%26;
//         	n=(n-1)/26;
//         	sb.append((char)((s+'A')));
//         }
//         return sb.reverse().toString();
//    }
//}
////189. Rotate Array  k = 3, array [1,2,3,4,5,6,7] rotated [5,6,7,1,2,3,4].
////�ͽ�ָoffer�ַ�����ת��2��һ�����ȸ����ַ�ת����ȫ����ת
//class Leet{
//	public void rotate(int[] nums, int k) {
//        int len=nums.length;
//        if(len<=1||k<0) return;
//        int realk=k%len;//��������Ҳ����
//        reverse(nums,0,len-1-realk);
//        reverse(nums,len-realk,len-1);
//        reverse(nums,0,len-1);
//    }
//	private void reverse(int[] s,int left,int right){
//		while(left<right){
//			s[left]=s[left]^s[right];
//			s[right]=s[left]^s[right];
//			s[left]=s[left]^s[right];
//			left++;
//			right--;
//		}
//	}
//}
////165. Compare Version Numbers ���ǰ��汾��С�Ƚ�0.1 < 1.1 < 1.2 < 13.37<15.1.3   4.5.6>4>3.4
//class Leet{//˼·������split("\\.");�ֳɸ������֣��ٱȽϡ�"."���������ַ�������ת��\.�Ƿ�������\\.
//	public int compareVersion(String version1, String version2) {
//        int len1=version1.length();//��ײ�˼·��ֱ�ӱ����ȽϾ���
//        int len2=version2.length();
//        int idx1=0,idx2=0;
//        while(idx1<len1 || idx2<len2){
//        	int sum1=0,sum2=0;
//        	while(idx1<len1 && version1.charAt(idx1)!='.'){//Ҳ����������õ�����
//        		sum1=sum1*10+(version1.charAt(idx1)-'0');//Integer.parseInt����valueOf
//        		idx1++;
//        	}
//        	while(idx2<len2 && version2.charAt(idx2)!='.'){
//        		sum2=sum2*10+(version2.charAt(idx2)-'0');
//        		idx2++;
//        	}
//        	if(sum1>sum2) return 1;
//        	else if(sum1<sum2) return -1;
//        	else{//�����Ѿ���'.'��λ�ˣ���+1�Ϳ��ԡ������һ������û�ˣ���һֱ��0��
//        		idx1++;
//        		idx2++;
//        	}
//        }
//        return 0;
//    }
//}
////8. String to Integer (atoi)ת��������������ֻ��+-���ֺϷ������������Ϸ�
//class Leet{//˼·ͬreverse Integer�Լ�valid numberע��Խ�紦��
//	public int myAtoi(String s) {
//        int len=s.length();
//        if(len==0) return 0;
//        int sign=1,sum=0,idx=0;
//        while(s.charAt(idx)==' ')
//        	idx++;
//        if(s.charAt(idx)=='+' || s.charAt(idx)=='-')
//        	sign= s.charAt(idx++)=='+'? 1:-1;
//        while(idx<len && s.charAt(idx)>='0' && s.charAt(idx)<='9'){
//        	if(sum>Integer.MAX_VALUE/10 || (sum==Integer.MAX_VALUE/10 && (s.charAt(idx)-'0')>7)){
//        		return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
//        	}//int��-2...48��2...47֮ǰ���������7�϶��������ֵ
//        	sum=sum*10+(s.charAt(idx++)-'0');
//        }
//        return sign*sum;
//    }
//}
//////////======����easy������middle===============
////338. Counting Bits ����0��nÿ�������������ж��ٸ�1.˼·������һ�����ķ���n&(n-1)
////˼·�ǣ����ƶ�̬�滮��ż��2n������һ��n����ͬ��������Ϊn<<1=2n;�����ټ�1����
//class Leet{
//	public int[] countBits(int num) {
//        int[] ones=new int[num+1];
//        for(int i=1;i<=num;i++){
//            if((i&1)==0)//ż����4=2<<1;
//                ones[i]=ones[i>>1];
//            else //������7=(3<<1)+1;
//                ones[i]=ones[i>>1]+1;
//        }//�����Ż�������������ones[i]=ones[i>>1]+(i&1);
//        return ones;
//    }
//}
////260. Single Number III ͬ��ָoffer40�⣬��n&(-n)�õ��ұߵ�һ����Ϊ0��λ
//class Leet{
//	public int[] singleNumber(int[] nums) {
//        int len=nums.length;
//        int[] res=new int[2];
//        if(len<=1) return res;
//        int all=0;
//        for(int i=0;i<len;i++){
//            all=all^nums[i];
//        }
//        int ind=0;
//        while(all!=0){
//            all=all>>>1;//������>>,����all=-1ʱ��һֱ!=0...
//            ind++;
//        }//�Ժ�������ķ����õ����ұ߲�����1��λ�ã�ֻ����һλ=1������=0
//        //all=all&(-all);
//        for(int i=0;i<len;i++){
//           // if((nums[i]&all)==0)
//            if(((nums[i]>>(ind-1))&1)==0)
//                res[0]=res[0]^nums[i];
//            else
//                res[1]=res[1]^nums[i];
//        }
//        return res;
//    }
//}
////238. Product of Array Except Selfͬ��ָoffer52�������ý�ָ��˼·�������Ż���O(1)�ռ�
//class Leet{
//	public int[] productExceptSelf(int[] nums) {
//        int len=nums.length;
//        int[] res=new int[len];
//        res[0]=1;
//        for(int i=1;i<len;i++){//�õ�������г˻�
//        	res[i]=res[i-1]*nums[i-1];
//        }
//        int right=1;//���ұ����г˻�ÿ�θ�����right�ϣ���res[i]��˼���
//        for(int i=len-1;i>=0;i--){
//        	res[i]=res[i]*right;//������С��ұ�����
//        	right=right*nums[i];
//        }
//        return res;
//    }
//}
////122. Best Time to Buy and Sell Stock II ��ο��Զ������������ʵ���򵥣�ֻҪ����������׬�˼���
////��ֻ�к�һ�α�ǰһ�δ��������������������
//class Leet{
//	public int maxProfit(int[] p) {
//        int len=p.length;
//        if(len<2) return 0;
//        int res=0;
//        for(int i=1;i<len;i++){
//        	if(p[i]>p[i-1]) res+=p[i]-p[i-1];
//        }
//        return res;
//    }
//}
////347. Top K Frequent Elements ������ִ�������K������Ҫ��ʱ������O(NlogN��
////˼·������HashMapͳ�ƣ�����С���ѻ�PriorityQueue�������ֺʹ������Ϊ������룬��д�Ƚ�����
////���õ�˼·����Ͱ����,ǰ�滹��HMͳ�ƣ�������������ķ����ҳ�TOP
//class Leet{
//	public List<Integer> topKFrequent(int[] nums, int k) {
//        HashMap<Integer,Integer> hm=new HashMap<>();
//        for(int i:nums){//8�·���,û��Key�򷵻�Ĭ��0
//            hm.put(i,hm.getOrDefault(i,0)+1);
//        }
//        int len=nums.length;//Ͱ����+1�Ǵ�����1��ʼ�����0��ʼ
//        ArrayList<Integer>[] bucket=new ArrayList[len+1];
//        for(Integer key:hm.keySet()){//ע�������������ɷ�ʽ������<>()��
//            int frequence=hm.get(key);
//            if(bucket[frequence]==null)
//                bucket[frequence]=new ArrayList<Integer>();
//            bucket[frequence].add(key);
//        }
//        List<Integer> res=new ArrayList<>();
//        for(int i=len;i>0;i--){
//            if(bucket[i]!=null){
//                for(int j=0;j<bucket[i].size() && res.size()<k;j++){
//                    res.add(bucket[i].get(j));
//                }
//            }
//        }
//        return res;
//    }
//}
////343. Integer Break ��һ��2��58���������ֽ������2��������˻����Ľ��n=10,return36(10=3+3+4).
////��f >= 4ʱ2*(f-2)=2f-4>=f��������Զ���÷ֽ�4���ϣ���ֻ��1��2��3.1�϶����У��Ƚ�2��3������2��2��2<3*3����
////��Զ���ó���3��2����ˣ����ȿ���3��Ȼ��2��һ��3�������3n��3n+2��3n+2+2
//class Leet{
//	public int interbreak(int n){
//		if(n==2) return 1;
//		if(n==3) return 2;
//		if(n%3==0) return (int)Math.pow(3, n/3);
//		if(n%3==1) return 2*2*(int)Math.pow(3, (n-4)/3);
//		else return 2*(int)Math.pow(3,(n-2)/3);
//	}
//}
////268. Missing Number Given nums = [0, 1, 3] return 2. 0-n ��һ����������
//class Leet{//���ַ���
//	 public int missingNumber(int[] nums) {
//	        int len=nums.length;
//	        int xor=0,i=0;
//	        for(i=0;i<len;i++){
//	            xor=xor^i^nums[i];
//	        }//���±����
//	        return xor^i;//i=len
//	    }
//	 public int missingNumber2(int[] nums) {
//	        int len=nums.length;
//	        int sum=0,i=0;
//	        for(i=0;i<len;i++){
//	            sum+=i-nums[i];
//	        }//1-n�ĺͼ�ȥ����͵õ�miss
//	        return sum+i;
//	    }
//}
////94. Binary Tree Inorder Traversal���򣬵ݹ�̫�򵥣���ѭ��
//class Leet{
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list=new ArrayList<Integer>();
//    	if(root==null) return list;
//    	Stack<TreeNode> s=new Stack<>();
//    	TreeNode cur=root;//��ǰΪ�ռ�Ҷ���µģ�����û���ҽڵ�ʱҪ��stack���оͼ���
//    	while(cur!=null || !s.isEmpty()){
//    		while(cur!=null){
//    			s.push(cur);
//    			cur=cur.left;
//    		}
//    		cur=s.pop();
//    		list.add(cur.val);
//    		cur=cur.right;
//    	}
//    	return list;
//    }
//}
////319. Bulb Switcher n�����ݣ���ʼȫ�أ���1��ȫ������2�ι����еڶ�����2��4��6.��3���л���3������3��5��7.����
////��n��ֻ�л����һ�������n�κ���Щ�ƻ����š�[0, 0, 0].[1,1,1].[1,0,1].[1,0,0]����1
////�൱�ڣ�һ��ʼȫ�صĵƣ�Ȼ��i��1��n����i�ı����Ķ��л�һ�Ρ����ʣ��һ���ƣ������⣺����n��ȡ�����Ǹ�.
////Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4.
////Except when i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, 
////and double divisor 6. So bulb i ends up on if and only if i is a square
//class Leet{
//	public int laston(int n){
//		if (n<=0) return 0;
//		return (int)Math.sqrt(n);
//	}
//}
////144. Binary Tree Preorder Traversal ǰ�������ѭ��
//class Leet{
//	public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list=new ArrayList<>();
//        if(root==null) return list;
//        Stack<TreeNode> s=new Stack<>();
//        TreeNode cur=root;
//        while(cur!=null || !s.isEmpty()){
//        	while(cur!=null){
//        		list.add(cur.val);
//        		s.push(cur);
//        		cur=cur.left;
//        	}
//        	cur=s.pop().right;
//        }
//        return list;
//    }
//}
//378. Kth Smallest Element in a Sorted Matrix  ��������ҵ�K�������Ȳ����ѣ���Ҫ�öѼ�¼
//˼·��minHeap����һ�У�Ȼ����п�ʼһ��������Ƚϡ���֮���Ͻǵ�Ԫ�ض��Ƚϲ��С�
//class Leet{
//	public int kthSmallest(int[][] matrix, int k) {
//        int len=matrix.length;
//        PriorityQueue<Ele> minHeap=new PriorityQueue<>();
//        for(int i=0;i<len;i++){
//        	minHeap.offer(new Ele(0,i,matrix[0][i]));
//        }
//        for(int i=0;i<k-1;i++){//��k-1��
//        	Ele tmp=minHeap.poll();
//        	if(tmp.x==len-1) continue;
//        	minHeap.offer(new Ele(tmp.x+1,tmp.y,matrix[tmp.x+1][tmp.y]));
//        }
//        return minHeap.peek().val;
//    }
//}
//class Ele implements Comparable<Ele>{//��һ�����������λ�ú�ֵ����������
//	int x,y,val;
//	public Ele(int x,int y,int val){
//		this.x=x;
//		this.y=y;
//		this.val=val;
//	}
//	@Override
//	public int compareTo(Ele other){
//		if(this.val>other.val) return 1;
//		else if(this.val<other.val) return -1;
//		else return 0;
//	}
//}
//373. Find K Pairs with Smallest Sums�������������Һ�ǰKС��ÿ�ԡ���������һ�ⷽ��һ��
class Leet{//�������s[m][n]������������a[m]+b[n]�ĺͣ�����ȫһ���ķ���
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Ele> minHeap=new PriorityQueue<>();
        int len1=nums1.length, len2=nums2.length;
        List<int[]> list=new ArrayList<int[]>();
        if(len1==0 || len2==0 || k<=0) return list;
        for(int i=0;i<len2;i++){//ע����len2������2������
        	minHeap.offer(new Ele(0,i,nums1[0]+nums2[i]));
        }//��������K���ܳ�����Χ��������Ҫ����
        int realk=Math.min(k, len1*len2);
        for(int i=0;i<realk;i++){
        	Ele tmp=minHeap.poll();
        	list.add(new int[]{nums1[tmp.x],nums2[tmp.y]});
        	if(tmp.x==len1-1) continue;
        	minHeap.offer(new Ele(tmp.x+1,tmp.y,nums1[tmp.x+1]+nums2[tmp.y]));
        }
        return list;
    }
}
class Ele implements Comparable<Ele>{//��һ�����������λ�ú�ֵ����������
int x,y,val;
public Ele(int x,int y,int val){
	this.x=x;
	this.y=y;
	this.val=val;
}
@Override
public int compareTo(Ele other){
	if(this.val>other.val) return 1;
	else if(this.val<other.val) return -1;
	else return 0;
}
}

