class Solution {

    public String minWindow(String s, String t) {

        if (t.length() > s.length())
            return "";

        int[] need = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int matched = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            window[c]++;

            if (need[c] > 0 && window[c] <= need[c]) {
                matched++;
            }

            while (matched == t.length()) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window[leftChar]--;

                if (need[leftChar] > 0 &&
                    window[leftChar] < need[leftChar]) {
                    matched--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLen);
    }
}
