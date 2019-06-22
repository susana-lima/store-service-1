/**
 * @author: Susana Lima
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.model.Unit;
import edu.umss.storeservice.repository.GenericRepository;
import edu.umss.storeservice.repository.UnitRepository;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends GenericServiceImpl<Unit> implements UnitService {
    private final UnitRepository repository;

    public UnitServiceImpl(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Unit> getRepository() {
        return repository;
    }
}
