package nico.custommvp.login;

import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

import nico.custommvp.BaseCallBack;
import nico.custommvp.Entity.User;
import nico.custommvp.utils.Constants;
import nico.custommvp.utils.HttpUtils;

/**
 * Created by Administrator on 2016/10/19.
 */
public class LoginModel implements LoginDetailContact.Model{


    @Override
    public void loadData(String url, HashMap<String, Object> params, BaseCallBack callBack) {
        HttpUtils.HttpGetRequest_Asyn(Constants.HTTP_URL_FM_LOGIN, params,
                callBack, new TypeToken<User>() {
                }.getType());
    }


}
