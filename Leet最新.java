package com.yang;

import java.util.*;

import javax.swing.tree.TreeNode;

//7 reverse digits of an integer 反转整数 7. Reverse Integer
//这题的难点在于int类型是-2147483648范围的，所以如果输入x是这个就越界了，导致0-x还是x没有去掉负号
//所以还要判断一次是否<0 这样复制字符时，去掉第一个负号。还有就是用double保持转后的数字，然后判断，
//如果超过MAX或者MIN，就直接异常返回0；
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
	//下面的方法是网上常见的处理方式，不过还是我上面自己的方法快很多。
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
// 139 动态规划 word-break Given a string s and a dictionary of words dict, determine 
//if s can be segmented into a space-separated sequence of one or more dictionary words.
//思路：长为N的字符，如果长度i可以，那么只要遍历i到N看是否可以组合，有则可以
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
		boolean[] dp=new boolean[length+1];//默认值为false
		dp[0]=true;
		for(int i=0;i<length;i++){ //字符从0到length-1
			if(dp[i]){ //dp正好应该是0到length-1就行，最后一个dp[length],可以在上一次的结果中赋值，所以最后一次不用算
				for(int j=i;j<length;j++){//字符的index
					if(dict.contains(s.substring(i,j+1))){
						dp[j+1]=true;
					}
				}  // s: 0 1 2 3 4 5  length-1   共length个
			}     //dp:0 1 2 3 4 5 6  length   共length+1个   dp[i]表示s[i-1]能否分词 
		}
		return dp[length];
	}
}
*/
//148 sort list  找到链表中点，用merge two sorted lists 思想合并排序 O(1)空间，O(NlogN)时间
/*
public class Leet{
	public static void main(String[] args) {
		
	}
	public ListNode sortList(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode slow=head;//一快一慢，找到中间
		ListNode fast=head;
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode head2=slow.next;
		slow.next=null; //断开成两个部分，不是数组可以判断下标就知道到哪是一半，链表必须断开
		ListNode left=sortList(head);
		ListNode right=sortList(head2);
		return merge(left,right);
	}
	public ListNode merge(ListNode left,ListNode right){//可以递归见sword，也可以循环
	//	if(left==null) 异常处理可以省略，因为上面调用这个函数的时候已经处理过，保证传入的不会是null
		ListNode temp=new ListNode(0);//当作第一个开始往后链接
		ListNode hnew=temp;//保存这个第一个位置，是一个index，最后返回头。不然上面一直向后链接后找不到头了
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
			temp.next=left; //left还有值，比right值多
		}else if(right!=null){
			temp.next=right;
		}
		return hnew.next;//第一个是辅助空间0，所以后一个才是头
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
//91 decode ways  动态规划，和爬楼梯类似  遇到有多少中可能的时候都应该往动态规划哪里想一想
public class Leet{
	public static void main(String[] args) {
		String s="26";  //输入可能是0,有10 20
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
		for(int i=1;i<length;i++){//注意-'0'过程，将char自动改成int,不然char的3可不是int3
			if(ss[i]!='0'){
				if( ss[i-1]!='0' && (ss[i-1]-'0')*10+(ss[i]-'0')<=26){
					fn=f0+f1;
				}else{
					fn=f1;
				}
				f0=f1;
				f1=fn;
			}else{//如果这位为0，那么要判断前一位是否在0<x<=2之间。否则就是不可能
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
//  最长公共子串 即完全相同的  左程云 P216  一般用二维动态规划，其空间是O(MN)，可以采取斜线方向，值要O(1)
/*
public class Leet{  //以（i,j）结尾的字序列
	public static void main(String[] args) {
		String s1="1AB3C4565CD";
		String s2="13C456EF";
		int a=zuichang(s1,s2);
		System.out.println(a);
		System.out.println(zc(s1,s2));
	}
	static public int[][] changdu(char[] s1,char[] s2){//求出二维DP的矩阵
		int len1=s1.length;
		int len2=s2.length;//开头不加容错是调用这个函数时已经处理过了特例
		int[][] dp=new int[len1][len2];
		for(int i=0;i<len1;i++){
			if(s1[i]==s2[0]){
				dp[i][0]=1;
			}
		}
		for(int j=1;j<len2;j++){//j=0的情况上面已经包括了，就是左上角公共元素
			if(s1[0]==s2[j]){
				dp[0][j]=1;
			}
		}
		for(int i=1;i<len1;i++){
			for(int j=1;j<len2;j++){
				if(s1[i]==s2[j]){
					dp[i][j]=dp[i-1][j-1]+1;
				}else{//可以不要这个=0操作，因为数组默认就是0
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
		} //return maxLen;  仅要长度的话，或者直接在上面计算dp的函数中返回就行
		return s1.substring(end+1-maxLen,end+1);
	}
	// 可以采取斜线方向，值要O(1)
	static public int zuichang(String s1,String s2){
		int len1=s1.length();
		int len2=s2.length();
		if(s1==null || s2==null || len1==0 || len2==0){
			return 0;
		}
		char[] cs1=s1.toCharArray();
		char[] cs2=s2.toCharArray();
		int maxLen=0; //记录最大长度
		int row= 0;//斜线开始的行
		int col= len2-1;//斜线开始的列
		int end=0;//记录最长字串的结尾位置
		while(row<len1){
			int i=row;
			int j=col; //从（i,j）开始向右下方遍历
			int nowLen=0;
			while(i<len1 && j<len2){
				if(cs1[i] !=cs2[j]){
					nowLen=0;
				}else{
					nowLen++;
				}
				if(nowLen>maxLen){
					maxLen=nowLen;
					end=i;//用第一个当标准，理论上=j，最后用第二个字符串计算也行
				}
				i++;
				j++;
			}
			if(col>0){//对应第一行的各个斜线，即右上三角
				col--;
			}else{ //左下三角
				row++;
			}
		} //需要返回字符内容，则返回位置就行
		return maxLen; //return s1.substring(end+1-maxLen,end+1);
	}
}
*/ 
/*
//最长公共子序列    这个和上一个区别在于，这个不要求连续，只有是子序列就可以。 依然是使用二维DP
public class Leet{ //左程云 P210
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
		for(int i=1;i<len1;i++){ //第一列，相等为1，不等和前一个一样
			if(s1[i]==s2[0]){
				dp[i][0]=1;
			}else{
				dp[i][0]=dp[i-1][0];
			}
		}
		for(int j=1;j<len2;j++){//第一行，相等为1，不等和前一个一样
			if(s2[j]==s1[0]){
				dp[0][j]=1;
			}else{
				dp[0][j]=dp[0][j-1];
			}
		}
		for(int i=1;i<len1;i++){//（i,j）如果s1[i]!=s2[j]那么（i-1,j）或者（i,j-1）中的大者.
			for(int j=1;j<len2;j++){ //如果相等，那么还可能是(i-1,j-1)+1，再次选择大者
				dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				if(s1[i]==s2[j]){
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-1]+1);
				}
			}
		}
		return dp;//最后一个值就是最长的长度
	}
	static public String zc(String s1,String s2){
		if(s1==null||s2==null||s1.equals("")||s2.length()==0){
			return ""; //一般用长度==0就行，这个只是一种思路
		}
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		int[][] dp=dp(c1,c2);
		int m=c1.length-1;
		int n=c2.length-1;//不仅仅是算出长度，主要是给下面当index
		char[] both=new char[dp[m][n]];
		int index=both.length-1;//作为相同字符的下标记录，从后往前找
		while(index>=0){
			if(m>0 && dp[m][n]==dp[m-1][n]){
				m--;  //m和n的判断先后顺序会影响最终结果，即如果有多种可能的话，选择的序列就不一样
			}else if(n>0 && dp[m][n]==dp[m][n-1]){
				n--;
			}else{
				both[index--]=c1[m];//或者c2[n]
				m--;
				n--;
			}
		}
		return String.valueOf(both);
	}
}
*/
/*
//344 reverse string  我用C++写的
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
//342  power of 4 four  思路：首先是2的次方即只有一个1，其次这个1要是在奇数位（4的次方），即与0101相与大于0.
public class Leet{
	public boolean isPowerOfFour(int num) {
		if((num&(num-1))==0 && (num&0x55555555)>0) //16进制，一个5=0101. 32位正好是8个5
			return true;
		return false;
	}
}
*/
/*
//226 invert binary tree 翻转二叉树
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
//191 number of one bit 1的个数
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
//88  Merge Sorted Array 把数组2合并到数组1中，注意已经排序。思路是从后往前合并，到数组1的后面。这样速度快
public class Leet{
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m+n-1; //总的index，从后往前
        int j1=m-1;//从后往前 数组1的index
        int j2=n-1; //数组2的
        while(j1>=0 && j2>=0)
        {
            nums1[i--]= (nums1[j1]>=nums2[j2])? nums1[j1--]:nums2[j2--];
        }
        while(j2>=0)//2合并到1中，所以只要看2是否有剩下，1不用管
        {
            nums1[i--]=nums2[j2--];
        }
    }
}
*/
/*
//26 Remove Duplicates from Sorted Array 要求不能用额外数组
public class Leet{
    public int removeDuplicates(int[] nums) {
       int len=nums.length;
    	if(len==0)
          return 0;
        int m=1;
        for(int i=1;i<len;i++){//两个index，m是新的不同的数组的元素个数，一个个往后确认，i是原来的
            if(nums[m-1]!=nums[i]){
                nums[m]=nums[i];//要求不仅是返回长度，还要真的去掉重复，这一步就是去掉重复
                m++;
            }
        }
        return m;
    }
}
*/
/*
//299 Bulls and Cows 猜数字 位置相同且值相同是bull  位置不同值相同是cow
//思路：用数组模拟hashmap，统计一共多少个相同的字符，其中位置也相等的就是bull，减去这个bull就是cow
public class Leet{//题目输入规定，只包含数字，且长度相等
	public String hint(String num,String guess){
		int len=num.length();
		if(len<=0 || num==null || guess==null){
			return "invalid";
		}
		char[] s=num.toCharArray();
		char[] g=guess.toCharArray();
		int[] mps=new int[10];//0-9共10个数
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
		return bull+"A"+cow+"B"; //题目要求A代表bull
	}
}
*/
/*
// 371 Sum of Two Integers 不用+-算加法
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
// 258 easy Add Digits 一个非负数，不用循环O(1)时间算出素有位数字之和直到一位数.
//思路：一个数能被9（3）整除，那么各位置数字相加后仍能被9（3）整除。9B+99C+999D+9999E……+A+B+C+D+E……
//即一个数各个位置和，等于这个数对9取余
//或者dr(n) = n-(n-1)/9 *9 = 1+(n-1)-(n-1)/9*9 = 1+(n-1)%9 所以一行代码，return (num-1)%9+1;
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
// 292.easy Nim Game 拿一堆石头每次1-3个，我先，给定个数，能否赢，
//枚举能分析出，谁是4的倍数谁输.不是4的倍数时，可以拿去几个，使成为4的倍数。dp[n]=!dp[n-1] || !dp[n-2] || !dp[n-3]
public class Leet{
	public boolean canwin(int n){
		if(n<=0)
			return false;//容错可以不加
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
//283. Move Zeroes 只准在原数组上操作   思路：定义一个index作为最终数组的下标，那么非0的一个个往后赋值
//直到整个数组遍历结束，这时将剩下的全部置0
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
        if(p==null || q==null){//这样简化了3次判断，同时null则true，只一个null则false
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
//242. Valid Anagram 同字母不同顺序的单词 （完全相同的也算好像）
public class Leet {
    public boolean isAnagram(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        if(len1!=len2) return false;
        int[] map=new int[26];//字母的Map数组
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        for(int i=0;i<len1;i++){
            map[ss[i]-'a']++;
        }//思路：统计第一个词+1次数，然后遍历第二词-1次数
        for(int i=0;i<len1;i++){
            if(map[tt[i]-'a']==0)//s中已经没了，t中又出现，则false
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
//169. Majority Element 非空数组存在次数超过一半（n/2）的为主要元素，
public class Leet{//思路：相同+1，不同-1，最后剩下的肯定是超过一半的。相当于一次消掉2个
	public int mje(int[] s){
		int len=s.length;
		if(len==0|| s==null)
			return 0;
		int mj=s[0];//第一个当默认
		int time=1;
		for(int i=1;i<len;i++){//i直接从第二个开始
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
//217. Contains Duplicate 判断数组是否有重复数字，用hashMap或者set都行
public class Leet{
	public boolean dup(int[] s){
		int len=s.length;
		if(len==0 || s==null)
			return false;
		HashSet<Integer> hs=new HashSet<>();
		for(int i=0;i<len;i++){
			if(!hs.add(s[i]))//add函数当set中存在这个数就返回false
				return true;
		}
		return false;
	}
}
*/
/*
//350. Intersection of Two Arrays II 返回数组相同部分 nums1=[1,2,2,1], nums2=[2, ],return[2,2]
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
//349. Intersection of Two Arrays  返回一个次就行
public class Leet{//思路：可以用hashmap，这里用hashset，利用remove性质
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
            if(hs.remove(nums2[j])){//remove返回ture，说明有这个元素
                res[index++]=nums2[j];
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
*/
/*
// 13. Roman to Integer  //：Ⅰ（1）Ⅴ（5）Ⅹ（10）L（50）C（100）D（500）M（1000） 
// rules:位于大数的后面时就作为加数；位于大数的前面就作为减数（只有I、X、C。比如45不可以写成VL，只能是XLV）
//eg：Ⅲ=3,Ⅳ=4,Ⅵ=6,ⅩⅨ=19,ⅩⅩ=20,ⅩLⅤ=45,MCMⅩⅩC=1980
//思路，用HashMap或者数组存好这些字母对应的数字。然后从后往前或者从前往后遍历字母。记录一个sum
//（后往前）遇到前面比后面小的则减去，反之则加上。（前往后）遇到后面比前面大则减去2倍反之加
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
//326. Power of Three 思路：1：最大的int类3的次方是1162261467，能被它整除肯定是。
//2：借助log函数 log10(n)/log10(3)是整数则可以.不用log代替log10，因为log(243)/log(3)会出错
public class Leet{
	public boolean ispow(int n){
	//	return n > 0 && (1162261467 % n == 0);
	    return n>0 && (Math.log10(n)/Math.log10(3))%1==0;
	}
}
*/
/*
//235. Lowest Common Ancestor of a Binary Search Tree
//最低祖先，注意Node本身也是自己的祖先
public class Leet{
	TreeNode lowcom(TreeNode root,TreeNode p,TreeNode q){
		if(root==null || p==null || q==null)
			return null;
		if((root.val-p.val)*(root.val-q.val)<=0)//自身当祖先
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
//263. Ugly Number  与剑指offer34类似，这个是判断，那个是生成
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
//202. Happy Number 各位平方相加直到等于1如19，或者循环
//思路：用HashSet或者table存下平方和，如果有了就false，没有就继续算.
//2:类似于检测链表有环，一个数，分别算一次和2次，直到两个相等。检查最后相等的值是不是1
public class Leet{
	public boolean isHappy(int n){
		if(n==0) return false;
		HashSet<Integer> hs=new HashSet<>();
		int sum=0,low=0;
		while(hs.add(n)){//能存，则不重复
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
	//环的思路也不错
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
//类似sword57，那个是返回2->4即重复的全删除。无序时左程云P71,用hashset存值，循环就行
//可以递归，也可以循环
public class Leet{
	public ListNode delrecursive(ListNode head){
		if(head==null || head.next==null)
			return head;
		head.next=delrecursive(head.next);//head.next=很重要，不是随便新建一个引用就行
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
//121. Best Time to Buy and Sell Stock  [7, 1, 5, 3, 6, 4] 输出5=6-1， 不好赚就是0
//可以用DP，第i天最大利润是dp[i],那么i+1天利润就是dp[i]或者第i+1天价格减去前i天最小值。
//等效为求最大子数组和的问题，因为上面就是就是找一个连续数组m，求m[n]-m[0]值最大，那么把原数组构造
//成后一个减前一个得到新数组，那么原问题就变成在新数组中连续和最大问题。
class Leet{
	public int buy(int[] s){
		int len=s.length;
		if(len<2) return 0;
		int max=0,newsum=0;//max是保持目前为止最大利润，newsum是每一个可能的子数组开始累积和
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
			if(left<right){//这里的判断可以不要，因为即使是相等，交换也无所谓
				char temp=ss[left];
				ss[left]=ss[right];
				ss[right]=temp;
				left++;
				right--;
			}else{//这里返回也可以不要，因为下一次肯定不符合大循环
				return String.valueOf(ss);
			}
		}
		return String.valueOf(ss);
	}
}
*/
/*
//24. Swap Nodes in Pairs   1->2->3->4, as 2->1->4->3. 两两交换链表
class Leet{
	//递归方法
	public ListNode swap(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode temp=head.next;
		head.next=swap(head.next.next);
		temp.next=head;
		return temp;
	}
	//循环
	public ListNode swap2(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode cur=dummy;
		while(cur.next!=null && cur.next.next!=null){
			ListNode fir=cur.next;
			ListNode sec=cur.next.next;
			cur.next=sec;//这几个点画图理解过程
			fir.next=sec.next;
			sec.next=fir;
			cur=cur.next.next;
		}
		return dummy.next;
	}
}
*/
/*
//198. House Robber 求非连续子数组最大和，DP求解。maxV[i] = max(maxV[i-2]+num[i], maxV[i-1])
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
//107 102 Binary Tree Level Order Traversal II 按行打印二叉树，上往下或向往上
class Leet{
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> list=new ArrayList<Integer>();
            int size=que.size();//用这个方法比左程云的判断最后一个Node好
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
//27 Remove Element  nums = [3,2,2,3], 去掉val = 3 返回2，且数组前面是2，2
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
//66. Plus One 数组组成的数字加1, 从后往前不是9则+1直接返回，9就变0进位，
//如果全是9，数组要加一位1，后面全是0
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
//118. Pascal's Triangle 输入5得到 [1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]
class Leet{
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listlist=new ArrayList<List<Integer>>();
        if(numRows<1)  return listlist;
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<numRows;i++){
            list.add(0,1);
            for(int j=1;j<list.size()-1;j++){//第一个最后一个一只是1不用算
                list.set(j,list.get(j)+list.get(j+1));//set是代替，add是插入
            }
            listlist.add(new ArrayList<Integer>(list));
        }
        return listlist;
    }
}
*/
/*
//119. Pascal's Triangle II输入K，输出地K行，要求 O(k)空间 k=3 有[1,3,3,1].
class Leet{
	public List<Integer> getRow(int n) {
        List<Integer> list=new ArrayList<Integer>();
        if(n<0) return list;
        list.add(0,1);
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=1;j--){
                list.set(j,list.get(j-1)+list.get(j));
            }    //之前那道题，放在循环前面，1也加在前面。本质不要覆盖数组。
            list.add(1);//加在最后,放在上面循环后面。
        }
        return list;
    }
}
*/
/*
//172. Factorial Trailing Zeroes 求N阶乘有多少0，
//对N阶乘做质因数分解，即2^k*3^m*5^n. 则2和5的次方少的那个就是0的个数。5是少的那个
//所以个数就是n/5的个数和n/5/5, n/5/5/5...直到0
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
//9. Palindrome Number 不用额外空间，判断数字是否是回文，即不能转换成字符串
class Leet{
	public boolean isP(int x){
		if(x<0 || (x!=0 && x%10==0)) return false;
		int right=0;
		while(x>right){//计算到一半长度即可。
			right=right*10+x%10;
			x/=10;
		}     // 偶数位                  奇数位
		return (x==right || x==right/10);
	}
}
*/
/*
//112. Path Sum 和为某一值路径和 见offer25
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
//36. Valid Sudoku 判断数独是否可行,不需要可解，只要已经有的数字，每行每列每个9宫格都没重复数就行
//思路：对每一个元素标记，如s[2][3]=5;那么遍历到5时，往Set中提交3个元素，一个是3列5，2行5，第一个
//九宫格的5.这样只要遍历一次整个数组就行。
class Leet{//空的书用‘.’表示
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
//374. Guess Number Higher or Lower  1-n的数，考察二分查找
class Leet{//已有API返回是大1是小-1
	public int guessNumber(int n){
		int low=1;
		int high=n;
		while(low<high){
			int mid=low+((high-low)>>1);//移位一定要加括号
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
class Leet{//注意是到叶节点（左右均为null）才算结束
	public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) return minDepth(root.right)+1;
        if(root.right==null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
*/
/*
//225. Implement Stack using Queues 只要一个就行，push后逆序一下
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
//223. Rectangle Area 两个矩形总面积，给左下右上点坐标
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
//思路就是用HashMap或者模拟的HM，每次加这个Key时检查对应的Value是否一样，不一样则false，一样就
//设置新的value，HashMap的put函数会返回要加的Key对应的前一次Value
class Leet{
	public boolean isIsomorphic(String s, String t) {
        int[] m1=new int[256];
        int[] m2=new int[256];
        int len=s.length();
        for(int i=0;i<len;i++){
            if(m1[s.charAt(i)]!=m2[t.charAt(i)])
                return false;
            m1[s.charAt(i)]=i+1;//+1是如果第一个则为0与数组
            m2[t.charAt(i)]=i+1;//默认值会混淆
        }
        return true;
    }
	public boolean isIsomorphic2(String s, String t) {
        HashMap<Character,Integer> m1=new HashMap<>();
        HashMap<Character,Integer> m2=new HashMap<>();
        int len=s.length();
        for(Integer i=0;i<len;i++){//注意是Integer不是int，有自动装箱的问题
            if(m1.put(s.charAt(i),i)!=m2.put(t.charAt(i),i))
                return false;//put返回这个Key上一次的Value，无则返回null
        }
        return true;
    }
}
*/
/*
//160. Intersection of Two Linked Lists 剑指上也有
class Leet{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;//传统先算出长度差，长的走完差值
        ListNode a=headA;//再两个一起走到相同
        ListNode b=headB;
        while(a!=b){//巧妙达到自动走完长度的差值
            a= a==null? headB:a.next; //一个走到尾就跳
            b= b==null? headA:b.next;//到另一个头部
        }
        return a;
    }
}
*/
/*
//219. Contains Duplicate II 给个数组和长度K，返回是否数组存在s[i]=s[j],j-i<=K
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
//19. Remove Nth Node From End of List 删除倒数第N的结点，关键在增加一个头结点
class Leet{
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        if(head==null) return head;
	        ListNode dummy=new ListNode(0);
	        dummy.next=head;//加一个头，可以不用再考虑删除头的特殊情况
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
        }//这题思路和判断两个字符串Isomorphic Strings那题一样
        return true;
    }
}
*/
/*
//257. Binary Tree Paths  DFS所有路径 ["1->2->5", "1->3"]
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
        s.append(root.val);//一定要先加，不能在下面返回时或者dfs函数中加
        if(root.left==null && root.right==null){
            list.add(s.toString());
        }else{
            s.append("->");//一定要在if前先加好，
            if(root.left!=null)
            dfs(root.left,s,list);//不能在函数参数里加
             if(root.right!=null)//必须要使得下面dfs函数遇到的s情况一样
            dfs(root.right,s,list);//如果在函数中加，那么下一个和上一个不一样
        }
        //如果用String，则不用回溯，因为每次都是新开的，不用担心会保留上一条路径
        s.setLength(len);//回溯去掉后面的路径
    }
}
*/
/*
//20. Valid Parentheses "()[]{}" are all valid but "(]" and "([)]" are not
class Leet{//思路就是用stack就行
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
//38. Count and Say 1, 11, 21, 1211, 111221数数的方式成为下一个数，用递归,返回第N个数
class Leet{
	public String countAndSay(int n) {
        if(n<=0) return "";
        if(n==1) return "1";
        String s=countAndSay(n-1);
        char[] c=s.toCharArray();
        int len=c.length;
        StringBuffer sb=new StringBuffer();
        int i=0;
        while(i<len){//cnt表示数出现的次数
            int cnt=1;//一定在大循环里面每次从1开始
            while(i<len-1 && c[i]==c[i+1]){
                i++;
                cnt++;
            }  //考察递归，每次字符增加 X的次数＋X本身
            sb.append(String.valueOf(cnt)).append(c[i]);
            i++;
        }
        return sb.toString();
    }
}
*/
/*
//58. Length of Last Word 最后一个词的长度"Hello World",则为5
class Leet{//输入是大小写字母加空格
	public int llw(String s){
		//下面一句就可以，trim函数截去字符串开头和末尾的空白
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
//返回 2 --> 3 --> 4 --> 5
class Leet{//删除链表时往往加一个头，处理边界
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
//190. Reverse Bits给32位无符号int，返回其二进制反转后对应的int数
class Leet{//思路和10进制一样×10和/10变成移一位而已
	public int revbit(int n){
		if(n==0) return 0;
		int result=0;
		for(int i=0;i<32;i++){
			result=result<<1;//相当于乘以2，（对应10进制的10）
			result=result+(n&1);//加上n的最后一位
			n=n>>1;
		}
		return result;
	}
}
*/
/*
//234. Palindrome Linked List 判断链表是否是回文,思路反转一半后再比较
class Leet{//O(n) time and O(1) space
	public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        }
        if(fast!=null)//奇数个时，fast在最后一个上，而slow在中间
        	slow=slow.next;//让slow在后一半的开头
        slow=reverse(slow);//反转slow开头的后一半
        while(slow!=null){
        	if(slow.val!=head.val)
        		return false;
        	else{
        		slow=slow.next;
        		head=head.next;
        	}
        }
        return true;
    }//下面是简单的反转链表
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
//190. Reverse Bits 给一个数3把它对应的32位2进制反转后对应的数字输出。
class Leet{
	public int reverseBits(int n) {
        if(n==0) return 0;
		int result=0;
		for(int i=0;i<32;i++){
			result=result<<1;//相当于乘以2，（对应10进制的10）
			result=result+(n&1);//加上n的最后一位
			n=n>>1;
		}
		return result;
    }
}
*/
/*
//14. Longest Common Prefix 一堆字符串的公共前缀
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
////1. Two Sum 在数组中找出2个数和等于特定值，只有一组
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
//		while(i>=0 || j>=0 ||carry==1){//直接a.charAt(i--)-'0'也行
//			aa= (i>=0)? Integer.valueOf(a.charAt(i--)+""):0;
//			bb= (j>=0)? Integer.parseInt(b.charAt(j--)+""):0;
//			int sum=aa^bb^carry;
//			carry= ((aa+bb+carry)>=2)? 1:0;
//			sb.append(sum);
//		}
//		return sb.reverse().toString();
//	}
//}
//// 28. Implement strStr()  就是第一次出现的位置，indexOf
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
////303. Range Sum Query - Immutable 动态规划，题目很简单求一个数组指定下标范围内的和
////要求是多次调用这个函数，所以肯定是先计算好所有从0到i的和存在n[i]里，然后n[j]-n[i]就是结果
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
////204. Count Primes <n的所有质数即素数
//class Leet{
//	public int countPrimes(int n) {
//        if(n<=2) return 0;
//        boolean[] notpri=new boolean[n];//默认false，都是prime
//        int cnt=n>>1;//n以内偶数不用看，去掉一半
//        for(int i=3;i*i<n;i+=2){//只看奇数
//            if(!notpri[i]){
//                for(int j=i*i;j<n;j+=2*i){//只看奇数，j是奇数i是奇数只有＋2i才行
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
////6. ZigZag Conversion  Z形打印一串字符，按行输出
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
//            }//直下第1到第row行
//            for(int id=numRows-2;id>=1 && i<len;id--){
//                sb[id].append(c[i++]);
//            }//斜上第row-1到第2行
//        }
//        for(int id=1;id<numRows;id++){
//            sb[0].append(sb[id]);
//        }
//        return sb[0].toString();
//    }
//}
////10. Regular Expression Matching hard难度的,剑指offer53
//class Leet{
//	 boolean match(char[] s, char[] p){
//	        return isMatch(s,0,p,0);
//	    }	 
//	 public boolean isMatch(char[] s,int start1,char[] p,int start2){
//		 int lens=s.length;
//		 int lenp=p.length;
//		 if(start1==lens&&start2==lenp) return true;
//		 if(start2>=lenp) return false;//只有pattern结束了才能结束整个过程，字符结束要继续看pattern可能仍能匹配
//		 if(start2<lenp-1){
//			 if(p[start2+1]=='*'){//对应1
//				 if((start1<lens)&&(s[start1]==p[start2]||p[start2]=='.')){
//					 return isMatch(s,start1,p,start2+2)||isMatch(s,start1+1,p,start2+2)||isMatch(s,start1+1,p,start2);
//				 }else return isMatch(s,start1,p,start2+2);//不等的话，只能是*当0次
//			 }
//		 }
//		 if(start1==lens) return false;
//		 if(s[start1]==p[start2]||p[start2]=='.')//对应2
//			 return isMatch(s,start1+1,p,start2+1);
//		 return false; //对应3       
//	 }
//}
////65. Valid Number hard级别难度 剑指offer上54题
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
////125. Valid Palindrome只看数字字母不分大小写 "A man, a plan, a canal: Panama" is a palindrome.
//class Leet{//思路简单，就是前后遍历判断。
//	public boolean isPalindrome(String s) {
//        int len=s.length();
//        if(len==0) return true;
//        char[] c=s.toCharArray();
//        int left=0;
//        int right=len-1;
//        while(left<right){//有现成的判断字母数字函数
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
////278. First Bad Version 对1到n，可以判断哪一个是坏的，求第一个坏的，就是二分。
//class Leet{//注意二分mid的计算用left+((right-left)>>1)比（left+right)/2安全，后者可能越界
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
////168. Excel Sheet Column Title和171题相反，其它进制转10进制，用位×进制的次方。反过程就用短除法，同二进制
//class Leet{//这种对应里没有0，所以Z%26=0，A%26=1，有点乱。不如n-1这样是0到25对应A到Z
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
////和剑指offer字符串旋转那2题一样。先各部分反转，再全部反转
//class Leet{
//	public void rotate(int[] nums, int k) {
//        int len=nums.length;
//        if(len<=1||k<0) return;
//        int realk=k%len;//超过长度也考虑
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
////165. Compare Version Numbers 就是按版本大小比较0.1 < 1.1 < 1.2 < 13.37<15.1.3   4.5.6>4>3.4
//class Leet{//思路可以用split("\\.");分成各个部分，再比较。"."代表任意字符，所以转义\.非法，所以\\.
//	public int compareVersion(String version1, String version2) {
//        int len1=version1.length();//最底层思路，直接遍历比较就行
//        int len2=version2.length();
//        int idx1=0,idx2=0;
//        while(idx1<len1 || idx2<len2){
//        	int sum1=0,sum2=0;
//        	while(idx1<len1 && version1.charAt(idx1)!='.'){//也可以用下面得到数字
//        		sum1=sum1*10+(version1.charAt(idx1)-'0');//Integer.parseInt或者valueOf
//        		idx1++;
//        	}
//        	while(idx2<len2 && version2.charAt(idx2)!='.'){
//        		sum2=sum2*10+(version2.charAt(idx2)-'0');
//        		idx2++;
//        	}
//        	if(sum1>sum2) return 1;
//        	else if(sum1<sum2) return -1;
//        	else{//上面已经在'.'这位了，再+1就可以。如果有一个长度没了，就一直是0；
//        		idx1++;
//        		idx2++;
//        	}
//        }
//        return 0;
//    }
//}
////8. String to Integer (atoi)转化到整数，所以只有+-数字合法，其他都不合法
//class Leet{//思路同reverse Integer以及valid number注意越界处理。
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
//        	}//int在-2...48到2...47之前，如果大于7肯定就是最大值
//        	sum=sum*10+(s.charAt(idx++)-'0');
//        }
//        return sign*sum;
//    }
//}
//////////======上面easy，下面middle===============
////338. Counting Bits 给出0到n每个数二进制中有多少个1.思路不是求一个数的方法n&(n-1)
////思路是，类似动态规划，偶数2n和他的一半n有相同个数，因为n<<1=2n;奇数再加1就行
//class Leet{
//	public int[] countBits(int num) {
//        int[] ones=new int[num+1];
//        for(int i=1;i<=num;i++){
//            if((i&1)==0)//偶数，4=2<<1;
//                ones[i]=ones[i>>1];
//            else //奇数，7=(3<<1)+1;
//                ones[i]=ones[i>>1]+1;
//        }//可以优化合起来，就是ones[i]=ones[i>>1]+(i&1);
//        return ones;
//    }
//}
////260. Single Number III 同剑指offer40题，用n&(-n)得到右边第一个不为0的位
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
//            all=all>>>1;//不能用>>,否则all=-1时，一直!=0...
//            ind++;
//        }//以后用下面的方法得到最右边不等于1的位置，只有那一位=1，其余=0
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
////238. Product of Array Except Self同剑指offer52，可以用剑指的思路，这里优化用O(1)空间
//class Leet{
//	public int[] productExceptSelf(int[] nums) {
//        int len=nums.length;
//        int[] res=new int[len];
//        res[0]=1;
//        for(int i=1;i<len;i++){//得到左边所有乘积
//        	res[i]=res[i-1]*nums[i-1];
//        }
//        int right=1;//把右边所有乘积每次更新在right上，和res[i]相乘即可
//        for(int i=len-1;i>=0;i--){
//        	res[i]=res[i]*right;//左边所有×右边所有
//        	right=right*nums[i];
//        }
//        return res;
//    }
//}
////122. Best Time to Buy and Sell Stock II 这次可以多次买卖。但其实更简单，只要把所有利润都赚了即可
////即只有后一次比前一次大，则买好卖。否则跳过。
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
////347. Top K Frequent Elements 数组出现次数最多的K个数，要求时间优于O(NlogN）
////思路可以先HashMap统计，再用小顶堆或PriorityQueue（把数字和次数组合为整体存入，重写比较器）
////更好的思路：用桶排序,前面还是HM统计，不过不用上面的方法找出TOP
//class Leet{
//	public List<Integer> topKFrequent(int[] nums, int k) {
//        HashMap<Integer,Integer> hm=new HashMap<>();
//        for(int i:nums){//8新方法,没有Key则返回默认0
//            hm.put(i,hm.getOrDefault(i,0)+1);
//        }
//        int len=nums.length;//桶排序+1是次数从1开始数组从0开始
//        ArrayList<Integer>[] bucket=new ArrayList[len+1];
//        for(Integer key:hm.keySet()){//注意上面数组生成方式不能有<>()等
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
////343. Integer Break 给一个2到58的整数，分解成至少2个数，求乘积最大的结果n=10,return36(10=3+3+4).
////当f >= 4时2*(f-2)=2f-4>=f，所以永远不用分解4以上，那只有1，2，3.1肯定不行，比较2和3，由于2×2×2<3*3所以
////永远不用超过3个2，因此，优先考虑3，然后2。一共3种情况，3n，3n+2，3n+2+2
//class Leet{
//	public int interbreak(int n){
//		if(n==2) return 1;
//		if(n==3) return 2;
//		if(n%3==0) return (int)Math.pow(3, n/3);
//		if(n%3==1) return 2*2*(int)Math.pow(3, (n-4)/3);
//		else return 2*(int)Math.pow(3,(n-2)/3);
//	}
//}
////268. Missing Number Given nums = [0, 1, 3] return 2. 0-n 少一个数，返回
//class Leet{//两种方法
//	 public int missingNumber(int[] nums) {
//	        int len=nums.length;
//	        int xor=0,i=0;
//	        for(i=0;i<len;i++){
//	            xor=xor^i^nums[i];
//	        }//和下标异或
//	        return xor^i;//i=len
//	    }
//	 public int missingNumber2(int[] nums) {
//	        int len=nums.length;
//	        int sum=0,i=0;
//	        for(i=0;i<len;i++){
//	            sum+=i-nums[i];
//	        }//1-n的和减去数组和得到miss
//	        return sum+i;
//	    }
//}
////94. Binary Tree Inorder Traversal中序，递归太简单，用循环
//class Leet{
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list=new ArrayList<Integer>();
//    	if(root==null) return list;
//    	Stack<TreeNode> s=new Stack<>();
//    	TreeNode cur=root;//当前为空即叶子下的，或者没有右节点时要看stack还有就继续
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
////319. Bulb Switcher n个灯泡，初始全关，第1次全开，第2次关所有第二个即2，4，6.第3次切换第3个，即3，5，7.。。
////第n次只切换最后一个，求第n次后那些灯还开着。[0, 0, 0].[1,1,1].[1,0,1].[1,0,0]返回1
////相当于，一开始全关的灯，然后i从1到n，吧i的倍数的都切换一次。最后剩哪一个灯，初中题：根号n下取整的那个.
////Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4.
////Except when i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, 
////and double divisor 6. So bulb i ends up on if and only if i is a square
//class Leet{
//	public int laston(int n){
//		if (n<=0) return 0;
//		return (int)Math.sqrt(n);
//	}
//}
////144. Binary Tree Preorder Traversal 前序遍历，循环
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
//378. Kth Smallest Element in a Sorted Matrix  升序矩阵找第K大数，比查找难，需要用堆记录
//思路用minHeap，存一行，然后从列开始一个个加入比较。总之左上角的元素都比较才行。
//class Leet{
//	public int kthSmallest(int[][] matrix, int k) {
//        int len=matrix.length;
//        PriorityQueue<Ele> minHeap=new PriorityQueue<>();
//        for(int i=0;i<len;i++){
//        	minHeap.offer(new Ele(0,i,matrix[0][i]));
//        }
//        for(int i=0;i<k-1;i++){//弹k-1次
//        	Ele tmp=minHeap.poll();
//        	if(tmp.x==len-1) continue;
//        	minHeap.offer(new Ele(tmp.x+1,tmp.y,matrix[tmp.x+1][tmp.y]));
//        }
//        return minHeap.peek().val;
//    }
//}
//class Ele implements Comparable<Ele>{//定一个类包含矩阵位置和值，这样方便
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
//373. Find K Pairs with Smallest Sums两个升序数组找和前K小的每对。本题与上一题方法一样
class Leet{//上题矩阵s[m][n]就是这题数组a[m]+b[n]的和，那完全一样的方法
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Ele> minHeap=new PriorityQueue<>();
        int len1=nums1.length, len2=nums2.length;
        List<int[]> list=new ArrayList<int[]>();
        if(len1==0 || len2==0 || k<=0) return list;
        for(int i=0;i<len2;i++){//注意是len2，列是2的数量
        	minHeap.offer(new Ele(0,i,nums1[0]+nums2[i]));
        }//本题输入K可能超出范围，所以需要限制
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
class Ele implements Comparable<Ele>{//定一个类包含矩阵位置和值，这样方便
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

