package com.halfof73.halfof73.Map;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.halfof73.halfof73.Common.Common;
import com.halfof73.halfof73.model.FoundationBean_HO73;

import java.lang.reflect.Type;
import java.util.List;

public class FoundationDao {
    private Activity inputActivity;
    private String TAG;
    private CommonTask StoreTask;
    private List<FoundationBean_HO73> StoreList;

    public FoundationDao(Activity inputActivity) {
        this.inputActivity = inputActivity;
        TAG = inputActivity.getClass().getName();
    }

    public List<FoundationBean_HO73> getStoreByDistance() {
        if (Common.networkConnected(inputActivity)) {
            System.out.println("getStoreByDistance() Start!!!");
            StoreList = null;
            // String userLocation = String.valueOf(latLng);
            //建立Gson物件，以便將資料轉成Json格式。
            Gson gson = new Gson();
            //透過IP和資料庫名稱找到資料庫。
            String url = Common.URL+"/foundation/getFoundationPage4App";
            //建立JsonObject
            JsonObject jsonObject = new JsonObject();
            //jsonObject新增屬性action其值為getStoreByDistance
            jsonObject.addProperty("action", "getFoundation");
            //jsonObject新增屬性sortNumber其值為userLocation
            //jsonObject.addProperty("userLocation", userLocation);
            //將jsonObject轉成json格式的字串。
            String jsonOut = jsonObject.toString();
            Log.d("jsonObject",jsonObject.toString());
            StoreTask = new CommonTask(url, jsonOut);

            try {
                //用字串儲存伺服器回應的json格式字串。
                String jsonIn = StoreTask.execute().get();
                Log.d("jsonIn",jsonIn);
                //利用TypeToken指定資料型態為List<Store>
                Type listType = new TypeToken<List<FoundationBean_HO73>>() {
                }.getType();
                //利用Gson把json字串轉成Type指定的型態(List<SortAs>)後放入sortAsList(List<SortAs>)。
                StoreList = gson.fromJson(jsonIn, listType);

            } catch (Exception e) {
                Log.e(TAG,e.toString());
            }
            if (StoreList == null || StoreList.isEmpty()) {
                //當伺服器回傳空的List時顯示給使用者"查無資料"。
                //System.out.println("StoreDAOLIST IS EMPTY");
                //  Common.showToast(inputActivity, "查無資料");
            } else {
                System.out.println("StoreDAOLIST" + StoreList.size());
                //回傳StoreList。
                return StoreList;
            }
        } else {
            Common.showToast(inputActivity, "no network connection available");
        }
        return StoreList;
    }

    public List<FoundationBean_HO73> getCollectionListByUser(String userCollection) {
        if (Common.networkConnected(inputActivity)) {
            StoreList = null;
            //建立Gson物件，以便將資料轉成Json格式。
            Gson gson = new Gson();
            //透過IP和資料庫名稱找到資料庫。
            String url = Common.URL+"/appStore";
            //建立JsonObject
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("action", "getCollectionByUser");
            jsonObject.addProperty("userCollection",userCollection);
            String jsonOut = jsonObject.toString();
            Log.d("jsonObject",jsonObject.toString());
            StoreTask = new CommonTask(url, jsonOut);
            try {
                //用字串儲存伺服器回應的json格式字串。
                String jsonIn = StoreTask.execute().get();
                Log.d("jsonIn",jsonIn);
                //利用TypeToken指定資料型態為List<Store>
                Type listType = new TypeToken<List<FoundationBean_HO73>>() {
                }.getType();
                //利用Gson把json字串轉成Type指定的型態(List<SortAs>)後放入sortAsList(List<SortAs>)。
                StoreList = gson.fromJson(jsonIn, listType);
            } catch (Exception e) {
                Log.e(TAG,e.toString());
            }
            if (StoreList == null || StoreList.isEmpty()) {
                //當伺服器回傳空的List時顯示給使用者"查無資料"。
                // Common.showToast(inputActivity, "查無資料");
            } else {
                //回傳StoreList。
                return StoreList;
            }
        } else {
            Common.showToast(inputActivity, "no network connection available");
        }
        return StoreList;
    }


}
