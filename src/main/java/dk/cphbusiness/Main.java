package dk.cphbusiness;

public class Main {
    private String[] names = {"Alice", "Bob", "Charlie", "David"};
    public static void main(String[] args) {
        Main main = new Main();
//        main.test1();
//        main.test2();
//        main.test3();
        main.test4();
    }
    public void test3(){
        MyFilter filter = name -> {
            System.out.println("Hello " + name);
            return name.length() >= 5;
        };
        doFilter(filter, names);
    }
    public void test4(){
        doFilter(name -> name.length() >= 5, names);
    }

    // Test 5 Use Lambda to get a string and return the string in uppercase.


    public void test2(){
        MyFilter filter = new MyFilter() {
            @Override
            public boolean accept(String name) {
                return name.length() >= 5;
            }
        };
        doFilter(filter, names);
    }
    public void test1(){

        MyFilter myFilter = new MyClass();
        doFilter(myFilter, names);
    }
    public void doFilter(MyFilter filter, String[] strings){
        int index = 0;
        String[] filteredStrings = new String[strings.length];
        for(String str : strings) {
            if(filter.accept(str)) {
                filteredStrings[index++] = str;
            }
        }
        for(String str : filteredStrings) {
            if(str != null) {
                System.out.println(str);
            }
        }
    }
    private interface MyFilter {
        boolean accept(String name);
    }
    private class MyClass implements MyFilter {
        @Override
        public boolean accept(String name) {
            return name.length() >= 5;
        }
    }
}