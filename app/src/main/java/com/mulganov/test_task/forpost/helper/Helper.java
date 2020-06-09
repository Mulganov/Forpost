package com.mulganov.test_task.forpost.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;

public class Helper {

    public static Bitmap loadBitmap(final String str, final String file){
        File f = getFile(str, file);
        return loadBitmap(f);
    }

    private static File getFile(String uurl, String file){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            URL url = new URL(uurl);
            bis = new BufferedInputStream(url.openStream());
            bos = new BufferedOutputStream(new FileOutputStream(new File(file)));

            int c;
            while ((c = bis.read()) != -1) {
                bos.write(c);
            }

            System.out.println(uurl + " OK");

            bos.close();
            bis.close();

            return new File(file);

        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(uurl + " NOT");
        }

        return null;
    }

    public static Bitmap loadBitmap(File f){
        try { // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
            // The new size we want to scale to
            int REQUIRED_SIZE = 70;
            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_SIZE &&
                    o.outHeight / scale / 2 >= REQUIRED_SIZE
            ) {
                scale *= 2;
            }
            // Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException ex) {
        }

        return null;
    }

}
