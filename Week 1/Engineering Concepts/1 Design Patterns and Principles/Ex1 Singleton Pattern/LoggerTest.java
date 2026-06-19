public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");
        Logger logger2 = Logger.getInstance();
        logger2.log("User login event captured.");
        System.out.println("Both logger objects are the same instance: " + (logger1 == logger2));
    }
}