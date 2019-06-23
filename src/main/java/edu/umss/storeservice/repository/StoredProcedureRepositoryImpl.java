package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.ModelBase;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class StoredProcedureRepositoryImpl<T extends ModelBase> implements StoredProcedureRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<T> findAllTable(){
        String typeName = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                .getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf('.') + 1);

        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("sp_GetAll_"+typeName);
        query.execute();

        return (List<T>) query.getResultList();
    }
}
