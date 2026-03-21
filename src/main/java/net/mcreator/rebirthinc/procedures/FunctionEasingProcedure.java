package net.mcreator.rebirthinc.procedures;

import dev.kosmx.playerAnim.core.util.Easing;

public class FunctionEasingProcedure {
	public static double execute(boolean invert, double Easing, double Xi, double Xmax) {
		double X = 0;
		double Max = 0;
		double Result = 0;
		double TrueX = 0;
		TrueX = Xi;
		Max = Xmax;
		X = TrueX / Max;
		if (Easing == 0) {
			Result = 1 - Math.cos((X * Math.PI) / 2);
		} else if (Easing == 1) {
			Result = X * X * X;
		} else if (Easing == 2) {
			Result = X * X * X * X;
		} else if (Easing == 3) {
			Result = 1 - Math.sqrt(1 - Math.pow(X, 2));
		} else if (Easing == 4) {
			if (X == 0) {
				Result = 0;
			} else if (X == 1) {
				Result = 1;
			} else {
				Result = (-1) * Math.pow(2, 10 * X - 10) * Math.sin((X * 10 - 10.75) * ((2 * Math.PI) / 3));
			}
		} else if (Easing == 5) {
			Result = X * X;
		} else if (Easing == 6) {
			Result = X * X * X * X;
		} else if (Easing == 7) {
			Result = X == 0 ? 0 : Math.pow(2, 10 * X - 10);
		} else if (Easing == 8) {
			Result = (1.70158 + 1) * X * X * X - 1.70158 * X * X;
		} else if (Easing == 9) {
			Result = 1 - FunctionEasingProcedure.execute(false, 19, 1 - X, 1);
		}
		if (Easing == 10) {
			Result = Math.sin((X * Math.PI) / 2);
		} else if (Easing == 11) {
			Result = 1 - Math.pow(1 - X, 3);
		} else if (Easing == 12) {
			Result = 1 - Math.pow(1 - X, 5);
		} else if (Easing == 13) {
			Result = Math.sqrt(1 - Math.pow(1 - X, 2));
		} else if (Easing == 14) {
			if (X == 0) {
				Result = 0;
			} else if (X == 1) {
				Result = 1;
			} else {
				Result = Math.pow(2, (-10) * X) * Math.sin((X * 10 - 0.75) * ((2 * Math.PI) / 3)) + 1;
			}
		} else if (Easing == 15) {
			Result = 1 - (1 - X) * (1 - X);
		} else if (Easing == 16) {
			Result = 1 - Math.pow(1 - X, 4);
		} else if (Easing == 17) {
			Result = X == 1 ? 1 : 1 - Math.pow(2, (-10) * X);
		} else if (Easing == 18) {
			Result = 1 + (1.70158 + 1) * Math.pow(X - 1, 3) + 1.70158 * Math.pow(X - 1, 2);
		} else if (Easing == 19) {
			if (X < 1 / 2.75) {
				Result = 7.5625 * X * X;
			} else if (X < 2 / 2.75) {
				X = X - 1.5 / 2.75;
				Result = 7.5625 * X * X + 0.75;
			} else if (X < 2.5 / 2.75) {
				X = X - 2.25 / 2.75;
				Result = 7.5625 * X * X + 0.9375;
			} else {
				X = X - 2.625 / 2.75;
				Result = 7.5625 * X * X + 0.984375;
			}
		}
		if (invert) {
			return 1 - Result;
		}
		return Result;
	}
}
