package groupbase.vn.thn.mydictionary.data.entry;

import groupbase.vn.thn.baselibs.util.JsonAnnotation;

/**
 * Created by nghiath on 5/8/15.
 */
public class LanguageEntry {
    @JsonAnnotation(FieldName = "language",FieldType = String.class)
    public String code;
    @JsonAnnotation(FieldName = "name",FieldType = String.class)
    public String name;
}
