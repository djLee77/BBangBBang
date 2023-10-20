package Algorithm.string;

//문자열 내의 부분 문자열 검색에 사용

public class KMP {
    public static int[] computePrefixArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int index = 0;
        for (int i = 1; i < pattern.length();) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static boolean KMPsearch(String text, String pattern) {
        int[] lps = computePrefixArray(pattern);
        int j = 0;
        int i = 0;
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j == pattern.length();
    }

    public static void main(String[] args) {
        String text = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";
        System.out.println(KMPsearch(text, pattern)); // Outputs true
    }
}
