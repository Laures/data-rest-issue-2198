package com.example.demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Jacksonized
@Entity
public class LombokExample {

    // necessary properties

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // data

    private String dataValue;

}
