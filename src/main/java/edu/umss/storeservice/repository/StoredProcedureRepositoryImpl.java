package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.ModelBase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class StoredProcedureRepositoryImpl<T extends ModelBase> implements StoredProcedureRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    /*@Override
    public List<T> findAllTable(){
        String typeName = (((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf(".") + 1);

        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("sp_GetAll_Unit");
        query.execute();

        return (List<T>) query.getResultList();
    }*/
}
