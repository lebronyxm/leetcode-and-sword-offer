package test.yang;

//import java.io.FileNotFoundException;
import java.util.*;

public class Huiwen {   //Manacher����
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
        // Ϊ�˱����������ĺ�ż�����ĵĲ�ͬ�������⣬��ԭ�ַ����в���'#'�������л��ı����������
        StringBuilder newStr = new StringBuilder();
        newStr.append("#");
        int length=str.length();
        for (int i = 0; i < length; i ++) {
            newStr.append(str.charAt(i));
            newStr.append("#");
        }        
        // rad[i]��ʾ��iΪ���ĵĻ��ĵ����뾶��i����Ϊ1�������ַ�����
        int newlength=newStr.length(); 
        int [] rad = new int[newlength];
        // right��ʾ��֪�Ļ����У����ҵı߽������
        int right = -1;
        // id��ʾ��֪�Ļ����У�ӵ�����ұ߽�Ļ��ĵ��е�����
        int id = -1;
        // 2.�������е�rad
        // ����㷨��O(n)�ģ���Ϊrightֻ���������while�ĵ�����������������١�         
        for (int i = 0; i < newlength; i ++) {
            // 2.1.ȷ��һ����С�İ뾶
  //���Ĵ��ұ���Ҫ��չ��right = id+r[id]-1����ַ��ġ���ô�������ʱ���ڼ���(id, right]�е�ĳ����x��ʱ��
  //���Է���x�Ĺ���id�ĶԳƵ�x` = 2*id-x�Ļ��Ĵ����Ѿ�������ģ�����x`�Ļ��ĵ����ʣ����Ǽ���x�İ뾶��ʱ��
        	//�Ͳ��ô�1��ʼö�٣����Ǵ�min(r[x`], right-x+1)��ʼö��
            int r = 1;
            if (i <= right) {
                r = Math.min(right-i+1, rad[id<<1 - i]);  //����2 ����λʵ��
            } 
            // 2.2.���Ը���İ뾶
            while ((i - r+1 >= 0 && i + r-1 <= newlength-1) && newStr.charAt(i - r+1) == newStr.charAt(i + r-1)) {
                r++;
            }
            r--;
            // 2.3.���±߽�ͻ�����������
            if (i + r - 1> right) {
                right = i + r - 1;
                id = i;
            }
            rad[i] = r;
        }       
        // 3.ɨ��һ��rad���飬�ҳ����İ뾶
        for (int i=1;i<newlength;i++) {
            if (rad[0] < rad[i]) {
               rad[0]=rad[i];
            }
        }
        return rad[0] - 1;
    }
}

//������ɢ   O(N2)
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
			// ����,������ i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			// ż����������i & i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest.length();
	}
   //�������ģ�����������Ӵ�
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