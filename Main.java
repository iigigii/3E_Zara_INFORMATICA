public class Main {
    public static void main(String[] args) {
        String input = "la mamma di Martina va al mercato a comprare le fragole per fare la macedonia";
        splitString(input, 40);
    }



    public static void splitString(String input, int maxLength) {
        int length = input.length();
        int startIndex = 0;
        int endIndex = 0;

        while (startIndex < length) {
            endIndex = Math.min(startIndex + maxLength, length);
            while (endIndex < length && !Character.isWhitespace(input.charAt(endIndex - 1))) {
                endIndex--;
            }

            System.out.println(input.substring(startIndex, endIndex));
            startIndex = endIndex;
            while (startIndex < length && Character.isWhitespace(input.charAt(startIndex))) {
                startIndex++;
            }
        }
    }

 



}
