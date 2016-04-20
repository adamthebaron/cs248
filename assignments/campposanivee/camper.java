public class camper implements Comparable {
    String name;
    int age;
    char sex;
	
	public int compareTo(Object obj) {
		if (obj instanceof camper)
			return 0;
		else
			return 0;
	}
}
