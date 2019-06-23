/**
 * @author: Susana Lima
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Unit;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepository extends CrudRepository<Unit, Long>, StoredProcedureRepository<Unit>{
}
