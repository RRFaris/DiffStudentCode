/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Ryan Faris
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {
        // 2D array to store all solutions
        int[][] tabs = new int[doc1.length() + 1][doc2.length() + 1];


        for (int i = 1; i < doc1.length() + 1; i++) {
            for (int j = 1; j < doc2.length() + 1; j++) {
                // Check if characters in the same spots are equal
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1))
                    tabs[i][j] = tabs[i - 1][j - 1] + 1;

                // If they aren't the same, use the largest path available
                else
                    tabs[i][j] = Math.max(tabs[i - 1][j], tabs[i][j - 1]);
            }
        }

        return tabs[doc1.length()][doc2.length()];
    }
}
