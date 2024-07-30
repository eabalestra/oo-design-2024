package barista;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

class CoffeeTest {
    CaffeineBeverage blackCoffee;

    @BeforeEach
    void setUp() {
        blackCoffee = new BlackCoffee();
    }

    @Test
    void brewPrintsBrewingBlackCoffee() {
        assertDoesNotThrow(blackCoffee::brew);
    }

    @Test
    void addCondimentsDoesNothing() {
        assertDoesNotThrow(blackCoffee::addCondiments);
    }

    @Test
    void customerWantsCondimentsReturnsFalse() {
        assertFalse(blackCoffee.customerWantsCondiments());
    }

    @Test
    void prepareRecipeDoesNotAddCondiments() {
        blackCoffee = mock(BlackCoffee.class);

        blackCoffee.prepareRecipe();

        InOrder inOrder = inOrder(blackCoffee);
        inOrder.verify(blackCoffee).boilWater();
        inOrder.verify(blackCoffee).brew();
        inOrder.verify(blackCoffee).pourInCup();
        inOrder.verify(blackCoffee, never()).addCondiments();
    }
}