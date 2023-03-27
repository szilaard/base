package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	int getJoyStickPos();

	int getRefSpeed();

	int getTime();

	void incTime(int a,int b);

	int getRefSpeedAt(int time);

	int getJoystickPosAt(int time);

	void overrideSpeedLimit(int speedLimit);

}
