package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensor sensor;

    @Before
    public void before() {
        sensor=new TrainSensorImpl(null,null);


    }


    @Test
    public void ThisIsAnExampleTestStub() {
        sensor.incTime(5,5);
        sensor.incTime(10,10);
        sensor.incTime(154,3);
        sensor.incTime(6,4);

        sensor.getJoystickPosAt(2);
        Assert.assertEquals(sensor.getRefSpeedAt(1),10);
        Assert.assertEquals(sensor.getJoystickPosAt(2),3);

    }
}
