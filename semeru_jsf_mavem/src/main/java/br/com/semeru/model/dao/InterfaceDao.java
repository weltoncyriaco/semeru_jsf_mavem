
package br.com.semeru.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Welton
 */
public interface InterfaceDao<T> {
    void save (T entity);
    void update (T entity);
    void remove (T entity);
    void merge  (T entity);
    
    T getEntity(Serializable id);
    T getEntityByDetachedCriteria(DetachedCriteria criteria);
    List<T> getEntities();
    List<T> getListsByDetachedCriteria(DetachedCriteria criteria);
}
