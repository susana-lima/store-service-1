/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.model.ItemInstance;
import edu.umss.storeservice.repository.GenericRepository;
import edu.umss.storeservice.repository.ItemInstanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemInstanceServiceImpl extends GenericServiceImpl<ItemInstance> implements ItemInstanceService {
    private final ItemInstanceRepository repository;

    public ItemInstanceServiceImpl(ItemInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<ItemInstance> getRepository() {
        return repository;
    }

    @Override
    public List<ItemInstance> findFeaturedItem(Boolean featured) {
        return repository.findFeaturedItem(featured);
    }

    public Boolean existFeaturedItem(){
       return !repository.findFeaturedItem(Boolean.TRUE).isEmpty();
    }
}
