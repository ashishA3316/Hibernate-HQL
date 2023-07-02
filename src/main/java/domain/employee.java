package domain;

import javax.persistence.*;

@Entity
@Table(name = "employee_master")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "p_details")
    private professional professional;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "a_details")
    private account account;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public domain.professional getProfessional() {
        return professional;
    }

    public void setProfessional(domain.professional professional) {
        this.professional = professional;
    }

    public domain.account getAccount() {
        return account;
    }

    public void setAccount(domain.account account) {
        this.account = account;
    }
}
