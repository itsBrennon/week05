package week05;


interface Logger {
    void log(String message);
    void error(String message);
}
class AsteriskLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("***" + message + "***");
    }

    @Override
    public void error(String message) {
        System.out.println("****************");
        System.out.println("***Error: " + message + "***");
        System.out.println("****************");
    }
}

class SpacedLogger implements Logger {
    @Override
    public void log(String message) {
        StringBuilder spacedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            spacedMessage.append(c).append(" ");
        }
        System.out.println(spacedMessage.toString().trim());
    }

    @Override
    public void error(String message) {
        System.out.print("ERROR: ");
        log(message);
    }
}


public class App {
    public static void main(String[] args) {
        Logger asteriskLogger = new AsteriskLogger();
        Logger spacedLogger = new SpacedLogger();

        // Test AsteriskLogger
        asteriskLogger.log("Hello");
        asteriskLogger.error("Something went wrong");

        // Test SpacedLogger
        spacedLogger.log("Hello");
        spacedLogger.error("Something went wrong");
    }
}
