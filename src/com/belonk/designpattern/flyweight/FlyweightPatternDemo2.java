package com.belonk.designpattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sun on 2020/12/18.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class FlyweightPatternDemo2 {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	// 随机位置
	public static Position randomPos() {
		int x = 19, y = 19;
		int posX = (int) (Math.random() * x);
		int posY = (int) (Math.random() * y);
		return new Position(posX, posY);
	}

	public static void main(String[] args) {
		/*
		示例：围棋，黑白两种棋子，如果每一个棋子创建一个对象，需要消耗很多内存，可以使用享元模式。
		思考：围棋下棋，总是逐个落子，除了棋子颜色不同外，棋子在棋盘上的位置也不同。那么，哪个是外部状态呢？棋子的颜色不会改变，因此颜色
		是内部状态，而棋子的位置会随着下棋的进行而不断变化，所以是外部状态。
		 */

		WeiqiPieceFactory factory = new WeiqiPieceFactory();
		Piece piece;
		int steps = 20;
		for (int i = 0; i < steps; i++) {
			// 黑子先行
			if (i % 2 == 0) {
				piece = factory.getPiece(Color.BLACK);
			} else {
				piece = factory.getPiece(Color.WHITE);
			}
			piece.put(randomPos());
		}
		System.out.println(factory.count());
	}
}

// 内部状态：棋子颜色
class Color {
	private final String color;
	static final Color BLACK = new Color("black");
	static final Color WHITE = new Color("white");

	private Color(String color) {
		this.color = color;
	}

	public String color() {
		return this.color;
	}
}

// 外部状态: 棋子位置
class Position {
	private final int x;
	private final int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String position() {
		return "(" + x + "," + y + ")";
	}
}

// flyweight接口：棋子
interface Piece {
	Color getColor();

	void put(Position position);
}

// 具体flyweight对象：围棋棋子
class WeiqiPiece implements Piece {
	private final Color color;

	public WeiqiPiece(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void put(Position position) {
		System.out.println("put " + this.getColor().color() + " piece at: " + position.position());
	}
}

// flyweight工厂
class WeiqiPieceFactory {
	private final Map<Color, Piece> pieces = new ConcurrentHashMap<>();

	public Piece getPiece(Color color) {
		pieces.putIfAbsent(color, new WeiqiPiece(color));
		return pieces.get(color);
	}

	public int count() {
		return pieces.size();
	}
}