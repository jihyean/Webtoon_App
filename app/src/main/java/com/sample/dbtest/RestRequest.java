package com.sample.dbtest;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RestRequest extends StringRequest {


    // 서버 URL 설정 ( PHP 파일 연동 )
    final static private String URL = "http://webalarm.dothome.co.kr/restlist.php";
    private Map<String, String> map;


    public RestRequest(String SB, String ID, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("SB",SB);
        map.put("ID",ID);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
