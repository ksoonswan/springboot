package me.whiteship.springboot;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies;







    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    private String yes;

    @Transient
    private String no;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street",column = @Column(name = "home_street"))
    })
    private Address address;

    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(this);
    }
}
