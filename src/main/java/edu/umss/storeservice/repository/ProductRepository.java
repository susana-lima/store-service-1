/**
 * @author: Susana Lima
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>, StoredProcedureRepository<Product> {
}
