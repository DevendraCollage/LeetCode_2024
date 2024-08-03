public class LC2678 {
    public static int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            // ! Approach-1 (Slower)
            // String age = detail.substring(11, 13);
            // int ageVal = Integer.parseInt(age);
            // ! Approach-2 (Faster)
            int a = detail.charAt(11) - '0';
            int b = detail.charAt(12) - '0';
            int ageVal = a * 10 + b;
            if (ageVal > 60) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String details[] = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };

        System.out.println(countSeniors(details));
    }
}