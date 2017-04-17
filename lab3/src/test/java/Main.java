import functional.newPages.MainPage;

/**
 * Created by cezar on 4/17/17.
 */
public class Main {
    public int a = 6;
}

class MainChild extends Main {
    public int a = 7;
}

class Test {


    public static void main(String[] args) {
        Main a = new MainChild();
        System.out.println(a.a);
    }
}
