package test.yang;
import java.util.concurrent.atomic.AtomicInteger;

//�����3����ӡ��
public class ThreadABC {
	public static void main(String[] args) {
		Dayin A=new Dayin("A",0);
		
		Dayin B=new Dayin("B",1);
		Dayin C=new Dayin("C",2);
		Thread ta=new Thread(A);
		Thread tb=new Thread(B);
		Thread tc=new Thread(C);
		ta.start();
		tb.start();
		tc.start();
	}
}
class Dayin implements Runnable{
	String name;
	int num=10;
	int key; //ÿ���̵߳�Կ��
	static	AtomicInteger lock=new AtomicInteger(0); //�������
	public void run(){   //һ��������3����ӡ���ֱ�ֻ�ܴ�ABC
		while(num>0)     //������һ����static��3����ӡ�����е�
		{
			synchronized(lock)
			{
				if(lock.get()%3==key) //ÿ���߳���֤���ڵ�Կ���ܲ��ܿ���
				{
					System.out.println(name);
					lock.getAndIncrement(); //���������ӡһ��+1�����һ���߳�Key
					num--;
					lock.notifyAll();  //��ӡ���ˣ�֪ͨ������������ȥ������
				}
				else  //key�򲻿������ڲ���������Լ����ȴ����ͷ�lock�������ñ���ȥ��
				{
					try {
						lock.wait();  
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
			}
		}
	}
	public Dayin(String name,int key){
		this.name=name;
		this.key=key;
	}
}


/*
//����1����ӡ��


	public class ThreadABC {  
	    public static void main(String argv[]) {            
	        AtomicInteger synObj = new AtomicInteger(0);   
	        Runnable r = new PrintThread(synObj);  
	        try {  
	            Thread a = new Thread(r, "A");  //A���̵߳����ֶ���
            Thread b = new Thread(r, "B");  
	            Thread c = new Thread(r, "C");    
	            a.start();  
            b.start();  
            c.start();              
        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
    }  
	}  
	class PrintThread implements Runnable {  
    private AtomicInteger synObj;        
    public PrintThread(AtomicInteger synObj) {  
	        this.synObj = synObj;  
    }  
    @Override  
    public void run() {  
        print();  
    }                   //�����ǹ���һ����ӡ����������forѭ���������������while��ʽ
    public void print() {  //��Ȼ��Ҫ30����Ҳ��һ������10�Σ����Թ���һ������ʱ������Ҫ��while  
        for (int i = 0; i < 10; i++) {  
            try {                                    
                synchronized (synObj) {  
                    if (synObj.get() % 3 == 0) {  
                        System.out.println("A");  
                        synObj.set(synObj.get() + 1);  
                        synObj.notifyAll();  
                    } else if (synObj.get() % 3 == 1 ) {  
	                        System.out.println("B");  
                        synObj.set(synObj.get() + 1);  
                        synObj.notifyAll();  
                    } else if (synObj.get() % 3 == 2 ) {  
                       System.out.println("C");  
                       synObj.set(synObj.get() + 1);  
                        synObj.notifyAll();  
                    } else {  
                        synObj.wait();  
                    }  
                }       
            } catch (Exception e) {  
                e.printStackTrace();  
	            }  
        }  
	    }  
	} 
*/