package com.example.demo.delombok;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonDeserialize(builder = Example.ExampleBuilder.class)
@Entity
public class Example {

    // necessary properties

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // data

    private String dataValue;

    public Example(Long id, String dataValue) {
        this.id = id;
        this.dataValue = dataValue;
    }

    public Example() {
    }

    public static ExampleBuilder builder() {
        return new ExampleBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getDataValue() {
        return this.dataValue;
    }

    @JsonPOJOBuilder
    public static class ExampleBuilder {
        private Long id;
        private String dataValue;

        ExampleBuilder() {
        }

        public ExampleBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ExampleBuilder withDataValue(String dataValue) {
            this.dataValue = dataValue;
            return this;
        }

        public Example build() {
            return new Example(id, dataValue);
        }

        public String toString() {
            return "Example.ExampleBuilder(id=" + this.id + ", dataValue=" + this.dataValue + ")";
        }
    }
}
