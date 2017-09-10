package com.handy.demo.base.collec;

import java.util.*;

/**
 * @author longhairen
 * @create 2017/8/17 0017 上午 8:55
 */
public class CollectionSrc {

    public static void main(String[] args){
        demo1();
    }

    public static void demo1(){
        Set<String> set = new HashSet<String>();
        set.add("AAA");
        set.add("BBB");
        set.add("CCC");
        print(set);

        //Set的第一种遍历方式:利用Iterator
        System.out.println("Set的第一种遍历方式:利用Iterator");
        Iterator<String> it1 = set.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        //Set的第一种遍历方式:利用foreach
        System.out.println("Set的第一种遍历方式:利用foreach");
        for (String sss : set) {
            System.out.println(sss);
        }

        List<String> list = new ArrayList<String>();
        list.add("DDDDD");
        list.add("EEEEE");
        list.add("FFFFF");
        print(list);

        //List的第一种遍历方式:因为list有顺序，利用size()和get()方法获取
        System.out.println("List的第一种遍历方式:因为list有顺序，利用size()和get()方法获取");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //List的第二种遍历方式：利用Iterator
        System.out.println("List的第二种遍历方式：利用Iterator");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //List的第三种遍历方式:利用foreach
        System.out.println("List的第三种遍历方式:利用foreach");
        for (String s2 : list) {
            System.out.println(s2);
        }

        Map<String,String> map = new HashMap<String, String>();
        map.put("Jerry", "10000");
        map.put("shellway", "20000");
        map.put("Kizi", "30000");
        print(map.entrySet());
        //Map的第一种遍历方式：先获得key,再获得值value
        System.out.println("Map的第一种遍历方式：先获得key,再获得值value");
        Set<String> sett = map.keySet();
        for (String s : sett) {
            System.out.println(s+":"+map.get(s));
        }
        //Map的第二种遍历方式：获得键值对
        System.out.println("Map的第二种遍历方式：获得键值对");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    public static void print(Collection<? extends Object> c){
        Iterator<? extends Object> it = c.iterator();
        while (it.hasNext()) {
            Object object = (Object) it.next();
            System.out.println(object);
        }
    }
}
