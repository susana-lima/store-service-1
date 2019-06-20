/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.umss.storeservice.model.ModelBase;
import org.modelmapper.ModelMapper;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("rawtypes")
public class DtoBase<E extends ModelBase> {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date createdOn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date updatedOn;

    protected void beforeConversion(E element, ModelMapper mapper) {
        // Do nothing
    }

    protected void afterConversion(E element, ModelMapper mapper) {
        // Do nothing
    }

    public DtoBase toDto(E element, ModelMapper mapper) {
        beforeConversion(element, mapper);
        if (element != null) {
            mapper.map(element, this);
        }
        afterConversion(element, mapper);
        return this;
    }

    public <D extends DtoBase> List<D> toListDto(Collection<E> elements, ModelMapper mapper) {
        if (elements == null || elements.isEmpty()) {
            return Collections.emptyList();
        }
        return convert(elements, mapper);
    }

    @SuppressWarnings("unchecked")
    private <D extends DtoBase> List<D> convert(Collection<E> elements, ModelMapper mapper) {
        return (List<D>) elements.stream().map(element -> {
            try {
                return this.getClass().newInstance().toDto(element, mapper);
            } catch (InstantiationException | IllegalAccessException e) {
                return new DtoBase<>();
            }
        }).sorted(Comparator.comparing(DtoBase::getId)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdAt) {
        this.createdOn = createdAt;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedAt) {
        this.updatedOn = updatedAt;
    }
}
