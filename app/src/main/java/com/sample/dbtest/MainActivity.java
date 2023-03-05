package com.sample.dbtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import static android.os.Build.ID;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<Item> items = new ArrayList<>();

    ItemAdapter adapter;

    EditText search_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        adapter = new ItemAdapter(this, items);
        recyclerView.setAdapter(adapter);
        search_bar = findViewById(R.id.search_bar);

        //리사이클러뷰의 레이아웃 매니저 설정
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)) ;
    }

    public void clickLoad(View view) {
        String SB = search_bar.getText().toString();
        String ID = "id";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                items.clear(); //일단 깨끗하게 처리함
                adapter.notifyDataSetChanged();
                try {
                    JSONArray searcharray = new JSONArray(response);
                    for(int i=0;i<response.length();i++){
                        JSONObject jsonObject = searcharray.getJSONObject(i);

                        int C_id= Integer.parseInt(jsonObject.getString("C_id")); //no가 문자열이라서 바꿔야함.
                        String C_title =jsonObject.getString("C_title");
                        String C_info =jsonObject.getString("C_info");
                        String C_img =jsonObject.getString("C_img");
                        String C_href =jsonObject.getString("C_href");
                        String C_notice =jsonObject.getString("C_notice");
                        //String C_date =jsonObject.getString("C_date");
                        String C_date =jsonObject.getString("C_notice").replaceAll("[^0-9]", "");

                        items.add(0,new Item(C_id, C_title, C_info, C_img, C_href, C_notice, C_date)); // 첫 번째 매개변수는 몇번째에 추가 될지, 제일 위에 오도록
                        adapter.notifyItemInserted(0);
                    }
                } catch (JSONException e) {e.printStackTrace();}

            }
        };
        // 서버로 Volley를 이용해서 요청을 함.
        SearchRequest searchRequest = new SearchRequest(SB, ID, responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(searchRequest);

    }

    public void clickPaid(View view) {
        String SB = search_bar.getText().toString();
        String ID = "id";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                items.clear(); //일단 깨끗하게 처리함
                adapter.notifyDataSetChanged();
                try {
                    JSONArray searcharray = new JSONArray(response);
                    for(int i=0;i<response.length();i++){
                        JSONObject jsonObject = searcharray.getJSONObject(i);

                        int C_id= Integer.parseInt(jsonObject.getString("C_id")); //no가 문자열이라서 바꿔야함.
                        String C_title =jsonObject.getString("C_title");
                        String C_info =jsonObject.getString("C_info");
                        String C_img =jsonObject.getString("C_img");
                        String C_href =jsonObject.getString("C_href");
                        String C_notice =jsonObject.getString("C_notice");
                        String C_date =jsonObject.getString("C_notice").replaceAll("[^0-9]", "");

                        items.add(0,new Item(C_id, C_title, C_info, C_img, C_href, C_notice, C_date)); // 첫 번째 매개변수는 몇번째에 추가 될지, 제일 위에 오도록
                        adapter.notifyItemInserted(0);
                    }
                } catch (JSONException e) {e.printStackTrace();}
            }
        };
        // 서버로 Volley를 이용해서 요청을 함.
        PaidRequest paidRequest = new PaidRequest(SB, ID, responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(paidRequest);

    }

    public void clickRest(View view) {
        String SB = search_bar.getText().toString();
        String ID = "id";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                items.clear(); //일단 깨끗하게 처리함
                adapter.notifyDataSetChanged();
                try {
                    JSONArray searcharray = new JSONArray(response);
                    for(int i=0;i<response.length();i++){
                        JSONObject jsonObject = searcharray.getJSONObject(i);

                        int C_id= Integer.parseInt(jsonObject.getString("C_id")); //no가 문자열이라서 바꿔야함.
                        String C_title =jsonObject.getString("C_title");
                        String C_info =jsonObject.getString("C_info");
                        String C_img =jsonObject.getString("C_img");
                        String C_href =jsonObject.getString("C_href");

                        String C_notice =jsonObject.getString("C_notice");
                        String C_date =jsonObject.getString("C_notice").replaceAll("[^0-9]", "");

                        items.add(0,new Item(C_id, C_title, C_info, C_img,C_href, C_notice, C_date)); // 첫 번째 매개변수는 몇번째에 추가 될지, 제일 위에 오도록
                        adapter.notifyItemInserted(0);
                    }
                } catch (JSONException e) {e.printStackTrace();}

            }
        };
        // 서버로 Volley를 이용해서 요청을 함.
        RestRequest restRequest = new RestRequest(SB, ID, responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(restRequest);

    }
}