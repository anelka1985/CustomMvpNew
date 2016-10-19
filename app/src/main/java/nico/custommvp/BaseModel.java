package nico.custommvp;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/19.
 */
public interface BaseModel {
    public void loadData(String url, HashMap<String,Object> params , BaseCallBack callBack);
}
