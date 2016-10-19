package nico.custommvp.login;

import nico.custommvp.BaseCallBack;
import nico.custommvp.BaseModel;
import nico.custommvp.BasePresenter;
import nico.custommvp.BaseView;

/**
 * Created by Administrator on 2016/10/14.
 */
public interface LoginDetailContact {

    interface View extends BaseView<Presenter> {

        public void showProgress();

        public void showError();

        public void showSuccess();
    }

    interface Presenter extends BasePresenter{

    }

    interface Model extends BaseModel{

    }

    interface Callback extends BaseCallBack{

    }
}
