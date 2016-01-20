package example.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;



@Entity
@Table(name = "sounds")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Sounds {

    @Id
    @GeneratedValue
    @JsonProperty
    private Integer id;

    @Column
    @JsonProperty
    private String keyword;

    @ManyToOne(optional = true)
    @JoinColumn(name = "binded_class", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Subject subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {return keyword;}

    public void setKeyword(String keyword) {this.keyword = keyword;}

    public Subject getSubject() {return subject;}

    public void setSubject(Subject subject) {this.subject = subject;}
}
