package test.yang;
//N �ʺ�����  N*N�����η�N�Ļʺ󣬲���һ���ߣ���ͬ��ͬ��ͬб�߶�����
//����N������һ���ж����ֿ��ܣ�û����N=2,3ʱ���ͷ���0  N=8��ʱ��92��
public class Nhuanghou {
// �����P239ҳ
	public static void main(String[] args) {
		int N=8;
		Gaoji a=new Gaoji();
		System.out.println(a.num2(N));
	}
	//��ͳ���� �ݹ飬���г���
static	public int num(int N){
		if(N<=0)
			return 0;            //��ʼĬ��ֵ��ȫ0
		int[] weizhi=new int[N];//weizhi[i]=j ��ʾ��i���е�j������
		return jilu(weizhi,N,0);
	}                 //����λ��        N�ʺ�    �ŵڼ���
static	public int jilu(int[] weizhi,int N,int m){
		if(m==N) //���һ���ʺ�ֻ��һ�ֿ���
			return 1;
		int result=0; //���������static
		for(int i=0;i<N;i++){
			boolean yes=put(weizhi,m,i);
			if(yes){
				weizhi[m]=i;//��m�����ڵ�ǰ���е�i��
				result+=jilu(weizhi,N,m+1);
			}//ע�����result�ۼӣ�����ÿ��֮�䣬���ǵ�ǰ�����У��м������ܵ�i��ÿ��i��Ӧ��һ�������ж��ٿ���
		}  //��������һ�м��ֿ���i�����Ӧ�Ŀ�������ӡ������һ��ÿ��λ�ö��У��������ۼ�ÿ��λ�ö�Ӧ�����м��ֿ��ܡ�
		return result;
	}
static	public boolean put(int[] weizhi,int m,int i){
		for(int j=0;j<m;j++){ // (j,wz[j])  ��    (m,i)����б��
			if(weizhi[j]==i || Math.abs(m-j)==Math.abs(weizhi[j]-i)){
				return false;
			}//��һ�������Ͼ�ֱ�Ӳ����ܣ�Ҫreturn
		}
		return true;
	}
}

class Gaoji{//�߼����� ����λ���㣬ֻ�ܼ���1��32�ʺ�  ̫�ѣ�û��Ҫ��
	public int num2(int N){
		if(N<1 || N>32)
			return 0;  //32ʱ��32��1����Ӧ-1   ����������������û����Χ
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