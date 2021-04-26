package spring.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import static spring.util.SettingUtil.ITEM_DESCRIPTION_LENGTH;
import static spring.util.SettingUtil.ITEM_NAME_LENGTH;

@Entity
@Table(name = "items", schema = "store")
public class Item {

    @Id
    @GeneratedValue(generator = "store.items_uuid_seq")
    @Column(name = "uuid", nullable = false, unique = true)
    private BigInteger uuid;

    @Column(name = "name", length = ITEM_NAME_LENGTH, nullable = false)
    private String name;

    @Column(name = "description", length = ITEM_DESCRIPTION_LENGTH, nullable = false)
    private String description;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "image", length = 255, nullable = true)
    private String imageURL;


    @OneToMany(mappedBy = "item" )
    private Set<Order> orders;


    public Item() {
        this.name = null;
        this.description = null;
        this.quantity = 0;
        this.price = null;
    }

    public Item(String name, String description, int quantity, BigDecimal price)
    {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public BigInteger getUuid()
    {
        return uuid;
    }

    public void setUuid( BigInteger uuid )
    {
        this.uuid = uuid;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity( int quantity )
    {
        this.quantity = quantity;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice( BigDecimal price )
    {
        this.price = price;
    }

    public void setQuantity( Integer quantity )
    {
        this.quantity = quantity;
    }

    public Set<Order> getOrders()
    {
        return orders;
    }

    public void setOrders( Set<Order> orders )
    {
        this.orders = orders;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
