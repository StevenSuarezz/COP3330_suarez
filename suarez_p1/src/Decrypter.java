public class Decrypter {
    public String decrypt(String s){
        int[] digits = convertToIntArray(s);
        String decryptedValue = decryptionAlgorithm(digits);
        return decryptedValue;
    }

    private int[] convertToIntArray(String s){
        int[] digits = new int[s.length()];
        for (int i = 0; i < digits.length; i++){
            digits[i] = Integer.parseInt(s.substring(i, i+1));
        }
        return digits;
    }

    private String decryptionAlgorithm(int[] digits){
        // Step 1: Swap the first digit with the third, and swap the second digit with the fourth
        for (int i = 0; i < digits.length / 2; i++){
            int temp = digits[i];
            digits[i] = digits[i+2];
            digits[i+2] = temp;
        }

        // Step 2: Replace each digit with the result of adding 7 to the digit and getting the remainder after dividing the new value by 10
        for (int i = 0; i < digits.length; i++){
            digits[i] = (digits[i] + 3) % 10;
        }

        // Step 3: Return the decrypted integer as a String
        return "" + digits[0] + digits[1] + digits[2] + digits[3];
    }
}
