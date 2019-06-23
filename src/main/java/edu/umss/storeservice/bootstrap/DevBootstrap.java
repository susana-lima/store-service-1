/**
 * @author: Susana Lima
 */

package edu.umss.storeservice.bootstrap;

import edu.umss.storeservice.model.Category;
import edu.umss.storeservice.model.Product;
import edu.umss.storeservice.model.SubCategory;
import edu.umss.storeservice.model.Unit;
import edu.umss.storeservice.repository.CategoryRepository;
import edu.umss.storeservice.repository.ProductRepository;
import edu.umss.storeservice.repository.SubCategoryRepository;
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
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public DevBootstrap(UnitRepository unitRepository, CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository, ProductRepository productRepository) {

        this.unitRepository = unitRepository;
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        List<Unit> unitListt = unitRepository.findAllTable();

        Unit unitOne = unitRepository.findByIdTable(1L);
        unitOne.getName();

        Boolean isDeleted = unitRepository.deleteByIdTable(2L);
        if(isDeleted){
            System.out.println("Unit deleted");
        }

        List<Category> categoryList = categoryRepository.findAllTable();

        Category categoryOne = categoryRepository.findByIdTable(1L);
        categoryOne.getCategoryDescription();

        Boolean isDeletedCategory = categoryRepository.deleteByIdTable(2L);
        if(isDeletedCategory){
            System.out.println("Category deleted");
        }

        List<SubCategory> subCategoryList = subCategoryRepository.findAllTable();

        SubCategory subCategoryOne = subCategoryRepository.findByIdTable(1L);
        subCategoryOne.getSubCategoryName();

        Boolean isDeletedSubCategory = subCategoryRepository.deleteByIdTable(2L);
        if(isDeletedSubCategory){
            System.out.println("Sub Category deleted");
        }

        List<Product> productList = productRepository.findAllTable();

        Product productOne = productRepository.findByIdTable(1L);
        productOne.getCodeProduct();

        Boolean isDeletedProduct = productRepository.deleteByIdTable(2L);
        if(isDeletedProduct){
            System.out.println("Product deleted");
        }

    }
}
