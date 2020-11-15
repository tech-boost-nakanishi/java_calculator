import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyInput {

	public static void keyTyped(int key) {
		
	}

	public static void keyPressed(int key, char keychar, int mod) {
		
		if(key == KeyEvent.VK_0) {
			Calculator.setPressedNum(0);
			Logic.LogicButton(0);
		}
		else if(key == KeyEvent.VK_1) {
			Calculator.setPressedNum(1);
			Logic.LogicButton(1);
		}
		else if(key == KeyEvent.VK_2) {
			Calculator.setPressedNum(2);
			Logic.LogicButton(2);
		}
		else if(key == KeyEvent.VK_3) {
			Calculator.setPressedNum(3);
			Logic.LogicButton(3);
		}
		else if(key == KeyEvent.VK_4) {
			Calculator.setPressedNum(4);
			Logic.LogicButton(4);
		}
		else if((mod & InputEvent.SHIFT_DOWN_MASK) == 0 && (key == KeyEvent.VK_5)) {
			Calculator.setPressedNum(5);
			Logic.LogicButton(5);
		}
		else if(key == KeyEvent.VK_6) {
			Calculator.setPressedNum(6);
			Logic.LogicButton(6);
		}
		else if(key == KeyEvent.VK_7) {
			Calculator.setPressedNum(7);
			Logic.LogicButton(7);
		}
		else if(key == KeyEvent.VK_8) {
			Calculator.setPressedNum(8);
			Logic.LogicButton(8);
		}
		else if(key == KeyEvent.VK_9) {
			Calculator.setPressedNum(9);
			Logic.LogicButton(9);
		}
		else if(key == KeyEvent.VK_PERIOD) {
			Calculator.setPressedNum(10);
			Logic.LogicButton(10);
		}
		else if((mod & InputEvent.SHIFT_DOWN_MASK) != 0 && (keychar == '+')) {
			Calculator.setPressedNum(11);
			Logic.LogicButton(11);
		}
		else if(keychar == '-') {
			Calculator.setPressedNum(12);
			Logic.LogicButton(12);
		}
		else if((mod & InputEvent.SHIFT_DOWN_MASK) != 0 && (keychar == '*')) {
			Calculator.setPressedNum(13);
			Logic.LogicButton(13);
		}
		else if(key == KeyEvent.VK_SLASH) {
			Calculator.setPressedNum(14);
			Logic.LogicButton(14);
		}
		else if((mod & InputEvent.SHIFT_DOWN_MASK) != 0 && (keychar == '%')) {
			Calculator.setPressedNum(16);
			Logic.LogicButton(16);
		}
		else if(key == KeyEvent.VK_ENTER) {
			Calculator.setPressedNum(17);
			Logic.LogicButton(17);
		}
		else if(key == KeyEvent.VK_C) {
			Calculator.setPressedNum(18);
			Logic.LogicButton(18);
		}
		else if(key == KeyEvent.VK_BACK_SPACE) {
			Logic.LogicButton(19);
		}
	}

	public static void keyReleased(int key) {
		Calculator.setPressedNum(-1);
	}

}
