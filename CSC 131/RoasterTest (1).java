/**
 * Name: Youssef Boujebha
 * Date: 12/11/2023
 * Assignment: HW 5
 */

package edu.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoasterTest {
    private Roaster roaster;

    @BeforeEach
    void setUp() {
        roaster = new Roaster();
    }

    @Test
    void setTemperatureCelsius() {
        Roaster roaster = new Roaster();
        int Expected = 100;

        roaster.setTemperatureCelsius(Expected);
        assertEquals(Expected, roaster.getTemperatureCelsius());

        assertThrows(IllegalArgumentException.class, () -> roaster.setTemperatureCelsius(-1),
                "Too cold!");
        assertThrows(IllegalArgumentException.class, () -> roaster.setTemperatureCelsius(500),
                "Too hot!");
    }

    @Test
    void setTimeSeconds() {
        int validTime = 300;
        roaster.setTimeSeconds(validTime);
        assertEquals(validTime, roaster.getTimeSeconds());

        //Lower bound
        int invalidTimeLower = -1;
        assertThrows(IllegalArgumentException.class,
                () -> roaster.setTimeSeconds(invalidTimeLower),
                "Too low!");

        //Upper bound
        int invalidTimeUpper = 500;
        assertThrows(IllegalArgumentException.class,
                () -> roaster.setTimeSeconds(invalidTimeUpper),
                "Too high!");
    }

    @Test
    void makeFrenchRoast(CoffeeBean coffeeBean, int quantityInGrams) {
        CoffeeBean coffeeBean = new CoffeeBean();
        int quantityInGrams = 200;
        int Expected = 200;
        assertEquals(quantityInGrams, Expected)

        coffee.setRoastDate("today");
        int setTemperatureCelsius = 270;
        assertEquals("BAD",coffee.setRoastState)
    }

    @Test
    void makeMediumRoast() {
        Roaster roaster = new Roaster();
        CoffeeBean coffeeBean = new CoffeeBean();

        Coffee coffee = new Coffee(coffeeBean);
        coffee.setQuantityInGrams(quantityInGrams);
        coffee.setRoastDate("today");

        int expectedWeight= 25;
        int actualWeight = actualWeight.setQuantityInGrams(25);
        assertEquals(expectedWeight,actualWeight);

        Coffee Good = roaster.makeMediumRoast(coffeeBean, quantityInGrams, 25, 210);
        Coffee Bad = roaster.makeMediumRoast(coffeeBean, quantityInGrams, 24, 210)

        assertAll(
                assertEquals(RoastProfile.MEDIUM, Good.getRoastProfile()),
                () -> assertEquals("balanced", Good.getFlavor()),
                () -> assertEquals(RoastState.GOOD, Good.getRoastState()
                )
    }

    @Test
    void makeAmazingCoffee() {
        Roaster roaster = new Roaster();
        String validCountry = "Ethiopia";
        Fermentation validFermentation = Fermentation.NATURAL;
        int quantityInGrams = 180;

        Coffee good = roaster.makeAmazingCoffee(validCountry, validFermentation, quantityInGrams);

        assertAll(
                () -> assertEquals(validCountry, good.getCoffeeBean().getCountry()),
                () -> assertEquals(validFermentation, good.getCoffeeBean().getFermentation()),
                () -> assertEquals(quantityInGrams, good.getQuantityInGrams()),
                () -> assertEquals("today", good.getRoastDate()),
                () -> assertEquals(RoastProfile.LIGHT, good.getRoastProfile()),
                () -> assertEquals("amazing", good.getFlavor()),
                () -> assertEquals(RoastState.GOOD, good.getRoastState()),

        );

    }

    @Test
    void makeDecafCoffee() {
        Roaster roaster = new Roaster();
        int quantityInGrams = 150;
        Coffee result = roaster.makeDecafCoffee(quantityInGrams);

        assertAll(
                () -> assertEquals(Fermentation.DECAFFEINATION, result.getCoffeeBean().getFermentation(), "Fermentation is incorrect"),
                () -> assertEquals(quantityInGrams, result.getQuantityInGrams(), "Quantity in grams is incorrect"),
                () -> assertEquals("whenever", result.getRoastDate(), "Roast date is incorrect"),
                () -> assertEquals(RoastProfile.MEDIUM, result.getRoastProfile(), "Roast profile is incorrect for decaf"),
                () -> assertEquals("spoiled", result.getFlavor(), "Flavor is incorrect for decaf"),
                () -> assertEquals(RoastState.BAD, result.getRoastState(), "Roast state is incorrect for decaf")
                );
            }
        }
    }
}