package com.it.dev.activitylife;

import java.io.Serializable;

/**
 * implements Serializable  序列化
 */
public class User implements Serializable {
    public String title;
    public class BasicInfo implements Serializable {  // 注意 内部类同样要序列化

    }
}
