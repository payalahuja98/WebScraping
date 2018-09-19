import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] args) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(findWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"), "prince"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();

        urlScanner.close();
        return contents;
    }

    public static int wordCount(String page) {
        String[] words = page.split("\\s+");
        return words.length;
    }

    public static int findWordCount(String text, String toFind) {
        String[] textArray = text.split("\\s+");

        int wordCount = 0;

        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i].startsWith(toFind)){
                wordCount++;
            }
        }

        return wordCount;
    }
}
