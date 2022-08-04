package cn.happymaya.support.service;

import cn.happymaya.support.entity.ResultSet;

import java.util.Map;

/**
 * To generate query service
 * @author superhsc
 */
public interface QueryService {

    /**
     * execute query and then return ResultSet.
     * If there are 'page' and 'size' in parameters, then do page.
     * If there are 'count' in parameters, then do not execute count.
     * @param params the parameters the query need.
     * @return The ResultSet object with page, size, count, and so on.
     */
    public ResultSet query(Map<String, Object> params);

}
