package peaksoft.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
public class Instructor {

    @Id
    @SequenceGenerator(name = "instructor_gen", sequenceName = "instructor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_gen")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String specialization;


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,
             CascadeType.REFRESH})
    @JoinTable
    private List<Course> courses;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
          CascadeType.REFRESH})
    private Company company;


    public Instructor(String firstName, String lastName, String phoneNumber, String email, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.specialization = specialization;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

}
