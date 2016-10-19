package nico.custommvp;

/**
 * Created by Administrator on 2016/10/19.
 */
public interface BaseCallBack {

    public void onSuccess(Object data);
    public void onServerFailed(Object errorObj);
    public void onNetFailed();
}
