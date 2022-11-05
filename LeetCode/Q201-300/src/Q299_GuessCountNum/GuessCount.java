package Q299_GuessCountNum;

public class GuessCount {
    public String getHint(String secret, String guess) {
        int[] sCount = new int[10];
        int[] gCount = new int[10];

        int A = 0;
        int B = 0;

        for (int i=0; i<secret.length(); i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);

            if (sc == gc) {
                A++;
                continue;
            }
            sCount[sc-'0']++;
            gCount[gc-'0']++;
        }

        for (int i=0; i<10; i++) {
            B += Math.min(sCount[i], gCount[i]);
        }

        return A+"A"+B+"B";
    }
}
