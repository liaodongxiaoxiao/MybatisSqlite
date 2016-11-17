package com.ldxx.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.UUID;

/**
 * <p>Title: [常用的公用工具类] </p>
 * <p>Description: [该类概要功能介绍描述]</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * @author <a href="mailto: [847353020@qq.com]">辽东小小</a>
 * @update [修改人] [修改时间]
 * @version $Revision$
 */
public class PublicUtils {
    /**
     * <p>Discription:根据map的value，获取所有的key</p>
     * @param map
     * @param value
     * @return
     * @author  ldxx    2014�?�?1�?     * @update [修改人] [修改时间] [变更描述]
     */
    public static <T, E> List<T> getKeysByValue(Map<T, E> map, E value) {
        List<T> keys = new ArrayList<T>();
        for (Entry<T, E> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    /**
     * <p>Discription:String类型的List转化成字符串</p>
     * @param list
     * @return
     * @author 王卓 2013-9-30
     * @update [修改人] [修改时间] [变更描述]
     */
    public static String listToString(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        else {
            String s = "";
            for (String str : list) {
                s += str + ",";
            }
            return s.substring(0, s.length() - 1);
        }
    }

    /**
     * <p>Discription:生成长度�?2的唯�?UID�?/p>
     * @return
     * @author  ldxx    2014�?2�?�?     * @update [修改人] [修改时间] [变更描述]
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
    
    public static String setToString(Set<String> set){
    	return listToString(new ArrayList<String>(set));
    }
}
