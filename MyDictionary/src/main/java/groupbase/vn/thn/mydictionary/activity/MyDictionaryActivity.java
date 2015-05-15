package groupbase.vn.thn.mydictionary.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import groupbase.vn.thn.baselibs.common.ActivityCommon;
import groupbase.vn.thn.baselibs.common.AdapterCommon;
import groupbase.vn.thn.baselibs.listener.AdapterBaseListener;
import groupbase.vn.thn.baselibs.listener.AdapterDropDownBaseListener;
import groupbase.vn.thn.baselibs.service.ConnectWS;
import groupbase.vn.thn.baselibs.service.callback.RequestCallBack;
import groupbase.vn.thn.mydictionary.ApiUrl;
import groupbase.vn.thn.mydictionary.R;
import groupbase.vn.thn.mydictionary.data.entry.LanguageEntry;
import groupbase.vn.thn.mydictionary.data.json.LanguagesJson;
import groupbase.vn.thn.mydictionary.data.json.TranslationsJson;

/**
 * Created by nghiath on 5/8/15.
 */
public class MyDictionaryActivity extends ActivityCommon implements View.OnClickListener {

    private Spinner source_to;
    private Spinner source_from;
    private ArrayList<LanguageEntry> languageEntries = new ArrayList<>();
    private String source;
    private String target;
    private AdapterCommon adapterCommon;

    @Override
    protected void init() {

        setLayout(R.layout.activity_my_dictionary);
        source_to = (Spinner) findViewById(R.id.to);
        source_from = (Spinner) findViewById(R.id.from);
        adapterCommon = new AdapterCommon(this, R.layout.language_info_cell, languageEntries);
        adapterCommon.setDropDownViewResource(R.layout.language_info_cell);
        source_to.setAdapter(adapterCommon);
        source_from.setAdapter(adapterCommon);
        source_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LanguageEntry obj = (LanguageEntry) parent.getItemAtPosition(position);
                target = obj.code;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        source_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LanguageEntry obj = (LanguageEntry) parent.getItemAtPosition(position);
                source = obj.code;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapterCommon.setAdapterBaseListener(new AdapterBaseListener<LanguageEntry, MyDictionaryActivity.HolderView>() {
            @Override
            public MyDictionaryActivity.HolderView setHolderView(View view) {
                return new HolderView(view);
            }

            @Override
            public void showData(LanguageEntry data, HolderView holderView, int position) {
                holderView.language_name.setText(data.name);

            }
        });
        adapterCommon.setAdapterDropDownBaseListener(new AdapterDropDownBaseListener<LanguageEntry, MyDictionaryActivity.HolderView>() {
            @Override
            public MyDictionaryActivity.HolderView setHolderView(View view) {
                return new HolderView(view);
            }

            @Override
            public void showData(LanguageEntry data, HolderView holderView, int position) {

            }
        });
        ConnectWS connectWS = new ConnectWS(ApiUrl.getLanguagesListApi("vi"), this);
        connectWS.setRequestCallBack(new RequestCallBack<LanguagesJson>() {
            @Override
            public void onResult(LanguagesJson data) {
                languageEntries.addAll(data.data.listLanguages);
                adapterCommon.notifyDataSetChanged();
            }

            @Override
            public void onResultArray(ArrayList<LanguagesJson> data) {

            }
        });
        connectWS.getRequest(false);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {

            TextView q = (TextView) findViewById(R.id.source);

            ConnectWS connectWS = new ConnectWS(ApiUrl.getTranslateApi(source, target, q.getText().toString()), this);
            connectWS.setRequestCallBack(new RequestCallBack<TranslationsJson>() {
                @Override
                public void onResult(TranslationsJson data) {
                    ((TextView) findViewById(R.id.result)).setText(data.data.translations.get(0).translatedText);
                }

                @Override
                public void onResultArray(ArrayList<TranslationsJson> data) {

                }
            });
            connectWS.getRequest(false);
        }
    }

    class HolderView {
        TextView language_name;

        public HolderView(View view) {
            language_name = (TextView) view.findViewById(R.id.language_name);
        }
    }
}
