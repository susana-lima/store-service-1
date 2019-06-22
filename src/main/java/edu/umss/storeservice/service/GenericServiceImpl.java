package edu.umss.storeservice.service;


import edu.umss.storeservice.dto.DtoBase;
import edu.umss.storeservice.model.ModelBase;
import edu.umss.storeservice.repository.GenericRepository;
import edu.umss.storeservice.repository.specifications.GenericSpecificationsBuilder;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@SuppressWarnings("rawtypes")
public abstract class GenericServiceImpl<T extends ModelBase> implements GenericService<T> {

    @Autowired
    protected ModelMapper modelMapper;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<T> findAll() {
        return new ArrayList<>(getRepository().findAll());
    }

    @Override
    public T findById(Long id) {
        final Optional<T> optional = getRepository().findById(id);
        if (!optional.isPresent()) {
            String typeName = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                    .getTypeName();
            typeName = typeName.substring(typeName.lastIndexOf('.') + 1);
            throw new NoResultException(String.format("%s Not found with id %s", typeName, id));
        } else {
            return optional.get();
        }
    }

    @Override
    public T save(T model) {
        validateSave(model);
        T t = getRepository().save(model);
        return findById(t.getId());
    }

    @Override
    public T saveAndFlush(T model) {
        validateSave(model);
        T t = getRepository().saveAndFlush(model);
        return findById(t.getId());
    }

    @Override
    public T patch(DtoBase dto, T model) {
        processDtoToDomainPatch(dto, model);
        return save(model);
    }

    protected void processDtoToDomainPatch(DtoBase dto, T updatedDomain) {

    }

    protected void validateSave(T model) {

    }

    @Override
    public List<T> saveAll(Iterable<T> models) {
        return StreamSupport.stream(models.spliterator(), false).map(this::save).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public List<T> findAll(String filter) {
        return getRepository().findAll(getQueryFrom(filter));
    }


    protected <E extends ModelBase> void appendModel(E model, Set<E> modelSet) {
        if (model != null) {
            modelSet.add(model);
        }
    }

    protected <E extends ModelBase<?>> void appendModel(E model, List<E> modelSet) {
        if (model != null) {
            modelSet.add(model);
        }
    }

    protected Specification<T> getQueryFrom(String filter) {
        return new GenericSpecificationsBuilder<T>().build(filter);
    }

    @Override
    public Byte[] getBytes(MultipartFile file) {
        try {
            Byte[] bytes = new Byte[file.getBytes().length];
            int i = 0;
            for (Byte aByte : file.getBytes()) {
                bytes[i++] = aByte;
            }
            return bytes;
        } catch (IOException e) {
            logger.error("Error reading file", e);
        }
        return new Byte[0];
    }

    protected abstract GenericRepository<T> getRepository();
}