import java.util.*;

public class Test_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringTokenizer st = new StringTokenizer("a-b", "+-/x", true);
		while (st.hasMoreTokens()) {
		System.out.println(st.nextToken());
		}

	}

}
