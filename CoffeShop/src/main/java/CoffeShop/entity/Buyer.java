package CoffeShop.entity;

import jakarta.persistence.*;

import java.awt.*;

@Entity
@Table(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "sale")
    private double sale;

    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_barista")
    private Barista barista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Barista getBarista() {
        return barista;
    }

    public void setBarista(Barista barista) {
        this.barista = barista;
    }
}
