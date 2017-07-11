package com.gson;

/**
 * Created  罗擦擦
 */

public class PorgramDetailGsonBean {

    public String code = "";
    public String msg = "";

    public DataBeanX data;

    public static class DataBeanX {
        public MyProgramGsonBean.DataBeanX.PageBean.DataBean project = new MyProgramGsonBean.DataBeanX.PageBean.DataBean();


        @Override
        public String toString() {
            return "DataBeanX{" +
                    "project=" + project +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "PorgramDetailGsonBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
