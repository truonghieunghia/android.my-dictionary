package groupbase.vn.thn.mydictionary.data.entry;

import java.util.ArrayList;

import groupbase.vn.thn.baselibs.util.JsonAnnotation;

/**
 * Created by nghiath on 5/8/15.
 */
public class LanguageListEntry {
    @JsonAnnotation(FieldName = "languages",FieldType = LanguageEntry.class,isObject = true,isList = true)
    public ArrayList<LanguageEntry> listLanguages = new ArrayList<>();
}
