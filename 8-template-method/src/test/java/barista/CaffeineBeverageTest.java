package barista;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CaffeineBeverageTest {
    CaffeineBeverage beverage;

    @BeforeEach
    void setUp() {
        beverage = mock(CaffeineBeverage.class, CALLS_REAL_METHODS);
    }

    @Test
    void prepareRecipeExecutesInOrder() {
        doReturn(true).when(beverage).customerWantsCondiments();
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
        assertDoesNotThrow(beverage::boilWater);
    }

    @Test
    void pourInCupPrintsMessage() {
        assertDoesNotThrow(beverage::pourInCup);
    }
}