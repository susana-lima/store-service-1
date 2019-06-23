/**
 * @author: Susana Lima
 */

package edu.umss.storeservice.bootstrap;

import edu.umss.storeservice.model.Category;
import edu.umss.storeservice.model.Unit;
import edu.umss.storeservice.repository.CategoryRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;

    public DevBootstrap(UnitRepository unitRepository, CategoryRepository categoryRepository) {

        this.unitRepository = unitRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        List<Unit> unitListt = unitRepository.findAllTable();

        Unit unitOne = unitRepository.findByIdTable(1L);
        unitOne.getName();

        /*Boolean isDeleted = unitRepository.deleteByIdTable(2L);
        if(isDeleted){
            System.out.println("Unit deleted");
        }*/

        List<Category> categoryList = categoryRepository.findAllTable();

        Category categoryOne = categoryRepository.findByIdTable(1L);
        categoryOne.getCategoryDescription();

        Boolean isDeletedCategory = categoryRepository.deleteByIdTable(2L);
        if(isDeletedCategory){
            System.out.println("Category deleted");
        }
    }
}
