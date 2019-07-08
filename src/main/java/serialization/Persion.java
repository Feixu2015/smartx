/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package serialization;

import java.io.Serializable;

/**
 * 人
 *
 * @author Feixu
 * @version $Id: Persion.java, v 0.1 2018/2/27 Feixu Exp $$
 */
public class Persion implements Serializable {

    private static final long serialVersionUID = -7109459858057466757L;
    public final String name;

    public Persion() {
        name = "天使";
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                '}';
    }
}
