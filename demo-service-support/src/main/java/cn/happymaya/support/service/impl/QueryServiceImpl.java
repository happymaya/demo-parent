package cn.happymaya.support.service.impl;

import cn.happymaya.support.dao.QueryDao;
import cn.happymaya.support.entity.ResultSet;
import cn.happymaya.support.service.QueryService;

import java.util.Collection;
import java.util.Map;

/**
 * The implement of to generate query service.
 *
 * @author superhsc
 */
public class QueryServiceImpl implements QueryService {

    private QueryDao queryDao;

    /**
     * @return the queryDao
     */
    public QueryDao getQueryDao() {
        return queryDao;
    }

    /**
     * @param queryDao the queryDao to set
     */
    public void setQueryDao(QueryDao queryDao) {
        this.queryDao = queryDao;
    }

    @Override
    public ResultSet query(Map<String, Object> params) {
        ResultSet resultSet = new ResultSet();
        page(params, resultSet);
        aggregate(params, resultSet);

        beforeQuery(params);
        Collection<?> result = queryDao.query(params);
        resultSet.setData(result);
        resultSet = afterQuery(params, resultSet);
        return resultSet;
    }

    /**
     * do something before query.
     * It just a hood that override the function in subclass if we need do something before query.
     *
     * @param params the parameters the query need
     */
    protected void beforeQuery(Map<String, Object> params) {
        // just a hood
    }

    /**
     * @param params    the parameters the query need
     * @param resultSet the result set after query.
     * @return the result after query
     */
    protected ResultSet afterQuery(Map<String, Object> params, ResultSet resultSet) {
        // just a hood
        return resultSet;
    }

    /**
     * @param params    the parameters the query need
     * @param resultSet the result set after query.
     */
    private void page(Map<String, Object> params, ResultSet resultSet) {
        if (params == null || params.isEmpty()) {
            return;
        }
        Object page = params.get("page");
        Object size = params.get("size");
        Object count = params.get("count");

        long cnt = (count == null) ? queryDao.count(params) : new Long(count.toString());
        resultSet.setCount(cnt);

        if (size == null) {
            return;
        }
        int p = (page == null) ? 0 : new Integer(page.toString());
        int s = new Integer(size.toString());
        int firstRow = p * s;
        params.put("page", p);
        params.put("size", s);
        params.put("firstRow", firstRow);
        resultSet.setPage(p);
        resultSet.setSize(s);
    }

    /**
     * @param params    the parameters the query need
     * @param resultSet the result set after query.
     */
    private void aggregate(Map<String, Object> params, ResultSet resultSet) {
        if (params == null || params.isEmpty()) {
            return;
        }
        @SuppressWarnings("unchecked") Map<String, String> aggregation = (Map<String, String>) params.get("aggregation");
        if (aggregation == null || aggregation.isEmpty()) {
            return;
        }

        @SuppressWarnings("unchecked") Map<String, Object> aggValue = (Map<String, Object>) params.get("aggValue");
        if (aggValue == null) {
            aggValue = queryDao.aggregate(params);
        }
        resultSet.setAggregation(aggValue);
    }
}
