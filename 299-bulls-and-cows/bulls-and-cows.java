class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s == g) {
                bulls++;
            } else {
                // If s was previously seen in guess, increment cows
                if (count[s] < 0) {
                    cows++;
                }
                // If g was previously seen in secret, increment cows
                if (count[g] > 0) {
                    cows++;
                }

                // Increment frequency for digit from secret
                count[s]++;
                // Decrement frequency for digit from guess
                count[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}