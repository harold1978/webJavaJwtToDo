/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemm2025.practicatodo.Crud;

import com.hemm2025.practicatodo.modelos.Tareas;
import com.hemm2025.practicatodo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class crud {

    Transaction tx = null;

    public boolean agregarToDo(Tareas tarea) {
        try {
            Session sesion = HibernateUtil.getSesionFactory().openSession();
            tx = sesion.beginTransaction();
            sesion.persist(tarea);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean eliminarToDo(int id) {
        try {
            Session sesion = HibernateUtil.getSesionFactory().openSession();
            tx = sesion.beginTransaction();
            Tareas t = sesion.get(Tareas.class, id);
            if (t != null) {
                sesion.remove(t);
            }
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Tareas> lista() {
        List<Tareas> l = null;
        try {
            Session sesion = HibernateUtil.getSesionFactory().openSession();
            l = sesion.createQuery("from Tareas").list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    public boolean actualizarToDo(Tareas tarea) {
        try {
            Session sesion = HibernateUtil.getSesionFactory().openSession();
            tx = sesion.beginTransaction();
            sesion.merge(tarea);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Tareas getToDo(int id) {
        Tareas tarea = null;

        try {
            Session sesion = HibernateUtil.getSesionFactory().openSession();
            tarea = sesion.get(Tareas.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tarea;
    }
}
