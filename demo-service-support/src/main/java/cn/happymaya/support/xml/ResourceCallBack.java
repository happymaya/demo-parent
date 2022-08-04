package cn.happymaya.support.xml;

import java.io.InputStream;

/**
 * @author superhsc
 */
@FunctionalInterface
public interface ResourceCallBack {
    /**
     * @param inputStream
     */
    void apply(InputStream inputStream);
}

