import java.util.Random;

public class DiningPhil extends Thread {
	private int name;
	private int stabL;
	private int stabR;
	
	public DiningPhil(int name, int stabL, int stabR) {
		this.name = name; 
		this.stabL = stabL;
		this.stabR = stabR;
	}
	
	public int getPhilName() {
		return name;
	}
	
	public int getStabL() {
		return stabL;
	}
	
	public int getStabR() {
		return stabR;
	}
	
	public void snooze() {
		Random rand = new Random();
		int randomTime = rand.nextInt(1000);
		
		try {
			Thread.sleep(randomTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void eat() {
		System.out.println(name + ": Eat");
	}
	
	public void run() {
		while(true) {
			snooze();		// Nachdenken
			eat();			// Essen
		}
	}
	
	public static void main (String[] args) {
		int num = 5;
		
		for(int i=1; i<=num; i++) {
			if(i+1 > num) { // Last Philosopher
				new DiningPhil(i, i, 1).start();
			}
			else {
				new DiningPhil(i, i, i+1).start();
			}
		}
	}
}
