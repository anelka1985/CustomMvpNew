package nico.custommvp;

/**
 * 自定义的view 接口  MVP 模式中的View
 */
public interface BaseView<T> {

     void setPresenter(T tp);
}
