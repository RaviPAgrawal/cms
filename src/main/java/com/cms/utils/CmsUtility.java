package com.cms.utils;

import java.util.HashMap;
import java.util.Map;

import com.cms.constants.CmsConstants;

/**
 * Created by raviagrawal on 06/04/17.
 */
public class CmsUtility {
    public static Map<String, Object> getSuccessResultMap() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(CmsConstants.SUCCESS, Boolean.TRUE);
        return result;
    }
}
