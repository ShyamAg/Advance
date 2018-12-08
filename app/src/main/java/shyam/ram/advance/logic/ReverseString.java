package shyam.ram.advance.logic;

public class ReverseString {
    public static void main(String[] args) {
        String string = "Shyam";
        int j= string.length();
        for (int i = 0; i < j; i++) {
            System.out.print(string.substring(string.length() - 1));
            string = string.substring(0, string.length() - 1);
        }
//        System.out.println(string.);
    }
//public static void main(String[] args)
//{
//    String input = "Geeks for Geeks";
//    StringBuilder input1 = new StringBuilder();
//    input1.append(input);
//    input1 = input1.reverse();
//    System.out.println(input1);
//}
}
