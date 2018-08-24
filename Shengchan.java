package test.yang;
import java.util.*;
import java.util.concurrent.*;

//传统方法
public class Shengchan {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
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
	//产品
}
class Store{
	final private int num=20;
	private LinkedList<Love> list= new LinkedList<Love>();//产品载体
	public void setList(LinkedList<Love> l){ //用于主函数只是初始载体
		this.list=l;
	}
	public void produce(int i){//生产方法
		synchronized(list){
			if(list.size()+i>num)//
			{
				System.out.println("要生产的太多了，暂时不能执行,现在有"+list.size());
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
				System.out.println("已经完成生产任务,现在有"+list.size());
				list.notifyAll();
			}
		}
	}
	public void consume(int i){
		synchronized(list){
			if(list.size()<i)
			{
				System.out.println("东西数量不够，请等待,现在有"+list.size());
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
				System.out.println("已经消费完,还有"+list.size());
				list.notifyAll();
			}
		}
	}
}
class Pro implements Runnable{
	private int num;//每次生产数量
	private Store s;//为哪个仓库生产
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
//用BlockingQueue
public class Shengchan {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
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
	//产品
}
class Store{
	final private int num=100;  //ArrayBlockingQueue也行,不过需要指定容量
	private LinkedBlockingQueue<Love> list=new LinkedBlockingQueue<Love>(num);//产品载体
	public void setList(LinkedBlockingQueue<Love> l){ //用于主函数只是初始载体
		this.list=l;
	}
	public void produce(int i){//生产方法，直接生产就行，不用任何判断和wait等
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
	private int num;//每次生产数量
	private Store s;//为哪个仓库生产
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


















