package groupbase.vn.thn.mydictionary;

/**
 * Created by nghiath on 5/11/15.
 */
public class ApiUrl {
    public static final String API_KEY = "AIzaSyC9LS5YiMUJ_IdMgWFqOCHsYtjIbpBAOtA";
    private static final String TRANSLATE_API = "https://www.googleapis.com/language/translate/v2?key=" + API_KEY + "&source=%s&target=%s&q=%s";
    private static final String LANGUAGES_LIST_API = "https://www.googleapis.com/language/translate/v2/languages?key=" + API_KEY + "&target=%s";

    public static String getTranslateApi(String source,String target, String q) {
        q = q.replace(" ", "%20");
        return String.format(TRANSLATE_API,source, target, q);
    }

    public static String getLanguagesListApi(String target) {
        target = target.trim();
        return String.format(LANGUAGES_LIST_API, target);
    }
}
