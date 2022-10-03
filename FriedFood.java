
public class FriedFood implements SideDish{
	private String food;
	private int price;
	
	public FriedFood(String food,int price) {
		this.food = food;
		this.price = price;
	}
	public String getFood() {
		String name = "aaa";
		name = "bbb";
		return this.food;
	}
	public int getPrice() {
		String name = "ccc";
		return this.price;
	}
	public String getName() {
		return (this.food + "ƒtƒ‰ƒC");
	}
	public void print() {
		System.out.println(getName() + getPrice() + "‰~");
	}

}
