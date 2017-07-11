package com.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Administrator on 2017/4/12.
 */

public class GsonUtil<T> {
    private static Gson gson;


    public GsonUtil() {

    }

    public static void getJson() {

    }

    /**
     * GsonBuilder有以下主要的功能：

     1.  serializeNulls:把json中的””,转换为null；


     2、    setPrettyPrinting:把json无格式字符串转换为带格式的字符串；


     3、    excludeFieldsWithModifiers(Modifier.PRIVATE):Gson在解析时，把类中字段的PRIVATE访问权限排除，
     就是遇到private修饰的字段时，Gson不做解析；
     （还可以对有final，static等修饰的变量，或者修饰类的abstract，或者类是接口的等等，都可以做出控制解析）


     8、     setDateFormat("yyyy-MM-dd HH:mm:ss"):
     把解析后的是Date类型的字段格式都转换为yyyy-MM-dd HH:mm:ss类型，Gson对日期设置的有好三种，不在累述，网上也有。
     *
     */

    public static Gson getGson() {
        if (gson == null) {
            GsonBuilder gb = new GsonBuilder();
//                    .registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory())
//                    .serializeNulls()
//                    .registerTypeAdapter(String.class, new StringConverter());
            gson = gb.create();
            //gson 非空统一解决
        }
        return gson;
    }


//    public T formateJson2Bean(String json, Class cls) {
//
//
//        return (T) getGson().fromJson(json, cls);
//
//    }

    public static <E> E formateJson2Bean(String json, Class<E> cls) {

//        System.out.println(t.getClass());


        return (E) getGson().fromJson(json, cls);
    }


    public static String Bean2Json(Object object) {
        String json = "";
//        System.out.println(t.getClass());
        json = getGson().toJson(object);
        return json;
    }


}
