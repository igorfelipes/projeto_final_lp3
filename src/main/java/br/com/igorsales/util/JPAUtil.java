/**
 *
 */
package br.com.bank.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Igor Sales
 *
 */
public class JPAUtil {

    private static EntityManagerFactory factory;

    //Singleton
    public static EntityManagerFactory getEntityManagerFactory() {
        if(factory == null) {
            factory = Persistence.createEntityManagerFactory("projeto_final");
        }
        return factory;
    }

    public static void finalFactory() {
        if(factory != null) {
            factory.close();
        }
    }
}
