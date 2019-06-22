package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Unit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class UnitRepositoryImpl implements UnitRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Unit> findAllUnit(){
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("sp_GetAll_Unit");
        query.execute();

        return query.getResultList();
    }
}
