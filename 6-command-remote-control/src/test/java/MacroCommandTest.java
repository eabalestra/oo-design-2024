import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import remotecontrol.remotewithundo.*;

import static org.junit.jupiter.api.Assertions.*;

public class MacroCommandTest {
    Light light;
    Computer computer;
    CeilingFan ceilingFan;
    Command lightOn;
    Command lightOff;
    Command computerOn;
    Command computerOff;
    Command ceilingFanMedium;
    Command ceilingFanOff;
    MacroCommand summerMacro;
    MacroCommand summerMacroOff;

    @BeforeEach
    public void setUp() {
        light = new Light("Office");
        lightOn = new LightOnCommand(light);
        lightOff = new LightOffCommand(light);

        computer = new Computer("Office");
        computerOn = new ComputerOnCommandUndo(computer);
        computerOff = new ComputerOffCommandUndo(computer);

        ceilingFan = new CeilingFan("Office");
        ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        Command[] summerProgramming = {lightOn, computerOn, ceilingFanMedium};
        Command[] summerProgrammingOff = {lightOff, computerOff, ceilingFanOff};

        summerMacro = new MacroCommand(summerProgramming);
        summerMacroOff = new MacroCommand(summerProgrammingOff);
    }

    @Test
    public void testExecute() {
        summerMacro.execute();

        assertEquals(100, light.getLevel());
        assertEquals(Computer.ON, computer.getState());
        assertEquals(CeilingFan.MEDIUM, ceilingFan.getSpeed());
    }

    @Test
    public void testUndo() {
        summerMacro.execute();
        summerMacro.undo();

        assertEquals(0, light.getLevel());
        assertEquals(Computer.OFF, computer.getState());
        assertEquals(CeilingFan.OFF, ceilingFan.getSpeed());
    }
}
