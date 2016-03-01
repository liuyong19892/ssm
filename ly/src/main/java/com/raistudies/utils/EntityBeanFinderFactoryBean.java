package com.raistudies.utils;

import java.io.BufferedInputStream;  
import java.io.DataInputStream;  
import java.io.InputStream;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
import org.springframework.beans.factory.FactoryBean;  
import org.springframework.context.ResourceLoaderAware;  
import org.springframework.core.io.Resource;  
import org.springframework.core.io.ResourceLoader;  
import org.springframework.core.io.support.ResourcePatternResolver;  
import org.springframework.core.io.support.ResourcePatternUtils;  
  
/** 
 * This class finds all @Entity annotated classes defined by an ANT style class name pattern. Default 
 * pattern is **.domain.** 
 *  
 * @author marcus.bristav@dreampark.com 
 */  
public class EntityBeanFinderFactoryBean implements ResourceLoaderAware,  
        FactoryBean {  
    private ResourcePatternResolver resolver;  
  
    private List<Class> managedClasses = null;  
  
    private String classPattern = "classpath*:**/domain/**/*.class";  
  
    static final int UTF = 1, INTEGER = 3, FLOAT = 4, LONG = 5, DOUBLE = 6,  
            CLASS = 7, STRING = 8, FIELD_REF = 9, METHOD_REF = 10,  
            INTERFACE_METHOD_REF = 11, NAME_AND_TYPE = 12;  
  
    public void setResourceLoader(ResourceLoader resourceLoader) {  
        resolver = ResourcePatternUtils  
                .getResourcePatternResolver(resourceLoader);  
    }  
  
    /** 
     * Determines what class files to scan for @Entity annotations. The string  
     * behaves like ANT paths. Default value is "**.domain.**" 
     * @param packagePattern 
     */  
    public void setClassNamePattern(String packagePattern) {  
        classPattern = "classpath*:" + packagePattern.replace(".", "/")  
                + "/*.class";  
    }  
  
    public Object getObject() throws Exception {  
        if (managedClasses == null) {  
            loadManagedClasses();  
        }  
        return managedClasses;  
    }  
  
    public Class getObjectType() {  
        return List.class;  
    }  
  
    public boolean isSingleton() {  
        return true;  
    }  
  
    private void loadManagedClasses() throws Exception {  
        managedClasses = new ArrayList<Class>();  
        Resource[] resources = resolver.getResources(classPattern);  
        if (resources != null) {  
            for (Resource res : resources) {  
                Class klass = getClass(res);  
                if (hasEntityAnnotation(klass)) {  
                    managedClasses.add(klass);  
                }  
            }  
        }  
    }  
      
    private Class getClass(Resource res) throws Exception{  
        String className = className(res);  
        System.out.println(className);  
        return Class.forName(className);          
    }  
  
    private boolean hasEntityAnnotation(Class klass) {  
        return (klass.getAnnotation(javax.persistence.Entity.class) != null);  
    }  
  
    // Parses java class files (byte code) to find class name  
    // Must be a better way to do this...  
    private String className(Resource res) throws Exception {  
        InputStream is = res.getInputStream();  
        Map<Integer, Integer> offsetTable = new HashMap<Integer, Integer>();  
        Map<Integer, String> classNameTable = new HashMap<Integer, String>();  
        DataInputStream data = new DataInputStream(new BufferedInputStream(is));  
        int magic = data.readInt();  
        int minorVersion = data.readShort();  
        int majorVersion = data.readShort();  
        int constant_pool_count = data.readShort();  
        int[] constant_pool = new int[constant_pool_count];  
        for (int i = 1; i < constant_pool_count; i++) {  
            int tag = data.read();  
            int tableSize;  
            switch (tag) {  
            case CLASS:  
                int offset = data.readShort();  
                offsetTable.put(i, offset);  
                break;  
            case UTF:  
                int length = data.readShort();  
                char[] bytes = new char[length];  
                for (int k = 0; k < bytes.length; k++)  
                    bytes[k] = (char) data.read();  
                String className = new String(bytes);  
                classNameTable.put(i, className);  
                break;  
            case LONG:  
            case DOUBLE:  
                data.readLong();  
                i++;  
                break;  
            case STRING:  
                data.readShort();  
                break;  
            default:  
                data.readInt();  
            }  
        }  
        short access_flags = data.readShort();  
        int this_class = data.readShort();  
        int super_class = data.readShort();  
        String thisClassName = classNameTable.get(offsetTable.get(this_class));  
        is.close();  
        return thisClassName.replace("/", ".");  
    }  
} 