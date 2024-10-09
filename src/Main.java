public class Main {
    public static void main(String[] args) {
        int init  =10;
        int increment = 2;
        int times = 20;

        int result = add(init, increment, times, 0);

        System.out.println(result);
    }

    private static int add(int init, int increment, int times, int counter){
        if(counter==times){
            return init;
        } else {
            init += increment;
            counter++;
            return add(init, increment, times, counter);
        }
    }
}