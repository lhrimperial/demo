package com.handy.demo.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author longhairen
 * @create 2017-09-02 11:09
 * @description
 **/
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
