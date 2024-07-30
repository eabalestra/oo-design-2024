package barista;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CaffeineBeverageTest {

    @Test
    void prepareRecipeExecutesInOrder() {
        CaffeineBeverage beverage = mock(CaffeineBeverage.class, CALLS_REAL_METHODS);
        doNothing().when(beverage).brew();
        doNothing().when(beverage).addCondiments();

        beverage.prepareRecipe();

        InOrder inOrder = inOrder(beverage);
        inOrder.verify(beverage).boilWater();
        inOrder.verify(beverage).brew();
        inOrder.verify(beverage).pourInCup();
        inOrder.verify(beverage).addCondiments();
    }

    @Test
    void boilWaterPrintsMessage() {
        CaffeineBeverage beverage = mock(CaffeineBeverage.class, CALLS_REAL_METHODS);
        assertDoesNotThrow(beverage::boilWater);
    }

    @Test
    void pourInCupPrintsMessage() {
        CaffeineBeverage beverage = mock(CaffeineBeverage.class, CALLS_REAL_METHODS);
        assertDoesNotThrow(beverage::pourInCup);
    }
}