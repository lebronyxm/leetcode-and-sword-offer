package test.yang;
//汉诺塔
public class HanTa {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int n=3;
		yidong(n,'A','B','C');
	}
	private static void yidong(int num,char from,char mid,char to){
		
       
		if(num==1){
			System.out.println("从"+from+"移动盘子"+1+"号到"+to);
			
		}
		else{
			//完整的递归是3步，1.将上面的搬到别的地方（中间）。2.将最下面一个搬到目的地（这步体现在输出，其他问题就是正常语句）。
			//3.记住还得将搬到中间的那堆再搬到目的地才算完整的过程。
			yidong(num-1,from,to,mid);	//step1：将上面的N-1个搬到中间
			System.out.println("从"+from+"移动盘子"+num+"号到"+to); //step2：将第N个从from搬到to，这句话相当于一个操作，搬最下面一个盘子到目的地
			yidong(num-1,mid,from,to); //step：再将中间的N-1个搬到to就可以了
		}
	
	}

}

/*
public class HanTa {
  //简单阶乘问题递归
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int n=4;
		int h=jc(n);
		System.out.println(h);
	}
	private static int jc(int n){
		if(n==1)
			{return 1;}
		else
		{
			return jc(n-1)*n;  //调用n-1次的结果，关键是这个结果要和现在的n相乘才行。
		}
	
	}

}
*/