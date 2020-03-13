package by.it.academy.project;

public class App {
    public static void main(String[] args) {
        String inputString = ":j@Z+VV3l\\^?\"D7+aE&^@d@XI:l8klT_&%ab\"a!AbBD\"5@Ehk+];I!^l66Dc$Igj";
        if (args.length > 0) {
            inputString= args[0];
        }
        String result = handleString(inputString);
        System.out.println(result);
    }
    private static String handleString(String inputString) {
        if (inputString.chars().anyMatch(number -> number == 33)) {
            return inputString;
        }
        return handleString(inputString.chars()
                .map(number -> --number)
                .collect(StringBuilder::new, (buf, c) -> buf.append((char) c), StringBuilder::append)
                .toString());
    }
}
