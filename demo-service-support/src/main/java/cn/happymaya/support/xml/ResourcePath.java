package cn.happymaya.support.xml;

import java.io.IOException;

/**
 * read resources by loader.
 * @author superhsc
 */
public interface ResourcePath {

    /**
     * read resources by loader
     * @return the array of Resources
     * @throws IOException
     */
    public Resource[] getResources() throws IOException;

    /**
     * @param filter the file filter
     */
    public void setFilter(Filter filter);

    /**
     * @return the file filter
     */
    public Filter getFilter();
}