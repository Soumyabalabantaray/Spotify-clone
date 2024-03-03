public class Result {
    public final String output1;
    public final String output2;
    public final String output3;
    public Result(String output1, String output2, String output3) {
        this.output1 = output1;
        this.output2 = output2;
        this.output3 = output3;
    }
    public static Result encode(String input1, String input2, String input3) {
        // Step 1: Split each string into 3 parts.
        String[] parts1 = splitInto3Parts(input1);
        String[] parts2 = splitInto3Parts(input2);
        String[] parts3 = splitInto3Parts(input3);
        // Step 2: Concatenate the parts of the strings according to the specified rule.
        String output1 = parts1[0] + parts3[2] + parts2[1];
        String output2 = parts2[0] + parts1[1] + parts3[2];
        String output3 = parts3[0] + parts2[1] + parts1[0];
        // Step 3: Process the output strings.
        output3 = toggleCase(output3);
        // Return the result.
        return new Result(output1, output2, output3);
    }
    private static String[] splitInto3Parts(String input) {
        // If the number of characters in the string is a multiple of 3, then each split-part will contain equal number of characters.
        if (input.length() % 3 == 0) {
            return new String[]{input.substring(0, input.length() / 3), input.substring(input.length() / 3, 2 * input.length() / 3), input.substring(2 * input.length() / 3)};
        }
        // If the number of characters in the string is not a multiple of 3, and there is one character more than a multiple of 3, then the middle part will get the extra character.
