
public class TestThreadAff {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		ThreadAff T1 = new ThreadAff ("T1");
		ThreadAff T2 = new ThreadAff ("T2");
		T1.start();
		T2.start();

	}

}
