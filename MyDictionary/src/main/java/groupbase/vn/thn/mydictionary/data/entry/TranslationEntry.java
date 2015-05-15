package groupbase.vn.thn.mydictionary.data.entry;

import groupbase.vn.thn.baselibs.util.JsonAnnotation;

/**
 * Created by nghiath on 5/8/15.
 */
public class TranslationEntry {
    @JsonAnnotation(FieldName = "translatedText",FieldType = String.class)
    public String translatedText;
    @JsonAnnotation(FieldName = "detectedSourceLanguage",FieldType = String.class)
    public String detectedSourceLanguage;
}
