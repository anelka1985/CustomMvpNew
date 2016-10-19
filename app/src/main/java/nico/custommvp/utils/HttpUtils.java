/**
 * @Project TestOkHttp
 * @Filename HttpUtils.java
 * @Package com.nico.testokhttp
 * @Description TODO
 * @Author wifiunion
 * @Creation 2016年5月5日 下午2:15:53
 * @Modification 2016年5月5日 下午2:15:53
 * @Copyright Copyright © 2012 - 2016 wifiunion.All Rights Reserved.
 **/
package nico.custommvp.utils;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import nico.custommvp.BaseCallBack;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @ClassName HttpUtils
 * @Description TODO
 * @Version
 * @Author wifiunion
 * @Creation 2016年5月5日 下午2:15:53
 * @Modification 2016年5月5日 下午2:15:53
 **/
public class HttpUtils {
    private static HttpUtils mInstance;
    private OkHttpClient mOkHttpClient;
    /**
     * json 类型
     */
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 上传文件用的到流类型
     */
    private static final MediaType MEDIA_TYPE_IMG = MediaType.parse("application/octet-stream");

    private static final String TAG = "HttpUtils";

    private Handler mDelivery;

    private HttpUtils() {
//        mOkHttpClient = new OkHttpClient();
//        mOkHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
//        mOkHttpClient.setWriteTimeout(30, TimeUnit.SECONDS);
//        mOkHttpClient.setReadTimeout(30, TimeUnit.SECONDS);


        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .build();
        // 设置缓存
//        File sdcache = context.getExternalCacheDir();
//        int cacheSize = 50 * 1024 * 1024; // 10 MiB

//        mDelivery = new Handler(Looper.getMainLooper());
//        mOkHttpClient.networkInterceptors().add(new StethoInterceptor());
//        mOkHttpClient.setCache(new Cache(sdcache.getAbsoluteFile(), cacheSize));
    }

    public static HttpUtils getInstance() {
        if (mInstance == null) {
            synchronized (HttpUtils.class) {
                if (mInstance == null) {
                    mInstance = new HttpUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     * 同步的Get请求
     *
     * @param url
     * @return Response
     */
    private Response _getAsyn(String url) throws IOException {
        final Request request = new Request.Builder().url(url).build();
        Call call = mOkHttpClient.newCall(request);
        Response execute = call.execute();
        return execute;
    }

    /**
     * 同步的Get请求
     *
     * @param url
     * @return 字符串
     */
    private String _getAsString(String url) throws IOException {
        Response execute = _getAsyn(url);
        return execute.body().string();
    }



    /**
     * @param url
     * @param params
     * @param type
     * @return void
     * @throws UnsupportedEncodingException
     * @Name _getAsyn
     * @Description 异步的get请求
     * @Author wifiunion
     * @Date 2016年5月5日 下午3:57:40
     */
    private void HttpGetRequest_Asyn_Real(String url, HashMap<String, Object> params, BaseCallBack callback,
                                          java.lang.reflect.Type type) {

        StringBuffer requesturl = new StringBuffer(Constants.HTTP_URL_HEADER + url);

        String authtoken = "";
        // 有参数
        if (!params.isEmpty()) {
            // 有auth
            if (params.containsKey("Authorization")) {
                // 添加Authorization
                authtoken = (String) params.get("Authorization");
                if (TextUtils.isEmpty(authtoken)) {
                    return;
                }
                params.remove("Authorization");
            }
            // 拼接httpurl
            Iterator iter = params.entrySet().iterator();
            while (iter.hasNext()) {
                HashMap.Entry<String, Object> entry = (HashMap.Entry<String, Object>) iter.next();
                Object paramname = entry.getKey();
                Object paramvalue = entry.getValue();
                try {
                    requesturl.append(paramname + "=" + URLEncoder.encode((String) paramvalue, "utf-8") + "&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

        }
        if (requesturl.lastIndexOf("&") == requesturl.length() - 1) {
            requesturl.deleteCharAt(requesturl.length() - 1);
        }

        Request request;

        if (TextUtils.isEmpty(authtoken)) {
            request = new Request.Builder().url(requesturl.toString()).build();
        } else {
            request = new Request.Builder().url(requesturl.toString()).addHeader("Authorization", authtoken).build();
        }

        deliveryHttpGetResult(request, callback, type);
    }













    private String getFileName(String path) {
        int separatorIndex = path.lastIndexOf("/");
        return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
    }


    private void setErrorResId(final ImageView view, final int errorResId) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                view.setImageResource(errorResId);
            }
        });
    }


    /**
     * @param url
     * @param params
     * @param type
     * @return void
     * @throws UnsupportedEncodingException
     * @Name getAsyn
     * @Description 异步的httpget请求
     * @Author wifiunion
     * @Date 2016年5月5日 下午3:00:57
     */
    public static void HttpGetRequest_Asyn( String url, HashMap<String, Object> params, BaseCallBack callback,
                                           java.lang.reflect.Type type) {
        getInstance().HttpGetRequest_Asyn_Real(url, params, callback, type);
    }





    private Request buildMultipartFormRequest(String url, File[] files, String[] fileKeys, Param[] params) {
        params = validateParam(params);

//        MultipartBuilder builder = new MultipartBuilder().type(MultipartBuilder.FORM);

        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Param param : params) {

            builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + param.key + "\""),
                    RequestBody.create(null, param.value));
        }
        if (files != null) {
            RequestBody fileBody = null;
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                String fileName = file.getName();
                fileBody = RequestBody.create(MediaType.parse(guessMimeType(fileName)), file);
                builder.addPart(Headers.of("Content-Disposition",
                        "form-data; name=\"" + fileKeys[i] + "\"; filename=\"" + fileName + "\""), fileBody);
            }
        }

        RequestBody requestBody = builder.build();
        return new Request.Builder().url(url).post(requestBody).build();
    }

    private String guessMimeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = fileNameMap.getContentTypeFor(path);
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }

    private Param[] validateParam(Param[] params) {
        if (params == null)
            return new Param[0];
        else
            return params;
    }

    private Param[] map2Params(Map<String, String> params) {
        if (params == null)
            return new Param[0];
        int size = params.size();
        Param[] res = new Param[size];
        Set<Map.Entry<String, String>> entries = params.entrySet();
        int i = 0;
        for (Map.Entry<String, String> entry : entries) {
            res[i++] = new Param(entry.getKey(), entry.getValue());
        }
        return res;
    }

    private String map2JsonString(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        Gson gson = new Gson();
        String jsonStr = gson.toJson(params);
        return jsonStr;
    }



    /**
     * @param request
     * @Name deliveryResult
     * @Description 发送请求请求
     * @rurn void
     * @Author wifiunion
     * @Date 2016年5月5日 下午3:06:57
     */
    private void deliveryHttpGetResult(Request request, final BaseCallBack callback, final java.lang.reflect.Type type
                                       ) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                // sendFailedStringCallback(request, e, callback);

//                Message msg = handler.obtainMessage();
//                msg.what = Constants.NET_FAILURE;
//                handler.sendMessage(msg);
                callback.onServerFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) {

                try {
                    String respStr = response.body().string();
                    JSONObject jsonObject = new JSONObject(respStr);
//                    Message msg = handler.obtainMessage();
                    if (jsonObject.has("messageCode") && "SYS9999".equals(jsonObject.getString("messageCode"))) {
//                        msg.what = Constants.FAILURE;
//                        msg.obj = jsonObject.getString("message");
//                        handler.sendMessage(msg);
                        callback.onServerFailed(jsonObject.getString("message"));
                    } else if (jsonObject.has("messageCode") && "BUI0001".equals(jsonObject.getString("messageCode"))) {
                        // 用户身份不正确
//                        context.sendBroadcast(new Intent(Constants.AUTHTOKEN_OUTDATE_ACTION));
                        callback.onServerFailed("用户身份不正确");
                    } else {
                        if (jsonObject.has("result")) {
                            if (1 == jsonObject.getInt("result")) {
                                if (jsonObject.has("data")) {
                                    if (type == null) {
//                                        msg.what = Constants.SUCCESS;
//                                        handler.sendMessage(msg);
                                        callback.onSuccess(null);
                                    } else {
//                                        Gson gson = new Gson();
                                        String data = jsonObject.getString("data");
//                                        Object result = gson.fromJson(data, type);
//                                        msg.obj = result;
//                                        msg.what = Constants.SUCCESS;
//                                        handler.sendMessage(msg);

                                        callback.onSuccess(data);
                                    }

                                }
                            } else {
//                                msg.what = Constants.FAILURE;
//                                msg.obj = jsonObject.getString("message");
//                                handler.sendMessage(msg);
                                callback.onServerFailed(jsonObject.getString("message"));
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
//                    if (handler != null) {
//                        Message msg = handler.obtainMessage();
//                        msg.what = Constants.OTHER_FAILURE;
//                        handler.sendMessage(msg);
//                    }
                    callback.onServerFailed(null);
                }
            }
        });
    }




    public interface StringCallback {
        void onFailure(Request request, IOException e);

        void onResponse(String response);
    }

    public static class Param {
        public Param() {
        }

        public Param(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String key;
        String value;
    }

}