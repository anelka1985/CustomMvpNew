package nico.custommvp.login;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

import nico.custommvp.Entity.User;
import nico.custommvp.utils.Constants;

/**
 * Created by Administrator on 2016/10/14.
 */
public class LoginPresenter implements LoginDetailContact.Presenter, LoginDetailContact.Callback {

    private LoginDetailContact.View mView;
    private Context mContext;
    private LoginModel mLoginModel;



    public LoginPresenter(Context context, LoginDetailContact.View view) {
        mView = view;
        mContext = context;
        mLoginModel = new LoginModel();
        mView.setPresenter(this);
    }

    @Override
    public void start() {


        mView.showProgress();

        HashMap<String, Object> params = new HashMap<String, Object>();
        String phoneStr = "18994021025";
        String passwordStr = "123456";
        params.put("phone", phoneStr);
        params.put("password", passwordStr);


        mLoginModel.loadData(Constants.HTTP_URL_FM_LOGIN, params, this);

    }


    @Override
    public void onSuccess(Object data) {
        Gson gson = new Gson();
        User result = gson.fromJson((String)data, new TypeToken<User>(){}.getType());

        mView.showSuccess();
    }

    @Override
    public void onServerFailed(Object errorObj) {
        mView.showError();
    }

    @Override
    public void onNetFailed() {
        mView.showError();
    }
}
