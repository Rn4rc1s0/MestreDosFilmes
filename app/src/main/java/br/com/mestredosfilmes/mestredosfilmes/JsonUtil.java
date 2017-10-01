package br.com.mestredosfilmes.mestredosfilmes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 20/09/2017.
 */

public class JsonUtil {

    public static List<ItemFilme> fromJsonToList(String json) {
        List<ItemFilme> list = new ArrayList<>();
        try {
            JSONObject jsonBase = new JSONObject(json);
            JSONArray results = jsonBase.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                JSONObject filmObject = results.getJSONObject(i);
                ItemFilme itemFilme = new ItemFilme(filmObject);
                list.add(itemFilme);
            }


        } catch (JSONException e) {
            e.printStackTrace();

        }
        return list;
    }

}
