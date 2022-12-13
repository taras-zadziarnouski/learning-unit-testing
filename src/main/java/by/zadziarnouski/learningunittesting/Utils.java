package by.zadziarnouski.learningunittesting;

import java.util.List;

public class Utils {

    private String foo = "foo";
    private String fooDuplicate = foo;
    private String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};
    private List<String> fooBarInList = List.of("foo", "bar");

    public List<String> getFooBarInList() {
        return fooBarInList;
    }

    public String getFoo() {
        return foo;
    }

    public String getFooDuplicate() {
        return fooDuplicate;
    }

    public String[] getFirstThreeLettersOfAlphabet() {
        return firstThreeLettersOfAlphabet;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public Object checkNull(Object obj) {
        if (obj != null) {
            return obj;
        }
        return null;
    }

    public Boolean isGreater(int n1, int n2) {
        return n1 > n2;
    }

    public String throwException(int a) throws Exception {
        if (a < 0) {
            throw new Exception("Value should be greater than or equal to 0");
        }
        return "Value is greater than or equal to 0";
    }

    public void checkTimeout() throws InterruptedException {
        System.out.println("I am going to sleep");
        Thread.sleep(2000);
        System.out.println("Sleeping over");
    }

}
