package test.yang;
//��ŵ��
public class HanTa {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int n=3;
		yidong(n,'A','B','C');
	}
	private static void yidong(int num,char from,char mid,char to){
		
       
		if(num==1){
			System.out.println("��"+from+"�ƶ�����"+1+"�ŵ�"+to);
			
		}
		else{
			//�����ĵݹ���3����1.������İᵽ��ĵط����м䣩��2.��������һ���ᵽĿ�ĵأ��ⲽ����������������������������䣩��
			//3.��ס���ý��ᵽ�м���Ƕ��ٰᵽĿ�ĵز��������Ĺ��̡�
			yidong(num-1,from,to,mid);	//step1���������N-1���ᵽ�м�
			System.out.println("��"+from+"�ƶ�����"+num+"�ŵ�"+to); //step2������N����from�ᵽto����仰�൱��һ����������������һ�����ӵ�Ŀ�ĵ�
			yidong(num-1,mid,from,to); //step���ٽ��м��N-1���ᵽto�Ϳ�����
		}
	
	}

}

/*
public class HanTa {
  //�򵥽׳�����ݹ�
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int n=4;
		int h=jc(n);
		System.out.println(h);
	}
	private static int jc(int n){
		if(n==1)
			{return 1;}
		else
		{
			return jc(n-1)*n;  //����n-1�εĽ�����ؼ���������Ҫ�����ڵ�n��˲��С�
		}
	
	}

}
*/