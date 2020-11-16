import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Calculator extends JPanel implements MouseListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	public final int WIDTH = 232, HEIGHT = 310;
	
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
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.getContentPane().add(this);
		
		this.addMouseListener(this);
		frame.addKeyListener(this);
		
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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		Color NormalNum = Color.LIGHT_GRAY;
		Color PressedNum = Color.GRAY;
		Color NormalCalc = new Color(255, 165, 0);
		Color PressedCalc = Color.LIGHT_GRAY;
		
		//数字表示フィールド
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 0, WIDTH, 58);
		
		//resultText表示
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
		g2d.drawString(resultText, WIDTH - g2d.getFontMetrics().stringWidth(resultText) - 8, 42);
		
		//各ボタンの境界線
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 58, WIDTH, HEIGHT - 58);
		
		//クリアボタン
		if(getPressedNum() == 18) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(clear);
		String clearText = "";
		if(resultText == "0") { clearText = "AC"; }
		else { clearText = "C"; }
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString(clearText, (int)57/2 - g2d.getFontMetrics().stringWidth(clearText)/2, 88);
		
		//正負切替ボタン
		if(getPressedNum() == 15) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(plusminus);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("+", 75, 83);
		g2d.drawString("／", 80, 90);
		g2d.drawString("-", 88, 93);
		
		//パーセントボタン
		if(getPressedNum() == 16) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(percent);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("%", 138, 88);
		
		//割るボタン
		if(getPressedNum() == 14) { g2d.setColor(PressedCalc); }
		else { g2d.setColor(NormalCalc); }
		g2d.fill(divide);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
		g2d.drawString("÷", 193, 90);
		
		//7ボタン
		if(getPressedNum() == 7) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(seven);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("7", 22, 138);
		
		//8ボタン
		if(getPressedNum() == 8) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(eight);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("8", 82, 138);
		
		//9ボタン
		if(getPressedNum() == 9) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(nine);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("9", 139, 138);
		
		//掛けるボタン
		if(getPressedNum() == 13) { g2d.setColor(PressedCalc); }
		else { g2d.setColor(NormalCalc); }
		g2d.fill(multiply);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		g2d.drawString("×", 193, 138);
		
		//4ボタン
		if(getPressedNum() == 4) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(four);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("4", 22, 187);
		
		//5ボタン
		if(getPressedNum() == 5) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(five);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("5", 82, 187);
		
		//6ボタン
		if(getPressedNum() == 6) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(six);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("6", 139, 187);
		
		//引くボタン
		if(getPressedNum() == 12) { g2d.setColor(PressedCalc); }
		else { g2d.setColor(NormalCalc); }
		g2d.fill(subtract);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
		g2d.drawString("-", 194, 190);
		
		//1ボタン
		if(getPressedNum() == 1) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(one);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("1", 22, 236);
		
		//2ボタン
		if(getPressedNum() == 2) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(two);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("2", 82, 236);
		
		//3ボタン
		if(getPressedNum() == 3) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(three);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("3", 139, 236);
		
		//足すボタン
		if(getPressedNum() == 11) { g2d.setColor(PressedCalc); }
		else { g2d.setColor(NormalCalc); }
		g2d.fill(add);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		g2d.drawString("+", 194, 237);
		
		//0ボタン
		if(getPressedNum() == 0) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(zero);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("0", 52, 286);
		
		//小数点ボタン
		if(getPressedNum() == 10) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(period);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString(".", 143, 286);
		
		//イコールボタン
		if(getPressedNum() == 17) { g2d.setColor(PressedCalc); }
		else { g2d.setColor(NormalCalc); }
		g2d.fill(equal);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		g2d.drawString("=", 194, 286);
	}

	public static void main(String[] args) {
		new Calculator();
	}

	public void mouseClicked(MouseEvent e) {
		MouseInput.mouseClicked(e.getX(), e.getY());
		repaint();
	}

	public void mousePressed(MouseEvent e) {
		MouseInput.mousePressed(e.getX(), e.getY());
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		MouseInput.mouseReleased();
		repaint();
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		KeyInput.keyPressed(e.getKeyCode(), e.getKeyChar(), e.getModifiersEx());
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		KeyInput.keyReleased(e.getKeyCode());
		repaint();
	}

}
