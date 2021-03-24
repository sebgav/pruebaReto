package com.co.certificacion.pruebas.definitions;

import com.co.certificacion.pruebas.dto.Datum;
import com.co.certificacion.pruebas.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Reported;
import org.json.JSONObject;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static jxl.biff.BaseCellFeatures.logger;


public class ServiciosDefinitions {

    String link = "https://reqres.in/api/user?page=2";
    JSONObject obj;
    private User dtoUser;
    private List<Datum> lsdata;
    private String endpont;
    private RequestSpecification spec;
    private  Response done;

    @Given("^consumo el  serivio$")
    public void consumoElSerivio() {
        RequestSpecification spec = RestAssured.given();
        Response result = spec.get(link);
        result.then().assertThat().statusCode(200);
        JSONObject obj = new JSONObject(result.asString());
        ObjectMapper mapper=new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            dtoUser=mapper.readValue(result.asString(), User.class);
        } catch (JsonProcessingException e) {
            logger.error("Fallo en el mapper",e);
        }
    }

    @When("^listo los valores$")
    public void listoLosValores() {
lsdata=dtoUser.getData();
    }
    @Then("^se mostraran$")
    public void seMostraran() {
        for (int i=0;lsdata.size()>i;i++)
        {
            logger.info("Nombre en posicion "+i+" "+ lsdata.get(i).getName()+"\n");
        }
    }

    @Given("^consumo el serivio post$")
    public void consumoElSerivioPost() {
         String json = "{place: 'earth', message: 'Hello'}";
         endpont="https://reqres.in/api/users";

        RequestSpecification spec = RestAssured.given();
        Response result = spec.get(link);
        spec.body(json);
        result.then().assertThat().statusCode(200);
        ObjectMapper mapper=new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            dtoUser=mapper.readValue(result.asString(), User.class);
        } catch (JsonProcessingException e) {
            logger.error("Fallo en el mapper",e);
        }
    }

    @Given("^consumo el serivio para eliminar$")
    public void consumoElSerivioParaEliminar() {
         String link = "https://reqres.in/api/users/10";
         spec = RestAssured.given();
         done = spec.delete(link);

    }
    @When("^valido el status code$")
    public void validoElStatusCode() {
        // Write code here that turns the phrase above into concrete actions
        done.then().assertThat().statusCode(204);
    }
    @Then("^valido que  halla eliminado$")
    public void validoQueHallaEliminado() {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Tiempo "+done.getTimeIn(TimeUnit.NANOSECONDS));
    }

}


