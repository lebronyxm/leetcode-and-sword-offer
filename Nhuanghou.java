package test.yang;
//N 皇后问题  N*N的期盼放N的皇后，不能一条线，即同行同列同斜线都不行
//输入N，返回一共有多少种可能，没有如N=2,3时，就返回0  N=8，时是92种
public class Nhuanghou {
// 左程云P239页
	public static void main(String[] args) {
		int N=8;
		Gaoji a=new Gaoji();
		System.out.println(a.num2(N));
	}
	//传统方法 递归，按行尝试
static	public int num(int N){
		if(N<=0)
			return 0;            //初始默认值是全0
		int[] weizhi=new int[N];//weizhi[i]=j 表示第i行中第j列有棋
		return jilu(weizhi,N,0);
	}                 //已有位置        N皇后    放第几个
static	public int jilu(int[] weizhi,int N,int m){
		if(m==N) //最后一个皇后，只有一种可能
			return 1;
		int result=0; //不能用类的static
		for(int i=0;i<N;i++){
			boolean yes=put(weizhi,m,i);
			if(yes){
				weizhi[m]=i;//第m个放在当前可行的i处
				result+=jilu(weizhi,N,m+1);
			}//注意这个result累加，不是每层之间，而是当前这样行，有几个可能的i，每个i对应着一个下面有多少可能
		}  //所以是这一行几种可行i下面对应的可能数相加。比如第一行每个位置都行，所以是累加每个位置对应后面有几种可能。
		return result;
	}
static	public boolean put(int[] weizhi,int m,int i){
		for(int j=0;j<m;j++){ // (j,wz[j])  和    (m,i)不能斜线
			if(weizhi[j]==i || Math.abs(m-j)==Math.abs(weizhi[j]-i)){
				return false;
			}//有一个不符合就直接不可能，要return
		}
		return true;
	}
}

class Gaoji{//高级方法 利用位运算，只能计算1～32皇后  太难，没必要记
	public int num2(int N){
		if(N<1 || N>32)
			return 0;  //32时是32个1，对应-1   其他就是正常数，没超范围
		int upper= N==32? -1:(1<<N)-1; 
		return jilu(upper,0,0,0);
	}
	public int jilu(int upper,int col,int left,int right){
		if(col==upper)
			return 1;
		int pos=0;
		int mostRight=0;
		pos=upper & (~(col | left | right));
		int result=0;
		while(pos!=0){
			mostRight=pos & (~pos+1);
			pos=pos-mostRight;
			result+=jilu(upper,col|mostRight,(left|mostRight)<<1,(right|mostRight)>>>1);
		}
		return result;
	}
}