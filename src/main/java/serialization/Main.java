/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package serialization;

import serialization.util.SerializationUitls;

/**
 * @author Feixu
 * @version $Id: Main.java, v 0.1 2018/2/27 Feixu Exp $$
 */
public class Main {
    public static void main(String[] args) {
        deserialize();
    }

    private static void serialize() {
        // 序列化
        Persion persion = new Persion();
        SerializationUitls.writeObject(persion);
    }

    private static void deserialize() {
        // 反序列化
        Object obj = SerializationUitls.readObject();
        if (null != obj) {
            System.out.println(obj);
        }
    }
}
