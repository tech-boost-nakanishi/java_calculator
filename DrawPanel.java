import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public DrawPanel() {
		this.setFocusable(true);
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
		g2d.fillRect(0, 0, Calculator.WIDTH, 58);
		
		//resultText表示
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
		g2d.drawString(Calculator.resultText, Calculator.WIDTH - g2d.getFontMetrics().stringWidth(Calculator.resultText) - 8, 42);
		
		//各ボタンの境界線
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 58, Calculator.WIDTH, Calculator.HEIGHT - 58);
		
		//クリアボタン
		if(Calculator.getPressedNum() == 18) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.clear);
		String clearText = "";
		if(Calculator.resultText == "0") { clearText = "AC"; }
		else { clearText = "C"; }
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString(clearText, (int)57/2 - g2d.getFontMetrics().stringWidth(clearText)/2, 88);
		
		//正負切替ボタン
		if(Calculator.getPressedNum() == 15) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.plusminus);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("+", 75, 83);
		g2d.drawString("／", 80, 90);
		g2d.drawString("-", 88, 93);
		
		//パーセントボタン
		if(Calculator.getPressedNum() == 16) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.percent);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("%", 138, 88);
		
		//割るボタン
		if(Calculator.getPressedNum() == 14) { g2d.setColor(PressedCalc); }
		else { g2d.setColor(NormalCalc); }
		g2d.fill(Calculator.divide);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
		g2d.drawString("÷", 193, 90);
		
		//7ボタン
		if(Calculator.getPressedNum() == 7) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.seven);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("7", 22, 138);
		
		//8ボタン
		if(Calculator.getPressedNum() == 8) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.eight);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("8", 82, 138);
		
		//9ボタン
		if(Calculator.getPressedNum() == 9) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.nine);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("9", 139, 138);
		
		//掛けるボタン
		if(Calculator.getPressedNum() == 13) { g2d.setColor(PressedCalc); }
		else { g2d.setColor(NormalCalc); }
		g2d.fill(Calculator.multiply);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		g2d.drawString("×", 193, 138);
		
		//4ボタン
		if(Calculator.getPressedNum() == 4) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.four);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("4", 22, 187);
		
		//5ボタン
		if(Calculator.getPressedNum() == 5) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.five);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("5", 82, 187);
		
		//6ボタン
		if(Calculator.getPressedNum() == 6) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.six);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("6", 139, 187);
		
		//引くボタン
		if(Calculator.getPressedNum() == 12) { g2d.setColor(PressedCalc); }
		else { g2d.setColor(NormalCalc); }
		g2d.fill(Calculator.subtract);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
		g2d.drawString("-", 194, 190);
		
		//1ボタン
		if(Calculator.getPressedNum() == 1) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.one);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("1", 22, 236);
		
		//2ボタン
		if(Calculator.getPressedNum() == 2) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.two);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("2", 82, 236);
		
		//3ボタン
		if(Calculator.getPressedNum() == 3) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.three);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("3", 139, 236);
		
		//足すボタン
		if(Calculator.getPressedNum() == 11) { g2d.setColor(PressedCalc); }
		else { g2d.setColor(NormalCalc); }
		g2d.fill(Calculator.add);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		g2d.drawString("+", 194, 237);
		
		//0ボタン
		if(Calculator.getPressedNum() == 0) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.zero);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString("0", 52, 286);
		
		//小数点ボタン
		if(Calculator.getPressedNum() == 10) { g2d.setColor(PressedNum); }
		else { g2d.setColor(NormalNum); }
		g2d.fill(Calculator.period);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g2d.drawString(".", 143, 286);
		
		//イコールボタン
		if(Calculator.getPressedNum() == 17) { g2d.setColor(PressedCalc); }
		else { g2d.setColor(NormalCalc); }
		g2d.fill(Calculator.equal);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		g2d.drawString("=", 194, 286);
	}

}
