package com.lazzylogging;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by shivam on 4/2/15.
 */
public final class StorageMaster {

    private StorageMaster() {
    }



    /**
     * This method writes given object in file, it looks for file on internal storage.
     * <p> To read data use {@link #writeObject(android.content.Context, String, Object)}.</p>

     * @param context application context.
     * @param key file name.
     * @param object object to store.
     * @return Nothing.
     * @throws java.io.IOException
     * @see java.io.IOException
     */
    public static void writeObject(Context context, String key, Object object) throws IOException {
        FileOutputStream fos = context.openFileOutput(key, Context.MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
        fos.close();
    }


    /**
     * This method reads object from given file, it looks for file on internal storage.
     * <p> To write data use {@link #readObject(android.content.Context, String)}.</p>

     * @param context application context.
     * @param key file name.
     *
     * @return Nothing.
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @see java.io.IOException
     * @see java.lang.ClassNotFoundException
     */
    public static Object readObject(Context context, String key) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = context.openFileInput(key);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object object = ois.readObject();
        return object;
    }
}