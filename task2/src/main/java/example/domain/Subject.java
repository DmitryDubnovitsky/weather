package example.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "subject")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Subject {

    @Id
    @GeneratedValue
    @JsonProperty
    private Integer id;

    @Column(name = "classname")
    @JsonProperty
    private String classname;

    @OneToMany(mappedBy = "subject",cascade ={CascadeType.REMOVE},fetch = FetchType.EAGER )
    private Set<Sounds> sound;

    public String getClassname() {return classname;}

    public void setClassname(String classname) {this.classname = classname;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Sounds> getSound() {return sound;}

    public void setSound(Set<Sounds> sound) {this.sound = sound;}
}
