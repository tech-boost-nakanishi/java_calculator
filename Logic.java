
public class Logic {
	
	public static void LogicButton(int keyNum) {
		if(keyNum == 0) {
			//0の場合
			if(Calculator.afterCalc || Calculator.getResultText().equals("0")) {
				Calculator.setResultText(String.valueOf(keyNum));
			}
			else {
				Calculator.setResultText(Calculator.getResultText() + String.valueOf(keyNum));
			}
			Calculator.afterCalc = false;
		}
		else if((keyNum >= 1) && (keyNum <= 9)) {
			//1~9の場合
			if(Calculator.getResultText().equals("0") || Calculator.afterCalc) {
				Calculator.setResultText(String.valueOf(keyNum));
			}
			else {
				Calculator.setResultText(Calculator.getResultText() + String.valueOf(keyNum));
			}
			Calculator.afterCalc = false;
		}
		else if(keyNum == 10) {
			//小数点の場合
			if(!Calculator.getResultText().contains(".")) {
				Calculator.setResultText(Calculator.getResultText() + ".");
			}
			if(Calculator.afterCalc) {
				Calculator.setResultText("0.");
			}
			Calculator.afterCalc = false;
		}
		else if((keyNum >= 11) && (keyNum <= 14)) {
			//+,-,×,÷のいずれかの場合
			Calculator.afterCalc = true;
			Calculator.isStacked = true;
			Calculator.stackedValue = Double.parseDouble(Calculator.getResultText());
			if(keyNum == 11) {
				Calculator.currentOp = "+";
			}
			else if(keyNum == 12) {
				Calculator.currentOp = "-";
			}
			else if(keyNum == 13) {
				Calculator.currentOp = "*";
			}
			else if(keyNum == 14) {
				Calculator.currentOp = "/";
			}
		}
		else if(keyNum == 15) {
			//プラスマイナスを切り替える
			if(Calculator.getResultText().contains("-")) {
				Calculator.setResultText(Calculator.getResultText().replace("-", ""));
			}
			else {
				Calculator.setResultText("-" + Calculator.getResultText());
			}
		}
		else if(keyNum == 16) {
			//%の場合
			Calculator.afterCalc = true;
			double value = Double.valueOf(Calculator.getResultText()).doubleValue();
			value /= 100;
			Calculator.setResultText(String.valueOf(value));
		}
		else if(keyNum == 17) {
			//イコールの場合
			if(Calculator.isStacked) {
				double value = Double.valueOf(Calculator.getResultText()).doubleValue();
				if(Calculator.currentOp.equals("+")) {
					Calculator.stackedValue += value;
				}
				else if(Calculator.currentOp.equals("-")) {
					Calculator.stackedValue -= value;
				}
				else if(Calculator.currentOp.equals("*")) {
					Calculator.stackedValue *= value;
				}
				else if(Calculator.currentOp.equals("/")) {
					Calculator.stackedValue /= value;
				}
				
				Calculator.setResultText(String.valueOf(Calculator.stackedValue));
				if(Double.valueOf(Calculator.getResultText()).doubleValue() % 1 == 0) {
					String st = Calculator.getResultText().substring(0, Calculator.getResultText().length() - 2);
					Calculator.setResultText(st);
				}
				if(Calculator.getResultText().equals("0.0")) {
					Calculator.setResultText("0");
				}
			}
			
			Calculator.afterCalc = true;
		}
		else if(keyNum == 18) {
			//クリアの場合
			if(Calculator.getResultText().equals("0")) {
				Calculator.stackedValue = 0.0;
				Calculator.afterCalc = false;
				Calculator.isStacked = false;
				Calculator.setResultText("0");
			}else {
				Calculator.setResultText("0");
			}
		}
		else if(keyNum == 19) {
			//バックスペースが押された場合
			String st = Calculator.getResultText().substring(0, Calculator.getResultText().length() - 1);
			if(st.equals("") || st.equals("-")) {
				st = "0";
			}
			Calculator.setResultText(st);
		}
		
		if(Calculator.getResultText().length() > 10) {
			String st = Calculator.getResultText().substring(0, 10);
			Calculator.setResultText(st);
		}
	}
}
