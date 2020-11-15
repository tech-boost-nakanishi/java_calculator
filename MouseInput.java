import java.awt.Rectangle;

public class MouseInput{

	public static void mouseClicked(int mx, int my) {
		Rectangle PressedRect = new Rectangle(mx, my, 1, 1);
		
		if(PressedRect.intersects(Calculator.zero)) {
			Logic.LogicButton(0);
		}
		else if(PressedRect.intersects(Calculator.one)) {
			Logic.LogicButton(1);
		}
		else if(PressedRect.intersects(Calculator.two)) {
			Logic.LogicButton(2);
		}
		else if(PressedRect.intersects(Calculator.three)) {
			Logic.LogicButton(3);
		}
		else if(PressedRect.intersects(Calculator.four)) {
			Logic.LogicButton(4);
		}
		else if(PressedRect.intersects(Calculator.five)) {
			Logic.LogicButton(5);
		}
		else if(PressedRect.intersects(Calculator.six)) {
			Logic.LogicButton(6);
		}
		else if(PressedRect.intersects(Calculator.seven)) {
			Logic.LogicButton(7);
		}
		else if(PressedRect.intersects(Calculator.eight)) {
			Logic.LogicButton(8);
		}
		else if(PressedRect.intersects(Calculator.nine)) {
			Logic.LogicButton(9);
		}
		else if(PressedRect.intersects(Calculator.period)) {
			Logic.LogicButton(10);
		}
		else if(PressedRect.intersects(Calculator.add)) {
			Logic.LogicButton(11);
		}
		else if(PressedRect.intersects(Calculator.subtract)) {
			Logic.LogicButton(12);
		}
		else if(PressedRect.intersects(Calculator.multiply)) {
			Logic.LogicButton(13);
		}
		else if(PressedRect.intersects(Calculator.divide)) {
			Logic.LogicButton(14);
		}
		else if(PressedRect.intersects(Calculator.plusminus)) {
			Logic.LogicButton(15);
		}
		else if(PressedRect.intersects(Calculator.percent)) {
			Logic.LogicButton(16);
		}
		else if(PressedRect.intersects(Calculator.equal)) {
			Logic.LogicButton(17);
		}
		else if(PressedRect.intersects(Calculator.clear)) {
			Logic.LogicButton(18);
		}
	}

	public static void mousePressed(int mx, int my) {
		Rectangle PressedRect = new Rectangle(mx, my, 1, 1);
		
		if(PressedRect.intersects(Calculator.zero)) {Calculator.setPressedNum(0);}
		else if(PressedRect.intersects(Calculator.one)) {Calculator.setPressedNum(1);}
		else if(PressedRect.intersects(Calculator.two)) {Calculator.setPressedNum(2);}
		else if(PressedRect.intersects(Calculator.three)) {Calculator.setPressedNum(3);}
		else if(PressedRect.intersects(Calculator.four)) {Calculator.setPressedNum(4);}
		else if(PressedRect.intersects(Calculator.five)) {Calculator.setPressedNum(5);}
		else if(PressedRect.intersects(Calculator.six)) {Calculator.setPressedNum(6);}
		else if(PressedRect.intersects(Calculator.seven)) {Calculator.setPressedNum(7);}
		else if(PressedRect.intersects(Calculator.eight)) {Calculator.setPressedNum(8);}
		else if(PressedRect.intersects(Calculator.nine)) {Calculator.setPressedNum(9);}
		else if(PressedRect.intersects(Calculator.period)) {Calculator.setPressedNum(10);}
		else if(PressedRect.intersects(Calculator.add)) {Calculator.setPressedNum(11);}
		else if(PressedRect.intersects(Calculator.subtract)) {Calculator.setPressedNum(12);}
		else if(PressedRect.intersects(Calculator.multiply)) {Calculator.setPressedNum(13);}
		else if(PressedRect.intersects(Calculator.divide)) {Calculator.setPressedNum(14);}
		else if(PressedRect.intersects(Calculator.plusminus)) {Calculator.setPressedNum(15);}
		else if(PressedRect.intersects(Calculator.percent)) {Calculator.setPressedNum(16);}
		else if(PressedRect.intersects(Calculator.equal)) {Calculator.setPressedNum(17);}
		else if(PressedRect.intersects(Calculator.clear)) {Calculator.setPressedNum(18);}
	}

	public static void mouseReleased() {
		Calculator.setPressedNum(-1);
	}

}
