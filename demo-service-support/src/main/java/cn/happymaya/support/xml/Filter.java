package cn.happymaya.support.xml;

/**
 * The file filter
 * @author superhsc
 */
public abstract class Filter {

    /**
     * @param fileName the filename pattern such as "*.xml"
     * @return whether satisfied the filename pattern.
     */
    public abstract boolean isSatisfied(String fileName);
}
