package test.yang;

import java.util.*;


//统计 输入多个字符串，一起统计各个字符的个数
public class HashmapZifu{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N=in.nextInt();
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<N;i++){
			String s= in.next();
			list.add(s);
		}
		Tj out=new Tj();
		for(int i=0;i<list.size();i++){
			
			out.tongji(list.get(i));
		}
		System.out.println(out.map);//这种输出按Key=value输出
		Iterator<Character> it= out.map.keySet().iterator();
		while(it.hasNext())
		{
			int temp = out.map.get(it.next());
			System.out.print(temp+" ");
		}
	}
}
class Tj{
	//用不用static都行，反正之建立了一个对象
	 HashMap<Character,Integer> map= new HashMap<Character,Integer>();
	public void tongji(String s){
		if(s==null)
			return;
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(c>='a' && c<='z')
			{
				if(!map.containsKey(c))
				{
					map.put(c, 1);
				}
				else
				{
					int ori= map.get(c);
					map.put(c, ori+1);
				}
			}
		}
		
	}
}
//字符串中不重复的第一个字符
//
//public class HashmapZifu {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		while(in.hasNext()){
//			int N = in.nextInt();
//			ArrayList <String> VS = new ArrayList <String>(); 
//			for(int i=0;i<N;i++){
//				VS.add(in.next());
//			}
//			for(int i=0;i<N;i++){
//				Me (VS.get(i));
//				System.out.print('\n');
//			}
//		
//		}
//		in.close();
//	}
//
//	public static void Me (String str) {
//		HashMap <Character, Integer> Map = new HashMap <Character, Integer>();
//		for (int i = 0; i < str.length(); i++) {
//			char ch = str.charAt(i);
//			if (ch >= 'A' && ch <= 'Z') {
//				if (!Map.containsKey(ch)) {
//					Map.put(ch, 1);
//				} 
//				else{
//					Integer in = Map.get(ch) + 1;
//					Map.put(ch, in);
//				}
//			}
//		}
//	//	System.out.print(Map); 
//		for(int i=0;i<str.length();i++){
//			Character key = str.charAt(i);
//				if(Map.get(key)==1){
//					System.out.print(key);
//					break;
//				}
//             
//			 
//		}
//	}
//}
