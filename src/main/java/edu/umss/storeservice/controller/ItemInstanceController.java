/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.ItemInstanceDto;
import edu.umss.storeservice.model.ItemInstance;
import edu.umss.storeservice.service.GenericService;
import edu.umss.storeservice.service.ItemInstanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/iteminstances")
public class ItemInstanceController extends GenericController<ItemInstance, ItemInstanceDto> {
    private ItemInstanceService service;

    public ItemInstanceController(ItemInstanceService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @GetMapping
    @Override
    protected List<ItemInstanceDto> getAll(@RequestParam Boolean... featured) {
        List<ItemInstanceDto> itemInstanceDtos = toDto(this.service.findFeaturedItem(featured[0]));
        return itemInstanceDtos;
    }
}