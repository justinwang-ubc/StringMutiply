/***
 * a function that take two big integer as string and return the product, also represented as a string
 * input: num1 big integer represented as string
 * input: num2 big integer represented as string
 * output: result big integer represented as string
 */

public class multiply{
    public static String multiply(String num1, String num2 ){
        int length1 = num1.length();
        int length2 = num2.length();

        if(length1 == 0 || length2 == 0){
            return "0";
        }
        // result length will not exceed the sum
        int[] result = new int[length1+length2];

        // from right to left in num1
        for(int i = length1 - 1; i >= 0; i--){
            for(int j = length2 - 1; j >= 0; j--) {

                // calculate the product of the current digit in num1 and num2
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // calculate the position of the one digit of the product as well as the ten digit of the product(计算个位数和十位数的位置)
                int tenDigitPosition  = i + j;
                int oneDigitPosition  = i + j + 1;

                // sum the product and the number at the position of one digit（加乘积和个位数）
                int sum = product + result[oneDigitPosition];

                result[tenDigitPosition] += sum / 10; // carry bit
                result[oneDigitPosition] = sum % 10;  // reminder
            }
        }
        // Convert the result array to a string
                StringBuilder sb = new StringBuilder();
                for (int digit : result) {
                    if (!(sb.length() == 0 && digit == 0)) { // make sure we dont put 0 in front of the result
                        sb.append(digit);
                    }
                }

                return sb.toString();

    }


    public static void main(String[] args) {
        String num1 = "1234";
        String num2 = "4567";
        String result = multiply(num1, num2);
        System.out.println(result);

        String num3 = "9999";
        String num4 = "9999";
        String result1 = multiply(num3, num4);
        System.out.println(result1);

        String num5= "00123";
        String num6= "04567";
        String result3 = multiply(num5, num6);
        System.out.println(result3);

    }

}
