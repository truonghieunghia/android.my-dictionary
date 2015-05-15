package groupbase.vn.thn.mydictionary.data.json;

import groupbase.vn.thn.baselibs.util.JsonAnnotation;
import groupbase.vn.thn.mydictionary.data.entry.TranslationListEntry;

/**
 * Created by nghiath on 5/8/15.
 */
public class TranslationsJson {
    @JsonAnnotation(FieldName = "data",FieldType = TranslationListEntry.class,isObject = true)
    public TranslationListEntry data;

}
