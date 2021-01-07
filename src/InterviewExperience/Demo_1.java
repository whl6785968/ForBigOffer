package InterviewExperience;

public class Demo_1 {
    public void testInteger(){
        System.out.println(Integer.valueOf(100) == new Integer(100));
    }

    public static void main(String[] args) {
        Demo_1 demo_1 = new Demo_1();
        demo_1.testInteger();
    }
}
