package com.vincent.evaluating_system.util;

import com.vincent.evaluating_system.entity.patient.StateTemp;

import java.io.*;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：12:00
 */
public class BlobTempUtil {
    public static StateTemp blobToStateTemp(byte[] stateBlob) {
        StateTemp stateTemp = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(stateBlob));
            stateTemp = (StateTemp) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stateTemp;
    }


    public static byte[] stateTempToStateBlob(StateTemp stateTemp) {
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(stateTemp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

}
