
package com.hemm2025.practicatodo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class HibernateUtil {
    private static  final SessionFactory sesion = new Configuration().configure().buildSessionFactory();
    public static SessionFactory getSesionFactory(){
        return sesion;
    }
}
