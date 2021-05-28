package com.belonk.designpattern.templateMethod;

/**
 * 模板方法模式示例。
 * <p>
 * Created by sun on 2021/5/28.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class TemplateMethodDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		// 流感疫苗接种过程
		System.out.println("==== 流感疫苗接种过程 ====");
		AbstractVaccinate vaccinate = new InfluenzaVaccine();
		vaccinate.vaccinate();
		// 新冠疫苗接种过程
		System.out.println("==== 新冠疫苗接种过程 ====");
		vaccinate = new Covid19Vaccine();
		vaccinate.vaccinate();
	}
}

/**
 * 抽象模板： 疫苗接种流程
 */
abstract class AbstractVaccinate {
	protected final String name;

	public AbstractVaccinate(String name) {
		this.name = name;
	}

	// 疫苗接种过程，模板方法，一般可以设置为final，以禁止子类重写
	public final void vaccinate() {
		order();
		tripMode();
		check();
		vaccinating();
		if (mustObservate())
			observate();
		afterVaccinated();
	}

	// 预约
	public abstract void order();

	// 去往接种目的地方式
	public void tripMode() {
		System.out.println(this.name + " 接种前自行前往接种地...");
	}

	// 审核
	public abstract void check();

	// 接种
	public void vaccinating() {
		System.out.println(this.name + " 接种中...");
	}

	// 观察
	public void observate() {
		System.out.println(this.name + " 接种后观察30分钟...");
	}

	// 钩子方法，是否必须观察
	public boolean mustObservate() {
		return false;
	}

	public void afterVaccinated() {
		System.out.println(this.name + " 接种成功！");
	}
}

/**
 * 具体的实现类：流感疫苗
 */
class InfluenzaVaccine extends AbstractVaccinate {
	public InfluenzaVaccine() {
		super("流感疫苗");
	}

	@Override
	public void order() {
		System.out.println(this.name + " 接种前到医院预约...");
	}

	@Override
	public void check() {
		System.out.println(this.name + " 接种前审核户口本和疫苗接种本...");
	}
}

/**
 * 具体的实现类：新冠疫苗接种
 */
class Covid19Vaccine extends AbstractVaccinate {
	public Covid19Vaccine() {
		super("COVID-19疫苗");
	}

	@Override
	public void order() {
		System.out.println(this.name + " 接种前到社区预约...");
	}

	@Override
	public void tripMode() {
		System.out.println(this.name + " 接种前社区统一安排前往接种地...");
	}

	@Override
	public void check() {
		System.out.println(this.name + " 接种前审核身份证...");
	}

	@Override
	public boolean mustObservate() {
		return true;
	}
}
