package basic;

public class DriverClassLoadingMain {

	public static void main(String[] args)throws Exception {
		String driverClass="basic.OracleDriver";
		/*
		 * 1. basic.OracleDriver class loading
		 *    A. Driver按眉积己
		 *    B. DriverManager俊按眉殿废
		 */
		//Driver driver=new OracleDriver();
		Class clazz = Class.forName(driverClass);
		/*
		Driver driver=(Driver)clazz.newInstance();
		DriverManager.registerDriver(driver);
		*/
		
	}

}
