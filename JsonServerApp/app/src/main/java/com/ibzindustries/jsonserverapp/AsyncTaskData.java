package com.ibzindustries.jsonserverapp;

import android.content.Context;
import android.os.AsyncTask;

import com.ibzindustries.jsonserverapp.modelClass.Merchant;
import com.ibzindustries.jsonserverapp.modelClass.Product;
import com.ibzindustries.jsonserverapp.modelClass.ProductCategory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class AsyncTaskData extends AsyncTask<String,Void, ArrayList<Product>> {

    WeakReference<AdapterRv> adapterWeak;
    Context context;

    public AsyncTaskData(WeakReference<AdapterRv> adapterWeak, Context context) {
        this.adapterWeak = adapterWeak;
        this.context = context;
    }

    @Override
    protected void onPostExecute(ArrayList<Product> products) {
        AdapterRv adapterRv = adapterWeak.get();

    }

    public String loadJsonDataFromApi(String urlParam){
        String json = null;
        try{
            HttpURLConnection connection = null;
            URL url = new URL(urlParam);
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);

                StringBuffer sb = new StringBuffer();
                String eachline;
                while ((eachline = reader.readLine()) != null){
                    sb.append(eachline);
                    System.out.println(eachline);
                }
                json = sb.toString();
            }catch (IOException e){
                e.printStackTrace();
            }
            finally {
                if(connection != null){
                    connection.disconnect();
                }
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
            return e.getMessage();
        }
        return json;
    }

    public ArrayList<Product> deserializeJson(String jsonParam){
        ArrayList<Product> data = new ArrayList<>();
        String json = jsonParam;
        try {
            JSONObject jsonStart = new JSONObject(json);
            JSONArray jsonData = jsonStart.getJSONArray("data");
            for (int i = 0; i<jsonData.length();i++){

                JSONObject jsonObject = jsonData.getJSONObject(i);

                int productId = jsonObject.getInt("productId");
                String productName = jsonObject.getString("productName");
                String productSlug = jsonObject.getString("productSlug");
                int productQty = jsonObject.getInt("");
                String productImage = jsonObject.getString("productImage");

                ArrayList<Merchant> merchants = new ArrayList<>();
                JSONObject jsonMerchant = jsonObject.getJSONObject("merchant");
                int merchantId = jsonMerchant.getInt("merchantId");
                String merchantName = jsonMerchant.getString("merchantName");
                String merchantSlug = jsonMerchant.getString("merchantSlug");
                Merchant merchant = new Merchant(merchantId,merchantName, merchantSlug);
                merchants.add(merchant);

                ArrayList<ProductCategory> categories = new ArrayList<>();
                JSONObject jsonCategory = jsonObject.getJSONObject("category");
                int categoryId = jsonCategory.getInt("categoryId");
                String categoryName = jsonCategory.getString("categoryName");

                ProductCategory category = new ProductCategory(categoryId,categoryName);
                categories.add(category);

                Product product = new Product(productId,productName,productSlug,productQty,productImage,merchant,category);
                data.add(product);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    protected ArrayList<Product> doInBackground(String... url) {
        ArrayList<Product> products = new ArrayList<>();
        String json = loadJsonDataFromApi(url[0]);
        products = deserializeJson(json);

        return products;
    }
}
