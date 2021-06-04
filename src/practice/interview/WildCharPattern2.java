package practice.interview;

public class WildCharPattern2 {

    public static void main(String[] args) {

        // * - 3 character , + - 1 character $ - 0-9
        String pattern = "+N$**{2}";
        String actualString = "aN8ccccc";
        int actualStringIndex = 0;
        boolean flag = true;
        boolean patternRepeatMatches = false;

        for(int i =0;i< pattern.length() && flag;i++) {

            if (pattern.charAt(i) == '+') {
                if (Character.isLetter(actualString.charAt(actualStringIndex))) {
                    actualStringIndex++;
                    continue;
                }
                flag = false;
                break;
            } else if (pattern.charAt(i) == '*') {
                int repeats = 3;
               if(pattern.length() >= i+3) {
                   if(pattern.charAt(i+1) == '{' && pattern.charAt(i+3) == '}' && Character.isDigit(pattern.charAt(i+2))) {
                       repeats = Character.getNumericValue(pattern.charAt(i+2) );
                       i = i + 3;
                   }

                   for(int k=0;k<repeats;k++) {
                      if((actualStringIndex+1) < actualString.length() && actualString.charAt(actualStringIndex) == actualString.charAt(actualStringIndex+1) ) {
                          System.out.println(actualString.charAt(actualStringIndex));
                          actualStringIndex++;
                          continue;
                      }
                       flag = false;
                      break;
                   }
                }

            } else if (pattern.charAt(i) == '$') {
                if (Character.isDigit(actualString.charAt(actualStringIndex))) {
                    actualStringIndex++;
                    continue;
                }
                flag = false;
                break;
            } else {
                if(actualString.charAt(actualStringIndex) == pattern.charAt(i)) {
                    actualStringIndex++;
                    continue;
                }
                flag = false;
                break;
            }

        }

        if(actualStringIndex != actualString.length()) flag = false;

        System.out.println("Final flag: " + flag);
    }
}
