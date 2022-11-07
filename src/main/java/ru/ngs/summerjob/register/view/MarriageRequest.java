package ru.ngs.summerjob.register.view;

import java.io.Serializable;
import java.time.LocalDate;

public class MarriageRequest implements Serializable {
    private String husbandSurname;
    private String husbandGivenName;
    private String husbandPatronymic;
    private LocalDate husbandDateOfBirth;
    private String husbandPassportSeria;
    private LocalDate husbandPassportIssueDate;

    private String wifeSurname;
    private String wifeGivenName;
    private String wifePatronymic;
    private LocalDate wifeDateOfBirth;
    private String wifePassportSeria;
    private LocalDate wifePassportIssueDate;

    private String marriageCertificateNumber;
    private LocalDate marriageCertificateDate;
}
