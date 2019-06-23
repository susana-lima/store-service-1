package edu.umss.storeservice.bootstrap;

import edu.umss.storeservice.model.Unit;
import edu.umss.storeservice.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UnitRepository unitRepository;

    public DevBootstrap(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        List<Unit> testUnit = unitRepository.findAllTable();
        testUnit.size();
    }
}
