package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class TestGreeter {

  private Greeter greeter;

  @Before
  public void setup() {
    greeter = new Greeter();
  }

  @Test
  public void greetShouldIncludeTheOneBeingGreeted() {
    String someone = "World";

    assertThat(greeter.greet(someone), containsString(someone));
  }

  @Test
  public void greetShouldIncludeGreetingPhrase() {
    String someone = "World";

    assertThat(greeter.greet(someone).length(), is(greaterThan(someone.length())));
  }

  @Test
  public void greetShouldHandleEmptyString() {
    String someone = "";
    String result = greeter.greet(someone);

    assertThat(result, containsString("Hello How are you"));
  }

  @Test
  public void greetShouldHandleSpecialCharacters() {
    String someone = "Alice@123!";
    String result = greeter.greet(someone);

    assertThat(result, containsString(someone));
    assertThat(result, containsString("Hello How are you"));
  }

  @Test
  public void greetShouldHandleLongNames() {
    String someone = "VeryLongNameWithManyCharactersHere";
    String result = greeter.greet(someone);

    assertThat(result, containsString(someone));
  }

  @Test
  public void greetShouldHandleMultipleWordNames() {
    String someone = "John Doe Smith";
    String result = greeter.greet(someone);

    assertThat(result, containsString(someone));
    assertThat(result, containsString("Hello How are you"));
  }

  @Test
  public void greetShouldEndWithExclamationMark() {
    String someone = "Alice";
    String result = greeter.greet(someone);

    assertThat(result, is("Hello How are you, Alice!"));
  }

  @Test
  public void greetShouldReturnNonNullString() {
    String someone = "Bob";
    String result = greeter.greet(someone);

    assertThat(result, org.hamcrest.Matchers.notNullValue());
  }
}
