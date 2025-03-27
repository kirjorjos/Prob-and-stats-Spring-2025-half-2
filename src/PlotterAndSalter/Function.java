package src.PlotterAndSalter;

public class Function {
	
	private String function;
	
	public Function(String func) {
		function = func;
	}
	
	public double run(double x) {
		String toEvaluate = function.replaceAll("(\\d)(?<!\\*)x", "$1*x");
		toEvaluate = toEvaluate.replaceAll("x", Double.toString(x));
		boolean foundAllRight = false;
		while (!foundAllRight) {
			char[] chars = toEvaluate.toCharArray();
			int lastLeftIndex = 0;
			foundAllRight = true;
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == '(') lastLeftIndex = i;
				if (chars[i] == ')') {
					String temp = toEvaluate.substring(lastLeftIndex, i+1);
					toEvaluate = toEvaluate.replaceAll("\\Q"+temp+"\\E", evaluateExponents(temp));
					foundAllRight = false;
				}
			}
		}
		return Double.parseDouble(evaluateExponents(toEvaluate));
	}

	private String evaluateExponents(String equation) {
		equation = equation.replace("(", "").replace(")", "");
		char[] chars = equation.toCharArray();
		int lastNonNumberIndex = 0;
		String left = "";
		String right = "";
		int lastExponentIndex = -1;
		boolean foundExponent = false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '^') {
				left = equation.substring(lastNonNumberIndex, i);
				foundExponent = true;
				lastExponentIndex = i;
				continue;
			}
			if (!String.valueOf(chars[i]).matches("\\d|\\.")) {
				if (foundExponent) {
					right = equation.substring(lastExponentIndex+1, i);
					left = doMultiplicationAndDivison(left);
					right = doMultiplicationAndDivison(right);
					equation = equation.replaceAll("\\Q" + left + "^" + right + "\\E", Double.toString(Math.pow(Double.parseDouble(left), Double.parseDouble(right))));
					foundExponent = false;
				}
				lastNonNumberIndex = i;
			}
		}
		if (foundExponent) {
			right = equation.substring(lastExponentIndex+1, equation.length());
			left = doMultiplicationAndDivison(left);
			right = doMultiplicationAndDivison(right);
			equation = equation.replaceAll("\\Q" + left + "^" + right + "\\E", Double.toString(Math.pow(Double.parseDouble(left), Double.parseDouble(right))));
		}
		return doMultiplicationAndDivison(equation);
	}

	private String doMultiplicationAndDivison(String equation) {
		if (equation.matches("-?\\d+(\\.\\d+)?")) return equation;
		String[] parts = equation.split("[+-]");
		for (String part : parts) {
			String operation = part.replaceAll("[^\\*/]", "");
			if (operation.equals("")) continue;
			String[] innerParts = part.split("[\\*/]");
			if (operation.equals("*")) {
				equation = equation.replaceAll("\\Q" + part + "\\E", Double.toString(Double.parseDouble(innerParts[0])*Double.parseDouble(innerParts[1])));
			} else {
				equation = equation.replaceAll("\\Q" + part + "\\E", Double.toString(Double.parseDouble(innerParts[0])/Double.parseDouble(innerParts[1])));
			}
		}
		return doAdditionAndSubtraction(equation);
	}

	private String doAdditionAndSubtraction(String equation) {
		String[] parts = equation.split("(?<!\\d)-|\\+");
		String[] operations = equation.split("(?<![\\d.])-?\\d+(\\.\\d+)?");
		for (int i = 1; i < parts.length; i++) {
			if (operations[i].equals("+")) {
				double left = Double.parseDouble(parts[i-1]);
				double right = Double.parseDouble(parts[i]);
				parts[i] = Double.toString(left+right);
			} else {
				double left = Double.parseDouble(parts[i-1]);
				double right = Double.parseDouble(parts[i]);
				parts[i] = Double.toString(left-right);
			}
		}
		return parts[parts.length-1];
	};
}
