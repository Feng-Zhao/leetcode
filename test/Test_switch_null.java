package test;

public class Test_switch_null {

    public static void main(String[] args) {
        method(null);
    }

    public static void method(String param) {
        // 可以理解为 使用 param.equals(case参数)
        // 传入 null 造成 NPE
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }

}
