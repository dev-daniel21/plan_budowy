package pl.dw.plan_budowy.Construction_Site;

import pl.dw.plan_budowy.Concrete.BetonEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class ConstructionSiteEntity {

    @Id
    @GeneratedValue
    private String id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "constructionSiteEntity")
    public List<BetonEntity> betonEntity;

    public ConstructionSiteEntity() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BetonEntity> getBetonEntity() {
        return betonEntity;
    }

    public void setBetonEntity(List<BetonEntity> betonEntity) {
        this.betonEntity = betonEntity;
    }

    public ConstructionSiteEntity(String id, String name, List<BetonEntity> betonEntity) {
        this.id = id;
        this.name = name;
        this.betonEntity = betonEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstructionSiteEntity that = (ConstructionSiteEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(betonEntity, that.betonEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, betonEntity);
    }
}
