package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import java.util.Map;

public class TrainSensorImpl implements TrainSensor {


	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private int time=0;
	private Table<String,Integer,Integer> tachograph= HashBasedTable.create();

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public int getJoyStickPos() {
		return user.getJoystickPosition();
	}

	@Override
	public int getRefSpeed() {
		return controller.getReferenceSpeed();
	}

	@Override
	public int getTime() {
		return 0;
	}



	@Override
	public void incTime(int refspeed,int joypos) {
		tachograph.put("RefSpeed",time,refspeed);
		tachograph.put("JoyPos",time,joypos);
		time+=1;
	}

	@Override
	public int getRefSpeedAt(int time) {
		Map<String, Integer> timeState=tachograph.column(time);
		return timeState.get("RefSpeed");
	}

	@Override
	public int getJoystickPosAt(int time) {
		Map<String, Integer> timeState=tachograph.column(time);
		return timeState.get("JoyPos");
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

}
