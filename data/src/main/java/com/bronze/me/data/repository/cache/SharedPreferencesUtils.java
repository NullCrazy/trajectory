package com.bronze.me.data.repository.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import javax.inject.Inject;

public final class SharedPreferencesUtils {
    private Context context;

    @Inject
    public SharedPreferencesUtils(Context context) {
        this.context = context;
    }


    /**
     * 可以将序列化后的对象存入指定的文件中
     *
     * @param key 键
     * @param obj 需要存入的值
     * @param name 存入文件的名称
     * @param <T>
     */
    public <T> void putObject(String key, T obj, String name) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                name, context.MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {

            out = new ObjectOutputStream(baos);
            out.writeObject(obj);
            String objectVal = new String(Base64.encode(baos.toByteArray(),
                    Base64.DEFAULT));
            editor.putString(key, objectVal);
            editor.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 能将SharedPreferences中指定的key反序列化成 T类型
     *
     * @param key 键
     * @param clazz 所需要反序列的类型
     * @return T
     */
    public <T> T getObject(String key, Class<T> clazz, String name) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                name, context.MODE_PRIVATE);
        if (sharedPreferences.contains(key)) {
            String objectVal = sharedPreferences.getString(key, null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                T t = (T) ois.readObject();
                return t;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     *  清除所有数据
     * @param name 所需要清除数据文件的 文件名
     */
    public void clear(String name) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                name, context.MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * 存入 boolen, Sting, Int, Float, Long
     *
     * @param key   键
     * @param object 值
     * @param name 文件名
     */
    public void put(String key, Object object, String name) {
        String type = object.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(name,
                context.MODE_PRIVATE);
        Editor editor = sp.edit();

        if ("String".equals(type)) {
            editor.putString(key, (String) object);
        } else if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) object);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) object);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) object);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) object);
        }

        editor.commit();
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param key 键
     * @param defaultObject 值
     * @return defaultObject
     */
    public Object getParam(String key, Object defaultObject, String name) {
        String type = defaultObject.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(name,
                context.MODE_PRIVATE);

        if ("String".equals(type)) {
            return sp.getString(key, (String) defaultObject);
        } else if ("Integer".equals(type)) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if ("Boolean".equals(type)) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if ("Float".equals(type)) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if ("Long".equals(type)) {
            return sp.getLong(key, (Long) defaultObject);
        }
        return null;
    }
}
