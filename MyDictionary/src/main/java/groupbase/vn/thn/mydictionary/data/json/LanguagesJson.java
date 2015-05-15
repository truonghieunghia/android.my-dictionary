package groupbase.vn.thn.mydictionary.data.json;

import groupbase.vn.thn.baselibs.util.JsonAnnotation;
import groupbase.vn.thn.mydictionary.data.entry.LanguageListEntry;

/**
 * Created by nghiath on 5/8/15.
 */
public class LanguagesJson {
    @JsonAnnotation(FieldName = "data", FieldType = LanguageListEntry.class, isObject = true)
    public LanguageListEntry data;
}
