/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.ItemDto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ItemInstance extends ModelBase<ItemDto> {
    @OneToOne
    private Item item;
    private String identifier;

    private Boolean featured = Boolean.FALSE;

    // todo generalmente se usa BigDecimal
    private Double price;
    // todo estados AVAILABLE, SOLD, MAINTENANCE, ON_TRANSPORTATION
    // private ItemInstanceState itemInstanceState;
    // todo agregar totalCost

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }
}
