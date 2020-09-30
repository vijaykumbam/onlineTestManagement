package com.capgemini.Bdd.onlineTestManagement.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/DateConflictCheck.feature", glue= {"com.capgemini.Bdd.onlineTestManagement.stepDefinations"})
public class Runner {

}
