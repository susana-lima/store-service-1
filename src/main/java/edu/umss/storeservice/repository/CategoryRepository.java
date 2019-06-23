/**
 * @author: Susana Lima
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>, StoredProcedureRepository<Category> {

}
