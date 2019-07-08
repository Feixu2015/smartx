/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.encrypt

import org.junit.Test

import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.security.spec.AlgorithmParameterSpec

import java.util.Base64;

/**
 *
 * @author Feixu
 * @version $Id: EncryptTest.java, v 0.1 `2018/8/14 Feixu Exp $$
 */
class EncryptTest {
    @Test
    public String toJson(final String encrypted) {
        try {
            SecretKey key = new SecretKeySpec(Base64.decoder.decode("u/Gu5posvwDsXUnV5Zaq4g=="), "AES");
            AlgorithmParameterSpec iv = new IvParameterSpec(Base64.decoder.decode("5D9r9ZVzEYYgha93/aUK2w=="));
            byte[] decodeBase64 = Base64.decoder.decode(encrypted);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);

            return new String(cipher.doFinal(decodeBase64), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException("This should not happen in production.", e);
        }
    }
}
