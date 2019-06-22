package edu.umss.storeservice.bootstrap;

import edu.umss.storeservice.model.Unit;
import edu.umss.storeservice.repository.UnitRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private UnitRepository unitRepository;

    public DevBootstrap(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Unit unit = new Unit();
        unit.setName("Metro");
        unitRepository.save(unit);
    }
}
