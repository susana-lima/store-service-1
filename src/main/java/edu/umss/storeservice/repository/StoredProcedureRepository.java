/**
 * @author: Susana Lima
 */

package edu.umss.storeservice.repository;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface StoredProcedureRepository<T>{
    List<T> findAllTable();

    T findByIdTable(Long id);

    Boolean deleteByIdTable(Long id);
}
