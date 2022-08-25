//load and register the driver
package steps;

public class STEP1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load & register the driver
			System.out.println("loading and registering completed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
