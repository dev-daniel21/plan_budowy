package pl.dw.plan_budowy.SiteManager;

import pl.dw.plan_budowy.Construction_Site.ConstructionSiteEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class SiteManagerEntity {
    @Id
    @NotBlank
    String fullName;
    int age;
    Experience experience;
    @OneToOne
    ConstructionSiteEntity constructionSite;

    public SiteManagerEntity(String fullName, int age, Experience experience, ConstructionSiteEntity constructionSite) {
        this.fullName = fullName;
        this.age = age;
        this.experience = experience;
        this.constructionSite = constructionSite;
    }

    public SiteManagerEntity() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public ConstructionSiteEntity getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(ConstructionSiteEntity constructionSite) {
        this.constructionSite = constructionSite;
    }


}
