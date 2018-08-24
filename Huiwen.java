package test.yang;

//import java.io.FileNotFoundException;
import java.util.*;

public class Huiwen {   //Manacher方法
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			ArrayList<String> list = new ArrayList<String>(N);
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				list.add(s);
			}
			for (int i = 0; i < N; i++) {
				System.out.println(getlength(list.get(i)));
			}
		}
	}
    public static int getlength(String str) {
        // 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文
        StringBuilder newStr = new StringBuilder();
        newStr.append("#");
        int length=str.length();
        for (int i = 0; i < length; i ++) {
            newStr.append(str.charAt(i));
            newStr.append("#");
        }        
        // rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
        int newlength=newStr.length(); 
        int [] rad = new int[newlength];
        // right表示已知的回文中，最右的边界的坐标
        int right = -1;
        // id表示已知的回文中，拥有最右边界的回文的中点坐标
        int id = -1;
        // 2.计算所有的rad
        // 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。         
        for (int i = 0; i < newlength; i ++) {
            // 2.1.确定一个最小的半径
  //回文串右边是要延展到right = id+r[id]-1这个字符的。那么我们这个时候在计算(id, right]中的某个点x的时候，
  //可以发现x的关于id的对称点x` = 2*id-x的回文串是已经计算过的，利用x`的回文的性质，我们计算x的半径的时候，
        	//就不用从1开始枚举，而是从min(r[x`], right-x+1)开始枚举
            int r = 1;
            if (i <= right) {
                r = Math.min(right-i+1, rad[id<<1 - i]);  //乘以2 用移位实现
            } 
            // 2.2.尝试更大的半径
            while ((i - r+1 >= 0 && i + r-1 <= newlength-1) && newStr.charAt(i - r+1) == newStr.charAt(i + r-1)) {
                r++;
            }
            r--;
            // 2.3.更新边界和回文中心坐标
            if (i + r - 1> right) {
                right = i + r - 1;
                id = i;
            }
            rad[i] = r;
        }       
        // 3.扫描一遍rad数组，找出最大的半径
        for (int i=1;i<newlength;i++) {
            if (rad[0] < rad[i]) {
               rad[0]=rad[i];
            }
        }
        return rad[0] - 1;
    }
}

//中心扩散   O(N2)
/*
public class Huiwen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			ArrayList<String> list = new ArrayList<String>(N);
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				list.add(s);
			}
			for (int i = 0; i < N; i++) {
				System.out.println(longsub(list.get(i)));
			}
		}
	}
	
	public  static int longsub(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		String longest = s.substring(0, 1);
		int length=s.length();
		for (int i = 0; i < length; i++) {
			// 奇数,中心是 i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			// 偶数，中心是i & i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest.length();
	}
   //给定中心，返回最长回文子串
	public static String helper(String s, int left, int right) {
		int  length=s.length();
		while (left >= 0 && right <= length - 1
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		String subS = s.substring(left + 1, right);
		return subS;
	}

}
*/