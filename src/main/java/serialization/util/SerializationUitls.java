/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package serialization.util;

import java.io.*;

/**
 * 序列化工具类
 *
 * @author Feixu
 * @version $Id: SerializationUitls.java, v 0.1 2018/2/27 Feixu Exp $$
 */
public class SerializationUitls {
    private static String FILE_NAME = "obj.bin";

    public static void writeObject(Serializable s){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            objectOutputStream.writeObject(s);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObject(){
        Object obj = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj = inputStream.readObject();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
