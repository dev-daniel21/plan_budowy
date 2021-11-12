package pl.dw.plan_budowy.Concrete;

import pl.dw.plan_budowy.Construction_Site.ConstructionSiteEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class BetonEntity {

    @Id
    @NotBlank
    String element;
    String quantity;
    @NotBlank
    @Size(min = 2, max = 20)
    String klasa;
    LocalDateTime startTime;
    @ManyToMany
    public List<ConstructionSiteEntity> constructionSiteEntity;

    public BetonEntity() {

    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public BetonEntity(List<ConstructionSiteEntity> constructionSiteEntity) {
        this.constructionSiteEntity = constructionSiteEntity;
    }

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public List<ConstructionSiteEntity> getConstructionSiteEntity() {
        return constructionSiteEntity;
    }

    public void setConstructionSiteEntity(List<ConstructionSiteEntity> constructionSiteEntity) {
        this.constructionSiteEntity = constructionSiteEntity;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetonEntity that = (BetonEntity) o;
        return Objects.equals(element, that.element) && Objects.equals(quantity, that.quantity) && Objects.equals(klasa, that.klasa) && Objects.equals(startTime, that.startTime) && Objects.equals(constructionSiteEntity, that.constructionSiteEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, quantity, klasa, startTime, constructionSiteEntity);
    }
}
