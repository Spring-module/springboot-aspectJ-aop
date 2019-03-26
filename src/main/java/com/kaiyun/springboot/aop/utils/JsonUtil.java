/**
 * Project Name:springboot-aspectJ-aop
 * File Name:JsonUtil.java
 * Package Name:com.kaiyun.springboot.aop.utils
 * Date:2019年3月26日上午11:19:33
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.aop.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * ClassName:JsonUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年3月26日 上午11:19:33 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class JsonUtil {

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
    }

}

