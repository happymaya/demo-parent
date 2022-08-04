package cn.happymaya.support.web;

import cn.happymaya.support.entity.ResultSet;
import cn.happymaya.support.exception.QueryException;
import cn.happymaya.support.service.QueryService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * To generate query controller
 * @author fangang
 */
@RestController
public class QueryController {
    @Autowired
    private ApplicationContext applicationContext = null;

    @RequestMapping(value="query/{bean}", method= {RequestMethod.GET, RequestMethod.POST})
    public ResultSet query(@PathVariable("bean")String beanName, HttpServletRequest request) {
        QueryService service = getBean(beanName);

        Map<String, Object> params = new HashMap<>();
        for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
            String key = e.nextElement();
            String value = request.getParameter(key);
            params.put(key, value);
        }
        return service.query(params);
    }

    /**
     * get bean in the spring context by name.
     * @param name the bean name
     * @return the instance of the bean
     */
    private QueryService getBean(String name) {
        if(name==null||name.isEmpty()) throw new QueryException("The bean name is empty!");
        try {
            return (QueryService)applicationContext.getBean(name);
        } catch (NoSuchBeanDefinitionException e) {
            throw new QueryException("No such bean definition in the spring context!", e);
        } catch (BeansException e) {
            throw new QueryException("error when get the bean["+name+"]");
        }
    }
}
