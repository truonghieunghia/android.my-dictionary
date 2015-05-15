package groupbase.vn.thn.mydictionary.data.entry;

import java.util.ArrayList;

import groupbase.vn.thn.baselibs.util.JsonAnnotation;

/**
 * Created by nghiath on 5/8/15.
 */
public class TranslationListEntry {
    @JsonAnnotation(FieldName = "translations",FieldType = TranslationEntry.class,isObject = true,isList = true)
    public ArrayList<TranslationEntry> translations = new ArrayList<>();
}
