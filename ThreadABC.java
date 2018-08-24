package test.yang;
import java.util.concurrent.atomic.AtomicInteger;

//下面的3个打印机
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
	int key; //每个线程的钥匙
	static	AtomicInteger lock=new AtomicInteger(0); //房间的锁
	public void run(){   //一个房间有3个打印机分别只能打ABC
		while(num>0)     //所以锁一定是static，3个打印机共有的
		{
			synchronized(lock)
			{
				if(lock.get()%3==key) //每个线程验证现在的钥匙能不能开锁
				{
					System.out.println(name);
					lock.getAndIncrement(); //锁的密码打印一次+1配对下一个线程Key
					num--;
					lock.notifyAll();  //打印完了，通知其他人想打可以去开锁了
				}
				else  //key打不开即现在不该你打，所以继续等待，释放lock的锁，让别人去开
				{
					try {
						lock.wait();  
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
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
//下面1个打印机


	public class ThreadABC {  
	    public static void main(String argv[]) {            
	        AtomicInteger synObj = new AtomicInteger(0);   
	        Runnable r = new PrintThread(synObj);  
	        try {  
	            Thread a = new Thread(r, "A");  //A是线程的名字而已
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
    }                   //由于是共享一个打印机，所以用for循环，不能用上面的while方式
    public void print() {  //不然需要30并且也不一定正好10次，所以共享一个对象时尽量不要用while  
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