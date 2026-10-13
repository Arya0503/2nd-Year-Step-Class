public class WordReverser {
    public static void main(String[] args) {
        String word = "level";
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        System.out.println(word);
        System.out.println(reversed);

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }
    }
}