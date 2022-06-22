public class Metodi {
    public static void main(String[] args) {
        printme();
        printme("zxc");
        printme(123);
    }

    private static void printme() {
        System.out.println("asd");
    }

    private static void printme(int varr) {
        System.out.println(varr);
    }

    private static void printme(String varr) {
        System.out.println(varr);
    }
}
