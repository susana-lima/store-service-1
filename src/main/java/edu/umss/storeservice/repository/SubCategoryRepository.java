/**
 * @author: Susana Lima
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.SubCategory;
import org.springframework.data.repository.CrudRepository;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Long>, StoredProcedureRepository<SubCategory> {
}
