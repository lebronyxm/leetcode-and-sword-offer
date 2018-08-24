package test.yang;
import java.util.*;
import java.util.concurrent.*;

//��ͳ����
public class Shengchan {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Store s=new Store();
		Pro p1=new Pro(10,s);
		Pro p2=new Pro(10,s);
		Pro p3=new Pro(10,s);
		Cons c1=new Cons(50,s);
		Cons c2=new Cons(20,s);
		Cons c3=new Cons(30,s);
		Thread t1=new Thread(p1);
		Thread t2=new Thread(p2);
		Thread t3=new Thread(p3);
		t1.start();
		t2.start();
		t3.start();
		c1.start();
		c2.start();
		c3.start();
	}

}
class Love{
	//��Ʒ
}
class Store{
	final private int num=20;
	private LinkedList<Love> list= new LinkedList<Love>();//��Ʒ����
	public void setList(LinkedList<Love> l){ //����������ֻ�ǳ�ʼ����
		this.list=l;
	}
	public void produce(int i){//��������
		synchronized(list){
			if(list.size()+i>num)//
			{
				System.out.println("Ҫ������̫���ˣ���ʱ����ִ��,������"+list.size());
				try{
					list.wait();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else
			{
				for(int j=0;j<i;j++)
				{
					list.add(new Love());
				}
				System.out.println("�Ѿ������������,������"+list.size());
				list.notifyAll();
			}
		}
	}
	public void consume(int i){
		synchronized(list){
			if(list.size()<i)
			{
				System.out.println("����������������ȴ�,������"+list.size());
				try {
					list.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
			{
				for(int j=0;j<i;j++)
				{
					list.remove();
				}
				System.out.println("�Ѿ�������,����"+list.size());
				list.notifyAll();
			}
		}
	}
}
class Pro implements Runnable{
	private int num;//ÿ����������
	private Store s;//Ϊ�ĸ��ֿ�����
	public Pro(int n,Store s){
		this.num=n;
		this.s=s;
	}
	public void run(){
		s.produce(num);
	}
}
class Cons extends Thread{
	private int num;
	private Store s;
	public Cons(int i,Store s){
		this.num=i;
		this.s=s;
	}
	public void run(){
		s.consume(num);
	}
}

/*
//��BlockingQueue
public class Shengchan {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Store s=new Store();
		Pro p1=new Pro(10,s);
		Pro p2=new Pro(10,s);
		Pro p3=new Pro(10,s);
		Cons c1=new Cons(50,s);
		Cons c2=new Cons(20,s);
		Cons c3=new Cons(30,s);
		Thread t1=new Thread(p1);
		Thread t2=new Thread(p2);
		Thread t3=new Thread(p3);
		t1.start();
		t2.start();
		t3.start();
		c1.start();
		c2.start();
		c3.start();
	}

}
class Love{
	//��Ʒ
}
class Store{
	final private int num=100;  //ArrayBlockingQueueҲ��,������Ҫָ������
	private LinkedBlockingQueue<Love> list=new LinkedBlockingQueue<Love>(num);//��Ʒ����
	public void setList(LinkedBlockingQueue<Love> l){ //����������ֻ�ǳ�ʼ����
		this.list=l;
	}
	public void produce(int i){//����������ֱ���������У������κ��жϺ�wait��
		for(int j=0;j<i;j++){
			try {
				list.put(new Love());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("now the num is:"+list.size());
	}
	public void consume(int i){
		for(int j=0;j<i;j++){
			try {
				list.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("now the num is:"+list.size());
	}
}
class Pro implements Runnable{
	private int num;//ÿ����������
	private Store s;//Ϊ�ĸ��ֿ�����
	public Pro(int n,Store s){
		this.num=n;
		this.s=s;
	}
	public void run(){
		s.produce(num);
	}
}
class Cons extends Thread{
	private int num;
	private Store s;
	public Cons(int i,Store s){
		this.num=i;
		this.s=s;
	}
	public void run(){
		s.consume(num);
	}
}
*/


















