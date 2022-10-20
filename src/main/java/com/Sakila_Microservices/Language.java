package com.Sakila_Microservices;

import javax.persistence.*;

@Entity
@Table(name="Language")

public class Language {
    //ATTRIBUTES//
    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int languageID;

    @Column(name = "name")
    String languageName;

    //CONSTRUCTORS//
    public Language(String languageName) {
        this.languageName = languageName;
    }

    public Language() {}

    //METHODS//
    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languagetName) {
        this.languageName = languagetName;
    }
}
