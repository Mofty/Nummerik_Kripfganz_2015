

public class Newton {

	public static Complex approximateRoot(ComplexFunction f, ComplexFunction fDeriv, ComplexFunction fDeriv2,
			Complex startApprox,
			double precision, boolean checkConvergence) throws Exception {
		Complex previousApprox = startApprox;
		for (int i = 0;; i++) {
			if (checkConvergence) {
				Complex fd = fDeriv.apply(previousApprox);
				Complex phiDeriv = Complex.div(
						Complex.mult(f.apply(previousApprox),
								fDeriv2.apply(previousApprox)), Complex.mult(fd, fd));
				if (Complex.abs(phiDeriv) >= 1)
					throw new Exception("No convergence at " + previousApprox +
							" with Φ′ = " + phiDeriv + ".");
			}
			//System.out.println(previousApprox);
			Complex approx =
					Complex.subtr(
							previousApprox,
							Complex.div(f.apply(previousApprox),
									fDeriv.apply(previousApprox)));
			if (Runden.getPrecision(Complex.abs(approx),
					Complex.abs(Complex.subtr(approx, previousApprox)))
			>= precision) {
				return approx;
			} else {
				previousApprox = approx;
			}
		}
	}
}
