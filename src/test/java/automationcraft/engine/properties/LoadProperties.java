package automationcraft.engine.properties;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class LoadProperties {
    /**
     * funcion para cargar archivos de properties
     * @param file : nombre de archivo properties
     * @return objeto Properties
     */
    public static Properties init_prop(){
        String file = "config";
        //Obtengo un objeto enumeracion con las llaves del archivo
        Properties propiedades = new Properties();
        ResourceBundle bundle = ResourceBundle.getBundle(file);
        Enumeration e = bundle.getKeys();

        //guardo las propiedades del archivo en el objeto propiedades
        String key = null;
        while (e.hasMoreElements()){
            key = (String) e.nextElement();
            propiedades.put(key,bundle.getObject(key));
        }
        return propiedades;
    }
}
