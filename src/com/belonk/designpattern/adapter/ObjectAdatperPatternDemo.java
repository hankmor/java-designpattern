package com.belonk.designpattern.adapter;

/**
 * 对象适配器模式: 耦合度低，遵循合成复用原则，推荐的方式。
 * <p>
 * Created by sun on 2020/8/19.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ObjectAdatperPatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	/**
	 * 示例：耳机插孔适配
	 */
	public static void main(String[] args) {
		// 一部IphoneXR
		IphoneXR iphoneXR = new IphoneXR();
		// 一条3.5mm接口的耳机
		EarphoneWith35mm earphoneWith35mm = new EarphoneWith35mm();
		// 通过耳机适配器将3.5mm耳机转换可用的TypeC接口耳机
		iphoneXR.soundUsingEarphone(new EarphoneAdapter(earphoneWith35mm));
	}
}

class IphoneXR {
	public void soundUsingEarphone(EarphoneWithTypeC earphoneWithTypeC) {
		earphoneWithTypeC.connectorWithTypeC();
		System.out.println("使用TypeC耳机听音乐");
	}
}

/**
 * 被适配者：3.5mm接口的耳机
 */
class EarphoneWith35mm {
	String connectorWith35mm() {
		return "3.5mm";
	}
}

/**
 * 目标接口：TypeC的耳机
 */
interface EarphoneWithTypeC {
	String connectorWithTypeC();
}

/**
 * 适配器：将3.5mm耳机孔转为TypeC的耳机孔
 */
class EarphoneAdapter implements EarphoneWithTypeC {
	private EarphoneWith35mm earphoneWith35mm;

	public EarphoneAdapter(EarphoneWith35mm earphoneWith35mm) {
		this.earphoneWith35mm = earphoneWith35mm;
	}

	@Override
	public String connectorWithTypeC() {
		String connectorWith35mm = earphoneWith35mm.connectorWith35mm();
		System.out.println("正在做一些转换处理, 将" + connectorWith35mm + "转换为TypeC...");
		return "TypeC";
	}
}