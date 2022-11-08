package ru.ngs.summerjob.register.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "ro_passport")
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Long passportId;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)                                              //ratio
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "series")
    private String series;
    @Column(name = "number")
    private String number;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "issue_department")
    private String issueDepartment;

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}
