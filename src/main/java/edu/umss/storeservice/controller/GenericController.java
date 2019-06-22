package edu.umss.storeservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umss.storeservice.dto.DtoBase;
import edu.umss.storeservice.exception.InternalErrorException;
import edu.umss.storeservice.model.ModelBase;
import edu.umss.storeservice.service.GenericService;
import io.micrometer.core.instrument.util.IOUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class GenericController<E extends ModelBase, D extends DtoBase<E>> {

    protected static final String ID = "id";
    protected static final String FILTER = "filter";
    protected static final String PAGE = "page";
    protected static final String SIZE = "size";
    protected static final String SORT = "sort";

    @Autowired
    protected ModelMapper modelMapper;
    @Autowired
    protected ObjectMapper objectMapper;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @DeleteMapping(value = "/{id}")
    protected void deleteElement(@PathVariable("id") @NotNull Long id) {
        getService().deleteById(id);
    }

    @GetMapping(value = "/model/{id}")
    public E findModelById(@PathVariable Long id) {
        return (E) getService().findById(id);
    }

    @GetMapping("/{id}")
    protected D getById(@PathVariable("id") @NotNull Long id) {
        return toDto((E) (getService().findById(id)));
    }

    @GetMapping
    protected List<D> getAll() {
        return toDto(getService().findAll());
    }

    protected List<D> findAll(String filter) {
        return toDto((getService().findAll(filter)));
    }

    @PostMapping
    protected D save(@RequestBody D element) {
        return toDto((E) getService().save(toModel(element)));
    }

    @PutMapping
    protected D update(@RequestBody D element) {
        return toDto((E) getService().save(toModel(element)));
    }

    /**
     * Absence of key means skip setting value, and null means replace current value
     * by null If deep patch is needed take a look this reference:
     * https://stackoverflow.com/questions/17860520/spring-mvc-patch-method-partial-updates
     *
     * @param id      the id of the object to be patched
     * @param request
     * @return patched domain model
     */
    @PatchMapping("/{id}")
    protected D patch(@PathVariable("id") @NotNull Long id, HttpServletRequest request) {
        E domain = (E) (getService().findById(id));
        E updatedDomain;
        D dto;
        try {
            @SuppressWarnings("deprecation")
            String jsonString = IOUtils.toString(request.getInputStream());
            updatedDomain = objectMapper.readerForUpdating(domain).readValue(jsonString);
            dto = objectMapper.readValue(jsonString, getDtoClass());
        } catch (IOException e) {
            logger.error("Error reading request body.", e);
            throw new InternalErrorException("Error reading request body.");
        }
        return toDto((E) getService().patch(dto, updatedDomain));
    }

    protected abstract GenericService getService();

    private D getInstanceOfD() {
        Class<D> type = getDtoClass();
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new InternalErrorException("No default constructor.", e);
        }
    }

    private E getInstanceOfE() {
        Class<E> type = getDomainClass();
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new InternalErrorException("No default constructor.", e);
        }
    }

    private Class<D> getDtoClass() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<D>) superClass.getActualTypeArguments()[1];
    }

    private Class<E> getDomainClass() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<E>) superClass.getActualTypeArguments()[0];
    }

    protected D toDto(E entity) {
        return (D) getInstanceOfD().toDto(entity, modelMapper);
    }

    protected E toModel(D dto) {
        return (E) getInstanceOfE().toDomain(dto, modelMapper);
    }

    protected List<D> toDto(Collection<E> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    protected List<E> toModel(List<D> dtos) {
        return dtos.stream().map(this::toModel).collect(Collectors.toList());
    }

    protected Page<D> toDto(Page<E> entities) {
        return entities.map(this::toDto);
    }

    protected Pageable getPageable(int page, int size) {
        return PageRequest.of(page - 1 > 0 ? page - 1 : 0, size);
    }

    protected Sort getSortType(boolean isAsc, String... filter) {
        return isAsc ? Sort.by(filter).ascending() : Sort.by(filter).descending();
    }


    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity preflight(HttpServletResponse response) {
        response.setHeader("Allow", "HEAD,GET,POST,PUT,PATCH,OPTIONS");
        return new ResponseEntity(HttpStatus.OK);
    }
}
