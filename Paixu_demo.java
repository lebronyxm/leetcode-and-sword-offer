package yang.paixu;

import java.util.*;

public class Paixu_demo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a={2,5,8,4,267,8,23,1,4,3,-6,-8,46,234,78,2,1,45};
		//Xuanze.sort(a);
		//Maopao.sort(a);
		//Charu.sort(a);
		//Kuaisu.sort(a,0,a.length-1);
		//Shell.sort(a);
		//Dui.sort(a);
		Merge.sort(a, 0, a.length-1);
	//	System.out.println(Arrays.toString(a)); //����������������������ţ�ֱ��дa��ӡ�����ǵ�ַ
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"  ");
		}
		System.out.println();
		Bfind.find(0, a.length-1, 23, a);
		MaxMin A=new MaxMin();
		//A.getm(a); //�������У���Ϊ�ҵ��ڲ����Լ���������static�����Բ�����MaxMin�Ķ���ȥ���ã���Ӧ��ֱ����������
		MaxMin.Result B=new MaxMin.Result();
		B=MaxMin.getM(a);
		System.out.println(B.max+"  "+B.min);
		System.out.println(MaxMin.getM(a).getMax());//�������ַ�ʽ����Ҳ�У����ô�������B

	}

}
//�ڲ���Ѱ��������ֵ
class MaxMin{
	public static class Result{
		int max;
		int min;
		public Result(){
			
		};
		public Result(int max, int min){
			this.max=max;
			this.min =min;
		}
		public int getMax(){
			return this.max;
		}
		public int getMin(){
			return min;
		}
	}
	public static Result getM(int [] s){
		int maxs=s[0];
		int mins=s[0];
		for(int i=1;i<s.length;i++)
		{
			if(s[i]<mins)
				mins=s[i];
			if(s[i]>maxs)
				maxs=s[i];
		}
		return new Result(maxs,mins);
	}
}

//���ֲ���
class Bfind{  //�����õݹ�ʵ�֣�Ҳ������ѭ��ʵ�֡�
	public static void find(int left,int right, int x,int[] s){
		if(left>right)
			return;
		int m = (left + right) >> 1;
		int mid = s[m];
			if(mid==x)
			{
				System.out.println("�ҵ�λ�ã��±�Ϊ��"+m);
			}
			else if(mid>x)
			{
				find(left,m-1,x,s);
			}
			else
			{
				find(m+1,right,x,s);
			}
	}//������ѭ��ʵ��,�����±�ֵ
	public static int find(int x,int[] s){
		int len=s.length;
		if(s==null || s==0) return -1;
		int low=0,high=len-1;
		while(low<=high){//�����һ��Ҫ�ӣ�ֻ����ֵ��x�������ﷵ�أ�����ʹlow��highҲ��������������x
			int mid=low+((high-low)>>1);  //ҲҪ���أ�1��û�ҵ���
			if(s[mid]==x) return mid;
			if(s[mid]>x)
				high=mid-1;
			else 
				low=mid+1;
		}
		return -1;
	}
}

//�������� base ����˼�룺�����д��Ƚ���ֵ����������ͳһΪͬ������λ���ȣ���λ�϶̵���ǰ�油�㡣
//Ȼ�󣬴����λ��ʼ�����ν���һ���������������λ����һֱ�����λ��������Ժ�,���оͱ��һ���������С�
//�е���hashmap�Ľṹ�����ݼ��������http://www.cnblogs.com/liuling/p/2013-7-24-01.html

//�鲢���� merge  ��������������ʱ���鲢����O(1)�ռ�������leetcode sort list
class Merge{
	public static void sort(int [] s,int left,int right){
		if(left<right){
			int middle = (left+right)>>1;
			sort(s,left,middle); //��ߵݹ�
			sort(s,middle+1,right);//�ұߵݹ�
			mer(s,left,middle,right);//�ϲ�
		}
	}
	public static void mer(int[] s,int left,int middle,int right){
		int[] tmpArr =new int[s.length];//����ռ�O(n),��������㺯���д���������飬�����������롣���ĳ�����ʵ����right-left+1
		int tmp3=left;//���������ָ��                  //���ǲ�������������������Ϊ����Ȼ��������ô��������left��Щֵ�����Ǻܴ�ģ�����Ҫ����ſ���
		int rm=middle+1; //�ұߵĿ�ʼλ��	
		int temp=left;  //ָ�룬��������潫����õ�������õ�tmpArr���鸴�Ƶ�����ԭ��������s��
		while(left<=middle && rm<=right){
			if(s[left]<=s[rm]){//����������������ѡȡ��С���������м�����
				tmpArr[tmp3++]=s[left++];
			}else{
				tmpArr[tmp3++]=s[rm++];
			}
		}
		//�� ������� ʣ��Ĳ��ַ����м����飬�����߲�һ������˭ʣ�£�˭���ŷ�
		while(left<=middle){
			tmpArr[tmp3++]=s[left++];
		}
		while(rm<=right){
			tmpArr[tmp3++]=s[rm++];
		}
	//	int temp=left; //���ָ�벻�ܷ����⣬��Ϊ����left�Ѿ�����ԭʼ�����鿪ʼλ���ˣ�����Ҫ��ǰ�涨��
		while(temp<=right){
			s[temp]=tmpArr[temp];
			temp++;
		}
	}
}

//������  heap
class Dui{
	public static void sort(int[] s){
		int length=s.length;
		for(int i=0;i<length-1;i++){//n-1��ѭ������
			maxHeap(s,length-1-i); //����
			int temp=s[0];  //�����Ѷ������һ��Ԫ��  
			s[0]=s[length-1-i];
			s[length-1-i]=temp;
		}
	}
	public static void maxHeap(int[] s,int end){
		//��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ ����Ϊ���������Ǵ�0��ʼ�����Խڵ�i��Ӧ�ӽڵ�2*i+1��2*i+2. 
		for(int i=(end-1)>>1;i>=0;i--){ //end-1�ٳ���2�õ����ڵ�
			int k=i; //k���������жϵĽڵ� 
			while((k<<1)+1<=end){//�����ǰk�ڵ���ӽڵ���� ,��Ϊ��ڵ���ھ�˵�����У���λ����2��k+1��ڵ�
				int big=(k<<1)+1; //����,�Ȱ��ӽڵ��нϴ��Ĭ��Ϊ��ڵ�
				if(big<end){//����С��end��˵������(big+1)����
					if(s[big]<s[big+1]) //���ͺ���ıȽϽ����ǣ�ͬʱ�ĳɴ��ںţ�������С�ѣ����ԴӴ�С��
						big++; //big���Ǽ�¼�ϴ��ӽڵ������ 
				}
				//���k�ڵ��ֵС����ϴ���ӽڵ��ֵ
				if(s[k]<s[big]){//��������ıȽ��ӽڵ�ѡС���Ǿ䣬ͬʱ�ĳɴ��ںţ�������С�ѣ����ԴӴ�С��
					int temp=s[k];
					s[k]=s[big];
					s[big]=temp; //����������whileһ�κ�k�仯������³����Ǹ��ڵ㣬������֤�³��Ľڵ�Ҳ��������ӽڵ�
					k=big;//��big����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ
				}else{
					break;//����while
				}
			}
		}
	}
}

//shell���� ϣ������
class Shell{
	public static void sort(int[] s){
		int length=s.length;
		int step=length>>1;
		while(step>0){
			for(int i=step;i<length;i++){//����Ĳ������򣬿���������˼·������������
				for(int j=i-step;j>=0 && s[j]>s[j+step];j=j-step){
					int temp=s[j];
					s[j]=s[j+step];
					s[j+step]=temp;
				}
			}
			step=step>>1;
		}
	}
}

//��������
class Kuaisu{
	public static void sort(int[] s,int left,int right){
		if(left<right){
		int l=left;
		//�ѱȽ�ֵ���ڳ����γ�һ����
		int temp=s[l]; //��仰����Ҫ�������Ƕ��õ���s[0]���ǵ����Ǹ����Ƚϵ�ֵ�����Ҳ��ܶ����ˣ�Ҫ��Left��������ֵ
		int r=right;
		// �������м�ĵ��Ƚ�ֵ
		//int temp=s[(left+right)/2];
		while(l<r)
		{
			while(r>l && s[r]>=temp) 
				r--;
			if(r>l)
			{
				s[l]=s[r]; //���ұߣ��ѱ�tempֵС��������������ұ��Ǹ��ҵ���ֵС��λ�þ���һ���¿�
				l++;
			}
			while(l<r && s[l]<=temp)
				l++;
			if(l<r)
			{
				s[r]=s[l];//����ߣ��ѱ�temp����ڳ���ղ��Ǹ��¿�����
				r--;
			}
		}//���while�����󣬱�tempС�Ķ�����ߣ���temp��Ķ����ұ�
		s[r]=temp; //��ʱl=r����ôд����ν��������м�ֵ�����������ݹ���������
		sort(s,left,r-1);//�ݹ�
		sort(s,r+1,right);
	}
}
}
//��������  ÿһ��ֵ���Ѿ��ź���������в��룬�ɺ���ǰ��
class Charu{
	public static void sort(int[] s){
		int temp=0;
		for(int i=1;i<s.length;i++)
		{
			for(int j=i-1;j>=0 && s[j]>s[j+1];j--)
			{
			//����˼·��������ð�ݣ��������s[i]�ͽ�����һֱ����������Ϊֹ
				temp = s[j];
				s[j] = s[j + 1];
				s[j + 1] = temp;
			//����������һ��˼·���Ƚ���temp����ǰs[i]����temp�У�Ȼ�󽫱�temp������һλ
			//ֱ������temp��������֣�Ȼ��temp�������λ�á�
//				int tmp = s[i];
//                for(j = i-1; j >= 0 && s[j] > tmp; j--) {
//                    s[j+1] = s[j];
//                }
//                s[j+1] = tmp;
			}
		}
	}
}
//ѡ������  ÿ��ѡʣ���е���С�ķ�ǰ��
class Xuanze{
	public static void sort(int[] s){
		for(int i=0;i<s.length-1;i++)
		{
			for(int j=i+1;j<s.length;j++)
			{
				if(s[i]>s[j])
				{   //ֻ��int���Ͳſ���ʹ�����ַ�ʽ������double���Ͳ�����
					s[i]=s[i]^s[j];
					s[j]=s[i]^s[j];
					s[i]=s[i]^s[j];
				}
			}
		}
		System.out.println("ѡ�����򷽷���");
	}
}
//ð������
class Maopao{
	static int temp=0;
	public static void sort(int[] s){
		for(int i=0;i<s.length-1;i++)
		{
			for(int j=0;j<s.length-1-i;j++)
			{
				if(s[j]>s[j+1])
				{
					temp=s[j];
					s[j]=s[j+1];
					s[j+1]=temp;
				}
			}
		}
		System.out.println("ð�����򷽷���");
	}
}

