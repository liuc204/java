package com.example.springboot.util;

import java.util.UUID;

/**
 *
 */
public class UUIDUtil {

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        //        uuid.replaceAll("-", "");
        System.out.println("uuid: " + uuid);
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(UUIDUtil.getUUID());
    }

}
