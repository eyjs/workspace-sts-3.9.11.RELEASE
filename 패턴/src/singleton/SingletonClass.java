package singleton;

public class SingletonClass {
	private static SingletonClass _instance=null;
	private SingletonClass() {
		System.out.println("SingletonClass() 생성자호출:"+this);
	}
	public  static SingletonClass getInstance() {
		if(_instance==null) {
			_instance=new SingletonClass();
		}
		return SingletonClass._instance;
	}
}
