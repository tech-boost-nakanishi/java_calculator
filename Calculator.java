import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class Calculator implements MouseListener, KeyListener {

	public static final int WIDTH = 232, HEIGHT = 300;
	
	DrawPanel dp;
	
	public static String resultText = "0";
	public static String currentOp = "";
	public static int PressedNum = -1;
	public static double stackedValue = 0.0;
	public static boolean isStacked = false, afterCalc = false;
	public static Rectangle zero, one, two, three, four, five, six, seven, eight, nine,
							period,         //小数点     keyNum = 10
							add,			//足す		keyNum = 11
							subtract,		//引く		keyNum = 12
							multiply,		//掛ける		keyNum = 13
							divide,			//割る		keyNum = 14
							plusminus,		//正負切替	keyNum = 15
							percent,		//100で割る	keyNum = 16
							equal,			//イコール	keyNum = 17
							clear;			//クリア		keyNum = 18

	public Calculator() {
		JFrame frame = new JFrame();
		frame.setTitle("電卓");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		dp = new DrawPanel();
		dp.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.getContentPane().add(dp);
		
		dp.addMouseListener(this);
		dp.addKeyListener(this);
		
		clear = new Rectangle(0, 58, 57, 48);
		plusminus = new Rectangle(58, 58, 57, 48);
		percent = new Rectangle(116, 58, 57, 48);
		divide = new Rectangle(174, 58, 57, 48);
		
		seven = new Rectangle(0, 107, 57, 48);
		eight = new Rectangle(58, 107, 57, 48);
		nine = new Rectangle(116, 107, 57, 48);
		multiply = new Rectangle(174, 107, 57, 48);
		
		four = new Rectangle(0, 156, 57, 48);
		five = new Rectangle(58, 156, 57, 48);
		six = new Rectangle(116, 156, 57, 48);
		subtract = new Rectangle(174, 156, 57, 48);
		
		one = new Rectangle(0, 205, 57, 48);
		two = new Rectangle(58, 205, 57, 48);
		three = new Rectangle(116, 205, 57, 48);
		add = new Rectangle(174, 205, 57, 48);
		
		zero = new Rectangle(0, 254, 115, 48);
		period = new Rectangle(116, 254, 57, 48);
		equal = new Rectangle(174, 254, 57, 48);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static int getPressedNum() {
		return PressedNum;
	}

	public static void setPressedNum(int pressedNum) {
		PressedNum = pressedNum;
	}
	
	public static String getResultText() {
		return resultText;
	}

	public static void setResultText(String resultText) {
		Calculator.resultText = resultText;
	}

	public static void main(String[] args) {
		new Calculator();
	}

	public void mouseClicked(MouseEvent e) {
		MouseInput.mouseClicked(e.getX(), e.getY());
		dp.repaint();
	}

	public void mousePressed(MouseEvent e) {
		MouseInput.mousePressed(e.getX(), e.getY());
		dp.repaint();
	}

	public void mouseReleased(MouseEvent e) {
		MouseInput.mouseReleased();
		dp.repaint();
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		KeyInput.keyPressed(e.getKeyCode(), e.getKeyChar(), e.getModifiersEx());
		dp.repaint();
	}

	public void keyReleased(KeyEvent e) {
		KeyInput.keyReleased(e.getKeyCode());
		dp.repaint();
	}

}
