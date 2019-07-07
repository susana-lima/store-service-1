/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.ItemInstance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemInstanceRepository extends GenericRepository<ItemInstance> {
    @Query("FROM ItemInstance  WHERE featured =  :featured")
    List<ItemInstance> findFeaturedItem(@Param("featured") Boolean featured);
}
  