package basic;

public class DriverClassLoadingMain {

	public static void main(String[] args)throws Exception {
		String driverClass="basic.OracleDriver";
		/*
		 * 1. basic.OracleDriver class loading
		 *    A. Driver��ü����
		 *    B. DriverManager����ü���
		 */
		//Driver driver=new OracleDriver();
		Class clazz = Class.forName(driverClass);
		/*
		Driver driver=(Driver)clazz.newInstance();
		DriverManager.registerDriver(driver);
		*/
		
	}

}
