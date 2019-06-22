/**
 * @author: Susana Lima
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.UnitDto;
import edu.umss.storeservice.model.Unit;
import edu.umss.storeservice.service.GenericService;
import edu.umss.storeservice.service.UnitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/units")
public class UnitController extends GenericController<Unit, UnitDto> {
    private UnitService service;

    public UnitController(UnitService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}
