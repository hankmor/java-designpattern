package com.belonk.designpattern.builder;

/**
 * Created by sun on 2020/8/17.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class SimpleBuilderDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		SimpleCar simpleCar = SimpleCar.builder()
				.motor("发动机")
				.frame("车架")
				.chassis("底盘")
				.gearbox("变速箱")
				.build();
		System.out.println(simpleCar);
	}
}

class SimpleCar {
	// 发动机
	private String motor;
	// 变速箱
	private String gearbox;
	// 底盘
	private String chassis;
	// 车架
	private String frame;

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String motor;
		private String gearbox;
		private String chassis;
		private String frame;

		public Builder motor(String motor) {
			this.motor = motor;
			return this;
		}

		public Builder gearbox(String gearbox) {
			this.gearbox = gearbox;
			return this;
		}

		public Builder chassis(String chassis) {
			this.chassis = chassis;
			return this;
		}

		public Builder frame(String frame) {
			this.frame = frame;
			return this;
		}

		public SimpleCar build() {
			SimpleCar simpleCar = new SimpleCar();
			simpleCar.setMotor(this.motor);
			simpleCar.setGearbox(this.gearbox);
			simpleCar.setChassis(this.chassis);
			simpleCar.setFrame(this.frame);
			return simpleCar;
		}
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}
}