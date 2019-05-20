package com.vincent.evaluating_system.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * Created by IDEA on 2019/4/6
 * User: Vincent
 * Time：10:38
 */
public class PasswordUtil {
    private static final RandomNumberGenerator saltGen = new SecureRandomNumberGenerator();

    public static String generateSalt() {
        String salt = saltGen.nextBytes().toBase64();
        return salt;
    }

    public static String generateHashPassword(String originalPwd, String salt) {
        String hashedPwd = new Sha256Hash(originalPwd, salt, 1024).toBase64();
        return hashedPwd;
    }

    public static boolean isRight(String salt, String hashedPassword, String password) {
        return new Sha256Hash(password, salt, 1024).toBase64().equals(hashedPassword);
    }

}
