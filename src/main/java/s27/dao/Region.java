package s27.dao;

import javax.persistence.Column;         
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Java persistence API, package che implementa la persistenza.
//E' un bean che ha un'entità, con una funzione, funzioni attribuite attraverso le annotazioni. 

@Entity
@Table(name="REGIONS")
public class Region {
    @Id   //primary key della tabella region
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //questo è un valore generato, ovvero che se non lo specificano, generalo automanticamente come fa mysql.
    @Column(name = "region_id")
    private int id;

    @Column(name = "region_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region [id=" + id + ", name=" + name + "]";
    }
}
