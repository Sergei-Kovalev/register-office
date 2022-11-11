package ru.ngs.summerjob.register.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "ro_marriage_certificate")
@Entity

@NamedQueries({
        @NamedQuery(name = "MarriageCertificate.findMarriageCertificate", query = """
                Select m FROM MarriageCertificate m\040
                LEFT JOIN FETCH m.husband_id hi\040
                LEFT JOIN FETCH m.wife_id wi\040
                WHERE m.number_certificate = :marriageCertificateNumber\040
                AND m.date_issue = :marriageCertificateDate\040
                AND hi.first_name = :husbandSurname\040
                AND hi.last_name = :husbandGivenName\040
                AND hi.patronymic = :husbandPatronymic\040
                AND wi.first_name = :wifeSurname\040
                AND wi.last_name = :wifeGivenName\040
                AND wi.patronymic = :wifePatronymic
                """)
})

public class MarriageCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marriage_certificate_id")
    private Long marriageCertificateId;
    @Column(name = "number_certificate")
    private String number;
    @Column(name = "date_issue")
    private LocalDate issueDate;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "husband_id")
    private PersonMale husband;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "wife_id")
    private PersonFemale wife;
    @Column(name = "active")
    private boolean active;
    @Column(name = "end_date")
    private LocalDate endDate;

    public Long getMarriageCertificateId() {
        return marriageCertificateId;
    }

    public void setMarriageCertificateId(Long marriageCertificateId) {
        this.marriageCertificateId = marriageCertificateId;
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

    public PersonMale getHusband() {
        return husband;
    }

    public void setHusband(PersonMale husband) {
        this.husband = husband;
    }

    public PersonFemale getWife() {
        return wife;
    }

    public void setWife(PersonFemale wife) {
        this.wife = wife;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
